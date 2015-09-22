//============================================================
// <T>系统工具消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.systemutility;

import org.mo.cloud.common.INetObject;
import org.mo.cloud.common.message.ENetMessageGroup;
import org.mo.cloud.common.message.ENetMessageType;
import org.mo.cloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>运行信息应答消息。</T>
//============================================================
public class FSyuRuntimeInfoResponse
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "SyuRuntimeInfoResponse";

   // 类型
   public final static int TYPE = ENetMessageType.Response;

   // 代码
   public final static int CODE = ENetMessageGroup.SystemUtility + 0x0002;

   // 版本
   public final static int VERSION = 0x40E3C204;

   //============================================================
   // <T>机器信息定义。</T>
   //============================================================
   public final static class SMachineInfo
         implements
            INetObject
   {
      // 代码
      public final static String CODE = "";

      //============================================================
      // <T>构造机器信息定义。</T>
      //============================================================
      public SMachineInfo(){
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
      public void reset(){
      }
   }

   //============================================================
   // <T>运行信息定义。</T>
   //============================================================
   public final static class SRuntimeInfo
         implements
            INetObject
   {
      // 代码
      public final static String CODE = "";

      //============================================================
      // <T>构造运行信息定义。</T>
      //============================================================
      public SRuntimeInfo(){
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
      public void reset(){
      }
   }

   // 结果类型
   protected String _resultCd;

   // 机器信息
   protected SMachineInfo _machine = new SMachineInfo();

   // 运行信息
   protected SRuntimeInfo _runtime = new SRuntimeInfo();

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FSyuRuntimeInfoResponse(){
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
   public FSyuRuntimeInfoResponse(FXmlNode xconfig){
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
   // <T>获得机器信息。</T>
   //
   // @return 机器信息
   //============================================================
   public SMachineInfo machine(){
      return _machine;
   }

   //============================================================
   // <T>获得运行信息。</T>
   //
   // @return 运行信息
   //============================================================
   public SRuntimeInfo runtime(){
      return _runtime;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _resultCd = xconfig.get("result_cd");
      FXmlNode xmachine = xconfig.findNode(SMachineInfo.CODE);
      if(xmachine != null){
         _machine.loadConfig(xmachine);
      }
      FXmlNode xruntime = xconfig.findNode(SRuntimeInfo.CODE);
      if(xruntime != null){
         _runtime.loadConfig(xruntime);
      }
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("result_cd", _resultCd);
      FXmlNode xmachine = xconfig.syncNode(SMachineInfo.CODE);
      _machine.saveConfig(xmachine);
      FXmlNode xruntime = xconfig.syncNode(SRuntimeInfo.CODE);
      _runtime.saveConfig(xruntime);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _resultCd = null;
      _machine.reset();
      _runtime.reset();
   }
}
