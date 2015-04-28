package org.mo.cloud.logic.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceMaterialLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源材质信息控制台。</T>
//============================================================
public class FGcResMaterialConsole
      extends FAbstractLogicUnitConsole<FDataResourceMaterialLogic, FGcResMaterialInfo>
      implements
         IGcResMaterialConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源控制台
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   // 资源材质位图控制台
   @ALink
   protected IGcResMaterialBitmapConsole _dataMaterialBitmapConsole;

   //============================================================
   // <T>构造资源材质信息控制台。</T>
   //============================================================
   public FGcResMaterialConsole(){
      super(FDataResourceMaterialLogic.class, FGcResMaterialInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResMaterialInfo findByResourceId(ILogicContext logicContext,
                                              long resourceId){
      String whereSql = FDataResourceMaterialLogic.RESOURCE_ID + "=" + resourceId;
      FGcResMaterialInfo bitmap = search(logicContext, whereSql);
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
   public FGcResMaterialInfo findByResourceGuid(ILogicContext logicContext,
                                                String resourceGuid){
      FGcResMaterialInfo bitmap = null;
      FGcResourceInfo resource = _dataResourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         bitmap = findByResourceId(logicContext, resourceId);
      }
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
                                    FGcResMaterialInfo materialInfo){
      // 检查用户编号
      long userId = materialInfo.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _dataResourceConsole.doPrepare(logicContext);
      resource.setUserId(userId);
      resource.setProjectId(materialInfo.projectId());
      resource.setCatalogId(materialInfo.catalogId());
      resource.setResourceCd(EGcResource.Material);
      resource.setCode(materialInfo.code());
      resource.setLabel(materialInfo.label());
      _dataResourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      materialInfo.setGuid(resource.guid());
      materialInfo.setResourceId(resource.ouid());
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
                                    FGcResMaterialInfo materialInfo){
      long materialId = materialInfo.ouid();
      // 删除位图集合
      String bitmapWhereSql = FDataResourceMaterialBitmapLogic.MATERIAL_ID + "=" + materialId;
      FLogicDataset<FGcResMaterialBitmapInfo> bitmapDataset = _dataMaterialBitmapConsole.fetch(logicContext, bitmapWhereSql);
      if(bitmapDataset != null){
         for(FGcResMaterialBitmapInfo bitmapInfo : bitmapDataset){
            _dataMaterialBitmapConsole.doDelete(logicContext, bitmapInfo);
         }
      }
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
                                   FGcResMaterialInfo material){
      // 删除关联资源
      long resourceId = material.resourceId();
      _dataResourceConsole.doDelete(logicContext, resourceId);
      // 返回结果
      return EResult.Success;
   }
}
