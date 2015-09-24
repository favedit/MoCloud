package org.mo.content.core.financial.marketer.member;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师成员控制台接口。</T>
//============================================================
public interface IDataMarketerMemberConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMarketerMemberUnit>
{
   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  memberId 成员编号
   // @return 数据对象
   // ============================================================
   FDataFinancialMarketerMemberUnit findByMemberId(ILogicContext logicContext,
                                                   long memberId);
}
