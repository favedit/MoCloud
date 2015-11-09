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

   //未知
   protected int _contactUnknown;

   //上线提醒
   protected int _contactOnline;

   //关注提醒
   protected int _contactFollow;

   //购买提醒
   protected int _contactPurchase;

   //充值提醒
   protected int _contactRecharge;

   // 性别
   protected String gender;

   //客户关注度
   protected int pv;

   public int getPv(){
      return pv;
   }

   public void setPv(int pv){
      this.pv = pv;
   }

   public String getGender(){
      return gender;
   }

   public void setGender(String gender){
      this.gender = gender;
   }

   public int contactUnknown(){
      return _contactUnknown;
   }

   public void setContactUnknown(int _contactUnknown){
      this._contactUnknown = _contactUnknown;
   }

   public int contactOnline(){
      return _contactOnline;
   }

   public void setContactOnline(int _contactOnline){
      this._contactOnline = _contactOnline;
   }

   public int contactFollow(){
      return _contactFollow;
   }

   public void setContactFollow(int _contactFollow){
      this._contactFollow = _contactFollow;
   }

   public int contactPurchase(){
      return _contactPurchase;
   }

   public void setContactPurchase(int _contactPurchase){
      this._contactPurchase = _contactPurchase;
   }

   public int contactRecharge(){
      return _contactRecharge;
   }

   public void setContactRecharge(int _contactRecharge){
      this._contactRecharge = _contactRecharge;
   }

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
