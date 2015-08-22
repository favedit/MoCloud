package org.mo.content.core.manage.person.role;

import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public interface IRoleModuleConsole
      extends
         IAbstractLogicUnitConsole<FDataControlRoleModuleUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataControlRoleModuleUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                        FDataControlRoleModuleUnit roleModuleUnit,
                                                                        int pageNum);

   // ============================================================
   // <T>根据角色编号删除数据</T>
   //
   // @param sqlContext 链接对象
   // @param roleId 角色编号
   // ============================================================
   void deleteByRoleId(ILogicContext logicContext,
                       long roleId);

   // ============================================================
   // <T>根据角色ID和moduleId查找数据</T>
   //
   // @param sqlContext 链接对象
   // @param roleId  角色ID
   // @param moduleId  模块ID
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataControlRoleModuleUnit> selectDataByRoleIdAndModuleId(ILogicContext logicContext,
                                                                           long roleId,
                                                                           long moduleId);
}
