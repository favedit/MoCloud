package org.mo.eai.console.financial;

import com.cyou.gccloud.data.data.FDataFinancialMarketerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.com.collections.FRow;
import org.mo.com.console.FConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.eai.core.common.EEaiLogicMode;

//============================================================
// <T>金融控制台。</T>
//============================================================
public class FFinancialMarketerConsole
      extends FConsole
      implements
         IFinancialMarketerConsole
{
   // 工作模式
   @AProperty
   protected String _modeCd = "online";

   //============================================================
   // <T>根据理登录名称查找理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录名称
   // @return 理财师信息
   //============================================================
   public FFinancialMarketerInfo testFindInfo(ILogicContext logicContext,
                                              String passport){
      FDataFinancialMarketerLogic marketerLogic = logicContext.findLogic(FDataFinancialMarketerLogic.class);
      // 查找数据
      FSql whereSql = new FSql(FDataFinancialMarketerLogic.PASSPORT + "={passsport}");
      whereSql.bindString("passsport", passport);
      FDataFinancialMarketerUnit unit = marketerLogic.search(whereSql);
      if(unit == null){
         return null;
      }
      // 返回内容
      FFinancialMarketerInfo info = new FFinancialMarketerInfo();
      info.setPassport(passport);
      info.setLabel(unit.label());
      info.setPhone(unit.phone());
      info.setCard(unit.card());
      return info;
   }

   //============================================================
   // <T>根据理登录名称查找理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录名称
   // @return 理财师信息
   //============================================================
   public FFinancialMarketerInfo onlineFindInfo(ILogicContext logicContext,
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
      if(EEaiLogicMode.Test.equals(_modeCd)){
         return testFindInfo(logicContext, passport);
      }else if(EEaiLogicMode.Online.equals(_modeCd)){
         return onlineFindInfo(logicContext, passport);
      }else{
         throw new FFatalError("Invalid info.");
      }
   }
}
