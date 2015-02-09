package org.mo.util.javascript;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.mo.script.javascript.FJavascriptClass;
import org.mo.script.javascript.FJavascriptInput;
import org.mo.script.javascript.FJavascriptMethod;
import org.mo.script.javascript.FJavascriptMethodParam;
import org.mo.script.javascript.FJavascriptOutput;
import org.mo.script.javascript.FJavascriptPackage;

public class RJsCompileJava
{
   public static void main(String[] args) throws Exception{
      File root = new File("E:\\Microbject\\MoScript\\source-v2");
      List<FJavascriptPackage> packageList = new ArrayList<FJavascriptPackage>();
      List<FJavascriptClass> classList = new ArrayList<FJavascriptClass>();
      List<FJavascriptMethod> methodList = new ArrayList<FJavascriptMethod>();
      List<FJavascriptMethodParam> methodParamList = new ArrayList<FJavascriptMethodParam>();

      FJavascriptInput process = new FJavascriptInput(packageList, classList, methodList, methodParamList);
      process.foreachFiles(root);

      File xmlFile = new File("E:\\Microbject\\MoScript\\source-v2\\javascript-help.xml");
      FJavascriptOutput outputToXml = new FJavascriptOutput(packageList, classList, methodList, methodParamList);
      outputToXml.outputHelp(xmlFile);

   }
}
