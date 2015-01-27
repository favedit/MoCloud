package org.mo.cloud.design.core.tree.base;

import org.mo.com.lang.face.AName;
import org.mo.cloud.design.core.configuration.FContentField;
import org.mo.cloud.design.core.configuration.XContentObject;

//============================================================
// <T>目录分列对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseTreeColumn extends XContentObject
{
   // 组件名称
   public static final String NAME = "TreeColumn";

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 有效性的定义
   public final static FContentField FieldIsValid = new FContentField("is_valid");

   // 备注的定义
   public final static FContentField FieldNote = new FContentField("note");

   // 图标的定义
   public final static FContentField FieldIcon = new FContentField("icon");

   // 数据名称的定义
   public final static FContentField FieldDataName = new FContentField("data_name");

   // 宽度的定义
   public final static FContentField FieldWidth = new FContentField("width");

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

   // 标签
   @AName("label")
   protected String _label;

   // 有效性
   @AName("is_valid")
   protected String _isValid;

   // 备注
   @AName("note")
   protected String _note;

   // 图标
   @AName("icon")
   protected String _icon;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 宽度
   @AName("width")
   protected String _width;

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
   // <T>获得有效性的内容。</T>
   //
   // @return 有效性
   //============================================================
   public String getIsValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setIsValid(String value){
      _isValid = value;
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
   // <T>获得图标的内容。</T>
   //
   // @return 图标
   //============================================================
   public String getIcon(){
      return _icon;
   }

   //============================================================
   // <T>设置图标的内容。</T>
   //
   // @param value 图标
   //============================================================
   public void setIcon(String value){
      _icon = value;
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
   // <T>获得宽度的内容。</T>
   //
   // @return 宽度
   //============================================================
   public String getWidth(){
      return _width;
   }

   //============================================================
   // <T>设置宽度的内容。</T>
   //
   // @param value 宽度
   //============================================================
   public void setWidth(String value){
      _width = value;
   }

}