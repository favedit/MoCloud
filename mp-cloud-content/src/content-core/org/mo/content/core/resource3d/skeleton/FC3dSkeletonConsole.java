package org.mo.content.core.resource3d.skeleton;

import com.cyou.gccloud.data.data.FDataResource3dMeshSkinLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import org.mo.com.lang.FFatalError;
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
      //FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      //FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = modelMeshLogic.fetch(FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId);
      // 获得蒙皮集合
      FDataResource3dSkeletonSkinLogic skeletonSkinLogic = logicContext.findLogic(FDataResource3dSkeletonSkinLogic.class);
      FLogicDataset<FDataResource3dSkeletonSkinUnit> skeletonSkinUnits = skeletonSkinLogic.fetch(FDataResource3dSkeletonSkinLogic.SKELETON_ID + "=" + skeletonId);
      for(FDataResource3dSkeletonSkinUnit skeletonSkinUnit : skeletonSkinUnits){
         long skeletonSkinId = skeletonSkinUnit.ouid();
         // 创建蒙皮
         FRs3SkeletonSkin skin = new FRs3SkeletonSkin();
         skin.loadUnit(skeletonSkinUnit);
         //............................................................
         // 查询网格数据
         String meshSql = "(" + FDataResource3dMeshSkinLogic.SKELETON_ID + "=" + skeletonId + ")";
         meshSql += " AND (" + FDataResource3dMeshSkinLogic.SKELETON_SKIN_ID + "=" + skeletonSkinId + ")";
         FDataResource3dMeshSkinLogic meshSkinLogic = logicContext.findLogic(FDataResource3dMeshSkinLogic.class);
         FLogicDataset<FDataResource3dMeshSkinUnit> meshSkinUnits = meshSkinLogic.fetch(meshSql);
         if(meshSkinUnits.count() != 1){
            throw new FFatalError("Skin mesh is too many. (skeleton_skin_id={1}, count={2})", skeletonSkinId, meshSkinUnits.count());
         }
         FDataResource3dMeshUnit meshUnit = meshSkinUnits.first().mesh();
         skin.setMeshGuid(meshUnit.guid());
         //............................................................
         // 查询网格的蒙皮数据
         String serachSql = "(" + FDataResource3dSkeletonSkinStreamLogic.SKELETON_ID + "=" + skeletonId + ")";
         serachSql += " AND (" + FDataResource3dSkeletonSkinStreamLogic.SKELETON_SKIN_ID + "=" + skeletonSkinId + ")";
         FDataResource3dSkeletonSkinStreamLogic skeletonSkinStreamLogic = logicContext.findLogic(FDataResource3dSkeletonSkinStreamLogic.class);
         FLogicDataset<FDataResource3dSkeletonSkinStreamUnit> skeletonSkinStreamUnits = skeletonSkinStreamLogic.fetch(serachSql);
         if(skeletonSkinStreamUnits.isEmpty()){
            throw new FFatalError("Skin stream is not exists. (skin_id={1})", skeletonSkinId);
         }
         // 构建数据流
         for(FDataResource3dSkeletonSkinStreamUnit skeletonSkinStreamUnit : skeletonSkinStreamUnits){
            long streamId = skeletonSkinStreamUnit.streamId();
            FRs3Stream stream = _streamConsole.makeStream(logicContext, streamId);
            skin.pushStream(stream);
         }
         skeleton.pushSkin(skin);
      }
      return skeleton;
   }
}
