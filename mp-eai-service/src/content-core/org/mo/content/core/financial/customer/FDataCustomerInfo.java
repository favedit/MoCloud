package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FDataCustomerInfo
      extends FDataFinancialProductUnit
{

   // 投资总额
   private double _investmentTotal;

   public double investmentTotal(){
      return _investmentTotal;
   }

   public void setInvestmentTotal(double _investmentTotal){
      this._investmentTotal = _investmentTotal;
   }

}
