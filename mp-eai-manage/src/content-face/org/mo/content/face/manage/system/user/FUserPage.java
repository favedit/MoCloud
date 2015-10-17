package org.mo.content.face.manage.system.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
//============================================================
//<P>登录容器</P>
//
//@class FFormPage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================
import org.mo.com.lang.FObjectId;

public class FUserPage
      extends 
         FObjectId
{

   //用户
   protected FDataPersonUserUnit user;

   protected String flag;

   // 当前页
   protected int _pageCurrent;

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

   public String getFlag(){
      return flag;
   }

   public void setFlag(String flag){
      this.flag = flag;
   }

   public FDataPersonUserUnit getUser(){
      return user;
   }

   public void setUser(FDataPersonUserUnit user){
      this.user = user;
   }

}
