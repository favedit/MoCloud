package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>区域信息操作接口</P>
//
//@class FAreaConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================

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

}
