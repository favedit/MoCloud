package org.mo.content.core.manage.product.examine.business;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import java.util.Iterator;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>新闻控制台</P>
//@class FNewsConsole
//@author XIAOHUI ZHANG
//@Date 2015.09.21 
//@version 1.0.0
//============================================================
public class FNewsConsole extends FAbstractLogicUnitConsole<FDataLogicNewsLogic, FDataLogicNewsUnit>implements INewsConsole {

   // 每页条数
   static final int _pageSize = 20;

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
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataNewsInfo> select(ILogicContext logicContext, FDataLogicNewsUnit unit, int pageNum, int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicNewsLogic.STATUS_CD + " = '{statusCd}'");
      whereSql.bind("statusCd", EGcResourceStatus.Apply + "");// 只查询状态为申请
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicNewsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FLogicDataset<FDataNewsInfo> moduleList = logic.fetchClass(FDataNewsInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for (Iterator<FDataNewsInfo> ite = moduleList.iterator(); ite.hasNext();) {
         FDataNewsInfo info = ite.next();
         if (RString.equals(EGcResourceStatus.Apply, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
         }
         if (RString.equals(EGcDisplay.Disable, info.displayCd())) {
            info.setDisplayCdStr(EGcDisplay.DisableLabel);
         }
         if (RString.equals(EGcDisplay.Enabled, info.displayCd())) {
            info.setDisplayCdStr(EGcDisplay.EnabledLabel);
         }
         if (RString.equals(EGcLink.Unknown, info.linkCd())) {
            info.setLinkCdStr(EGcLink.UnknownLabel);
         }
         if (RString.equals(EGcLink.Content, info.linkCd())) {
            info.setLinkCdStr(EGcLink.ContentLabel);
         }
         if (RString.equals(EGcLink.Link, info.linkCd())) {
            info.setLinkCdStr(EGcLink.LinkLabel);
         }
      }
      return moduleList;
   }

}
