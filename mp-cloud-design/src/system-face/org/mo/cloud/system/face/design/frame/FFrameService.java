package org.mo.cloud.system.face.design.frame;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationService;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FFrameService
      extends FAbstractConfigurationService
      implements
         IFrameService
{
   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FFrameService(){
      _storageName = "system";
      _spaceName = "design.frame";
   }
}
