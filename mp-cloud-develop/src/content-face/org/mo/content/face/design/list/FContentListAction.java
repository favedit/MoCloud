package org.mo.content.face.design.list;

import org.mo.cloud.content.design.configuration.common.FAbstractConfigurationAction;
import org.mo.jfa.face.apl.page.IPublicPage;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>内容列表处理。</T>
//============================================================
public class FContentListAction
      extends FAbstractConfigurationAction
      implements
         IContentListAction
{
   // 目录页面
   public final static String PAGE_CATALOG = "Catalog";

   // 代码页面
   public final static String PAGE_SOURCE = "Source";

   //============================================================
   // <T>构造内容列表处理。</T>
   //============================================================
   public FContentListAction(){
      _storageName = "cloud";
      _spaceName = "design.list";
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
                         FContentListPage page){
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
                      FContentListPage page){
      return list(context, page, IPublicPage.XOBJECT_FORM);
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
                        FContentListPage page){
      return insert(context, page, IPublicPage.XOBJECT_FORM);
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
                        FContentListPage page){
      return update(context, page, IPublicPage.XOBJECT_FORM);
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
                        FContentListPage page){
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
                      FContentListPage page){
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
                          FContentListPage page){
      //      // 设置代码生成参数
      //      SContentPersistenceBuildArgs args = new SContentPersistenceBuildArgs();
      //      args.setActionCd(EContentPersistenceAction.All);
      //      args.setTypeCd(EContentPersistenceType.All);
      //      _persistenceConsole.build(args);
      return IPublicPage.PROCESS_SUCCESS;
   }
}
