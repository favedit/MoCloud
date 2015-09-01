package org.mo.content.face.mb;

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

   //是否登录
   protected boolean _isLogin;

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

   public boolean isLogin(){
      return _isLogin;
   }

   public void setIsLogin(boolean _isLogin){
      this._isLogin = _isLogin;
   }

}
