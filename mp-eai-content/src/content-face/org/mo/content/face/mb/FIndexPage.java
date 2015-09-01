package org.mo.content.face.mb;

import org.mo.com.lang.FObjectId;

//============================================================
// <P>页面容器</P>
//============================================================
public class FIndexPage
      extends FObjectId
{
   // 主机地址
   protected String _host;

   // 账号
   protected String _passport;

   // 密码
   protected String _password;

   // 消息
   protected String _message;

   // 服务器
   protected String _serviceLogic;

   // 场景代码
   protected String _sceneCode;

   //是否登录
   protected boolean _isLogin;

   public boolean isLogin(){
      return _isLogin;
   }

   public void setIsLogin(boolean _isLogin){
      this._isLogin = _isLogin;
   }

   //============================================================
   // <P>获得主机地址。</P>
   //============================================================
   public String host(){
      return _host;
   }

   //============================================================
   // <P>设置主机地址。</P>
   //============================================================
   public void setHost(String host){
      _host = host;
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
   // <P>获得密码。</P>
   //============================================================
   public String password(){
      return _password;
   }

   //============================================================
   // <P>设置密码。</P>
   //============================================================
   public void setPassword(String password){
      _password = password;
   }

   //============================================================
   // <P>获得消息。</P>
   //============================================================
   public String message(){
      return _message;
   }

   //============================================================
   // <P>设置消息。</P>
   //============================================================
   public void setMessage(String message){
      _message = message;
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
