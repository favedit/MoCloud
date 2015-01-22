package org.mo.eng.instantmessag;

//============================================================
// <T>消息参数集合。</T>
//============================================================
public class SImSingleMessage
{
   // 消息范围类型
   protected EImMessageScope msgType = EImMessageScope.Single;

   // 账号
   protected String _passport;

   // 消息
   protected String _text;

   protected String _group;

   protected String _subject;

   //============================================================
   // <T>构造消息参数集合。</T>
   //============================================================
   public SImSingleMessage(){
   }

   //============================================================
   // <T>获得账号。</T>
   //
   // @return 账号
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置账号。</T>
   //
   // @param passport 账号
   //============================================================
   public void setPassport(String passport){
      _passport = passport;
   }

   //============================================================
   // <T>获得文本。</T>
   //
   // @return 文本
   //============================================================
   public String text(){
      return _text;
   }

   //============================================================
   // <T>设置文本。</T>
   //
   // @param text 文本
   //============================================================
   public void setText(String text){
      _text = text;
   }

   //============================================================
   // <T>构造消息参数集合。</T>
   //============================================================
   public SImSingleMessage(String userName,
                           String message){
      this._passport = userName;
      //this._message = message;
      this.msgType = EImMessageScope.Single;
   }

   public SImSingleMessage(String groupName,
                           String subject,
                           String message){
      this._group = groupName;
      this._subject = subject;
      //this._message = message;
      this.msgType = EImMessageScope.Group;
   }

   public EImMessageScope getMsgType(){
      return msgType;
   }

   public String getUserName(){
      return _passport;
   }

   public String getGroupName(){
      return _group;
   }

   public String getSubject(){
      return _subject;
   }
}
