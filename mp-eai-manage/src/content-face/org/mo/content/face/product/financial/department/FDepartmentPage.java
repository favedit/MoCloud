package org.mo.content.face.product.financial.department;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>用户容器</P>
//
//@class FProvincePage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FDepartmentPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected String strInvestment;

   protected String redemptionDate;

   public String strInvestment(){
      return strInvestment;
   }

   public void setStrInvestment(String strInvestment){
      this.strInvestment = strInvestment;
   }

   public String redemptionDate(){
      return redemptionDate;
   }

   public void setRedemptionDate(String redemptionDate){
      this.redemptionDate = redemptionDate;
   }

   protected FDataFinancialDepartmentUnit unit;

   public FDataFinancialDepartmentUnit unit(){
      return unit;
   }

   public void setUnit(FDataFinancialDepartmentUnit unit){
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
