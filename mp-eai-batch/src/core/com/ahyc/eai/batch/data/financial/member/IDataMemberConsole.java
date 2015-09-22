package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融用户控制台接口。</T>
//============================================================
public interface IDataMemberConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMemberUnit>
{
   // ============================================================
   // <T>根据Linkid获取对象</T>
   //
   // @param logicContext 链接对象
   // @param linkId 
   // @return 数据对象 
   // ============================================================
   FDataFinancialMemberUnit findByLinkId(ILogicContext logicContext,
                                         long linkId);
}
