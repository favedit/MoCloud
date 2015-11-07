package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FDataCustomerInfo
      extends FDataFinancialProductUnit
{
   // 当前理财师下所有产品的投资额
   private double _investmentAll;

   // 投资总额
   private double _investmentTotal;

   public double investmentTotal(){
      return _investmentTotal;
   }

   public void setInvestmentTotal(double _investmentTotal){
      this._investmentTotal = _investmentTotal;
   }

   public double get_investmentAll(){
      return _investmentAll;
   }

   public void set_investmentAll(double _investmentAll){
      this._investmentAll = _investmentAll;
   }

}
