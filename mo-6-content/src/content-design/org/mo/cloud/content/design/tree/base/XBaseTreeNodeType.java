package org.mo.cloud.content.design.tree.base;

import org.mo.com.lang.face.AName;
import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;

//============================================================
// <T>节点类型对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseTreeNodeType extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "TreeNodeType";

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String, "", "", "", "YYNY");

   // 代码的定义
   @AContentField
   public final static FContentField CODE = new FContentField("code", "code", EContentData.String, "", "", "", "YYNY");

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String, "", "", "", "YYNY");

   // 有效性的定义
   @AContentField
   public final static FContentField IS_VALID = new FContentField("isValid", "is_valid", EContentData.Boolean, "", "", "", "YYNY");

   // 备注的定义
   @AContentField
   public final static FContentField NOTE = new FContentField("note", "note", EContentData.String, "", "", "", "YYNY");

   // 存储的定义
   @AContentField
   public final static FContentField STORAGE = new FContentField("storage", "storage", EContentData.String, "", "", "", "YYNY");

   // 图标的定义
   @AContentField
   public final static FContentField ICON = new FContentField("icon", "icon", EContentData.String, "", "", "", "YYNY");

   // 服务的定义
   @AContentField
   public final static FContentField SERVICE = new FContentField("service", "service", EContentData.String, "", "", "", "YYNY");

   // 命令的定义
   @AContentField
   public final static FContentField ACTION = new FContentField("action", "action", EContentData.String, "", "", "", "YYNY");

   // 属性集合的定义
   @AContentField
   public final static FContentField ATTRIBUTES = new FContentField("attributes", "attributes", EContentData.String, "", "", "", "YYNY");

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

   // 代码
   @AName("code")
   protected String _code;

   // 标签
   @AName("label")
   protected String _label;

   // 有效性
   @AName("is_valid")
   protected boolean _isValid;

   // 备注
   @AName("note")
   protected String _note;

   // 存储
   @AName("storage")
   protected String _storage;

   // 图标
   @AName("icon")
   protected String _icon;

   // 服务
   @AName("service")
   protected String _service;

   // 命令
   @AName("action")
   protected String _action;

   // 属性集合
   @AName("attributes")
   protected String _attributes;

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
   // <T>获得代码的内容。</T>
   //
   // @return 代码
   //============================================================
   public String getCode(){
      return _code;
   }

   //============================================================
   // <T>设置代码的内容。</T>
   //
   // @param value 代码
   //============================================================
   public void setCode(String value){
      _code = value;
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
   // <T>获得存储的内容。</T>
   //
   // @return 存储
   //============================================================
   public String getStorage(){
      return _storage;
   }

   //============================================================
   // <T>设置存储的内容。</T>
   //
   // @param value 存储
   //============================================================
   public void setStorage(String value){
      _storage = value;
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

   //============================================================
   // <T>获得命令的内容。</T>
   //
   // @return 命令
   //============================================================
   public String getAction(){
      return _action;
   }

   //============================================================
   // <T>设置命令的内容。</T>
   //
   // @param value 命令
   //============================================================
   public void setAction(String value){
      _action = value;
   }

   //============================================================
   // <T>获得属性集合的内容。</T>
   //
   // @return 属性集合
   //============================================================
   public String getAttributes(){
      return _attributes;
   }

   //============================================================
   // <T>设置属性集合的内容。</T>
   //
   // @param value 属性集合
   //============================================================
   public void setAttributes(String value){
      _attributes = value;
   }

}