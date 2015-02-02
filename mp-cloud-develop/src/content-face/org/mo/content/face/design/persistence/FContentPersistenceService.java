package org.mo.content.face.design.persistence;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationService;

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
