package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>复选框对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseCheck extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Check";

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

   // 属性集合的定义
   @AContentField
   public final static FContentField ATTRIBUTES = new FContentField("attributes", "attributes", EContentData.String, "", "", "", "YYNY");

   // 锚点类型的定义
   @AContentField
   public final static FContentField ANCHOR_CD = new FContentField("anchorCd", "anchor_cd", EContentData.String, "", "", "", "YYNY");

   // 回行类型的定义
   @AContentField
   public final static FContentField WRAP_CD = new FContentField("wrapCd", "wrap_cd", EContentData.String, "", "", "", "YYNY");

   // 停靠类型的定义
   @AContentField
   public final static FContentField DOCK_CD = new FContentField("dockCd", "dock_cd", EContentData.String, "", "", "", "YYNY");

   // 对齐方式的定义
   @AContentField
   public final static FContentField ALIGN_CD = new FContentField("alignCd", "align_cd", EContentData.String, "", "", "", "YYNY");

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

   // 内边框的定义
   @AContentField
   public final static FContentField BORDER_INNER = new FContentField("borderInner", "border_inner", EContentData.String, "", "", "", "YYNY");

   // 外边框的定义
   @AContentField
   public final static FContentField BORDER_OUTER = new FContentField("borderOuter", "border_outer", EContentData.String, "", "", "", "YYNY");

   // 前景颜色的定义
   @AContentField
   public final static FContentField FORE_COLOR = new FContentField("foreColor", "fore_color", EContentData.String, "", "", "", "YYNY");

   // 前景字体的定义
   @AContentField
   public final static FContentField FORE_FONT = new FContentField("foreFont", "fore_font", EContentData.String, "", "", "", "YYNY");

   // 前景资源的定义
   @AContentField
   public final static FContentField FORE_RESOURCE = new FContentField("foreResource", "fore_resource", EContentData.String, "", "", "", "YYNY");

   // 背景颜色的定义
   @AContentField
   public final static FContentField BACK_COLOR = new FContentField("backColor", "back_color", EContentData.String, "", "", "", "YYNY");

   // 背景字体的定义
   @AContentField
   public final static FContentField BACK_FONT = new FContentField("backFont", "back_font", EContentData.String, "", "", "", "YYNY");

   // 背景资源的定义
   @AContentField
   public final static FContentField BACK_RESOURCE = new FContentField("backResource", "back_resource", EContentData.String, "", "", "", "YYNY");

   // 背景分割的定义
   @AContentField
   public final static FContentField BACK_GRID = new FContentField("backGrid", "back_grid", EContentData.String, "", "", "", "YYNY");

   // 背景活动颜色的定义
   @AContentField
   public final static FContentField BACK_HOVER_COLOR = new FContentField("backHoverColor", "back_hover_color", EContentData.String, "", "", "", "YYNY");

   // 背景活动资源的定义
   @AContentField
   public final static FContentField BACK_HOVER_RESOURCE = new FContentField("backHoverResource", "back_hover_resource", EContentData.String, "", "", "", "YYNY");

   // 背景获得分割的定义
   @AContentField
   public final static FContentField BACK_HOVER_GRID = new FContentField("backHoverGrid", "back_hover_grid", EContentData.String, "", "", "", "YYNY");

   // 关联属性的定义
   @AContentField
   public final static FContentField LINKER = new FContentField("linker", "linker", EContentData.String, "", "", "", "YYNY");

   // 提示信息的定义
   @AContentField
   public final static FContentField HINT = new FContentField("hint", "hint", EContentData.String, "", "", "", "YYNY");

   // 显示模式的定义
   @AContentField
   public final static FContentField DISPLAY_MODE = new FContentField("displayMode", "display_mode", EContentData.String, "", "", "", "YYNN");

   // 查看显示的定义
   @AContentField
   public final static FContentField DISPLAY_VIEW = new FContentField("displayView", "display_view", EContentData.Boolean, "display_mode", "V", "Y", "YNNY");

   // 设计显示的定义
   @AContentField
   public final static FContentField DISPLAY_DESIGN = new FContentField("displayDesign", "display_design", EContentData.String, "display_mode", "G", "Y", "YNNY");

   // 搜索显示的定义
   @AContentField
   public final static FContentField DISPLAY_SEARCH = new FContentField("displaySearch", "display_search", EContentData.String, "display_mode", "S", "Y", "YNNY");

   // 新建显示的定义
   @AContentField
   public final static FContentField DISPLAY_INSERT = new FContentField("displayInsert", "display_insert", EContentData.Boolean, "display_mode", "I", "Y", "YNNY");

   // 更新显示的定义
   @AContentField
   public final static FContentField DISPLAY_UPDATE = new FContentField("displayUpdate", "display_update", EContentData.Boolean, "display_mode", "U", "Y", "YNNY");

   // 删除显示的定义
   @AContentField
   public final static FContentField DISPLAY_DELETE = new FContentField("displayDelete", "display_delete", EContentData.Boolean, "display_mode", "D", "Y", "YNNY");

   // 缩放显示的定义
   @AContentField
   public final static FContentField DISPLAY_ZOOM = new FContentField("displayZoom", "display_zoom", EContentData.Boolean, "display_mode", "Z", "Y", "YNNY");

   // 打印显示的定义
   @AContentField
   public final static FContentField DISPLAY_PRINT = new FContentField("displayPrint", "display_print", EContentData.Boolean, "display_mode", "project_id", "Y", "YNNY");

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

   // 标签对齐的定义
   @AContentField
   public final static FContentField LABEL_ALIGN_CD = new FContentField("labelAlignCd", "label_align_cd", EContentData.String, "", "", "", "YYNY");

   // 标签尺寸的定义
   @AContentField
   public final static FContentField LABEL_SIZE = new FContentField("labelSize", "label_size", EContentData.String, "", "", "", "YYNY");

   // 编辑尺寸的定义
   @AContentField
   public final static FContentField EDIT_SIZE = new FContentField("editSize", "edit_size", EContentData.String, "", "", "", "YYNY");

   // 数据必须的定义
   @AContentField
   public final static FContentField DATA_REQUIRE = new FContentField("dataRequire", "data_require", EContentData.Boolean, "", "", "", "YYNY");

   // 数据类型的定义
   @AContentField
   public final static FContentField DATA_TYPE_CD = new FContentField("dataTypeCd", "data_type_cd", EContentData.String, "", "", "", "YYNY");

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String, "", "", "", "YYNY");

   // 数据别称的定义
   @AContentField
   public final static FContentField DATA_ALIAS = new FContentField("dataAlias", "data_alias", EContentData.String, "", "", "", "YYNY");

   // 数据内容的定义
   @AContentField
   public final static FContentField DATA_VALUE = new FContentField("dataValue", "data_value", EContentData.String, "", "", "", "YYNY");

   // 数据默认的定义
   @AContentField
   public final static FContentField DATA_DEFAULT = new FContentField("dataDefault", "data_default", EContentData.String, "", "", "", "YYNY");

   // 数据来源的定义
   @AContentField
   public final static FContentField DATA_SOURCE = new FContentField("dataSource", "data_source", EContentData.String, "", "", "", "YYNY");

   // 真值的定义
   @AContentField
   public final static FContentField VALUE_TRUE = new FContentField("valueTrue", "value_true", EContentData.String, "", "", "", "YYNY");

   // 假值的定义
   @AContentField
   public final static FContentField VALUE_FALSE = new FContentField("valueFalse", "value_false", EContentData.String, "", "", "", "YYNY");

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

   // 属性集合
   @AName("attributes")
   protected String _attributes;

   // 锚点类型
   @AName("anchor_cd")
   protected String _anchorCd;

   // 回行类型
   @AName("wrap_cd")
   protected String _wrapCd;

   // 停靠类型
   @AName("dock_cd")
   protected String _dockCd;

   // 对齐方式
   @AName("align_cd")
   protected String _alignCd;

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

   // 内边框
   @AName("border_inner")
   protected String _borderInner;

   // 外边框
   @AName("border_outer")
   protected String _borderOuter;

   // 前景颜色
   @AName("fore_color")
   protected String _foreColor;

   // 前景字体
   @AName("fore_font")
   protected String _foreFont;

   // 前景资源
   @AName("fore_resource")
   protected String _foreResource;

   // 背景颜色
   @AName("back_color")
   protected String _backColor;

   // 背景字体
   @AName("back_font")
   protected String _backFont;

   // 背景资源
   @AName("back_resource")
   protected String _backResource;

   // 背景分割
   @AName("back_grid")
   protected String _backGrid;

   // 背景活动颜色
   @AName("back_hover_color")
   protected String _backHoverColor;

   // 背景活动资源
   @AName("back_hover_resource")
   protected String _backHoverResource;

   // 背景获得分割
   @AName("back_hover_grid")
   protected String _backHoverGrid;

   // 关联属性
   @AName("linker")
   protected String _linker;

   // 提示信息
   @AName("hint")
   protected String _hint;

   // 显示模式
   @AName("display_mode")
   protected String _displayMode;

   // 查看显示
   @AName("display_view")
   protected boolean _displayView;

   // 设计显示
   @AName("display_design")
   protected String _displayDesign;

   // 搜索显示
   @AName("display_search")
   protected String _displaySearch;

   // 新建显示
   @AName("display_insert")
   protected boolean _displayInsert;

   // 更新显示
   @AName("display_update")
   protected boolean _displayUpdate;

   // 删除显示
   @AName("display_delete")
   protected boolean _displayDelete;

   // 缩放显示
   @AName("display_zoom")
   protected boolean _displayZoom;

   // 打印显示
   @AName("display_print")
   protected boolean _displayPrint;

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

   // 标签对齐
   @AName("label_align_cd")
   protected String _labelAlignCd;

   // 标签尺寸
   @AName("label_size")
   protected String _labelSize;

   // 编辑尺寸
   @AName("edit_size")
   protected String _editSize;

   // 数据必须
   @AName("data_require")
   protected boolean _dataRequire;

   // 数据类型
   @AName("data_type_cd")
   protected String _dataTypeCd;

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 数据别称
   @AName("data_alias")
   protected String _dataAlias;

   // 数据内容
   @AName("data_value")
   protected String _dataValue;

   // 数据默认
   @AName("data_default")
   protected String _dataDefault;

   // 数据来源
   @AName("data_source")
   protected String _dataSource;

   // 真值
   @AName("value_true")
   protected String _valueTrue;

   // 假值
   @AName("value_false")
   protected String _valueFalse;

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

   //============================================================
   // <T>获得锚点类型的内容。</T>
   //
   // @return 锚点类型
   //============================================================
   public String getAnchorCd(){
      return _anchorCd;
   }

   //============================================================
   // <T>设置锚点类型的内容。</T>
   //
   // @param value 锚点类型
   //============================================================
   public void setAnchorCd(String value){
      _anchorCd = value;
   }

   //============================================================
   // <T>获得回行类型的内容。</T>
   //
   // @return 回行类型
   //============================================================
   public String getWrapCd(){
      return _wrapCd;
   }

   //============================================================
   // <T>设置回行类型的内容。</T>
   //
   // @param value 回行类型
   //============================================================
   public void setWrapCd(String value){
      _wrapCd = value;
   }

   //============================================================
   // <T>获得停靠类型的内容。</T>
   //
   // @return 停靠类型
   //============================================================
   public String getDockCd(){
      return _dockCd;
   }

   //============================================================
   // <T>设置停靠类型的内容。</T>
   //
   // @param value 停靠类型
   //============================================================
   public void setDockCd(String value){
      _dockCd = value;
   }

   //============================================================
   // <T>获得对齐方式的内容。</T>
   //
   // @return 对齐方式
   //============================================================
   public String getAlignCd(){
      return _alignCd;
   }

   //============================================================
   // <T>设置对齐方式的内容。</T>
   //
   // @param value 对齐方式
   //============================================================
   public void setAlignCd(String value){
      _alignCd = value;
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
   // <T>获得内边框的内容。</T>
   //
   // @return 内边框
   //============================================================
   public String getBorderInner(){
      return _borderInner;
   }

   //============================================================
   // <T>设置内边框的内容。</T>
   //
   // @param value 内边框
   //============================================================
   public void setBorderInner(String value){
      _borderInner = value;
   }

   //============================================================
   // <T>获得外边框的内容。</T>
   //
   // @return 外边框
   //============================================================
   public String getBorderOuter(){
      return _borderOuter;
   }

   //============================================================
   // <T>设置外边框的内容。</T>
   //
   // @param value 外边框
   //============================================================
   public void setBorderOuter(String value){
      _borderOuter = value;
   }

   //============================================================
   // <T>获得前景颜色的内容。</T>
   //
   // @return 前景颜色
   //============================================================
   public String getForeColor(){
      return _foreColor;
   }

   //============================================================
   // <T>设置前景颜色的内容。</T>
   //
   // @param value 前景颜色
   //============================================================
   public void setForeColor(String value){
      _foreColor = value;
   }

   //============================================================
   // <T>获得前景字体的内容。</T>
   //
   // @return 前景字体
   //============================================================
   public String getForeFont(){
      return _foreFont;
   }

   //============================================================
   // <T>设置前景字体的内容。</T>
   //
   // @param value 前景字体
   //============================================================
   public void setForeFont(String value){
      _foreFont = value;
   }

   //============================================================
   // <T>获得前景资源的内容。</T>
   //
   // @return 前景资源
   //============================================================
   public String getForeResource(){
      return _foreResource;
   }

   //============================================================
   // <T>设置前景资源的内容。</T>
   //
   // @param value 前景资源
   //============================================================
   public void setForeResource(String value){
      _foreResource = value;
   }

   //============================================================
   // <T>获得背景颜色的内容。</T>
   //
   // @return 背景颜色
   //============================================================
   public String getBackColor(){
      return _backColor;
   }

   //============================================================
   // <T>设置背景颜色的内容。</T>
   //
   // @param value 背景颜色
   //============================================================
   public void setBackColor(String value){
      _backColor = value;
   }

   //============================================================
   // <T>获得背景字体的内容。</T>
   //
   // @return 背景字体
   //============================================================
   public String getBackFont(){
      return _backFont;
   }

   //============================================================
   // <T>设置背景字体的内容。</T>
   //
   // @param value 背景字体
   //============================================================
   public void setBackFont(String value){
      _backFont = value;
   }

   //============================================================
   // <T>获得背景资源的内容。</T>
   //
   // @return 背景资源
   //============================================================
   public String getBackResource(){
      return _backResource;
   }

   //============================================================
   // <T>设置背景资源的内容。</T>
   //
   // @param value 背景资源
   //============================================================
   public void setBackResource(String value){
      _backResource = value;
   }

   //============================================================
   // <T>获得背景分割的内容。</T>
   //
   // @return 背景分割
   //============================================================
   public String getBackGrid(){
      return _backGrid;
   }

   //============================================================
   // <T>设置背景分割的内容。</T>
   //
   // @param value 背景分割
   //============================================================
   public void setBackGrid(String value){
      _backGrid = value;
   }

   //============================================================
   // <T>获得背景活动颜色的内容。</T>
   //
   // @return 背景活动颜色
   //============================================================
   public String getBackHoverColor(){
      return _backHoverColor;
   }

   //============================================================
   // <T>设置背景活动颜色的内容。</T>
   //
   // @param value 背景活动颜色
   //============================================================
   public void setBackHoverColor(String value){
      _backHoverColor = value;
   }

   //============================================================
   // <T>获得背景活动资源的内容。</T>
   //
   // @return 背景活动资源
   //============================================================
   public String getBackHoverResource(){
      return _backHoverResource;
   }

   //============================================================
   // <T>设置背景活动资源的内容。</T>
   //
   // @param value 背景活动资源
   //============================================================
   public void setBackHoverResource(String value){
      _backHoverResource = value;
   }

   //============================================================
   // <T>获得背景获得分割的内容。</T>
   //
   // @return 背景获得分割
   //============================================================
   public String getBackHoverGrid(){
      return _backHoverGrid;
   }

   //============================================================
   // <T>设置背景获得分割的内容。</T>
   //
   // @param value 背景获得分割
   //============================================================
   public void setBackHoverGrid(String value){
      _backHoverGrid = value;
   }

   //============================================================
   // <T>获得关联属性的内容。</T>
   //
   // @return 关联属性
   //============================================================
   public String getLinker(){
      return _linker;
   }

   //============================================================
   // <T>设置关联属性的内容。</T>
   //
   // @param value 关联属性
   //============================================================
   public void setLinker(String value){
      _linker = value;
   }

   //============================================================
   // <T>获得提示信息的内容。</T>
   //
   // @return 提示信息
   //============================================================
   public String getHint(){
      return _hint;
   }

   //============================================================
   // <T>设置提示信息的内容。</T>
   //
   // @param value 提示信息
   //============================================================
   public void setHint(String value){
      _hint = value;
   }

   //============================================================
   // <T>获得显示模式的内容。</T>
   //
   // @return 显示模式
   //============================================================
   public String getDisplayMode(){
      return _displayMode;
   }

   //============================================================
   // <T>设置显示模式的内容。</T>
   //
   // @param value 显示模式
   //============================================================
   public void setDisplayMode(String value){
      _displayMode = value;
   }

   //============================================================
   // <T>获得查看显示的内容。</T>
   //
   // @return 查看显示
   //============================================================
   public Boolean getDisplayView(){
      return _displayView;
   }

   //============================================================
   // <T>设置查看显示的内容。</T>
   //
   // @param value 查看显示
   //============================================================
   public void setDisplayView(Boolean value){
      _displayView = value;
   }

   //============================================================
   // <T>获得设计显示的内容。</T>
   //
   // @return 设计显示
   //============================================================
   public String getDisplayDesign(){
      return _displayDesign;
   }

   //============================================================
   // <T>设置设计显示的内容。</T>
   //
   // @param value 设计显示
   //============================================================
   public void setDisplayDesign(String value){
      _displayDesign = value;
   }

   //============================================================
   // <T>获得搜索显示的内容。</T>
   //
   // @return 搜索显示
   //============================================================
   public String getDisplaySearch(){
      return _displaySearch;
   }

   //============================================================
   // <T>设置搜索显示的内容。</T>
   //
   // @param value 搜索显示
   //============================================================
   public void setDisplaySearch(String value){
      _displaySearch = value;
   }

   //============================================================
   // <T>获得新建显示的内容。</T>
   //
   // @return 新建显示
   //============================================================
   public Boolean getDisplayInsert(){
      return _displayInsert;
   }

   //============================================================
   // <T>设置新建显示的内容。</T>
   //
   // @param value 新建显示
   //============================================================
   public void setDisplayInsert(Boolean value){
      _displayInsert = value;
   }

   //============================================================
   // <T>获得更新显示的内容。</T>
   //
   // @return 更新显示
   //============================================================
   public Boolean getDisplayUpdate(){
      return _displayUpdate;
   }

   //============================================================
   // <T>设置更新显示的内容。</T>
   //
   // @param value 更新显示
   //============================================================
   public void setDisplayUpdate(Boolean value){
      _displayUpdate = value;
   }

   //============================================================
   // <T>获得删除显示的内容。</T>
   //
   // @return 删除显示
   //============================================================
   public Boolean getDisplayDelete(){
      return _displayDelete;
   }

   //============================================================
   // <T>设置删除显示的内容。</T>
   //
   // @param value 删除显示
   //============================================================
   public void setDisplayDelete(Boolean value){
      _displayDelete = value;
   }

   //============================================================
   // <T>获得缩放显示的内容。</T>
   //
   // @return 缩放显示
   //============================================================
   public Boolean getDisplayZoom(){
      return _displayZoom;
   }

   //============================================================
   // <T>设置缩放显示的内容。</T>
   //
   // @param value 缩放显示
   //============================================================
   public void setDisplayZoom(Boolean value){
      _displayZoom = value;
   }

   //============================================================
   // <T>获得打印显示的内容。</T>
   //
   // @return 打印显示
   //============================================================
   public Boolean getDisplayPrint(){
      return _displayPrint;
   }

   //============================================================
   // <T>设置打印显示的内容。</T>
   //
   // @param value 打印显示
   //============================================================
   public void setDisplayPrint(Boolean value){
      _displayPrint = value;
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
   // <T>获得编辑尺寸的内容。</T>
   //
   // @return 编辑尺寸
   //============================================================
   public String getEditSize(){
      return _editSize;
   }

   //============================================================
   // <T>设置编辑尺寸的内容。</T>
   //
   // @param value 编辑尺寸
   //============================================================
   public void setEditSize(String value){
      _editSize = value;
   }

   //============================================================
   // <T>获得数据必须的内容。</T>
   //
   // @return 数据必须
   //============================================================
   public Boolean getDataRequire(){
      return _dataRequire;
   }

   //============================================================
   // <T>设置数据必须的内容。</T>
   //
   // @param value 数据必须
   //============================================================
   public void setDataRequire(Boolean value){
      _dataRequire = value;
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
   // <T>获得数据别称的内容。</T>
   //
   // @return 数据别称
   //============================================================
   public String getDataAlias(){
      return _dataAlias;
   }

   //============================================================
   // <T>设置数据别称的内容。</T>
   //
   // @param value 数据别称
   //============================================================
   public void setDataAlias(String value){
      _dataAlias = value;
   }

   //============================================================
   // <T>获得数据内容的内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String getDataValue(){
      return _dataValue;
   }

   //============================================================
   // <T>设置数据内容的内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDataValue(String value){
      _dataValue = value;
   }

   //============================================================
   // <T>获得数据默认的内容。</T>
   //
   // @return 数据默认
   //============================================================
   public String getDataDefault(){
      return _dataDefault;
   }

   //============================================================
   // <T>设置数据默认的内容。</T>
   //
   // @param value 数据默认
   //============================================================
   public void setDataDefault(String value){
      _dataDefault = value;
   }

   //============================================================
   // <T>获得数据来源的内容。</T>
   //
   // @return 数据来源
   //============================================================
   public String getDataSource(){
      return _dataSource;
   }

   //============================================================
   // <T>设置数据来源的内容。</T>
   //
   // @param value 数据来源
   //============================================================
   public void setDataSource(String value){
      _dataSource = value;
   }

   //============================================================
   // <T>获得真值的内容。</T>
   //
   // @return 真值
   //============================================================
   public String getValueTrue(){
      return _valueTrue;
   }

   //============================================================
   // <T>设置真值的内容。</T>
   //
   // @param value 真值
   //============================================================
   public void setValueTrue(String value){
      _valueTrue = value;
   }

   //============================================================
   // <T>获得假值的内容。</T>
   //
   // @return 假值
   //============================================================
   public String getValueFalse(){
      return _valueFalse;
   }

   //============================================================
   // <T>设置假值的内容。</T>
   //
   // @param value 假值
   //============================================================
   public void setValueFalse(String value){
      _valueFalse = value;
   }

}