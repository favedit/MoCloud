package org.mo.cloud.editor.core.logic;

import org.mo.cloud.editor.core.enums.common.XEnum;
import org.mo.cloud.editor.core.logic.common.XLogic;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.IXmlObject;
import org.mo.eng.store.IXmlConfigConsole;

public interface ILogicConsole
      extends
         IXmlConfigConsole<XLogic>
{

   void buildAll(ELogicSource type);

   FXmlNode buildConfig(IXmlObject xenumeGroup,
                        EXmlConfig type);

   FXmlNode buildConfig(String name);

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
