package com.ahyc.eai.core.financial;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>投资模式。</T>
//============================================================
public class FFinancialTenderModel
      extends FObject
{
   // 代码
   private String _code;

   // 标签
   private String _label;

   // 比率
   private float _rate;

   // 比率标签
   private String _rateLabel;

   // 日比率
   private double _rateDay;

   // 期限数量
   private int _horizonCount;

   // 期限单位
   private int _horizonUnit;

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>获得标签。</T>
   //
   // @return 标签
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>获得比率。</T>
   //
   // @return 比率
   //============================================================
   public float rate(){
      return _rate;
   }

   //============================================================
   // <T>获得比率标签。</T>
   //
   // @return 比率标签
   //============================================================
   public String rateLabel(){
      return _rateLabel;
   }

   //============================================================
   // <T>获得日比率。</T>
   //
   // @return 日比率
   //============================================================
   public double rateDay(){
      return _rateDay;
   }

   //============================================================
   // <T>获得期限数量。</T>
   //
   // @return 期限数量
   //============================================================
   public int horizonCount(){
      return _horizonCount;
   }

   //============================================================
   // <T>获得期限单位。</T>
   //
   // @return 期限单位
   //============================================================
   public int horizonUnit(){
      return _horizonUnit;
   }

   //============================================================
   // <T>计算盈利。</T>
   //
   // @param currency 货币
   // @param currentDate 时间
   // @return 盈利
   //============================================================
   public double calculateGain(double currency,
                               TDateTime currentDate){
      double gain = 0;
      // 计算盈利
      if(_horizonUnit == EFinancialHerizonUnit.Day){
         gain = currency * _rateDay * _horizonCount;
      }else if(_horizonUnit == EFinancialHerizonUnit.Month){
         TDateTime endDate = currentDate.clone();
         endDate.addMonth(_horizonCount);
         int day = (int)((double)(endDate.get() - currentDate.get()) / 1000 / 3600 / 24);
         gain = currency * _rateDay * day;
      }
      // 限制最小
      if(gain < 0.01){
         gain = 0.01;
      }
      return gain;
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _code = xconfig.get("code");
      _label = xconfig.get("label");
      _rate = xconfig.getFloat("rate");
      _rateDay = _rate / 100 / 365;
      _rateLabel = RString.leftPad(RFloat.format(_rate, 1), 4, ' ');
      _horizonCount = xconfig.getInt("horizon_count");
      String horizonUnit = xconfig.get("horizon_unit");
      if(horizonUnit.equals("day")){
         _horizonUnit = EFinancialHerizonUnit.Day;
      }else if(horizonUnit.equals("month")){
         _horizonUnit = EFinancialHerizonUnit.Month;
      }else{
         throw new FFatalError("Invalid unit.");
      }
   }
}
