package org.mo.content.face.pc.marketer.recommend;

import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.com.lang.FObjectId;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <P>页面容器</P>
//============================================================
public class FRecommendPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   // 客户集合
   protected FLogicDataset<FDataFinancialMemberUnit> _memberList;

   public FLogicDataset<FDataFinancialMemberUnit> memberList(){
      return _memberList;
   }

   public void setMemberList(FLogicDataset<FDataFinancialMemberUnit> memberList){
      this._memberList = memberList;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
