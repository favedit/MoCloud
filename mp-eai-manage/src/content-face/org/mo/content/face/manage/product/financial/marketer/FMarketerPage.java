package org.mo.content.face.manage.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>理财师信息容器</P>
//@class FMarketerPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FMarketerPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面信息处理结果
   protected String result;

   //客户投资日期字符串
   protected String customerInvestmentDate;

   //客户赎回日期字符串
   protected String customerRedemptionDate;

   //金融市场实体类
   protected FDataFinancialMarketerUnit unit;

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

   public FDataFinancialMarketerUnit unit(){
      return unit;
   }

   public void setUnit(FDataFinancialMarketerUnit unit){
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
