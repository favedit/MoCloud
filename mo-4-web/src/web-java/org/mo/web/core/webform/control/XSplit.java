package org.mo.web.core.webform.control;

import org.mo.web.core.webform.base.XBaseSplit;

public class XSplit
      extends XBaseSplit
{

   @Override
   public String getDispConfig(){
      return RPropertyMaker.getDispConfig(this);
   }

   @Override
   public String getDispMode(){
      return RPropertyMaker.getDispMode(this);
   }

   @Override
   public void setDispConfig(String value){
      RPropertyMaker.setDispConfig(this, value);
   }

   @Override
   public void setDispMode(String value){
      RPropertyMaker.setDispMode(this, value);
   }

}
