package org.mo.content.face.resource3d.model;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>目录描述服务。</T>
//============================================================
public class FModelService
      implements
         IModelService
{
   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FModelService(){
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
      // 获得模型信息
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FLogicDataset<FDataResource3dModelUnit> modelUnits = modelLogic.fetchAll();
      for(FDataResource3dModelUnit modelUnit : modelUnits){
         // 创建树节点
         FXmlNode xnode = xoutput.createNode("TreeNode");
         xnode.set("name", modelUnit.code());
      }
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
}
