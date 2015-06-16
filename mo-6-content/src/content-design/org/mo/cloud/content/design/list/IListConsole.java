package org.mo.cloud.content.design.list;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.list.common.XList;
import org.mo.cloud.content.design.persistence.EPersistenceMode;

//============================================================
// <T>内容列表控制台接口。</T>
//============================================================
public interface IListConsole
{
   //============================================================
   // <T>获得列表集合。</T>
   //
   // @param storgeName 存储名称
   // @return 列表集合
   //============================================================
   XList[] list(String storgeName);

   //============================================================
   // <T>根据名称获得列表。</T>
   //
   // @param storgeName 存储名称
   // @param listName 列表名称
   // @return 列表
   //============================================================
   XList find(String storgeName,
              String listName,
              EPersistenceMode modeCd);

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param listName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   FContentObject findDefine(String storgeName,
                             String listName,
                             EPersistenceMode modeCd);
}
