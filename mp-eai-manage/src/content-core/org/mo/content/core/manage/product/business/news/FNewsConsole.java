package org.mo.content.core.manage.product.business.news;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>新闻控制台</P>
//@class FNewsConsole
//@version 1.0.0
//============================================================
public class FNewsConsole 
      extends 
         FAbstractLogicUnitConsole<FDataLogicNewsLogic, FDataLogicNewsUnit>
      implements 
         INewsConsole 
{

   // 每页条数
   static final int _pageSize = 20;
   // 应用名称
   @AProperty
   protected String _applicationName;
   // 服务器地址
   @AProperty
   protected String _servers;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FNewsConsole() {
      super(FDataLogicNewsLogic.class, FDataLogicNewsUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataNewsInfo> select(ILogicContext logicContext, 
                                              FDataLogicNewsUnit unit, 
                                              int pageNum, 
                                              int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataLogicNewsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s, %s %s", FDataLogicNewsLogic.DISPLAY_ORDER, "DESC", FDataLogicNewsLogic.RECORD_DATE, "DESC");
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FLogicDataset<FDataNewsInfo> moduleList = logic.fetchClass(FDataNewsInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataNewsInfo info : moduleList) {
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         info.setDisplayCdStr(EGcDisplay.formatLabel(info.displayCd()));
         info.setLinkCdStr(EGcLink.formatLabel(info.linkCd()));
      }
      return moduleList;
   }
   // ============================================================
   // <T>根据状态，是否显示，标题查询数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @param statusCd 状态
   // @param displayCd 是否显示
   // @param label 标题
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataNewsInfo> selectByMessage(ILogicContext logicContext, 
                                                       Integer statusCd,
                                                       Integer displayCd,
                                                       String label, 
                                                       int pageNum,
                                                       int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(label)) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicNewsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(label));
      }
      if (!RString.isEmpty(displayCd+"")) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicNewsLogic.DISPLAY_CD + " = '{displayCd}'");
         whereSql.bind("displayCd", RString.parse(displayCd));
      }
      if (!RString.isEmpty(statusCd+"")) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicNewsLogic.STATUS_CD + " = '{statusCd}'");
         whereSql.bind("statusCd", RString.parse(statusCd));
      }
      String orderBy = String.format("%s %s", FDataLogicNewsLogic.UPDATE_DATE, "DESC");
      FDataLogicNewsLogic logic = new FDataLogicNewsLogic(logicContext);
      FLogicDataset<FDataNewsInfo> unitlist = logic.fetchClass(FDataNewsInfo.class, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataNewsInfo info :unitlist) {
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         info.setDisplayCdStr(EGcDisplay.formatLabel(info.displayCd()));
         info.setLinkCdStr(EGcLink.formatLabel(info.linkCd()));
      }
      return unitlist;
   }
}
