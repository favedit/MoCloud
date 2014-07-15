package org.mo.game.editor.face.apl.logic.form;

import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

public interface IWebFormPdfServlet{

   void build(IWebContext context,
              ISqlContext sqlContext,
              IWebServletResponse response);

}
