package org.mo.content.core.manage.product.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserLogic;
import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>设备控制台。</T>
//============================================================
public class FDeviceBrowserConsole extends FAbstractLogicUnitConsole<FDataInfoDeviceBrowserLogic, FDataInfoDeviceBrowserUnit>implements IDeviceBrowserConsole {
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造设备控制台。</T>
   // ============================================================
   public FDeviceBrowserConsole() {
      super(FDataInfoDeviceBrowserLogic.class, FDataInfoDeviceBrowserUnit.class);
   }

   // ============================================================
   // <T>插入设备信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param deviceBrowserInfo 设备信息
   // @return 插入结果
   // ============================================================
   @Override
   public EResult insert(ILogicContext logicContext, FDataInfoDeviceBrowserUnit deviceBrowserInfo) {
      EResult resultCd = doInsert(logicContext, deviceBrowserInfo);
      return resultCd;
   }

   @Override
   public FLogicDataset<FDataInfoDeviceBrowserUnit> select(ILogicContext logicContext) {
      FDataInfoDeviceBrowserLogic logic = new FDataInfoDeviceBrowserLogic(logicContext);
      FLogicDataset<FDataInfoDeviceBrowserUnit> unitlist = logic.fetchClass(FDataInfoDeviceBrowserUnit.class, null, "CONTENT");
      return unitlist;
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataInfoDeviceBrowserUnit> select(ILogicContext logicContext, FDataInfoDeviceBrowserUnit unit, int pageNum, int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (!RString.isEmpty(unit.agentCode())) {
         whereSql.append(FDataInfoDeviceBrowserLogic.AGENT_CODE + " LIKE '%{code}%'");
         whereSql.bind("code", RString.parse(unit.agentCode()));
      }
      FDataInfoDeviceBrowserLogic logic = logicContext.findLogic(FDataInfoDeviceBrowserLogic.class);
      FLogicDataset<FDataInfoDeviceBrowserUnit> moduleList = logic.fetchClass(FDataInfoDeviceBrowserUnit.class, null, whereSql.toString(), null, pageSize, pageNum);
      return moduleList;
   }
}
