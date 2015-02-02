package org.mo.content.face.design.frame;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationService;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FContentFrameService
      extends FAbstractConfigurationService
      implements
         IContentFrameService
{
   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FContentFrameService(){
      _storageName = "cloud";
      _spaceName = "design.frame";
   }
}
