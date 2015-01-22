package com.cyou.gccloud.common.validator;

import org.mo.com.lang.FValidError;
import org.mo.com.message.IMessageContext;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;

//============================================================
// <T>校验器。</T>
//============================================================
public class RGcValidator
{
   private static IResource _resource = RResource.find(RGcValidator.class);

   //============================================================
   // <T>检查非空。</T>
   //============================================================
   public static void checkNull(IMessageContext context,
                                Object value,
                                String display){
      if(value == null){
         throw new FValidError(_resource.findDisplay("checkNull"), display);
      }
   }
}
