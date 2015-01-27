package org.mo.cloud.core.logger;

import com.cyou.gccloud.define.enums.common.EGcLogger;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>系统例外日志。</T>
//============================================================
public class FGcLoggerSystemException
      extends FGcLogger
{
   // 用户编号
   protected long _userId;

   // 代码
   protected String _code;

   // 描述
   protected String _description;

   //============================================================
   // <T>构造系统例外日志。</T>
   //============================================================
   public FGcLoggerSystemException(){
      _typeCd = EGcLogger.Fatal;
   }

   //============================================================
   // <T>构造系统例外日志。</T>
   //
   // @param operationCd 操作类型
   // @param parameters 参数集合
   //============================================================
   public FGcLoggerSystemException(long userId,
                                   String code,
                                   String description,
                                   Object... parameters){
      _typeCd = EGcLogger.Fatal;
      _userId = userId;
      _code = code;
      _description = description;
      setAttributes(parameters);
   }

   //============================================================
   // <T>获得用户编号。</T>
   //
   // @return 用户编号
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号。</T>
   //
   // @param userId 用户编号
   //============================================================
   public void setUserId(long userId){
      _userId = userId;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
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
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置描述。</T>
   //
   // @param code 描述
   //============================================================
   public void setDescription(String description){
      _description = description;
   }

   //============================================================
   // <T>从配置节点中加载数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      _userId = xconfig.getLong("user_id");
      _code = xconfig.get("code");
      _description = xconfig.get("description");
   }

   //============================================================
   // <T>向配置节点中保存数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      xconfig.set("user_id", _userId);
      xconfig.set("code", _code);
      xconfig.set("description", _description);
   }
}
