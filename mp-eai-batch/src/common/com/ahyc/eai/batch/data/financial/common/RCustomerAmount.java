package com.ahyc.eai.batch.data.financial.common;

import com.cyou.gccloud.define.enums.financial.EGcFinancialAmountLevel;

//============================================================
// <T>用户数字。</T>
//============================================================
public class RCustomerAmount
{
   //============================================================
   // <T>计算数字分级。</T>
   //============================================================
   public static int calculateAmountLevelCd(double amount){
      if(amount > 10000000){
         return EGcFinancialAmountLevel.Level7;
      }else if(amount > 5000000){
         return EGcFinancialAmountLevel.Level6;
      }else if(amount > 1000000){
         return EGcFinancialAmountLevel.Level5;
      }else if(amount > 500000){
         return EGcFinancialAmountLevel.Level4;
      }else if(amount > 100000){
         return EGcFinancialAmountLevel.Level3;
      }else if(amount > 10000){
         return EGcFinancialAmountLevel.Level2;
      }else if(amount > 0){
         return EGcFinancialAmountLevel.Level1;
      }
      return EGcFinancialAmountLevel.Unknown;
   }

}
