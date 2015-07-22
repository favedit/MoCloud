package org.mo.eai.country;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>省份数据。</T>
//============================================================
public class FProvinceData
      extends FObject
{
   // 代码
   protected String _code;

   // 颜色
   protected int _color;

   // 边界集合
   protected FObjects<FBoundaryData> _boundaries = new FObjects<FBoundaryData>(FBoundaryData.class);

   //============================================================
   // <T>构造省份数据。</T>
   //============================================================
   public FProvinceData(){
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
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
   // <T>获得颜色。</T>
   //
   // @return 颜色
   //============================================================
   public int color(){
      return _color;
   }

   //============================================================
   // <T>设置颜色。</T>
   //
   // @param color 颜色
   //============================================================
   public void setColor(int color){
      _color = color;
   }

   //============================================================
   // <T>获得边界集合。</T>
   //
   // @return 边界集合
   //============================================================
   public FObjects<FBoundaryData> boundaries(){
      return _boundaries;
   }

   //============================================================
   // <T>增加一个边界。</T>
   //
   // @param boundary 边界
   //============================================================
   public void pushBoundary(FBoundaryData boundary){
      boundary.setProvince(this);
      _boundaries.push(boundary);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      for(FBoundaryData boundary : _boundaries){
         boundary.calculate();
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeUint16(RInteger.parse(_code));
      int validCount = 0;
      for(FBoundaryData boundary : _boundaries){
         if(boundary.valid){
            validCount++;
         }
      }
      output.writeInt32(validCount);
      for(FBoundaryData boundary : _boundaries){
         if(boundary.valid){
            boundary.serialize(output);
         }
      }
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.append(_code);
      info.appendLine();
      for(FBoundaryData boundary : _boundaries){
         boundary.dump(info);
         info.appendLine();
      }
      return info;
   }
}
