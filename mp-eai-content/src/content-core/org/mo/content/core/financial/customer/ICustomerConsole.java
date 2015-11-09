package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>客户控制台接口。</T>
//============================================================
public interface ICustomerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialCustomerUnit>
{
   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                long marketerId);

   // ============================================================
   // <T>获取客户</T>
   //
   // @param logicContext 链接对象
   // @param  objectId 对象编号
   // @return 数据对象
   // ============================================================
   FDataFinancialCustomerInfo findInfo(ILogicContext logicContext,
                                       long objectId);

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总页数
   // ============================================================
   int getPageCount(ILogicContext logicContext,
                    long marketerId);

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                long marketerId,
                                                                int pageNum);

   // ============================================================
   // <T>获取客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据对象
   // ============================================================
   FDataFinancialCustomerInfo findInfo(ILogicContext logicContext,
                                       long marketerId,
                                       long customerId);

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialCustomerInfo> search(ILogicContext logicContext,
                                                    IWebContext context,
                                                    long marketerId,
                                                    int pageNum,
                                                    int pageSize);

   FLogicDataset<FDataFinancialCustomerInfo> findPage(ILogicContext logicContext,
                                                      IWebContext context,
                                                      int pageNum,
                                                      int pageSize);

   // ============================================================
   // <T>获取总行数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总行数
   // ============================================================
   int getRowCount(ILogicContext logicContext,
                   long marketerId);
}
