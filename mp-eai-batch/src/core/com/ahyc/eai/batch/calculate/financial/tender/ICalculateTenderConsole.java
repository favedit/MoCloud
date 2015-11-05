package com.ahyc.eai.batch.calculate.financial.tender;

import org.mo.data.logic.ILogicContext;

//============================================================
// <T>统计投标控制台接口。</T>
//============================================================
public interface ICalculateTenderConsole
{

   // ============================================================
   // <T>批量插入字段值link_id,borrow_model</T>
   // @param logicContext 链接对象
   // @return void
   // ============================================================
   void insertBatchLinkIdandBorrowModel(ILogicContext logicContext);
   
   // ============================================================
   // <T>根据条件判断是否存在重复数据</T>
   //
   // @param context 网络环境
   // @param productCode 产品名称
   // @param productIssue 期次编号
   // @return 页面
   // ============================================================
   boolean isNotExistByProductCodeandIssue(ILogicContext logicContext,
                                           String productCode,
                                           String productIssue);
}
