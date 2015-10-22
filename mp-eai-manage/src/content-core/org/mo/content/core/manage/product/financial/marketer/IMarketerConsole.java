package org.mo.content.core.manage.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>理财师信息控制台接口</P>
//@interface IMarketerConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface IMarketerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMarketerUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialMarketerUnit> select(ILogicContext logicContext,
                                                    FDataFinancialMarketerUnit unit,
                                                    int pageNum,
                                                    int pageSize);

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataFinancialMarketerUnit findByCode(ILogicContext logicContext,
                                         String code);
   
   // ============================================================
   // <T>根据搜索条件时间段查询分页数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialMarketerUnit> selectByMessage(ILogicContext logicContext, 
                                                             String beginDateStr, 
                                                             String endDateStr,
                                                             String name,
                                                             int pageNum, 
                                                             int pageSize);
}
