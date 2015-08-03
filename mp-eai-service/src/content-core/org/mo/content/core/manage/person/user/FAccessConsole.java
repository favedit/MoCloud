package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FDataPersonAccessAuthorityUnit>
      implements
         IAccessConsole
{
   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAccessConsole(){
      super(FDataPersonAccessAuthorityLogic.class, FDataPersonAccessAuthorityUnit.class);
   }

   @Override
   public FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext,
                                                               int pageNum){
      if(0 > pageNum){
         pageNum = 0;
      }
      FDataPersonAccessAuthorityLogic logic = logicContext.findLogic(FDataPersonAccessAuthorityLogic.class);
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = logic.fetchClass(FDataPersonAccessAuthorityUnit.class, null, null, _pageSize, pageNum);
      return unitlist;
   }

   @Override
   public EResult hostExists(ILogicContext logicContext,
                             String host){

      StringBuffer whereSql = new StringBuffer();
      if(!host.isEmpty()){
         whereSql.append(FDataPersonAccessAuthorityLogic.HOST_ADDRESS).append(" = '").append(host).append("'");
      }
      FDataPersonAccessAuthorityLogic logic = logicContext.findLogic(FDataPersonAccessAuthorityLogic.class);
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = logic.fetch(whereSql);
      return unitlist.count() > 0 ? EResult.Success : EResult.Failure;
   }

   @Override
   public EResult passportExists(ILogicContext logicContext,
                                 String passport){
      StringBuffer whereSql = new StringBuffer();
      if(!passport.isEmpty()){
         whereSql.append(FDataPersonAccessAuthorityLogic.PASSPORT).append(" = '").append(passport).append("'");
      }
      FDataPersonAccessAuthorityLogic logic = logicContext.findLogic(FDataPersonAccessAuthorityLogic.class);
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = logic.fetch(whereSql);
      return unitlist.count() > 0 ? EResult.Success : EResult.Failure;
   }

}
