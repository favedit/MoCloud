//============================================================
// <T>逻辑共通消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.logiccommon;

import com.cyou.gccloud.common.INetObject;
import com.cyou.gccloud.common.message.ENetMessageGroup;
import com.cyou.gccloud.common.message.ENetMessageType;
import com.cyou.gccloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>学校列表请求消息。</T>
//============================================================
public class FLgcSchoolListRequest
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "LgcSchoolListRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.LogicCommon + 0x0001;

   // 版本
   public final static int VERSION = 0x29845AFC;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FLgcSchoolListRequest(){
      _head.name = NAME;
      _head.type = TYPE;
      _head.code = CODE;
      _head.version = VERSION;
   }

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @param xconfig 配置节点
   // @return 实例对象
   //============================================================
   public FLgcSchoolListRequest(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
   }
}
