package org.mo.cloud.editor.core.message;

import org.mo.cloud.editor.core.message.common.XMessageGroup;
import org.mo.com.lang.FString;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.IXmlObject;
import org.mo.eng.store.IXmlConfigConsole;

public interface IMessageConsole
      extends
         IXmlConfigConsole<XMessageGroup>
{

   void buildAll(EMessageSource type);

   FString buildAsGroupSource(IXmlObject xmessageGroup);

   FString buildAsMessageSource(IXmlObject xmessageGroup,
                                String messageName);

   FString buildAsStructSource(IXmlObject xmessageGroup,
                               String messageName,
                               String structName);

   FXmlNode buildConfig(String name);

   FString buildCsMessageSource(IXmlObject xmessageGroup,
                                String messageName);

   FString buildSource(FXmlNode messageGroup,
                       String buildType);

   FString buildSource(IXmlObject xmessageGroup,
                       String buildType);

   String buildStoreAsPath(String fileName);

   String buildStoreCsPath(String fileName);

   String buildStorePath(String fileName);

   String sourcePath();
}
