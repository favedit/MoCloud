package com.ahyc.eai.batch.calculate.financial.tender;

import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>产品期次同步类。</T>
//============================================================
public class FCalculateTenderSynchronize
{

   // 产品期次控制台
   @ALink
   protected ICalculateTenderConsole _calculateTenderConsole;
   
   //============================================================
   // <T>产品期次处理。</T>
   //============================================================
   public void synchronize(FLogicContext logicContext){
      _calculateTenderConsole.insertBatchLinkIdandBorrowModel(logicContext);
   }
}
