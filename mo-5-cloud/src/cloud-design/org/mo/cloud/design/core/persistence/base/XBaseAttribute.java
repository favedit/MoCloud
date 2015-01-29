package org.mo.cloud.design.core.persistence.base;

import org.mo.cloud.design.core.configuration.FContentField;
import org.mo.cloud.design.core.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>属性对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseAttribute
      extends XContentObject
{
   // 组件名称
   public static final String NAME = "Attribute";

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

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

}
