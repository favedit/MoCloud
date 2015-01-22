package org.mo.com.message;

import org.mo.com.lang.FError;
import org.mo.com.lang.RDump;
import org.mo.com.lang.RString;
import org.mo.com.lang.RThrowable;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>消息基础类。</T>
//============================================================
public abstract class FAbstractMessage
      implements
         IMessage
{
   // 类型
   protected String _type;

   // 代码
   protected String _code;

   // 描述
   protected String _description;

   // 消息
   protected String _message;

   // 参数集合
   protected Object[] _params;

   //============================================================
   // <T>构造消息基础类。</T>
   //============================================================
   public FAbstractMessage(){
   }

   //============================================================
   // <T>构造消息基础类。</T>
   //
   // @param message 消息文本
   //============================================================
   public FAbstractMessage(String message){
      _message = message;
   }

   //============================================================
   // <T>构造消息基础类。</T>
   //
   // @param message 消息文本
   // @param params 参数集合
   //============================================================
   public FAbstractMessage(String message,
                           Object[] params){
      _message = message;
      _params = params;
   }

   //============================================================
   // <T>构造消息基础类。</T>
   //
   // @param throwable 例外
   //============================================================
   public FAbstractMessage(Throwable throwable){
      // 获得根例外
      Throwable rootThrowable = RThrowable.rootThrowable(throwable);
      // 设置例外信息
      _type = RClass.shortName(rootThrowable);
      _code = rootThrowable.getMessage();
      if(rootThrowable instanceof FError){
         _message = ((FError)rootThrowable).description();
      }else{
         _message = RThrowable.buildMessage(throwable).toString();
      }
      _description = RThrowable.buildDescription(throwable).toString();
   }

   //============================================================
   // <T>构造消息基础类。</T>
   //
   // @param throwable 例外
   // @param message 消息
   // @param params 参数几何
   //============================================================
   public FAbstractMessage(Throwable throwable,
                           String message,
                           Object... params){
      // 获得根例外
      Throwable rootThrowable = RThrowable.rootThrowable(throwable);
      // 设置例外信息
      _type = RClass.shortName(rootThrowable);
      _code = rootThrowable.getMessage();
      if(rootThrowable instanceof FError){
         _message = ((FError)rootThrowable).description();
      }else{
         _message = RThrowable.buildMessage(throwable).toString();
      }
      _description = RThrowable.buildDescription(throwable).toString();
      _params = params;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   @Override
   public abstract String name();

   //============================================================
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   @Override
   public String type(){
      return _type;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   @Override
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>获得描述。</T>
   //
   // @return 描述
   //============================================================
   @Override
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置描述。</T>
   //
   // @param description 描述
   //============================================================
   public void setDescription(String description){
      _description = description;
   }

   //============================================================
   // <T>获得消息。</T>
   //
   // @return 消息
   //============================================================
   @Override
   public String message(){
      return RString.format(_message, _params);
   }

   //============================================================
   // <T>设置消息。</T>
   //
   // @param message 消息
   //============================================================
   public void setMessage(String message){
      _message = message;
   }

   //============================================================
   // <T>获得参数集合。</T>
   //
   // @return 参数集合
   //============================================================
   @Override
   public Object[] params(){
      return _params;
   }

   //============================================================
   // <T>设置参数集合。</T>
   //
   // @param params 参数集合
   //============================================================
   public void setParams(Object[] params){
      _params = params;
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      _code = xconfig.get("code");
      _message = xconfig.get("message");
      _description = xconfig.get("description");
   }

   //============================================================
   // <T>保存配置信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("type", name());
      xconfig.set("code", _code);
      xconfig.set("message", message());
      xconfig.set("description", description());
   }

   //============================================================
   // <T>获得运行时信息。</T>
   //
   // @return 信息
   //============================================================
   public TDumpInfo dump(){
      return dump(new TDumpInfo(this));
   }

   //============================================================
   // <T>获得运行时信息。</T>
   //
   // @param info 信息
   // @return 信息
   //============================================================
   public TDumpInfo dump(TDumpInfo info){
      RDump.dump(info, this);
      info.append("[");
      info.append("Message:", _message);
      info.append(" Description:", _description);
      info.append(" Params:", _params);
      info.append(" Type:", _type);
      info.append("]");
      return info;
   }
}
