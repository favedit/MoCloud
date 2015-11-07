package org.mo.content.core.financial.logic.message;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.com.lang.FObject;
import org.mo.content.core.common.message.IMessageConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>短信推送服务控制台。</T>
//============================================================
public class FMessagePushConsole
      extends FObject
      implements
         IMessagePushConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FMessagePushConsole.class);
   // 建周短信控制台
   @ALink
   protected IMessageConsole _messageConsole;

   // ============================================================
   // <T>构造资源</T>
   // ============================================================
   public FMessagePushConsole(){

   }

   // ============================================================
   // <T>短信推送</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext 逻辑上下文
   // ============================================================
   @Override
   public FLogicDataset<FDataLogicNewsUnit> pushSMS(String linkIdStr,
                                                    String dateTimeStr,
                                                    ILogicContext logicContext,
                                                    IWebContext context,
                                                    IWebSession sessionContext){
      // _messageConsole.sendBatchMessage("15311444853",
      // "你好,,,田禄在测试短信接口,,,成功啦啦!!");
      // TDateTime dateTime = new TDateTime(RDateTime.currentDateTime());
      // if (dateTime.isAfter()&&(!dateTime.isBetween(,))){
      //
      // }

      return null;
   }
}
