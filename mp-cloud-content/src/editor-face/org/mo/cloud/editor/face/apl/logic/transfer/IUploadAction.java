package org.mo.cloud.editor.face.apl.logic.transfer;

import org.mo.web.core.face.AWebLogin;

import org.mo.logic.data.ISyAttachmentDi;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.container.EContainerScope;
import org.mo.web.protocol.context.IWebContext;

@AWebLogin
public interface IUploadAction
{

   String construct(IWebContext context,
                    ISyAttachmentDi syAttachmentDi,
                    @AContainer(name = "page", scope = EContainerScope.Local) FUploadPage page);

   String preview(IWebContext context,
                  @AContainer(name = "page", scope = EContainerScope.Local) FUploadPage page);

   String upload(IWebContext context,
                 ISyAttachmentDi syAttachmentDi,
                 @AContainer(name = "page", scope = EContainerScope.Local) FUploadPage page);
}
