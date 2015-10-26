package com.ahyc.eai.batch.statistics.financial.member;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.ahyc.eai.batch.data.financial.common.RCustomerCard;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.RString;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>金融用户控制台。</T>
//============================================================
public class FStatisticsMemberConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialMemberUnit>
      implements
         IStatisticsMemberConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsMemberConsole.class);

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FStatisticsMemberConsole(){
      super(FStatisticsFinancialMemberUnit.class);
   }

   //============================================================
   // <T>根据编号同步一个用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialMemberUnit syncByLinkId(FLogicContext logicContext,
                                                      long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialMemberUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialMemberLogic logic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      unit = logic.search(FStatisticsFinancialMemberLogic.LINK_ID + "=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FSql sql = _resource.findString(FSql.class, "sql.member");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row == null){
         return null;
      }
      FSql infoSql = _resource.findString(FSql.class, "sql.member.info");
      infoSql.bindLong("id", linkId);
      FRow infoRow = connection.find(infoSql);
      // 新建单元
      unit = logic.doPrepare();
      unit.setLinkId(linkId);
      unit.linkDate().parse(row.get("upd_time"));
      unit.setPassport(row.get("user_name"));
      unit.setPhone(row.get("user_phone"));
      unit.setEmail(row.get("user_email"));
      unit.registerDate().parse(row.get("register_date"));
      unit.lastLoginDate().parse(row.get("last_login_date"));
      if(infoRow != null){
         String card = infoRow.get("idcard");
         unit.setLabel(infoRow.get("real_name"));
         unit.setCard(card);
         if(!RString.isEmpty(card)){
            unit.setCardArea(RCustomerCard.calculateArea(card));
            unit.setCardBirth(RCustomerCard.calculateBirth(card));
            unit.setCardGender(RCustomerCard.calculateGender(card));
         }
         unit.setGenderCode(infoRow.get("sex"));
         unit.setMarryCode(infoRow.get("marry"));
         unit.setEducationCode(infoRow.get("education"));
         unit.setBusinessCode(infoRow.get("zy"));
         unit.setIncomeCode(infoRow.get("income"));
         unit.setProvinceCode(infoRow.getInt("province"));
         unit.setCityCode(infoRow.getInt("city"));
         unit.setAreaCode(infoRow.getInt("area"));
         unit.setAddress(infoRow.get("address"));
         unit.setInfo(infoRow.get("info"));
      }
      logic.doInsert(unit);
      return unit;
   }

   //============================================================
   // <T>根据编号更新一个用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialMemberUnit updateByLinkId(FLogicContext logicContext,
                                                        long linkId){
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      // 查找单元
      FStatisticsFinancialMemberLogic logic = logicContext.findLogic(FStatisticsFinancialMemberLogic.class);
      FStatisticsFinancialMemberUnit unit = logic.search("LINK_ID=" + linkId);
      if(unit == null){
         return null;
      }
      // 设置基本信息
      FSql sql = _resource.findString(FSql.class, "sql.member");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row != null){
         unit.setPhone(row.get("user_phone"));
         unit.setEmail(row.get("user_email"));
         unit.registerDate().parse(row.get("register_date"));
      }
      // 更新详细信息
      FSql infoSql = _resource.findString(FSql.class, "sql.member.info");
      infoSql.bindLong("id", linkId);
      FRow infoRow = connection.find(infoSql);
      if(infoRow != null){
         String card = infoRow.get("idcard");
         unit.setLabel(infoRow.get("real_name"));
         if(!RString.isEmpty(card)){
            unit.setCardArea(RCustomerCard.calculateArea(card));
            unit.setCardBirth(RCustomerCard.calculateBirth(card));
            unit.setCardGender(RCustomerCard.calculateGender(card));
         }
         unit.setGenderCode(infoRow.get("sex"));
         unit.setMarryCode(infoRow.get("marry"));
         unit.setEducationCode(infoRow.get("education"));
         unit.setBusinessCode(infoRow.get("zy"));
         unit.setIncomeCode(infoRow.get("income"));
         unit.setProvinceCode(infoRow.getInt("province"));
         unit.setCityCode(infoRow.getInt("city"));
         unit.setAreaCode(infoRow.getInt("area"));
         unit.setAddress(infoRow.get("address"));
         unit.setInfo(infoRow.get("info"));
      }
      logic.doUpdate(unit);
      return unit;
   }
}
