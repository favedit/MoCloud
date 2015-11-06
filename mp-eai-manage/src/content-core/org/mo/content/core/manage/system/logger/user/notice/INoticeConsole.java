package org.mo.content.core.manage.system.logger.user.notice;

import com.cyou.gccloud.data.data.FDataPersonUserNoticeUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>公告日志控制台接口。</T>
//============================================================
public interface INoticeConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonUserNoticeUnit>
{
   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNoticeInfo> select(ILogicContext logicContext,
                                         int pageNum,
                                         int pageSize);

   // ============================================================
   // <T>根据时间段和操作信息查询数据</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @param beginDateStr 开始时间
   // @param endDateStr 结束时间
   // @param activeCd 是否激活
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNoticeInfo> selectByDateandActiveCd(ILogicContext logicContext,
                                                          String beginDateStr,
                                                          String endDateStr,
                                                          int activeCd,
                                                          String noticeLabel,
                                                          int pageNum,
                                                          int pageSize);
}
