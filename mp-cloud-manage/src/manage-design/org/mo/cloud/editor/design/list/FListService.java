package org.mo.cloud.editor.design.list;

import org.mo.cloud.content.design.common.IContentConsole;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.list.IListConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.editor.design.common.FAbstractDesignService;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>设计列表服务。</T>
//============================================================
public class FListService
      extends FAbstractDesignService
      implements
         IListService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容列表控制台接口
   @ALink
   protected IListConsole _listConsole;

   //============================================================
   // <T>构造设计列表服务。</T>
   //============================================================
   public FListService(){
   }

   //============================================================
   // <T>获得内容管理器。</T>
   //
   // @return 内容管理器
   //============================================================
   @Override
   protected IContentConsole contentConsole(){
      return _listConsole;
   }

   //============================================================
   // <T>获得内容列表处理。</T>
   //
   // @return 内容列表
   //============================================================
   @Override
   protected XContentObject[] contentList(){
      return _listConsole.list(_storageName);
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
      return _listConsole.findDefine(_storageName, containerName, modeCd);
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param content 内容
   //============================================================
   @Override
   protected void contentUpdate(FContentObject content){
      _listConsole.update(_storageName, content);
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
      return catalogPackage(context, input, output);
   }
}
