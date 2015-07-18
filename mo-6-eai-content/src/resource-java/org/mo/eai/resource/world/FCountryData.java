package org.mo.eai.resource.world;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>国家数据。</T>
//============================================================
public class FCountryData
      extends FObject
{
   // 代码
   protected String _code;

   // 标签
   protected String _label;

   // 边界集合
   protected FObjects<FBoundaryData> _boundaries = new FObjects<FBoundaryData>(FBoundaryData.class);

   // 省份集合
   protected FObjects<FProvinceData> _provinces = new FObjects<FProvinceData>(FProvinceData.class);

   //============================================================
   // <T>构造国家数据。</T>
   //============================================================
   public FCountryData(){
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
   // <T>获得标签。</T>
   //
   // @return 标签
   //============================================================
   public String _label(){
      return _label;
   }

   //============================================================
   // <T>设置标签。</T>
   //
   // @param label 标签
   //============================================================
   public void setLabel(String label){
      _label = label;
   }

   //============================================================
   // <T>获得边界个数。</T>
   //
   // @return 边界个数
   //============================================================
   public int boundaryCount(){
      return _boundaries.count();
   }

   //============================================================
   // <T>获得边界个数。</T>
   //
   // @return 边界个数
   //============================================================
   public int boundaryPointCount(){
      int total = 0;
      for(FBoundaryData boundary : _boundaries){
         total += boundary.points().count();
      }
      return total;
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
      _boundaries.push(boundary);
   }

   //============================================================
   // <T>获得省份集合。</T>
   //
   // @return 省份集合
   //============================================================
   public FObjects<FProvinceData> provinces(){
      return _provinces;
   }

   //============================================================
   // <T>增加一个省份。</T>
   //
   // @param province 省份
   //============================================================
   public void pushProvince(FProvinceData province){
      _provinces.push(province);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出属性
      output.writeString(_code);
      output.writeString(_label);
      // 输出边界集合
      output.writeInt32(_boundaries.count());
      for(FBoundaryData boundary : _boundaries){
         boundary.serialize(output);
      }
      // 输出省份集合
      output.writeInt32(_provinces.count());
      for(FProvinceData province : _provinces){
         province.serialize(output);
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
      for(FProvinceData province : _provinces){
         province.dump(info);
         info.appendLine();
      }
      return info;
   }
}
