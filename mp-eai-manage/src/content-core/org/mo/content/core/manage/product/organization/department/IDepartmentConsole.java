package org.mo.content.core.manage.product.organization.department;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUnit;

//============================================================
//<P>组织部门控制台接口</P>
//@interface IDepartmentConsole
//@version 1.0.0
//============================================================
public interface IDepartmentConsole
      extends
         IAbstractLogicUnitConsole<FDataOrganizationDepartmentUnit>
{
   // ============================================================
   // <T>获得分页数据列表</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataDepartmentInfo> select(ILogicContext logicContext,
                                             FDataDepartmentInfo unit,
                                             int pageNum,
                                             int pageSize);
   // ============================================================
   // <T>根据父级id获取父级</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataOrganizationDepartmentUnit findParentUnitByParentId(ILogicContext logicContext,
                                                            Long parentId);
   // ============================================================
   // <T>根据获取组织部门列表</T>
   // @param logicContext 链接对象
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataOrganizationDepartmentUnit> selectAll(ILogicContext logicContext);
   // ============================================================
   // <T>根据ouid查询组织部门信息</T>
   // @param logicContext 链接对象
   // @param ouid 唯一标识符
   // @return 数据对象
   // ============================================================
   FDataDepartmentInfo findInfo(ILogicContext logicContext,
                                Long ouid);
}
