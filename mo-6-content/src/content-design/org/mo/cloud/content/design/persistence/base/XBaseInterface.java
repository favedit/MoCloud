package org.mo.cloud.content.design.persistence.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>接口对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseInterface extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Interface";

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

   // 继承集合的定义
   @AContentField
   public final static FContentField INHERITS = new FContentField("inherits", "inherits", EContentData.String, "", "", "", "YYNY");

   // 实装类名的定义
   @AContentField
   public final static FContentField CLASS_NAME = new FContentField("className", "class_name", EContentData.String, "", "", "", "YYNY");

   // 代码路径的定义
   @AContentField
   public final static FContentField SOURCE_PATH = new FContentField("sourcePath", "source_path", EContentData.String, "", "", "", "YYNY");

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

   // 继承集合
   @AName("inherits")
   protected String _inherits;

   // 实装类名
   @AName("class_name")
   protected String _className;

   // 代码路径
   @AName("source_path")
   protected String _sourcePath;

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
   // <T>获得继承集合的内容。</T>
   //
   // @return 继承集合
   //============================================================
   public String getInherits(){
      return _inherits;
   }

   //============================================================
   // <T>设置继承集合的内容。</T>
   //
   // @param value 继承集合
   //============================================================
   public void setInherits(String value){
      _inherits = value;
   }

   //============================================================
   // <T>获得实装类名的内容。</T>
   //
   // @return 实装类名
   //============================================================
   public String getClassName(){
      return _className;
   }

   //============================================================
   // <T>设置实装类名的内容。</T>
   //
   // @param value 实装类名
   //============================================================
   public void setClassName(String value){
      _className = value;
   }

   //============================================================
   // <T>获得代码路径的内容。</T>
   //
   // @return 代码路径
   //============================================================
   public String getSourcePath(){
      return _sourcePath;
   }

   //============================================================
   // <T>设置代码路径的内容。</T>
   //
   // @param value 代码路径
   //============================================================
   public void setSourcePath(String value){
      _sourcePath = value;
   }

}