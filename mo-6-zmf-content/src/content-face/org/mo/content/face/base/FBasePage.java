package org.mo.content.face.base;

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
   // 路径
   protected String _url;

   protected String _json;

   // 消息
   protected String _message;

   public String message(){
      return _message;
   }

   public void setMessage(String _message){
      this._message = _message;
   }

   public String url(){
      return _url;
   }

   public void setUrl(String _url){
      this._url = _url;
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
         // System.out.println(_json);
      }catch(JSONException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
         this._json = "{}";
      }
   }
}
