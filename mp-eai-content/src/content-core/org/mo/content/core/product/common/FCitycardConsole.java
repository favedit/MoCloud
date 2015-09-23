package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityCardLogic;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>城市身份证关联控制台</P>
//@class FCitycardConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FCitycardConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityCardLogic, FDataCommonCityCardUnit>
      implements
         ICitycardConsole
{

   //============================================================
   // <T>构造城市身份证关联控制台。</T>
   //============================================================
   public FCitycardConsole(){
      super(FDataCommonCityCardLogic.class, FDataCommonCityCardUnit.class);
   }

}
