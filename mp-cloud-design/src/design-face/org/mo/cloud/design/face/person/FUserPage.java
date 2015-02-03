package org.mo.cloud.design.face.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.lang.FObjectId;
//============================================================
//<P>用户容器</P>
//
//@class FUserPage
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public class FUserPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected FDataPersonUserUnit userUnit;

   public FDataPersonUserUnit getUserUnit(){
      return userUnit;
   }

   public void setUserUnit(FDataPersonUserUnit userUnit){
      this.userUnit = userUnit;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }
}
