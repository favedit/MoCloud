package org.mo.com.xml;

//============================================================
// <T>XML设置接口。</T>
//
// @history 120828 MAOCY 创建
//============================================================
public interface IXmlConfig
{
   //============================================================
   // <T>从设置节点中加载设置信息。</T>
   //
   // @param xconfig 设置节点
   //============================================================
   void loadConfig(FXmlNode xconfig);

   //============================================================
   // <T>保存设置信息到设置节点中。</T>
   //
   // @param xconfig 设置节点
   //============================================================
   void saveConfig(FXmlNode config);
}
