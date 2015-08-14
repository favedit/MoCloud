package org.mo.cloud.content.design.common;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;

//============================================================
// <T>内容控制台接口。</T>
//============================================================
public interface IContentConsole
{
   //============================================================
   // <T>根据名称获得容器定义。</T>
   //
   // @param storgeName 存储名称
   // @param containerName 容器名称
   // @param modeCd 模式类型
   // @return 容器定义
   //============================================================
   FContentObject findDefine(String storgeName,
                             String containerName,
                             EPersistenceMode modeCd);

   //============================================================
   // <T>新建列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   void insert(String storgeName,
               FContentObject contentObject);

   //============================================================
   // <T>更新列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   void update(String storgeName,
               FContentObject contentObject);

   //============================================================
   // <T>删除列表配置。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   void delete(String storgeName,
               FContentObject contentObject);
}
