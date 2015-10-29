package org.mo.content.core.financial.member;

import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import java.util.Map;
import org.mo.com.lang.RString;

public class FDataFinancialMemberInfo
      extends FDataFinancialMemberUnit
{
   // 年领字段
   protected int _age;

   // 城市名称
   protected String _cityLabel;

   // 剩余天数
   protected int _remainingDays;

   // 姓别
   protected String _genderLabel;

   // 婚姻
   protected String _marryLabel;

   // 教育
   protected String _educationLabel;

   // 职业
   protected String _businessLabel;

   // 月收入
   protected String _incomeLabel;

   public String incomeLabel(){
      return _incomeLabel;
   }

   public void setIncomeLabel(String _incomeLabel){
      this._incomeLabel = _incomeLabel;
   }

   public String genderLabel(){
      return _genderLabel;
   }

   public void setGenderLabel(String _genderLabel){
      this._genderLabel = _genderLabel;
   }

   public String marryLabel(){
      return _marryLabel;
   }

   public void setMarryLabel(String _marryLabel){
      this._marryLabel = _marryLabel;
   }

   public String educationLabel(){
      return _educationLabel;
   }

   public void setEducationLabel(String _educationLabel){
      this._educationLabel = _educationLabel;
   }

   public String businessLabel(){
      return _businessLabel;
   }

   public void setBusinessLabel(String _businessLabel){
      this._businessLabel = _businessLabel;
   }

   public int remainingDays(){
      return _remainingDays;
   }

   public void setRemainingDays(int _remainingDays){
      this._remainingDays = _remainingDays;
   }

   public String cityLabel(){
      return _cityLabel;
   }

   public void setCityLabel(String _cityLabel){
      this._cityLabel = _cityLabel;
   }

   public int age(){
      return _age;
   }

   public void setAge(int _age){
      this._age = _age;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("age", RString.parse(_age));
      map.put("cityLabel", _cityLabel);
   }
}
