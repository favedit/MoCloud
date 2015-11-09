package org.mo.content.core.manage.product.organization.department.user;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUserUnit;
//============================================================
//<P>部门用户控制台接口</P>
//@interface IUserConsole
//@version 1.0.0
//============================================================
public interface IUserConsole
      extends
         IAbstractLogicUnitConsole<FDataOrganizationDepartmentUserUnit>
{

   // ============================================================
   // <T>获得分页数据列表</T>
   //
   // @param sqlContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataUserInfo> select(ILogicContext logicContext,
                                       FDataUserInfo unit,
                                       int pageNum,
                                       int pageSize);
   // ============================================================
   // <T>根据ouid查询组织部门用户信息</T>
   // @param logicContext 链接对象
   // @param ouid 唯一标识符
   // @return 数据对象
   // ============================================================
  FDataUserInfo findInfo(ILogicContext logicContext,
                         Long ouid);
}
