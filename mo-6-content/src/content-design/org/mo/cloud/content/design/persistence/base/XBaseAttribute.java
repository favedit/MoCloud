package org.mo.cloud.content.design.persistence.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>属性对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseAttribute extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Attribute";

   // 有效的定义
   @AContentField
   public final static FContentField IS_VALID = new FContentField("isValid", "is_valid", EContentData.String, "", "", "", "YYNY");

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String, "", "", "", "YYNY");

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String, "", "", "", "YYNY");

   // 备注的定义
   @AContentField
   public final static FContentField NOTE = new FContentField("note", "note", EContentData.String, "", "", "", "YYNY");

   // 数据类型的定义
   @AContentField
   public final static FContentField DATA_TYPE_CD = new FContentField("dataTypeCd", "data_type_cd", EContentData.String, "", "", "", "YYNY");

   // 数据分组的定义
   @AContentField
   public final static FContentField DATA_GROUP = new FContentField("dataGroup", "data_group", EContentData.String, "", "", "", "YYNY");

   // 数据代码的定义
   @AContentField
   public final static FContentField DATA_CODE = new FContentField("dataCode", "data_code", EContentData.String, "", "", "", "YYNY");

   // 数据默认值的定义
   @AContentField
   public final static FContentField DATA_DEFAULT = new FContentField("dataDefault", "data_default", EContentData.String, "", "", "", "YYNY");

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

   // 有效
   @AName("is_valid")
   protected String _isValid;

   // 名称
   @AName("name")
   protected String _name;

   // 标签
   @AName("label")
   protected String _label;

   // 备注
   @AName("note")
   protected String _note;

   // 数据类型
   @AName("data_type_cd")
   protected String _dataTypeCd;

   // 数据分组
   @AName("data_group")
   protected String _dataGroup;

   // 数据代码
   @AName("data_code")
   protected String _dataCode;

   // 数据默认值
   @AName("data_default")
   protected String _dataDefault;

   //============================================================
   // <T>获得有效的内容。</T>
   //
   // @return 有效
   //============================================================
   public String getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效的内容。</T>
   //
   // @param value 有效
   //============================================================
   public void setIsValid(String value){
      _isValid = value;
   }

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
   // <T>获得备注的内容。</T>
   //
   // @return 备注
   //============================================================
   public String getNote(){
      return _note;
   }

   //============================================================
   // <T>设置备注的内容。</T>
   //
   // @param value 备注
   //============================================================
   public void setNote(String value){
      _note = value;
   }

   //============================================================
   // <T>获得数据类型的内容。</T>
   //
   // @return 数据类型
   //============================================================
   public String getDataTypeCd(){
      return _dataTypeCd;
   }

   //============================================================
   // <T>设置数据类型的内容。</T>
   //
   // @param value 数据类型
   //============================================================
   public void setDataTypeCd(String value){
      _dataTypeCd = value;
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
   // <T>获得数据代码的内容。</T>
   //
   // @return 数据代码
   //============================================================
   public String getDataCode(){
      return _dataCode;
   }

   //============================================================
   // <T>设置数据代码的内容。</T>
   //
   // @param value 数据代码
   //============================================================
   public void setDataCode(String value){
      _dataCode = value;
   }

   //============================================================
   // <T>获得数据默认值的内容。</T>
   //
   // @return 数据默认值
   //============================================================
   public String getDataDefault(){
      return _dataDefault;
   }

   //============================================================
   // <T>设置数据默认值的内容。</T>
   //
   // @param value 数据默认值
   //============================================================
   public void setDataDefault(String value){
      _dataDefault = value;
   }

}