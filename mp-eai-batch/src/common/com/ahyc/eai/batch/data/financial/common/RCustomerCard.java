package com.ahyc.eai.batch.data.financial.common;

import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerGender;
import org.mo.com.lang.RString;

public class RCustomerCard
{
   public static String calculateArea(String customerCard){
      if(!RString.isEmpty(customerCard)){
         if(customerCard.length() == 18){
            return customerCard.substring(0, 6);
         }else if(customerCard.length() == 15){
            return customerCard.substring(0, 6);
         }
      }
      return null;
   }

   public static String calculateBirth(String customerCard){
      if(!RString.isEmpty(customerCard)){
         if(customerCard.length() == 18){
            return customerCard.substring(6, 14);
         }else if(customerCard.length() == 15){
            return "19" + customerCard.substring(6, 12);
         }
      }
      return null;
   }

   public static int calculateGender(String customerCard){
      if(!RString.isEmpty(customerCard)){
         if(customerCard.length() == 18){
            int customerGender = customerCard.charAt(16) - '0';
            if((customerGender >= 0) && (customerGender <= 9)){
               if(customerGender % 2 == 0){
                  return EGcFinancialCustomerGender.Female;
               }else{
                  return EGcFinancialCustomerGender.Male;
               }
            }
         }else if(customerCard.length() == 15){
            int customerGender = customerCard.charAt(14) - '0';
            if((customerGender >= 0) && (customerGender <= 9)){
               if(customerGender % 2 == 0){
                  return EGcFinancialCustomerGender.Female;
               }else{
                  return EGcFinancialCustomerGender.Male;
               }
            }
         }
      }
      return 0;
   }
}
