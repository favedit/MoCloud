package org.mo.content.face.manage.product.user.whitelists;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.com.lang.FObjectId;
import org.mo.data.logic.FLogicDataset;

//============================================================
//<P>用户容器</P>
//@class FAccessPage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================
public class FAccessPage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected FLogicDataset<FDataPersonAccessAuthorityUnit> unitList;

   protected FDataPersonAccessAuthorityUnit unit;

   public FDataPersonAccessAuthorityUnit unit(){
      return unit;
   }

   public void setUnit(FDataPersonAccessAuthorityUnit unit){
      this.unit = unit;
   }

   public FLogicDataset<FDataPersonAccessAuthorityUnit> unitList(){
      return unitList;
   }

   public void setUnitList(FLogicDataset<FDataPersonAccessAuthorityUnit> unitList){
      this.unitList = unitList;
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
