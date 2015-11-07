package org.mo.content.core.financial.tender;

import com.cyou.gccloud.data.data.FDataFinancialTenderUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>投标信息接口。</T>
//============================================================
public interface ITenderConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialTenderUnit>
{
   //============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductUnit 产品信息
   // @return 插入结果
   //============================================================
   FLogicDataset<FDataFinancialTenderInfo> select(ILogicContext logicContext,
                                                  long marketerId,
                                                  long productId);

   //============================================================
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductUnit 产品信息
   // @return 插入结果
   //============================================================
   FLogicDataset<FDataFinancialTenderInfo> selectByMarkterIdAndProductId(ILogicContext logicContext,
                                                                         long marketerId,
                                                                         long productIdd,
                                                                         int pageNum);

   //============================================================
   // <T>查询理财师下产品的客户总数。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductUnit 产品信息
   // @return 插入结果
   //============================================================
   int selectByMarkterIdAndProductId(ILogicContext logicContext,
                                     long marketerId,
                                     long productId);

   //============================================================
   // <T>查询产品编号</T>
   //
   // @param logicContext 逻辑环境
   // @param tenderId 
   // @return 插入结果
   //============================================================
   int selectByTenderId(ILogicContext logicContext,
                        long tenderId);

}
