package org.mo.eng.instantmessag;

//============================================================
// <T>消息参数集合。</T>
//============================================================
public class SImGroupMessage
{
   // 消息范围类型
   protected EImMessageScope msgType = EImMessageScope.Single;

   protected String _passport;

   protected String _message;

   protected String _group;

   protected String _subject;

   //============================================================
   // <T>构造消息参数集合。</T>
   //============================================================
   public SImGroupMessage(String userName,
                          String message){
      this._passport = userName;
      this._message = message;
      this.msgType = EImMessageScope.Single;
   }

   public SImGroupMessage(String groupName,
                          String subject,
                          String message){
      this._group = groupName;
      this._subject = subject;
      this._message = message;
      this.msgType = EImMessageScope.Group;
   }

   public EImMessageScope getMsgType(){
      return msgType;
   }

   public String getUserName(){
      return _passport;
   }

   public String getMessage(){
      return _message;
   }

   public String getGroupName(){
      return _group;
   }

   public String getSubject(){
      return _subject;
   }
}
