package org.mo.content.core.frame.base;

import org.mo.com.lang.face.AName;
import org.mo.content.core.configuration.FContentField;
import org.mo.content.core.configuration.XContentObject;

//============================================================
// <T>窗口对象的内容基类。</T>
//
// @author autosource
//============================================================
public abstract class XBaseWindow extends XContentObject
{
   // 组件名称
   public static final String NAME = "Window";

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

   // 名称的定义
   public final static FContentField FieldName = new FContentField("name");

   // 标签的定义
   public final static FContentField FieldLabel = new FContentField("label");

   // 左位置的定义
   public final static FContentField FieldLeft = new FContentField("left");

   // 上位置的定义
   public final static FContentField FieldTop = new FContentField("top");

   // 宽度的定义
   public final static FContentField FieldWidth = new FContentField("width");

   // 高度的定义
   public final static FContentField FieldHeight = new FContentField("height");

   // 名称
   @AName("name")
   protected String _name;

   // 标签
   @AName("label")
   protected String _label;

   // 左位置
   @AName("left")
   protected String _left;

   // 上位置
   @AName("top")
   protected String _top;

   // 宽度
   @AName("width")
   protected String _width;

   // 高度
   @AName("height")
   protected String _height;

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

}