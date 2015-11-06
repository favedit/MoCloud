package org.mo.content.core.financial.customer.tender;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FDataCustomerTenderInfo
      extends FDataFinancialCustomerTenderUnit
{

   // 投资总额
   private double _investmentTotal;

   // 赎回总额
   private double _redemptionTotal;

   // 净投总额
   private double _netinvestmentTotal;

   // 利息额
   private double _interestTotal;

   public double investmentTotal(){
      return _investmentTotal;
   }

   public void setInvestmentTotal(double _investmentTotal){
      this._investmentTotal = _investmentTotal;
   }

   public double redemptionTotal(){
      return _redemptionTotal;
   }

   public void setRedemptionTotal(double _redemptionTotal){
      this._redemptionTotal = _redemptionTotal;
   }

   public double netinvestmentTotal(){
      return _netinvestmentTotal;
   }

   public void setNetinvestmentTotal(double _netinvestmentTotal){
      this._netinvestmentTotal = _netinvestmentTotal;
   }

   public double interestTotal(){
      return _interestTotal;
   }

   public void setInterestTotal(double _interestTotal){
      this._interestTotal = _interestTotal;
   }

}
