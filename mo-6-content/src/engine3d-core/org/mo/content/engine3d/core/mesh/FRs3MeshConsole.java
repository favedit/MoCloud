package org.mo.content.engine3d.core.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.com.console.FConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.content.resource3d.model.FRs3ModelStream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源数据流控制台。</T>
//============================================================
public class FRs3MeshConsole
      extends FConsole
      implements
         IRs3MeshConsole
{
   // 存储控制台
   @ALink
   protected IRs3StreamConsole _streamConsole;

   //============================================================
   // <T>新建一个网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   // @return 网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit insert(ILogicContext logicContext,
                                         FRs3ModelMesh mesh){
      // 新建模型
      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit meshUnit = meshLogic.doPrepare();
      meshUnit.setFullCode(mesh.fullCode());
      meshUnit.setCode(mesh.code());
      meshLogic.doInsert(meshUnit);
      // 新建数据流
      for(FRs3ModelStream stream : mesh.streams()){
         // 新建数据流
         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
         // 建立网格和数据流关联
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FDataResource3dMeshStreamUnit meshStreamUnit = meshStreamLogic.doPrepare();
         meshStreamUnit.setMeshId(meshUnit.ouid());
         meshStreamUnit.setStreamId(streamUnit.ouid());
         meshStreamLogic.doInsert(meshStreamUnit);
      }
      // 返回网格单元
      return meshLogic.find(meshUnit.ouid());
   }
}
