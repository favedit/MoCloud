package org.mo.eai.logic.financial;

import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.common.EEaiDataConnection;

//============================================================
// <T>金融控制台。</T>
//============================================================
public class FFinancialMarketerConsole
      extends FConsole
      implements
         IFinancialMarketerConsole
{
   //============================================================
   // <T>根据理登录名称查找理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录名称
   // @return 理财师信息
   //============================================================
   @Override
   public FFinancialMarketerInfo findInfo(ILogicContext logicContext,
                                          String passport){
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      // 查找用户编号
      FSql findSql = new FSql("SELECT id FROM lzh_members WHERE user_name={passport}");
      findSql.bindString("passport", passport);
      FRow memberRow = connection.find(findSql);
      if(memberRow == null){
         return null;
      }
      // 查找理财师
      long memberId = memberRow.getLong("id");
      FSql managerSql = new FSql("SELECT id FROM idcard WHERE uid={user_id} status != 1");
      managerSql.bindLong("user_id", memberId);
      FRow managerRow = connection.find(findSql);
      if(managerRow == null){
         return null;
      }
      // 查找用户信息
      FSql memberInfoSql = new FSql("SELECT real_name,cell_phone,idcard FROM lzh_member_info WHERE uid={user_id}");
      memberInfoSql.bindLong("user_id", memberId);
      FRow memberInfoRow = connection.find(findSql);
      if(memberInfoRow == null){
         return null;
      }
      // 返回内容
      FFinancialMarketerInfo info = new FFinancialMarketerInfo();
      info.setPassport(passport);
      info.setLabel(memberInfoRow.get("real_name"));
      info.setPhone(memberInfoRow.get("cell_phone"));
      info.setCard(memberInfoRow.get("idcard"));
      return info;
   }
}
