package org.mo.cloud.content.design.tree.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>目录层级对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseTreeLevel
      extends XContentObject
{
   // 类名称
   public static final String CLASS_NAME = "TreeLevel";

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String);

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String);

   // 有效性的定义
   @AContentField
   public final static FContentField IS_VALID = new FContentField("isValid", "is_valid", EContentData.String);

   // 备注的定义
   @AContentField
   public final static FContentField NOTE = new FContentField("note", "note", EContentData.String);

   // 编号的定义
   @AContentField
   public final static FContentField ID = new FContentField("id", "id", EContentData.String);

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

   // 编号
   @AName("id")
   protected String _id;

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
   // <T>获得编号的内容。</T>
   //
   // @return 编号
   //============================================================
   public String getId(){
      return _id;
   }

   //============================================================
   // <T>设置编号的内容。</T>
   //
   // @param value 编号
   //============================================================
   public void setId(String value){
      _id = value;
   }

}
