package org.mo.content.core.manage.person.role;

import com.cyou.gccloud.data.data.FDataControlRoleModuleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.statistics.financial.customer.FPhaseConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FRoleModuleConsole
      extends FAbstractLogicUnitConsole<FDataControlRoleModuleLogic, FDataControlRoleModuleUnit>
      implements
         IRoleModuleConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FPhaseConsole.class);

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FRoleModuleConsole(){
      super(FDataControlRoleModuleLogic.class, FDataControlRoleModuleUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataControlRoleModuleUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                               FDataControlRoleModuleUnit roleModuleUnit,
                                                                               int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      StringBuffer whereSql = new StringBuffer();
      if(roleModuleUnit.roleId() != 0){
         whereSql.append(FDataControlRoleModuleLogic.ROLE_ID).append(" = ").append(roleModuleUnit.roleId());
      }
      FDataControlRoleModuleLogic logic = logicContext.findLogic(FDataControlRoleModuleLogic.class);
      FLogicDataset<FDataControlRoleModuleUnit> roleModuleList = logic.fetch(whereSql.toString(), _pageSize, pageNum);
      return roleModuleList;
   }

   // ============================================================
   // <T>根据角色编号删除数据</T>
   //
   // @param sqlContext 链接对象
   // @param roleId 角色编号
   // ============================================================
   @Override
   public void deleteByRoleId(ILogicContext logicContext,
                              long roleId){

      StringBuffer sql = new StringBuffer();
      if(roleId != 0){
         sql.append("DELETE FROM ").append(FDataControlRoleModuleLogic.TABLE);
         sql.append(" WHERE ").append(FDataControlRoleModuleLogic.ROLE_ID).append(" = ").append(roleId);
      }
      _logger.debug(this, "Delete", "Delete by roleId finish. (whereSql={1})", sql.toString());
      logicContext.findLogic(FDataControlRoleModuleLogic.class).executeSql(sql.toString());
   }

   // ============================================================
   // <T>根据角色ID和moduleId查找数据</T>
   //
   // @param sqlContext 链接对象
   // @param roleId  角色ID
   // @param moduleId  模块ID
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataControlRoleModuleUnit> selectDataByRoleIdAndModuleId(ILogicContext logicContext,
                                                                                  long roleId,
                                                                                  long moduleId){

      StringBuffer whereSql = new StringBuffer();
      if(roleId != 0){
         whereSql.append(FDataControlRoleModuleLogic.ROLE_ID).append(" = ").append(roleId);
      }
      if(moduleId != 0){
         if(roleId != 0){
            whereSql.append(" AND ");
         }
         whereSql.append(FDataControlRoleModuleLogic.MODULE_ID).append(" = ").append(moduleId);
      }
      return logicContext.findLogic(FDataControlRoleModuleLogic.class).fetch(whereSql.toString());
   }
}
