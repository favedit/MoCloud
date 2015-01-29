package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源纹理位图控制台。</T>
//============================================================
public class FRs3TextureBitmapConsole
      extends FConsole
      implements
         IRs3TextureBitmapConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>根据代码查找纹理位图单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param textureId 纹理编号
   // @param code 代码
   // @return 纹理单元
   //============================================================
   @Override
   public FDataResource3dTextureBitmapUnit findByCode(ILogicContext logicContext,
                                                      long textureId,
                                                      String code){
      String searchSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ")";
      searchSql += " AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + code + "')";
      FDataResource3dTextureBitmapLogic bitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
      FDataResource3dTextureBitmapUnit bitmapUnit = bitmapLogic.search(searchSql);
      return bitmapUnit;
   }
}
