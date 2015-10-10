package org.mo.content.core.manage.product.user.logger;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole
      extends FAbstractLogicUnitConsole<FLoggerPersonUserAccessLogic, FLoggerPersonUserAccessUnit>
      implements
         IAccessConsole
{
   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAccessConsole(){
      super(FLoggerPersonUserAccessLogic.class, FLoggerPersonUserAccessUnit.class);
   }

   @Override
   public FLogicDataset<FLoggerPersonUserAccessUnit> select(ILogicContext logicContext,
                                                            int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, null, "UPDATE_DATE DESC", _pageSize, pageNum);
      return unitlist;
   }
}
