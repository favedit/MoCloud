package org.mo.data.logic;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.IStringPair;

//============================================================
// <T>逻辑数据单元。</T>
//============================================================
public class FLogicUnit
      extends FObject
{
   // 逻辑环境
   protected ILogicContext _logicContext;

   //============================================================
   // <T>获得逻辑环境。</T>
   //
   // @return 逻辑环境
   //============================================================
   public ILogicContext logicContext(){
      return _logicContext;
   }

   //============================================================
   // <T>设置逻辑环境。</T>
   //
   // @param logicContext 逻辑环境
   //============================================================
   public void linkLogicContext(ILogicContext logicContext){
      _logicContext = logicContext;
   }

   //============================================================
   // <T>根据名称获得内容。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   public String get(String name){
      return null;
   }

   //============================================================
   // <T>根据名称设置内容。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   public void set(String name,
                   String value){
   }

   //============================================================
   // <T>加载属性集合。</T>
   //
   // @param attributes 存储属性集合
   //============================================================
   public void loadAttributes(IAttributes attributes){
      for(IStringPair pair : attributes){
         String attributeName = pair.name();
         String attributeValue = pair.value();
         set(attributeName, attributeValue);
      }
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   public void load(FRow row){
   }

   //============================================================
   // <T>存储行记录。</T>
   //
   // @param row 行记录
   //============================================================
   public void save(FRow row){
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   public void saveMap(Map<String, String> map){
   }

   //============================================================
   // <T>反序列化数据到内容。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
   }

   //============================================================
   // <T>序列化内容到数据。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
   }

   //============================================================
   // <T>复制当前对象。</T>
   //
   // @param unit 对象
   //============================================================
   public void copy(FLogicUnit unit){
   }
}
