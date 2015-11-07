package org.mo.content.face.pc.marketer.product.customer;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.content.core.financial.customer.tender.FDataFinancialCustomerTenderInfo;
import org.mo.content.core.financial.product.FDataFinancialProductInfo;
import org.mo.data.logic.FLogicDataset;

//============================================================
// <P>页面容器</P>
//============================================================
public class FCustomerTenderPage
      extends FObjectId
{
   // 当前页
   protected int                                             _pageCurrent;

   // 总页数
   protected int                                             _pageTotal;

   // 客户总数
   protected int                                             _numTotal;

   // 客户集合
   protected FLogicDataset<FDataFinancialCustomerTenderInfo> _customerTenderList;

   // 客户信息
   protected FDataFinancialCustomerInfo                      _customerInfo;

   //名称
   protected String                                          _label;

   // 消息
   protected String                                          _message;

   // 产品集合
   protected FLogicDataset<FDataFinancialProductInfo>        _productList;

   // 产品编号
   protected long                                            _productId;

   // 投资总额
   protected float                                           _investment_total;

   // 净投总额
   protected float                                           _netInvestment_total;

   // 投资人数
   protected int                                             _customer_total;

   public float netInvestment_total(){
      return _netInvestment_total;
   }

   public void setNetInvestment_total(float _netInvestment_total){
      this._netInvestment_total = _netInvestment_total;
   }

   public int customer_total(){
      return _customer_total;
   }

   public void setCustomer_total(int _customer_total){
      this._customer_total = _customer_total;
   }

   public float investment_total(){
      return _investment_total;
   }

   public void setInvestment_total(float _investment_total){
      this._investment_total = _investment_total;
   }

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

   public FLogicDataset<FDataFinancialCustomerTenderInfo> customerTenderList(){
      return _customerTenderList;
   }

   public void setCustomerTenderList(FLogicDataset<FDataFinancialCustomerTenderInfo> _customerTenderList){
      this._customerTenderList = _customerTenderList;
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

   public long productId(){
      return _productId;
   }

   public void setProductId(long _productId){
      this._productId = _productId;
   }

}
