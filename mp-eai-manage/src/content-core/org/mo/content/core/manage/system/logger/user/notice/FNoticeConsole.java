package org.mo.content.core.manage.system.logger.user.notice;

import com.cyou.gccloud.data.data.FDataPersonUserNoticeLogic;
import com.cyou.gccloud.data.data.FDataPersonUserNoticeUnit;
import com.cyou.gccloud.define.enums.common.EGcActive;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>公告日志控制台。</T>
//============================================================
public class FNoticeConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserNoticeLogic, FDataPersonUserNoticeUnit>
      implements
         INoticeConsole
{
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造公告日志控制台。</T>
   // ============================================================
   public FNoticeConsole(){
      super(FDataPersonUserNoticeLogic.class, FDataPersonUserNoticeUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataNoticeInfo> select(ILogicContext logicContext,
                                                int pageNum,
                                                int pageSize){
      if(0 > pageNum){
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FDataPersonUserNoticeLogic.UPDATE_DATE, "DESC");
      FDataPersonUserNoticeLogic logic = new FDataPersonUserNoticeLogic(logicContext);
      FLogicDataset<FDataNoticeInfo> unitlist = logic.fetchClass(FDataNoticeInfo.class, null, orderBy, pageSize, pageNum);
      for(FDataNoticeInfo info : unitlist){
         info.setUserName(info.user().name());
         info.setNoticeLabel(info.notice().label());
         info.setActiveCdStr(EGcActive.formatLabel(info.activeCd()));
      }
      return unitlist;
   }

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
   @Override
   public FLogicDataset<FDataNoticeInfo> selectByDateandActiveCd(ILogicContext logicContext,
                                                                 String beginDateStr,
                                                                 String endDateStr,
                                                                 int activeCd,
                                                                 String noticeLabel,
                                                                 int pageNum,
                                                                 int pageSize){
      if(0 > pageNum){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if(!RString.isEmpty(activeCd + "")){
         whereSql.append(" and ");
         whereSql.append(FDataPersonUserNoticeLogic.ACTIVE_CD + " = '{activeCd}'");
         whereSql.bind("activeCd", RString.parse(activeCd));
      }
      if(!RString.isEmpty(beginDateStr)){
         whereSql.append(" and ");
         whereSql.append(FDataPersonUserNoticeLogic.CREATE_DATE + " >= '{beginDateStr}'");
         whereSql.bind("beginDateStr", RString.parse(beginDateStr));
      }
      if(!RString.isEmpty(endDateStr)){
         whereSql.append(" and ");
         whereSql.append(FDataPersonUserNoticeLogic.CREATE_DATE + " <= '{endDateStr}'");
         whereSql.bind("endDateStr", RString.parse(endDateStr));
      }
      String orderBy = String.format("%s %s", FDataPersonUserNoticeLogic.UPDATE_DATE, "DESC");
      FLogicDataset<FDataNoticeInfo> list =new FLogicDataset<>(FDataNoticeInfo.class);
      FDataPersonUserNoticeLogic logic = new FDataPersonUserNoticeLogic(logicContext);
      FLogicDataset<FDataNoticeInfo> unitlist = logic.fetchClass(FDataNoticeInfo.class, whereSql.toString(), orderBy, pageSize, pageNum);
      for(FDataNoticeInfo info : unitlist){
         String label = info.notice().label();
         if(!RString.isEmpty(label)&&label.contains(noticeLabel)){
            info.setUserName(info.user().name());
            info.setNoticeLabel(info.notice().label());
            info.setActiveCdStr(EGcActive.formatLabel(info.activeCd()));
            list.push(info);
         }
      }
      return list;
   }
}
