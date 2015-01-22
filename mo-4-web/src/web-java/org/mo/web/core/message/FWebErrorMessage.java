package org.mo.web.core.message;

import org.mo.com.message.FErrorMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>错误消息。</T>
//============================================================
public class FWebErrorMessage
      extends FErrorMessage
{
   // 内容集合
   protected Object[] _values;

   //============================================================
   // <T>构造检查消息。</T>
   //============================================================
   public FWebErrorMessage(){
   }

   //============================================================
   // <T>构造检查消息。</T>
   //
   // @param code 代码
   // @param message 消息
   // @param params 参数集合
   //============================================================
   public FWebErrorMessage(String code,
                           String message,
                           String... params){
      _code = code;
      _message = message;
      _params = params;
   }

   //============================================================
   // <T>获得内容集合。</T>
   //
   // @return 内容集合
   //============================================================
   public Object[] values(){
      return _values;
   }

   //============================================================
   // <T>设置内容集合。</T>
   //
   // @param values 内容集合
   //============================================================
   public void setValues(Object... values){
      _values = values;
   }

   //============================================================
   // <T>保存配置信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      xconfig.setName(name());
      // 设置属性
      xconfig.set("code", _code);
      xconfig.set("note", message());
      // 设置内容集合
      if(_values != null){
         int count = _values.length;
         for(int n = 0; n < count; n++){
            Object value = _values[n];
            if(value != null){
               xconfig.set("value" + (n + 1), value.toString());
            }
         }
      }
   }
}
