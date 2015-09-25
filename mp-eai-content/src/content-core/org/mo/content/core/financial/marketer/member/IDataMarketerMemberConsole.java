package org.mo.content.core.financial.marketer.member;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
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

   // ============================================================
   // <T>获取已关注的</T>
   //
   // @param logicContext 链接对象
   // @param  memberId 成员编号
   // @return 数据对象
   // ============================================================
   FDataFinancialMarketerMemberUnit findFollowed(ILogicContext logicContext,
                                                 long memberId);

   // ============================================================
   // <T>获取理财师已关注的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataFinancialMarketerMemberInfo> selectFollowedByMarketerId(ILogicContext logicContext,
                                                                              long marketerId,
                                                                              int pageNum);

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @return 总页数
   // ============================================================
   int getPageCount(ILogicContext logicContext);

   // ============================================================
   // <T>获取当前理财师 是否关注过此成员</T>
   //
   // @param logicContext 链接对象
   // @return 总页数
   // ============================================================
   FDataFinancialMarketerMemberUnit findByMarketerAndMember(ILogicContext logicContext,
                                                            long marketerId,
                                                            long memberId);
}
