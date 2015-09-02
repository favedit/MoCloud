package org.mo.content.face.pc;

import org.mo.com.lang.FObjectId;

//============================================================
// <P>页面容器</P>
//============================================================
public class FMainPage
      extends FObjectId
{
   // 账号
   protected String _passport;

   // 服务器
   protected String _serviceLogic;

   //
   // 场景代码
   protected String _sceneCode;

   //是否登录
   protected boolean _isLogin;

   //用户类型
   protected String _userType;

   public String userType(){
      return _userType;
   }

   public void setUserType(String _userType){
      this._userType = _userType;
   }

   public boolean isLogin(){
      return _isLogin;
   }

   public void setIsLogin(boolean _isLogin){
      this._isLogin = _isLogin;
   }

   //============================================================
   // <P>获得账号。</P>
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <P>设置账号。</P>
   //============================================================
   public void setPassport(String passport){
      _passport = passport;
   }

   //============================================================
   // <P>获得服务地址。</P>
   //============================================================
   public String serviceLogic(){
      return _serviceLogic;
   }

   //============================================================
   // <P>设置服务地址。</P>
   //============================================================
   public void setServiceLogic(String serviceLogic){
      _serviceLogic = serviceLogic;
   }

   //============================================================
   // <P>获得场景代码。</P>
   //============================================================
   public String sceneCode(){
      return _sceneCode;
   }

   //============================================================
   // <P>设置场景代码。</P>
   //============================================================
   public void setSceneCode(String sceneCode){
      _sceneCode = sceneCode;
   }
}
