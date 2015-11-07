package org.mo.content.core.manage.product.examine.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicSalestoolsLogic;
import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
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
//<P>销售工具控制台</P>
//@class FSalestoolsConsole
//@version 1.0.0
//============================================================
public class FSalestoolsConsole 
      extends 
         FAbstractLogicUnitConsole<FDataLogicSalestoolsLogic, FDataLogicSalestoolsUnit>
      implements 
         ISalestoolsConsole 
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
   public FSalestoolsConsole() {
      super(FDataLogicSalestoolsLogic.class, FDataLogicSalestoolsUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataSalestoolsInfo> select(ILogicContext logicContext, 
                                                    FDataLogicSalestoolsUnit unit, 
                                                    int pageNum, 
                                                    int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicNewsLogic.STATUS_CD + " = '{statusCd}'");
      whereSql.bind("statusCd", EGcResourceStatus.Apply + "");// 只查询状态为申请
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(" and ");
         whereSql.append(FDataLogicSalestoolsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s, %s %s", FDataLogicNewsLogic.DISPLAY_ORDER, "DESC", FDataLogicNewsLogic.RECORD_DATE, "DESC");
      FDataLogicSalestoolsLogic logic = logicContext.findLogic(FDataLogicSalestoolsLogic.class);
      FLogicDataset<FDataSalestoolsInfo> moduleList = logic.fetchClass(FDataSalestoolsInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataSalestoolsInfo info : moduleList) {
         if (RString.equals(EGcResourceStatus.Apply, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
         }
         if (RString.equals(EGcResourceStatus.Publish, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.PublishLabel);
         }
         if (RString.equals(EGcResourceStatus.CheckFail, info.statusCd())) {
            info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
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
