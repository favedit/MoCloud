package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>命令对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseAction
      extends XContentObject
{
   // 组件名称
   public static final String NAME = "Action";

   // 类名称的定义
   public final static FContentField FieldClassName = new FContentField("class_name");

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 有效性的定义
   public final static FContentField FieldValid = new FContentField("valid");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 服务的定义
   public final static FContentField FieldService = new FContentField("service");

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

   // 类名称
   @AName("class_name")
   protected String _className;

   // 名称
   @AName("name")
   protected String _name;

   // 有效性
   @AName("valid")
   protected boolean _valid;

   // 标签
   @AName("label")
   protected String _label;

   // 服务
   @AName("service")
   protected String _service;

   //============================================================
   // <T>获得类名称的内容。</T>
   //
   // @return 类名称
   //============================================================
   public String getClassName(){
      return _className;
   }

   //============================================================
   // <T>设置类名称的内容。</T>
   //
   // @param value 类名称
   //============================================================
   public void setClassName(String value){
      _className = value;
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
   // <T>获得服务的内容。</T>
   //
   // @return 服务
   //============================================================
   public String getService(){
      return _service;
   }

   //============================================================
   // <T>设置服务的内容。</T>
   //
   // @param value 服务
   //============================================================
   public void setService(String value){
      _service = value;
   }

}
