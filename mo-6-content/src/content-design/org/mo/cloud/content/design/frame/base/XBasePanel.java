package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>面板对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBasePanel
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "Panel";

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

   // 背景颜色的定义
   @AContentField
   public final static FContentField BACK_COLOR = new FContentField("backColor", "back_color", EContentData.String, "", "", "", "YYNY");

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

   // 页面来源的定义
   @AContentField
   public final static FContentField FRAME_SOURCE = new FContentField("frameSource", "frame_source", EContentData.String, "", "", "", "YYNY");

   // 滚动类型的定义
   @AContentField
   public final static FContentField SCROLL_CD = new FContentField("scrollCd", "scroll_cd", EContentData.String, "", "", "", "YYNY");

   // 样式类型的定义
   @AContentField
   public final static FContentField STYLE_CD = new FContentField("styleCd", "style_cd", EContentData.String, "", "", "", "YYNY");

   // 图标的定义
   @AContentField
   public final static FContentField ICON = new FContentField("icon", "icon", EContentData.String, "", "", "", "YYNY");

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

   // 背景颜色
   @AName("back_color")
   protected String _backColor;

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

   // 页面来源
   @AName("frame_source")
   protected String _frameSource;

   // 滚动类型
   @AName("scroll_cd")
   protected String _scrollCd;

   // 样式类型
   @AName("style_cd")
   protected String _styleCd;

   // 图标
   @AName("icon")
   protected String _icon;

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
   // <T>获得样式类型的内容。</T>
   //
   // @return 样式类型
   //============================================================
   public String getStyleCd(){
      return _styleCd;
   }

   //============================================================
   // <T>设置样式类型的内容。</T>
   //
   // @param value 样式类型
   //============================================================
   public void setStyleCd(String value){
      _styleCd = value;
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

}
