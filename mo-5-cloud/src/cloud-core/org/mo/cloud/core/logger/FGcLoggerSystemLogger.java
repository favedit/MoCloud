package org.mo.cloud.core.logger;

import com.cyou.gccloud.define.enums.common.EGcLogger;
import org.mo.com.logging.ELoggerLevel;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户操作日志。</T>
//============================================================
public class FGcLoggerSystemLogger
      extends FGcLogger
{
   // 用户编号
   protected long _userId;

   // 级别类型
   protected ELoggerLevel _levelCd;

   // 代码
   protected String _code;

   // 描述
   protected String _description;

   //============================================================
   // <T>构造用户操作日志。</T>
   //============================================================
   public FGcLoggerSystemLogger(){
      _typeCd = EGcLogger.Error;
   }

   //============================================================
   // <T>构造用户操作日志。</T>
   //
   // @param operationCd 操作类型
   // @param userId 用户编号
   // @param levelCd 级别
   // @param code 代码
   // @param description 描述
   // @param parameters 参数集合
   //============================================================
   public FGcLoggerSystemLogger(long userId,
                                ELoggerLevel levelCd,
                                String code,
                                String description,
                                Object... parameters){
      _typeCd = EGcLogger.Error;
      _userId = userId;
      _levelCd = levelCd;
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
   // <T>获得级别类型。</T>
   //
   // @return 级别类型
   //============================================================
   public ELoggerLevel levelCd(){
      return _levelCd;
   }

   //============================================================
   // <T>设置级别类型。</T>
   //
   // @param levelCd 级别类型
   //============================================================
   public void setLevelCd(ELoggerLevel levelCd){
      _levelCd = levelCd;
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
      _levelCd = ELoggerLevel.parseCode(xconfig.get("level_cd"));
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
      xconfig.set("level_cd", ELoggerLevel.toCode(_levelCd));
      xconfig.set("code", _code);
      xconfig.set("description", _description);
   }
}
