package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
//============================================================
//<P>区域信息操作接口</P>
//
//@class FAreaConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FAreaConsole
      extends FAbstractLogicUnitConsole<FDataCommonAreaLogic, FDataCommonAreaUnit>
      implements
         IAreaConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAreaConsole(){
      super(FDataCommonAreaLogic.class, FDataCommonAreaUnit.class);
   }

   @Override
   public FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext,
                                              FDataCommonAreaUnit unit,
                                              int pageNum,
                                              int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql where = new FSql();
      if(!RString.isEmpty(unit.label())){
         where.append(FDataCommonAreaLogic.LABEL);
         where.append(" LIKE '%");
         where.append(unit.label() + "%'");
      }
      String orderBy = String.format("%s %s", FDataCommonAreaLogic.LABEL, "ASC");
      FDataCommonAreaLogic logic = logicContext.findLogic(FDataCommonAreaLogic.class);
      FLogicDataset<FDataAreaInfo> userInfoList = logic.fetchClass(FDataAreaInfo.class, null, where.toString(), null, pageSize, pageNum);
      return userInfoList;
   }

}
