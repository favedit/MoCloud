package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>表单对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseForm
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Form";

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

   // 页面来源的定义
   @AContentField
   public final static FContentField FRAME_SOURCE = new FContentField("frameSource", "frame_source", EContentData.String, "", "", "", "YYNY");

   // 滚动类型的定义
   @AContentField
   public final static FContentField SCROLL_CD = new FContentField("scrollCd", "scroll_cd", EContentData.String, "", "", "", "YYNY");

   // 数据名称的定义
   @AContentField
   public final static FContentField DATASET_NAME = new FContentField("datasetName", "dataset_name", EContentData.String, "", "", "", "YYNY");

   // 数据分页大小的定义
   @AContentField
   public final static FContentField DATASET_PAGE_SIZE = new FContentField("datasetPageSize", "dataset_page_size", EContentData.String, "", "", "", "YYNY");

   // 数据搜索的定义
   @AContentField
   public final static FContentField DATASET_SEARCH = new FContentField("datasetSearch", "dataset_search", EContentData.String, "", "", "", "YYNY");

   // 数据排序的定义
   @AContentField
   public final static FContentField DATASET_ORDER = new FContentField("datasetOrder", "dataset_order", EContentData.String, "", "", "", "YYNY");

   // 数据查询指令的定义
   @AContentField
   public final static FContentField DATASET_FETCH_COMMAND = new FContentField("datasetFetchCommand", "dataset_fetch_command", EContentData.String, "", "", "", "YYNY");

   // 数据新建命令的定义
   @AContentField
   public final static FContentField DATASET_INSERT_ACTION = new FContentField("datasetInsertAction", "dataset_insert_action", EContentData.String, "", "", "", "YYNY");

   // 数据更新命令的定义
   @AContentField
   public final static FContentField DATASET_UPDATE_ACTION = new FContentField("datasetUpdateAction", "dataset_update_action", EContentData.String, "", "", "", "YYNY");

   // 数据删除命令的定义
   @AContentField
   public final static FContentField DATASET_DELETE_ACTION = new FContentField("datasetDeleteAction", "dataset_delete_action", EContentData.String, "", "", "", "YYNY");

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

   // 页面来源
   @AName("frame_source")
   protected String _frameSource;

   // 滚动类型
   @AName("scroll_cd")
   protected String _scrollCd;

   // 数据名称
   @AName("dataset_name")
   protected String _datasetName;

   // 数据分页大小
   @AName("dataset_page_size")
   protected String _datasetPageSize;

   // 数据搜索
   @AName("dataset_search")
   protected String _datasetSearch;

   // 数据排序
   @AName("dataset_order")
   protected String _datasetOrder;

   // 数据查询指令
   @AName("dataset_fetch_command")
   protected String _datasetFetchCommand;

   // 数据新建命令
   @AName("dataset_insert_action")
   protected String _datasetInsertAction;

   // 数据更新命令
   @AName("dataset_update_action")
   protected String _datasetUpdateAction;

   // 数据删除命令
   @AName("dataset_delete_action")
   protected String _datasetDeleteAction;

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
   // <T>获得页面来源的内容。</T>
   //
   // @return 页面来源
   //============================================================
   public String getFrameSource(){
      return _frameSource;
   }

   //============================================================
   // <T>设置页面来源的内容。</T>
   //
   // @param value 页面来源
   //============================================================
   public void setFrameSource(String value){
      _frameSource = value;
   }

   //============================================================
   // <T>获得滚动类型的内容。</T>
   //
   // @return 滚动类型
   //============================================================
   public String getScrollCd(){
      return _scrollCd;
   }

   //============================================================
   // <T>设置滚动类型的内容。</T>
   //
   // @param value 滚动类型
   //============================================================
   public void setScrollCd(String value){
      _scrollCd = value;
   }

   //============================================================
   // <T>获得数据名称的内容。</T>
   //
   // @return 数据名称
   //============================================================
   public String getDatasetName(){
      return _datasetName;
   }

   //============================================================
   // <T>设置数据名称的内容。</T>
   //
   // @param value 数据名称
   //============================================================
   public void setDatasetName(String value){
      _datasetName = value;
   }

   //============================================================
   // <T>获得数据分页大小的内容。</T>
   //
   // @return 数据分页大小
   //============================================================
   public String getDatasetPageSize(){
      return _datasetPageSize;
   }

   //============================================================
   // <T>设置数据分页大小的内容。</T>
   //
   // @param value 数据分页大小
   //============================================================
   public void setDatasetPageSize(String value){
      _datasetPageSize = value;
   }

   //============================================================
   // <T>获得数据搜索的内容。</T>
   //
   // @return 数据搜索
   //============================================================
   public String getDatasetSearch(){
      return _datasetSearch;
   }

   //============================================================
   // <T>设置数据搜索的内容。</T>
   //
   // @param value 数据搜索
   //============================================================
   public void setDatasetSearch(String value){
      _datasetSearch = value;
   }

   //============================================================
   // <T>获得数据排序的内容。</T>
   //
   // @return 数据排序
   //============================================================
   public String getDatasetOrder(){
      return _datasetOrder;
   }

   //============================================================
   // <T>设置数据排序的内容。</T>
   //
   // @param value 数据排序
   //============================================================
   public void setDatasetOrder(String value){
      _datasetOrder = value;
   }

   //============================================================
   // <T>获得数据查询指令的内容。</T>
   //
   // @return 数据查询指令
   //============================================================
   public String getDatasetFetchCommand(){
      return _datasetFetchCommand;
   }

   //============================================================
   // <T>设置数据查询指令的内容。</T>
   //
   // @param value 数据查询指令
   //============================================================
   public void setDatasetFetchCommand(String value){
      _datasetFetchCommand = value;
   }

   //============================================================
   // <T>获得数据新建命令的内容。</T>
   //
   // @return 数据新建命令
   //============================================================
   public String getDatasetInsertAction(){
      return _datasetInsertAction;
   }

   //============================================================
   // <T>设置数据新建命令的内容。</T>
   //
   // @param value 数据新建命令
   //============================================================
   public void setDatasetInsertAction(String value){
      _datasetInsertAction = value;
   }

   //============================================================
   // <T>获得数据更新命令的内容。</T>
   //
   // @return 数据更新命令
   //============================================================
   public String getDatasetUpdateAction(){
      return _datasetUpdateAction;
   }

   //============================================================
   // <T>设置数据更新命令的内容。</T>
   //
   // @param value 数据更新命令
   //============================================================
   public void setDatasetUpdateAction(String value){
      _datasetUpdateAction = value;
   }

   //============================================================
   // <T>获得数据删除命令的内容。</T>
   //
   // @return 数据删除命令
   //============================================================
   public String getDatasetDeleteAction(){
      return _datasetDeleteAction;
   }

   //============================================================
   // <T>设置数据删除命令的内容。</T>
   //
   // @param value 数据删除命令
   //============================================================
   public void setDatasetDeleteAction(String value){
      _datasetDeleteAction = value;
   }

}
