package org.mo.cloud.design.face.person;

import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.data.ASqlConnect;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

public interface IUserAction
{
   //============================================================
   // <T>默认跳转</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   String construct(IWebContext context,
                    @ASqlConnect(name = "CD_DATA") ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>用户查询</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   String selectDataByPage(IWebContext context,
                           @ASqlConnect(name = "CD_DATA") ILogicContext logicContext,
                           @AContainer(name = "userPage") FUserPage userPage,
                           @AContainer(name = "basePage") FBasePage basePage);

}
