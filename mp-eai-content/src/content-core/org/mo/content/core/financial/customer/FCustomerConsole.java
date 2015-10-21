package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>客户推荐控制台。</T>
//============================================================
public class FCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerLogic, FDataFinancialCustomerUnit>
      implements
         ICustomerConsole
{

   @ALink
   protected IDataMemberConsole _memberConsole;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCustomerConsole(){
      super(FDataFinancialCustomerLogic.class, FDataFinancialCustomerUnit.class);
   }

   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                       long marketerId){
      if(marketerId == 0){
         throw new FFatalError("selectByMarketerId,marketerId is null");
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialCustomerLogic.MARKETER_ID, "={marketerId}");
      whereSql.bind("marketerId", RString.parse(marketerId));
      FLogicDataset<FDataFinancialCustomerInfo> unitList = logic.fetchClass(FDataFinancialCustomerInfo.class, whereSql);
      for(FDataFinancialCustomerInfo info : unitList){
         System.out.println(info.investmentTotal() + "---------" + info.ouid());
         // 客户的主键和成员的主键一样
         FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
         if(member != null){
            info.setLabel("123456");
            info.setPhone(member.phone());
            info.setLastLogin(member.lastLoginDate());
            info.setAge(nowDate.year() - member.birthday().year());
         }
      }
      return unitList;
   }
}
