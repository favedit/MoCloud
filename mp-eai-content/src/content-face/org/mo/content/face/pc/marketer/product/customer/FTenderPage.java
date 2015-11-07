package org.mo.content.face.pc.marketer.product.customer;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.content.core.financial.product.FDataFinancialProductInfo;
import org.mo.content.core.financial.tender.FDataFinancialTenderInfo;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <P>页面容器</P>
//============================================================
public class FTenderPage
      extends FObjectId
{
   // 当前页
   protected int                                      _pageCurrent;

   // 总页数
   protected int                                      _pageTotal;

   // 客户总数
   protected int                                      _numTotal;

   // 客户集合
   protected FLogicDataset<FDataFinancialTenderInfo>  _tenderList;

   // 客户信息
   protected FDataFinancialCustomerInfo               _customerInfo;

   //名称
   protected String                                   _label;

   // 消息
   protected String                                   _message;

   // 产品集合
   protected FLogicDataset<FDataFinancialProductInfo> _productList;

   public FDataFinancialCustomerInfo customerInfo(){
      return _customerInfo;
   }

   public void setCustomerInfo(FDataFinancialCustomerInfo _customerInfo){
      this._customerInfo = _customerInfo;
   }

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

   public FLogicDataset<FDataFinancialTenderInfo> tenderList(){
      return _tenderList;
   }

   public void setTenderList(FLogicDataset<FDataFinancialTenderInfo> _tenderList){
      this._tenderList = _tenderList;
   }

   public FLogicDataset<FDataFinancialProductInfo> productList(){
      return _productList;
   }

   public void setProductList(FLogicDataset<FDataFinancialProductInfo> _productList){
      this._productList = _productList;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

   public int numTotal(){
      return _numTotal;
   }

   public void setNumTotal(int _numTotal){
      this._numTotal = _numTotal;
   }

}
