package org.mo.content.core.manage.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import com.cyou.gccloud.define.enums.core.EGcVersionForce;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>版本控制台</P>
//@class FVersionConsole
//@version 1.0.0
//============================================================
public class FVersionConsole 
      extends 
         FAbstractLogicUnitConsole<FDataSystemVersionLogic, FDataSystemVersionUnit>
      implements 
         IVersionConsole 
{

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造版本控制台。</T>
   // ============================================================
   public FVersionConsole() {
      super(FDataSystemVersionLogic.class, FDataSystemVersionUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataVersionInfo> select(ILogicContext logicContext, 
                                                 FDataSystemVersionUnit unit, 
                                                 int pageNum, 
                                                 int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataSystemVersionLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", unit.label());
      }
      String orderBy = String.format("%s %s, %s %s", FDataSystemVersionLogic.NUMBER, "DESC", FDataSystemVersionLogic.LABEL, "DESC");
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataVersionInfo> moduleList = logic.fetchClass(FDataVersionInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataVersionInfo info : moduleList) {
         info.setApplicationLabel(info.application().code());
         info.setForceCdStr(EGcVersionForce.formatLabel(info.forceCd()));
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         DecimalFormat a = new DecimalFormat("#,##0.00");
         String frmStr = a.format(info.number());
         info.setNumberStr(frmStr);
      }
      return moduleList;
   }

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataSystemVersionUnit findByLable(ILogicContext logicContext, String label) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(label)) {
         whereSql.append(FDataSystemVersionLogic.LABEL);
         whereSql.append(" like '%");
         whereSql.append("{label}");
         whereSql.bind("label", label);
         whereSql.append("%'");
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataSystemVersionUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   // ============================================================
   // <T>根应用id和版本号和ouid 对象</T>
   // @param logicContext 链接对象
   // @return 是否重复
   // ============================================================
   @Override
   public boolean isExsitsAppIdandNumber(ILogicContext logicContext, Long applicationId, Float number) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(applicationId + "") && !RString.isEmpty(number + "")) {
         whereSql.append(FDataSystemVersionLogic.APPLICATION_ID);
         whereSql.append(" = ");
         whereSql.append("{applicationId}");
         whereSql.bind("applicationId", RString.parse(applicationId));
         whereSql.append(" and ");
         whereSql.append(FDataSystemVersionLogic.NUMBER);
         whereSql.append(" = ");
         whereSql.append("{number}");
         whereSql.bind("number", RString.parse(number));
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataSystemVersionUnit> verList = logic.fetch(whereSql.toString());
      if (verList.count() > 0) {
         return true;
      }
      return false;
   }

   // ============================================================
   // <T>根据应用id和版本号和ouid判断是否有重复数据</T>
   // @param logicContext 链接对象
   // @return 是否重复
   // ============================================================
   @Override
   public boolean isExsitsAppIdandNumberandOuid(ILogicContext logicContext, Long applicationId, Long ouid, Float number) {
      FSql whereSql = new FSql();
      if (!RString.isEmpty(applicationId + "") && !RString.isEmpty(number + "")) {
         whereSql.append(FDataSystemVersionLogic.APPLICATION_ID);
         whereSql.append(" = ");
         whereSql.append("{applicationId}");
         whereSql.bind("applicationId", RString.parse(applicationId));
         whereSql.append(" and ");
         whereSql.append(FDataSystemVersionLogic.NUMBER);
         whereSql.append(" = ");
         whereSql.append("{number}");
         whereSql.bind("number", RString.parse(number));
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataSystemVersionUnit> verList = logic.fetch(whereSql.toString());
      if (verList.count() > 0) {
         for (Iterator<FDataSystemVersionUnit> iterator = verList.iterator(); iterator.hasNext();) {
            FDataSystemVersionUnit unit = iterator.next();
            if (!RString.equals(unit.ouid(), ouid)) {
               return true;
            }
         }
      }
      return false;
   }

   // ============================================================
   // <T>抽取数据库字段枚举赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return void
   // ============================================================
   public void setInfoVersionLabel(FDataVersionInfo info) {
      if (RString.equals(EGcResourceStatus.Unknown, info.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.UnknownLabel);
      }
      if (RString.equals(EGcResourceStatus.Apply, info.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
      }
      if (RString.equals(EGcResourceStatus.Publish, info.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.PublishLabel);
      }
      if (RString.equals(EGcResourceStatus.CheckFail, info.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
      }
      if (RString.equals(EGcVersionForce.Unknown, info.statusCd())) {
         info.setForceCdStr(EGcVersionForce.UnknownLabel);
      }
      if (RString.equals(EGcVersionForce.Optional, info.statusCd())) {
         info.setForceCdStr(EGcVersionForce.OptionalLabel);
      }
      if (RString.equals(EGcVersionForce.Auto, info.statusCd())) {
         info.setForceCdStr(EGcVersionForce.AutoLabel);
      }
      if (RString.equals(EGcVersionForce.Force, info.statusCd())) {
         info.setForceCdStr(EGcVersionForce.ForceLabel);
      }
      if (RString.equals(EGcVersionForce.NoUpdate, info.statusCd())) {
         info.setForceCdStr(EGcVersionForce.NoUpdateLabel);
      }
   }

   @Override
   public FLogicDataset<FDataVersionInfo> selectExamine(ILogicContext logicContext, FDataSystemVersionUnit unit, int pageNum, int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataSystemVersionLogic.STATUS_CD, " = " + EGcResourceStatus.Apply + " ");// 只查询状态为申请
      if (!RString.isEmpty(unit.label())) {
         whereSql.append(FDataSystemVersionLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", unit.label());
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataVersionInfo> moduleList = logic.fetchClass(FDataVersionInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for (FDataVersionInfo info : moduleList) {
         info.setApplicationLabel(info.application().code());
         info.setForceCdStr(EGcVersionForce.formatLabel(info.forceCd()));
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
      }
      return moduleList;
   }
}
