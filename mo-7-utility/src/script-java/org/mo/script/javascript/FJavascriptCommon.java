package org.mo.script.javascript;

import java.util.ArrayList;
import java.util.List;

public class FJavascriptCommon
{
   protected List<FJavascriptPackage> packageList = new ArrayList<>();

   protected FJavascriptPackage javascriptPackage = new FJavascriptPackage();

   protected List<FJavascriptClass> classList = new ArrayList<>();

   protected FJavascriptClass fJavascriptClass = new FJavascriptClass();

   protected List<FJavascriptMethod> methodList = new ArrayList<>();

   protected FJavascriptMethod fJavascriptMethod = new FJavascriptMethod();

   protected List<FJavascriptMethodParam> methodParamList = new ArrayList<>();

   protected FJavascriptMethodParam methodParam = new FJavascriptMethodParam();
}
