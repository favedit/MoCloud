package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>工具编辑按键对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseToolButtonEdit
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "ToolButtonEdit";

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

   // 回行类型的定义
   @AContentField
   public final static FContentField WRAP_CD = new FContentField("wrapCd", "wrap_cd", EContentData.String, "", "", "", "YYNY");

   // 停靠类型的定义
   @AContentField
   public final static FContentField DOCK_CD = new FContentField("dockCd", "dock_cd", EContentData.String, "", "", "", "YYNY");

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

   // 背景颜色的定义
   @AContentField
   public final static FContentField BACK_COLOR = new FContentField("backColor", "back_color", EContentData.String, "", "", "", "YYNY");

   // 背景资源的定义
   @AContentField
   public final static FContentField BACK_RESOURCE = new FContentField("backResource", "back_resource", EContentData.String, "", "", "", "YYNY");

   // 背景分割的定义
   @AContentField
   public final static FContentField BACK_GRID = new FContentField("backGrid", "back_grid", EContentData.String, "", "", "", "YYNY");

   // 关联属性的定义
   @AContentField
   public final static FContentField LINKER = new FContentField("linker", "linker", EContentData.String, "", "", "", "YYNY");

   // 提示信息的定义
   @AContentField
   public final static FContentField HINT = new FContentField("hint", "hint", EContentData.String, "", "", "", "YYNY");

   // 图标的定义
   @AContentField
   public final static FContentField ICON = new FContentField("icon", "icon", EContentData.String, "", "", "", "YYNY");

   // 禁止图标的定义
   @AContentField
   public final static FContentField ICON_DISABLE = new FContentField("iconDisable", "icon_disable", EContentData.String, "", "", "", "YYNY");

   // 热键的定义
   @AContentField
   public final static FContentField HOTKEY = new FContentField("hotkey", "hotkey", EContentData.String, "", "", "", "YYNY");

   // 命令的定义
   @AContentField
   public final static FContentField ACTION = new FContentField("action", "action", EContentData.String, "", "", "", "YYNY");

   // 放大引用的定义
   @AContentField
   public final static FContentField ZOOM_REFERENCE = new FContentField("zoomReference", "zoom_reference", EContentData.String, "", "", "", "YYNY");

   // 放大字段的定义
   @AContentField
   public final static FContentField ZOOM_FIELD = new FContentField("zoomField", "zoom_field", EContentData.String, "", "", "", "YYNY");

   // 引用服务的定义
   @AContentField
   public final static FContentField LOV_SERVICE = new FContentField("lovService", "lov_service", EContentData.String, "", "", "", "YYNY");

   // 引用地址的定义
   @AContentField
   public final static FContentField LOV_REFERENCE = new FContentField("lovReference", "lov_reference", EContentData.String, "", "", "", "YYNY");

   // 引用字段的定义
   @AContentField
   public final static FContentField LOV_FIELDS = new FContentField("lovFields", "lov_fields", EContentData.String, "", "", "", "YYNY");

   // 应用条件的定义
   @AContentField
   public final static FContentField LOV_WHERE = new FContentField("lovWhere", "lov_where", EContentData.String, "", "", "", "YYNY");

   // 引用排序的定义
   @AContentField
   public final static FContentField LOV_ORDER = new FContentField("lovOrder", "lov_order", EContentData.String, "", "", "", "YYNY");

   // 编辑长度的定义
   @AContentField
   public final static FContentField EDIT_LENGTH = new FContentField("editLength", "edit_length", EContentData.String, "", "", "", "YYNY");

   // 编辑对齐方式的定义
   @AContentField
   public final static FContentField EDIT_ALIGN_CD = new FContentField("editAlignCd", "edit_align_cd", EContentData.String, "", "", "", "YYNY");

   // 编辑大小写类型的定义
   @AContentField
   public final static FContentField EDIT_CASE_CD = new FContentField("editCaseCd", "edit_case_cd", EContentData.String, "", "", "", "YYNY");

   // 编辑模板的定义
   @AContentField
   public final static FContentField EDIT_PATTERN = new FContentField("editPattern", "edit_pattern", EContentData.String, "", "", "", "YYNY");

   // 编辑自动完成的定义
   @AContentField
   public final static FContentField EDIT_COMPLETE = new FContentField("editComplete", "edit_complete", EContentData.String, "", "", "", "YYNY");

   // 校验最小长度的定义
   @AContentField
   public final static FContentField VALID_LENGTH_MIN = new FContentField("validLengthMin", "valid_length_min", EContentData.String, "", "", "", "YYNY");

   // 校验最大长度的定义
   @AContentField
   public final static FContentField VALID_LENGTH_MAX = new FContentField("validLengthMax", "valid_length_max", EContentData.String, "", "", "", "YYNY");

   // 编辑大小的定义
   @AContentField
   public final static FContentField EDIT_SIZE = new FContentField("editSize", "edit_size", EContentData.String, "", "", "", "YYNY");

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

   // 回行类型
   @AName("wrap_cd")
   protected String _wrapCd;

   // 停靠类型
   @AName("dock_cd")
   protected String _dockCd;

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

   // 背景颜色
   @AName("back_color")
   protected String _backColor;

   // 背景资源
   @AName("back_resource")
   protected String _backResource;

   // 背景分割
   @AName("back_grid")
   protected String _backGrid;

   // 关联属性
   @AName("linker")
   protected String _linker;

   // 提示信息
   @AName("hint")
   protected String _hint;

   // 图标
   @AName("icon")
   protected String _icon;

   // 禁止图标
   @AName("icon_disable")
   protected String _iconDisable;

   // 热键
   @AName("hotkey")
   protected String _hotkey;

   // 命令
   @AName("action")
   protected String _action;

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

   // 编辑长度
   @AName("edit_length")
   protected String _editLength;

   // 编辑对齐方式
   @AName("edit_align_cd")
   protected String _editAlignCd;

   // 编辑大小写类型
   @AName("edit_case_cd")
   protected String _editCaseCd;

   // 编辑模板
   @AName("edit_pattern")
   protected String _editPattern;

   // 编辑自动完成
   @AName("edit_complete")
   protected String _editComplete;

   // 校验最小长度
   @AName("valid_length_min")
   protected String _validLengthMin;

   // 校验最大长度
   @AName("valid_length_max")
   protected String _validLengthMax;

   // 编辑大小
   @AName("edit_size")
   protected String _editSize;

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
   // <T>获得禁止图标的内容。</T>
   //
   // @return 禁止图标
   //============================================================
   public String getIconDisable(){
      return _iconDisable;
   }

   //============================================================
   // <T>设置禁止图标的内容。</T>
   //
   // @param value 禁止图标
   //============================================================
   public void setIconDisable(String value){
      _iconDisable = value;
   }

   //============================================================
   // <T>获得热键的内容。</T>
   //
   // @return 热键
   //============================================================
   public String getHotkey(){
      return _hotkey;
   }

   //============================================================
   // <T>设置热键的内容。</T>
   //
   // @param value 热键
   //============================================================
   public void setHotkey(String value){
      _hotkey = value;
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
   // <T>获得编辑对齐方式的内容。</T>
   //
   // @return 编辑对齐方式
   //============================================================
   public String getEditAlignCd(){
      return _editAlignCd;
   }

   //============================================================
   // <T>设置编辑对齐方式的内容。</T>
   //
   // @param value 编辑对齐方式
   //============================================================
   public void setEditAlignCd(String value){
      _editAlignCd = value;
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

}
