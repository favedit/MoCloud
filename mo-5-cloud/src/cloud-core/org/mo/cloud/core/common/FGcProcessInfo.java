package org.mo.cloud.core.common;

import org.mo.cloud.logic.data.person.FGcUserInfo;
import org.mo.com.lang.FObject;

//============================================================
// <T>处理信息。</T>
//============================================================
public class FGcProcessInfo
      extends FObject
{
   // 用户信息
   private FGcUserInfo _userInfo;

   //============================================================
   // <T>构造处理信息。</T>
   //============================================================
   public FGcProcessInfo(){
   }

   //============================================================
   // <T>获得用户信息。</T>
   //
   // @return 用户信息
   //============================================================
   public FGcUserInfo userInfo(){
      return _userInfo;
   }

   //============================================================
   // <T>设置用户信息。</T>
   //
   // @param userInfo 用户信息
   //============================================================
   public void setUserInfo(FGcUserInfo userInfo){
      _userInfo = userInfo;
   }
}
