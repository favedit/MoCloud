package org.mo.content.face.manage.system.user.role;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.com.lang.FObjectId;
//============================================================
//<P>后台角色容器</P>
//
//@class FRolePage
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public class FRolePage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected FDataControlRoleUnit role;

   public FDataControlRoleUnit role(){
      return role;
   }

   public void setRole(FDataControlRoleUnit role){
      this.role = role;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }
}
