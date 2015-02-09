package org.mo.script.javascript;

public class FJavascriptMethodParam
{

   //方法参数代码
   protected String _paramCode;

   //方法参数类型
   protected String _paramType;

   //方法参数名称
   protected String _paramName;

   //方法参数注释
   protected String _paramAnnotation;

   public String paramCode(){
      return _paramCode;
   }

   public void setParamCode(String _paramCode){
      this._paramCode = _paramCode;
   }

   public String paramAnnotation(){
      return _paramAnnotation;
   }

   public void setParamAnnotation(String _paramAnnotation){
      this._paramAnnotation = _paramAnnotation;
   }

   public String paramType(){
      return _paramType;
   }

   public void setParamType(String _paramType){
      this._paramType = _paramType;
   }

   public String paramName(){
      return _paramName;
   }

   public void setParamName(String _paramName){
      this._paramName = _paramName;
   }

}
