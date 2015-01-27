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
   // <T>设置代码。</T>
   //
   // @param 代码
   //============================================================
   public void setCode(String code){
      _code = code;
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
   // <T>设置元素类型。</T>
   //
   // @param elementDataCd 元素类型
   //============================================================
   public void setElementDataCd(int elementDataCd){
      _elementDataCd = elementDataCd;
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
   // <T>设置元素个数。</T>
   //
   // @param elementCount 元素个数
   //============================================================
   public void setElementCount(int elementCount){
      _elementCount = elementCount;
   }

   //============================================================
   // <T>获得数据宽度。</T>
   //
   // @return 数据宽度
   //============================================================
   public int dataStride(){
      return _dataStride;
   }

   //============================================================
   // <T>设置数据宽度。</T>
   //
   // @param dataStride 数据宽度
   //============================================================
   public void setDataStride(int dataStride){
      _dataStride = dataStride;
   }

   //============================================================
   // <T>获得数据个数。</T>
   //
   // @return 数据个数
   //============================================================
   public int dataCount(){
      return _dataCount;
   }

   //============================================================
   // <T>设置数据个数。</T>
   //
   // @param dataCount 数据个数
   //============================================================
   public void setDataCount(int dataCount){
      _dataCount = dataCount;
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
   // <T>设置数据。</T>
   //
   // @param data 代码
   //============================================================
   public void setData(byte[] data){
      _data = data;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 读取属性
      output.writeString(_code);
      output.writeUint8((short)_elementDataCd);
      output.writeUint8((short)_elementCount);
      output.writeUint8((short)_dataStride);
      output.writeInt32(_dataCount);
      // 读取数据
      output.write(_data, 0, _data.length);
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
