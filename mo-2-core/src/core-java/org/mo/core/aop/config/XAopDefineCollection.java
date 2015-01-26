package org.mo.core.aop.config;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;

//============================================================
// <T>AOP定义集合。</T>
//============================================================
public class XAopDefineCollection
      extends XAopNodeCollection<XAopDefine>
{
   // 属性集合
   protected FAttributes _attributes = new FAttributes();

   //============================================================
   // <T>构造AOP定义集合。</T>
   //============================================================
   public XAopDefineCollection(){
      super(XAopDefine.class);
   }

   //============================================================
   // <T>获得属性集合。</T>
   //
   // @return 属性集合
   //============================================================
   public FAttributes attributes(){
      return _attributes;
   }

   //============================================================
   // <T>格式化显示内容。</T>
   //
   // @param value 内容
   // @return 解析内容
   //============================================================
   public String parse(String value){
      // 检查参数
      if(RString.isEmpty(value)){
         return value;
      }
      // 替换内容
      int start = 0;
      while((start = value.indexOf("${")) != -1){
         int end = value.indexOf("}", start);
         if(-1 != end){
            // 查找引用
            String parse = null;
            String refer = value.substring(start + 2, end);
            if(!RString.isEmpty(refer)){
               refer = refer.toLowerCase();
               if(_attributes.contains(refer)){
                  parse = _attributes.get(refer);
               }else{
                  XAopDefine define = findByKey(refer.toLowerCase());
                  if(define == null){
                     throw new FFatalError("Refer is not defined. (value={1}, refer={2})", value, refer);
                  }
                  parse = define.value();
               }
            }
            if(parse == null){
               parse = "";
            }else if(parse.contains(refer)){
               throw new FFatalError("Define parser loop failure. (refer={1}, parse={2})", refer, parse);
            }
            // 设置内容
            value = value.substring(0, start) + parse + value.substring(end + 1);
         }
      }
      return value;
   }
}
