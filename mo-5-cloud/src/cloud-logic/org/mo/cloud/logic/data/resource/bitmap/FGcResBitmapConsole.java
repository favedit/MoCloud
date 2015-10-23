package org.mo.cloud.logic.data.resource.bitmap;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;

import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import org.mo.cloud.logic.data.resource.IGcResourceConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源位图信息控制台。</T>
//============================================================
public class FGcResBitmapConsole
      extends FAbstractLogicUnitConsole<FDataResourceBitmapLogic, FGcResBitmapInfo>
      implements
         IGcResBitmapConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageMongoConsole _storageConsole;

   // 资源管理器
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResBitmapConsole(){
      super(FDataResourceBitmapLogic.class, FGcResBitmapInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResBitmapInfo findByResourceId(ILogicContext logicContext,
                                            long resourceId){
      String whereSql = FDataResourceBitmapLogic.RESOURCE_ID + "=" + resourceId;
      FGcResBitmapInfo bitmap = search(logicContext, whereSql);
      return bitmap;
   }

   //============================================================
   // <T>根据资源唯一编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResBitmapInfo findByResourceGuid(ILogicContext logicContext,
                                              String resourceGuid){
      FGcResBitmapInfo bitmap = null;
      FGcResourceInfo resource = _dataResourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         bitmap = findByResourceId(logicContext, resourceId);
      }
      return bitmap;
   }

   //============================================================
   // <T>根据用户编号和全代码编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param fullCode 全代码
   // @return 位图信息
   //============================================================
   @Override
   public FGcResBitmapInfo findByUserFullCode(ILogicContext logicContext,
                                              long userId,
                                              String fullCode){
      String whereSql = "(" + FDataResourceBitmapLogic.USER_ID + "=" + userId + ") AND (" + FDataResourceBitmapLogic.FULL_CODE + "='" + fullCode + "')";
      FGcResBitmapInfo bitmap = search(logicContext, whereSql);
      return bitmap;
   }

   //============================================================
   // <T>新建记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onInsertBefore(ILogicContext logicContext,
                                    FGcResBitmapInfo bitmapInfo){
      // 检查用户编号
      long userId = bitmapInfo.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _dataResourceConsole.doPrepare(logicContext);
      resource.setGuid(bitmapInfo.guid());
      resource.setUserId(userId);
      resource.setProjectId(bitmapInfo.projectId());
      resource.setCatalogId(bitmapInfo.catalogId());
      resource.setResourceCd(EGcResource.Bitmap);
      resource.setCode(bitmapInfo.code());
      resource.setLabel(bitmapInfo.label());
      _dataResourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      bitmapInfo.setResourceId(resource.ouid());
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteBefore(ILogicContext logicContext,
                                    FGcResBitmapInfo bitmapInfo){
      // 删除位图数据
      String guid = bitmapInfo.guid();
      _storageConsole.delete(EGcStorageMongoCatalog.CacheBitmapPreview, guid);
      _storageConsole.delete(EGcStorageMongoCatalog.ResourceBitmap, guid);
      // 返回结果
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteAfter(ILogicContext logicContext,
                                   FGcResBitmapInfo bitmapInfo){
      // 删除关联资源
      long resourceId = bitmapInfo.resourceId();
      if(resourceId > 0){
         _dataResourceConsole.doDelete(logicContext, resourceId);
      }
      // 返回结果
      return EResult.Success;
   }
}
