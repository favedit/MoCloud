package org.mo.cloud.content.design.tree;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.tree.common.XTreeView;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容列表控制台。</T>
//============================================================
public class FTreeConsole
      extends FConsole
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
   protected IConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 列表
   protected FDictionary<XTreeView> _treeDictionary = new FDictionary<XTreeView>(XTreeView.class);

   //============================================================
   // <T>获得目录集合。</T>
   //
   // @param storgeName 存储名称
   // @return 目录集合
   //============================================================
   @Override
   public XTreeView[] list(String storgeName){
      FObjects<XTreeView> results = new FObjects<XTreeView>(XTreeView.class);
      FContentSpace space = _configurationConsole.getSpace(storgeName, _pathName);
      for(INamePair<FContentNode> pair : space.contents()){
         FContentNode node = pair.value();
         String treeName = node.name();
         XTreeView xtree = find(storgeName, treeName);
         results.push(xtree);
      }
      return results.toObjects();
   }

   //============================================================
   // <T>根据名称获得目录。</T>
   //
   // @param storgeName 存储名称
   // @param treeName 目录名称
   // @return 目录
   //============================================================
   @Override
   public XTreeView find(String storgeName,
                         String treeName){
      String code = storgeName + "|" + treeName;
      XTreeView xtree = _treeDictionary.find(code);
      if(xtree == null){
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, treeName);
         xtree = persistence.convertInstance(node.config());
         _treeDictionary.set(code, xtree);
      }
      return xtree;
   }

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param treeName 目录名称
   // @return 目录配置
   //============================================================
   @Override
   public FXmlNode buildConfig(String storgeName,
                               String treeName){
      // 查找目录定义
      XTreeView xtree = find(storgeName, treeName);
      // 转换数据
      FXmlNode xconfig = new FXmlNode();
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, "design.tree");
      FContentObject content = persistence.convertConfig(xtree);
      // 存储输出
      content.saveConfig(xconfig);
      return xconfig;
   }
}
