package org.mo.content.face.manage.product.system.version;

import org.mo.com.lang.FObjectId;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
//============================================================
//<P>版本容器</P>
//@class FVersionPage
//@version 1.0.0
//============================================================
public class FVersionPage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   //页面信息处理结果
   protected String result;
   
   //版本数据单元
   protected FDataSystemVersionUnit unit;

   public FDataSystemVersionUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataSystemVersionUnit unit) {
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
