package org.mo.content.face.manage.product.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P客户信息容器</P>
//@class FCustomerPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FCustomerPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面信息结果
   protected String result;

   //投资日期字符串
   protected String customerInvestmentDate;

   //赎回日期字符串
   protected String customerRedemptionDate;

   //金融客户实体类
   protected FDataFinancialCustomerUnit unit;

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
