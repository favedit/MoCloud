package org.mo.content.core.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

public class FDataFinancialProductInfo
      extends FDataFinancialProductUnit
{
   // 净投资
   protected float _netInvestment_total;
   
   public float netInvestment_total(){
      return _netInvestment_total;
   }
   
   public void setNetInvestment_total(float _netInvestment_total){
      this._netInvestment_total = _netInvestment_total;
   }
}
