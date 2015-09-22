//============================================================
// <T>对象实体定义。</T>
//
// @version 1.0.1
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.entity;

import org.mo.cloud.common.INetObject;
import org.mo.cloud.common.SNetObject;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>对象实体。</T>
//============================================================
public class SGcObject
      extends SNetObject
      implements
         INetObject
{
   // 实体代码
   public final static String CODE = "";

   // 对象类型
   protected String _objectCd;

   //============================================================
   // <T>构造实体的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public SGcObject(){
   }

   //============================================================
   // <T>获得对象类型。</T>
   //
   // @return 对象类型
   //============================================================
   public String objectCd(){
      return _objectCd;
   }

   //============================================================
   // <T>设置对象类型。</T>
   //
   // @param value 对象类型
   //============================================================
   public void setObjectcd(String value){
      _objectCd = value;
   }

   //============================================================
   // <T>接收对象内容。</T>
   //
   // @param value 对象
   //============================================================
   @Override
   public void assign(Object value){
      super.assign(value);
      SGcObject object = (SGcObject)value;
      _objectCd = object._objectCd;
   }

   //============================================================
   // <T>序列化到输入流中。</T>
   //
   // @param output 输入流
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      xconfig.set("object_cd", _objectCd);
   }

   //============================================================
   // <T>从输出流中反序列化。</T>
   //
   // @param input 输出流
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      _objectCd = xconfig.get("object_cd", null);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _objectCd = null;
   }
}
