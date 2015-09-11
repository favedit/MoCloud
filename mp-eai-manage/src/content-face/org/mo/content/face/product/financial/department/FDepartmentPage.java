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

   protected FDataFinancialDepartmentUnit unit;

   protected String dataInfo;

   public String dataInfo(){
      return dataInfo;
   }

   public void setDataInfo(String dataInfo){
      this.dataInfo = dataInfo;
   }

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
