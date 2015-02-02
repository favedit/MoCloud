package org.mo.content.core.list;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.list.common.XList;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.content.core.persistence.FContentPersistence;
import org.mo.content.core.persistence.IContentPersistenceConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容列表控制台。</T>
//============================================================
public class FContentListConsole
      implements
         IContentListConsole
{
   // 空间名称
   @AProperty
   protected String _spaceName;

   // 路径名称
   @AProperty
   protected String _pathName;

   // 内容配置控制台接口
   @ALink
   protected IConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IContentPersistenceConsole _persistenceConsole;

   // 列表
   protected FDictionary<XList> _list = new FDictionary<XList>(XList.class);

   //============================================================
   // <T>获得列表集合。</T>
   //
   // @param storgeName 存储名称
   // @return 列表集合
   //============================================================
   @Override
   public XList[] list(String storgeName){
      FObjects<XList> results = new FObjects<XList>(XList.class);
      FContentSpace space = _configurationConsole.getSpace(storgeName, _pathName);
      for(INamePair<FContentNode> pair : space.contents()){
         FContentNode node = pair.value();
         String listName = node.name();
         XList xlist = find(storgeName, listName);
         results.push(xlist);
      }
      return results.toObjects();
   }

   //============================================================
   // <T>根据名称获得列表。</T>
   //
   // @param storgeName 存储名称
   // @param listName 列表名称
   // @return 列表
   //============================================================
   @Override
   public XList find(String storgeName,
                     String listName){
      String code = storgeName + "|" + listName;
      XList xlist = _list.find(code);
      if(xlist == null){
         FContentPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, listName);
         xlist = persistence.convertInstance(node.config());
         _list.set(code, xlist);
      }
      return xlist;
   }
}
