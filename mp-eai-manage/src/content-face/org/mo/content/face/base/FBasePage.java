package org.mo.content.face.base;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.mo.com.lang.FObjectId;
import org.mo.com.lang.RString;

//============================================================
//<P>公共容器</P>
//
//@class FBasePage
//@author Sunhr
//@Date 2014.9.19
//@version 1.0.0
//============================================================
public class FBasePage
      extends 
         FObjectId
{
   //ajax
   protected String _json;

   //临时变量
   protected String _temp;

   //用户权限
   protected String _menuString;

   //版本号
   protected String _version;

   protected String _userId;

   protected String _userName;

   protected String _passport;

   protected long _roleId;

   protected String _message;

   public String message(){
      return _message;
   }

   public void setMessage(String _message){
      this._message = _message;
   }

   public long roleId(){
      return _roleId;
   }

   public void setRoleId(long _roleId){
      this._roleId = _roleId;
   }

   public String passport(){
      return _passport;
   }

   public void setPassport(String _passport){
      this._passport = _passport;
   }

   public String userName(){
      return _userName;
   }

   public void setUserName(String _userName){
      this._userName = _userName;
   }

   public String userId(){
      return _userId;
   }

   public void setUserId(String _userId){
      this._userId = _userId;
   }

   public String version(){
      return _version;
   }

   public void setVersion(String _version){
      this._version = _version;
   }

   public String menuString(){
      return _menuString;
   }

   public void setMenuString(String _menuString){
      this._menuString = _menuString;
   }

   public String temp(){
      return _temp;
   }

   public void setTemp(String _temp){
      this._temp = _temp;
   }

   public String json(){
      return _json;
   }

   public void setJson(String _json){
      this._json = _json;
   }

   public void ajax(int status,
                    String url){
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      sb.append("\"status\":\"").append(status + "\"");
      if(!RString.isEmpty(url))
         sb.append(",\"url\":\"").append(url + "\"");
      sb.append("}");
      String json = sb.toString();
      this._json = json;
   }

   public void toJson(Object obj){
      try{
         JSONObject jo = JSONObject.fromObject(obj);
         this._json = jo.toString();
         //System.out.println(_json);
      }catch(JSONException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
         this._json = "{}";
      }
   }

   public void toArrayJson(Object[] obj){
      try{
         JSONArray jo = JSONArray.fromObject(obj);
         this._json = jo.toString();
         //System.out.println(_json);
      }catch(JSONException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
         this._json = "{}";
      }
   }
   
   public boolean userExists(){
      if(RString.isEmpty(userId())){
         return false;
      }
      return true;
   }
}
