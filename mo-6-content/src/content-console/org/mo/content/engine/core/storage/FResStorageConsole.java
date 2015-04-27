package org.mo.content.engine.core.storage;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.data.ISqlDatasetReader;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.FDataExport;
import org.mo.eng.data.FDataImport;

//============================================================
// <T>资源存储控制台。</T>
//============================================================
public class FResStorageConsole
      extends FConsole
      implements
         IResStorageConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FResStorageConsole.class);

   // 配置文件路径
   @AProperty
   protected String _configFileName;

   // 文件编码
   protected String _charset = "utf-8";

   // 数据库配置
   protected FXmlNode _xdatabaseMysql;

   // 存储配置
   protected FXmlNode _xdatabaseMongo;

   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>清空数据。</T>
   //
   // @param logicContext 逻辑环境
   // @return 处理结果
   //============================================================
   @Override
   public EResult clearData(ILogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection();
      int count = _xdatabaseMysql.nodeCount();
      for(int n = count - 1; n >= 0; n--){
         FXmlNode xdataset = _xdatabaseMysql.node(n);
         String dataName = xdataset.get("data_name");
         String sql = "DELETE FROM " + dataName;
         connection.executeSql(sql);
         _logger.debug(this, "clearData", "Clear dataset. (data_name={1})", dataName);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导出数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult exportData(ILogicContext logicContext,
                             String path){
      ISqlConnection connection = logicContext.activeConnection();
      FDataExport exportor = new FDataExport(connection, _charset);
      for(FXmlNode xdataset : _xdatabaseMysql.nodes()){
         String dataName = xdataset.get("data_name");
         String fileName = RFile.format(path + "/" + dataName + ".pck");
         exportor.makeTableSql(dataName, fileName);
         _logger.debug(this, "exportData", "Export dataset. (data_name={1}, file_name={2})", dataName, fileName);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导出存储。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult exportStorage(ILogicContext logicContext,
                                String path){
      ISqlConnection connection = logicContext.activeConnection();
      for(FXmlNode xcollection : _xdatabaseMongo.nodes()){
         String name = xcollection.get("name");
         String storagePath = path + "/" + name;
         String dataName = xcollection.get("data_name");
         String formatName = xcollection.get("format_name", "bin");
         String sql = "SELECT GUID FROM " + dataName;
         ISqlDatasetReader reader = connection.fetchReader(sql);
         for(FRow row : reader){
            String guid = row.get("guid");
            _storageConsole.exportFile(name, guid, formatName, storagePath);
         }
         reader.close();
         _logger.debug(this, "exportData", "Export dataset. (name={1}, data_name={2}, path={3})", name, dataName, storagePath);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult importData(ILogicContext logicContext,
                             String path){
      ISqlConnection connection = logicContext.activeConnection();
      FDataImport importor = new FDataImport(connection, _charset);
      for(FXmlNode xdataset : _xdatabaseMysql.nodes()){
         String dataName = xdataset.get("data_name");
         String fileName = RFile.format(path + "/" + dataName + ".pck");
         importor.executeTable(fileName);
         _logger.debug(this, "importData", "Import dataset. (data_name={1}, file_name={2})", dataName, fileName);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入存储。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   @Override
   public EResult importStorage(ILogicContext logicContext,
                                String path){
      ISqlConnection connection = logicContext.activeConnection();
      for(FXmlNode xcollection : _xdatabaseMongo.nodes()){
         String name = xcollection.get("name");
         String storagePath = path + "/" + name;
         String dataName = xcollection.get("data_name");
         String formatName = xcollection.get("format_name", "bin");
         //String fieldTypeLower = null;
         String sql = "SELECT GUID FROM " + dataName;
         //if(!RString.isEmpty(fieldType)){
         //   sql = "SELECT GUID," + fieldType + " FROM " + dataName;
         //   fieldTypeLower = fieldType.toLowerCase();
         //}
         ISqlDatasetReader reader = connection.fetchReader(sql);
         for(FRow row : reader){
            String guid = row.get("guid");
            //String type = "bin";
            //if(!RString.isEmpty(fieldType)){
            //   type = row.get(fieldTypeLower);
            //}
            String fileName = storagePath + "/" + guid + "." + formatName;
            _storageConsole.importFile(name, guid, formatName, fileName);
         }
         reader.close();
         _logger.debug(this, "exportData", "Export dataset. (name={1}, data_name={2}, path={3})", name, dataName, storagePath);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      FXmlDocument xdocument = new FXmlDocument(_configFileName);
      for(FXmlNode xnode : xdocument.root().nodes()){
         if(xnode.isName("Database")){
            String type = xnode.get("type");
            switch(type){
               case "mysql":
                  _xdatabaseMysql = xnode;
                  break;
               case "mongodb":
                  _xdatabaseMongo = xnode;
                  break;
            }
         }
      }
   }
}
