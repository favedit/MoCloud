package org.mo.content.core.mobile.account;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
//============================================================
//<T>登录用户信息</T>
//============================================================

public class FDataPersonUserInfo
      extends FDataPersonUserUnit
{
   //最后打卡时间
   String last_sign_date;

   public String last_sign_date(){
      return last_sign_date;
   }

   public void setLast_sign_date(String last_sign_date){
      this.last_sign_date = last_sign_date;
   }

}
