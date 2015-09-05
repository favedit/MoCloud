package org.mo.content.service.logic.frame;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.dataset.IDatasetConsole;
import org.mo.cloud.content.design.frame.IFrameConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>页面服务。</T>
//============================================================
public class FFrameService
      extends FObject
      implements
         IFrameService
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FFrameService.class);

   // 页面控制台
   @ALink
   protected IFrameConsole _frameConsole;

   // 数据集控制台
   @ALink
   protected IDatasetConsole _datasetConsole;

   protected String _storgeName = "cloud";

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FFrameService(){
   }

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FSql makeSelectSql(FContentObject frameContent,
                             FXmlNode xsearch,
                             FFieldExpressions expressions){
      String frameName = frameContent.get("name");
      // 更新数据集
      String datasetName = frameContent.get("dataset_name");
      String datasetWhere = frameContent.get("dataset_where", null);
      String datasetOrder = frameContent.get("dataset_order", null);
      FContentObject datasetContent = _datasetConsole.findDefine(_storgeName, datasetName, EPersistenceMode.Store);
      if(datasetContent == null){
         throw new FFatalError("Frame dataset is not exists. (frame_name={1}, dataset_name={2})", frameName, datasetName);
      }
      String datasetDataName = datasetContent.get("data_name");
      //..........................................................
      // 生成SQL
      FSql sql = new FSql();
      sql.append("SELECT ");
      boolean fieldFirst = true;
      for(FContentObject controlContent : frameContent.nodes()){
         String dataName = controlContent.get("data_name", null);
         if(!RString.isEmpty(dataName)){
            // 表达式字段
            String dataExpression = controlContent.get("data_expression", null);
            if(!RString.isEmpty(dataExpression)){
               continue;
            }
            // 查询字段
            if(!fieldFirst){
               sql.append(",");
            }
            sql.append("`", datasetDataName, "`.`", dataName, "`");
            fieldFirst = false;
         }
      }
      sql.append(" FROM ");
      sql.append(datasetDataName);
      //..........................................................
      // 增加交叉查询条件
      if(xsearch != null){
         for(FXmlNode xcolumn : xsearch){
            if(xcolumn.isName("Column")){
               String name = xcolumn.get("name");
               // 查找字段
               FContentObject fieldContent = frameContent.findObject("name", name);
               String dataValue = xcolumn.get("value");
               // 表达式字段
               String dataExpression = fieldContent.get("data_expression", null);
               if(!RString.isEmpty(dataExpression)){
                  FFieldExpression expression = expressions.get(name);
                  FSql joinSql = new FSql(" INNER JOIN {table} on {base}.{filter_name} = {table}.OUID AND {table}.{field_name} like '%{value}%'");
                  joinSql.bind("base", datasetDataName);
                  joinSql.bind("table", expression.datasetDataName());
                  joinSql.bind("filter_name", expression.filterName());
                  joinSql.bind("field_name", expression.fieldName());
                  joinSql.bind("value", dataValue);
                  sql.append(joinSql);
               }
            }
         }
      }
      //..........................................................
      // 增加查询条件
      FSql searchSql = new FSql();
      if(!RString.isEmpty(datasetWhere)){
         searchSql.append(datasetWhere);
      }
      if(xsearch != null){
         for(FXmlNode xcolumn : xsearch){
            if(xcolumn.isName("Column")){
               String name = xcolumn.get("name");
               // 查找字段
               FContentObject fieldContent = frameContent.findObject("name", name);
               String dataName = fieldContent.get("data_name");
               String dataValue = xcolumn.get("value");
               // 表达式字段
               String dataExpression = fieldContent.get("data_expression", null);
               if(!RString.isEmpty(dataExpression)){
                  continue;
               }
               if(!searchSql.isEmpty()){
                  searchSql.append(" AND ");
               }
               searchSql.append("(`", datasetDataName, "`.`", dataName, "`");
               searchSql.append(" LIKE '%", dataValue, "%')");
            }
         }
      }
      if(!searchSql.isEmpty()){
         sql.append(" WHERE ");
         sql.append(searchSql);
      }
      //..........................................................
      // 增加排序条件
      if(!RString.isEmpty(datasetOrder)){
         sql.append(" ORDER BY ");
         sql.append(datasetOrder);
      }
      return sql;
   }

   //============================================================
   // <T>查找所有表达式集合。</T>
   //============================================================
   public FFieldExpressions findExpressions(FContentObject frameContent){
      FFieldExpressions expressions = new FFieldExpressions();
      // 查找字段
      for(FContentObject controlContent : frameContent.nodes()){
         String name = controlContent.get("name");
         String dataName = controlContent.get("data_name", null);
         if(!RString.isEmpty(dataName)){
            // 表达式字段
            String dataExpression = controlContent.get("data_expression", null);
            if(!RString.isEmpty(dataExpression)){
               FFieldExpression expression = new FFieldExpression(controlContent);
               String datasetName = expression.datasetName();
               FContentObject datasetContent = _datasetConsole.findDefine(_storgeName, datasetName, EPersistenceMode.Store);
               if(datasetContent == null){
                  throw new FFatalError("Frame dataset is not exists. (dataset_name={1})", datasetName);
               }
               String datasetDataName = datasetContent.get("data_name");
               expression.setDatasetDataName(datasetDataName);
               expressions.set(name, expression);
            }
         }
      }
      return expressions;
   }

   //============================================================
   // <T>存储数据集合。</T>
   //
   // @param dataset 数据集
   // @param xdataset 数据集节点
   //============================================================
   public void saveDataset(ILogicContext logicContext,
                           FDataset dataset,
                           FXmlNode xdataset,
                           FFieldExpressions expressions){
      xdataset.set("total", dataset.total());
      xdataset.set("page_size", dataset.pageSize());
      xdataset.set("page_count", dataset.pageCount());
      xdataset.set("page", dataset.page());
      for(FRow row : dataset){
         // 获得数值
         FXmlNode xrow = xdataset.createNode("Row");
         for(IStringPair pair : row){
            xrow.set(pair.name(), pair.value());
         }
         // 表达式计算
         if(expressions != null){
            for(INamePair<FFieldExpression> pair : expressions){
               pair.value().execute(logicContext, xrow, row);
            }
         }
      }
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      FXmlNode xcontent = input.config().findNode("Content");
      int page = xcontent.getInt("page", 0);
      int pageSize = xcontent.getInt("page_size", 20);
      String frameName = xcontent.get("frame_name");
      FXmlNode xsearch = xcontent.findNode("Search");
      // 获得页面
      FContentObject frameContent = _frameConsole.findDefine(_storgeName, frameName, EPersistenceMode.Store);
      if(frameContent == null){
         throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
      }
      _logger.debug(this, "save", "Save frame dataset. (frame={1})", frameName);
      // 更新数据集
      String datasetName = frameContent.get("dataset_name");
      FContentObject datasetContent = _datasetConsole.findDefine(_storgeName, datasetName, EPersistenceMode.Store);
      if(datasetContent == null){
         throw new FFatalError("Frame dataset is not exists. (frame_name={1}, dataset_name={2})", frameName, datasetName);
      }
      String dataGroup = datasetContent.get("data_group");
      // 生成SQL
      FFieldExpressions expressions = findExpressions(frameContent);
      FSql sql = makeSelectSql(frameContent, xsearch, expressions);
      // 查询数据
      ISqlConnection connection = logicContext.activeConnection(dataGroup);
      FDataset dataset = connection.fetchDataset(sql, pageSize, page);
      FXmlNode xoutput = output.config().createNode("Content");
      // 输出内容
      FXmlNode xdataset = xoutput.createNode("Dataset");
      xdataset.set("name", datasetName);
      saveDataset(logicContext, dataset, xdataset, expressions);
      return EResult.Success;
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult detail(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      FXmlNode xcontent = input.config().findNode("Content");
      String frameName = xcontent.get("frame_name");
      FXmlNode xsearch = xcontent.nodes().first();
      long ouid = xsearch.getLong("ouid");
      // 获得页面
      FContentObject frameContent = _frameConsole.findDefine(_storgeName, frameName, EPersistenceMode.Store);
      if(frameContent == null){
         throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
      }
      _logger.debug(this, "save", "Save frame dataset. (frame={1})", frameName);
      // 更新数据集
      String datasetName = frameContent.get("dataset_name");
      FContentObject datasetContent = _datasetConsole.findDefine(_storgeName, datasetName, EPersistenceMode.Store);
      if(datasetContent == null){
         throw new FFatalError("Frame dataset is not exists. (frame_name={1}, dataset_name={2})", frameName, datasetName);
      }
      String datasetDataName = datasetContent.get("data_name");
      // 生成SQL
      FSql sql = new FSql();
      sql.append("SELECT ");
      boolean fieldFirst = true;
      for(FContentObject controlContent : frameContent.nodes()){
         String dataName = controlContent.get("data_name", null);
         if(!RString.isEmpty(dataName)){
            if(!fieldFirst){
               sql.append(",");
            }
            sql.append("`", dataName, "`");
            fieldFirst = false;
         }
      }
      sql.append(" FROM ");
      sql.append(datasetDataName);
      sql.append(" WHERE OUID={ouid}");
      sql.bindLong("ouid", ouid);
      // 查询数据
      ISqlConnection connection = logicContext.activeConnection("data");
      FDataset dataset = connection.fetchDataset(sql);
      FXmlNode xoutput = output.config().createNode("Content");
      // 输出内容
      FXmlNode xdataset = xoutput.createNode("Dataset");
      xdataset.set("name", datasetName);
      saveDataset(logicContext, dataset, xdataset, null);
      return EResult.Success;
   }

   //============================================================
   // <T>登录数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public void saveRow(ILogicContext logicContext,
                       FContentObject frameContent,
                       FContentObject datasetContent,
                       FXmlNode xrow){
      // 获得逻辑控制器
      String name = datasetContent.get("name");
      String className = "org.mo.cloud.logic." + name + ".IGc" + RString.firstUpper(RString.right(name, ".")) + "Console";
      IAbstractLogicUnitConsole<FLogicUnit> console = RAop.find(className);
      // 获得状态
      String statusCd = xrow.get("_status_cd");
      if("I".equals(statusCd)){
         // 新建处理
         FLogicUnit unit = console.doPrepare(logicContext);
         unit.loadAttributes(xrow.attributes());
         console.doInsert(logicContext, unit);
      }else if("U".equals(statusCd)){
         // 更新处理
         long ouid = xrow.getLong("ouid");
         FLogicUnit unit = console.find(logicContext, ouid);
         unit.loadAttributes(xrow.attributes());
         console.doUpdate(logicContext, unit);
      }else if("D".equals(statusCd)){
         // 删除处理
         long ouid = xrow.getLong("ouid");
         FLogicUnit unit = console.find(logicContext, ouid);
         unit.loadAttributes(xrow.attributes());
         console.doDelete(logicContext, unit);
      }else{
         throw new FFatalError("Invalid data status. (status_cd={1})", statusCd);
      }
   }

   //============================================================
   // <T>保存数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult save(IWebContext context,
                       ILogicContext logicContext,
                       IWebInput input,
                       IWebOutput output){
      FXmlNode xcontent = input.config().findNode("Content");
      String frameName = xcontent.get("frame_name");
      // 获得定义
      FContentObject frameContent = _frameConsole.findDefine(_storgeName, frameName, EPersistenceMode.Store);
      if(frameContent == null){
         throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
      }
      _logger.debug(this, "save", "Save frame dataset. (frame={1})", frameName);
      // 更新数据集
      for(FXmlNode xdataset : xcontent.nodes()){
         if(xdataset.isName("Dataset")){
            String datasetName = xdataset.get("name");
            FContentObject datasetContent = _datasetConsole.findDefine(_storgeName, datasetName, EPersistenceMode.Store);
            if(datasetContent == null){
               throw new FFatalError("Frame dataset is not exists. (frame_name={1}, dataset_name={2})", frameName, datasetName);
            }
            for(FXmlNode xrow : xdataset.nodes()){
               if(xrow.isName("Row")){
                  saveRow(logicContext, frameContent, datasetContent, xrow);
               }
            }
         }
      }
      return EResult.Success;
   }
}
