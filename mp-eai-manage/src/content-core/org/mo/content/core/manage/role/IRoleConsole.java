package org.mo.content.core.manage.role;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>用户逻辑数据库操作接口</P>
//
//@class IUserConsole
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public interface IRoleConsole
      extends
         IAbstractLogicUnitConsole<FDataControlRoleUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataControlRoleInfo> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                  FDataControlRoleUnit roleUnit,
                                                                  int pageNum);

   FDataControlRoleUnit findByCode(ILogicContext logicContext,
                                   String code);
}
