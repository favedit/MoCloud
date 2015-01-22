package com.cyou.gccloud.core.logger;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>日志。</T>
//============================================================
public class FGcLogger
      extends FObject
{
   // 类型
   protected int _typeCd;

   // 服务代码
   protected String _serverCode;

   // 时间
   protected long _dateTime;

   // 属性集合
   protected FAttributes _attributes;

   //============================================================
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   public int typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型。</T>
   //
   // @param typeCd 类型
   //============================================================
   public void setTypeCd(int typeCd){
      _typeCd = typeCd;
   }

   //============================================================
   // <T>获得服务代码。</T>
   //
   // @return 服务代码
   //============================================================
   public String serverCode(){
      return _serverCode;
   }

   //============================================================
   // <T>设置服务代码。</T>
   //
   // @param serverCode 服务代码
   //============================================================
   public void setServerCode(String serverCode){
      _serverCode = serverCode;
   }

   //============================================================
   // <T>获得时间。</T>
   //
   // @return 时间
   //============================================================
   public long dateTime(){
      return _dateTime;
   }

   //============================================================
   // <T>设置时间。</T>
   //
   // @param dateTime 时间
   //============================================================
   public void setDateTime(long dateTime){
      _dateTime = dateTime;
   }

   //============================================================
   // <T>判断是否有属性集合。</T>
   //
   // @return 是否有属性集合
   //============================================================
   public boolean hasAttribute(){
      return (_attributes != null) ? !_attributes.isEmpty() : false;
   }

   //============================================================
   // <T>获得属性集合。</T>
   //
   // @return 属性集合
   //============================================================
   public FAttributes attributes(){
      if(_attributes == null){
         _attributes = new FAttributes();
      }
      return _attributes;
   }

   //============================================================
   // <T>设置属性集合。</T>
   //
   // @param parameters 参数集合
   //============================================================
   public void setAttributes(Object[] parameters){
      if(parameters != null){
         int count = parameters.length;
         if(count > 0){
            // 检查个数
            if((count % 2) != 0){
               throw new FFatalError("Parameters count is invalid. (count={1})", count);
            }
            // 设置属性集合
            FAttributes attributes = attributes();
            for(int n = 0; n < count; n += 2){
               String name = RString.nvl(parameters[n]);
               String value = RString.nvl(parameters[n + 1]);
               attributes.set(name, value);
            }
         }
      }
   }

   //============================================================
   // <T>从配置节点中加载数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _typeCd = xconfig.getInt("type_cd");
      _serverCode = xconfig.get("server_code");
      _dateTime = xconfig.getLong("datetime");
      if(xconfig.contains("attributes")){
         String attributePack = xconfig.get("attributes");
         attributes().unpack(attributePack);
      }
   }

   //============================================================
   // <T>向配置节点中保存数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("type_cd", _typeCd);
      xconfig.set("server_code", _serverCode);
      xconfig.set("datetime", _dateTime);
      if(hasAttribute()){
         String attributePack = _attributes.pack();
         xconfig.set("attributes", attributePack);
      }
   }
}
