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
