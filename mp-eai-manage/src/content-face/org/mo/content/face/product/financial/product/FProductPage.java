package org.mo.content.face.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>用户容器</P>
//
//@class FProvincePage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FProductPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected String customerInvestmentDate;

   protected String customerRedemptionDate;

   protected FDataFinancialCustomerUnit unit;

   protected String dataInfo;

   public String customerInvestmentDate(){
      return customerInvestmentDate;
   }

   public void setCustomerInvestmentDate(String customerInvestmentDate){
      this.customerInvestmentDate = customerInvestmentDate;
   }

   public String customerRedemptionDate(){
      return customerRedemptionDate;
   }

   public void setCustomerRedemptionDate(String customerRedemptionDate){
      this.customerRedemptionDate = customerRedemptionDate;
   }

   public String dataInfo(){
      return dataInfo;
   }

   public void setDataInfo(String dataInfo){
      this.dataInfo = dataInfo;
   }

   public FDataFinancialCustomerUnit unit(){
      return unit;
   }

   public void setUnit(FDataFinancialCustomerUnit unit){
      this.unit = unit;
   }

   public String result(){
      return result;
   }

   public void setResult(String result){
      this.result = result;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
