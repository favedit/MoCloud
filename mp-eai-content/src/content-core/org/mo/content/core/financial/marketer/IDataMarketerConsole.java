package org.mo.content.core.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师控制台接口。</T>
//============================================================
public interface IDataMarketerConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMarketerUnit>
{
   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  passport 理财师passport
   // @return 数据对象
   // ============================================================
   FDataFinancialMarketerUnit findByPassport(ILogicContext logicContext,
                                             String passport);
}
