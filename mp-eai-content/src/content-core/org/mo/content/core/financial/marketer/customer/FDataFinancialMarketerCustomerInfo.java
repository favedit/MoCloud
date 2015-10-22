package org.mo.content.core.financial.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import java.util.Map;
import org.mo.com.lang.type.TDateTime;

public class FDataFinancialMarketerCustomerInfo
      extends FDataFinancialMarketerCustomerUnit
      implements
         Comparable<FDataFinancialMarketerCustomerInfo>
{
   // 成员唯一码
   protected String _memberGuid;

   // 成员名称
   protected String _memberLabel;

   // 成员手机号
   protected String _memberPhone;

   // 成员最后登录时间
   protected TDateTime _memberLastLoginDate;

   // 成员评分
   protected int _memberRecommendScore;

   // 剩余天数
   protected int _remainingDays;

   public int remainingDays(){
      return _remainingDays;
   }

   public void setRemainingDays(int _remainingDays){
      this._remainingDays = _remainingDays;
   }

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

   public int memberRecommendScore(){
      return _memberRecommendScore;
   }

   public void setMemberRecommendScore(int _memberRecommendScore){
      this._memberRecommendScore = _memberRecommendScore;
   }

   public String memberGuid(){
      return _memberGuid;
   }

   public void setMemberGuid(String _memberGuid){
      this._memberGuid = _memberGuid;
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

   @Override
   public int compareTo(FDataFinancialMarketerCustomerInfo o){

      if(o != null){
         if(this._memberRecommendScore > o._memberRecommendScore){
            return 1;
         }else if(this._memberRecommendScore == o._memberRecommendScore){
            return 0;
         }else{
            return -1;
         }

      }
      return 0;
   }
}
