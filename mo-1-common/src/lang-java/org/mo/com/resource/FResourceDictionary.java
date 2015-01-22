package org.mo.com.resource;

import org.mo.com.lang.FDictionary;

//============================================================
// <T>资源字典。</T>
//============================================================
public class FResourceDictionary
      extends FDictionary<IResource>
{
   //============================================================
   // <T>构造资源字典。</T>
   //============================================================
   public FResourceDictionary(){
      super(IResource.class);
   }
}
