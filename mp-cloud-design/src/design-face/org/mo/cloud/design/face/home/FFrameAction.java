package org.mo.cloud.design.face.home;

import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

public class FFrameAction
      implements
         IFrameAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FFrameAction.class);

   //============================================================
   // <T>默认跳转。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      _logger.debug(this, "construct", "construct begin.");
      return "#/home/Frame";
   }

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   //   @Override
   //   public String process(IWebContext context,
   //                         ILogicContext logicContext,
   //                         @AContainer(name = "page") FListPage page){
   //      System.out.println("Test");
   //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
   //      modelLogic.doInsert(modelUnit);
   //      return null;
   //   }
}
