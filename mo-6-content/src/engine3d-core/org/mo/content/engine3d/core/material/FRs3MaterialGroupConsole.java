package org.mo.content.engine3d.core.material;

import com.cyou.gccloud.data.data.FDataResource3dMaterialGroupLogic;
import com.cyou.gccloud.data.data.FDataResource3dMaterialGroupUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.com.console.FConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureBitmapConsole;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.content.resource3d.common.FRs3MaterialGroup;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3MaterialGroupConsole
      extends FConsole
      implements
         IRs3MaterialGroupConsole
{
   // 纹理控制台
   @ALink
   protected IRs3TextureConsole _textureConsole;

   // 纹理位图控制台
   @ALink
   protected IRs3TextureBitmapConsole _textureBitmapConsole;

   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.search(searchSql);
      return modelUnit;
   }

   //============================================================
   // <T>新建一个材质组。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialGroup 材质组
   // @return 材质组单元
   //============================================================
   @Override
   public FDataResource3dMaterialGroupUnit insertMaterialGroup(ILogicContext logicContext,
                                                               FRs3MaterialGroup materialGroup){
      // 新建材质
      FDataResource3dMaterialGroupLogic materialGroupLogic = logicContext.findLogic(FDataResource3dMaterialGroupLogic.class);
      FDataResource3dMaterialGroupUnit materialGroupUnit = materialGroupLogic.doPrepare();
      materialGroupUnit.setCode(materialGroup.code());
      materialGroupUnit.setLabel(materialGroup.label());
      materialGroupLogic.doInsert(materialGroupUnit);
      // 返回材质单元
      return materialGroupLogic.find(materialGroupUnit.ouid());
   }
}
