package org.mo.cloud.content.design.frame;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;

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
   // <T>根据名称获得表单。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @return 表单
   //============================================================
   XContentObject find(String storgeName,
                       String formName);

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @param modeCd 模式类型
   // @return 表单定义
   //============================================================
   FContentObject findDefine(String storgeName,
                             String formName,
                             EPersistenceMode modeCd);
}
