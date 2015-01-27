package org.mo.engine3d.resource.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;

//============================================================
// <T>资源模型数据流。</T>
//============================================================
public class FRs3ModelStream
{
   // 代码
   protected String _code;

   // 元素类型
   protected int _elementDataCd;

   // 元素个数
   protected int _elementCount;

   // 数据宽度
   protected int _dataStride;

   // 数据个数
   protected int _dataCount;

   // 数据长度
   protected byte[] _data;

   //============================================================
   // <T>构造资源模型数据流。</T>
   //============================================================
   public FRs3ModelStream(){
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
   // <T>获得元素类型。</T>
   //
   // @return 元素类型
   //============================================================
   public int elementDataCd(){
      return _elementDataCd;
   }

   //============================================================
   // <T>获得元素个数。</T>
   //
   // @return 元素个数
   //============================================================
   public int elementCount(){
      return _elementCount;
   }

   //============================================================
   // <T>获得宽度。</T>
   //
   // @return 宽度
   //============================================================
   public int dataStride(){
      return _dataStride;
   }

   //============================================================
   // <T>获得个数。</T>
   //
   // @return 个数
   //============================================================
   public int dataCount(){
      return _dataCount;
   }

   //============================================================
   // <T>获得长度。</T>
   //
   // @return 长度
   //============================================================
   public int dataLength(){
      return _dataStride * _dataCount;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] data(){
      return _data;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _code = input.readString();
      _elementDataCd = input.readInt8();
      _elementCount = input.readInt8();
      _dataStride = input.readInt16();
      _dataCount = input.readInt32();
      // 读取数据
      int size = _dataStride * _dataCount;
      _data = new byte[size];
      input.read(_data, 0, size);
   }
}
