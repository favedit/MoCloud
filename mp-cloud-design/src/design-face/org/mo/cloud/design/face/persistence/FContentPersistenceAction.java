package org.mo.cloud.design.face.persistence;

import org.mo.cloud.design.core.persistence.EContentPersistenceAction;
import org.mo.cloud.design.core.persistence.EContentPersistenceType;
import org.mo.cloud.design.core.persistence.IContentPersistenceConsole;
import org.mo.cloud.design.core.persistence.SContentPersistenceBuildArgs;

import org.mo.cloud.design.core.configuration.common.FAbstractConfigurationAction;
import org.mo.core.aop.face.ALink;
import org.mo.jfa.face.apl.page.IPublicPage;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>内容持久化处理。</T>
//============================================================
public class FContentPersistenceAction
      extends FAbstractConfigurationAction
      implements
         IContentPersistenceAction
{
   // 目录页面
   public final static String PAGE_CATALOG = "Catalog";

   // 代码页面
   public final static String PAGE_SOURCE = "Source";

   // 内容持久控制台接口
   @ALink
   protected IContentPersistenceConsole _persistenceConsole;

   //============================================================
   // <T>构造内容持久化处理。</T>
   //============================================================
   public FContentPersistenceAction(){
      _storageName = "cloud";
      _spaceName = "design.persistence";
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
                         FContentPersistencePage page){
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
                      FContentPersistencePage page){
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
                        FContentPersistencePage page){
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
                        FContentPersistencePage page){
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
                        FContentPersistencePage page){
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
                      FContentPersistencePage page){
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
                          FContentPersistencePage page){
      // 设置代码生成参数
      SContentPersistenceBuildArgs args = new SContentPersistenceBuildArgs();
      args.setActionCd(EContentPersistenceAction.All);
      args.setTypeCd(EContentPersistenceType.All);
      _persistenceConsole.build(args);
      return IPublicPage.PROCESS_SUCCESS;
   }

   //   @Override
   //   public String build(IWebContext context,
   //                       FPersistencePage page){
   //      String collection = context.parameter(PTY_SEL_COLLECTION);
   //      IXmlObject xcollection = _persistenceConsole.get(collection);
   //      // 设置代码生成参数
   //      FPersistenceBuilderArgs args = new FPersistenceBuilderArgs();
   //      args.setPersistence((XPersistence)xcollection);
   //      // 根据类型分别处理
   //      String type = context.parameter(PTY_SEL_TYPE);
   //      if(TYPE_COLLECTION.equals(type)){
   //         args.setAction(EPersistenceBuildAction.Store);
   //         args.setType(EPersistenceSourceType.Persistence);
   //         _persistenceConsole.build(args);
   //         return IPublicPage.PROCESS_SUCCESS;
   //      }else if(TYPE_COMPONENT.equals(type)){
   //         String component = context.parameter(PTY_SEL_COMPONENT);
   //         IXmlObject xcomponent = xcollection.search(component);
   //         if(null == xcomponent){
   //            throw new FFatalError("Xml component is not found. (collection={0},component={1})", collection, component);
   //         }
   //         args.setAction(EPersistenceBuildAction.Query);
   //         args.setType(EPersistenceSourceType.Component);
   //         args.setComponent(xcomponent);
   //         _persistenceConsole.build(args);
   //      }else{
   //         throw new FFatalError("Unknown select type. (type={0})", type);
   //      }
   //      // 为代码进行HTML上色
   //      ISyntaxMaker syntaxMaker = _formatConsole.find(ESyntax.Java);
   //      page.setSource(syntaxMaker.format(args.source()));
   //      return PAGE_SOURCE;
   //   }

   //
   //   @Override
   //   public String execute(IWebContext context,
   //                         FPersistencePage page){
   //      String collection = page.getSelectCollection();
   //      IXmlObject xcollection = _persistenceConsole.get(collection);
   //      // 设置代码生成参数
   //      FPersistenceBuilderArgs args = new FPersistenceBuilderArgs();
   //      args.setAction(EPersistenceBuildAction.Store);
   //      args.setPersistence((XPersistence)xcollection);
   //      // 根据类型分别处理
   //      String type = page.getSelectType();
   //      if(TYPE_COLLECTION.equals(type)){
   //         args.setType(EPersistenceSourceType.Persistence);
   //         _persistenceConsole.build(args);
   //      }else if(TYPE_COMPONENT.equals(type)){
   //         String component = page.getSelectComponent();
   //         IXmlObject xcomponent = xcollection.search(component);
   //         if(null == xcomponent){
   //            throw new FFatalError("Xml component is not found. (collection={0},component={1})", collection, component);
   //         }
   //         args.setType(EPersistenceSourceType.Component);
   //         args.setComponent(xcomponent);
   //         _persistenceConsole.build(args);
   //      }else{
   //         throw new FFatalError("Unknown select type. (type={0})", type);
   //      }
   //      return IPublicPage.PROCESS_SUCCESS;
   //   }
   //
   //   @Override
   //   public String help(IWebContext context,
   //                      FPersistencePage page){
   //      ITemplateParser parser = _templateConsole.findParser("helper.design", "persistence.detail");
   //      return help(_persistenceConsole, context, page, parser, IPublicPage.XOBJECT_HELP);
   //   }
}
