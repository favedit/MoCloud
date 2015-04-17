package org.mo.script.javascript;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import org.mo.com.lang.RDateTime;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

public class FJavascriptOutput
{

   protected List<FJavascriptPackage> packageList;

   protected FJavascriptPackage javascriptPackage;

   protected List<FJavascriptClass> classList;

   protected FJavascriptClass fJavascriptClass;

   protected List<FJavascriptMethod> methodList;

   protected FJavascriptMethod fJavascriptMethod;

   protected List<FJavascriptMethodParam> methodParamList;

   protected FJavascriptMethodParam methodParam;

   //============================================================
   // <T>初始化</T>
   //
   //============================================================
   public FJavascriptOutput(List<FJavascriptPackage> packageList,
                            List<FJavascriptClass> classList,
                            List<FJavascriptMethod> methodList,
                            List<FJavascriptMethodParam> methodParamList){
      this.packageList = packageList;
      this.classList = classList;
      this.methodList = methodList;
      this.methodParamList = methodParamList;
   }

   //============================================================
   // <T>创建创建XML。</T>
   //
   // @param xmlFile 文件
   //============================================================
   public void outputHelp(String fileName){
      try{
         //         //如果没有此文件创建一个
         //         if(!xmlFile.exists()){
         //            xmlFile.createNewFile();
         //         }
         String newTime = RDateTime.currentDateTime().format("YYYYMMDDHH24MISS").toString();
         System.out.println("startTime:" + newTime);
         //         FileWriter fw = new FileWriter(xmlFile.getAbsoluteFile());
         //         BufferedWriter bw = new BufferedWriter(fw);
         FXmlDocument xd = new FXmlDocument();

         FXmlNode xmlnode1 = new FXmlNode("Configuration");
         FXmlNode xmlnode2 = new FXmlNode("NamespaceCollection");

         //创建包XML
         for(FJavascriptPackage javascriptPackage : packageList){
            FXmlNode xnSpace = new FXmlNode("Namespace");
            xnSpace.set("name", javascriptPackage.packageName());

            //创建类xml
            for(FJavascriptClass fJavascriptClass : javascriptPackage.classes()){
               FXmlNode xnClassCollection = new FXmlNode("ClassCollection");
               xnSpace.push(xnClassCollection);
               FXmlNode xnClass = new FXmlNode("Class");
               xnClass.set("name", fJavascriptClass.className());
               xnClass.set("label", fJavascriptClass.classAnnotation());
               xnClassCollection.push(xnClass);
               //               createMethod(bw, fJavascriptClass);
               for(FJavascriptMethod method : fJavascriptClass.methods()){
                  FXmlNode xnMethodCollection = new FXmlNode("MethodCollection");
                  xnClass.push(xnMethodCollection);
                  FXmlNode xnMethod = new FXmlNode("Method");
                  xnMethod.set("name", method.methodName());
                  xnMethod.set("label", method.methodAnnotation());
                  xnMethodCollection.push(xnMethod);
                  FXmlNode xnParameterCollection = new FXmlNode("ParameterCollection");
                  for(FJavascriptMethodParam methodParam : method.methodParam()){
                     //方法参数
                     FXmlNode xnParameter = new FXmlNode("Parameter");
                     xnParameter.set("code", methodParam.paramCode());
                     xnParameter.set("name", methodParam.paramName());
                     xnParameter.set("type", methodParam.paramType());
                     xnParameter.set("label", methodParam.paramAnnotation());
                     xnParameterCollection.push(xnParameter);
                  }

                  xnMethod.push(xnParameterCollection);
                  //返回值 
                  FXmlNode xnReturn = new FXmlNode("ReturnParameter");
                  if(method.methodReturn() != null){
                     xnReturn.set("type", method.methodReturn().returnType());
                     xnReturn.set("label", method.methodReturn().returnAnnotation());
                  }
                  xnMethod.push(xnReturn);
               }

               //xmlnode2.push(xnMethodCollection);
            }
            xmlnode2.push(xnSpace);
         }

         xmlnode1.push(xmlnode2);
         xd.setRoot(xmlnode1);
         xd.saveFile(fileName);
         String endTime = RDateTime.currentDateTime().format("YYYYMMDDHH24MISS").toString();
         System.out.println("endTime:" + endTime);
         //         bw.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }

   //============================================================
   // <T>创建方法。</T>
   //
   // @param fJavascriptClass 类对象
   //============================================================
   @SuppressWarnings("unused")
   private void createMethod(BufferedWriter bw,
                             FJavascriptClass fJavascriptClass) throws IOException{
      //创建方法xml
      for(FJavascriptMethod fJavascriptMethod : fJavascriptClass.methods()){
         bw.newLine();
         bw.write("               <MethodCollection>");
         bw.newLine();
         bw.write("                  <Method name='" + fJavascriptMethod.methodName() + "' label='" + fJavascriptMethod.methodAnnotation() + "'>");
         createMethodParam(bw, fJavascriptMethod);
         bw.newLine();
         bw.write("                  </Method>");
         bw.newLine();
         bw.write("               </MethodCollection>");
      }
   }

   //============================================================
   // <T>创建方法参数。</T>
   //
   // @param fJavascriptMethod 方法对象
   //============================================================
   private void createMethodParam(BufferedWriter bw,
                                  FJavascriptMethod fJavascriptMethod) throws IOException{
      //创建方法参数
      bw.newLine();
      bw.write("                     <ParameterCollection>");
      for(FJavascriptMethodParam methodParam : fJavascriptMethod.methodParam()){
         bw.newLine();
         bw.write("                        <Parameter code='" + methodParam.paramCode() + "' name='" + methodParam.paramName() + "' type='" + methodParam.paramType() + "' label='" + methodParam.paramAnnotation() + "'>");
      }

      bw.newLine();
      bw.write("                     <ParameterCollection>");
      if(fJavascriptMethod.methodReturn() != null){
         bw.newLine();
         bw.write("                     <ReturnParameter type='" + fJavascriptMethod.methodReturn().returnType() + "' label='" + fJavascriptMethod.methodReturn().returnAnnotation() + "'>");
      }
   }

}
