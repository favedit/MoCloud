package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融成员控制台接口。</T>
//============================================================
public interface IDataMemberConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialMemberUnit>
{
   // ============================================================
   // <T>获得分页数据</T>
   //
   // @param logicContext 链接对象
   // @param  pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialMemberInfo> select(ILogicContext logicContext,
                                                  int pageNum);

   // ============================================================
   // <T>用户关注</T>
   //
   // @param logicContext 链接对象
   // @param  guid 用户唯一码
   // @return 数据集合
   // ============================================================
   EResult follow(ILogicContext logicContext,
                  String guid);

   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @return 总页数
   // ============================================================
   int getPageCount(ILogicContext logicContext);

   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  guid 用户唯一码
   // @return 数据对象
   // ============================================================
   FDataFinancialMemberInfo findInfoByGuid(ILogicContext logicContext,
                                           String guid);
}
