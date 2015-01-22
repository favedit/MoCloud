package org.mo.content.core.persistence;

import org.mo.com.io.FStringFile;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FString;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.lang.cultrue.REncoding;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlNodes;
import org.mo.content.core.configuration.FContentNode;
import org.mo.content.core.configuration.FContentObject;
import org.mo.content.core.configuration.FContentObjects;
import org.mo.content.core.configuration.FContentSpace;
import org.mo.content.core.configuration.IContentConfigurationConsole;
import org.mo.core.aop.RAop;
import org.mo.core.aop.face.ALink;
import org.mo.eng.template.ITemplateConsole;
import org.mo.eng.template.ITemplateParser;

//============================================================
// <T>内容持久化控制台。</T>
//============================================================
public class FContentPersistenceConsole
      implements
         IContentPersistenceConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FContentPersistenceConsole.class);

   // 存储名称
   protected String _storageName = "cloud";

   // 空间名称
   protected String _spaceName = "design.persistence";

   // 配置控制台接口
   @ALink
   protected IContentConfigurationConsole _configurationConsole;

   // 模板控制台接口
   @ALink
   protected ITemplateConsole _templateConsole;

   // 持久化字典
   protected FDictionary<FContentPersistence> _persistences = new FDictionary<FContentPersistence>(FContentPersistence.class);

   //============================================================
   // <T>查找持久对象。</T>
   //
   // @param storageName 存储名称
   // @param persistenceName 持久名称
   // @return 持久对象
   //============================================================
   @Override
   public FContentPersistence findPersistence(String storageName,
                                              String persistenceName){
      String code = storageName + "|" + persistenceName;
      FContentPersistence persistence = _persistences.find(code);
      if(persistence == null){
         FContentNode xpersistence = _configurationConsole.getNode(storageName, _spaceName, persistenceName);
         persistence = new FContentPersistence();
         persistence.setStorageName(_storageName);
         persistence.setPersistenceName(persistenceName);
         persistence.load(xpersistence.config());
         _persistences.set(code, persistence);
      }
      return persistence;
   }

   //============================================================
   // <T>根据节点名称获得内容节点。</T>
   //
   // @param nodeName 节点名称
   // @return 内容节点
   //============================================================
   @Override
   public FContentNode find(String name){
      return _configurationConsole.getNode(_storageName, _spaceName, name);
   }

   //============================================================
   // <T>构建属性集合。</T>
   //
   // @param xpersistence 持久化节点
   // @param xcomponent 对象节点
   // @param xattributes 属性节点
   //============================================================
   protected void buildAttributes(FContentObject xpersistence,
                                  FContentObject xcomponent,
                                  FContentObjects xattributes){
      // 分解继承的接口或类
      String name = xcomponent.get("name");
      String inherits = xcomponent.get("inherits");
      if(!RString.isEmpty(inherits)){
         String[] inheritItems = RString.trimNoEmpty(RString.split(inherits, ','));
         for(String inherit : inheritItems){
            // 查找被继承的接口或类
            FContentObject xinherit = xpersistence.findObject("name", inherit);
            if(xinherit == null){
               throw new FFatalError("Can't find inherit. (component={1}, inherit={2})", name, inherit);
            }
            buildAttributes(xpersistence, xinherit, xattributes);
         }
      }
      // 增加新的属性到属性列表
      if(xcomponent.hasNode()){
         // 增加属性
         for(FContentObject xattribute : xcomponent.nodes()){
            if(xattribute.isName("Attribute")){
               String attributeName = xattribute.get("name");
               if(xattributes.findObject("name", attributeName) != null){
                  throw new FFatalError("Attribute is duplication. (component={1}, attribute={2})", name, attributeName);
               }
               xattributes.push(xattribute);
            }
         }
      }
   }

   //============================================================
   // <T>构建属性集合。</T>
   //
   // @param xpersistence 持久化节点
   // @param xcomponent 对象节点
   // @param xattributes 属性节点
   //============================================================
   protected void buildComponent(FContentObject xpersistence,
                                 FContentObject xcomponent){
      // String template = xpersistence.getTemplate();
      ITemplateParser parser = _templateConsole.getParser("content.persistence.component");
      String className = xcomponent.get("base_name", null);
      if(RString.isEmpty(className)){
         throw new FFatalError("Class name is null.");
      }
      // 分解继承关系
      FXmlNodes importNodes = new FXmlNodes();
      String inherits = xcomponent.get("inherits");
      if(!RString.isEmpty(inherits)){
         for(String inherit : RString.split(inherits, ',')){
            if(!RString.isEmpty(inherit)){
               FContentObject xobject = xpersistence.findObject("name", inherit);
               if(xobject == null){
                  throw new FFatalError("Inherits is not found. (inherit={1})", inherit);
               }
               FXmlNode importNode = importNodes.create("Import");
               importNode.set("class_name", xobject.get("class_name"));
            }
         }
      }
      // 递归建立所有属性
      FContentObjects xattributes = new FContentObjects();
      try{
         buildAttributes(xpersistence, xcomponent, xattributes);
      }catch(Exception e){
         throw new FFatalError(e, "Build attributes error. (persistence={1}, component={2})", xpersistence.get("name"), xcomponent.get("name"));
      }
      // 生成配置
      FXmlNode xcomponentConfig = xcomponent.makeConfig();
      xcomponentConfig.set("class", className);
      // 解析代码
      parser.reset();
      parser.define("imports", importNodes);
      parser.define("component", xcomponentConfig);
      parser.define("attributes", xattributes.makeConfig());
      FString source = parser.parse();
      // 获得文件名称
      String path = RAop.configConsole().parseDefine(xpersistence.get("source"));
      String target = RString.replace(className, '.', '/');
      target = RFile.makeFilename(path, target + ".java");
      // 存储文件内容
      FStringFile file = new FStringFile();
      file.append(source);
      file.saveFile(target, REncoding.UTF8.toString());
      _logger.debug(this, "buildComponent", "Build component source. (target={1})", target);
   }

   //   protected void buildInterface(XPersistence xpersistence,
   //                                 XInterface xinterface,
   //                                 FString source,
   //                                 EPersistenceBuildAction action){
   //      ITemplateParser parser = _templateConsole.getParser(_templateFace);
   //      FXmlNode compNode = RXmlObject.convertDeepToNode(xinterface, EXmlConfig.Value);
   //      String className = xinterface.getClassName();
   //      if(RString.isEmpty(className)){
   //         throw new FFatalError("Class name is null.");
   //      }
   //      // 分解继承关系
   //      FXmlNodes importNodes = new FXmlNodes();
   //      String inherits = xinterface.getInherits();
   //      if(!RString.isEmpty(inherits)){
   //         for(String inherit : RString.split(inherits, ',')){
   //            if(!RString.isEmpty(inherit)){
   //               IXmlObject xobject = xpersistence.find("name", inherit);
   //               if(null == xobject){
   //                  throw new FFatalError("inherits is not found. (inherit={1})", inherit);
   //               }
   //               FXmlNode importNode = importNodes.create("Import");
   //               importNode.set("class_name", xobject.innerGet("class_name"));
   //            }
   //         }
   //      }
   //      // 解析代码
   //      parser.reset();
   //      parser.define("imports", importNodes);
   //      parser.define("interface", compNode);
   //      parser.define("attributes", compNode.nodes());
   //      source.assign(parser.parse());
   //      if(EPersistenceBuildAction.Store == action){
   //         // 获得文件名称
   //         String persistenceSource = xpersistence.getSource();
   //         String path = RAop.configConsole().parseDefine(persistenceSource);
   //         String target = RString.replace(className, '.', '/');
   //         target = RFile.makeFilename(path, target + ".java");
   //         // 存储文件内容
   //         FStringFile file = new FStringFile();
   //         file.append(source);
   //         file.saveFile(target, REncoding.UTF8.toString());
   //         _logger.debug(this, "buildInterface", "Build interface source. (target={1})", target);
   //      }
   //   }

   //============================================================
   // <T>构建内容节点。</T>
   //
   // @param xpersistence 持久化节点
   //============================================================
   protected void buildContentNode(FContentNode xpersistence){
      FContentObject xconfig = xpersistence.config();
      for(FContentObject xobject : xconfig.nodes()){
         if(xobject.isName("Component")){
            buildComponent(xconfig, xobject);
         }else if(xobject.isName("Interface")){
            //buildInterface(xconfig, xobject);
         }else{
            throw new FFatalError("Invalid component type.");
         }
      }
   }

   //============================================================
   // <T>构建处理。</T>
   //
   // @param builder 构建器
   // @return 处理结果
   //============================================================
   @Override
   public EResult build(SContentPersistenceBuildArgs builder){
      EContentPersistenceAction actionCd = builder.actionCd();
      if(actionCd == EContentPersistenceAction.Single){
         // 建立单个节点
         String containerName = builder.containerName();
         FContentNode node = _configurationConsole.getNode(_storageName, _spaceName, containerName);
         buildContentNode(node);
      }else if(actionCd == EContentPersistenceAction.All){
         // 建立全部节点
         FContentSpace space = _configurationConsole.getSpace(_storageName, _spaceName);
         for(INamePair<FContentNode> pair : space.contents()){
            buildContentNode(pair.value());
         }
      }else{
         return EResult.Failure;
      }
      return EResult.Success;
   }
}
