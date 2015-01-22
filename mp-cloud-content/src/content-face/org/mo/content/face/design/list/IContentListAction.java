package org.mo.content.face.design.list;

import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>内容列表处理接口。</T>
//============================================================
public interface IContentListAction
{
   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String catalog(IWebContext context,
                  @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>获得列表处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String list(IWebContext context,
               @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>新建配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String insert(IWebContext context,
                 @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>更新配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String update(IWebContext context,
                 @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>删除配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String delete(IWebContext context,
                 @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>排序配置内容处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String sort(IWebContext context,
               @AContainer(name = "page") FContentListPage page);

   //============================================================
   // <T>建立全部代码处理。</T>
   //
   // @param context 网页环境
   // @param page 页面
   // @return 处理结果
   //============================================================
   String buildAll(IWebContext context,
                   @AContainer(name = "page") FContentListPage page);
}
