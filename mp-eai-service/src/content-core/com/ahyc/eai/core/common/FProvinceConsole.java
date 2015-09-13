package com.ahyc.eai.core.common;

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
import org.mo.data.logic.ILogicContext;

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

   // ============================================================
   // <T>根据名称获取对象</T>
   //
   // @param logicContext 链接对象
   // @param label 名称
   // @return 数据对象
   // ============================================================
   @Override
   public FDataCommonProvinceUnit findByLabel(ILogicContext context,
                                              String label){

      StringBuffer where = new StringBuffer();
      if(label != null){
         where.append(FDataCommonProvinceLogic.LABEL).append(" = '").append(label).append("'");
      }
      FDataCommonProvinceLogic logic = context.findLogic(FDataCommonProvinceLogic.class);
      FDataCommonProvinceUnit province = logic.search(where);
      return province;
   }

}
