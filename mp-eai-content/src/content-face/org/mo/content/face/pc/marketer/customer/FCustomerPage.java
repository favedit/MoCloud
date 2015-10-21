package org.mo.content.face.pc.marketer.customer;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <P>页面容器</P>
//============================================================
public class FCustomerPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   // 总页数
   protected int _pageTotal;

   // 成员集合
   protected FLogicDataset<FDataFinancialCustomerInfo> _customerList;

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

   public FLogicDataset<FDataFinancialCustomerInfo> customerList(){
      return _customerList;
   }

   public void setCustomerList(FLogicDataset<FDataFinancialCustomerInfo> _customerList){
      this._customerList = _customerList;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
