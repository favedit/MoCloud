package org.mo.cloud.editor.design.tree;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.tree.ITreeConsole;
import org.mo.cloud.content.design.tree.common.XTreeView;
import org.mo.cloud.editor.design.common.FAbstractDesignService;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>设计目录服务。</T>
//============================================================
public class FTreeService
      extends FAbstractDesignService
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
   // <T>构造设计目录服务。</T>
   //============================================================
   public FTreeService(){
   }

   //============================================================
   // <T>获得内容列表处理。</T>
   //
   // @return 内容列表
   //============================================================
   @Override
   protected XContentObject[] contentList(){
      return _treeConsole.list(_storageName);
   }

   //============================================================
   // <T>查找配置定义处理。</T>
   //
   // @param containerName 容器名称
   // @param modeCd 持久化模式
   // @return 内容对象
   //============================================================
   @Override
   protected FContentObject contentFindDefine(String containerName,
                                              EPersistenceMode modeCd){
      return _treeConsole.findDefine(_storageName, containerName, modeCd);
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param content 内容
   //============================================================
   @Override
   protected void contentUpdate(FContentObject content){
      //_treeConsole.update(_storageName, content);
   }

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   @Override
   public EResult catalog(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      return catalogList(context, input, output);
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
      XTreeView xtree = _treeConsole.find(_storageName, code, EPersistenceMode.Config);
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
}
