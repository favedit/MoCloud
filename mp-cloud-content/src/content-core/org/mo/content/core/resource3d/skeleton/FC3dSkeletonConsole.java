package org.mo.content.core.resource3d.skeleton;

import com.cyou.gccloud.data.data.FDataResource3dMeshSkinStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshSkinStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dSkeletonConsole
      implements
         IC3dSkeletonConsole
{
   // 存储管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   @Override
   public FRs3Skeleton makeSkeleton(ILogicContext logicContext,
                                    long modelId,
                                    long skeletonId){
      FRs3Skeleton skeleton = new FRs3Skeleton();
      // 获得骨骼信息
      FDataResource3dSkeletonLogic skeletonLogic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
      FDataResource3dSkeletonUnit skeletonUnit = skeletonLogic.find(skeletonId);
      if(skeletonUnit == null){
         return null;
      }
      skeleton.loadUnit(skeletonUnit);
      // 获得网格集合
      FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = modelMeshLogic.fetch(FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId);
      // 获得蒙皮集合
      FDataResource3dSkeletonSkinLogic skeletonSkinLogic = logicContext.findLogic(FDataResource3dSkeletonSkinLogic.class);
      FLogicDataset<FDataResource3dSkeletonSkinUnit> skeletonSkinUnits = skeletonSkinLogic.fetch(FDataResource3dSkeletonSkinLogic.SKELETON_ID + "=" + skeletonId);
      for(FDataResource3dSkeletonSkinUnit skeletonSkinUnit : skeletonSkinUnits){
         // 创建蒙皮
         FRs3SkeletonSkin skin = new FRs3SkeletonSkin();
         skin.loadUnit(skeletonSkinUnit);
         // 查询蒙皮数据
         for(FDataResource3dModelMeshUnit modelMeshUnit : modelMeshUnits){
            long meshId = modelMeshUnit.meshId();
            // 查询网格的蒙皮数据
            String serachSql = "(" + FDataResource3dMeshSkinStreamLogic.MESH_ID + "=" + meshId + ") AND (" + FDataResource3dMeshSkinStreamLogic.SKELETON_ID + "=" + skeletonId + ")";
            FDataResource3dMeshSkinStreamLogic meshSkinStreamLogic = logicContext.findLogic(FDataResource3dMeshSkinStreamLogic.class);
            FLogicDataset<FDataResource3dMeshSkinStreamUnit> meshSkinStreamUnits = meshSkinStreamLogic.fetch(serachSql);
            for(FDataResource3dMeshSkinStreamUnit meshSkinStreamUnit : meshSkinStreamUnits){
               long streamId = meshSkinStreamUnit.streamId();
               // 构建数据流
               FRs3Stream stream = _streamConsole.makeStream(logicContext, streamId);
               skin.pushStream(stream);
            }
         }
      }
      return skeleton;
   }
}
