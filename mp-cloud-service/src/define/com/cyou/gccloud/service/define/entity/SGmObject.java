//============================================================
// <T>对象实体定义。</T>
//
// @version 1.0.1
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.service.define.entity;

import org.mo.com.xml.*;
import com.cyou.gccloud.service.common.entity.*;

//============================================================
// <T>对象实体。</T>
//============================================================
public class SGmObject extends SMemoryPoolObject implements INetObject
{
   // 对象类型
   protected String _objectCd;

   //============================================================
   // <T>构造实体的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public SGmObject(){
   }

   //============================================================
   // <T>接收对象内容。</T>
   //
   // @param object 对象
   //============================================================
   @Override
   public void assign(Object object){
      super.assign(object);
      SGmObject obj = (SGmObject)object;
      // 反序列化对象类型
      _objectCd = obj._objectCd;
   }

   //============================================================
   // <T>序列化到输入流中。</T>
   //
   // @param output 输入流
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 序列化对象类型
      xconfig.set("object_cd", _objectCd);
   }

   //============================================================
   // <T>从输出流中反序列化。</T>
   //
   // @param input 输出流
   //============================================================
   @Override
   public boolean loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 反序列化对象类型
      _objectCd = xconfig.get("object_cd");
      return true;
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      // 重置对象类型内容
      _objectCd = null;
   }

   // @manual (Source.Begin)
   //------------------------------------------------------------
   //------------------------------------------------------------
   // @manual (Source.End)
}
