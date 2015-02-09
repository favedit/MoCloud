package org.mo.content.core.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>场景控制台。</T>
//============================================================
public class FC3dSceneConsole
      extends FAbstractLogicUnitConsole<FDataResource3dSceneLogic, FDataResource3dSceneUnit>
      implements
         IC3dSceneConsole
{

   //============================================================
   // <T>构造场景控制台。</T>
   //============================================================
   public FC3dSceneConsole(){
      super(FDataResource3dSceneLogic.class, FDataResource3dSceneUnit.class);
   }

   //============================================================
   // <T>根据代码查找模板单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模板单元
   //============================================================
   public FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                              String code){
      String sql = FDataResource3dSceneLogic.CODE + "='" + code + "'";
      FDataResource3dSceneLogic logic = logicContext.findLogic(FDataResource3dSceneLogic.class);
      FDataResource3dSceneUnit unit = logic.search(sql);
      return unit;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   @Override
   public FRs3Scene makeScene(ILogicContext logicContext,
                              String guid,
                              String code){
      // 查找数据
      FDataResource3dSceneUnit sceneUnit = null;
      if(!RString.isEmpty(guid)){
         sceneUnit = findByGuid(logicContext, guid);
      }else if(!RString.isEmpty(code)){
         sceneUnit = findByCode(logicContext, code);
      }else{
         throw new FFatalError("Find scene failure. (guid={1}, code={2})", guid, code);
      }
      // 未查到处理
      if(sceneUnit == null){
         return null;
      }
      // 创建场景
      FRs3Scene scene = new FRs3Scene();
      scene.loadUnit(sceneUnit);
      return scene;
   }
}
