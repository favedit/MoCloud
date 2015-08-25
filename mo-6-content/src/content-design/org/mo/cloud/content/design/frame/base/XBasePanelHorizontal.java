package org.mo.cloud.content.design.frame.base;

import org.mo.cloud.content.design.configuration.AContentField;
import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.face.AName;

//============================================================
// <T>横向面板对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBasePanelHorizontal
      extends XContentObject
{
   // 类名称
   public static final String CONTENT_NAME = "PanelHorizontal";

   // 有效性的定义
   @AContentField
   public final static FContentField VALID = new FContentField("valid", "valid", EContentData.Boolean, "", "", "", "YYNY");

   // 代码的定义
   @AContentField
   public final static FContentField CODE = new FContentField("code", "code", EContentData.String, "", "", "", "YYNY");

   // 名称的定义
   @AContentField
   public final static FContentField NAME = new FContentField("name", "name", EContentData.String, "", "", "", "YYNY");

   // 标签的定义
   @AContentField
   public final static FContentField LABEL = new FContentField("label", "label", EContentData.String, "", "", "", "YYNY");

   // 类型的定义
   @AContentField
   public final static FContentField TYPE = new FContentField("type", "type", EContentData.String, "", "", "", "YYNY");

   // 属性集合的定义
   @AContentField
   public final static FContentField ATTRIBUTES = new FContentField("attributes", "attributes", EContentData.String, "", "", "", "YYNY");

   // 是否续行的定义
   @AContentField
   public final static FContentField NOWRAP = new FContentField("nowrap", "nowrap", EContentData.Boolean, "", "", "", "YYNY");

   // 左位置的定义
   @AContentField
   public final static FContentField LEFT = new FContentField("left", "left", EContentData.String, "", "", "", "YYNY");

   // 上位置的定义
   @AContentField
   public final static FContentField TOP = new FContentField("top", "top", EContentData.String, "", "", "", "YYNY");

   // 右位置的定义
   @AContentField
   public final static FContentField RIGHT = new FContentField("right", "right", EContentData.String, "", "", "", "YYNY");

   // 下位置的定义
   @AContentField
   public final static FContentField BOTTOM = new FContentField("bottom", "bottom", EContentData.String, "", "", "", "YYNY");

   // 位置的定义
   @AContentField
   public final static FContentField LOCATION = new FContentField("location", "location", EContentData.String, "", "", "", "YYNY");

   // 宽度的定义
   @AContentField
   public final static FContentField WIDTH = new FContentField("width", "width", EContentData.String, "", "", "", "YYNY");

   // 高度的定义
   @AContentField
   public final static FContentField HEIGHT = new FContentField("height", "height", EContentData.String, "", "", "", "YYNY");

   // 尺寸的定义
   @AContentField
   public final static FContentField SIZE = new FContentField("size", "size", EContentData.String, "", "", "", "YYNY");

   // 锚点类型的定义
   @AContentField
   public final static FContentField ANCHOR_CD = new FContentField("anchorCd", "anchor_cd", EContentData.String, "", "", "", "YYNY");

   // 停靠类型的定义
   @AContentField
   public final static FContentField DOCK_CD = new FContentField("dockCd", "dock_cd", EContentData.String, "", "", "", "YYNY");

   // 对齐方式的定义
   @AContentField
   public final static FContentField ALIGN_CD = new FContentField("alignCd", "align_cd", EContentData.String, "", "", "", "YYNY");

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

   // 页面来源的定义
   @AContentField
   public final static FContentField FRAME_SOURCE = new FContentField("frameSource", "frame_source", EContentData.String, "", "", "", "YYNY");

   // 滚动类型的定义
   @AContentField
   public final static FContentField SCROLL_CD = new FContentField("scrollCd", "scroll_cd", EContentData.String, "", "", "", "YYNY");

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

   // 有效性
   @AName("valid")
   protected boolean _valid;

   // 代码
   @AName("code")
   protected String _code;

   // 名称
   @AName("name")
   protected String _name;

   // 标签
   @AName("label")
   protected String _label;

   // 类型
   @AName("type")
   protected String _type;

   // 属性集合
   @AName("attributes")
   protected String _attributes;

   // 是否续行
   @AName("nowrap")
   protected boolean _nowrap;

   // 左位置
   @AName("left")
   protected String _left;

   // 上位置
   @AName("top")
   protected String _top;

   // 右位置
   @AName("right")
   protected String _right;

   // 下位置
   @AName("bottom")
   protected String _bottom;

   // 位置
   @AName("location")
   protected String _location;

   // 宽度
   @AName("width")
   protected String _width;

   // 高度
   @AName("height")
   protected String _height;

   // 尺寸
   @AName("size")
   protected String _size;

   // 锚点类型
   @AName("anchor_cd")
   protected String _anchorCd;

   // 停靠类型
   @AName("dock_cd")
   protected String _dockCd;

   // 对齐方式
   @AName("align_cd")
   protected String _alignCd;

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

   // 页面来源
   @AName("frame_source")
   protected String _frameSource;

   // 滚动类型
   @AName("scroll_cd")
   protected String _scrollCd;

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
   // <T>获得是否续行的内容。</T>
   //
   // @return 是否续行
   //============================================================
   public Boolean getNowrap(){
      return _nowrap;
   }

   //============================================================
   // <T>设置是否续行的内容。</T>
   //
   // @param value 是否续行
   //============================================================
   public void setNowrap(Boolean value){
      _nowrap = value;
   }

   //============================================================
   // <T>获得左位置的内容。</T>
   //
   // @return 左位置
   //============================================================
   public String getLeft(){
      return _left;
   }

   //============================================================
   // <T>设置左位置的内容。</T>
   //
   // @param value 左位置
   //============================================================
   public void setLeft(String value){
      _left = value;
   }

   //============================================================
   // <T>获得上位置的内容。</T>
   //
   // @return 上位置
   //============================================================
   public String getTop(){
      return _top;
   }

   //============================================================
   // <T>设置上位置的内容。</T>
   //
   // @param value 上位置
   //============================================================
   public void setTop(String value){
      _top = value;
   }

   //============================================================
   // <T>获得右位置的内容。</T>
   //
   // @return 右位置
   //============================================================
   public String getRight(){
      return _right;
   }

   //============================================================
   // <T>设置右位置的内容。</T>
   //
   // @param value 右位置
   //============================================================
   public void setRight(String value){
      _right = value;
   }

   //============================================================
   // <T>获得下位置的内容。</T>
   //
   // @return 下位置
   //============================================================
   public String getBottom(){
      return _bottom;
   }

   //============================================================
   // <T>设置下位置的内容。</T>
   //
   // @param value 下位置
   //============================================================
   public void setBottom(String value){
      _bottom = value;
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
   // <T>获得宽度的内容。</T>
   //
   // @return 宽度
   //============================================================
   public String getWidth(){
      return _width;
   }

   //============================================================
   // <T>设置宽度的内容。</T>
   //
   // @param value 宽度
   //============================================================
   public void setWidth(String value){
      _width = value;
   }

   //============================================================
   // <T>获得高度的内容。</T>
   //
   // @return 高度
   //============================================================
   public String getHeight(){
      return _height;
   }

   //============================================================
   // <T>设置高度的内容。</T>
   //
   // @param value 高度
   //============================================================
   public void setHeight(String value){
      _height = value;
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

}
