package org.mo.content.core.manage.product.examine.business.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>公告控制台</P>
//@class FNoticeConsole
//@version 1.0.0
//============================================================
public class FNoticeConsole 
      extends 
         FAbstractLogicUnitConsole<FDataLogicNoticeLogic, FDataLogicNoticeUnit>
      implements 
         INoticeConsole 
{

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FNoticeConsole() {
      super(FDataLogicNoticeLogic.class, FDataLogicNoticeUnit.class);
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
                                                FDataLogicNoticeUnit unit, 
                                                int pageNum, 
                                                int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicNoticeLogic.STATUS_CD + " = '{statusCd}'");
      whereSql.bind("statusCd", EGcResourceStatus.Apply + "");// 只查询状态为申请
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicNoticeLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s, %s %s", FDataLogicNoticeLogic.DISPLAY_ORDER, "DESC", FDataLogicNoticeLogic.CREATE_DATE, "DESC");
      FDataLogicNoticeLogic logic = logicContext.findLogic(FDataLogicNoticeLogic.class);
      FLogicDataset<FDataNoticeInfo> moduleList = logic.fetchClass(FDataNoticeInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataNoticeInfo info : moduleList) {
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         info.setDisplayCdStr(EGcDisplay.formatLabel(info.displayCd()));
         info.setLinkCdStr(EGcLink.formatLabel(info.linkCd()));
         info.setUserName(info.user()==null?"":info.user().label());
      }
      return moduleList;
   }

}
