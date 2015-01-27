package org.mo.cloud.core.database;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FFileInfo;
import org.mo.com.io.FFileInfos;
import org.mo.com.io.RDirectory;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.eng.data.FDataExport;
import org.mo.eng.data.IConnectionConsole;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;
import org.mo.mime.zip.RZip;

//============================================================
// <T>数据控制台。</T>
//============================================================
public class FGcDatabaseConsole
      extends FConsole
      implements
         IGcDatabaseConsole
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FGcDatabaseConsole.class);

   // 数据路径
   @AProperty
   protected String _dataPath;

   // 数据控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   //============================================================
   // <T>导出数据库数据。</T>
   //
   // @param sqlContext 数据环境
   // @return 处理结果
   //============================================================
   @Override
   public EResult export(ISqlContext sqlContext){
      String date = RDateTime.format();
      String outputPath = RFile.makePathname(_dataPath, date);
      // 导出所有数据
      String dataPath = RFile.makePathname(outputPath, "source");
      IConnectionConsole[] connectionConsoles = _databaseConsole.connectionConsoles();
      for(IConnectionConsole connectionConsole : connectionConsoles){
         String connectionName = connectionConsole.name();
         // 生成路径
         String connectionPath = RFile.makePathname(dataPath, connectionName);
         RDirectory.makeDirectory(connectionPath);
         // 导出文件
         ISqlConnection connection = sqlContext.activeConnection(connectionName);
         FDataExport exporter = new FDataExport(connection);
         exporter.makeDatabaseSql(connectionPath);
      }
      // 打包存储
      String fileName = RFile.makeFilename(outputPath, "data_" + date + ".zip");
      RZip.compress(fileName, dataPath);
      return EResult.Success;
   }

   //============================================================
   // <T>获得数据库描述。</T>
   //
   // @param sqlContext 数据环境
   // @return 处理结果
   //============================================================
   @Override
   public FDataset fetch(){
      FDataset dataset = new FDataset();
      FFileInfos fileInfos = RDirectory.listFiles(_dataPath, false);
      for(FFileInfo fileInfo : fileInfos){
         String fileName = fileInfo.fileName();
         String date = fileName.substring(_dataPath.length() + 1);
         FRow row = new FRow();
         row.set("datetime", date);
         row.set("name", "data_" + date);
         row.set("download_url", "/data/" + date + "/data_" + date + ".zip");
         dataset.push(row);
      }
      System.out.println(dataset.dump());
      return dataset;
   }
}
