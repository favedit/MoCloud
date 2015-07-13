package org.mo.content.face.resource.mesh;

import org.mo.content.core.person.IAccountConsole;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>用户逻辑实现类</P>
//
//@class FPersonAction
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FMeshAction
      implements
         IMeshAction
{
   //用户控制台
   @ALink
   protected IAccountConsole _personConsole;

   @Override
   public String importData(IWebContext context){
      System.out.println("begin");
      for(FWebUploadFile file : context.files()){
         System.out.println(file.dump());
      }
      System.out.println("end");
      return null;
   }
}
