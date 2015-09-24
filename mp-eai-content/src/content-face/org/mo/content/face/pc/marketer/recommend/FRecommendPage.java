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

   // 总页数
   protected int _pageTotal;

   // 会员集合
   protected FLogicDataset<FDataFinancialMemberInfo> _memberList;

   //名称
   protected String _label;

   // 消息
   protected String _message;

   public String message(){
      return _message;
   }

   public void setMessage(String _message){
      this._message = _message;
   }

   public int pageTotal(){
      return _pageTotal;
   }

   public void setPageTotal(int _pageTotal){
      this._pageTotal = _pageTotal;
   }

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
