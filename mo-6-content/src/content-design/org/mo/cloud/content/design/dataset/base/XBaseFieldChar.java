package org.mo.cloud.content.design.dataset.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>字段字段对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseFieldChar
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "FieldChar";

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

   // 主键的定义
   @AContentField
   public final static FContentField IS_KEY = new FContentField("isKey", "is_key", EContentData.Boolean, "", "", "", "YY");

   // 空值的定义
   @AContentField
   public final static FContentField IS_NULL = new FContentField("isNull", "is_null", EContentData.Boolean, "", "", "", "YY");

   // 唯一值的定义
   @AContentField
   public final static FContentField IS_UNIQUE = new FContentField("isUnique", "is_unique", EContentData.Boolean, "", "", "", "YY");

   // 可存储的定义
   @AContentField
   public final static FContentField IS_STORE = new FContentField("isStore", "is_store", EContentData.String, "", "", "", "YY");

   // 虚字段的定义
   @AContentField
   public final static FContentField IS_ABSTRACT = new FContentField("isAbstract", "is_abstract", EContentData.String, "", "", "", "YY");

   // 可加密的定义
   @AContentField
   public final static FContentField IS_ENCRYPT = new FContentField("isEncrypt", "is_encrypt", EContentData.String, "", "", "", "YYN");

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String, "", "", "", "YY");

   // 数据格式的定义
   @AContentField
   public final static FContentField DATA_FORMAT = new FContentField("dataFormat", "data_format", EContentData.String, "", "", "", "YYY");

   // 数据别称的定义
   @AContentField
   public final static FContentField DATA_ALIAS = new FContentField("dataAlias", "data_alias", EContentData.String, "", "", "", "YY");

   // 数据类型的定义
   @AContentField
   public final static FContentField DATA_TYPE = new FContentField("dataType", "data_type", EContentData.String, "", "", "", "YY");

   // 数据大小的定义
   @AContentField
   public final static FContentField DATA_SIZE = new FContentField("dataSize", "data_size", EContentData.String, "", "", "", "YY");

   // 数据引用的定义
   @AContentField
   public final static FContentField DATA_REFER = new FContentField("dataRefer", "data_refer", EContentData.String, "", "", "", "YY");

   // 数据编号的定义
   @AContentField
   public final static FContentField DATA_CODE = new FContentField("dataCode", "data_code", EContentData.String, "", "", "", "YY");

   // 唯一名称集的定义
   @AContentField
   public final static FContentField DATA_UNIQUES = new FContentField("dataUniques", "data_uniques", EContentData.String, "", "", "", "YY");

   // 分组类型的定义
   @AContentField
   public final static FContentField GROUP = new FContentField("group", "group", EContentData.String, "", "", "", "YYY");

   // 新建缺省的定义
   @AContentField
   public final static FContentField DATA_DEFAULT = new FContentField("dataDefault", "data_default", EContentData.String, "", "", "", "YYN");

   // 新建数据的定义
   @AContentField
   public final static FContentField DATA_INSERT = new FContentField("dataInsert", "data_insert", EContentData.String, "", "", "", "YYY");

   // 更新数据的定义
   @AContentField
   public final static FContentField DATA_UPDATE = new FContentField("dataUpdate", "data_update", EContentData.String, "", "", "", "YYN");

   // 索引名称的定义
   @AContentField
   public final static FContentField INDEX_NAMES = new FContentField("indexNames", "index_names", EContentData.String, "", "", "", "YYY");

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

   // 主键
   @AName("is_key")
   protected boolean _isKey;

   // 空值
   @AName("is_null")
   protected boolean _isNull;

   // 唯一值
   @AName("is_unique")
   protected boolean _isUnique;

   // 可存储
   @AName("is_store")
   protected String _isStore;

   // 虚字段
   @AName("is_abstract")
   protected String _isAbstract;

   // 可加密
   @AName("is_encrypt")
   protected String _isEncrypt;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 数据格式
   @AName("data_format")
   protected String _dataFormat;

   // 数据别称
   @AName("data_alias")
   protected String _dataAlias;

   // 数据类型
   @AName("data_type")
   protected String _dataType;

   // 数据大小
   @AName("data_size")
   protected String _dataSize;

   // 数据引用
   @AName("data_refer")
   protected String _dataRefer;

   // 数据编号
   @AName("data_code")
   protected String _dataCode;

   // 唯一名称集
   @AName("data_uniques")
   protected String _dataUniques;

   // 分组类型
   @AName("group")
   protected String _group;

   // 新建缺省
   @AName("data_default")
   protected String _dataDefault;

   // 新建数据
   @AName("data_insert")
   protected String _dataInsert;

   // 更新数据
   @AName("data_update")
   protected String _dataUpdate;

   // 索引名称
   @AName("index_names")
   protected String _indexNames;

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
   // <T>获得主键的内容。</T>
   //
   // @return 主键
   //============================================================
   public Boolean getIsKey(){
      return _isKey;
   }

   //============================================================
   // <T>设置主键的内容。</T>
   //
   // @param value 主键
   //============================================================
   public void setIsKey(Boolean value){
      _isKey = value;
   }

   //============================================================
   // <T>获得空值的内容。</T>
   //
   // @return 空值
   //============================================================
   public Boolean getIsNull(){
      return _isNull;
   }

   //============================================================
   // <T>设置空值的内容。</T>
   //
   // @param value 空值
   //============================================================
   public void setIsNull(Boolean value){
      _isNull = value;
   }

   //============================================================
   // <T>获得唯一值的内容。</T>
   //
   // @return 唯一值
   //============================================================
   public Boolean getIsUnique(){
      return _isUnique;
   }

   //============================================================
   // <T>设置唯一值的内容。</T>
   //
   // @param value 唯一值
   //============================================================
   public void setIsUnique(Boolean value){
      _isUnique = value;
   }

   //============================================================
   // <T>获得可存储的内容。</T>
   //
   // @return 可存储
   //============================================================
   public String getIsStore(){
      return _isStore;
   }

   //============================================================
   // <T>设置可存储的内容。</T>
   //
   // @param value 可存储
   //============================================================
   public void setIsStore(String value){
      _isStore = value;
   }

   //============================================================
   // <T>获得虚字段的内容。</T>
   //
   // @return 虚字段
   //============================================================
   public String getIsAbstract(){
      return _isAbstract;
   }

   //============================================================
   // <T>设置虚字段的内容。</T>
   //
   // @param value 虚字段
   //============================================================
   public void setIsAbstract(String value){
      _isAbstract = value;
   }

   //============================================================
   // <T>获得可加密的内容。</T>
   //
   // @return 可加密
   //============================================================
   public String getIsEncrypt(){
      return _isEncrypt;
   }

   //============================================================
   // <T>设置可加密的内容。</T>
   //
   // @param value 可加密
   //============================================================
   public void setIsEncrypt(String value){
      _isEncrypt = value;
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
   // <T>获得数据格式的内容。</T>
   //
   // @return 数据格式
   //============================================================
   public String getDataFormat(){
      return _dataFormat;
   }

   //============================================================
   // <T>设置数据格式的内容。</T>
   //
   // @param value 数据格式
   //============================================================
   public void setDataFormat(String value){
      _dataFormat = value;
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
   // <T>获得数据类型的内容。</T>
   //
   // @return 数据类型
   //============================================================
   public String getDataType(){
      return _dataType;
   }

   //============================================================
   // <T>设置数据类型的内容。</T>
   //
   // @param value 数据类型
   //============================================================
   public void setDataType(String value){
      _dataType = value;
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
   // <T>获得数据引用的内容。</T>
   //
   // @return 数据引用
   //============================================================
   public String getDataRefer(){
      return _dataRefer;
   }

   //============================================================
   // <T>设置数据引用的内容。</T>
   //
   // @param value 数据引用
   //============================================================
   public void setDataRefer(String value){
      _dataRefer = value;
   }

   //============================================================
   // <T>获得数据编号的内容。</T>
   //
   // @return 数据编号
   //============================================================
   public String getDataCode(){
      return _dataCode;
   }

   //============================================================
   // <T>设置数据编号的内容。</T>
   //
   // @param value 数据编号
   //============================================================
   public void setDataCode(String value){
      _dataCode = value;
   }

   //============================================================
   // <T>获得唯一名称集的内容。</T>
   //
   // @return 唯一名称集
   //============================================================
   public String getDataUniques(){
      return _dataUniques;
   }

   //============================================================
   // <T>设置唯一名称集的内容。</T>
   //
   // @param value 唯一名称集
   //============================================================
   public void setDataUniques(String value){
      _dataUniques = value;
   }

   //============================================================
   // <T>获得分组类型的内容。</T>
   //
   // @return 分组类型
   //============================================================
   public String getGroup(){
      return _group;
   }

   //============================================================
   // <T>设置分组类型的内容。</T>
   //
   // @param value 分组类型
   //============================================================
   public void setGroup(String value){
      _group = value;
   }

   //============================================================
   // <T>获得新建缺省的内容。</T>
   //
   // @return 新建缺省
   //============================================================
   public String getDataDefault(){
      return _dataDefault;
   }

   //============================================================
   // <T>设置新建缺省的内容。</T>
   //
   // @param value 新建缺省
   //============================================================
   public void setDataDefault(String value){
      _dataDefault = value;
   }

   //============================================================
   // <T>获得新建数据的内容。</T>
   //
   // @return 新建数据
   //============================================================
   public String getDataInsert(){
      return _dataInsert;
   }

   //============================================================
   // <T>设置新建数据的内容。</T>
   //
   // @param value 新建数据
   //============================================================
   public void setDataInsert(String value){
      _dataInsert = value;
   }

   //============================================================
   // <T>获得更新数据的内容。</T>
   //
   // @return 更新数据
   //============================================================
   public String getDataUpdate(){
      return _dataUpdate;
   }

   //============================================================
   // <T>设置更新数据的内容。</T>
   //
   // @param value 更新数据
   //============================================================
   public void setDataUpdate(String value){
      _dataUpdate = value;
   }

   //============================================================
   // <T>获得索引名称的内容。</T>
   //
   // @return 索引名称
   //============================================================
   public String getIndexNames(){
      return _indexNames;
   }

   //============================================================
   // <T>设置索引名称的内容。</T>
   //
   // @param value 索引名称
   //============================================================
   public void setIndexNames(String value){
      _indexNames = value;
   }

}
