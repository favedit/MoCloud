package org.mo.cloud.design.core.tree;

import org.mo.cloud.design.core.tree.common.XTreeView;

//============================================================
// <T>目录控制台接口。</T>
//============================================================
public interface ITreeConsole
{
   //============================================================
   // <T>获得目录集合。</T>
   //
   // @param storgeName 存储名称
   // @return 列表集合
   //============================================================
   XTreeView[] list(String storgeName);

   //============================================================
   // <T>根据名称获得列表。</T>
   //
   // @param storgeName 存储名称
   // @param listName 列表名称
   // @return 列表
   //============================================================
   XTreeView find(String storgeName,
                  String listName);
}
