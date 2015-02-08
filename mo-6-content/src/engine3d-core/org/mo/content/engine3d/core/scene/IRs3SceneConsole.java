package org.mo.content.engine3d.core.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源场景控制台接口。</T>
//============================================================
public interface IRs3SceneConsole
{
   //============================================================
   // <T>根据代码查找资源场景单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dSceneUnit findByCode(ILogicContext logicContext,
                                       String code);

   //============================================================
   // <T>导入场景。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importScene(ILogicContext logicContext,
                       String fileName);
}
