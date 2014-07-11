package org.mo.jfa.face.database.procedure;

import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

public interface IProcedureService
{

   void catalog(ISqlContext sqlContext,
                IWebInput input,
                IWebOutput output);

   void doSave(ISqlContext sqlContext,
               IWebInput input,
               IWebOutput output);

   void listField(ISqlContext context,
                  IWebInput input,
                  IWebOutput output);

}
