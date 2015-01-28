package org.mo.cloud.design.face.home;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.design.face.base.FBasePage;
import org.mo.cloud.design.face.list.FListPage;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

public class FHomeAction
      implements
         IHomeAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FHomeAction.class);

   //============================================================
   // <T>列出目录处理。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           FBasePage basePage){
      _logger.debug(this, "construct", "construct begin.");
      return "#/manage/home/Frame";
   }

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String process(IWebContext context,
                         ILogicContext logicContext,
                         @AContainer(name = "page") FListPage page){
      System.out.println("Test");
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
      modelLogic.doInsert(modelUnit);
      return null;
   }
}
