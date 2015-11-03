package org.mo.content.face.mb.marketer.achievements;

import org.mo.com.lang.FObjectId;

//============================================================
// <P>页面容器</P>
//============================================================
public class FAchievementsPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
