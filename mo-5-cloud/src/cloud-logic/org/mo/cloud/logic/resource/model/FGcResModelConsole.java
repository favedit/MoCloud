package org.mo.cloud.logic.resource.model;

import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源位图信息控制台。</T>
//============================================================
public class FGcResModelConsole
      extends FAbstractLogicUnitConsole<FDataResourceBitmapLogic, FGcResModelInfo>
      implements
         IGcResModelConsole
{
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResModelConsole(){
      super(FDataResourceBitmapLogic.class, FGcResModelInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResModelInfo findByResourceId(ILogicContext logicContext,
                                            long resourceId){
      String whereSql = FDataResourceBitmapLogic.RESOURCE_ID + "=" + resourceId;
      FGcResModelInfo bitmap = search(logicContext, whereSql);
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
   public FGcResModelInfo findByResourceGuid(ILogicContext logicContext,
                                              String resourceGuid){
      FGcResModelInfo bitmap = null;
      FGcResourceInfo resource = _resourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         bitmap = findByResourceId(logicContext, resourceId);
      }
      return bitmap;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult onDeleteBefore(ILogicContext logicContext,
                                 FGcResModelInfo unit){
      //      long bitmapId = unit.ouid();
      // 删除网格数据流集合
      //      FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
      //      String whereSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapId;
      //      FLogicDataset<FGcResBitmapImageInfo> bitmapImageDataset = bitmapImageLogic.fetchClass(FGcResBitmapImageInfo.class, whereSql);
      //      if(bitmapImageDataset != null){
      //         for(FGcResBitmapImageInfo bitmapImageUnit : bitmapImageDataset){
      //            _dataBitmapImageConsole.doDelete(logicContext, bitmapImageUnit);
      //         }
      //      }
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
   public EResult onDeleteAfter(ILogicContext logicContext,
                                FGcResModelInfo unit){
      // 删除关联资源
      long resourceId = unit.resourceId();
      if(resourceId > 0){
         _resourceConsole.doDelete(logicContext, resourceId);
      }
      // 返回结果
      return EResult.Success;
   }
}
