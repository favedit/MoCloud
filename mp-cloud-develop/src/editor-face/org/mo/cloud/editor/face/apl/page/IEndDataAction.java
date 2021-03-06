package org.mo.cloud.editor.face.apl.page;

import org.mo.web.protocol.context.IWebContext;

public interface IEndDataAction
{

   String construct(IWebContext context);

   String delete(IWebContext context);

   String insert(IWebContext context);

   String update(IWebContext context);

}
