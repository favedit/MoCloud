package org.mo.content.engine.core.material;

import org.mo.cloud.logic.resource.material.FGcResMaterialBitmapConsole;

//============================================================
// <T>资源材质位图控制台。</T>
//============================================================
public class FResMaterialBitmapConsole
      extends FGcResMaterialBitmapConsole
      implements
         IResMaterialBitmapConsole
{
   //   //============================================================
   //   // <T>根据代码查找模型单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
   //                                              String code){
   //      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
   //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FDataResource3dModelUnit modelUnit = modelLogic.search(searchSql);
   //      return modelUnit;
   //   }
   //
   //   //============================================================
   //   // <T>新建一个材质组。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param materialGroup 材质组
   //   // @return 材质组单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMaterialGroupUnit insertMaterialGroup(ILogicContext logicContext,
   //                                                               FRs3MaterialGroup materialGroup){
   //      // 新建材质
   //      FDataResource3dMaterialGroupLogic materialGroupLogic = logicContext.findLogic(FDataResource3dMaterialGroupLogic.class);
   //      FDataResource3dMaterialGroupUnit materialGroupUnit = materialGroupLogic.doPrepare();
   //      materialGroupUnit.setCode(materialGroup.code());
   //      materialGroupUnit.setLabel(materialGroup.label());
   //      materialGroupLogic.doInsert(materialGroupUnit);
   //      // 返回材质单元
   //      return materialGroupLogic.find(materialGroupUnit.ouid());
   //   }
}
