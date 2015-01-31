package org.mo.cloud.content.design.configuration.common;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentObjects;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.RXml;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.webform.IWebFormConsole;
import org.mo.web.core.webform.control.XWebForm;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>配置处理基类。</T>
//============================================================
public class FAbstractConfigurationAction
      extends FAbstractConfigurationBase
{
   // 类型集合
   public final static String TYPE_COLLECTION = "collection";

   // 类型组件
   public final static String TYPE_COMPONENT = "component";

   // 存储名称
   protected String _storageName;

   // 空间名称
   protected String _spaceName;

   // 表单配置控制台
   @ALink
   protected IWebFormConsole _formConsole;

   // 内容配置控制台
   @ALink
   protected IConfigurationConsole _configurationConsole;

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String catalog(IWebContext context,
                         FAbstractConfigurationPage page,
                         String redirect){
      // 获得上传的数据
      page.appachContext(context);
      return redirect;
   }

   //============================================================
   // <T>获得列表处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String list(IWebContext context,
                      FAbstractConfigurationPage page,
                      String redirect){
      // 获得上传的数据
      page.appachContext(context);
      // 获得列表数据
      FXmlNode config = new FXmlNode(RXml.DEFAULT_ROOT_NAME);
      FXmlNode dsNode = config.createNode(FDataset.NAME);
      dsNode.set("name", page.getFormName());
      // 设置内容
      FContentSpace contentSpace = _configurationConsole.getSpace(_storageName, _spaceName);
      for(INamePair<FContentNode> pair : contentSpace.contents()){
         FContentNode contentNode = pair.value();
         FXmlNode rowNode = dsNode.createNode();
         rowNode.setName(FRow.NAME);
         rowNode.attributes().assign(contentNode.config().attributes());
      }
      page.setPageAction("display");
      page.setFormValue(config.xml());
      return redirect;
   }

   //============================================================
   // <T>新建配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String insert(IWebContext context,
                        FAbstractConfigurationPage page,
                        String redirect){
      // 获得上传的数据
      page.appachContext(context);
      // 重置表单数据
      FXmlNode config = new FXmlNode("Config");
      config.set(PTY_TYPE, context.parameter(PTY_TYPE));
      page.setFormValue(config.xml());
      return redirect;
   }

   //============================================================
   // <T>更新配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String update(IWebContext context,
                        FAbstractConfigurationPage page,
                        String redirect){
      // 获得上传的数据
      page.appachContext(context);
      // 查找选中的XML集合对象和XML对象
      String collection = page.getSelectCollection();
      // 获得内容空间
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      page.setCollection(contentNode);
      // 判断操作类型
      String type = page.getSelectType();
      FXmlNode xconfig = new FXmlNode();
      if(TYPE_COLLECTION.equals(type)){
         // 存储选中的XML集合对象
         contentNode.config().saveConfig(xconfig, false);
         page.setFormValue(contentNode.config().simpleXml());
      }else if(TYPE_COMPONENT.equals(type)){
         // 存储选中的XML对象
         String component = page.getSelectComponent();
         FContentObject xcomponent = contentNode.search(component);
         if(xcomponent == null){
            throw new FFatalError("Xml component is not found. (collection={1}, component={2})", collection, component);
         }
         page.setComponent(xcomponent);
         xcomponent.saveConfig(xconfig, false);
      }else{
         throw new FFatalError("Unknown select type. (type={1})", type);
      }
      xconfig.set(PTY_TYPE, xconfig.name());
      page.setFormValue(xconfig.simpleXml());
      return redirect;
   }

   //============================================================
   // <T>删除配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String delete(IWebContext context,
                        FAbstractConfigurationPage page,
                        String redirect){
      // 获得上传的数据
      page.appachContext(context);
      // 查找选中的XML集合对象和XML对象
      String collection = page.getSelectCollection();
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      page.setCollection(contentNode);
      // 判断操作类型
      String type = page.getSelectType();
      if(TYPE_COLLECTION.equals(type)){
         // 删除选中的XML集合对象
         contentNode.remove();
      }else if(TYPE_COMPONENT.equals(type)){
         // 删除选中的XML对象
         String component = page.getSelectComponent();
         FContentObject xcomponent = contentNode.search(component);
         if(xcomponent == null){
            throw new FFatalError("Xml component is not found. (collection={1}, component={2})", collection, component);
         }
         // 查找要删除XML对象的父节点对象
         FContentObject xparent = xcomponent.parent();
         if(xparent == null){
            throw new FFatalError("Xml parent is not found. (collection={1}, component={2})", collection, component);
         }
         // 删除XML对象
         xparent.nodes().remove(xcomponent);
         contentNode.store();
      }
      // 刷新树目录
      page.resetCommands();
      page.setTreeParentRefresh();
      return redirect;
   }

   //============================================================
   // <T>删除配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   public String sort(IWebContext context,
                      FAbstractConfigurationPage page,
                      String redirect){
      // 获得上传的数据
      page.appachContext(context);
      String formName = page.getFormName();
      FXmlNode buildNode = _formConsole.build(formName, EXmlConfig.Value);
      FXmlNode orderActionNode = buildNode.findNode("name", ACTION_SORT);
      if(orderActionNode == null){
         throw new FFatalError("Can't find sort action in form config. (form={1})", formName);
      }
      orderActionNode.setName("ConfigAction");
      // 查找选中的XML集合对象
      String collection = page.getSelectCollection();
      // 获得内容空间
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      page.setCollection(contentNode);
      // 判断操作类型
      String type = page.getSelectType();
      FContentObjects xcomponents = null;
      if(TYPE_COLLECTION.equals(type)){
         xcomponents = contentNode.config().nodes();
      }else if(TYPE_COMPONENT.equals(type)){
         // 存储选中的XML对象
         String component = page.getSelectComponent();
         FContentObject xcomponent = contentNode.search(component);
         if(xcomponent == null){
            throw new FFatalError("Xml component is not found. (collection={1}, component={2})", collection, component);
         }
         xcomponents = xcomponent.nodes();
         page.setComponent(xcomponent);
      }else{
         throw new FFatalError("Unknown select type. (type={1})", type);
      }
      // 建立ListBox对象
      FXmlNode formNode = new FXmlNode(XWebForm.NAME);
      formNode.set("name", "sortForm");
      formNode.set("width", "100%");
      //formNode.set("height", "100%");
      formNode.push(orderActionNode);
      FXmlNode listNode = formNode.createNode("ListBox");
      listNode.set("name", "sortList");
      for(FContentObject xcomponent : xcomponents){
         String label = RString.nvl(xcomponent.get("label"), xcomponent.get("note"));
         // 建立节点
         FXmlNode itemNode = listNode.createNode("ListItem");
         itemNode.set("name", xcomponent.objectId());
         itemNode.set("label", xcomponent.get("name") + "(" + label + ")");
      }
      page.setFormConfig(formNode.xml());
      return redirect;
   }

   //   public String design(IXmlConfigConsole<X> console,
   //                        IWebContext context,
   //                        FAbstractConfigurationPage<X> page,
   //                        String redirect){
   //      // 获得上传的数据
   //      page.appachContext(context);
   //      // 查找选中的XML集合对象和XML对象
   //      String collection = page.getSelectCollection();
   //      X xcollection = console.get(collection);
   //      page.setCollection(xcollection);
   //      // 判断操作类型
   //      String type = page.getSelectType();
   //      if(TYPE_COLLECTION.equals(type)){
   //         // 存储选中的XML集合对象
   //         page.setFormValue(RXmlObject.convertToXml(xcollection, EXmlConfig.Value));
   //         page.setFormConfig(RXmlObject.convertDeepToXml(xcollection, EXmlConfig.Value));
   //      }else if(TYPE_COMPONENT.equals(type)){
   //         // 存储选中的XML对象
   //         String component = page.getSelectComponent();
   //         IXmlObject xcomponent = xcollection.children().search(component);
   //         if(null == xcomponent){
   //            throw new FFatalError("Xml component is not found. (collection={1}, component={2})", collection, component);
   //         }
   //         page.setComponent(xcomponent);
   //         page.setFormValue(RXmlObject.convertToXml(xcomponent, EXmlConfig.Value));
   //         page.setFormConfig(RXmlObject.convertDeepToXml(xcomponent, EXmlConfig.Value));
   //      }else{
   //         throw new FFatalError("Unknown select type. (type={1})", type);
   //      }
   //      return redirect;
   //   }
   //
   //   public IAttributes findEnvPack(IWebContext context){
   //      String pack = context.parameter("env_pack");
   //      if(RString.isNotEmpty(pack)){
   //         FAttributes attributes = new FAttributes();
   //         attributes.unpack(pack);
   //         return attributes;
   //      }
   //      return null;
   //   }
   //
   //   /**
   //    * 获得系统上传的数据设置
   //    * 
   //    * @param input 上传数据
   //    * @return 数据设置
   //    */
   //   public X getSelectCollection(IXmlConfigConsole<X> console,
   //                                FAbstractConfigurationPage<X> page){
   //      String collection = page.getSelectCollection();
   //      return console.get(collection);
   //   }
   //
   //   public String help(IXmlConfigConsole<X> console,
   //                      IWebContext context,
   //                      FAbstractConfigurationPage<X> page,
   //                      ITemplateParser parser,
   //                      String redirect){
   //      // 获得上传的数据
   //      page.appachContext(context);
   //      // 查找选中的XML集合对象和XML对象
   //      String collection = page.getSelectCollection();
   //      X xcollection = console.get(collection);
   //      page.setCollection(xcollection);
   //      FXmlNode config = RXmlObject.convertDeepToNode(xcollection, EXmlConfig.Value);
   //      parser.define("collection", config);
   //      // 判断操作类型
   //      String type = page.getSelectType();
   //      if(TYPE_COLLECTION.equals(type)){
   //         // 存储选中的XML集合对象
   //         parser.define("config", config);
   //      }else if(TYPE_COMPONENT.equals(type)){
   //         // 存储选中的XML对象
   //         String component = page.getSelectComponent();
   //         IXmlObject xcomponent = xcollection.children().search(component);
   //         if(null == xcomponent){
   //            throw new FFatalError("Xml component is not found. (collection={1}, component={2})", collection, component);
   //         }
   //         config = RXmlObject.convertDeepToNode(xcomponent, EXmlConfig.Value);
   //         page.setComponent(xcomponent);
   //         parser.define("component", config);
   //         parser.define("config", config);
   //      }else{
   //         throw new FFatalError("Unknown select type. (type={1})", type);
   //      }
   //      FString source = parser.parse();
   //      page.setHelp(source.toString());
   //      return redirect;
   //   }
   //
}
