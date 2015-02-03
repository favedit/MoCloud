package org.mo.com.lang;

//============================================================
// <T>集合工具类。</T>
//
// @class
// @author MAOCY
// @history 150203 Create
//============================================================
public class RSet
{
   //============================================================
   // <T>设置字符串集合内容。</T>
   //
   // @param value 内容
   // @param code 代码
   // @param flag 标志
   //============================================================
   public static String stringSet(Object value,
                                  Object code,
                                  boolean flag){
      // 格式化参数
      String valueString = RString.nvl(value);
      String codeString = RString.nvl(code);
      // 设置内容
      String result = valueString;
      if(flag){
         // 集合加入
         if(!valueString.contains(codeString)){
            result += codeString;
         }
      }else{
         // 集合移除
         if(valueString.contains(codeString)){
            result = RString.removeString(valueString, codeString);
         }
      }
      return result;
   }
}
