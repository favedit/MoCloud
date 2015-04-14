package org.mo.content.engine3d.core.skeleton;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源3D蒙皮控制台。</T>
//============================================================
public class FRs3SkeletonConsole
      extends FConsole
      implements
         IRs3SkeletonConsole
{
   //   // 数据流控制台
   //   @ALink
   //   protected IRs3StreamConsole _streamConsole;
   //
   //   //============================================================
   //   // <T>根据代码查找骨骼单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FDataResource3dSkeletonUnit findByCode(ILogicContext logicContext,
   //                                                 String code){
   //      String searchSql = FDataResource3dSkeletonLogic.CODE + "='" + code + "'";
   //      FDataResource3dSkeletonLogic logic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
   //      FDataResource3dSkeletonUnit unit = logic.search(searchSql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>新建一个蒙皮。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param skeletonId 骨骼编号
   //   // @param skin 蒙皮
   //   // @return 蒙皮单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dSkeletonSkinUnit insertSkin(ILogicContext logicContext,
   //                                                     long meshId,
   //                                                     long skeletonId,
   //                                                     FRs3SkeletonSkin skin){
   //      // 新建跟踪
   //      FDataResource3dSkeletonSkinLogic skeletonSkinLogic = logicContext.findLogic(FDataResource3dSkeletonSkinLogic.class);
   //      FDataResource3dSkeletonSkinUnit skeletonSkinUnit = skeletonSkinLogic.doPrepare();
   //      skeletonSkinUnit.setSkeletonId(skeletonId);
   //      skin.saveUnit(skeletonSkinUnit);
   //      skeletonSkinLogic.doInsert(skeletonSkinUnit);
   //      // 新建数据流集合
   //      for(FRs3Stream stream : skin.streams()){
   //         // 新建数据流
   //         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
   //         // 关联蒙皮和数据流
   //         FDataResource3dSkeletonSkinStreamLogic skeletonSkinStreamLogic = logicContext.findLogic(FDataResource3dSkeletonSkinStreamLogic.class);
   //         FDataResource3dSkeletonSkinStreamUnit skeletonSkinStreamUnit = skeletonSkinStreamLogic.doPrepare();
   //         skeletonSkinStreamUnit.setSkeletonId(skeletonId);
   //         skeletonSkinStreamUnit.setSkeletonSkinId(skeletonSkinUnit.ouid());
   //         skeletonSkinStreamUnit.setStreamId(streamUnit.ouid());
   //         skeletonSkinStreamLogic.doInsert(skeletonSkinStreamUnit);
   //      }
   //      // 返回骨骼皮肤单元
   //      return skeletonSkinLogic.find(skeletonSkinUnit.ouid());
   //   }
   //
   //   //============================================================
   //   // <T>构建蒙皮处理。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 蒙皮
   //   //============================================================
   //   @Override
   //   public FRs3Skeleton makeSkeleton(ILogicContext logicContext,
   //                                    long modelId,
   //                                    long skeletonId){
   //      FRs3Skeleton skeleton = new FRs3Skeleton();
   //      // 获得骨骼信息
   //      FDataResource3dSkeletonLogic skeletonLogic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
   //      FDataResource3dSkeletonUnit skeletonUnit = skeletonLogic.find(skeletonId);
   //      if(skeletonUnit == null){
   //         return null;
   //      }
   //      skeleton.loadUnit(skeletonUnit);
   //      // 获得网格集合
   //      //FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
   //      //FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = modelMeshLogic.fetch(FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId);
   //      // 获得蒙皮集合
   //      FDataResource3dSkeletonSkinLogic skeletonSkinLogic = logicContext.findLogic(FDataResource3dSkeletonSkinLogic.class);
   //      FLogicDataset<FDataResource3dSkeletonSkinUnit> skeletonSkinUnits = skeletonSkinLogic.fetch(FDataResource3dSkeletonSkinLogic.SKELETON_ID + "=" + skeletonId);
   //      for(FDataResource3dSkeletonSkinUnit skeletonSkinUnit : skeletonSkinUnits){
   //         long skeletonSkinId = skeletonSkinUnit.ouid();
   //         // 创建蒙皮
   //         FRs3SkeletonSkin skin = new FRs3SkeletonSkin();
   //         skin.loadUnit(skeletonSkinUnit);
   //         //............................................................
   //         // 查询网格数据
   //         String meshSql = "(" + FDataResource3dMeshSkinLogic.SKELETON_ID + "=" + skeletonId + ")";
   //         meshSql += " AND (" + FDataResource3dMeshSkinLogic.SKELETON_SKIN_ID + "=" + skeletonSkinId + ")";
   //         FDataResource3dMeshSkinLogic meshSkinLogic = logicContext.findLogic(FDataResource3dMeshSkinLogic.class);
   //         FLogicDataset<FDataResource3dMeshSkinUnit> meshSkinUnits = meshSkinLogic.fetch(meshSql);
   //         if(meshSkinUnits.count() != 1){
   //            throw new FFatalError("Skin mesh is too many. (skeleton_skin_id={1}, count={2})", skeletonSkinId, meshSkinUnits.count());
   //         }
   //         FDataResource3dMeshUnit meshUnit = meshSkinUnits.first().mesh();
   //         skin.setMeshGuid(meshUnit.guid());
   //         //............................................................
   //         // 查询网格的蒙皮数据
   //         String serachSql = "(" + FDataResource3dSkeletonSkinStreamLogic.SKELETON_ID + "=" + skeletonId + ")";
   //         serachSql += " AND (" + FDataResource3dSkeletonSkinStreamLogic.SKELETON_SKIN_ID + "=" + skeletonSkinId + ")";
   //         FDataResource3dSkeletonSkinStreamLogic skeletonSkinStreamLogic = logicContext.findLogic(FDataResource3dSkeletonSkinStreamLogic.class);
   //         FLogicDataset<FDataResource3dSkeletonSkinStreamUnit> skeletonSkinStreamUnits = skeletonSkinStreamLogic.fetch(serachSql);
   //         if(skeletonSkinStreamUnits.isEmpty()){
   //            throw new FFatalError("Skin stream is not exists. (skin_id={1})", skeletonSkinId);
   //         }
   //         // 构建数据流
   //         for(FDataResource3dSkeletonSkinStreamUnit skeletonSkinStreamUnit : skeletonSkinStreamUnits){
   //            long streamId = skeletonSkinStreamUnit.streamId();
   //            FRs3Stream stream = _streamConsole.makeStream(logicContext, streamId);
   //            skin.pushStream(stream);
   //         }
   //         skeleton.pushSkin(skin);
   //      }
   //      return skeleton;
   //   }
}
