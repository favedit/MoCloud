package com.ahyc.eai.batch.financial.tender;

import org.mo.eai.logic.common.EEaiDataConnection;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialTenderUnit;
import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicContext;

//============================================================
// <T>统计投标控制台。</T>
//============================================================
public class FStatisticsTenderConsole
      extends FConsole
      implements
         IStatisticsTenderConsole
{
   // 部门信息字典
   protected FDictionary<FStatisticsFinancialTenderUnit> _units = new FDictionary<FStatisticsFinancialTenderUnit>(FStatisticsFinancialTenderUnit.class);

   //============================================================
   // <T>根据编号同步一个投标信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param id 编号
   //============================================================
   @Override
   public FStatisticsFinancialTenderUnit sync(FLogicContext logicContext,
                                              long id){
      // 检查参数
      if(id == 0){
         return null;
      }
      String code = Long.toString(id);
      // 查找单元
      FStatisticsFinancialTenderUnit unit = _units.find(code);
      if(unit != null){
         return unit;
      }
      // 查找投标信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FRow row = connection
            .find("SELECT borrow_name,borrow_model,borrow_duration,borrow_money,borrow_interest,borrow_interest_rate,borrow_info,FROM_UNIXTIME(`add_time`,'%Y%m%d%H%i%s') as borrow_date,DATE_FORMAT(`start_time`,'%Y%m%d%H%i%s') as begin_date,xm1,xm2,xm3,xm4 FROM lzh_borrow_info where id="
                  + id);
      // 新建投标信息
      if(row != null){
         FStatisticsFinancialTenderLogic tenderLogic = logicContext.findLogic(FStatisticsFinancialTenderLogic.class);
         unit = tenderLogic.search("LINK_ID=" + id);
         if(unit == null){
            // 计算分组
            String label = row.get("borrow_name");
            String groupNumber = RString.mid(label, "第", "期");
            // 新建记录
            unit = tenderLogic.doPrepare();
            unit.setLinkId(id);
            unit.linkDate().parse(row.get("borrow_date"));
            if(!RString.isEmpty(groupNumber)){
               unit.setGroupNumber(RInteger.parse(groupNumber));
            }
            unit.setLabel(row.get("borrow_name"));
            unit.setBorrowModel(row.get("borrow_model"));
            unit.setBorrowDuration(row.getInt("borrow_duration"));
            unit.setBorrowMoney(row.getDouble("borrow_money"));
            unit.setBorrowInerest(row.getDouble("borrow_interest"));
            unit.setBorrowInerestRate(row.getFloat("borrow_interest_rate"));
            unit.setBorrowInfo(row.get("borrow_info"));
            unit.setProjectInfo(row.get("xm1"));
            unit.setCompanyInfo(row.get("xm2"));
            unit.setSafeguardInfo(row.get("xm3"));
            unit.setMortgageInfo(row.get("xm4"));
            unit.investmentBeginDate().parse(row.get("begin_date"));
            tenderLogic.doInsert(unit);
         }
         _units.set(code, unit);
      }
      return unit;
   }

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   @Override
   public void clear(){
      _units.clear();
   }
}
