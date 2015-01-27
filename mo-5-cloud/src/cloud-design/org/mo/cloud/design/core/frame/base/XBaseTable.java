package org.mo.cloud.design.core.frame.base;

import org.mo.com.lang.face.AName;
import org.mo.cloud.design.core.configuration.FContentField;
import org.mo.cloud.design.core.configuration.XContentObject;

//============================================================
// <T>表格对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseTable extends XContentObject
{
   // 组件名称
   public static final String NAME = "Table";

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 有效性的定义
   public final static FContentField FieldValid = new FContentField("valid");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 位置的定义
   public final static FContentField FieldLocation = new FContentField("location");

   // 尺寸的定义
   public final static FContentField FieldSize = new FContentField("size");

   // 内空白的定义
   public final static FContentField FieldPadding = new FContentField("padding");

   // 外空白的定义
   public final static FContentField FieldMargin = new FContentField("margin");

   // 数据名称的定义
   public final static FContentField FieldDatasetName = new FContentField("dataset_name");

   // 数据分页大小的定义
   public final static FContentField FieldDatasetPageSize = new FContentField("dataset_page_size");

   // 数据搜索的定义
   public final static FContentField FieldDatasetSearch = new FContentField("dataset_search");

   // 数据排序的定义
   public final static FContentField FieldDatasetOrder = new FContentField("dataset_order");

   // 数据查询指令的定义
   public final static FContentField FieldDatasetFetchCommand = new FContentField("dataset_fetch_command");

   // 数据新建命令的定义
   public final static FContentField FieldDatasetInsertAction = new FContentField("dataset_insert_action");

   // 数据更新命令的定义
   public final static FContentField FieldDatasetUpdateAction = new FContentField("dataset_update_action");

   // 数据删除命令的定义
   public final static FContentField FieldDatasetDeleteAction = new FContentField("dataset_delete_action");

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

   // 有效性
   @AName("valid")
   protected String _valid;

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
   public String getValid(){
      return _valid;
   }

   //============================================================
   // <T>设置有效性的内容。</T>
   //
   // @param value 有效性
   //============================================================
   public void setValid(String value){
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