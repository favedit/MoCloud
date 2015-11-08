package com.ahyc.eai.service.cockpit.forecast;

public class ForecastUnit
{
   String label;

   Object[] months;

   public String getLabel(){
      return label;
   }

   public void setLabel(String label){
      this.label = label;
   }

   public Object[] getMonths(){
      return months;
   }

   public void setMonths(Object[] months){
      this.months = months;
   }

}
