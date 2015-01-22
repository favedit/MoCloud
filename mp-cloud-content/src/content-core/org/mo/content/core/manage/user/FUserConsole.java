package org.mo.content.core.manage.user;

import org.mo.cloud.content.data.logic.data.FDataPersonUserLogic;
import org.mo.cloud.content.data.logic.data.FDataPersonUserUnit;
import org.mo.content.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.ILogicContext;

public class FUserConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserUnit>
      implements
         IUserConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>创建逻辑单元</T>
   //
   // @param logicContext 数据环境
   // @return 逻辑单元
   //============================================================
   @Override
   protected FLogicTable createLogic(ILogicContext logicContext){
      return new FDataPersonUserLogic(logicContext);
   }

   @Override
   public FLogicDataset<FDataPersonUserUnit> loginUser(ILogicContext logicContext,
                                                       FDataPersonUserUnit userUnit){
      FDataPersonUserLogic userUnitLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      StringBuffer whereSB = new StringBuffer();
      //whereSB.append(FDataPersonUserLogic.ROLE_CD).append(" = ").append(EGcPersonRole.Admin);
      whereSB.append(FDataPersonUserLogic.PASSPORT).append(" = ").append("'" + userUnit.passport() + "'");
      //whereSB.append(" AND ").append(FDataPersonUserLogic.FieldPassword).append(" = ").append("'" + userUnit.password() + "'");
      FLogicDataset<FDataPersonUserUnit> userUnitList = userUnitLogic.fetch(whereSB.toString(), -1, -1);
      return userUnitList;
   }
   //
   //   // ============================================================
   //   // <T>根据帐号查找数据</T>
   //   //
   //   // @param logicContext 链接对象
   //   // @param passport 帐号
   //   // @return 模块数据
   //   // ============================================================
   //   @Override
   //   public FLogicDataset<FDataPersonUserUnit> checkPassportIsExist(ILogicContext logicContext,
   //                                                                  String passport){
   //      FDataPersonUserLogic userUnitLogic = new FDataPersonUserLogic(logicContext);
   //      StringBuffer whereSB = new StringBuffer();
   //      whereSB.append(FDataPersonUserLogic.ROLE_CD).append("= ").append(EGcPersonRole.Admin);
   //      if(!RString.isEmpty(passport))
   //         whereSB.append(" AND ").append(FDataPersonUserLogic.PASSPORT).append(" = '").append(passport).append("'");
   //      return userUnitLogic.fetch(whereSB.toString(), -1, -1);
   //   }
   //
   //   // ============================================================
   //   // <T>根据ouid修改用户</T>
   //   //
   //   // @param logicContext 链接对象
   //   // @param ouid 主键
   //   // @return 数据信息
   //   // ============================================================
   //   @Override
   //   public void updateByOuid(ILogicContext logicContext,
   //                            FDataPersonUserUnit user){
   //      new FDataPersonUserLogic(logicContext).doUpdate(user, user.ouid());
   //   }
}
