package org.mo.cloud.content.design.tree.common;

import org.mo.cloud.content.design.tree.base.XBaseTreeNode;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>树目录节点。</T>
//============================================================
public class XTreeNode
      extends XBaseTreeNode
{
   //============================================================
   // <T>存储配置。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.setNvl(IS_VALID.linkName(), _isValid);
      xconfig.setNvl(TYPE_CODE.linkName(), _typeCode);
      xconfig.setNvl(GUID.linkName(), _guid);
      xconfig.setNvl(CODE.linkName(), _code);
      xconfig.setNvl(LABEL.linkName(), _label);
      xconfig.setNvl(HAS_CHILD.linkName(), _hasChild);
      xconfig.setNvl(NOTE.linkName(), _note);
      xconfig.setNvl(ATTRIBUTES.linkName(), _attributes);
   }

   //============================================================
   // <T>转换为节点。</T>
   //
   // @return 配置节点
   //============================================================
   public FXmlNode toNode(){
      FXmlNode xconfig = new FXmlNode();
      saveConfig(xconfig);
      return xconfig;
   }
}
