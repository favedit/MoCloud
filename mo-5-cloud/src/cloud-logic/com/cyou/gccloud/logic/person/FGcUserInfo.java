package com.cyou.gccloud.logic.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;

//============================================================
// <T>用户信息。</T>
//============================================================
public class FGcUserInfo
      extends FDataPersonUserUnit
{
   // 会话编号
   protected String _sessionGuid;

   //============================================================
   // <T>获得用户会话唯一编号。</T>
   //
   // @return 会话唯一编号
   //============================================================
   public String sessionGuid(){
      return _sessionGuid;
   }

   //============================================================
   // <T>设置用户会话唯一编号。</T>
   //
   // @param sessionGuid 会话唯一编号
   //============================================================
   public void setSessionGuid(String sessionGuid){
      _sessionGuid = sessionGuid;
   }
}
