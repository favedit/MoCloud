package org.mo.cloud.design.core.person;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.design.face.base.FBasePage;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FPersonConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserLogic, FDataPersonUserUnit>
      implements
         IPersonConsole
{
   // 每页条数
   static final int _pageSize = 20;

   public FPersonConsole(){
      super(FDataPersonUserLogic.class, FDataPersonUserUnit.class);
   }

   // ============================================================
   // <T>登录</T>
   //
   // @param sqlContext 链接对象
   // @param personUser 用户对象
   // @return 结果
   // ============================================================
   @Override
   public String login(ILogicContext logicContext,
                       FBasePage basePage,
                       String passport,
                       String password){

      FLogicDataset<FDataPersonUserUnit> personUserList = selectByPassport(logicContext, passport);
      if(personUserList.count() < 1){
         return "无此用户。";
      }
      if(personUserList.count() > 1){
         return "有重复用户名，数据异常。";
      }

      if(personUserList.first() != null && personUserList.first().password().equals(password)){
         basePage.setUser(personUserList.first());
         return "1";
      }else{
         return "用户名或密码错误。";
      }
   }

   // ============================================================
   // <T>根据用户名称获取对集合</T>
   //
   // @param sqlContext 链接对象
   // @param personUser 用户对象
   // @return 对象集合
   // ============================================================
   @Override
   public FLogicDataset<FDataPersonUserUnit> selectByPassport(ILogicContext logicContext,
                                                              String passport){
      FDataPersonUserLogic personLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      //条件
      StringBuffer sqlString = new StringBuffer();
      sqlString.append(FDataPersonUserLogic.PASSPORT);
      sqlString.append(" = '");
      sqlString.append(passport);
      sqlString.append("'");

      FLogicDataset<FDataPersonUserUnit> personUserList = personLogic.fetch(sqlString, 0, 0);
      return personUserList;
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param con 链接对象
   // @pageNum 指定页面
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataPersonUserUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                        FDataPersonUserUnit userUnit,
                                                                        int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FDataPersonUserLogic personLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      //条件
      //StringBuffer sqlString = new StringBuffer();

      FLogicDataset<FDataPersonUserUnit> userList = personLogic.fetch(null, _pageSize, pageNum);
      return userList;
   }
}
