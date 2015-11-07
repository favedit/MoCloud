package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.type.TDateTime;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FDataCustomerInfo
      extends FDataFinancialCustomerUnit
{
   // 客户名称
   private String _customerLabel;

   // 最后登录时间
   private TDateTime _lastLoginDate;

   public String customerLabel(){
      return _customerLabel;
   }

   public void setCustomerLabel(String _customerLabel){
      this._customerLabel = _customerLabel;
   }

   public TDateTime lastLoginDate(){
      return _lastLoginDate;
   }

   public void setLastLoginDate(TDateTime _lastLoginDate){
      this._lastLoginDate = _lastLoginDate;
   }

}
