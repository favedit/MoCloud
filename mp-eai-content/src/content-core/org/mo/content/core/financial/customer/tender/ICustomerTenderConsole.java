package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.collections.FDataset;
import org.mo.content.core.financial.tender.FDataFinancialTenderInfo;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>投标信息接口。</T>
//============================================================
public interface ICustomerTenderConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerTenderUnit>
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
   FLogicDataset<FDataFinancialCustomerTenderInfo> selectByMarkterIdAndProductId(ILogicContext logicContext,
                                                                                 long marketerId,
                                                                                 long productId,
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
   // <T>查询理财师下产品的客户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param FDataFinancialProductUnit 产品信息
   // @return 插入结果
   //============================================================
   FLogicDataset<FDataFinancialCustomerTenderInfo> selectByProductIdAndMarkterId(ILogicContext logicContext,
                                                                                 long marketerId,
                                                                                 long productId,
                                                                                 int pageNum);

   //============================================================
   // <T>查询理财师下产品的投资信息汇总。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @param productId 产品编号
   // @return 插入结果
   //============================================================
   FDataset getTotal(ILogicContext logicContext,
                     long marketerId,
                     long productId);

}
