package org.mo.eng.template.tag;

import org.mo.com.lang.RString;
import org.mo.com.lang.generic.MString;

//============================================================
// <T>根据数据源中指针位置，输出指定的内容。</T>
//============================================================
public class FTplPositionTag
      extends FAbstractTplTag
{
   public static String NAME = "Position";

   // 数据源
   protected String _source;

   // 要测试的类型
   protected String _type;

   // 满足条件时要输出数据内容
   protected String _value;

   // 不满足条件时要输出数据内容
   protected String _elsevalue;

   //============================================================
   // <T>标签开始处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public int onStart(){
      // 获得总数
      int count = 0;
      Object sourceCount = _context.parse(_source + FTplLoopTag.REF_COUNT);
      if(sourceCount != null){
         count = (Integer)sourceCount;
      }
      // 获得位置
      int position = 0;
      Object sourcePosition = _context.parse(_source + FTplLoopTag.REF_POSITION);
      if(sourceCount != null){
         position = (Integer)sourcePosition;
      }
      // 生成内容
      if(!RString.isEmpty(_type)){
         if(_type.equalsIgnoreCase("first")){
            if(position == 0){
               _context.append(_value);
            }else{
               _context.append(_elsevalue);
            }
         }else if(_type.equalsIgnoreCase("middle")){
            if(position > 0 && position < count){
               _context.append(_value);
            }else{
               _context.append(_elsevalue);
            }
         }else if(_type.equalsIgnoreCase("last")){
            if(position == count - 1){
               _context.append(_value);
            }else{
               _context.append(_elsevalue);
            }
         }
      }
      return STOP;
   }

   //============================================================
   // <T>设置要测试的数据源，必须是数据循环对象的子节点。</T>
   //
   // @param source 满足条件时要输出数据内容
   //============================================================
   public void setSource(String source){
      _source = source;
   }

   //============================================================
   // <T>设置测试类型。</T>
   //
   // @param type 类型(first,middle,last)
   //============================================================
   public void setType(String type){
      _type = type;
   }

   //============================================================
   // <T>设置满足条件时要输出的内容。</T>
   //
   // @param value 满足条件时要输出数据内容
   //============================================================
   public void setValue(String value){
      _value = value;
   }

   //============================================================
   // <T>设置不满足条件时要输出的内容。</T>
   //
   // @param elseValue 不满足条件时要输出数据内容
   //============================================================
   public void setElseValue(String elseValue){
      _elsevalue = elseValue;
   }

   //============================================================
   // <T>输出运行信息。</T>
   //
   // @param 运行信息
   //============================================================
   @Override
   public void onDump(MString dump){
      dump.append(NAME, " [");
      dump.append(" source=", _source);
      dump.append(" ]");
   }

}
