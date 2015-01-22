package org.mo.cloud.design.core.tree;

import org.mo.cloud.design.core.configuration.FContentNode;
import org.mo.cloud.design.core.configuration.FContentSpace;
import org.mo.cloud.design.core.configuration.IContentConfigurationConsole;
import org.mo.cloud.design.core.persistence.FContentPersistence;
import org.mo.cloud.design.core.persistence.IContentPersistenceConsole;
import org.mo.cloud.design.core.tree.common.XTreeView;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容列表控制台。</T>
//============================================================
public class FTreeConsole
      implements
         ITreeConsole
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

   // 列表
   protected FDictionary<XTreeView> _list = new FDictionary<XTreeView>(XTreeView.class);

   //============================================================
   // <T>获得列表集合。</T>
   //
   // @param storgeName 存储名称
   // @return 列表集合
   //============================================================
   @Override
   public XTreeView[] list(String storgeName){
      FObjects<XTreeView> results = new FObjects<XTreeView>(XTreeView.class);
      FContentSpace space = _configurationConsole.getSpace(storgeName, _pathName);
      for(INamePair<FContentNode> pair : space.contents()){
         FContentNode node = pair.value();
         String listName = node.name();
         XTreeView xtree = find(storgeName, listName);
         results.push(xtree);
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
   public XTreeView find(String storgeName,
                         String listName){
      String code = storgeName + "|" + listName;
      XTreeView xtree = _list.find(code);
      if(xtree == null){
         FContentPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, listName);
         xtree = persistence.convertInstance(node.config());
         _list.set(code, xtree);
      }
      return xtree;
   }
}
