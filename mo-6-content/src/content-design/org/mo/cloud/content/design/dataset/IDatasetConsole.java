package org.mo.cloud.content.design.dataset;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;

//============================================================
// <T>内容数据集控制台接口。</T>
//============================================================
public interface IDatasetConsole
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
}
