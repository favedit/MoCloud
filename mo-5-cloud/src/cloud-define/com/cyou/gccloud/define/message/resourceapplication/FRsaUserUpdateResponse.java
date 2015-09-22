//============================================================
// <T>资源应用消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.resourceapplication;

import org.mo.cloud.common.INetObject;
import org.mo.cloud.common.message.ENetMessageGroup;
import org.mo.cloud.common.message.ENetMessageType;
import org.mo.cloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户更新应答消息。</T>
//============================================================
public class FRsaUserUpdateResponse
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "RsaUserUpdateResponse";

   // 类型
   public final static int TYPE = ENetMessageType.Response;

   // 代码
   public final static int CODE = ENetMessageGroup.ResourceApplication + 0x0008;

   // 版本
   public final static int VERSION = 0x00E3C204;

   // 结果类型
   protected String _resultCd;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FRsaUserUpdateResponse(){
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
   public FRsaUserUpdateResponse(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得结果类型。</T>
   //
   // @return 结果类型
   //============================================================
   public String resultCd(){
      return _resultCd;
   }

   //============================================================
   // <T>设置结果类型。</T>
   //
   // @param resultCd 结果类型
   //============================================================
   public void setResultCd(String resultCd){
      _resultCd = resultCd;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _resultCd = xconfig.get("result_cd");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("result_cd", _resultCd);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _resultCd = null;
   }
}
