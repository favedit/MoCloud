package org.mo.content.face.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P客户信息容器</P>
//@class FCustomerPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FSalesToolsPage
      extends FObjectId
{
   // 当前页
   protected String userLabel;

   //页面信息结果
   protected String result;

   //金融客户实体类
   protected FDataLogicSalestoolsUnit unit;

   public FDataLogicSalestoolsUnit unit(){
      return unit;
   }

   public void setUnit(FDataLogicSalestoolsUnit unit){
      this.unit = unit;
   }

   public String result(){
      return result;
   }

   public void setResult(String result){
      this.result = result;
   }

   public String userLabel(){
      return userLabel;
   }

   public void setUserLabel(String userLabel){
      this.userLabel = userLabel;
   }

}
