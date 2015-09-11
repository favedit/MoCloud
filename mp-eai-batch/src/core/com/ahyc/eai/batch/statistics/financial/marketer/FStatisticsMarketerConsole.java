package com.ahyc.eai.batch.statistics.financial.marketer;

import com.ahyc.eai.batch.common.FStatisticsPoolConsole;
import com.ahyc.eai.batch.statistics.financial.member.IStatisticsMemberConsole;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMemberUnit;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.core.common.EEaiDataConnection;

//============================================================
// <T>统计投标控制台。</T>
//============================================================
public class FStatisticsMarketerConsole
      extends FStatisticsPoolConsole<FStatisticsFinancialMarketerUnit>
      implements
         IStatisticsMarketerConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsMarketerConsole.class);

   // 成员控制台
   @ALink
   protected IStatisticsMemberConsole _memberConsole;

   //============================================================
   // <T>构造金融用户控制台。</T>
   //============================================================
   public FStatisticsMarketerConsole(){
      super(FStatisticsFinancialMarketerUnit.class);
   }

   //============================================================
   // <T>根据编号同步一个理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param linkId 关联编号
   //============================================================
   @Override
   public FStatisticsFinancialMarketerUnit syncByLinkId(FLogicContext logicContext,
                                                        long linkId){
      // 检查参数
      if(linkId == 0){
         return null;
      }
      // 查找单元
      String code = Long.toString(linkId);
      FStatisticsFinancialMarketerUnit unit = _pool.find(code);
      if(unit != null){
         return unit;
      }
      // 查找单元
      FStatisticsFinancialMarketerLogic logic = logicContext.findLogic(FStatisticsFinancialMarketerLogic.class);
      unit = logic.search("LINK_ID=" + linkId);
      if(unit != null){
         return unit;
      }
      //............................................................
      // 查找成员
      FStatisticsFinancialMemberUnit memberUnit = _memberConsole.syncByLinkId(logicContext, linkId);
      if(memberUnit == null){
         throw new FFatalError("Marketer member is not exists. (link_id={1})", linkId);
      }
      //............................................................
      // 查询信息
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      FSql sql = _resource.findString(FSql.class, "sql.marketer");
      sql.bindLong("id", linkId);
      FRow row = connection.find(sql);
      if(row == null){
         throw new FFatalError("Marketer is not exists. (link_id={1})", linkId);
      }
      // 查询状态
      FSql statusSql = _resource.findString(FSql.class, "sql.marketer.status");
      statusSql.bindLong("id", linkId);
      FRow statusRow = connection.find(statusSql);
      // 新建单元
      unit = logic.doPrepare();
      unit.setLinkId(linkId);
      unit.linkDate().parse(row.get("upd_time"));
      unit.setLinkDepartmentId(row.getLong("belong_dept"));
      unit.setCode(row.get("code"));
      unit.setLabel(row.get("real_name"));
      unit.setRankLabel(row.get("rank"));
      unit.setPhone(memberUnit.phone());
      unit.setCard(memberUnit.card());
      unit.setStatusCd(row.getInt("status"));
      if(statusRow != null){
         unit.enterDate().parse(statusRow.get("add_date"));
      }else{
         unit.enterDate().parse(row.get("add_date"));
      }
      logic.doInsert(unit);
      return unit;
   }
}
