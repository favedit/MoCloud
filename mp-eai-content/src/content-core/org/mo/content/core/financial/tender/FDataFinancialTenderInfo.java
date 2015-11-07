package org.mo.content.core.financial.tender;

import com.cyou.gccloud.data.data.FDataFinancialTenderUnit;
import java.util.Map;
import org.mo.com.lang.type.TDateTime;

public class FDataFinancialTenderInfo
      extends FDataFinancialTenderUnit
{
   // 成员唯一码
   protected String _memberGuid;

   // 成员名称
   protected String _memberLabel;

   // 成员手机号
   protected String _memberPhone;

   // 成员最后登录时间
   protected TDateTime _memberLastLoginDate;

   // 城市名称
   protected String _cityLabel;

   // 姓别
   protected String _genderLabel;

   // 理财师编号类型
   protected String _marketerId;

   public String memberLabel(){
      return _memberLabel;
   }

   public void setMemberLabel(String _memberLabel){
      this._memberLabel = _memberLabel;
   }

   public String memberPhone(){
      return _memberPhone;
   }

   public void setMemberPhone(String _memberPhone){
      this._memberPhone = _memberPhone;
   }

   public TDateTime memberLastLoginDate(){
      return _memberLastLoginDate;
   }

   public void setMemberLastLoginDate(TDateTime _memberLastLoginDate){
      this._memberLastLoginDate = _memberLastLoginDate;
   }

   public String memberGuid(){
      return _memberGuid;
   }

   public void setMemberGuid(String _memberGuid){
      this._memberGuid = _memberGuid;
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

   public String marketerId(){
      return _marketerId;
   }

   public void setMarketerId(String _marketerId){
      this._marketerId = _marketerId;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
   }
}
