package org.mo.content.core.financial.marketer.member;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师成员控制台。</T>
//============================================================
public class FDataMarketerMemberConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerMemberLogic, FDataFinancialMarketerMemberUnit>
      implements
         IDataMarketerMemberConsole
{
   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerMemberConsole(){
      super(FDataFinancialMarketerMemberLogic.class, FDataFinancialMarketerMemberUnit.class);
   }

   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  memberId 成员编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerMemberUnit findByMemberId(ILogicContext logicContext,
                                                          long memberId){
      FDataFinancialMarketerMemberLogic logic = logicContext.findLogic(FDataFinancialMarketerMemberLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialMarketerMemberLogic.MEMBER_ID + " = {member_id}");
      whereSql.bind("member_id", RString.parse(memberId));
      FLogicDataset<FDataFinancialMarketerMemberUnit> unit = logic.fetch(whereSql);
      if(unit == null){
         return null;
      }
      return unit.first();
   }
}
