package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>省份信息操作接口</P>
//
//@class FProvinceConsole
//@author Sunhr
//@Date 2015.09.13  
//@version 1.0.0
//============================================================

public class FProvinceConsole
      extends FAbstractLogicUnitConsole<FDataCommonProvinceLogic, FDataCommonProvinceUnit>
      implements
         IProvinceConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FProvinceConsole(){
      super(FDataCommonProvinceLogic.class, FDataCommonProvinceUnit.class);
   }

}
