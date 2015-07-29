package org.mo.content.core.manage.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserLogic;
import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>设备控制台。</T>
//============================================================
public class FDeviceBrowserConsole
      extends FAbstractLogicUnitConsole<FDataInfoDeviceBrowserLogic, FDataInfoDeviceBrowserUnit>
      implements
         IDeviceBrowserConsole
{
   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDeviceBrowserConsole(){
      super(FDataInfoDeviceBrowserLogic.class, FDataInfoDeviceBrowserUnit.class);
   }

   //============================================================
   // <T>插入设备信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param deviceBrowserInfo 设备信息
   // @return 插入结果
   //============================================================
   @Override
   public EResult insert(ILogicContext logicContext,
                         FDataInfoDeviceBrowserUnit deviceBrowserInfo){
      EResult resultCd = doInsert(logicContext, deviceBrowserInfo);
      return resultCd;
   }

   @Override
   public FLogicDataset<FDataInfoDeviceBrowserUnit> select(ILogicContext logicContext,
                                                           int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FDataInfoDeviceBrowserLogic logic = new FDataInfoDeviceBrowserLogic(logicContext);
      FLogicDataset<FDataInfoDeviceBrowserUnit> unitlist = logic.fetchClass(FDataInfoDeviceBrowserUnit.class, null, null, _pageSize, pageNum);
      return unitlist;
   }

}
