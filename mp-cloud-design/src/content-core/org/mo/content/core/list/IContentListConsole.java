package org.mo.content.core.list;

import org.mo.content.core.list.common.XList;

//============================================================
// <T>内容列表控制台接口。</T>
//============================================================
public interface IContentListConsole
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
              String listName);
}
