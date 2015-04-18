package org.mo.content.core.resource.scene;

import org.mo.com.lang.EResult;
import org.mo.content.engine3d.core.scene.IResSceneConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容场景控制台接口。</T>
//============================================================
public interface ICntSceneConsole
      extends
         IResSceneConsole
{
   //============================================================
   // <T>根据资源编号删除场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByResourceId(ILogicContext logicContext,
                                long userId,
                                long resourceId);

   //   //============================================================
   //   // <T>获取数据处理。</T>
   //   //
   //   // @param context 逻辑环境
   //   // @param xoutput 输出内容
   //   // @param serach 搜索内容
   //   // @param pageSize 页面大小
   //   // @param page 页面编号
   //   // @return 处理结果
   //   //============================================================
   //   EResult fetch(ILogicContext context,
   //                 FXmlNode xoutput,
   //                 String serach,
   //                 int pageSize,
   //                 int page);
   //
   //   //============================================================
   //   // <T>更新场景。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param scene 场景
   //   //============================================================
   //   EResult updateScene(ILogicContext logicContext,
   //                       FRs3Scene scene);
   //
   //   //============================================================
   //   // <T>更新场景主题。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param scene 场景
   //   //============================================================
   //   EResult updateSceneTheme(ILogicContext logicContext,
   //                            FRs3Scene scene);
}
