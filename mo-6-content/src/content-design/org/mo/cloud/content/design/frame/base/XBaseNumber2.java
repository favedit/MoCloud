package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>数字2编辑框对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseNumber2
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Number2";

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

   // 最小值的定义
   @AContentField
   public final static FContentField VALUE_MIN = new FContentField("valueMin", "value_min", EContentData.String, "", "", "", "YYNY");

   // 最大值的定义
   @AContentField
   public final static FContentField VALUE_MAX = new FContentField("valueMax", "value_max", EContentData.String, "", "", "", "YYNY");

   // 值精度的定义
   @AContentField
   public final static FContentField VALUE_PRECISION = new FContentField("valuePrecision", "value_precision", EContentData.String, "", "", "", "YYNY");

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

   // 最小值
   @AName("value_min")
   protected String _valueMin;

   // 最大值
   @AName("value_max")
   protected String _valueMax;

   // 值精度
   @AName("value_precision")
   protected String _valuePrecision;

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
   // <T>获得最小值的内容。</T>
   //
   // @return 最小值
   //============================================================
   public String getValueMin(){
      return _valueMin;
   }

   //============================================================
   // <T>设置最小值的内容。</T>
   //
   // @param value 最小值
   //============================================================
   public void setValueMin(String value){
      _valueMin = value;
   }

   //============================================================
   // <T>获得最大值的内容。</T>
   //
   // @return 最大值
   //============================================================
   public String getValueMax(){
      return _valueMax;
   }

   //============================================================
   // <T>设置最大值的内容。</T>
   //
   // @param value 最大值
   //============================================================
   public void setValueMax(String value){
      _valueMax = value;
   }

   //============================================================
   // <T>获得值精度的内容。</T>
   //
   // @return 值精度
   //============================================================
   public String getValuePrecision(){
      return _valuePrecision;
   }

   //============================================================
   // <T>设置值精度的内容。</T>
   //
   // @param value 值精度
   //============================================================
   public void setValuePrecision(String value){
      _valuePrecision = value;
   }

}
