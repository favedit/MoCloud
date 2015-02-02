package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>数字编辑框对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseNumber
      extends XContentObject
{
   // 类名称
   public static final String CLASS_NAME = "Number";

   // 类型的定义
   @AContentField
   public final static FContentField TYPE = new FContentField("type", "type", EContentData.String);

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String);

   // 有效性的定义
   @AContentField
   public final static FContentField VALID = new FContentField("valid", "valid", EContentData.Boolean);

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String);

   // 位置的定义
   @AContentField
   public final static FContentField LOCATION = new FContentField("location", "location", EContentData.String);

   // 尺寸的定义
   @AContentField
   public final static FContentField SIZE = new FContentField("size", "size", EContentData.String);

   // 内空白的定义
   @AContentField
   public final static FContentField PADDING = new FContentField("padding", "padding", EContentData.String);

   // 外空白的定义
   @AContentField
   public final static FContentField MARGIN = new FContentField("margin", "margin", EContentData.String);

   // 标签对齐的定义
   @AContentField
   public final static FContentField LABEL_ALIGN_CD = new FContentField("labelAlignCd", "label_align_cd", EContentData.String);

   // 标签尺寸的定义
   @AContentField
   public final static FContentField LABEL_SIZE = new FContentField("labelSize", "label_size", EContentData.String);

   // 编辑大小的定义
   @AContentField
   public final static FContentField EDIT_SIZE = new FContentField("editSize", "edit_size", EContentData.String);

   // 编辑只读的定义
   @AContentField
   public final static FContentField EDIT_READONLY = new FContentField("editReadonly", "edit_readonly", EContentData.Boolean);

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String);

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

   // 标签对齐
   @AName("label_align_cd")
   protected String _labelAlignCd;

   // 标签尺寸
   @AName("label_size")
   protected String _labelSize;

   // 编辑大小
   @AName("edit_size")
   protected String _editSize;

   // 编辑只读
   @AName("edit_readonly")
   protected boolean _editReadonly;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

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
   // <T>获得标签对齐的内容。</T>
   //
   // @return 标签对齐
   //============================================================
   public String getLabelAlignCd(){
      return _labelAlignCd;
   }

   //============================================================
   // <T>设置标签对齐的内容。</T>
   //
   // @param value 标签对齐
   //============================================================
   public void setLabelAlignCd(String value){
      _labelAlignCd = value;
   }

   //============================================================
   // <T>获得标签尺寸的内容。</T>
   //
   // @return 标签尺寸
   //============================================================
   public String getLabelSize(){
      return _labelSize;
   }

   //============================================================
   // <T>设置标签尺寸的内容。</T>
   //
   // @param value 标签尺寸
   //============================================================
   public void setLabelSize(String value){
      _labelSize = value;
   }

   //============================================================
   // <T>获得编辑大小的内容。</T>
   //
   // @return 编辑大小
   //============================================================
   public String getEditSize(){
      return _editSize;
   }

   //============================================================
   // <T>设置编辑大小的内容。</T>
   //
   // @param value 编辑大小
   //============================================================
   public void setEditSize(String value){
      _editSize = value;
   }

   //============================================================
   // <T>获得编辑只读的内容。</T>
   //
   // @return 编辑只读
   //============================================================
   public Boolean getEditReadonly(){
      return _editReadonly;
   }

   //============================================================
   // <T>设置编辑只读的内容。</T>
   //
   // @param value 编辑只读
   //============================================================
   public void setEditReadonly(Boolean value){
      _editReadonly = value;
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

}
