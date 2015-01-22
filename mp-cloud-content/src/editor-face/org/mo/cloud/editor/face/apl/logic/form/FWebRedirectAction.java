package org.mo.cloud.editor.face.apl.logic.form;

import org.mo.cloud.editor.web.apl.form.FAbstractWebFormAction;
import org.mo.cloud.editor.web.session.FUserSessionPage;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;

public class FWebRedirectAction
      extends FAbstractWebFormAction
      implements
         IWebRedirectAction
{

   public final String URI_MASTER = "display@/apl/logic/form/WebMaster.wa";

   @Override
   public String construct(IWebContext context,
                           ISqlContext sqlContext,
                           FUserSessionPage sessionPage,
                           FWebFormPage formPage){
      return redirect(context, sqlContext, sessionPage, formPage, URI_MASTER);
   }

}
