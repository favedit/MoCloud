package org.mo.web.core.webtools.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>图标接口对象的XML节点基类。</T>
//============================================================
public interface XIconFace
      extends IXmlObject
{
   // 名称定义
   String NAME = "IIcon";

   // 图标的名称定义
   String PTY_ICON = "icon";

   // 禁止图标的名称定义
   String PTY_ICON_DISABLE = "icon_disable";

   //============================================================
   // <T>获得图标的内容。</T>
   //
   // @return 图标
   //============================================================
   String getIcon();

   //============================================================
   // <T>设置图标的内容。</T>
   //
   // @param value 图标
   //============================================================
   void setIcon(String value);

   //============================================================
   // <T>获得禁止图标的内容。</T>
   //
   // @return 禁止图标
   //============================================================
   String getIconDisable();

   //============================================================
   // <T>设置禁止图标的内容。</T>
   //
   // @param value 禁止图标
   //============================================================
   void setIconDisable(String value);
}