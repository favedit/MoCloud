package org.mo.cloud.editor.design.frame;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.frame.IFrameConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.editor.design.common.FAbstractDesignService;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>设计表单服务。</T>
//============================================================
public class FFrameService
      extends FAbstractDesignService
      implements
         IFrameService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容表单控制台接口
   @ALink
   protected IFrameConsole _frameConsole;

   //============================================================
   // <T>构造设计表单服务。</T>
   //============================================================
   public FFrameService(){
   }

   //============================================================
   // <T>获得内容管理器。</T>
   //
   // @return 内容管理器
   //============================================================
   @Override
   protected IContentConsole contentConsole(){
      return _frameConsole;
   }

   //============================================================
   // <T>获得内容列表处理。</T>
   //
   // @return 内容列表
   //============================================================
   @Override
   protected XContentObject[] contentList(){
      return _frameConsole.list(_storageName);
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
      return _frameConsole.findDefine(_storageName, containerName, modeCd);
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param content 内容
   //============================================================
   @Override
   protected void contentUpdate(FContentObject content){
      _frameConsole.update(_storageName, content);
   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult catalog(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      return catalogPackage(context, input, output);
   }
}
