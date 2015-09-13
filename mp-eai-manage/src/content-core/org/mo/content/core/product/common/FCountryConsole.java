package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>国家信息操作接口</P>
//
//@class FCountryConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================

public class FCountryConsole
      extends FAbstractLogicUnitConsole<FDataCommonCountryLogic, FDataCommonCountryUnit>
      implements
         ICountryConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCountryConsole(){
      super(FDataCommonCountryLogic.class, FDataCommonCountryUnit.class);
   }

}
