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

   // 短信设置状态
   protected int _statusSMS;

   // 城市名称
   protected String _cityLabel;

   // 姓别
   protected String _genderLabel;

   // 邮箱
   protected String _EMAIL;

   //职业
   protected String _business;

   //婚否
   protected String _marray;

   //学历
   protected String _education;

   //收入
   protected String _inCome;

   public String inCome(){
      return _inCome;
   }

   public void setInCome(String _inCome){
      this._inCome = _inCome;
   }

   public String education(){
      return _education;
   }

   public void setEducation(String _education){
      this._education = _education;
   }

   public String marray(){
      return _marray;
   }

   public String business(){
      return _business;
   }

   public void setBusiness(String _business){
      this._business = _business;
   }

   public void setMarray(String _marray){
      this._marray = _marray;
   }

   public String EMAIL(){
      return _EMAIL;
   }

   public void setEMAIL(String _eMAIL){
      _EMAIL = _eMAIL;
   }

   public String cityLabel(){
      return _cityLabel;
   }

   public void setCityLabel(String _cityLabel){
      this._cityLabel = _cityLabel;
   }

   public String genderLabel(){
      return _genderLabel;
   }

   public void setGenderLabel(String _genderLabel){
      this._genderLabel = _genderLabel;
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

}
