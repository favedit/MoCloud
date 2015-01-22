package org.mo.script.java.parser;

import org.mo.com.lang.INamePair;
import org.mo.com.lang.generic.MDictionary;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>类对象集合。</T>
//============================================================
public class FJavaClasses
      extends MDictionary<INamePair<FJavaClass>, FJavaClass>
{
   //============================================================
   // <T>构造类对象集合。</T>
   //============================================================
   public FJavaClasses(){
      super(FJavaClass.class);
   }

   //============================================================
   // <T>保存设置信息。</T>
   //
   // @param xconfig 设置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      for(int n = 0; n < _count; n++){
         FJavaClass javaClass = _values[n];
         javaClass.saveConfig(xconfig.createNode("Class"));
      }
   }
}
