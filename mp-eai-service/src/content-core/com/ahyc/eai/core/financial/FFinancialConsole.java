package com.ahyc.eai.core.financial;

import org.mo.com.console.FConsole;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;

//============================================================
// <T>金融控制台。</T>
//============================================================
public class FFinancialConsole
      extends FConsole
      implements
         IFinancialConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FFinancialConsole.class);

   public void initialize(){
   }
}
