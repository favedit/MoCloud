package org.mo.script.javascript;

import java.util.List;

public class FJavascriptPackage
{

   //包名
   protected String _packageName;

   //类
   List<FJavascriptClass> _classes;

   public void setPackageName(String packageName){
      this._packageName = packageName;
   }

   public String packageName(){
      return _packageName;
   }

   public List<FJavascriptClass> classes(){
      return _classes;
   }

   public void setClasses(List<FJavascriptClass> _classes){
      this._classes = _classes;
   }

}
