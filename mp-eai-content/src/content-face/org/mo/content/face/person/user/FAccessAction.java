package org.mo.content.face.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessHostUnit;
import org.mo.content.core.person.user.IAccessConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//
// @author sunhr
// @version 150328
//============================================================
public class FAccessAction
      implements
         IAccessAction
{
   //用户控制台
   @ALink
   protected IAccessConsole _accessConsole;

   //============================================================
   // <T>注册用户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage page){
      FLogicDataset<FDataPersonAccessHostUnit> unitlist = _accessConsole.select(logicContext);
      for(FDataPersonAccessHostUnit unit : unitlist){
         System.out.println(unit.host() + "--------------------------");
      }
      page.setUnitList(unitlist);
      return "/person/user/access";
   }

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FAccessPage page){
      System.out.println("------------eai----------------");
      return "Index";
   }
}
