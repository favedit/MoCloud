package org.mo.cloud.content.design.frame;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容表单控制台。</T>
//============================================================
public class FFrameConsole
      extends FConsole
      implements
         IFrameConsole
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

   // 表单字典
   protected FDictionary<XContentObject> _frames = new FDictionary<XContentObject>(XContentObject.class);

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
      XContentObject xframe = _frames.find(code);
      if(xframe == null){
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, formName);
         if(node != null){
            FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
            xframe = persistence.convertInstance(node.config(), modeCd);
            _frames.set(code, xframe);
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
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, "design.frame");
         // 转换对象
         return persistence.convertConfig(xobject, modeCd);
      }
      return null;
   }

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @return 目录配置
   //============================================================
   protected void buildContentConfig(String storgeName,
                                     FContentObject contentObject,
                                     EPersistenceMode modeCd){
      // 处理模板
      if(contentObject.isName("Template")){
         FContentObject contentParent = contentObject.parent();
         int index = contentParent.nodes().indexOf(contentObject);
         contentParent.nodes().remove(contentObject);
         // 查找引用内容
         String frameSource = contentObject.get("frame_source");
         FContentObject contentTemplate = findDefine(storgeName, frameSource, modeCd);
         buildContentConfig(storgeName, contentTemplate, modeCd);
         if(contentTemplate.hasNode()){
            for(FContentObject contentNode : contentTemplate.nodes()){
               contentParent.nodes().insert(contentNode, index++);
            }
         }
      }
      // 处理子节点
      if(contentObject.hasNode()){
         for(FContentObject contentNode : contentObject.nodes()){
            buildContentConfig(storgeName, contentNode, modeCd);
         }
      }
   }

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @param modeCd 模式类型
   // @return 目录配置
   //============================================================
   @Override
   public FXmlNode buildConfig(String storgeName,
                               String frameName,
                               EPersistenceMode modeCd){
      // 查找目录定义
      FContentObject content = findDefine(storgeName, frameName, modeCd);
      // 转换数据
      buildContentConfig(storgeName, content, modeCd);
      // 存储输出
      FXmlNode xconfig = new FXmlNode();
      content.saveConfig(xconfig);
      return xconfig;
   }

   //============================================================
   // <T>更新表单配置。</T>
   //
   // @param frame 页面
   //============================================================
   @Override
   public void update(String storgeName,
                      FContentObject frame){
      String nodeName = frame.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      FContentObject xinstance = node.config();
      // 获得转换器
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, "design.frame");
      persistence.mergeConfig(xinstance, frame, EPersistenceMode.Config);
      // 保存处理
      node.store();
      // 清空缓冲
      _frames.clear();
   }
}
