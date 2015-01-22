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
   // @return 目录集合
   //============================================================
   XTreeView[] list(String storgeName);

   //============================================================
   // <T>根据名称获得目录。</T>
   //
   // @param storgeName 存储名称
   // @param treeName 目录名称
   // @return 目录
   //============================================================
   XTreeView find(String storgeName,
                  String treeName);
}
