package org.mo.cloud.logic.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
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
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

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
      FGcResourceInfo resource = _resourceConsole.findByGuid(logicContext, resourceGuid);
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
                                    FGcResBitmapInfo bitmap){
      // 检查用户编号
      long userId = bitmap.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _resourceConsole.doPrepare(logicContext);
      resource.setUserId(userId);
      resource.setProjectId(bitmap.projectId());
      resource.setCatalogId(bitmap.catalogId());
      resource.setResourceCd(EGcResource.Bitmap);
      resource.setCode(bitmap.code());
      resource.setLabel(bitmap.label());
      _resourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      bitmap.setResourceId(resource.ouid());
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
   public EResult onDeleteAfter(ILogicContext logicContext,
                                FGcResBitmapInfo unit){
      // 删除关联资源
      long resourceId = unit.resourceId();
      if(resourceId > 0){
         _resourceConsole.doDelete(logicContext, resourceId);
      }
      // 返回结果
      return EResult.Success;
   }
}
