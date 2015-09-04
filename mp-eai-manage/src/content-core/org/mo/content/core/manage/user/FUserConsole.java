package org.mo.content.core.manage.user;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.content.core.manage.role.IRoleConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FUserConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserLogic, FDataPersonUserUnit>
      implements
         IUserConsole
{

   // 每页条数
   static final int _pageSize = 20;

   // 存储控制台
   @ALink
   public IGcStorageConsole _storageConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FUserConsole(){
      super(FDataPersonUserLogic.class, FDataPersonUserUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   //
   // @param con 链接对象
   // @pageNum 指定页面
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataPersonUserInfo> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                        FDataPersonUserUnit userUnit,
                                                                        int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FDataPersonUserLogic userUnitLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      StringBuffer whereSB = new StringBuffer();
      whereSB.append(FDataPersonUserLogic.OVLD).append(" = ").append(1);
      FLogicDataset<FDataPersonUserInfo> userInfoList = userUnitLogic.fetchClass(FDataPersonUserInfo.class, null, whereSB.toString(), null, _pageSize, pageNum);
      for(FDataPersonUserInfo info : userInfoList){
         FDataControlRoleUnit role = _roleConsole.find(logicContext, info.roleId());
         if(role != null){
            info.setRoleLabel(role.label());
         }
      }
      return userInfoList;
   }

   @Override
   public FLogicDataset<FDataPersonUserUnit> loginUser(ILogicContext logicContext,
                                                       FDataPersonUserUnit userUnit){
      FDataPersonUserLogic userUnitLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      StringBuffer whereSB = new StringBuffer();
      //      whereSB.append(FDataPersonUserLogic.FieldRoleCd).append(" = ").append(EGcPersonRole.Admin);
      whereSB.append(FDataPersonUserLogic.PASSPORT).append(" = ").append("'" + userUnit.passport() + "'");
      FLogicDataset<FDataPersonUserUnit> userUnitList = userUnitLogic.fetch(whereSB.toString(), -1, -1);
      return userUnitList;
   }

   // ============================================================
   // <T>根据帐号查找数据</T>
   //
   // @param sqlContext 链接对象
   // @param passport 帐号
   // @return 模块数据
   // ============================================================
   @Override
   public EResult passportExists(ILogicContext logicContext,
                                 String passport){
      FDataPersonUserLogic logic = logicContext.findLogic(FDataPersonUserLogic.class);
      StringBuffer whereSB = new StringBuffer();
      whereSB.append(FDataPersonUserLogic.OVLD).append(" = ").append(1);
      if(!RString.isEmpty(passport))
         whereSB.append(" AND ").append(FDataPersonUserLogic.PASSPORT).append(" = '").append(passport).append("'");
      FLogicDataset<FDataPersonUserUnit> unitlist = logic.fetch(whereSB);
      return unitlist.count() > 0 ? EResult.Success : EResult.Failure;
   }

   // ============================================================
   // <T>根据角色查找数据</T>
   //
   // @param sqlContext 链接对象
   // @param passport 帐号
   // @return 模块数据
   // ============================================================
   @Override
   public EResult roleExists(ILogicContext logicContext,
                             String role){
      FDataPersonUserLogic logic = logicContext.findLogic(FDataPersonUserLogic.class);
      StringBuffer whereSB = new StringBuffer();
      whereSB.append(FDataPersonUserLogic.OVLD).append(" = ").append(1);
      if(!RString.isEmpty(role))
         whereSB.append(" AND ").append(FDataPersonUserLogic.ROLE_ID).append(" = '").append(role).append("'");
      FLogicDataset<FDataPersonUserUnit> unitlist = logic.fetch(whereSB);
      return unitlist.count() > 0 ? EResult.Success : EResult.Failure;
   }

   // ============================================================
   // <T>根据ouid修改用户</T>
   //
   // @param sqlContext 链接对象
   // @param ouid 主键
   // @return 数据信息
   // ============================================================
   @Override
   public void updateByOuid(ILogicContext logicContext,
                            FDataPersonUserUnit user){
      logicContext.findLogic(FDataPersonUserLogic.class).doUpdate(user, user.ouid());
   }

   // ============================================================
   // <T>删除用户</T>
   //
   // @param sqlContext 链接对象
   // @param ouid 主键
   // @return 数据信息
   // ============================================================
   @Override
   public EResult delete(ILogicContext logicContext,
                         long id){
      FDataPersonUserLogic logic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit user = logic.find(id);
      user.setOvld(false);
      EResult result = logic.doUpdate(user, id);
      return result;
   }
}
