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
      XContentObject xframe = _frames.find(code);
      if(xframe == null){
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, formName);
         xframe = persistence.convertInstance(node.config());
         _frames.set(code, xframe);
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
      XContentObject xobject = find(storgeName, formName);
      if(xobject != null){
         // 获得转换器
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, "design.frame");
         // 转换对象
         FContentObject content = persistence.convertConfig(xobject, modeCd);
         return content;
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
      XContentObject xframe = find(storgeName, treeName);
      // 转换数据
      FXmlNode xconfig = new FXmlNode();
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, "design.frame");
      FContentObject content = persistence.convertConfig(xframe);
      // 存储输出
      content.saveConfig(xconfig);
      return xconfig;
   }
}
