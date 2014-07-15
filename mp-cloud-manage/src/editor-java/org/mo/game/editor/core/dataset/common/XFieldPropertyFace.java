package org.mo.game.editor.core.dataset.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>属性字段对象的XML节点基类。</T>
//============================================================
public interface XFieldPropertyFace
      extends 
         XFieldFace
{
   // 名称定义
   String NAME = "IFieldProperty";

   // 属性代码号的名称定义
   String PTY_PROPERTY_ID = "property_id";

   //============================================================
   // <T>获得属性代码号的内容。</T>
   //
   // @return 属性代码号
   //============================================================
   String getPropertyId();

   //============================================================
   // <T>设置属性代码号的内容。</T>
   //
   // @param value 属性代码号
   //============================================================
   void setPropertyId(String value);
}