package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityCardLogic;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>城市信息操作接口</P>
//
//@class FCitycardConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================

public class FCitycardConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityCardLogic, FDataCommonCityCardUnit>
      implements
         ICitycardConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCitycardConsole(){
      super(FDataCommonCityCardLogic.class, FDataCommonCityCardUnit.class);
   }

}
