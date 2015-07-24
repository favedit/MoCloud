package org.mo.content.face.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessHostUnit;
import org.mo.com.lang.FObjectId;
import org.mo.data.logic.FLogicDataset;

//============================================================
//<P>用户容器</P>
//
//@class FProvincePage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FAccessPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected FLogicDataset<FDataPersonAccessHostUnit> unitList;

   public FLogicDataset<FDataPersonAccessHostUnit> getUnitList(){
      return unitList;
   }

   public void setUnitList(FLogicDataset<FDataPersonAccessHostUnit> unitList){
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
