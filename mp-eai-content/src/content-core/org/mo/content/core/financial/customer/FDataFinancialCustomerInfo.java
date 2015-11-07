package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.type.TDateTime;

public class FDataFinancialCustomerInfo
      extends FDataFinancialCustomerUnit
{

   // 客户名称
   protected String _label;

   // 手机号字段
   protected String _phone;

   // 最后登录时间
   protected TDateTime _lastLogin;

   // 年龄
   protected int _age;

   // 性别
   protected String gender;

   // 短信设置状态
   protected int _statusSMS;

   //客户关注度
   protected int pv;

   public int getPv(){
      return pv;
   }

   public void setPv(int pv){
      this.pv = pv;
   }

   public int statusSMS(){
      return _statusSMS;
   }

   public void setStatusSMS(int _statusSMS){
      this._statusSMS = _statusSMS;
   }

   public String label(){
      return _label;
   }

   public void setLabel(String _label){
      this._label = _label;
   }

   public String phone(){
      return _phone;
   }

   public void setPhone(String _phone){
      this._phone = _phone;
   }

   public TDateTime lastLogin(){
      return _lastLogin;
   }

   public void setLastLogin(TDateTime _lastLogin){
      this._lastLogin = _lastLogin;
   }

   public int age(){
      return _age;
   }

   public void setAge(int _age){
      this._age = _age;
   }

   public String getGender(){
      return gender;
   }

   public void setGender(String gender){
      this.gender = gender;
   }

}
