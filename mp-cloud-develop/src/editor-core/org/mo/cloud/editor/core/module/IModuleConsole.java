package org.mo.cloud.editor.core.module;

import org.mo.cloud.editor.core.module.common.XEntityGroup;
import org.mo.com.lang.FString;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlNodes;
import org.mo.com.xml.IXmlObject;
import org.mo.eng.store.IXmlConfigConsole;

public interface IModuleConsole
      extends
         IXmlConfigConsole<XEntityGroup>
{

   /**
    * <T>排序节点集</T>
    * 
    */
   void ascOrderNodes(FXmlNodes nodes,
                      String... attrNames);

   FXmlNode buildConfig(IXmlObject xentityGroup,
                        EXmlConfig type);

   FXmlNode buildConfig(String name);

   FString buildSource(FXmlNode entityGroup,
                       String buildType);

   FString buildSource(IXmlObject xentityGroup);

   void buildSourceAll();

   String buildStorePath(String fileName);

   FString buildView(IXmlObject xentityGroup,
                     String buildType);

   String sourcePath();
}
