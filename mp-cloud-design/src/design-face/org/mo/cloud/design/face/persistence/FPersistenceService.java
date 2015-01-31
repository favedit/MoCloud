package org.mo.cloud.design.face.persistence;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationService;

//============================================================
// <T>内容持久化服务。</T>
//============================================================
public class FPersistenceService
      extends FAbstractConfigurationService
      implements
         IPersistenceService
{
   //============================================================
   // <T>构造内容持久化服务。</T>
   //============================================================
   public FPersistenceService(){
      _storageName = "cloud";
      _spaceName = "design.persistence";
   }
}
