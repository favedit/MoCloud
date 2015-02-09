package org.mo.script.javascript;

import java.util.List;

public class FJavascriptClass
{
   //类名
   protected String _className;

   //类注释
   protected String _classAnnotation;

   //方法
   protected List<FJavascriptMethod> _methods;

   public String classAnnotation(){
      return _classAnnotation;
   }

   public void setClassAnnotation(String _classAnnotation){
      this._classAnnotation = _classAnnotation;
   }

   public List<FJavascriptMethod> methods(){
      return _methods;
   }

   public void setMethods(List<FJavascriptMethod> _method){
      this._methods = _method;
   }

   public void setClassName(String className){
      this._className = className;
   }

   public String className(){
      return _className;
   }

}
