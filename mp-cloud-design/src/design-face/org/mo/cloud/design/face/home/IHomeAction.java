package org.mo.cloud.design.face.home;

import org.mo.cloud.design.face.list.FListPage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

public interface IHomeAction
{

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String process(IWebContext context,
                  ILogicContext logicContext,
                  @AContainer(name = "page") FListPage page);
}
