package org.mo.content.core.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import com.cyou.gccloud.define.enums.core.EGcVersionForce;
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
      extends FAbstractLogicUnitConsole<FDataSystemVersionLogic, FDataSystemVersionUnit>
      implements
         IVersionConsole
{

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造版本控制台。</T>
   // ============================================================
   public FVersionConsole(){
      super(FDataSystemVersionLogic.class, FDataSystemVersionUnit.class);
   }

   @Override
   public FDataSystemVersionUnit findMaxByAppId(ILogicContext logicContext,
                                                long applicationId){
      FSql sql = new FSql();
      sql.append(FDataSystemVersionLogic.APPLICATION_ID, " = '{appId}'");
      sql.bind("appId", RString.parse(applicationId));
      sql.append(" AND ", FDataSystemVersionLogic.STATUS_CD, " = ", EGcResourceStatus.Publish);
      sql.append(" AND ", FDataSystemVersionLogic.FORCE_CD, " <> ", EGcVersionForce.NoUpdate);
      FLogicDataset<FDataSystemVersionUnit> unitList = fetch(logicContext, sql, "NUMBER DESC");
      if(unitList.count() > 0){
         return unitList.first();
      }
      return null;
   }
}
