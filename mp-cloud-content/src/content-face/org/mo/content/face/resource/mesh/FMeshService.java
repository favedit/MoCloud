package org.mo.content.face.resource.mesh;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.engine3d.core.mesh.IRs3MeshConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>目录描述服务。</T>
//============================================================
public class FMeshService
      extends FObject
      implements
         IMeshService
{
   // 网格控制台
   @ALink
   protected IRs3MeshConsole _meshConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FMeshService(){
   }

   //============================================================
   // <T>获得模型列表。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       ILogicContext logicContext,
                       IWebInput input,
                       IWebOutput output){
      FXmlNode xoutput = output.config();
      //      // 获得模型信息
      //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      //      FLogicDataset<FDataResource3dModelUnit> modelUnits = modelLogic.fetchAll();
      //      for(FDataResource3dModelUnit modelUnit : modelUnits){
      //         // 创建树节点
      //         FXmlNode xnode = xoutput.createNode("TreeNode");
      //         xnode.set("name", modelUnit.code());
      //         xnode.set("label", modelUnit.code());
      //         xnode.set("type", "Model");
      //      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output){
      //      String code = context.parameter("code");
      //      // 查找目录定义
      //      XTreeView xtree = _treeConsole.find(_storageName, code);
      //      if(xtree == null){
      //         return EResult.Failure;
      //      }
      //      // 转换数据
      //      FXmlNode xconfig = output.config().createNode();
      //      FPersistence persistence = _persistenceConsole.findPersistence(_storageName, "design.tree");
      //      FContentObject content = persistence.convertConfig(xtree);
      //      // 存储输出
      //      content.saveConfig(xconfig);
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      //      // 检查输入
      //      FXmlNode xmesh = input.config();
      //      if(!xmesh.isName("Mesh")){
      //         throw new FFatalError("Invalid config code.");
      //      }
      //      // 获得唯一编号
      //      String guid = xmesh.get("guid");
      //      if(RString.isEmpty(guid)){
      //         throw new FFatalError("Parameter guid is empry. (guid={1})", guid);
      //      }
      //      // 合并场景
      //      FRs3Mesh mesh = _meshConsole.makeMesh(logicContext, guid);
      //      mesh.mergeConfig(xmesh);
      //      // 更新场景
      //      _meshConsole.updateMesh(logicContext, mesh);
      return EResult.Success;
   }
}
