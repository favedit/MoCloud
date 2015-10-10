package org.mo.content.core.manage.system.user.module;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
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

public interface IModuleConsole
      extends
         IAbstractLogicUnitConsole<FDataControlModuleUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataControlModuleUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                    FDataControlModuleUnit moduleUnit,
                                                                    int pageNum);

   // ============================================================
   // <T>查询一个角色所拥有的模块/T>
   //
   // @param sqlContext 链接对象
   // @param unit 更新数据
   // ============================================================
   FLogicDataset<FDataControlModuleInfo> selectModule(ILogicContext logicContext);

   FDataControlModuleUnit findByCode(ILogicContext logicContext,
                                     String code);
}
