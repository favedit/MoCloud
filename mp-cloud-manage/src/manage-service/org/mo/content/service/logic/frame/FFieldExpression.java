package org.mo.content.service.logic.frame;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.collections.FRow;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>字段表达式。</T>
//============================================================
public class FFieldExpression
      extends FObject
{
   // 数据名称
   protected String _dataName;

   // 数据表达式
   protected String _dataExpression;

   // 数据集合名称
   protected String _datasetName;

   // 过滤名称
   protected String _filterName;

   // 字段名称
   protected String _fieldName;

   // 数据接口
   protected IAbstractLogicUnitConsole<FLogicUnit> _console;

   //============================================================
   // <T>构造字段表达式。</T>
   //============================================================
   public FFieldExpression(){
   }

   //============================================================
   // <T>构造字段表达式。</T>
   //
   // @param content 内容
   //============================================================
   public FFieldExpression(FContentObject content){
      parse(content);
   }

   //============================================================
   // <T>获得数据集合名称。</T>
   //
   // @return 数据集合名称
   //============================================================
   public String datasetName(){
      return _datasetName;
   }

   //============================================================
   // <T>设置数据集合名称。</T>
   //
   // @param datasetName 数据集合名称
   //============================================================
   public void setDatasetName(String datasetName){
      _datasetName = datasetName;
   }

   //============================================================
   // <T>获得过滤名称。</T>
   //
   // @return 过滤名称
   //============================================================
   public String filterName(){
      return _filterName;
   }

   //============================================================
   // <T>设置过滤名称。</T>
   //
   // @param filterName 过滤名称
   //============================================================
   public void setFilterName(String filterName){
      _filterName = filterName;
   }

   //============================================================
   // <T>获得字段名称。</T>
   //
   // @return 字段名称
   //============================================================
   public String fieldName(){
      return _fieldName;
   }

   //============================================================
   // <T>设置字段名称。</T>
   //
   // @param fieldName 字段名称
   //============================================================
   public void setFieldName(String fieldName){
      _fieldName = fieldName;
   }

   //============================================================
   // <T>设置字段名称。</T>
   //
   // @param fieldName 字段名称
   //============================================================
   public void parse(FContentObject content){
      _dataName = content.get("data_name");
      _dataExpression = content.get("data_expression");
      // 获得内容
      _datasetName = RString.mid(_dataExpression, "{", "}");
      _filterName = RString.mid(_dataExpression, "find(", ")");
      _fieldName = RString.right(_dataExpression, ").");
      // 获得接口
      String className = "org.mo.cloud.logic." + _datasetName + ".IGc" + RString.firstUpper(RString.right(_datasetName, ".")) + "Console";
      _console = RAop.find(className);
   }

   //============================================================
   // <T>设置字段名称。</T>
   //
   // @param fieldName 字段名称
   //============================================================
   public void execute(ILogicContext logicContext,
                       FXmlNode xrow,
                       FRow row){
      long filterId = row.getLong(_filterName);
      FLogicUnit unit = _console.find(logicContext, filterId);
      if(unit != null){
         String value = unit.get(_fieldName);
         if(value != null){
            xrow.set(_dataName, value);
         }
      }
   }
}
