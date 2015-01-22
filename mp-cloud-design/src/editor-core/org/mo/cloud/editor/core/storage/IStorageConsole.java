package org.mo.cloud.editor.core.storage;

import org.mo.cloud.editor.core.storage.common.XGroup;
import org.mo.com.lang.FString;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlNodes;
import org.mo.com.xml.IXmlObject;
import org.mo.eng.store.IXmlConfigConsole;

public interface IStorageConsole
      extends
         IXmlConfigConsole<XGroup>
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

   FString buildSource(IXmlObject xentityGroup,
                       String buildType);

   FString buildSource(String source,
                       String templatePath,
                       String define);

   String buildStorePath(String fileName);

   String sourcePath();
}
