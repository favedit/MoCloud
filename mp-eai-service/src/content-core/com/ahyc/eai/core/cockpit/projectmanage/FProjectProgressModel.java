package com.ahyc.eai.core.cockpit.projectmanage;


//============================================================
// <T>投资模式。</T>
//============================================================
public class FProjectProgressModel
{
   private String _key;

   private String _start_v;

   private String _end_v;

   private String _cur_v;

   private String _type;

   private String _is_show;

   private String _progress;

   private String _value;

   public String key(){
      return _key;
   }

   public void setKey(String _key){
      this._key = _key;
   }

   public String start_v(){
      return _start_v;
   }

   public void setStart_v(String _start_v){
      this._start_v = _start_v;
   }

   public String end_v(){
      return _end_v;
   }

   public void setEnd_v(String _end_v){
      this._end_v = _end_v;
   }

   public String cur_v(){
      return _cur_v;
   }

   public void setCur_v(String _cur_v){
      this._cur_v = _cur_v;
   }

   public String type(){
      return _type;
   }

   public void setType(String _type){
      this._type = _type;
   }

   public String is_show(){
      return _is_show;
   }

   public void setIs_show(String _is_show){
      this._is_show = _is_show;
   }

   public String progress(){
      return _progress;
   }

   public void setProgress(String _progress){
      this._progress = _progress;
   }

   public String value(){
      return _value;
   }

   public void setValue(String _value){
      this._value = _value;
   }

}
