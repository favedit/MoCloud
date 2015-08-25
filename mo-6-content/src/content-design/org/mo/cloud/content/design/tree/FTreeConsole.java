package org.mo.cloud.content.design.tree;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.tree.common.XTreeView;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.system.IListener;
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

   // 持久化名称
   @AProperty
   protected String _persistenceName;

   // 内容配置控制台接口
   @ALink
   protected IConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容字典
   protected FDictionary<XTreeView> _contents = new FDictionary<XTreeView>(XTreeView.class);

   //============================================================
   // <T>更新配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   public void initialize(){
      _configurationConsole.registerFileChanged(new IListener(){
         @Override
         public boolean process(Object sender,
                                int command,
                                Object params){
            _contents.clear();
            return true;
         }
      });
   }

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
         XTreeView xtree = find(storgeName, treeName, EPersistenceMode.Config);
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
                         String treeName,
                         EPersistenceMode modeCd){
      String code = storgeName + "|" + treeName + "|" + modeCd;
      XTreeView xtree = _contents.find(code);
      if(xtree == null){
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, treeName);
         xtree = persistence.convertInstance(node.content(), modeCd);
         _contents.set(code, xtree);
      }
      return xtree;
   }

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param treeName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public FContentObject findDefine(String storgeName,
                                    String treeName,
                                    EPersistenceMode modeCd){
      XContentObject xobject = find(storgeName, treeName, modeCd);
      if(xobject != null){
         // 获得转换器
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
         // 转换对象
         return persistence.convertConfig(xobject, modeCd);
      }
      return null;
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
      XTreeView xtree = find(storgeName, treeName, EPersistenceMode.Config);
      // 转换数据
      FXmlNode xconfig = new FXmlNode();
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
      FContentObject content = persistence.convertConfig(xtree);
      // 存储输出
      content.saveConfig(xconfig);
      return xconfig;
   }

   //============================================================
   // <T>新建配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void insert(String storgeName,
                      FContentObject contentObject){
      // 新建节点
      String nodeName = contentObject.get("name");
      FContentSpace space = _configurationConsole.findSpace(storgeName, _spaceName);
      FContentNode contentNode = space.create(nodeName);
      contentNode.setContent(contentObject);
      contentNode.store();
      // 清空缓冲
      _contents.clear();
   }

   //============================================================
   // <T>更新配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void update(String storgeName,
                      FContentObject contentObject){
      String nodeName = contentObject.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      FContentObject xinstance = node.content();
      // 获得转换器
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
      persistence.mergeConfig(xinstance, contentObject, EPersistenceMode.Config);
      // 保存处理
      node.store();
      // 清空缓冲
      _contents.clear();
   }

   //============================================================
   // <T>删除配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void delete(String storgeName,
                      FContentObject contentObject){
      // 移除节点
      String nodeName = contentObject.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      node.remove();
      // 清空缓冲
      _contents.clear();
   }
}
