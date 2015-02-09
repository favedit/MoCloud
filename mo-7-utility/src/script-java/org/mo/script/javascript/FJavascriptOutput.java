package org.mo.script.javascript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.mo.com.lang.RDateTime;

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
   public void outputHelp(File xmlFile){
      try{
         //如果没有此文件创建一个
         if(!xmlFile.exists()){
            xmlFile.createNewFile();
         }
         String newTime = RDateTime.currentDateTime().format("YYYYMMDDHH24MISS").toString();
         System.out.println("startTime:" + newTime);
         FileWriter fw = new FileWriter(xmlFile.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         createHeader(bw);
         //创建包XML
         for(FJavascriptPackage javascriptPackage : packageList){
            bw.newLine();
            bw.write("      <Namespace name='" + javascriptPackage.packageName() + "'>");
            //创建类xml
            for(FJavascriptClass fJavascriptClass : javascriptPackage.classes()){
               bw.newLine();
               bw.write("         <ClassCollection>");
               bw.newLine();
               bw.write("            <Class name='" + fJavascriptClass.className() + "' label='" + fJavascriptClass.classAnnotation() + "'>");
               createMethod(bw, fJavascriptClass);
               bw.newLine();
               bw.write("            </Class>");
               bw.newLine();
               bw.write("         </ClassCollection>");
            }
            bw.newLine();
            bw.write("      </Namespace>");
         }
         createFooter(bw);
         String endTime = RDateTime.currentDateTime().format("YYYYMMDDHH24MISS").toString();
         System.out.println("endTime:" + endTime);
         bw.close();
      }catch(IOException e){
         e.printStackTrace();
      }
   }

   //============================================================
   // <T>创建方法。</T>
   //
   // @param fJavascriptClass 类对象
   //============================================================
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

   //============================================================
   // <T>创建XML底部。</T>
   //
   // @param bw 流对象
   //============================================================
   private void createFooter(BufferedWriter bw) throws IOException{
      String endConfiguration = "</Configuration>";
      String endNamespaceCollection = "   </NamespaceCollection>";
      bw.newLine();
      bw.write(endNamespaceCollection);
      bw.newLine();
      bw.write(endConfiguration);
   }

   //============================================================
   // <T>创建XML头部。</T>
   //
   // @param bw 流对象
   //============================================================
   private void createHeader(BufferedWriter bw) throws IOException{
      String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
      String configuration = "<Configuration>";
      String namespaceCollection = "   <NamespaceCollection>";
      bw.write(header);
      bw.newLine();
      bw.write(configuration);
      bw.newLine();
      bw.write(namespaceCollection);
   }
}
