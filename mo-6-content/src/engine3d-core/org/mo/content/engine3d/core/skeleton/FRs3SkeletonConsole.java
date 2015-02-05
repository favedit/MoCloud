package org.mo.content.engine3d.core.skeleton;

import com.cyou.gccloud.data.data.FDataResource3dSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.com.console.FConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源3D蒙皮控制台。</T>
//============================================================
public class FRs3SkeletonConsole
      extends FConsole
      implements
         IRs3SkeletonConsole
{
   // 数据流控制台
   @ALink
   protected IRs3StreamConsole _streamConsole;

   //============================================================
   // <T>根据代码查找骨骼单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dSkeletonUnit findByCode(ILogicContext logicContext,
                                                 String code){
      String searchSql = FDataResource3dSkeletonLogic.CODE + "='" + code + "'";
      FDataResource3dSkeletonLogic logic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
      FDataResource3dSkeletonUnit unit = logic.search(searchSql);
      return unit;
   }

   //============================================================
   // <T>新建一个蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param skeletonId 骨骼编号
   // @param skin 蒙皮
   // @return 蒙皮单元
   //============================================================
   @Override
   public FDataResource3dSkeletonSkinUnit insertSkin(ILogicContext logicContext,
                                                     long meshId,
                                                     long skeletonId,
                                                     FRs3SkeletonSkin skin){
      // 新建跟踪
      FDataResource3dSkeletonSkinLogic skeletonSkinLogic = logicContext.findLogic(FDataResource3dSkeletonSkinLogic.class);
      FDataResource3dSkeletonSkinUnit skeletonSkinUnit = skeletonSkinLogic.doPrepare();
      skeletonSkinUnit.setSkeletonId(skeletonId);
      skin.saveUnit(skeletonSkinUnit);
      skeletonSkinLogic.doInsert(skeletonSkinUnit);
      // 新建数据流集合
      for(FRs3Stream stream : skin.streams()){
         // 新建数据流
         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
         // 关联蒙皮和数据流
         FDataResource3dSkeletonSkinStreamLogic skeletonSkinStreamLogic = logicContext.findLogic(FDataResource3dSkeletonSkinStreamLogic.class);
         FDataResource3dSkeletonSkinStreamUnit skeletonSkinStreamUnit = skeletonSkinStreamLogic.doPrepare();
         skeletonSkinStreamUnit.setSkeletonId(skeletonId);
         skeletonSkinStreamUnit.setSkeletonSkinId(skeletonSkinUnit.ouid());
         skeletonSkinStreamUnit.setStreamId(streamUnit.ouid());
         skeletonSkinStreamLogic.doInsert(skeletonSkinStreamUnit);
      }
      // 返回骨骼皮肤单元
      return skeletonSkinLogic.find(skeletonSkinUnit.ouid());
   }
}
