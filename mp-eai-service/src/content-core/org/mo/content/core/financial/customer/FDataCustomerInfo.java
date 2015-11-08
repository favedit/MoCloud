package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.type.TDateTime;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FDataCustomerInfo
      extends FDataFinancialCustomerUnit
{
   // 客户图像
   private String _iconUrl;

   // 客户名称
   private String _label;

   // 最后登录时间
   private TDateTime _lastLoginDate;

   public String iconUrl(){
      return _iconUrl;
   }

   public void setIconUrl(String _iconUrl){
      this._iconUrl = _iconUrl;
   }

   public String label(){
      return _label;
   }

   public void setLabel(String _label){
      this._label = _label;
   }

   public TDateTime lastLoginDate(){
      return _lastLoginDate;
   }

   public void setLastLoginDate(TDateTime _lastLoginDate){
      this._lastLoginDate = _lastLoginDate;
   }

}
