package org.mo.content.core.logger.browser;

import com.cyou.gccloud.data.logger.FLoggerInfoBrowserAccessLogic;
import com.cyou.gccloud.data.logger.FLoggerInfoBrowserAccessUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole
      extends FAbstractLogicUnitConsole<FLoggerInfoBrowserAccessLogic, FLoggerInfoBrowserAccessUnit>
      implements
         IAccessConsole
{
   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAccessConsole(){
      super(FLoggerInfoBrowserAccessLogic.class, FLoggerInfoBrowserAccessUnit.class);
   }

   @Override
   public FLogicDataset<FLoggerInfoBrowserAccessUnit> select(ILogicContext logicContext,
                                                             int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FLoggerInfoBrowserAccessLogic logic = new FLoggerInfoBrowserAccessLogic(logicContext);
      FLogicDataset<FLoggerInfoBrowserAccessUnit> unitlist = logic.fetchClass(FLoggerInfoBrowserAccessUnit.class, null, null, _pageSize, pageNum);
      return unitlist;
   }

}
