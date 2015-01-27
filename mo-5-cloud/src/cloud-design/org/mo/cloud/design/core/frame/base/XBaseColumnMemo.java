package org.mo.cloud.design.core.frame.base;

import org.mo.com.lang.face.AName;
import org.mo.cloud.design.core.configuration.FContentField;
import org.mo.cloud.design.core.configuration.XContentObject;

//============================================================
// <T>表格多行文本框列对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseColumnMemo extends XContentObject
{
   // 组件名称
   public static final String NAME = "ColumnMemo";

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 有效性的定义
   public final static FContentField FieldValid = new FContentField("valid");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 位置的定义
   public final static FContentField FieldLocation = new FContentField("location");

   // 尺寸的定义
   public final static FContentField FieldSize = new FContentField("size");

   // 内空白的定义
   public final static FContentField FieldPadding = new FContentField("padding");

   // 外空白的定义
   public final static FContentField FieldMargin = new FContentField("margin");

   // 数据名称的定义
   public final static FContentField FieldDataName = new FContentField("data_name");

   // 放大引用的定义
   public final static FContentField FieldZoomReference = new FContentField("zoom_reference");

   // 放大字段的定义
   public final static FContentField FieldZoomField = new FContentField("zoom_field");

   // 引用服务的定义
   public final static FContentField FieldLovService = new FContentField("lov_service");

   // 引用地址的定义
   public final static FContentField FieldLovReference = new FContentField("lov_reference");

   // 引用字段的定义
   public final static FContentField FieldLovFields = new FContentField("lov_fields");

   // 应用条件的定义
   public final static FContentField FieldLovWhere = new FContentField("lov_where");

   // 引用排序的定义
   public final static FContentField FieldLovOrder = new FContentField("lov_order");

   // 编辑大小写类型的定义
   public final static FContentField FieldEditCaseCd = new FContentField("edit_case_cd");

   // 编辑模板的定义
   public final static FContentField FieldEditPattern = new FContentField("edit_pattern");

   // 编辑长度的定义
   public final static FContentField FieldEditLength = new FContentField("edit_length");

   // 编辑自动完成的定义
   public final static FContentField FieldEditComplete = new FContentField("edit_complete");

   // 校验最小长度的定义
   public final static FContentField FieldValidLengthMin = new FContentField("valid_length_min");

   // 校验最大长度的定义
   public final static FContentField FieldValidLengthMax = new FContentField("valid_length_max");

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

   // 有效性
   @AName("valid")
   protected String _valid;

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

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 放大引用
   @AName("zoom_reference")
   protected String _zoomReference;

   // 放大字段
   @AName("zoom_field")
   protected String _zoomField;

   // 引用服务
   @AName("lov_service")
   protected String _lovService;

   // 引用地址
   @AName("lov_reference")
   protected String _lovReference;

   // 引用字段
   @AName("lov_fields")
   protected String _lovFields;

   // 应用条件
   @AName("lov_where")
   protected String _lovWhere;

   // 引用排序
   @AName("lov_order")
   protected String _lovOrder;

   // 编辑大小写类型
   @AName("edit_case_cd")
   protected String _editCaseCd;

   // 编辑模板
   @AName("edit_pattern")
   protected String _editPattern;

   // 编辑长度
   @AName("edit_length")
   protected String _editLength;

   // 编辑自动完成
   @AName("edit_complete")
   protected String _editComplete;

   // 校验最小长度
   @AName("valid_length_min")
   protected String _validLengthMin;

   // 校验最大长度
   @AName("valid_length_max")
   protected String _validLengthMax;

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
   public String getValid(){
      return _valid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setValid(String value){
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
   // <T>获得放大引用的内容。</T>
   //
   // @return 放大引用
   //============================================================
   public String getZoomReference(){
      return _zoomReference;
   }

   //============================================================
   // <T>设置放大引用的内容。</T>
   //
   // @param value 放大引用
   //============================================================
   public void setZoomReference(String value){
      _zoomReference = value;
   }

   //============================================================
   // <T>获得放大字段的内容。</T>
   //
   // @return 放大字段
   //============================================================
   public String getZoomField(){
      return _zoomField;
   }

   //============================================================
   // <T>设置放大字段的内容。</T>
   //
   // @param value 放大字段
   //============================================================
   public void setZoomField(String value){
      _zoomField = value;
   }

   //============================================================
   // <T>获得引用服务的内容。</T>
   //
   // @return 引用服务
   //============================================================
   public String getLovService(){
      return _lovService;
   }

   //============================================================
   // <T>设置引用服务的内容。</T>
   //
   // @param value 引用服务
   //============================================================
   public void setLovService(String value){
      _lovService = value;
   }

   //============================================================
   // <T>获得引用地址的内容。</T>
   //
   // @return 引用地址
   //============================================================
   public String getLovReference(){
      return _lovReference;
   }

   //============================================================
   // <T>设置引用地址的内容。</T>
   //
   // @param value 引用地址
   //============================================================
   public void setLovReference(String value){
      _lovReference = value;
   }

   //============================================================
   // <T>获得引用字段的内容。</T>
   //
   // @return 引用字段
   //============================================================
   public String getLovFields(){
      return _lovFields;
   }

   //============================================================
   // <T>设置引用字段的内容。</T>
   //
   // @param value 引用字段
   //============================================================
   public void setLovFields(String value){
      _lovFields = value;
   }

   //============================================================
   // <T>获得应用条件的内容。</T>
   //
   // @return 应用条件
   //============================================================
   public String getLovWhere(){
      return _lovWhere;
   }

   //============================================================
   // <T>设置应用条件的内容。</T>
   //
   // @param value 应用条件
   //============================================================
   public void setLovWhere(String value){
      _lovWhere = value;
   }

   //============================================================
   // <T>获得引用排序的内容。</T>
   //
   // @return 引用排序
   //============================================================
   public String getLovOrder(){
      return _lovOrder;
   }

   //============================================================
   // <T>设置引用排序的内容。</T>
   //
   // @param value 引用排序
   //============================================================
   public void setLovOrder(String value){
      _lovOrder = value;
   }

   //============================================================
   // <T>获得编辑大小写类型的内容。</T>
   //
   // @return 编辑大小写类型
   //============================================================
   public String getEditCaseCd(){
      return _editCaseCd;
   }

   //============================================================
   // <T>设置编辑大小写类型的内容。</T>
   //
   // @param value 编辑大小写类型
   //============================================================
   public void setEditCaseCd(String value){
      _editCaseCd = value;
   }

   //============================================================
   // <T>获得编辑模板的内容。</T>
   //
   // @return 编辑模板
   //============================================================
   public String getEditPattern(){
      return _editPattern;
   }

   //============================================================
   // <T>设置编辑模板的内容。</T>
   //
   // @param value 编辑模板
   //============================================================
   public void setEditPattern(String value){
      _editPattern = value;
   }

   //============================================================
   // <T>获得编辑长度的内容。</T>
   //
   // @return 编辑长度
   //============================================================
   public String getEditLength(){
      return _editLength;
   }

   //============================================================
   // <T>设置编辑长度的内容。</T>
   //
   // @param value 编辑长度
   //============================================================
   public void setEditLength(String value){
      _editLength = value;
   }

   //============================================================
   // <T>获得编辑自动完成的内容。</T>
   //
   // @return 编辑自动完成
   //============================================================
   public String getEditComplete(){
      return _editComplete;
   }

   //============================================================
   // <T>设置编辑自动完成的内容。</T>
   //
   // @param value 编辑自动完成
   //============================================================
   public void setEditComplete(String value){
      _editComplete = value;
   }

   //============================================================
   // <T>获得校验最小长度的内容。</T>
   //
   // @return 校验最小长度
   //============================================================
   public String getValidLengthMin(){
      return _validLengthMin;
   }

   //============================================================
   // <T>设置校验最小长度的内容。</T>
   //
   // @param value 校验最小长度
   //============================================================
   public void setValidLengthMin(String value){
      _validLengthMin = value;
   }

   //============================================================
   // <T>获得校验最大长度的内容。</T>
   //
   // @return 校验最大长度
   //============================================================
   public String getValidLengthMax(){
      return _validLengthMax;
   }

   //============================================================
   // <T>设置校验最大长度的内容。</T>
   //
   // @param value 校验最大长度
   //============================================================
   public void setValidLengthMax(String value){
      _validLengthMax = value;
   }

}