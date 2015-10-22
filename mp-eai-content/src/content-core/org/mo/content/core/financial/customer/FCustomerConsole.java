package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
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
   // 每页条数
   static final int _pageSize = 12;

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
         // 客户的主键和成员的主键一样
         FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
         if(member != null){
            info.setLabel(member.label());
            info.setPhone(member.phone());
            info.setLastLogin(member.lastLoginDate());
            info.setAge(nowDate.year() - member.birthday().year());
         }
      }
      return unitList;
   }

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总页数
   // ============================================================
   @Override
   public int getPageCount(ILogicContext logicContext,
                           long marketerId){
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql sql = new FSql();
      sql.append("SELECT COUNT(ouid) FROM DT_FIN_CUSTOMER WHERE ");
      sql.append(FDataFinancialCustomerLogic.MARKETER_ID + " = {marketer_id}");
      sql.bind("marketer_id", RString.parse(marketerId));
      ISqlConnection conn = logic.connection();
      int count = conn.executeInteger(sql);
      int pageTotal = count / _pageSize;
      if(count % _pageSize != 0){
         pageTotal += 1;
      }
      return pageTotal;
   }
}
