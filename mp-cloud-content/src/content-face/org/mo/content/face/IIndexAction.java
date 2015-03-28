package org.mo.content.face;

import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.container.AContainer;

//============================================================
//<P>用户逻辑接口</P>
//
//@class IPersonAction
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================
public interface IIndexAction
{
   String construct(ISqlContext context,
                    @AContainer(name = "page") FIndexPage page);
}
