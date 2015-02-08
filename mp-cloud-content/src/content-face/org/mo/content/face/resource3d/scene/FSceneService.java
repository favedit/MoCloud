package org.mo.content.face.resource3d.scene;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D模板服务。</T>
//============================================================
public class FSceneService
      extends FObject
      implements
         ISceneService
{
   @ALink
   protected IC3dSceneConsole _sceneConsole;

   //============================================================
   // <T>构造资源3D模板服务。</T>
   //============================================================
   public FSceneService(){
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      FRs3Scene scene = _sceneConsole.makeScene(logicContext, guid, code);
      FXmlNode xconfig = output.config().createNode("Scene");
      scene.saveConfig(xconfig);
      return EResult.Success;
   }
}
