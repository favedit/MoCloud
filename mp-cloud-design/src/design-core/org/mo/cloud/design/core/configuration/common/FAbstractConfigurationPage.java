package org.mo.cloud.design.core.configuration.common;

import org.mo.cloud.design.core.configuration.FContentNode;
import org.mo.cloud.design.core.configuration.FContentObject;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FObjectId;
import org.mo.com.lang.FString;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.IXmlObject;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>配置对象表单页面基类。</T>
//============================================================
public abstract class FAbstractConfigurationPage
      extends FObjectId
{
   public final static String PTY_NODE_FILTER = "node_filter";

   public final static String PTY_NODE_SORT = "node_sort";

   public final static String PTY_NODE_TYPE = "node_type";

   public final static String PTY_SEL_COLLECTION = "sel_collection";

   public final static String PTY_SEL_COMPONENT = "sel_component";

   public final static String PTY_SEL_TYPE = "sel_type";

   private String _componentType;

   private String _help;

   private String _nodeFilter;

   private String _nodeSort;

   private String _nodeType;

   private String _pageAction;

   private String _selectCollection;

   private String _selectComponent;

   private String _selectType;

   private FContentNode _xcollection;

   private FContentObject _xcomponent;

   // 表单名称
   public final static String PTY_FORM_NAME = "form_name";

   // 表单服务
   public final static String PTY_FORM_SERVICE = "form_service";

   protected String _action;

   protected FXmlNode _environment = new FXmlNode("Environment");

   protected IXmlObject _form;

   private String _formAction;

   protected String _formConfig;

   protected String _formDataset;

   private String _formEvent;

   protected String _formName;

   protected String _formOrder;

   private String _formPack;

   private String _formParameters;

   protected String _formParent;

   protected String _formSearch;

   private String _formService;

   protected String _formValue;

   protected FXmlNode _result = new FXmlNode("Result");

   public void setEnvironment(String name,
                              String value){
      _environment.set(name, value);
   }

   public void appachContext(IWebContext context){
      IAttributes parameters = context.parameters();
      // 填充数据
      String formName = parameters.get(PTY_FORM_NAME, null);
      if(RString.isNotEmpty(formName)){
         setFormName(formName);
      }
      String formService = parameters.get(PTY_FORM_SERVICE, null);
      if(RString.isNotEmpty(formService)){
         setFormService(formService);
      }

      // 获得选中的数据
      _pageAction = parameters.get("do", null);
      _nodeType = parameters.get(PTY_NODE_TYPE, null);
      _nodeFilter = parameters.get(PTY_NODE_FILTER, null);
      _nodeSort = parameters.get(PTY_NODE_SORT, null);
      _selectType = parameters.get(PTY_SEL_TYPE, null);
      _selectCollection = parameters.get(PTY_SEL_COLLECTION, null);
      _selectComponent = parameters.get(PTY_SEL_COMPONENT, null);
      _componentType = parameters.get("component_type", null);
      // 设置环境对象
      if(parameters.contains(PTY_NODE_TYPE)){
         setEnvironment(PTY_NODE_TYPE, _nodeType);
      }
      if(parameters.contains(PTY_NODE_FILTER)){
         setEnvironment(PTY_NODE_FILTER, _nodeFilter);
      }
      if(parameters.contains(PTY_NODE_SORT)){
         setEnvironment(PTY_NODE_SORT, _nodeSort);
      }
      if(parameters.contains(PTY_SEL_TYPE)){
         setEnvironment("sel_type", _selectType);
      }
      if(parameters.contains(PTY_SEL_COLLECTION)){
         setEnvironment(PTY_SEL_COLLECTION, _selectCollection);
      }
      if(parameters.contains(PTY_SEL_COMPONENT)){
         setEnvironment(PTY_SEL_COMPONENT, _selectComponent);
      }
   }

   public FXmlNode commandsNode(){
      FXmlNode commands = _result.nodes().findNode("Commands");
      if(null == commands){
         commands = _result.nodes().create("Commands");
      }
      return commands;
   }

   public String getAction(){
      return _action;
   }

   public FString getEnvironment(){
      return _environment.xml();
   }

   public String getEnvironmentPack(){
      return _environment.attributes().pack();
   }

   public IXmlObject getForm(){
      return _form;
   }

   public String getFormAction(){
      return _formAction;
   }

   public String getFormConfig(){
      return _formConfig;
   }

   public String getFormDataset(){
      return _formDataset;
   }

   public String getFormEvent(){
      return _formEvent;
   }

   public String getFormName(){
      return _formName;
   }

   public String getFormOrder(){
      return _formOrder;
   }

   public String getFormPack(){
      return _formPack;
   }

   public String getFormParameters(){
      return _formParameters;
   }

   public String getFormParent(){
      return _formParent;
   }

   public String getFormSearch(){
      return _formSearch;
   }

   public String getFormService(){
      return _formService;
   }

   public String getFormValue(){
      return _formValue;
   }

   public FString getResultXml(){
      return _result.xml();
   }

   public IAttributes makeFormParent(){
      if(RString.isNotEmpty(_formParent)){
         FAttributes pack = new FAttributes();
         pack.unpack(_formParent);
         return pack;
      }
      return null;
   }

   public void reset(){
      _result.clear();
   }

   public void resetCommands(){
      commandsNode().clear();
   }

   public void resetFormValue(){
      _formValue = null;
   }

   public void setAction(String action){
      _action = action;
   }

   public void setForm(IXmlObject form){
      _form = form;
   }

   public void setFormAction(String formAction){
      _formAction = formAction;
   }

   public void setFormConfig(FString config){
      _formConfig = config.toString();
   }

   public void setFormConfig(String config){
      _formConfig = config;
   }

   public void setFormDataset(String dataset){
      _formDataset = dataset;
   }

   public void setFormEvent(String formEvent){
      _formEvent = formEvent;
   }

   public void setFormName(String formName){
      _formName = formName;
   }

   public void setFormOrder(String order){
      _formOrder = order;
   }

   public void setFormPack(String formPack){
      _formPack = formPack;
   }

   public void setFormParameters(String formParameters){
      _formParameters = formParameters;
   }

   public void setFormParent(String parent){
      _formParent = parent;
   }

   public void setFormSearch(String search){
      _formSearch = search;
   }

   public void setFormService(String formService){
      _formService = formService;
   }

   public void setFormValue(FString value){
      _formValue = value.toString();
   }

   public void setFormValue(String value){
      _formValue = value;
   }

   public void setTreeParentRefresh(){
      FXmlNode command = commandsNode().createNode("command");
      command.set("name", "tree.parent.refresh");
   }

   public void setTreeRefresh(){
      FXmlNode command = commandsNode().createNode("command");
      command.set("name", "tree.node.refresh");
   }

   public FContentNode getCollection(){
      return _xcollection;
   }

   public void setCollection(FContentNode xcollection){
      _xcollection = xcollection;
   }

   public FContentObject getComponent(){
      return _xcomponent;
   }

   public String getComponentType(){
      return _componentType;
   }

   public String getHelp(){
      return _help;
   }

   public String getNodeFilter(){
      return _nodeFilter;
   }

   public String getNodeSort(){
      return _nodeSort;
   }

   public String getNodeType(){
      return _nodeType;
   }

   public String getPageAction(){
      return _pageAction;
   }

   public String getSelectCollection(){
      return _selectCollection;
   }

   public String getSelectComponent(){
      return _selectComponent;
   }

   public String getSelectType(){
      return _selectType;
   }

   public void setComponent(FContentObject xcomponent){
      _xcomponent = xcomponent;
   }

   public void setComponentType(String componentType){
      _componentType = componentType;
   }

   public void setHelp(String help){
      _help = help;
   }

   public void setNodeFilter(String nodeFilter){
      _nodeFilter = nodeFilter;
   }

   public void setNodeSort(String nodeSort){
      _nodeSort = nodeSort;
   }

   public void setNodeType(String _nodeType){
      this._nodeType = _nodeType;
   }

   public void setPageAction(String pageAction){
      _pageAction = pageAction;
   }

   public void setSelectCollection(String selectCollection){
      _selectCollection = selectCollection;
   }

   public void setSelectComponent(String selectComponent){
      _selectComponent = selectComponent;
   }

   public void setSelectType(String selectType){
      _selectType = selectType;
   }

}
