package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FNoticeModel
      extends FDataLogicNoticeUnit
{

   // 用户标签
   private String _userLabel;

   //============================================================
   // <T>获得用户标签。</T>
   //
   // @return 标签
   //============================================================
   public String userLabel(){
      return _userLabel;
   }

   //============================================================
   // <T>设置用户标签。</T>
   //============================================================
   public void setUserLabel(String _userLabel){
      this._userLabel = _userLabel;
   }

}
