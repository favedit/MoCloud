package org.mo.content.face.manage.system.user.module;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import org.mo.com.lang.FObjectId;
//============================================================
//<P>后台模块容器</P>
//
//@class FModulePage
//@author Sunhr
//@Date 2014.12.08
//@version 1.0.0
//============================================================

public class FModulePage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected FDataControlModuleUnit module;

   protected long adminId;

   public long adminId(){
      return adminId;
   }

   public void setAdminId(long adminId){
      this.adminId = adminId;
   }

   public FDataControlModuleUnit module(){
      return module;
   }

   public void setModule(FDataControlModuleUnit module){
      this.module = module;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }
}
