package org.mo.script.javascript;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FJavascriptInput
{
   private BufferedReader bufferedReader;

   protected List<FJavascriptPackage> packageList;

   protected FJavascriptPackage javascriptPackage;

   protected List<FJavascriptClass> classList;

   protected FJavascriptClass fJavascriptClass;

   protected List<FJavascriptMethod> methodList;

   protected FJavascriptMethod fJavascriptMethod;

   protected List<FJavascriptMethodParam> methodParamList;

   protected FJavascriptMethodParam methodParam;

   protected FJavascriptMethodReturn methodReturn;

   //============================================================
   // <T>初始化</T>
   //
   //============================================================
   public FJavascriptInput(List<FJavascriptPackage> packageList,
                           List<FJavascriptClass> classList,
                           List<FJavascriptMethod> methodList,
                           List<FJavascriptMethodParam> methodParamList){
      this.packageList = packageList;
      this.classList = classList;
      this.methodList = methodList;
      this.methodParamList = methodParamList;
   }

   //============================================================
   // <T>遍历文件夹下的所有文件，解析所有的js文件。</T>
   //
   // @param content 转换环境
   // @param source 代码内容
   //============================================================
   public void foreachFiles(File dir) throws Exception{
      File[] fs = dir.listFiles();
      int index = 0;
      for(int i = 0; i < fs.length; i++){

         if(fs[i].isDirectory()){
            try{
               //将上一个文件增加至当前List
               if(index != 0){
                  javascriptPackage.setClasses(classList);
                  this.packageList.add(javascriptPackage);
               }

               //获取包名
               String packageName = fs[i].getName().substring(fs[i].getName().indexOf('-') + 1, fs[i].getName().length());
               String firstWord = fs[i].getName().substring(0, 1);
               //文件夹名中是否有数字
               if(!Character.isDigit(firstWord.charAt(0))){
                  continue;
               }
               classList = new ArrayList<FJavascriptClass>();
               javascriptPackage = new FJavascriptPackage();
               javascriptPackage.setPackageName(packageName);
               System.out.println("packageName=" + packageName);
               index++;
               foreachFiles(fs[i]);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(fs[i].isFile()){

            //获取类名
            try{
               String className = fs[i].getName().substring(0, fs[i].getName().lastIndexOf('.'));
               String isJs = fs[i].getName().substring(fs[i].getName().lastIndexOf('.') + 1, fs[i].getName().length());
               if(!isJs.equals("js"))
                  continue;
               fJavascriptClass = new FJavascriptClass();
               fJavascriptClass.setClassName(className);
               System.out.println("className=" + className);

               methodList = new ArrayList<FJavascriptMethod>();
               String lineTxt = null;
               InputStreamReader read = new InputStreamReader(new FileInputStream(fs[i]), "UTF-8");
               bufferedReader = new BufferedReader(read);
               while((lineTxt = bufferedReader.readLine()) != null){
                  lineTxt = lineTxt.trim();
                  //获取方法注释
                  if(isMethodAnnotation(lineTxt)){
                     String methodAnnotation = lineTxt.substring(lineTxt.indexOf("<T>") + 3, lineTxt.lastIndexOf("<"));
                     fJavascriptMethod = new FJavascriptMethod();
                     fJavascriptMethod.setMethodAnnotation(methodAnnotation);
                     methodParamList = new ArrayList<FJavascriptMethodParam>();
                     System.out.println("methodAnnotation -->" + methodAnnotation);
                  }
                  //获取方法参数
                  if(isParam(lineTxt)){
                     String paramCode = "方法参数注释异常";
                     String paramType = "方法参数注释异常";
                     String paramName = "方法参数注释异常";
                     String paramAnnotation = "方法参数注释异常";
                     if(isStandardAnnotation(lineTxt) == 1){
                        paramCode = lineTxt.substring(lineTxt.indexOf(':') - 1, lineTxt.indexOf(':'));
                        paramType = lineTxt.substring(lineTxt.lastIndexOf(':') + 1, lineTxt.lastIndexOf(' '));
                        paramName = lineTxt.substring(lineTxt.indexOf(':') + 1, lineTxt.lastIndexOf(':'));
                        paramAnnotation = lineTxt.substring(lineTxt.lastIndexOf(' ') + 1, lineTxt.length());
                     }
                     methodParam = new FJavascriptMethodParam();
                     methodParam.setParamCode(paramCode);
                     methodParam.setParamType(paramType);
                     methodParam.setParamName(paramName);
                     methodParam.setParamAnnotation(paramAnnotation);
                     methodParamList.add(methodParam);
                     System.out.println("paramCode:" + paramCode + ",paramType:" + paramType + ",paramName:" + paramName + ",paramAnnotation:" + paramAnnotation);
                  }
                  //return参数
                  if(isReturn(lineTxt)){
                     String returnType = "类型注释异常";
                     String returnAnnotation = "注释异常";
                     int returnEnum = isStandardAnnotation(lineTxt);
                     if(returnEnum == 1){
                        returnType = lineTxt.substring(lineTxt.indexOf("return") + 7, lineTxt.lastIndexOf(' '));
                        returnAnnotation = lineTxt.substring(lineTxt.lastIndexOf(' ') + 1, lineTxt.length());
                     }else if(returnEnum == 2){
                        returnAnnotation = lineTxt.substring(lineTxt.lastIndexOf(' ') + 1, lineTxt.length());
                     }

                     methodReturn = new FJavascriptMethodReturn();
                     methodReturn.setReturnType(returnType);
                     methodReturn.setReturnAnnotation(returnAnnotation);
                     fJavascriptMethod.setMethodReturn(methodReturn);
                     System.out.println("methodReturnType:" + returnType);
                     System.out.println("methodReturnAnnotation:" + returnAnnotation);
                  }
                  //获取方法名
                  if(isMethod(lineTxt)){
                     String methodName = "";
                     if(noFunName(lineTxt)){
                        methodName = lineTxt.substring(lineTxt.indexOf("function") + 9, lineTxt.indexOf('('));
                     }
                     fJavascriptMethod.setMethodName(methodName);
                     fJavascriptMethod.setMethodParam(methodParamList);
                     System.out.println("methodName -->" + methodName);
                     if(methodName.equals("RClass_innerCopy")){
                        System.out.println("123");
                     }
                     this.methodList.add(fJavascriptMethod);

                  }
               }
               fJavascriptClass.setMethods(methodList);
               this.classList.add(fJavascriptClass);
            }catch(Exception e){
               e.printStackTrace();
            }
         }

      }
   }

   private boolean noFunName(String lineTxt){
      if(!lineTxt.substring(lineTxt.lastIndexOf("(") - 9, lineTxt.lastIndexOf("(")).equals("function")){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>检查此行方法返回值注释</T>
   //
   // @param lineText 行内容
   //============================================================
   private boolean isReturn(String lineTxt){
      if(isAnnotation(lineTxt) && lineTxt.contains("return")){
         return true;
      }else{
         return false;
      }
   }

   //============================================================
   // <T>检查此行是否是方法参数</T>
   //
   // @param lineText 行内容
   //============================================================
   private boolean isParam(String lineTxt){
      if(isAnnotation(lineTxt) && lineTxt.contains("param")){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>检查此行是否是注释</T>
   //
   // @param lineText 行内容
   //============================================================
   private int isStandardAnnotation(String lineTxt){
      if(lineTxt.split(" ").length > 3){
         return 1;
      }else if(lineTxt.split(" ").length > 2){
         return 2;
      }
      return 0;
   }

   //============================================================
   // <T>检查此行是否是方法</T>
   //
   // @param lineText 行内容
   //============================================================
   private boolean isMethod(String lineTxt){
      if(lineTxt.startsWith("function") || lineTxt.contains("new function")){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>检查此行是否是注释</T>
   //
   // @param lineText 行内容
   //============================================================
   private boolean isAnnotation(String lineText){
      if(lineText.contains("//")){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>检查此行是否是方法注释</T>
   //
   // @param lineText 行内容
   //============================================================
   private boolean isMethodAnnotation(String lineText){
      if(isAnnotation(lineText) && lineText.contains("<T>")){
         return true;
      }
      return false;

   }
}
