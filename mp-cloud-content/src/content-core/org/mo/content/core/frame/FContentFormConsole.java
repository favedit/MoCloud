package org.mo.content.core.frame;

import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.content.core.configuration.FContentNode;
import org.mo.content.core.configuration.FContentSpace;
import org.mo.content.core.configuration.IContentConfigurationConsole;
import org.mo.content.core.configuration.XContentObject;
import org.mo.content.core.persistence.FContentPersistence;
import org.mo.content.core.persistence.IContentPersistenceConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容表单控制台。</T>
//============================================================
public class FContentFormConsole
      implements
         IContentFormConsole
{
   // 空间名称
   @AProperty
   protected String _spaceName;

   // 路径名称
   @AProperty
   protected String _pathName;

   // 内容配置控制台接口
   @ALink
   protected IContentConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IContentPersistenceConsole _persistenceConsole;

   // 表单字典
   protected FDictionary<XContentObject> _forms = new FDictionary<XContentObject>(XContentObject.class);

   //============================================================
   // <T>获得表单集合。</T>
   //
   // @param storgeName 存储名称
   // @return 表单集合
   //============================================================
   @Override
   public XContentObject[] list(String storgeName){
      FObjects<XContentObject> results = new FObjects<XContentObject>(XContentObject.class);
      FContentSpace space = _configurationConsole.getSpace(storgeName, _pathName);
      for(INamePair<FContentNode> pair : space.contents()){
         FContentNode node = pair.value();
         String listName = node.name();
         XContentObject xlist = find(storgeName, listName);
         results.push(xlist);
      }
      return results.toObjects();
   }

   //============================================================
   // <T>根据名称获得表单。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @return 表单
   //============================================================
   @Override
   public XContentObject find(String storgeName,
                              String formName){
      String code = storgeName + "|" + formName;
      XContentObject xlist = _forms.find(code);
      if(xlist == null){
         FContentPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, formName);
         xlist = persistence.convertInstance(node.config());
         _forms.set(code, xlist);
      }
      return xlist;
   }
}
