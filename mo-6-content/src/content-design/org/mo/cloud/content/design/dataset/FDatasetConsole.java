package org.mo.cloud.content.design.dataset;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.list.IListConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.system.IListener;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容数据集控制台。</T>
//============================================================
public class FDatasetConsole
      extends FConsole
      implements
         IDatasetConsole
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

   // 内容列表控制台接口
   @ALink
   protected IListConsole _listConsole;

   // 内容字典
   protected FDictionary<XContentObject> _contents = new FDictionary<XContentObject>(XContentObject.class);

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
         XContentObject xlist = find(storgeName, listName, EPersistenceMode.Store);
         results.push(xlist);
      }
      return results.toObjects();
   }

   //============================================================
   // <T>根据名称获得表单。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public XContentObject find(String storgeName,
                              String formName,
                              EPersistenceMode modeCd){
      String code = storgeName + "|" + formName + "|" + modeCd.toString();
      XContentObject xframe = _contents.find(code);
      if(xframe == null){
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, formName);
         if(node != null){
            FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
            xframe = persistence.convertInstance(node.content(), modeCd);
            _contents.set(code, xframe);
         }
      }
      return xframe;
   }

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public FContentObject findDefine(String storgeName,
                                    String formName,
                                    EPersistenceMode modeCd){
      XContentObject xobject = find(storgeName, formName, modeCd);
      if(xobject != null){
         // 获得转换器
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
         // 转换对象
         return persistence.convertConfig(xobject, modeCd);
      }
      return null;
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
                      FContentObject frame){
      String nodeName = frame.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      FContentObject xinstance = node.content();
      // 获得转换器
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
      persistence.mergeConfig(xinstance, frame, EPersistenceMode.Config);
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
