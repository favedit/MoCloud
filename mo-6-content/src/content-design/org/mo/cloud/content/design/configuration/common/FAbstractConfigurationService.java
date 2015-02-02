package org.mo.cloud.content.design.configuration.common;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentObjects;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlNodes;
import org.mo.core.aop.face.ALink;
import org.mo.eng.validator.IValidatorConsole;
import org.mo.eng.validator.common.FStringValidator;
import org.mo.jfa.common.service.RServiceResult;
import org.mo.jfa.face.apl.page.IPublicPage;
import org.mo.web.core.webtree.common.XTreeNode;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容配置服务。</T>
//============================================================
public class FAbstractConfigurationService
      extends FAbstractConfigurationBase
      implements
         IConfigurationService
{
   // 存储名称
   protected String _storageName;

   // 空间名称
   protected String _spaceName;

   // 校验控制台接口
   @ALink
   protected IValidatorConsole _validatorConsole;

   // 内容配置控制台
   @ALink
   protected IConfigurationConsole _configurationConsole;

   //============================================================
   // <T>生成集合名称。</T>
   //
   // @param name 名称
   // @return 名称
   //============================================================
   protected String makeCollectionName(String name){
      return name;
   }

   //============================================================
   // <T>建立数目录节点。</T>
   //
   // @param xnode 名称
   // @param xobject 节点
   //============================================================
   protected void onBuildTreeNode(XTreeNode xnode,
                                  FXmlNode xobject){
   }

   //============================================================
   // <T>保存集合配置信息。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   protected void saveCollection(IWebContext context,
                                 IWebInput input,
                                 IWebOutput output){
      // 查找上传的控件数据信息
      FXmlNode data = input.config().findNode("Data");
      if(data == null){
         throw new FFatalError("Collection config is null.");
      }
      // 查找目录树和控件定义对象
      FXmlNode envNode = input.config().findNode("Environment");
      String collection = envNode.get(PTY_SEL_COLLECTION);
      if(RString.isEmpty(collection)){
         throw new FFatalError("Can't find selected collection.");
      }
      // 获得内容空间
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      contentNode.config().assignAttributes(data.attributes());
      contentNode.store();
   }

   //============================================================
   // <T>保存节点配置信息。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   protected void saveComponent(IWebContext context,
                                IWebInput input,
                                IWebOutput output){
      // 获得上传数据
      FXmlNode envNode = getEnvironmentNode(input);
      FXmlNode dataNode = getDataNode(input);
      // 查找表单和控件定义对象
      String type = envNode.get(PTY_SEL_TYPE);
      String collection = envNode.get(PTY_SEL_COLLECTION);
      String component = envNode.get(PTY_SEL_COMPONENT);
      // 查找XML集合对象
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      // 根据类型来选择操作
      if(TYPE_COLLECTION.equals(type)){
         // 存储XML集合对象
         contentNode.config().assignAttributes(dataNode.attributes());
      }else if(TYPE_COMPONENT.equals(type)){
         // 存储XML对象
         FContentObject xcomponent = contentNode.search(component);
         if(null == xcomponent){
            throw new FFatalError("Component is null. (collection={0}, component={1})", collection, component);
         }
         // 更新操作
         String componentType = dataNode.get(PTY_TYPE);
         if(RString.equalsIgnoreCase(componentType, xcomponent.name())){
            // 读取控件设置
            xcomponent.assignAttributes(dataNode.attributes());
         }else{
            // 查找当前控件的父控件
            FContentObject xparent = xcomponent.parent();
            if(null == xparent){
               throw new FFatalError("Control parent is null. (collection={0}, component={1})", collection, component);
            }
            // 创建指定类型的新控件
            dataNode.setName(componentType);
            //IXmlObject xcreate = console.createElement(dataNode, EXmlConfig.Value);
            FContentObject xcreate = new FContentObject();
            //            if(xcreate == null){
            //               throw new FFatalError("Create component failure. (collection={0}, config={1})", collection, dataNode.xml());
            //            }
            int index = xparent.nodes().indexOf(xcomponent);
            if(-1 == index){
               throw new FFatalError("Find component index failure. (collection={0}, component={1})", collection, component);
            }
            xparent.nodes().set(index, xcreate);
            // 刷新树内容
            RServiceResult.setTreeParentRefresh(output);
         }
      }else{
         throw new FFatalError("Unknown select type. (type={0})", type);
      }
      // 存储表单
      contentNode.store();
   }

   //============================================================
   // <T>从配置文件中加载树目录。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult catalog(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      // 获得内容空间
      FContentSpace space = _configurationConsole.findSpace(_storageName, _spaceName);
      // 建立目录节点
      FXmlNodes outputNodes = output.config().nodes();
      for(INamePair<FContentNode> pair : space.contents()){
         // 获得属性
         FContentNode contentNode = pair.value();
         String name = contentNode.name();
         String type = contentNode.config().name();
         String label = contentNode.config().get("label");
         String uuid = contentNode.config().objectId();
         boolean hasChild = contentNode.config().hasNode();
         boolean isValid = contentNode.config().getBoolean("is_valid", true);
         // 新建节点
         XTreeNode xnode = new XTreeNode();
         xnode.setType(type);
         xnode.setUuid(uuid);
         xnode.setLabel(name);
         xnode.setNote(label);
         xnode.setChild(hasChild);
         xnode.set("linker_name", name);
         FXmlNode node = xnode.toSimpleNode();
         node.set("is_valid", isValid);
         outputNodes.push(node);
      }
      // 控制排序
      outputNodes.sortByAttribute("label");
      return EResult.Success;
   }

   //============================================================
   // <T>从配置文件中加载树目录的子节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      // 获得选中的内容
      FXmlNode selectNode = getSelectNode(input);
      FAttributes nodeAttrs = new FAttributes();
      // 获得容器节点
      String nodeName = null;
      String typeType = selectNode.get("type_type");
      if(TYPE_COLLECTION.equals(typeType)){
         nodeName = selectNode.get("label");
      }else if(TYPE_COMPONENT.equals(typeType)){
         FXmlNode topNode = selectNode.search("Node", "type_type", TYPE_COLLECTION);
         nodeAttrs.unpack(topNode.get("attributes"));
         if(nodeAttrs.contains("linker_name")){
            nodeName = nodeAttrs.get("linker_name");
         }else{
            nodeName = topNode.get("label");
         }
      }
      // 获得内容空间
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, nodeName);
      // 获得控件对象
      FContentObjects xcontrols = null;
      if(TYPE_COLLECTION.equals(typeType)){
         xcontrols = contentNode.config().nodes();
      }else{
         String objectId = selectNode.get("uuid");
         FContentObject xcontrol = contentNode.search(objectId);
         if(xcontrol != null){
            xcontrols = xcontrol.nodes();
         }
      }
      if(xcontrols == null){
         throw new FFatalError("Find control node is null. (node_name={1})", nodeName);
      }
      // 新建所有子节点
      FXmlNodes outputNodes = output.config().nodes();
      for(int n = 0; n < xcontrols.count(); n++){
         FContentObject xcomponent = xcontrols.get(n);
         // 建立树节点
         XTreeNode xnode = new XTreeNode();
         xnode.setType(xcomponent.name());
         xnode.setUuid(xcomponent.objectId());
         xnode.setLabel(RString.nvl(xcomponent.get(PTY_NAME), xcomponent.name()));
         xnode.setNote(xcomponent.get(PTY_LABEL));
         xnode.setChild(xcomponent.hasNode());
         FXmlNode node = xnode.toSimpleNode();
         node.set("is_valid", xcomponent.get("is_valid"));
         outputNodes.push(node);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult insert(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      // 获得上传数据
      FXmlNode envNode = getEnvironmentNode(input);
      FXmlNode dataNode = getDataNode(input);
      // 判断操作类型
      String selectType = envNode.get(PTY_SEL_TYPE);
      String uuid = null;
      if(TYPE_COLLECTION.equals(selectType)){
         // 基本数据检查
         String type = dataNode.get(PTY_TYPE);
         String name = dataNode.get(PTY_NAME);
         FStringValidator sv = _validatorConsole.find(FStringValidator.class);
         sv.checkEmpty(context.messages(), type, PTY_TYPE);
         sv.checkEmpty(context.messages(), name, PTY_NAME);
         context.messages().check();
         dataNode.setName(type);
         // 新建XML数据集
         FContentSpace contentSpace = _configurationConsole.getSpace(_storageName, _spaceName);
         FContentNode contentNode = contentSpace.create(name);
         contentNode.config().setName(type);
         contentNode.config().attributes().assign(dataNode.attributes());
         contentNode.store();
         uuid = contentNode.config().objectId();
         // 刷新树目录
         RServiceResult.setTreeReload(output);
      }else if(TYPE_COMPONENT.equals(selectType)){
         // 查找选中的表单和控件
         String collection = envNode.get(PTY_SEL_COLLECTION);
         FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
         // 查找父控件，当是顶层控件时，父控件为空
         FContentObject xparent = null;
         String parentControl = envNode.get(PTY_SEL_COMPONENT);
         if(RString.isNotEmpty(parentControl)){
            xparent = contentNode.search(parentControl);
            if(null == xparent){
               throw new FFatalError("Parent control is null. (tree={0}, control={1})", contentNode, parentControl);
            }
         }
         // 检查控件的名称和类型有效性
         String type = dataNode.get(PTY_TYPE);
         String name = dataNode.get(PTY_NAME);
         FStringValidator sv = _validatorConsole.find(FStringValidator.class);
         sv.checkEmpty(context.messages(), type, PTY_TYPE);
         sv.checkEmpty(context.messages(), name, PTY_NAME);
         context.messages().check();
         dataNode.setName(type);
         // 新建控件
         if(xparent != null){
            xparent.createNode(dataNode);
            uuid = xparent.objectId();
         }else{
            contentNode.config().createNode(dataNode);
            uuid = contentNode.config().objectId();
         }
         contentNode.store();
         // 刷新树目录
         RServiceResult.setTreeNodeRefresh(output, uuid);
      }else{
         throw new FFatalError("Unknown select type. (type={1})", selectType);
      }
      // 设置页面转向
      RServiceResult.setPageRedirect(output, IPublicPage.PROCESS_END_INSERT);
      return EResult.Success;

   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      // 获得上传数据
      FXmlNode envNode = getEnvironmentNode(input);
      // 判断操作类型
      String type = envNode.get(PTY_SEL_TYPE);
      if(TYPE_COLLECTION.equals(type)){
         saveCollection(context, input, output);
      }else if(TYPE_COMPONENT.equals(type)){
         saveComponent(context, input, output);
      }else{
         throw new FFatalError("Unknown select type. (type={1})", type);
      }
      return EResult.Success;

   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      // 获得上传数据
      FXmlNode envNode = getEnvironmentNode(input);
      // 判断操作类型
      String type = envNode.get(PTY_SEL_TYPE);
      String collection = envNode.get(PTY_SEL_COLLECTION);
      // 获得内容空间
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      if(TYPE_COLLECTION.equals(type)){
         // 删除选中的内容节点对象
         contentNode.remove();
      }else if(TYPE_COMPONENT.equals(type)){
         // 删除选中的内容对象
         String component = envNode.get(PTY_SEL_COMPONENT);
         FContentObject xcomponent = contentNode.search(component);
         if(xcomponent == null){
            throw new FFatalError("Xml component is not found. (collection={1},component={2})", collection, component);
         }
         // 查找要删除XML对象的父节点对象
         FContentObject xparent = xcomponent.parent();
         if(xparent == null){
            throw new FFatalError("Xml parent is not found. (collection={1},component={2})", collection, component);
         }
         // 删除XML对象
         xparent.nodes().remove(xcomponent);
         contentNode.store();
      }else{
         throw new FFatalError("Unknown select type. (type={0})", type);
      }
      // 刷新树目录
      RServiceResult.setTreeParentRefresh(output);
      RServiceResult.setPageRedirect(output, IPublicPage.PROCESS_END_INSERT);
      return EResult.Success;

   }

   //============================================================
   // <T>配置排序处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult sort(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      // 获得环境对象
      FXmlNode envNode = input.config().findNode("Environment");
      if(envNode == null){
         throw new FFatalError("Environment config is null.");
      }
      // 查找XML集合对象
      String collection = envNode.get(PTY_SEL_COLLECTION);
      FContentNode contentNode = _configurationConsole.getNode(_storageName, _spaceName, collection);
      FXmlNode sortForm = input.config().findNode("FWebForm");
      FXmlNode sortNode = sortForm.findNode("FListBox", "name", NAME_SORT);
      if(null == sortNode){
         throw new FFatalError("Sort config is null.");
      }
      // 根据类型来选择操作
      String type = envNode.get(PTY_SEL_TYPE);
      FContentObject xsort = null;
      if(TYPE_COLLECTION.equals(type)){
         xsort = contentNode.config();
      }else if(TYPE_COMPONENT.equals(type)){
         String component = envNode.get(PTY_SEL_COMPONENT);
         FContentObject xcomponent = contentNode.search(component);
         if(xcomponent == null){
            throw new FFatalError("Component is null. (collection={0}, component={1})", collection, component);
         }
         xsort = xcomponent;
      }else{
         throw new FFatalError("Unknown select type. (type={0})", type);
      }
      // 对集合中对象进行重新排序
      if(xsort.sortByConfig(sortNode)){
         contentNode.store();
      }
      // 刷新树目录节点
      RServiceResult.setTreeRefresh(output);
      RServiceResult.setPageRedirect(output, IPublicPage.PROCESS_SUCCESS);
      return EResult.Success;

   }
   //   //============================================================
   //   @SuppressWarnings("unchecked")
   //   protected void insertCollection(IXmlConfigConsole<X> console,
   //                                   IWebContext context,
   //                                   IWebInput input,
   //                                   IWebOutput output){
   //      // 获得上传数据
   //      FXmlNode data = input.config().findNode("Data");
   //      if(null == data){
   //         throw new FFatalError("Collection config is null.");
   //      }
   //      // 基本数据检查
   //      String type = data.get(PTY_TYPE);
   //      String name = data.get(PTY_NAME);
   //      FStringValidator sv = _validatorConsole.find(FStringValidator.class);
   //      sv.checkEmpty(context.messages(), type, PTY_TYPE);
   //      sv.checkEmpty(context.messages(), name, PTY_NAME);
   //      context.messages().check();
   //      data.setName(type);
   //      // 新建XML数据集
   //      IXmlObject xcollection = console.createElement(data, EXmlConfig.Value);
   //      console.persist((X)xcollection);
   //   }
   //
   //   //============================================================
   //   @SuppressWarnings("unchecked")
   //   protected void insertComponent(IXmlConfigConsole<X> console,
   //                                  IWebContext context,
   //                                  IWebInput input,
   //                                  IWebOutput output){
   //      // 获得上传数据
   //      FXmlNode data = input.config().findNode("Data");
   //      if(null == data){
   //         throw new FFatalError("Component config is null.");
   //      }
   //      FXmlNode envNode = input.config().findNode("Environment");
   //      if(null == envNode){
   //         throw new FFatalError("Can't find environment node.");
   //      }
   //      // 查找选中的表单和控件
   //      String collection = envNode.get(PTY_SEL_COLLECTION);
   //      IXmlObject xcollection = console.get(collection);
   //      String parentControl = envNode.get(PTY_SEL_COMPONENT);
   //      IXmlObject xparent = null;
   //      if(RString.isNotEmpty(parentControl)){
   //         xparent = xcollection.children().search(parentControl);
   //         if(null == xparent){
   //            throw new FFatalError("Parent control is null. (tree={0},control={1})", xcollection, parentControl);
   //         }
   //      }
   //      // 检查控件的名称和类型有效性
   //      String type = data.get(PTY_TYPE);
   //      String name = data.get(PTY_NAME);
   //      FStringValidator sv = _validatorConsole.find(FStringValidator.class);
   //      sv.checkEmpty(context.messages(), type, PTY_TYPE);
   //      sv.checkEmpty(context.messages(), name, PTY_NAME);
   //      context.messages().check();
   //      data.setName(type);
   //      // 新建控件
   //      IXmlObject xcontrol = console.createElement(data, EXmlConfig.Value);
   //      if(null != xparent){
   //         xparent.children().push(xcontrol);
   //      }else{
   //         xcollection.children().push(xcontrol);
   //      }
   //      console.store((X)xcollection);
   //   }
}
