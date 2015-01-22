package org.mo.content.face.base;

import net.sf.json.JSONException;

public class BaseAction
{
   private String msg, url, json;

   public String getMsg(){
      return msg;
   }

   public void setMsg(String msg){
      this.msg = msg;
   }

   public String getUrl(){
      return url;
   }

   public void setUrl(String url){
      this.url = url;
   }

   public String getJson(){
      return json;
   }

   public void setJson(String json){
      this.json = json;
   }

   protected String msg(String msg,
                        String url){
      this.msg = msg;
      this.url = url;
      return "msg";
   }

   protected String ajax(String json){
      this.json = json;
      return "ajax";
   }

   protected String toJson(Object obj){
      try{
         //         this.json = JSONUtil.serialize(obj);
      }catch(JSONException e){
         // TODO Auto-generated catch block
         e.printStackTrace();
         this.json = "{}";
      }
      return "ajax";
   }
}
