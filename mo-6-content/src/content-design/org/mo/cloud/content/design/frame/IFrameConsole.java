package org.mo.cloud.content.design.frame;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;

//============================================================
// <T>内容表单控制台接口。</T>
//============================================================
public interface IFrameConsole
      extends
         IContentConsole
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
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   FContentObject buildDefine(String storgeName,
                              String frameName,
                              EPersistenceMode modeCd);
}
