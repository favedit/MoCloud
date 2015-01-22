package org.mo.com.collections;

import org.mo.com.lang.RString;
import org.mo.com.lang.generic.MAttributes;

//============================================================
// <T>参数表。</T>
//============================================================
@SuppressWarnings("unchecked")
public class FParameters
      extends MAttributes
{
   //============================================================
   // <T>构造参数表。</T>
   //============================================================
   public FParameters(){
   }

   //============================================================
   // <T>构造参数表。</T>
   //
   // @param capacity 容量
   //============================================================
   public FParameters(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造参数表。</T>
   //
   // @param pack 打包字符串
   //============================================================
   public FParameters(String pack){
      unpack(pack);
   }

   //============================================================
   // <T>解析参数表。</T>
   //
   // @param parameters 参数集合
   //============================================================
   public void parse(String parameters){
      for(String parameter : RString.split(parameters, ',')){
         String[] items = RString.split(parameter, '=');
         if(items.length == 2){
            String name = items[0].trim();
            String value = items[1].trim();
            if(value.startsWith("\"") && value.endsWith("\"")){
               value = value.substring(1, value.length() - 1);
            }
            set(name, value);
         }
      }
   }
}
