package org.mo.eai.history;

import org.mo.com.io.IDataOutput;

//============================================================
// <T>历史里程碑数据。</T>
//============================================================
public class FHistoryMilestoneData
{
   // 代码
   protected String _code;

   // 总投资额
   protected float _investmentTotal;

   // 开始天数
   protected int _dayCount;

   // 花费天数
   protected int _dayCost;

   // 分公司数量
   protected int _companyCount;

   // 理财师数量
   protected int _staffCount;

   //============================================================
   // <T>构造历史里程碑数据。</T>
   //============================================================
   public FHistoryMilestoneData(String code,
                                float investmentTotal,
                                int dayCount,
                                int dayCost,
                                int companyCount,
                                int staffCount){
      _code = code;
      _investmentTotal = investmentTotal;
      _dayCount = dayCount;
      _dayCost = dayCost;
      _companyCount = companyCount;
      _staffCount = staffCount;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 投资额
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>获得投资额。</T>
   //
   // @return 投资额
   //============================================================
   public float investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置投资额。</T>
   //
   // @param investmentTotal 投资额
   //============================================================
   public void setInvestmentTotal(float investmentTotal){
      _investmentTotal = investmentTotal;
   }

   //============================================================
   // <T>获得日数。</T>
   //
   // @return 日数
   //============================================================
   public float dayCount(){
      return _dayCount;
   }

   //============================================================
   // <T>设置日数。</T>
   //
   // @param dayCount 日数
   //============================================================
   public void setDayCount(int dayCount){
      _dayCount = dayCount;
   }

   //============================================================
   // <T>获得分公司数量。</T>
   //
   // @return 分公司数量
   //============================================================
   public int companyCount(){
      return _companyCount;
   }

   //============================================================
   // <T>设置分公司数量。</T>
   //
   // @param companyCount 分公司数量
   //============================================================
   public void setCompanyCount(int companyCount){
      _companyCount = companyCount;
   }

   //============================================================
   // <T>获得雇员数量。</T>
   //
   // @return 雇员数量
   //============================================================
   public int staffCount(){
      return _companyCount;
   }

   //============================================================
   // <T>设置雇员数量。</T>
   //
   // @param staffCount 雇员数量
   //============================================================
   public void setStaffCount(int staffCount){
      _companyCount = staffCount;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 写入属性
      output.writeString(_code);
      output.writeFloat(_investmentTotal);
      output.writeUint16(_dayCount);
      output.writeUint16(_companyCount);
      output.writeUint16(_staffCount);
   }
}
