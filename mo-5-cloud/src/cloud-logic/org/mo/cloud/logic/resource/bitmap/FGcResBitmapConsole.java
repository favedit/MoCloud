package org.mo.cloud.logic.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
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

   // 位图图像管理器
   @ALink
   protected IGcResBitmapImageConsole _dataBitmapImageConsole;

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
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult onDeleteBefore(ILogicContext logicContext,
                                 FGcResBitmapInfo unit){
      long bitmapId = unit.ouid();
      // 删除网格数据流集合
      FDataResourceBitmapImageLogic bitmapImageLogic = logicContext.findLogic(FDataResourceBitmapImageLogic.class);
      String whereSql = FDataResourceBitmapImageLogic.BITMAP_ID + "=" + bitmapId;
      FLogicDataset<FGcResBitmapImageInfo> bitmapImageDataset = bitmapImageLogic.fetchClass(FGcResBitmapImageInfo.class, whereSql);
      if(bitmapImageDataset != null){
         for(FGcResBitmapImageInfo bitmapImageUnit : bitmapImageDataset){
            _dataBitmapImageConsole.doDelete(logicContext, bitmapImageUnit);
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
