package org.mo.content.engine3d.core.texture;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源纹理位图控制台。</T>
//============================================================
public class FResTextureBitmapConsole
      extends FConsole
      implements
         IResTextureBitmapConsole
{
   //   // 存储控制台
   //   @ALink
   //   protected IGcStorageConsole _storageConsole;
   //
   //   //============================================================
   //   // <T>根据代码查找纹理位图单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param textureId 纹理编号
   //   // @param code 代码
   //   // @return 纹理单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dTextureBitmapUnit findByCode(ILogicContext logicContext,
   //                                                      long textureId,
   //                                                      String code){
   //      String searchSql = "(" + FDataResource3dTextureBitmapLogic.TEXTURE_ID + "=" + textureId + ")";
   //      searchSql += " AND (" + FDataResource3dTextureBitmapLogic.CODE + "='" + code + "')";
   //      FDataResource3dTextureBitmapLogic bitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
   //      FDataResource3dTextureBitmapUnit bitmapUnit = bitmapLogic.search(searchSql);
   //      return bitmapUnit;
   //   }
   //
   //   //============================================================
   //   // <T>逻辑处理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @param version 版本
   //   //============================================================
   //   @Override
   //   public FDataResourceBitmapImageUnit findBitmapUnit(ILogicContext logicContext,
   //                                                      String code,
   //                                                      String version){
   //      // 获得纹理位图信息
   //      FDataResource3dTextureBitmapLogic textureBitmapLogic = logicContext.findLogic(FDataResource3dTextureBitmapLogic.class);
   //      FDataResource3dTextureBitmapUnit textureBitmapUnit = textureBitmapLogic.findByGuid(code);
   //      if(textureBitmapUnit == null){
   //         return null;
   //      }
   //
   //      FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
   //      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.find(textureBitmapUnit.bitmapId());
   //
   //      String bitmapSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid();
   //      FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
   //      FDataResourceBitmapImageUnit bitmapImageUnit = bitmapImageLogic.search(bitmapSql);
   //      return bitmapImageUnit;
   //   }
   //
   //   //============================================================
   //   // <T>逻辑处理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @param version 版本
   //   //============================================================
   //   @Override
   //   public FDataResourceBitmapImageUnit findBitmapUnit(ILogicContext logicContext,
   //                                                      long bitmapId){
   //      // 查找位图
   //      FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
   //      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.find(bitmapId);
   //      // 查找图片
   //      String bitmapSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapUnit.ouid();
   //      FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
   //      FDataResourceBitmapImageUnit bitmapImageUnit = bitmapImageLogic.search(bitmapSql);
   //      return bitmapImageUnit;
   //   }
}
