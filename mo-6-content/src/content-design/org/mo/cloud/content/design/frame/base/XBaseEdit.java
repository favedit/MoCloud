package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>文本编辑框对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseEdit
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Edit";

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

   // 显示模式的定义
   @AContentField
   public final static FContentField DISPLAY_MODE = new FContentField("displayMode", "display_mode", EContentData.String, "", "", "", "NYNN");

   // 查看显示的定义
   @AContentField
   public final static FContentField DISPLAY_VIEW = new FContentField("displayView", "display_view", EContentData.Boolean, "display_mode", "V", "Y", "YNNY");

   // 新建显示的定义
   @AContentField
   public final static FContentField DISPLAY_INSERT = new FContentField("displayInsert", "display_insert", EContentData.Boolean, "display_mode", "I", "Y", "YNNY");

   // 更新显示的定义
   @AContentField
   public final static FContentField DISPLAY_UPDATE = new FContentField("displayUpdate", "display_update", EContentData.Boolean, "display_mode", "U", "Y", "YNNY");

   // 删除显示的定义
   @AContentField
   public final static FContentField DISPLAY_DELETE = new FContentField("displayDelete", "display_delete", EContentData.Boolean, "display_mode", "D", "Y", "YNNY");

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

   // 数据名称的定义
   @AContentField
   public final static FContentField DATA_NAME = new FContentField("dataName", "data_name", EContentData.String, "", "", "", "YYNY");

   // 数据类型的定义
   @AContentField
   public final static FContentField DATA_TYPE_CD = new FContentField("dataTypeCd", "data_type_cd", EContentData.String, "", "", "", "YYNY");

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

   // 编辑大小写类型的定义
   @AContentField
   public final static FContentField EDIT_CASE_CD = new FContentField("editCaseCd", "edit_case_cd", EContentData.String, "", "", "", "YYNY");

   // 编辑模板的定义
   @AContentField
   public final static FContentField EDIT_PATTERN = new FContentField("editPattern", "edit_pattern", EContentData.String, "", "", "", "YYNY");

   // 编辑长度的定义
   @AContentField
   public final static FContentField EDIT_LENGTH = new FContentField("editLength", "edit_length", EContentData.String, "", "", "", "YYNY");

   // 编辑自动完成的定义
   @AContentField
   public final static FContentField EDIT_COMPLETE = new FContentField("editComplete", "edit_complete", EContentData.String, "", "", "", "YYNY");

   // 校验最小长度的定义
   @AContentField
   public final static FContentField VALID_LENGTH_MIN = new FContentField("validLengthMin", "valid_length_min", EContentData.String, "", "", "", "YYNY");

   // 校验最大长度的定义
   @AContentField
   public final static FContentField VALID_LENGTH_MAX = new FContentField("validLengthMax", "valid_length_max", EContentData.String, "", "", "", "YYNY");

   // 输入尺寸的定义
   @AContentField
   public final static FContentField INPUT_SIZE = new FContentField("inputSize", "input_size", EContentData.String, "", "", "", "YYNY");

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

   // 显示模式
   @AName("display_mode")
   protected String _displayMode;

   // 查看显示
   @AName("display_view")
   protected boolean _displayView;

   // 新建显示
   @AName("display_insert")
   protected boolean _displayInsert;

   // 更新显示
   @AName("display_update")
   protected boolean _displayUpdate;

   // 删除显示
   @AName("display_delete")
   protected boolean _displayDelete;

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

   // 数据名称
   @AName("data_name")
   protected String _dataName;

   // 数据类型
   @AName("data_type_cd")
   protected String _dataTypeCd;

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

   // 编辑大小写类型
   @AName("edit_case_cd")
   protected String _editCaseCd;

   // 编辑模板
   @AName("edit_pattern")
   protected String _editPattern;

   // 编辑长度
   @AName("edit_length")
   protected String _editLength;

   // 编辑自动完成
   @AName("edit_complete")
   protected String _editComplete;

   // 校验最小长度
   @AName("valid_length_min")
   protected String _validLengthMin;

   // 校验最大长度
   @AName("valid_length_max")
   protected String _validLengthMax;

   // 输入尺寸
   @AName("input_size")
   protected String _inputSize;

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
   // <T>获得输入尺寸的内容。</T>
   //
   // @return 输入尺寸
   //============================================================
   public String getInputSize(){
      return _inputSize;
   }

   //============================================================
   // <T>设置输入尺寸的内容。</T>
   //
   // @param value 输入尺寸
   //============================================================
   public void setInputSize(String value){
      _inputSize = value;
   }

}
