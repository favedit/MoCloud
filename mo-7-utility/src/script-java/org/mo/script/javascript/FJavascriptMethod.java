package org.mo.script.javascript;

import java.util.List;

public class FJavascriptMethod
{
   //方法名称
   protected String _methodName;

   //方法注释
   protected String _methodAnnotation;

   //方法参数
   protected List<FJavascriptMethodParam> _methodParam;

   //return参数
   protected FJavascriptMethodReturn _methodReturn;

   public FJavascriptMethodReturn methodReturn(){
      return _methodReturn;
   }

   public void setMethodReturn(FJavascriptMethodReturn _methodReturn){
      this._methodReturn = _methodReturn;
   }

   public List<FJavascriptMethodParam> methodParam(){
      return _methodParam;
   }

   public void setMethodParam(List<FJavascriptMethodParam> _methodParam){
      this._methodParam = _methodParam;
   }

   public String methodName(){
      return _methodName;
   }

   public void setMethodName(String methodName){
      this._methodName = methodName;
   }

   public String methodAnnotation(){
      return _methodAnnotation;
   }

   public void setMethodAnnotation(String methodAnnotation){
      this._methodAnnotation = methodAnnotation;
   }

}
