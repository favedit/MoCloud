package org.mo.cloud.content.design.tree;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.tree.common.XTreeView;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>目录控制台接口。</T>
//============================================================
public interface ITreeConsole
      extends
         IContentConsole
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
                  String treeName,
                  EPersistenceMode modeCd);

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param treeName 目录名称
   // @return 目录配置
   //============================================================
   FXmlNode buildConfig(String storgeName,
                        String treeName);
}
