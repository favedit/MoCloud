package org.mo.content.face.solution;

import org.mo.cloud.logic.person.FGcUserInfo;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>用户容器</P>
//
//@class FProvincePage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================
public class FPrivatePage
      extends FObjectId
{
   protected String _userLabel;

   protected FGcUserInfo _user;

   public String userLabel(){
      return _userLabel;
   }

   public void setUserLabel(String label){
      _userLabel = label;
   }

   public FGcUserInfo user(){
      return _user;
   }

   public void setUser(FGcUserInfo user){
      _user = user;
   }
}
