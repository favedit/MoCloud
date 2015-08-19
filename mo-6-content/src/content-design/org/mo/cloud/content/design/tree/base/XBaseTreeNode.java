package org.mo.cloud.content.design.tree.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>节点对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseTreeNode extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "TreeNode";

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

   // 类型分组的定义
   @AContentField
   public final static FContentField TYPE_GROUP = new FContentField("typeGroup", "type_group", EContentData.String, "", "", "", "YYNY");

   // 类型代码的定义
   @AContentField
   public final static FContentField TYPE_CODE = new FContentField("typeCode", "type_code", EContentData.String, "", "", "", "YYNY");

   // 含有子节点的定义
   @AContentField
   public final static FContentField HAS_CHILD = new FContentField("hasChild", "has_child", EContentData.Boolean, "", "", "", "YYNY");

   // 唯一编号的定义
   @AContentField
   public final static FContentField GUID = new FContentField("guid", "guid", EContentData.String, "", "", "", "YYNY");

   // 图标的定义
   @AContentField
   public final static FContentField ICON = new FContentField("icon", "icon", EContentData.String, "", "", "", "YYNY");

   // 颜色的定义
   @AContentField
   public final static FContentField COLOR = new FContentField("color", "color", EContentData.Boolean, "", "", "", "YYNY");

   // 是否选中的定义
   @AContentField
   public final static FContentField CHECKED = new FContentField("checked", "checked", EContentData.String, "", "", "", "YYNY");

   // 是否展开的定义
   @AContentField
   public final static FContentField EXTENDED = new FContentField("extended", "extended", EContentData.String, "", "", "", "YYNY");

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

   // 类型分组
   @AName("type_group")
   protected String _typeGroup;

   // 类型代码
   @AName("type_code")
   protected String _typeCode;

   // 含有子节点
   @AName("has_child")
   protected boolean _hasChild;

   // 唯一编号
   @AName("guid")
   protected String _guid;

   // 图标
   @AName("icon")
   protected String _icon;

   // 颜色
   @AName("color")
   protected boolean _color;

   // 是否选中
   @AName("checked")
   protected String _checked;

   // 是否展开
   @AName("extended")
   protected String _extended;

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
   // <T>获得类型分组的内容。</T>
   //
   // @return 类型分组
   //============================================================
   public String getTypeGroup(){
      return _typeGroup;
   }

   //============================================================
   // <T>设置类型分组的内容。</T>
   //
   // @param value 类型分组
   //============================================================
   public void setTypeGroup(String value){
      _typeGroup = value;
   }

   //============================================================
   // <T>获得类型代码的内容。</T>
   //
   // @return 类型代码
   //============================================================
   public String getTypeCode(){
      return _typeCode;
   }

   //============================================================
   // <T>设置类型代码的内容。</T>
   //
   // @param value 类型代码
   //============================================================
   public void setTypeCode(String value){
      _typeCode = value;
   }

   //============================================================
   // <T>获得含有子节点的内容。</T>
   //
   // @return 含有子节点
   //============================================================
   public Boolean getHasChild(){
      return _hasChild;
   }

   //============================================================
   // <T>设置含有子节点的内容。</T>
   //
   // @param value 含有子节点
   //============================================================
   public void setHasChild(Boolean value){
      _hasChild = value;
   }

   //============================================================
   // <T>获得唯一编号的内容。</T>
   //
   // @return 唯一编号
   //============================================================
   public String getGuid(){
      return _guid;
   }

   //============================================================
   // <T>设置唯一编号的内容。</T>
   //
   // @param value 唯一编号
   //============================================================
   public void setGuid(String value){
      _guid = value;
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
   // <T>获得颜色的内容。</T>
   //
   // @return 颜色
   //============================================================
   public Boolean getColor(){
      return _color;
   }

   //============================================================
   // <T>设置颜色的内容。</T>
   //
   // @param value 颜色
   //============================================================
   public void setColor(Boolean value){
      _color = value;
   }

   //============================================================
   // <T>获得是否选中的内容。</T>
   //
   // @return 是否选中
   //============================================================
   public String getChecked(){
      return _checked;
   }

   //============================================================
   // <T>设置是否选中的内容。</T>
   //
   // @param value 是否选中
   //============================================================
   public void setChecked(String value){
      _checked = value;
   }

   //============================================================
   // <T>获得是否展开的内容。</T>
   //
   // @return 是否展开
   //============================================================
   public String getExtended(){
      return _extended;
   }

   //============================================================
   // <T>设置是否展开的内容。</T>
   //
   // @param value 是否展开
   //============================================================
   public void setExtended(String value){
      _extended = value;
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