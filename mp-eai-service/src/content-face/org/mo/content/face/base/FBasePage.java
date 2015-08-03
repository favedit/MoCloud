package org.mo.content.face.base;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
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
      extends FObjectId
{
   //ajax
   protected String _json;

   //用户
   protected FDataPersonUserUnit user;

   //详情
   protected String _description;

   //用户权限
   protected String _menuString;

   //版本号
   protected String _version;

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

   public String description(){
      return _description;
   }

   public void setDescription(String _description){
      this._description = _description;
   }

   public FDataPersonUserUnit user(){
      return user;
   }

   public void setUser(FDataPersonUserUnit user){
      this.user = user;
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
}
