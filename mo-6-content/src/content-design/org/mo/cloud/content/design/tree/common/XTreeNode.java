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
      xconfig.set(IS_VALID.linkName(), _isValid);
      xconfig.set(TYPE_CODE.linkName(), _typeCode);
      xconfig.set(GUID.linkName(), _guid);
      xconfig.set(CODE.linkName(), _code);
      xconfig.set(LABEL.linkName(), _label);
      xconfig.set(HAS_CHILD.linkName(), _hasChild);
      xconfig.set(NOTE.linkName(), _note);
      xconfig.set(ATTRIBUTES.linkName(), _attributes);
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
