package org.mo.cloud.system.face.design.list;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationService;

//============================================================
// <T>内容列表服务。</T>
//============================================================
public class FListService
      extends FAbstractConfigurationService
      implements
         IListService
{
   //============================================================
   // <T>构造内容列表服务。</T>
   //============================================================
   public FListService(){
      _storageName = "system";
      _spaceName = "design.list";
   }
}
