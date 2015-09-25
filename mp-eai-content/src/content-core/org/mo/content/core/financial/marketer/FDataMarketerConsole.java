package org.mo.content.core.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerLogic;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师控制台。</T>
//============================================================
public class FDataMarketerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialMarketerLogic, FDataFinancialMarketerUnit>
      implements
         IDataMarketerConsole
{
   //============================================================
   // <T>构造控制台。</T>
   //============================================================
   public FDataMarketerConsole(){
      super(FDataFinancialMarketerLogic.class, FDataFinancialMarketerUnit.class);
   }

   // ============================================================
   // <T>获取对象</T>
   //
   // @param logicContext 链接对象
   // @param  passport 理财师passport
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialMarketerUnit findByPassport(ILogicContext logicContext,
                                                    String passport){
      FDataFinancialMarketerLogic logic = logicContext.findLogic(FDataFinancialMarketerLogic.class);
      FSql whereSql = new FSql();
      if(passport.isEmpty()){
         throw new FFatalError("findByPassport,passport is null");
      }
      whereSql.append(FDataFinancialMarketerLogic.PASSPORT + " = '{passport}'");
      whereSql.bind("passport", passport);
      FLogicDataset<FDataFinancialMarketerUnit> list = logic.fetch(whereSql);
      if(list.count() <= 0){
         return null;
      }
      return list.first();
   }

}
