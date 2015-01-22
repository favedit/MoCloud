package org.mo.cloud.editor.core.entity;

import org.mo.cloud.editor.core.entity.common.XEntityGroup;
import org.mo.eng.store.IXmlConfigConsole;

public interface IEntityConsole
      extends
         IXmlConfigConsole<XEntityGroup>
{

   void buildAll(EEntitySource type);

   String buildPath(String type,
                    String fileName);
}
