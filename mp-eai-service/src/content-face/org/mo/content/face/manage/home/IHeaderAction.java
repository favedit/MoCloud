package org.mo.content.face.manage.home;

import org.mo.com.data.ASqlConnect;
import org.mo.content.face.base.FBasePage;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>用户权限逻辑实现类</P>
//
//@class IHeaderAction
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public interface IHeaderAction
{
   //============================================================
   // <T>列出目录。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String construct(IWebContext context,
                    @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>产品权限。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String productLeft(IWebContext context,
                      @ASqlConnect(name = "GCDATA") ISqlContext sqlContext,
                      @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>数据分析权限。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String analysisLeft(IWebContext context,
                       @ASqlConnect(name = "GCDATA") ISqlContext sqlContext,
                       @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>后台管理权限。</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String manageLeft(IWebContext context,
                     @ASqlConnect(name = "GCDATA") ISqlContext sqlContext,
                     @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T>数据库管理</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   String databaseLeft(IWebContext context,
                       @ASqlConnect(name = "GCDATA") ISqlContext sqlContext,
                       @AContainer(name = "basePage") FBasePage basePage);
}
