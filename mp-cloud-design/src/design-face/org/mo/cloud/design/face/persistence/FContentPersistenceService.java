package org.mo.cloud.design.face.persistence;

import org.mo.cloud.design.core.configuration.common.FAbstractConfigurationService;

//============================================================
// <T>内容持久化服务。</T>
//============================================================
public class FContentPersistenceService
      extends FAbstractConfigurationService
      implements
         IContentPersistenceService
{
   //============================================================
   // <T>构造内容持久化服务。</T>
   //============================================================
   public FContentPersistenceService(){
      _storageName = "cloud";
      _spaceName = "design.persistence";
   }
}
