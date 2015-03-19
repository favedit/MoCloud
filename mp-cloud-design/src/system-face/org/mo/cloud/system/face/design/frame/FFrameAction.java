package org.mo.cloud.system.face.design.frame;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationAction;
import org.mo.cloud.system.face.common.ICommonAction;
import org.mo.jfa.face.apl.page.IPublicPage;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>内容表单处理。</T>
//============================================================
public class FFrameAction
      extends FAbstractConfigurationAction
      implements
         IFrameAction
{
   // 目录页面
   public final static String PAGE_CATALOG = "Catalog";

   // 代码页面
   public final static String PAGE_SOURCE = "Source";

   //============================================================
   // <T>构造内容列表处理。</T>
   //============================================================
   public FFrameAction(){
      _storageName = "system";
      _spaceName = "design.frame";
   }

   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String catalog(IWebContext context,
                         FFramePage page){
      return catalog(context, page, PAGE_CATALOG);
   }

   //============================================================
   // <T>获得列表处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String list(IWebContext context,
                      FFramePage page){
      return list(context, page, ICommonAction.XFRAME);
   }

   //============================================================
   // <T>新建配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String insert(IWebContext context,
                        FFramePage page){
      return insert(context, page, ICommonAction.XFRAME);
   }

   //============================================================
   // <T>更新配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String update(IWebContext context,
                        FFramePage page){
      return update(context, page, ICommonAction.XFRAME);
   }

   //============================================================
   // <T>删除配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String delete(IWebContext context,
                        FFramePage page){
      return delete(context, page, IPublicPage.PROCESS_END_DELETE);
   }

   //============================================================
   // <T>排序配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String sort(IWebContext context,
                      FFramePage page){
      return sort(context, page, IPublicPage.XOBJECT_SORT);
   }

   //============================================================
   // <T>建立全部代码处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   @Override
   public String buildAll(IWebContext context,
                          FFramePage page){
      //      // 设置代码生成参数
      //      SContentPersistenceBuildArgs args = new SContentPersistenceBuildArgs();
      //      args.setActionCd(EContentPersistenceAction.All);
      //      args.setTypeCd(EContentPersistenceType.All);
      //      _persistenceConsole.build(args);
      return IPublicPage.PROCESS_SUCCESS;
   }
}
