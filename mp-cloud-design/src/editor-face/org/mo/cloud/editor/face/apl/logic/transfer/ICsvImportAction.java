package org.mo.cloud.editor.face.apl.logic.transfer;

import org.mo.web.core.face.AWebLogin;

import org.mo.logic.session.ISqlSessionContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

@AWebLogin
public interface ICsvImportAction
{

   String upload(IWebContext context,
                 ISqlSessionContext sqlContext,
                 @AContainer(name = "page") FCsvImportPage page);

   String uploadSave(IWebContext context,
                     ISqlSessionContext sqlContext,
                     @AContainer(name = "page") FCsvImportPage page);
}
