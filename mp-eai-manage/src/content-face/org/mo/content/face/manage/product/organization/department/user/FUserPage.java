package org.mo.content.face.manage.product.organization.department.user;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.organization.department.user.FDataUserInfo;

//============================================================
//<P>部门用户容器</P>
//@class FUserPage
//@version 1.0.0
//============================================================
public class FUserPage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //部门用户类
   protected FDataUserInfo unit;

   public FDataUserInfo unit(){
      return unit;
   }

   public void setUnit(FDataUserInfo unit){
      this.unit = unit;
   }

   public String result(){
      return result;
   }

   public void setResult(String result){
      this.result = result;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
