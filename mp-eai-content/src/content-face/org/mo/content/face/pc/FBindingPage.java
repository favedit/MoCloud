package org.mo.content.face.pc;

import org.mo.com.lang.FObjectId;

//============================================================
// <P>页面容器</P>
//============================================================
public class FBindingPage
      extends FObjectId
{

   // 账号
   protected String _passport;

   // 消息
   protected String _message;

   //用户类型
   protected String _userType;

   public String userType(){
      return _userType;
   }

   public void setUserType(String _userType){
      this._userType = _userType;
   }

   public String message(){
      return _message;
   }

   public void setMessage(String _message){
      this._message = _message;
   }

   public String passport(){
      return _passport;
   }

   public void setPassport(String _passport){
      this._passport = _passport;
   }

}
