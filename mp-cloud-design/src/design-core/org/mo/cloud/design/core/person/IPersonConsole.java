package org.mo.cloud.design.core.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.cloud.design.face.base.FBasePage;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台接口</T>
//============================================================
public interface IPersonConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonUserUnit>
{
   // ============================================================
   // <T>根据用户名称获取对集合</T>
   //
   // @param sqlContext 链接对象
   // @param personUser 用户对象
   // @return 对象集合
   // ============================================================
   FLogicDataset<FDataPersonUserUnit> selectByPassport(ILogicContext logicContext,
                                                       String passport);

   // ============================================================
   // <T>登录</T>
   //
   // @param sqlContext 链接对象
   // @param personUser 用户对象
   // @return 结果
   // ============================================================
   String login(ILogicContext logicContext,
                FBasePage basePage,
                String passport,
                String password);
}
