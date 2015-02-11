package org.mo.content.resource3d;

import org.mo.core.aop.RAop;

public class RRs3ImportHome
{
   public static String Config = "application-home.xml";

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      // 设置变量
      RRs3Configuration.Config = RRs3ImportLocal.Config;
      // 设置环境
      String configPath = RRs3Configuration.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Configuration.Config);
      // 导入处理
      RRs3TextureImport.importProcess();
      RRs3ModelImport.importProcess();
      Rs3TemplateImport.importProcess();
      Rs3SceneImport.importProcess();
      // 释放环境
      RAop.release();
   }
}
