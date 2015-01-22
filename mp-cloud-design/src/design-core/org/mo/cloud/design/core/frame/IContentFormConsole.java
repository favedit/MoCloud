package org.mo.cloud.design.core.frame;

import org.mo.cloud.design.core.configuration.XContentObject;

//============================================================
// <T>内容表单控制台接口。</T>
//============================================================
public interface IContentFormConsole
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
}
