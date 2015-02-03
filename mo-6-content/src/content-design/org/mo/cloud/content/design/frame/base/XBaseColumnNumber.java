package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>表格数字列对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseColumnNumber
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "ColumnNumber";

   // 类型的定义
   @AContentField
   public final static FContentField TYPE = new FContentField("type", "type", EContentData.String, "", "", "", "YYNY");

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String, "", "", "", "YYNY");

   // 有效性的定义
   @AContentField
   public final static FContentField VALID = new FContentField("valid", "valid", EContentData.Boolean, "", "", "", "YYNY");

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String, "", "", "", "YYNY");

   // 位置的定义
   @AContentField
   public final static FContentField LOCATION = new FContentField("location", "location", EContentData.String, "", "", "", "YYNY");

   // 尺寸的定义
   @AContentField
   public final static FContentField SIZE = new FContentField("size", "size", EContentData.String, "", "", "", "YYNY");

   // 内空白的定义
   @AContentField
   public final static FContentField PADDING = new FContentField("padding", "padding", EContentData.String, "", "", "", "YYNY");

   // 外空白的定义
   @AContentField
   public final static FContentField MARGIN = new FContentField("margin", "margin", EContentData.String, "", "", "", "YYNY");

   // 编辑模式的定义
   @AContentField
   public final static FContentField EDIT_MODE = new FContentField("editMode", "edit_mode", EContentData.String, "", "", "", "NYNN");

   // 查看编辑的定义
   @AContentField
   public final static FContentField EDIT_VIEW = new FContentField("editView", "edit_view", EContentData.Boolean, "edit_mode", "V", "Y", "YNNY");

   // 新建编辑的定义
   @AContentField
   public final static FContentField EDIT_INSERT = new FContentField("editInsert", "edit_insert", EContentData.Boolean, "edit_mode", "I", "Y", "YNNY");

   // 更新编辑的定义
   @AContentField
   public final static FContentField EDIT_UPDATE = new FContentField("editUpdate", "edit_update", EContentData.Boolean, "edit_mode", "U", "Y", "YNNY");

   // 删除编辑的定义
   @AContentField
   public final static FContentField EDIT_DELETE = new FContentField("editDelete", "edit_delete", EContentData.Boolean, "edit_mode", "D", "Y", "YNNY");

   // 校验模式的定义
   @AContentField
   public final static FContentField VERIFY_MODE = new FContentField("verifyMode", "verify_mode", EContentData.String, "", "", "", "NYNN");

   // 新建检查的定义
   @AContentField
   public final static FContentField VERIFY_INSERT = new FContentField("verifyInsert", "verify_insert", EContentData.Boolean, "verify_mode", "I", "Y", "YNNY");

   // 编辑检查的定义
   @AContentField
   public final static FContentField VERIFY_UPDATE = new FContentField("verifyUpdate", "verify_update", EContentData.Boolean, "verify_mode", "U", "Y", "YNNY");

   // 删除检查的定义
   @AContentField
   public final static FContentField VERIFY_DELETE = new FContentField("verifyDelete", "verify_delete", EContentData.Boolean, "verify_mode", "D", "Y", "YNNY");

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String, "", "", "", "YYNY");

   // 数据类型的定义
   @AContentField
   public final static FContentField DATA_TYPE_CD = new FContentField("dataTypeCd", "data_type_cd", EContentData.String, "", "", "", "YYNY");

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

   // 类型
   @AName("type")
   protected String _type;

   // 名称
   @AName("name")
   protected String _name;

   // 有效性
   @AName("valid")
   protected boolean _valid;

   // 标签
   @AName("label")
   protected String _label;

   // 位置
   @AName("location")
   protected String _location;

   // 尺寸
   @AName("size")
   protected String _size;

   // 内空白
   @AName("padding")
   protected String _padding;

   // 外空白
   @AName("margin")
   protected String _margin;

   // 编辑模式
   @AName("edit_mode")
   protected String _editMode;

   // 查看编辑
   @AName("edit_view")
   protected boolean _editView;

   // 新建编辑
   @AName("edit_insert")
   protected boolean _editInsert;

   // 更新编辑
   @AName("edit_update")
   protected boolean _editUpdate;

   // 删除编辑
   @AName("edit_delete")
   protected boolean _editDelete;

   // 校验模式
   @AName("verify_mode")
   protected String _verifyMode;

   // 新建检查
   @AName("verify_insert")
   protected boolean _verifyInsert;

   // 编辑检查
   @AName("verify_update")
   protected boolean _verifyUpdate;

   // 删除检查
   @AName("verify_delete")
   protected boolean _verifyDelete;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 数据类型
   @AName("data_type_cd")
   protected String _dataTypeCd;

   //============================================================
   // <T>获得类型的内容。</T>
   //
   // @return 类型
   //============================================================
   public String getType(){
      return _type;
   }

   //============================================================
   // <T>设置类型的内容。</T>
   //
   // @param value 类型
   //============================================================
   public void setType(String value){
      _type = value;
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
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public Boolean getValid(){
      return _valid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setValid(Boolean value){
      _valid = value;
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
   // <T>获得位置的内容。</T>
   //
   // @return 位置
   //============================================================
   public String getLocation(){
      return _location;
   }

   //============================================================
   // <T>设置位置的内容。</T>
   //
   // @param value 位置
   //============================================================
   public void setLocation(String value){
      _location = value;
   }

   //============================================================
   // <T>获得尺寸的内容。</T>
   //
   // @return 尺寸
   //============================================================
   public String getSize(){
      return _size;
   }

   //============================================================
   // <T>设置尺寸的内容。</T>
   //
   // @param value 尺寸
   //============================================================
   public void setSize(String value){
      _size = value;
   }

   //============================================================
   // <T>获得内空白的内容。</T>
   //
   // @return 内空白
   //============================================================
   public String getPadding(){
      return _padding;
   }

   //============================================================
   // <T>设置内空白的内容。</T>
   //
   // @param value 内空白
   //============================================================
   public void setPadding(String value){
      _padding = value;
   }

   //============================================================
   // <T>获得外空白的内容。</T>
   //
   // @return 外空白
   //============================================================
   public String getMargin(){
      return _margin;
   }

   //============================================================
   // <T>设置外空白的内容。</T>
   //
   // @param value 外空白
   //============================================================
   public void setMargin(String value){
      _margin = value;
   }

   //============================================================
   // <T>获得编辑模式的内容。</T>
   //
   // @return 编辑模式
   //============================================================
   public String getEditMode(){
      return _editMode;
   }

   //============================================================
   // <T>设置编辑模式的内容。</T>
   //
   // @param value 编辑模式
   //============================================================
   public void setEditMode(String value){
      _editMode = value;
   }

   //============================================================
   // <T>获得查看编辑的内容。</T>
   //
   // @return 查看编辑
   //============================================================
   public Boolean getEditView(){
      return _editView;
   }

   //============================================================
   // <T>设置查看编辑的内容。</T>
   //
   // @param value 查看编辑
   //============================================================
   public void setEditView(Boolean value){
      _editView = value;
   }

   //============================================================
   // <T>获得新建编辑的内容。</T>
   //
   // @return 新建编辑
   //============================================================
   public Boolean getEditInsert(){
      return _editInsert;
   }

   //============================================================
   // <T>设置新建编辑的内容。</T>
   //
   // @param value 新建编辑
   //============================================================
   public void setEditInsert(Boolean value){
      _editInsert = value;
   }

   //============================================================
   // <T>获得更新编辑的内容。</T>
   //
   // @return 更新编辑
   //============================================================
   public Boolean getEditUpdate(){
      return _editUpdate;
   }

   //============================================================
   // <T>设置更新编辑的内容。</T>
   //
   // @param value 更新编辑
   //============================================================
   public void setEditUpdate(Boolean value){
      _editUpdate = value;
   }

   //============================================================
   // <T>获得删除编辑的内容。</T>
   //
   // @return 删除编辑
   //============================================================
   public Boolean getEditDelete(){
      return _editDelete;
   }

   //============================================================
   // <T>设置删除编辑的内容。</T>
   //
   // @param value 删除编辑
   //============================================================
   public void setEditDelete(Boolean value){
      _editDelete = value;
   }

   //============================================================
   // <T>获得校验模式的内容。</T>
   //
   // @return 校验模式
   //============================================================
   public String getVerifyMode(){
      return _verifyMode;
   }

   //============================================================
   // <T>设置校验模式的内容。</T>
   //
   // @param value 校验模式
   //============================================================
   public void setVerifyMode(String value){
      _verifyMode = value;
   }

   //============================================================
   // <T>获得新建检查的内容。</T>
   //
   // @return 新建检查
   //============================================================
   public Boolean getVerifyInsert(){
      return _verifyInsert;
   }

   //============================================================
   // <T>设置新建检查的内容。</T>
   //
   // @param value 新建检查
   //============================================================
   public void setVerifyInsert(Boolean value){
      _verifyInsert = value;
   }

   //============================================================
   // <T>获得编辑检查的内容。</T>
   //
   // @return 编辑检查
   //============================================================
   public Boolean getVerifyUpdate(){
      return _verifyUpdate;
   }

   //============================================================
   // <T>设置编辑检查的内容。</T>
   //
   // @param value 编辑检查
   //============================================================
   public void setVerifyUpdate(Boolean value){
      _verifyUpdate = value;
   }

   //============================================================
   // <T>获得删除检查的内容。</T>
   //
   // @return 删除检查
   //============================================================
   public Boolean getVerifyDelete(){
      return _verifyDelete;
   }

   //============================================================
   // <T>设置删除检查的内容。</T>
   //
   // @param value 删除检查
   //============================================================
   public void setVerifyDelete(Boolean value){
      _verifyDelete = value;
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

}
