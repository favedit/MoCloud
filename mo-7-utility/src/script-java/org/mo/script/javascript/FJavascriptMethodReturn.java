package org.mo.script.javascript;

public class FJavascriptMethodReturn
{

   //return类型
   protected String _returnType;

   //return注释
   protected String _returnAnnotation;

   public String returnType(){
      return _returnType;
   }

   public void setReturnType(String _returnType){
      this._returnType = _returnType;
   }

   public String returnAnnotation(){
      return _returnAnnotation;
   }

   public void setReturnAnnotation(String _returnAnnotation){
      this._returnAnnotation = _returnAnnotation;
   }

}
