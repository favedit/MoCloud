package org.mo.cloud.editor.core.enums;

import org.mo.cloud.editor.core.enums.common.XEnum;
import org.mo.cloud.editor.core.enums.common.XEnumGroup;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.IXmlObject;
import org.mo.eng.store.IXmlConfigConsole;

public interface IEnumConsole
      extends
         IXmlConfigConsole<XEnumGroup>
{

   void buildAll(EEnumSource type);

   FXmlNode buildConfig(IXmlObject xenumeGroup,
                        EXmlConfig type);

   FXmlNode buildConfig(String name);

   boolean fetchDefineCodeList();

   boolean fetchDefineMail();

   boolean fetchDefineMessage();

   boolean fetchDefineProperty();

   String searchConstantCode(String name);

   String searchConstantValue(String name);

   String searchConstantValue(String name,
                              String value);

   FXmlNode searchEnum(String name);

   XEnum searchEnumObject(String name);

   String sourceClientPath();

   String sourceServerPath();

   String sourceToolPath();
}
