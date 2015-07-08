package org.mo.eai.resource.country;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.geom.SIntPoint3;
import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>省份数据。</T>
//============================================================
public class FProvinceData
      extends FObject
{
   // 名称
   protected String _name;

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
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
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
      _boundaries.push(boundary);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeString(_name);
      output.writeUint32(_color);
      output.writeInt32(_boundaries.count());
      for(FBoundaryData boundary : _boundaries){
         boundary.serialize(output);
      }
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
   // <T>加载定义文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      FLinesFile file = new FLinesFile(fileName, "utf-8");
      int count = file.count();
      FBoundaryData boundary = new FBoundaryData();
      for(int n = 0; n < count; n++){
         String line = RString.trim(file.line(n));
         if(RString.startsWith(line, "V:")){
            String value = line.substring(2);
            SDoublePoint3 point = new SDoublePoint3();
            point.parse(value);
            boundary.points().push(point);
         }
         if(RString.startsWith(line, "I:")){
            String value = line.substring(2);
            SIntPoint3 index = new SIntPoint3();
            index.parse(value);
            boundary.indexes().append(index.x);
            boundary.indexes().append(index.y);
            boundary.indexes().append(index.z);
         }
      }
      pushBoundary(boundary);
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.append(_name);
      info.appendLine();
      for(FBoundaryData boundary : _boundaries){
         boundary.dump(info);
         info.appendLine();
      }
      return info;
   }
}
