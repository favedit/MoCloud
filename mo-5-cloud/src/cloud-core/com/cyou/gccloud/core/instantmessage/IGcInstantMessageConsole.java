package com.cyou.gccloud.core.instantmessage;

import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.instantmessag.SImConnectParams;

//============================================================
// <T>即时消息控制台接口。</T>
//============================================================
public interface IGcInstantMessageConsole
{

   //============================================================
   // <T>链接用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param xconfig 配置信息
   // @return 处理结果
   //============================================================
   EResult connectUser(ILogicContext logicContext,
                       long userId,
                       FXmlNode xconfig);

   //============================================================
   // <T>推送信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param message 消息对象
   // @return 处理结果
   //============================================================
   EResult pushMessage(ILogicContext logicContext,
                       SGcImMessage message);

   //============================================================
   // <T>得到配置信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param message 消息对象
   // @return 处理结果
   //============================================================
   SImConnectParams getImConnectParams();
}
