package org.mo.content.resource3d;

import org.mo.core.aop.RAop;

public class RRs3Import
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      // 设置环境
      String configPath = RRs3Utility.RootPath + "/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/" + RRs3Utility.Config);
      // 导入处理
      RRs3TextureImport.importProcess();
      RRs3ModelImport.importProcess();
      Rs3TemplateImport.importProcess();
      Rs3SceneImport.importProcess();
      // 释放环境
      RAop.release();
   }
}
