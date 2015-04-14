package org.mo.content.face.resource.template;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine3d.core.material.IRs3MaterialConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D模板服务。</T>
//============================================================
public class FTemplateService
      extends FObject
      implements
         ITemplateService
{
   @ALink
   protected IRs3MaterialConsole _materialConsole;

   //============================================================
   // <T>构造资源3D模板服务。</T>
   //============================================================
   public FTemplateService(){
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public void updateMaterial(ILogicContext logicContext,
                              FXmlNode xmaterial){
      //      String guid = xmaterial.get("guid");
      //      FRs3Material material = _materialConsole.findMaterial(logicContext, guid);
      //      material.setAlphaBase(xmaterial.getFloat("alpha_base"));
      //      material.setAlphaRate(xmaterial.getFloat("alpha_rate"));
      //      material.ambientColor().parse(xmaterial.get("ambient_color"));
      //      material.diffuseColor().parse(xmaterial.get("diffuse_color"));
      //      material.specularColor().parse(xmaterial.get("specular_color"));
      //      material.setSpecularLevel(xmaterial.getFloat("specular_level"));
      //      material.reflectColor().parse(xmaterial.get("reflect_color"));
      //      material.setReflectMerge(xmaterial.getFloat("reflect_merge"));
      //      material.emissiveColor().parse(xmaterial.get("emissive_color"));
      //      _materialConsole.updateMaterial(logicContext, material);
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
   public EResult update(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      FXmlNode xinput = input.config();
      for(FXmlNode xnode : xinput.nodes()){
         if(xnode.isName("Material")){
            updateMaterial(logicContext, xnode);
         }
      }
      return EResult.Success;
   }
}
