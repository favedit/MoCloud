//============================================================
// <T>逻辑升级消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.logicupgrade;

import com.cyou.gccloud.common.INetObject;
import com.cyou.gccloud.common.message.ENetMessageGroup;
import com.cyou.gccloud.common.message.ENetMessageType;
import com.cyou.gccloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>版本查询请求消息。</T>
//============================================================
public class FLguVersionQueryRequest
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "LguVersionQueryRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.LogicUpgrade + 0x0001;

   // 版本
   public final static int VERSION = 0x00E3C204;

   // 版本
   protected String _version;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FLguVersionQueryRequest(){
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
   public FLguVersionQueryRequest(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得版本。</T>
   //
   // @return 版本
   //============================================================
   public String version(){
      return _version;
   }

   //============================================================
   // <T>设置版本。</T>
   //
   // @param version 版本
   //============================================================
   public void setVersion(String version){
      _version = version;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _version = xconfig.nodeText("Version");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.createNode("version").setText(_version);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _version = null;
   }
}
