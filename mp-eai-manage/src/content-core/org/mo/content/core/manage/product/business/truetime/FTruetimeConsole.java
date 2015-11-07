package org.mo.content.core.manage.product.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeLogic;
import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>实时数据制台</P>
//@class FTruetimeConsole
//@version 1.0.0
//============================================================
public class FTruetimeConsole
      extends FAbstractLogicUnitConsole<FDataLogicTruetimeLogic, FDataLogicTruetimeUnit>
      implements
         ITruetimeConsole
{

   // 每页条数
   static final int _pageSize = 20;

   // 应用名称
   @AProperty
   protected String _applicationName;

   // 服务器地址
   @AProperty
   protected String _servers;

   // 存储服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FTruetimeConsole(){
      super(FDataLogicTruetimeLogic.class, FDataLogicTruetimeUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataTruetimeInfo> select(ILogicContext logicContext,
                                                  FDataLogicTruetimeUnit unit,
                                                  int pageNum,
                                                  int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataLogicTruetimeLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      String orderBy = String.format("%s %s, %s %s", FDataLogicTruetimeLogic.DISPLAY_ORDER, "DESC", FDataLogicTruetimeLogic.RECORD_DATE, "DESC");
      FDataLogicTruetimeLogic logic = logicContext.findLogic(FDataLogicTruetimeLogic.class);
      FLogicDataset<FDataTruetimeInfo> moduleList = logic.fetchClass(FDataTruetimeInfo.class, null, whereSql.toString(), orderBy, pageSize, pageNum);
      for(FDataTruetimeInfo info : moduleList){
         info.setStatusCdStr(EGcResourceStatus.formatLabel(info.statusCd()));
         info.setDisplayCdStr(EGcDisplay.formatLabel(info.displayCd()));
         info.setLinkCdStr(EGcLink.formatLabel(info.linkCd()));
      }
      return moduleList;
   }
}
