package org.mo.content.face.pc.marketer.recommend;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.financial.member.FDataFinancialMemberInfo;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <P>页面容器</P>
//============================================================
public class FRecommendPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   // 会员集合
   protected FLogicDataset<FDataFinancialMemberInfo> _memberList;

   //名称
   protected String _label;

   public String label(){
      return _label;
   }

   public void setLabel(String _label){
      this._label = _label;
   }

   public FLogicDataset<FDataFinancialMemberInfo> memberList(){
      return _memberList;
   }

   public void setMemberList(FLogicDataset<FDataFinancialMemberInfo> memberList){
      this._memberList = memberList;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
