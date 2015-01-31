package org.mo.cloud.content.describe.tree;

import org.mo.cloud.content.design.tree.common.XTreeView;

import org.mo.cloud.content.design.tree.ITreeConsole;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>目录描述服务。</T>
//============================================================
public class FTreeService
      implements
         ITreeService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容列表控制台接口
   @ALink
   protected ITreeConsole _treeConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FTreeService(){
   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      XTreeView[] xtrees = _treeConsole.list(_storageName);
      FXmlNode xconfig = output.config();
      for(XTreeView xtree : xtrees){
         FXmlNode xnode = xconfig.createNode("TreeNode");
         xnode.set("name", xtree.getName());
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
      String code = context.parameter("code");
      // 查找目录定义
      XTreeView xtree = _treeConsole.find(_storageName, code);
      if(xtree == null){
         return EResult.Failure;
      }
      // 转换数据
      FXmlNode xconfig = output.config().createNode();
      FPersistence persistence = _persistenceConsole.findPersistence(_storageName, "design.tree");
      FContentObject content = persistence.convertConfig(xtree);
      // 存储输出
      content.saveConfig(xconfig);
      return EResult.Success;
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult insert(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
