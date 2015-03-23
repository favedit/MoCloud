package org.mo.content.mime.phy;

import org.mo.com.io.FByteFile;
import org.mo.com.io.FFileLineReader;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.RByte;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;

//============================================================
// <T>PLY文件。</T>
//============================================================
public class FPlyFile
      extends FPlyMesh
{
   // 文件编码
   protected String _encoding = "UTF-8";

   // 文件是否有效
   protected boolean _valid;

   // 文件格式
   protected String _formatCd;

   // 文件版本
   protected String _version;

   // 解析属性
   protected FObjects<SPlyProperty> _parseProperties;

   // 顶点个数
   protected int _vertexCount;

   // 面个数
   protected int _faceCount;

   // 注释集合
   protected FStrings _comments = new FStrings();

   //============================================================
   // <T>构造PLY文件。</T>
   //============================================================
   public FPlyFile(){
   }

   //============================================================
   // <T>构造PLY文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FPlyFile(String fileName){
      loadFile(fileName, _encoding);
   }

   //============================================================
   // <T>解析头信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseHeader(String line){
      // 检查格式
      if(line.equals("ply")){
         _valid = true;
         return;
      }
      String[] items = RString.split(line, ' ');
      String code = items[0];
      // 检查版本
      if(code.equals("format")){
         // format ascii 1.0
         // format binary_little_endian 1.0
         // format binary_big_endian 1.0
         _formatCd = items[1];
         _version = items[2];
         return;
      }
      // 检查元素
      if(code.equals("element")){
         String type = items[1];
         if(type.equals("vertex")){
            _vertexCount = RInteger.parse(items[2]);
            _vertexs.setSize(_vertexCount);
            _parseProperties = _vertexProperties;
         }else if(type.equals("face")){
            _faceCount = RInteger.parse(items[2]);
            _faces.setSize(_faceCount);
            _parseProperties = _faceProperties;
         }else{
            throw new FFatalError("Unknown element type. (type={1})", type);
         }
         return;
      }
      // 检查属性
      if(code.equals("property")){
         // Type: char uchar short ushort int uint float double
         // Type: int8 uint8 int16 uint16 int32 uint32 float32 float64
         SPlyProperty property = new SPlyProperty();
         property.typeCd = items[1];
         property.code = items[2];
         property.index = _parseProperties.count();
         _parseProperties.push(property);
         return;
      }
      // 检查注释
      if(code.equals("comment")){
         _comments.push(line);
         return;
      }
   }

   //============================================================
   // <T>解析顶点信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseVertex(String line){
      String[] items = RString.split(line, ' ');
      int count = items.length;
      SPlyVertex vertex = new SPlyVertex();
      float[] data = new float[count];
      for(int n = 0; n < count; n++){
         data[n] = RFloat.parse(items[n]);
      }
      vertex.data = data;
      _vertexs.push(vertex);
   }

   //============================================================
   // <T>解析面信息。</T>
   //
   // @param line 行字符串
   //============================================================
   public void parseFace(String line){
      String[] items = RString.split(line, ' ');
      // 检查个数
      int splitCount = items.length;
      int count = RInteger.parse(items[0]);
      if(count + 1 != splitCount){
         throw new FFatalError("Parse face count invalid. (count={1}, parse_count={2})", splitCount, count);
      }
      // 解析内容
      SPlyFace face = new SPlyFace();
      int[] data = new int[count];
      for(int n = 0; n < count; n++){
         data[n] = RInteger.parse(items[n + 1]);
      }
      face.data = data;
      _faces.push(face);
   }

   //============================================================
   // <T>加载文件。</T>
   //
   // @param fileName 文件名称
   // @param encoding 文本编码
   //============================================================
   @SuppressWarnings("resource")
   public void loadFile(String fileName,
                        String encoding){
      try(FFileLineReader reader = new FFileLineReader(fileName, encoding)){
         // 读取头信息
         for(String line : reader){
            if(line.equals("end_header")){
               break;
            }else{
               parseHeader(line);
            }
         }
         // 字符串读取方式
         if(_formatCd.equals("ascii")){
            // 读取顶点信息
            for(int n = 0; n < _vertexCount; n++){
               String line = reader.readLine();
               parseVertex(line);
            }
            // 读取面信息
            for(int n = 0; n < _faceCount; n++){
               String line = reader.readLine();
               parseFace(line);
            }
         }
         // 二进制小头读取方式
         else if(_formatCd.equals("binary_little_endian")){
            FByteFile stream = new FByteFile(fileName);
            //stream.setEndianCd(EByteEndian.Little);
            byte[] find = "end_header".getBytes();
            int index = RByte.search(stream.memory(), find);
            if(index == -1){
               throw new FFatalError("Can't find end header.");
            }
            stream.skip(index + find.length + 1);
            // 读取顶点信息
            for(int n = 0; n < _vertexCount; n++){
               SPlyVertex vertex = new SPlyVertex();
               for(SPlyProperty property : _vertexProperties){
                  if(property.typeCd.equals("float")){
                     if(property.code.equals("x")){
                        vertex.x = stream.readFloat();
                     }else if(property.code.equals("y")){
                        vertex.y = stream.readFloat();
                     }else if(property.code.equals("z")){
                        vertex.z = stream.readFloat();
                     }else{
                        throw new FFatalError("Unknown code.");
                     }
                  }else if(property.typeCd.equals("uchar")){
                     if(property.code.equals("red")){
                        vertex.r = stream.readUint8();
                     }else if(property.code.equals("green")){
                        vertex.g = stream.readUint8();
                     }else if(property.code.equals("blue")){
                        vertex.b = stream.readUint8();
                     }else{
                        throw new FFatalError("Unknown code.");
                     }
                  }else{
                     throw new FFatalError("Unknown type.");
                  }
               }
               _vertexs.push(vertex);
            }
            // 读取面信息
            for(int n = 0; n < _faceCount; n++){
               SPlyFace face = new SPlyFace();
               int count = stream.readUint8();
               if(count != 3){
                  throw new FFatalError("Unknown index count.");
               }
               int[] data = new int[count];
               for(int i = 0; i < count; i++){
                  data[i] = (int)stream.readUint32();
               }
               face.data = data;
               _faces.push(face);
            }
            stream.close();
         }else{
            throw new FFatalError("Unknown format.");
         }
      }
   }

   public static void main(String[] args){
      FPlyFile stream = new FPlyFile();
      //stream.loadFile("E:/Microbject/Reference/i-sight/data/sphere.ply", "utf-8");
      stream.loadFile("E:/Microbject/Temp/person.ply", "utf-8");
      System.out.println(stream.toString());
   }
}
