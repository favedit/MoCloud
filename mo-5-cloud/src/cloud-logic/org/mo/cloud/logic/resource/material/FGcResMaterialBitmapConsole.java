package org.mo.cloud.logic.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialBitmapLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源材质信息控制台。</T>
//============================================================
public class FGcResMaterialBitmapConsole
      extends FAbstractLogicUnitConsole<FDataResourceMaterialBitmapLogic, FGcResMaterialBitmapInfo>
      implements
         IGcResMaterialBitmapConsole
{
   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResMaterialBitmapConsole(){
      super(FDataResourceMaterialBitmapLogic.class, FGcResMaterialBitmapInfo.class);
   }

   //============================================================
   // <T>根据材质和代码查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialId 材质编号
   // @param code 代码
   // @return 位图信息
   //============================================================
   @Override
   public FGcResMaterialBitmapInfo findByMaterialCode(ILogicContext logicContext,
                                                      long materialId,
                                                      String code){
      String whereSql = "(" + FDataResourceMaterialBitmapLogic.MATERIAL_ID + "=" + materialId + ")";
      whereSql += " AND (" + FDataResourceMaterialBitmapLogic.CODE + "='" + code + "')";
      FGcResMaterialBitmapInfo bitmapInfo = search(logicContext, whereSql);
      return bitmapInfo;
   }
}
