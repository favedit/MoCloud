package org.mo.content.resource3d.common;

import com.cyou.gccloud.define.enums.common.EGcData;
import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>资源模型数据流。</T>
//============================================================
public class FRs3Stream
      extends FRs3Object
{
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
   public FRs3Stream(){
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   @Override
   public String fullCode(){
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
   public void serializeFloat2(IDataOutput output){
      if((_elementDataCd != EGcData.Float32) || (_elementCount != 2)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)_elementDataCd);
      output.writeUint8((short)_elementCount);
      output.writeBoolean(false);
      output.writeUint8((short)_dataStride);
      output.writeInt32(_dataCount);
      // 输出数据
      output.write(_data, 0, _data.length);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeFloat3(IDataOutput output){
      if((_elementDataCd != EGcData.Float32) || (_elementCount != 3)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)_elementDataCd);
      output.writeUint8((short)_elementCount);
      output.writeBoolean(false);
      output.writeUint8((short)_dataStride);
      output.writeInt32(_dataCount);
      // 输出数据
      output.write(_data, 0, _data.length);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeFloat4(IDataOutput output){
      if((_elementDataCd != EGcData.Float32) || (_elementCount != 4)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)_elementDataCd);
      output.writeUint8((short)_elementCount);
      output.writeBoolean(false);
      output.writeUint8((short)_dataStride);
      output.writeInt32(_dataCount);
      // 输出数据
      output.write(_data, 0, _data.length);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeColor4(IDataOutput output){
      if((_elementDataCd == EGcData.Uint8) && (_elementCount == 4)){
         // 输出属性
         output.writeUint8((short)EGcData.Uint8);
         output.writeUint8((short)4);
         output.writeBoolean(true);
         output.writeUint8((short)4);
         output.writeInt32(_dataCount);
         // 输出数据
         FByteStream stream = new FByteStream(_data, _data.length);
         for(int n = 0; n < _dataCount; n++){
            short v1 = stream.readUint8();
            short v2 = stream.readUint8();
            short v3 = stream.readUint8();
            short v4 = stream.readUint8();
            output.writeUint8(v1);
            output.writeUint8(v2);
            output.writeUint8(v3);
            output.writeUint8(v4);
         }
      }else if((_elementDataCd == EGcData.Float32) && (_elementCount == 4)){
         // 输出属性
         output.writeUint8((short)EGcData.Uint8);
         output.writeUint8((short)4);
         output.writeBoolean(true);
         output.writeUint8((short)4);
         output.writeInt32(_dataCount);
         // 输出数据
         FByteStream stream = new FByteStream(_data, _data.length);
         for(int n = 0; n < _dataCount; n++){
            float v1 = stream.readFloat();
            float v2 = stream.readFloat();
            float v3 = stream.readFloat();
            float v4 = stream.readFloat();
            output.writeUint8((byte)(v1 * 240.0f));
            output.writeUint8((byte)(v2 * 240.0f));
            output.writeUint8((byte)(v3 * 240.0f));
            output.writeUint8((byte)(v4 * 240.0f));
         }
      }else{
         throw new FFatalError("Invalid format.");
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeByte4Normal(IDataOutput output){
      if((_elementDataCd != EGcData.Float32) || (_elementCount != 3)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)EGcData.Uint8);
      output.writeUint8((short)4);
      output.writeBoolean(true);
      output.writeUint8((short)4);
      output.writeInt32(_dataCount);
      // 输出数据
      FByteStream stream = new FByteStream(_data, _data.length);
      for(int n = 0; n < _dataCount; n++){
         float v1 = stream.readFloat();
         float v2 = stream.readFloat();
         float v3 = stream.readFloat();
         //SFloatVector3 value = new SFloatVector3(v1, v2, v3);
         //value.normallize();
         output.writeUint8((short)((v1 + 1.0) * 0.5f * 240.0f));
         output.writeUint8((short)((v2 + 1.0) * 0.5f * 240.0f));
         output.writeUint8((short)((v3 + 1.0) * 0.5f * 240.0f));
         output.writeUint8((short)255);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeUint16(IDataOutput output){
      if((_elementDataCd != EGcData.Int16) || (_elementCount != 3)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)EGcData.Uint16);
      output.writeUint8((short)3);
      output.writeBoolean(false);
      output.writeUint8((short)6);
      output.writeInt32(_dataCount);
      // 输出数据
      FByteStream stream = new FByteStream(_data, _data.length);
      int total = _dataCount * 3;
      for(int n = 0; n < total; n++){
         int index = stream.readUint16();
         output.writeUint16(index);
      }
      // 输出数据
      //output.write(_data, 0, _data.length);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeUint32(IDataOutput output){
      if((_elementDataCd != EGcData.Int32) || (_elementCount != 3)){
         throw new FFatalError("Invalid format.");
      }
      if(_dataCount > 65536){
         // 输出属性
         output.writeString("index32");
         output.writeUint8((short)EGcData.Uint32);
         output.writeUint8((short)3);
         output.writeBoolean(false);
         output.writeUint8((short)12);
         output.writeInt32(_dataCount);
         // 输出数据
         FByteStream stream = new FByteStream(_data, _data.length);
         int total = _dataCount * 3;
         for(int n = 0; n < total; n++){
            output.writeUint32(stream.readUint32());
         }
      }else{
         // 输出属性
         output.writeString("index16");
         output.writeUint8((short)EGcData.Uint16);
         output.writeUint8((short)3);
         output.writeBoolean(false);
         output.writeUint8((short)6);
         output.writeInt32(_dataCount);
         // 输出数据
         FByteStream stream = new FByteStream(_data, _data.length);
         int total = _dataCount * 3;
         for(int n = 0; n < total; n++){
            output.writeUint16(stream.readInt32());
         }
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeBoneIndex(IDataOutput output){
      if((_elementDataCd != EGcData.Int16) || (_elementCount != 4)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)EGcData.Uint8);
      output.writeUint8((short)4);
      output.writeBoolean(false);
      output.writeUint8((short)4);
      output.writeInt32(_dataCount);
      // 输出数据
      FByteStream stream = new FByteStream(_data, _data.length);
      int total = _dataCount * 4;
      for(int n = 0; n < total; n++){
         output.writeUint8(stream.readInt16());
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeBoneWeight(IDataOutput output){
      if((_elementDataCd != EGcData.Float32) || (_elementCount != 4)){
         throw new FFatalError("Invalid format.");
      }
      // 输出属性
      output.writeUint8((short)EGcData.Uint8);
      output.writeUint8((short)4);
      output.writeBoolean(true);
      output.writeUint8((short)4);
      output.writeInt32(_dataCount);
      // 输出数据
      FByteStream stream = new FByteStream(_data, _data.length);
      int total = _dataCount * 4;
      for(int n = 0; n < total; n++){
         output.writeUint8((short)(stream.readFloat() * 255.0f));
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeData(IDataOutput output){
      // 输出属性
      output.writeUint8((short)_elementDataCd);
      output.writeUint8((short)_elementCount);
      output.writeBoolean(false);
      output.writeUint8((short)_dataStride);
      output.writeInt32(_dataCount);
      // 输出数据
      output.write(_data, 0, _data.length);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      switch(_code){
         case "position":
            output.writeString(_code);
            serializeFloat3(output);
            break;
         case "color":
            output.writeString(_code);
            serializeColor4(output);
            break;
         case "coord":
            output.writeString(_code);
            serializeFloat2(output);
            break;
         case "normal":
         case "binormal":
         case "tangent":
            output.writeString(_code);
            serializeByte4Normal(output);
            break;
         case "bone_index":
            output.writeString(_code);
            serializeBoneIndex(output);
            break;
         case "bone_weight":
            output.writeString(_code);
            serializeBoneWeight(output);
            break;
         case "index16":
            output.writeString(_code);
            serializeUint16(output);
            break;
         case "index32":
            serializeUint32(output);
            break;
         default:
            throw new FFatalError("Unknown code");
      }
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

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
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
