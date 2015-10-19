package org.mo.content.face;

import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页接口。</P>
//
// @author maocy
// @version 150427
//============================================================
public interface IIndexAction {
    // ============================================================
    // <T>默认逻辑处理。</T>
    //
    // @param context 页面环境
    // @param page 页面
    // ============================================================
    String construct(ISqlContext context,
            @AContainer(name = "page") FIndexPage page, IWebContext webContext);

}
