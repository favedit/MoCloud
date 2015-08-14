package org.mo.cloud.content.design.list;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.list.common.XList;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容列表控制台。</T>
//============================================================
public class FListConsole
      extends FConsole
      implements
         IListConsole
{
   // 空间名称
   @AProperty
   protected String _spaceName;

   // 路径名称
   @AProperty
   protected String _pathName;

   // 持久化名称
   @AProperty
   protected String _persistenceName;

   // 内容配置控制台接口
   @ALink
   protected IConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 列表
   protected FDictionary<XList> _lists = new FDictionary<XList>(XList.class);

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
         XList xlist = find(storgeName, listName, EPersistenceMode.Config);
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
                     String listName,
                     EPersistenceMode modeCd){
      String code = storgeName + "|" + listName + "|" + modeCd;
      XList xlist = _lists.find(code);
      if(xlist == null){
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, listName);
         xlist = persistence.convertInstance(node.config(), modeCd);
         _lists.set(code, xlist);
      }
      return xlist;
   }

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param listName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public FContentObject findDefine(String storgeName,
                                    String listName,
                                    EPersistenceMode modeCd){
      XContentObject xobject = find(storgeName, listName, modeCd);
      if(xobject != null){
         // 获得转换器
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
         // 转换对象
         return persistence.convertConfig(xobject, modeCd);
      }
      return null;
   }

   //============================================================
   // <T>更新列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void insert(String storgeName,
                      FContentObject contentObject){
      String nodeName = contentObject.get("name");
      FContentSpace space = _configurationConsole.findSpace(storgeName, _spaceName);
      FContentNode contentNode = space.create(nodeName);
      contentNode.setConfig(contentObject);
      contentNode.store();
      // 清空缓冲
      _lists.clear();
   }

   //============================================================
   // <T>更新列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void update(String storgeName,
                      FContentObject contentObject){
      String nodeName = contentObject.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      FContentObject xinstance = node.config();
      // 获得转换器
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
      persistence.mergeConfig(xinstance, contentObject, EPersistenceMode.Config);
      // 保存处理
      node.store();
      // 清空缓冲
      _lists.clear();
   }

   //============================================================
   // <T>删除列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void delete(String storgeName,
                      FContentObject contentObject){
      String nodeName = contentObject.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      node.remove();
      // 清空缓冲
      _lists.clear();
   }
}
