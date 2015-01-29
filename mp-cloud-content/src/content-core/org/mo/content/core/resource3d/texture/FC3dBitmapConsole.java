package org.mo.content.core.resource3d.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dBitmapConsole
      implements
         IC3dBitmapConsole
{

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   @Override
   public FDataResourceBitmapImageUnit findBitmapUnit(ILogicContext logicContext,
                                                      String code,
                                                      String version){
      // 获得纹理位图信息
      FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
      FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.findByGuid(code);
      if(textureBitmapUnit == null){
         return null;
      }

      FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.find(textureBitmapUnit.bitmapId());

      String bitmapSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid();
      FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
      FDataResourceBitmapImageUnit bitmapImageUnit = bitmapImageLogic.search(bitmapSql);
      return bitmapImageUnit;
   }
}
