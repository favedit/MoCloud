package org.mo.cloud.content.design.dataset.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>数据视图对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseDataView
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "DataView";

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String, "", "", "", "YY");

   // 简称的定义
   @AContentField
   public final static FContentField ALIAS = new FContentField("alias", "alias", EContentData.String, "", "", "", "YY");

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String, "", "", "", "YYNN");

   // 有效性的定义
   @AContentField
   public final static FContentField IS_VALID = new FContentField("isValid", "is_valid", EContentData.Boolean, "", "", "Y", "YY");

   // 属性列表的定义
   @AContentField
   public final static FContentField ATTRIBUTES = new FContentField("attributes", "attributes", EContentData.String, "", "", "", "YY");

   // 注释信息的定义
   @AContentField
   public final static FContentField NOTE = new FContentField("note", "note", EContentData.String, "", "", "", "YYNN");

   // 查询可的定义
   @AContentField
   public final static FContentField ACCESS_QUERY = new FContentField("accessQuery", "access_query", EContentData.String, "", "", "", "YY");

   // 新建可的定义
   @AContentField
   public final static FContentField ACCESS_INSERT = new FContentField("accessInsert", "access_insert", EContentData.Boolean, "", "", "", "YY");

   // 更新可的定义
   @AContentField
   public final static FContentField ACCESS_UPDATE = new FContentField("accessUpdate", "access_update", EContentData.Boolean, "", "", "", "YY");

   // 删除可的定义
   @AContentField
   public final static FContentField ACCESS_DELETE = new FContentField("accessDelete", "access_delete", EContentData.Boolean, "", "", "", "YY");

   // 数据引擎的定义
   @AContentField
   public final static FContentField DATA_ENGINE = new FContentField("dataEngine", "data_engine", EContentData.String, "", "", "", "YYY");

   // 数据分组的定义
   @AContentField
   public final static FContentField DATA_GROUP = new FContentField("dataGroup", "data_group", EContentData.String, "", "", "", "YYY");

   // 数据工厂的定义
   @AContentField
   public final static FContentField DATA_FACTORY = new FContentField("dataFactory", "data_factory", EContentData.String, "", "", "", "YYY");

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String, "", "", "", "YY");

   // 数据别称的定义
   @AContentField
   public final static FContentField DATA_ALIAS = new FContentField("dataAlias", "data_alias", EContentData.String, "", "", "", "YY");

   // 数据别称的定义
   @AContentField
   public final static FContentField DATA_LOGIC = new FContentField("dataLogic", "data_logic", EContentData.String, "", "", "", "YY");

   // 数据大小的定义
   @AContentField
   public final static FContentField DATA_SIZE = new FContentField("dataSize", "data_size", EContentData.String, "", "", "", "YYY");

   // 逻辑接口的定义
   @AContentField
   public final static FContentField LOGIC_NAME = new FContentField("logicName", "logic_name", EContentData.String, "", "", "", "YY");

   // 处理接口的定义
   @AContentField
   public final static FContentField LOGIC_FACE = new FContentField("logicFace", "logic_face", EContentData.String, "", "", "", "YY");

   // 单元类的定义
   @AContentField
   public final static FContentField LOGIC_ENTITY = new FContentField("logicEntity", "logic_entity", EContentData.String, "", "", "", "Y");

   // 处理类的定义
   @AContentField
   public final static FContentField LOGIC_CLASS = new FContentField("logicClass", "logic_class", EContentData.String, "", "", "", "YY");

   // 新建逻辑的定义
   @AContentField
   public final static FContentField LOGIC_INSERT = new FContentField("logicInsert", "logic_insert", EContentData.String, "", "", "", "YY");

   // 更新逻辑的定义
   @AContentField
   public final static FContentField LOGIC_UPDATE = new FContentField("logicUpdate", "logic_update", EContentData.String, "", "", "", "YY");

   // 删除逻辑的定义
   @AContentField
   public final static FContentField LOGIC_DELETE = new FContentField("logicDelete", "logic_delete", EContentData.String, "", "", "", "YY");

   // 超时设定的定义
   @AContentField
   public final static FContentField LOGIC_TIMEOUT = new FContentField("logicTimeout", "logic_timeout", EContentData.String, "", "", "", "YYY");

   // 数据来自的定义
   @AContentField
   public final static FContentField DATA_FROM = new FContentField("dataFrom", "data_from", EContentData.String, "", "", "", "YYY");

   // 数据条件的定义
   @AContentField
   public final static FContentField DATA_WHERE = new FContentField("dataWhere", "data_where", EContentData.String, "", "", "", "YYY");

   // 数据排序的定义
   @AContentField
   public final static FContentField DATA_ORDER = new FContentField("dataOrder", "data_order", EContentData.String, "", "", "", "YYY");

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param name 名称
   //============================================================
   public static boolean isInstance(String name){
      return NAME.equals(name);
   }

   //============================================================
   // <T>判断是否指定实例。</T>
   //
   // @param xinstance 实例
   //============================================================
   public static boolean isInstance(XContentObject xinstance){
      return NAME.equals(xinstance.contentClass().name());
   }

   // 名称
   @AName("name")
   protected String _name;

   // 简称
   @AName("alias")
   protected String _alias;

   // 标签
   @AName("label")
   protected String _label;

   // 有效性
   @AName("is_valid")
   protected boolean _isValid;

   // 属性列表
   @AName("attributes")
   protected String _attributes;

   // 注释信息
   @AName("note")
   protected String _note;

   // 查询可
   @AName("access_query")
   protected String _accessQuery;

   // 新建可
   @AName("access_insert")
   protected boolean _accessInsert;

   // 更新可
   @AName("access_update")
   protected boolean _accessUpdate;

   // 删除可
   @AName("access_delete")
   protected boolean _accessDelete;

   // 数据引擎
   @AName("data_engine")
   protected String _dataEngine;

   // 数据分组
   @AName("data_group")
   protected String _dataGroup;

   // 数据工厂
   @AName("data_factory")
   protected String _dataFactory;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 数据别称
   @AName("data_alias")
   protected String _dataAlias;

   // 数据别称
   @AName("data_logic")
   protected String _dataLogic;

   // 数据大小
   @AName("data_size")
   protected String _dataSize;

   // 逻辑接口
   @AName("logic_name")
   protected String _logicName;

   // 处理接口
   @AName("logic_face")
   protected String _logicFace;

   // 单元类
   @AName("logic_entity")
   protected String _logicEntity;

   // 处理类
   @AName("logic_class")
   protected String _logicClass;

   // 新建逻辑
   @AName("logic_insert")
   protected String _logicInsert;

   // 更新逻辑
   @AName("logic_update")
   protected String _logicUpdate;

   // 删除逻辑
   @AName("logic_delete")
   protected String _logicDelete;

   // 超时设定
   @AName("logic_timeout")
   protected String _logicTimeout;

   // 数据来自
   @AName("data_from")
   protected String _dataFrom;

   // 数据条件
   @AName("data_where")
   protected String _dataWhere;

   // 数据排序
   @AName("data_order")
   protected String _dataOrder;

   //============================================================
   // <T>获得名称的内容。</T>
   //
   // @return 名称
   //============================================================
   public String getName(){
      return _name;
   }

   //============================================================
   // <T>设置名称的内容。</T>
   //
   // @param value 名称
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>获得简称的内容。</T>
   //
   // @return 简称
   //============================================================
   public String getAlias(){
      return _alias;
   }

   //============================================================
   // <T>设置简称的内容。</T>
   //
   // @param value 简称
   //============================================================
   public void setAlias(String value){
      _alias = value;
   }

   //============================================================
   // <T>获得标签的内容。</T>
   //
   // @return 标签
   //============================================================
   public String getLabel(){
      return _label;
   }

   //============================================================
   // <T>设置标签的内容。</T>
   //
   // @param value 标签
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setIsValid(Boolean value){
      _isValid = value;
   }

   //============================================================
   // <T>获得属性列表的内容。</T>
   //
   // @return 属性列表
   //============================================================
   public String getAttributes(){
      return _attributes;
   }

   //============================================================
   // <T>设置属性列表的内容。</T>
   //
   // @param value 属性列表
   //============================================================
   public void setAttributes(String value){
      _attributes = value;
   }

   //============================================================
   // <T>获得注释信息的内容。</T>
   //
   // @return 注释信息
   //============================================================
   public String getNote(){
      return _note;
   }

   //============================================================
   // <T>设置注释信息的内容。</T>
   //
   // @param value 注释信息
   //============================================================
   public void setNote(String value){
      _note = value;
   }

   //============================================================
   // <T>获得查询可的内容。</T>
   //
   // @return 查询可
   //============================================================
   public String getAccessQuery(){
      return _accessQuery;
   }

   //============================================================
   // <T>设置查询可的内容。</T>
   //
   // @param value 查询可
   //============================================================
   public void setAccessQuery(String value){
      _accessQuery = value;
   }

   //============================================================
   // <T>获得新建可的内容。</T>
   //
   // @return 新建可
   //============================================================
   public Boolean getAccessInsert(){
      return _accessInsert;
   }

   //============================================================
   // <T>设置新建可的内容。</T>
   //
   // @param value 新建可
   //============================================================
   public void setAccessInsert(Boolean value){
      _accessInsert = value;
   }

   //============================================================
   // <T>获得更新可的内容。</T>
   //
   // @return 更新可
   //============================================================
   public Boolean getAccessUpdate(){
      return _accessUpdate;
   }

   //============================================================
   // <T>设置更新可的内容。</T>
   //
   // @param value 更新可
   //============================================================
   public void setAccessUpdate(Boolean value){
      _accessUpdate = value;
   }

   //============================================================
   // <T>获得删除可的内容。</T>
   //
   // @return 删除可
   //============================================================
   public Boolean getAccessDelete(){
      return _accessDelete;
   }

   //============================================================
   // <T>设置删除可的内容。</T>
   //
   // @param value 删除可
   //============================================================
   public void setAccessDelete(Boolean value){
      _accessDelete = value;
   }

   //============================================================
   // <T>获得数据引擎的内容。</T>
   //
   // @return 数据引擎
   //============================================================
   public String getDataEngine(){
      return _dataEngine;
   }

   //============================================================
   // <T>设置数据引擎的内容。</T>
   //
   // @param value 数据引擎
   //============================================================
   public void setDataEngine(String value){
      _dataEngine = value;
   }

   //============================================================
   // <T>获得数据分组的内容。</T>
   //
   // @return 数据分组
   //============================================================
   public String getDataGroup(){
      return _dataGroup;
   }

   //============================================================
   // <T>设置数据分组的内容。</T>
   //
   // @param value 数据分组
   //============================================================
   public void setDataGroup(String value){
      _dataGroup = value;
   }

   //============================================================
   // <T>获得数据工厂的内容。</T>
   //
   // @return 数据工厂
   //============================================================
   public String getDataFactory(){
      return _dataFactory;
   }

   //============================================================
   // <T>设置数据工厂的内容。</T>
   //
   // @param value 数据工厂
   //============================================================
   public void setDataFactory(String value){
      _dataFactory = value;
   }

   //============================================================
   // <T>获得数据名称的内容。</T>
   //
   // @return 数据名称
   //============================================================
   public String getDataName(){
      return _dataName;
   }

   //============================================================
   // <T>设置数据名称的内容。</T>
   //
   // @param value 数据名称
   //============================================================
   public void setDataName(String value){
      _dataName = value;
   }

   //============================================================
   // <T>获得数据别称的内容。</T>
   //
   // @return 数据别称
   //============================================================
   public String getDataAlias(){
      return _dataAlias;
   }

   //============================================================
   // <T>设置数据别称的内容。</T>
   //
   // @param value 数据别称
   //============================================================
   public void setDataAlias(String value){
      _dataAlias = value;
   }

   //============================================================
   // <T>获得数据别称的内容。</T>
   //
   // @return 数据别称
   //============================================================
   public String getDataLogic(){
      return _dataLogic;
   }

   //============================================================
   // <T>设置数据别称的内容。</T>
   //
   // @param value 数据别称
   //============================================================
   public void setDataLogic(String value){
      _dataLogic = value;
   }

   //============================================================
   // <T>获得数据大小的内容。</T>
   //
   // @return 数据大小
   //============================================================
   public String getDataSize(){
      return _dataSize;
   }

   //============================================================
   // <T>设置数据大小的内容。</T>
   //
   // @param value 数据大小
   //============================================================
   public void setDataSize(String value){
      _dataSize = value;
   }

   //============================================================
   // <T>获得逻辑接口的内容。</T>
   //
   // @return 逻辑接口
   //============================================================
   public String getLogicName(){
      return _logicName;
   }

   //============================================================
   // <T>设置逻辑接口的内容。</T>
   //
   // @param value 逻辑接口
   //============================================================
   public void setLogicName(String value){
      _logicName = value;
   }

   //============================================================
   // <T>获得处理接口的内容。</T>
   //
   // @return 处理接口
   //============================================================
   public String getLogicFace(){
      return _logicFace;
   }

   //============================================================
   // <T>设置处理接口的内容。</T>
   //
   // @param value 处理接口
   //============================================================
   public void setLogicFace(String value){
      _logicFace = value;
   }

   //============================================================
   // <T>获得单元类的内容。</T>
   //
   // @return 单元类
   //============================================================
   public String getLogicEntity(){
      return _logicEntity;
   }

   //============================================================
   // <T>设置单元类的内容。</T>
   //
   // @param value 单元类
   //============================================================
   public void setLogicEntity(String value){
      _logicEntity = value;
   }

   //============================================================
   // <T>获得处理类的内容。</T>
   //
   // @return 处理类
   //============================================================
   public String getLogicClass(){
      return _logicClass;
   }

   //============================================================
   // <T>设置处理类的内容。</T>
   //
   // @param value 处理类
   //============================================================
   public void setLogicClass(String value){
      _logicClass = value;
   }

   //============================================================
   // <T>获得新建逻辑的内容。</T>
   //
   // @return 新建逻辑
   //============================================================
   public String getLogicInsert(){
      return _logicInsert;
   }

   //============================================================
   // <T>设置新建逻辑的内容。</T>
   //
   // @param value 新建逻辑
   //============================================================
   public void setLogicInsert(String value){
      _logicInsert = value;
   }

   //============================================================
   // <T>获得更新逻辑的内容。</T>
   //
   // @return 更新逻辑
   //============================================================
   public String getLogicUpdate(){
      return _logicUpdate;
   }

   //============================================================
   // <T>设置更新逻辑的内容。</T>
   //
   // @param value 更新逻辑
   //============================================================
   public void setLogicUpdate(String value){
      _logicUpdate = value;
   }

   //============================================================
   // <T>获得删除逻辑的内容。</T>
   //
   // @return 删除逻辑
   //============================================================
   public String getLogicDelete(){
      return _logicDelete;
   }

   //============================================================
   // <T>设置删除逻辑的内容。</T>
   //
   // @param value 删除逻辑
   //============================================================
   public void setLogicDelete(String value){
      _logicDelete = value;
   }

   //============================================================
   // <T>获得超时设定的内容。</T>
   //
   // @return 超时设定
   //============================================================
   public String getLogicTimeout(){
      return _logicTimeout;
   }

   //============================================================
   // <T>设置超时设定的内容。</T>
   //
   // @param value 超时设定
   //============================================================
   public void setLogicTimeout(String value){
      _logicTimeout = value;
   }

   //============================================================
   // <T>获得数据来自的内容。</T>
   //
   // @return 数据来自
   //============================================================
   public String getDataFrom(){
      return _dataFrom;
   }

   //============================================================
   // <T>设置数据来自的内容。</T>
   //
   // @param value 数据来自
   //============================================================
   public void setDataFrom(String value){
      _dataFrom = value;
   }

   //============================================================
   // <T>获得数据条件的内容。</T>
   //
   // @return 数据条件
   //============================================================
   public String getDataWhere(){
      return _dataWhere;
   }

   //============================================================
   // <T>设置数据条件的内容。</T>
   //
   // @param value 数据条件
   //============================================================
   public void setDataWhere(String value){
      _dataWhere = value;
   }

   //============================================================
   // <T>获得数据排序的内容。</T>
   //
   // @return 数据排序
   //============================================================
   public String getDataOrder(){
      return _dataOrder;
   }

   //============================================================
   // <T>设置数据排序的内容。</T>
   //
   // @param value 数据排序
   //============================================================
   public void setDataOrder(String value){
      _dataOrder = value;
   }

}
