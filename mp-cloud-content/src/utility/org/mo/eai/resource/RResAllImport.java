package org.mo.eai.resource;

import org.mo.content.common.RRs3Configuration;
import org.mo.core.aop.RAop;

public class RResAllImport
{
   public static String Config = "application-home.xml";

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      // 设置变量
      RRs3Configuration.Config = RResAllImport.Config;
      // 设置环境
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-content/src/config/" + RRs3Configuration.Config);
      // 导入处理
      RResBitmapImport.importProcess();
      RResModelImport.importProcess();
      RResTemplateImport.importProcess();
      RResSceneImport.importProcess();
      // 释放环境
      RAop.release();
   }
}
