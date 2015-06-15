package org.mo.cloud.content.design.frame;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>内容表单控制台接口。</T>
//============================================================
public interface IFrameConsole
{
   //============================================================
   // <T>获得表单集合。</T>
   //
   // @param storgeName 存储名称
   // @return 表单集合
   //============================================================
   XContentObject[] list(String storgeName);

   //============================================================
   // <T>根据名称查找表单。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   XContentObject find(String storgeName,
                       String frameName,
                       EPersistenceMode modeCd);

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @param modeCd 模式类型
   // @return 表单定义
   //============================================================
   FContentObject findDefine(String storgeName,
                             String frameName,
                             EPersistenceMode modeCd);

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @param modeCd 模式类型
   // @return 目录配置
   //============================================================
   FXmlNode buildConfig(String storgeName,
                        String frameName,
                        EPersistenceMode modeCd);

   //============================================================
   // <T>更新表单配置。</T>
   //
   // @param frame 页面
   //============================================================
   void update(String storgeName,
               FContentObject frame);
}
