package org.mo.content.face.manage.product.configration.rule;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.configration.rule.FDataRuleInfo;

//============================================================
//<P>规则配置信息容器</P>
//
//@class FConfigrationPage
//@author Zxh
//@Date 2015.10.06 
//@version 1.0.0
//============================================================
public class FRulePage extends FObjectId {

   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //配置信息实体类
   protected FDataRuleInfo unit;

   public FDataRuleInfo unit(){
      return unit;
   }

   public void setUnit(FDataRuleInfo unit){
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
