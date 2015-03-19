package org.mo.cloud.content.design.configuration.common;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.RContentConfiguration;
import org.mo.com.lang.FObjectId;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>配置表单页面基类。</T>
//============================================================
public abstract class FAbstractConfigurationPage
      extends FObjectId
{
   // 页面命令
   protected String _pageAction;

   // 节点类型
   protected String _nodeType;

   // 节点过滤
   protected String _nodeFilter;

   // 节点排序
   protected String _nodeSort;

   // 集合代码
   protected String _storageCode;

   // 集合代码
   protected String _collectionCode;

   // 集合
   protected FContentNode _xcollection;

   // 组件代码
   protected String _componentCode;

   // 组件
   protected FContentObject _xcomponent;

   // 表单名称
   protected String _frameCode;

   // 表单服务
   protected String _frameService;

   // 表单内容
   protected String _frameValue;

   // 环境信息
   protected FXmlNode _environment = new FXmlNode("Environment");

   //   private String _componentType;
   //
   //   private String _help;
   //
   //   protected String _action;
   //
   //   protected IXmlObject _form;
   //
   //   private String _formAction;
   //
   //   protected String _formConfig;
   //
   //   protected String _formDataset;
   //
   //   private String _formEvent;
   //
   //   protected String _formOrder;
   //
   //   private String _formPack;
   //
   //   private String _formParameters;
   //
   //   protected String _formParent;
   //
   //   protected String _formSearch;
   //
   //   protected FXmlNode _result = new FXmlNode("Result");

   //============================================================
   // <T>构造配置表单页面基类。</T>
   //============================================================
   public FAbstractConfigurationPage(){
   }

   //============================================================
   // <T>接收环境内容。</T>
   //
   // @param context 内容
   //============================================================
   public void attachContext(IWebContext context){
      IAttributes parameters = context.parameters();
      // 填充数据
      String frameName = parameters.get(RContentConfiguration.PTY_FRAME_CODE, null);
      if(RString.isNotEmpty(frameName)){
         setFrameCode(frameName);
      }
      String formService = parameters.get(RContentConfiguration.PTY_FRAME_SERVICE, null);
      if(RString.isNotEmpty(formService)){
         setFrameService(formService);
      }
      _pageAction = parameters.get("do", null);
      _nodeType = parameters.get(RContentConfiguration.PTY_NODE_TYPE, null);
      _nodeFilter = parameters.get(RContentConfiguration.PTY_NODE_FILTER, null);
      _nodeSort = parameters.get(RContentConfiguration.PTY_NODE_SORT, null);
      _storageCode = parameters.get(RContentConfiguration.PTY_STORAGE_CODE, null);
      _collectionCode = parameters.get(RContentConfiguration.PTY_COLLECTION_CODE, null);
      _componentCode = parameters.get(RContentConfiguration.PTY_COMPONENT_CODE, null);
      //      _componentType = parameters.get("component_type", null);
      // 设置环境对象
      if(parameters.contains(RContentConfiguration.PTY_NODE_TYPE)){
         setEnvironment(RContentConfiguration.PTY_NODE_TYPE, _nodeType);
      }
      if(parameters.contains(RContentConfiguration.PTY_NODE_FILTER)){
         setEnvironment(RContentConfiguration.PTY_NODE_FILTER, _nodeFilter);
      }
      if(parameters.contains(RContentConfiguration.PTY_NODE_SORT)){
         setEnvironment(RContentConfiguration.PTY_NODE_SORT, _nodeSort);
      }
      if(parameters.contains(RContentConfiguration.PTY_STORAGE_CODE)){
         setEnvironment(RContentConfiguration.PTY_STORAGE_CODE, _storageCode);
      }
      if(parameters.contains(RContentConfiguration.PTY_COLLECTION_CODE)){
         setEnvironment(RContentConfiguration.PTY_COLLECTION_CODE, _collectionCode);
      }
      if(parameters.contains(RContentConfiguration.PTY_COMPONENT_CODE)){
         setEnvironment(RContentConfiguration.PTY_COMPONENT_CODE, _componentCode);
      }
   }

   //============================================================
   // <T>获得页面命令。</T>
   //
   // @return 页面命令
   //============================================================
   public String pageAction(){
      return _pageAction;
   }

   //============================================================
   // <T>设置页面命令。</T>
   //
   // @param pageAction 页面命令
   //============================================================
   public void setPageAction(String pageAction){
      _pageAction = pageAction;
   }

   //============================================================
   // <T>获得节点类型。</T>
   //
   // @return 节点类型
   //============================================================
   public String nodeType(){
      return _nodeType;
   }

   //============================================================
   // <T>设置节点类型。</T>
   //
   // @param nodeType 节点类型
   //============================================================
   public void setNodeType(String nodeType){
      _nodeType = nodeType;
   }

   //============================================================
   // <T>获得节点过滤。</T>
   //
   // @return 节点过滤
   //============================================================
   public String nodeFilter(){
      return _nodeFilter;
   }

   //============================================================
   // <T>设置节点过滤。</T>
   //
   // @param nodeFilter 节点过滤
   //============================================================
   public void setNodeFilter(String nodeFilter){
      _nodeFilter = nodeFilter;
   }

   //============================================================
   // <T>获得节点排序。</T>
   //
   // @return 节点排序
   //============================================================
   public String nodeSort(){
      return _nodeSort;
   }

   //============================================================
   // <T>设置节点排序。</T>
   //
   // @param code 节点排序
   //============================================================
   public void setNodeSort(String nodeSort){
      _nodeSort = nodeSort;
   }

   //============================================================
   // <T>获得存储代码。</T>
   //
   // @return 存储代码
   //============================================================
   public String storageCode(){
      return _storageCode;
   }

   //============================================================
   // <T>设置存储代码。</T>
   //
   // @param code 存储代码
   //============================================================
   public void setStorageCode(String storageCode){
      _storageCode = storageCode;
   }

   //============================================================
   // <T>获得集合代码。</T>
   //
   // @return 集合代码
   //============================================================
   public String collectionCode(){
      return _collectionCode;
   }

   //============================================================
   // <T>设置集合代码。</T>
   //
   // @param code 集合代码
   //============================================================
   public void setCollectionCode(String collectionCode){
      _collectionCode = collectionCode;
   }

   //============================================================
   // <T>获得集合。</T>
   //
   // @return 集合
   //============================================================
   public FContentNode getCollection(){
      return _xcollection;
   }

   //============================================================
   // <T>设置集合。</T>
   //
   // @param xcollection 集合
   //============================================================
   public void setCollection(FContentNode xcollection){
      _xcollection = xcollection;
   }

   //============================================================
   // <T>获得组件代码。</T>
   //
   // @return 组件代码
   //============================================================
   public String componentCode(){
      return _componentCode;
   }

   //============================================================
   // <T>设置组件代码。</T>
   //
   // @param code 组件代码
   //============================================================
   public void setComponentCode(String componentCode){
      _componentCode = componentCode;
   }

   //============================================================
   // <T>获得组件。</T>
   //
   // @return 组件
   //============================================================
   public FContentObject component(){
      return _xcomponent;
   }

   //============================================================
   // <T>设置组件。</T>
   //
   // @param xcomponent 组件
   //============================================================
   public void setComponent(FContentObject xcomponent){
      _xcomponent = xcomponent;
   }

   //============================================================
   // <T>获得表单代码。</T>
   //
   // @return 表单代码
   //============================================================
   public String frameCode(){
      return _frameCode;
   }

   //============================================================
   // <T>设置表单代码。</T>
   //
   // @param code 表单代码
   //============================================================
   public void setFrameCode(String frameCode){
      _frameCode = frameCode;
   }

   //============================================================
   // <T>获得表单服务。</T>
   //
   // @return 表单代码
   //============================================================
   public String frameService(){
      return _frameService;
   }

   //============================================================
   // <T>设置表单服务。</T>
   //
   // @param code 表单代码
   //============================================================
   public void setFrameService(String frameService){
      _frameService = frameService;
   }

   //============================================================
   // <T>获得表单内容。</T>
   //
   // @return 表单内容
   //============================================================
   public String frameValue(){
      return _frameValue;
   }

   //============================================================
   // <T>设置表单内容。</T>
   //
   // @param value 表单内容
   //============================================================
   public void setFrameValue(String frameValue){
      _frameValue = frameValue;
   }

   //============================================================
   // <T>获得环境内容。</T>
   //
   // @return 环境内容
   //============================================================
   public FXmlNode environment(){
      return _environment;
   }

   //============================================================
   // <T>获得环境打包内容。</T>
   //
   // @return 环境打包内容
   //============================================================
   public String environmentPack(){
      return _environment.attributes().pack();
   }

   //============================================================
   // <T>获得环境配置字符串。</T>
   //
   // @return 环境配置字符串
   //============================================================
   public String environmentXml(){
      return _environment.xml().toString();
   }

   //============================================================
   // <T>设置环境信息。</T>
   //
   // @parma name 名称
   // @param value 内容
   //============================================================
   public void setEnvironment(String name,
                              String value){
      _environment.set(name, value);
   }

   //   public FXmlNode commandsNode(){
   //      FXmlNode commands = _result.nodes().findNode("Commands");
   //      if(null == commands){
   //         commands = _result.nodes().create("Commands");
   //      }
   //      return commands;
   //   }
   //
   //   public String getAction(){
   //      return _action;
   //   }
   //
   //   public IXmlObject getForm(){
   //      return _form;
   //   }
   //
   //   public String getFormAction(){
   //      return _formAction;
   //   }
   //
   //   public String getFormConfig(){
   //      return _formConfig;
   //   }
   //
   //   public String getFormDataset(){
   //      return _formDataset;
   //   }
   //
   //   public String getFormEvent(){
   //      return _formEvent;
   //   }
   //
   //   public String getFormOrder(){
   //      return _formOrder;
   //   }
   //
   //   public String getFormPack(){
   //      return _formPack;
   //   }
   //
   //   public String getFormParameters(){
   //      return _formParameters;
   //   }
   //
   //   public String getFormParent(){
   //      return _formParent;
   //   }
   //
   //   public String getFormSearch(){
   //      return _formSearch;
   //   }
   //
   //   public FString getResultXml(){
   //      return _result.xml();
   //   }
   //
   //   public IAttributes makeFormParent(){
   //      if(RString.isNotEmpty(_formParent)){
   //         FAttributes pack = new FAttributes();
   //         pack.unpack(_formParent);
   //         return pack;
   //      }
   //      return null;
   //   }
   //
   //   public void reset(){
   //      _result.clear();
   //   }
   //
   //   public void resetCommands(){
   //      commandsNode().clear();
   //   }
   //
   //   public void resetFormValue(){
   //      _formValue = null;
   //   }
   //
   //   public void setAction(String action){
   //      _action = action;
   //   }
   //
   //   public void setForm(IXmlObject form){
   //      _form = form;
   //   }
   //
   //   public void setFormAction(String formAction){
   //      _formAction = formAction;
   //   }
   //
   //   public void setFormConfig(FString config){
   //      _formConfig = config.toString();
   //   }
   //
   //   public void setFormConfig(String config){
   //      _formConfig = config;
   //   }
   //
   //   public void setFormDataset(String dataset){
   //      _formDataset = dataset;
   //   }
   //
   //   public void setFormEvent(String formEvent){
   //      _formEvent = formEvent;
   //   }
   //
   //   public void setFormOrder(String order){
   //      _formOrder = order;
   //   }
   //
   //   public void setFormPack(String formPack){
   //      _formPack = formPack;
   //   }
   //
   //   public void setFormParameters(String formParameters){
   //      _formParameters = formParameters;
   //   }
   //
   //   public void setFormParent(String parent){
   //      _formParent = parent;
   //   }
   //
   //   public void setFormSearch(String search){
   //      _formSearch = search;
   //   }
   //
   //   public void setFormValue(FString value){
   //      _formValue = value.toString();
   //   }
   //
   //   public void setTreeParentRefresh(){
   //      FXmlNode command = commandsNode().createNode("command");
   //      command.set("name", "tree.parent.refresh");
   //   }
   //
   //   public void setTreeRefresh(){
   //      FXmlNode command = commandsNode().createNode("command");
   //      command.set("name", "tree.node.refresh");
   //   }
   //
   //   public String getComponentType(){
   //      return _componentType;
   //   }
   //
   //   public String getHelp(){
   //      return _help;
   //   }
   //
   //   public void setComponentType(String componentType){
   //      _componentType = componentType;
   //   }
   //
   //   public void setHelp(String help){
   //      _help = help;
   //   }
   //
}
