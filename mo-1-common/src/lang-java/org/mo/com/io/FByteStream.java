package org.mo.com.io;

import java.io.BufferedInputStream;
import java.io.InputStream;
import org.mo.com.io.base.MByteStream;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;

//============================================================
// <T>字节数据流。</T>
//
// @class
//============================================================
public class FByteStream
      extends MByteStream
      implements
         IDataInput,
         IDataOutput
{
   // 字节顺序
   protected EByteEndian _endianCd = EByteEndian.Little;

   //============================================================
   // <T>构造字节数据流。</T>
   //============================================================
   public FByteStream(){
   }

   //============================================================
   // <T>构造字节数据流。</T>
   //
   // @param capacity 容量
   //============================================================
   public FByteStream(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造字节数据流。</T>
   //
   // @param memory 内存
   //============================================================
   public FByteStream(byte[] memory){
      super(memory, memory.length);
   }

   //============================================================
   // <T>构造字节数据流。</T>
   //
   // @param memory 内存
   // @param length 长度
   //============================================================
   public FByteStream(byte[] memory,
                      int length){
      super(memory, length);
   }

   //============================================================
   // <T>获得字节顺序。</T>
   //
   // @return 字节顺序
   //============================================================
   public EByteEndian endianCd(){
      return _endianCd;
   }

   //============================================================
   // <T>设置字节顺序。</T>
   //
   // @param endianCd 字节顺序
   //============================================================
   public void setEndianCd(EByteEndian endianCd){
      _endianCd = endianCd;
   }

   //============================================================
   // <T>从字节流中读取一个布尔值。</T>
   // <P>占用一个字节，为1表示真，为0表示假。</P>
   //
   // @return 布尔值
   //============================================================
   @Override
   public boolean readBoolean(){
      byte value = _memory[_position++];
      return (value > 0);
   }

   //============================================================
   // <T>从字节流中读取一个有符号8位整数。</T>
   //
   // @return 有符号8位整数
   //============================================================
   @Override
   public byte readInt8(){
      return _memory[_position++];
   }

   //============================================================
   // <T>从字节流中读取一个有符号16位整数。</T>
   //
   // @return 有符号16位整数
   //============================================================
   @Override
   public short readInt16(){
      short value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
      }else{
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return value;
   }

   //============================================================
   // <T>从字节流中读取一个有符号32位整数。</T>
   //
   // @return 有符号32位整数
   //============================================================
   @Override
   public int readInt32(){
      int value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 24;
      }else{
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return value;
   }

   //============================================================
   // <T>从字节流中读取一个有符号64位整数。</T>
   //
   // @return 有符号64位整数
   //============================================================
   @Override
   public long readInt64(){
      long value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 32;
         value |= (_memory[_position++] & 0xFF) << 40;
         value |= (_memory[_position++] & 0xFF) << 48;
         value |= (_memory[_position++] & 0xFF) << 56;
      }else{
         value |= (_memory[_position++] & 0xFF) << 56;
         value |= (_memory[_position++] & 0xFF) << 48;
         value |= (_memory[_position++] & 0xFF) << 40;
         value |= (_memory[_position++] & 0xFF) << 32;
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return value;
   }

   //============================================================
   // <T>从字节流中读取一个无符号8位整数。</T>
   //
   // @return 无符号8位整数
   //============================================================
   @Override
   public short readUint8(){
      return _memory[_position++];
   }

   //============================================================
   // <T>从字节流中读取一个无符号16位整数。</T>
   //
   // @return 无符号16位整数
   //============================================================
   @Override
   public int readUint16(){
      int value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
      }else{
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return value;
   }

   //============================================================
   // <T>从字节流中读取一个无符号32位整数。</T>
   //
   // @return 无符号32位整数
   //============================================================
   @Override
   public long readUint32(){
      long value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 24;
      }else{
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return value;
   }

   //============================================================
   // <T>从字节流中读取一个32位浮点数。</T>
   //
   // @return 32位浮点数
   //============================================================
   @Override
   public float readFloat(){
      int value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 24;
      }else{
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return Float.intBitsToFloat(value);
   }

   //============================================================
   // <T>从字节流中读取一个64位浮点数。</T>
   //
   // @return 64位浮点数
   //============================================================
   @Override
   public double readDouble(){
      long value = 0;
      if(_endianCd == EByteEndian.Little){
         value |= (_memory[_position++] & 0xFF);
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 32;
         value |= (_memory[_position++] & 0xFF) << 40;
         value |= (_memory[_position++] & 0xFF) << 48;
         value |= (_memory[_position++] & 0xFF) << 56;
      }else{
         value |= (_memory[_position++] & 0xFF) << 56;
         value |= (_memory[_position++] & 0xFF) << 48;
         value |= (_memory[_position++] & 0xFF) << 40;
         value |= (_memory[_position++] & 0xFF) << 32;
         value |= (_memory[_position++] & 0xFF) << 24;
         value |= (_memory[_position++] & 0xFF) << 16;
         value |= (_memory[_position++] & 0xFF) << 8;
         value |= (_memory[_position++] & 0xFF);
      }
      return Double.longBitsToDouble(value);
   }

   //============================================================
   // <T>从字节流中读取一个字符串。</T>
   // <P>前两位长度，后面数据。</P>
   //
   // @return 字符串
   //============================================================
   @Override
   public String readString(){
      // 读取长度
      int length = readInt16();
      StringBuffer result = new StringBuffer(length);
      for(int n = 0; n < length; n++){
         result.append((char)readInt16());
      }
      return result.toString();
   }

   //============================================================
   // <T>向字节流中写入一个布尔值。</T>
   // <P>占用一个字节，为1表示真，为0表示假。</P>
   //
   // @param value 布尔值
   //============================================================
   @Override
   public void writeBoolean(boolean value){
      ensureSize(_position + 1);
      _memory[_position++] = (byte)(value ? 1 : 0);
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个有符号整数。</T>
   //
   // @param value 有符号整数
   //============================================================
   @Override
   public void writeInt(int value){
      ensureSize(_position + 1);
      _memory[_position++] = (byte)((value) & 0xFF);
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个有符号8位整数。</T>
   //
   // @param value 有符号8位整数
   //============================================================
   @Override
   public void writeInt8(byte value){
      ensureSize(_position + 1);
      _memory[_position++] = (byte)((value) & 0xFF);
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>在字节流中写入一个有符号16位整数。</T>
   //
   // @param value 有符号16位整数
   //============================================================
   @Override
   public void writeInt16(short value){
      ensureSize(_position + 2);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((value) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
      }else{
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>在字节流中写入一个有符号32位整数。</T>
   //
   // @param value 有符号32位整数
   //============================================================
   @Override
   public void writeInt32(int value){
      ensureSize(_position + 4);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((value) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
      }else{
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>在字节流中写入一个有符号64位整数。</T>
   //
   // @param value 有符号64位整数
   //============================================================
   @Override
   public void writeInt64(long value){
      ensureSize(_position + 8);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((value) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
         _memory[_position++] = (byte)((value >> 32) & 0xFF);
         _memory[_position++] = (byte)((value >> 40) & 0xFF);
         _memory[_position++] = (byte)((value >> 48) & 0xFF);
         _memory[_position++] = (byte)((value >> 56) & 0xFF);
      }else{
         _memory[_position++] = (byte)((value >> 56) & 0xFF);
         _memory[_position++] = (byte)((value >> 48) & 0xFF);
         _memory[_position++] = (byte)((value >> 40) & 0xFF);
         _memory[_position++] = (byte)((value >> 32) & 0xFF);
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个无符号8位整数。</T>
   //
   // @param value 无符号8位整数
   //============================================================
   @Override
   public void writeUint8(short value){
      ensureSize(_position + 1);
      _memory[_position++] = (byte)((value) & 0xFF);
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个无符号16位整数。</T>
   //
   // @param value 无符号16位整数
   //============================================================
   @Override
   public void writeUint16(int value){
      ensureSize(_position + 2);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((value) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
      }else{
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个无符号32位整数。</T>
   //
   // @param value 无符号32位整数
   //============================================================
   @Override
   public void writeUint32(long value){
      ensureSize(_position + 4);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((value) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
      }else{
         _memory[_position++] = (byte)((value >> 24) & 0xFF);
         _memory[_position++] = (byte)((value >> 16) & 0xFF);
         _memory[_position++] = (byte)((value >> 8) & 0xFF);
         _memory[_position++] = (byte)((value) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个32位浮点数。</T>
   //
   // @param value 32位浮点数
   //============================================================
   @Override
   public void writeFloat(float value){
      ensureSize(_position + 4);
      int data = Float.floatToIntBits(value);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((data) & 0xFF);
         _memory[_position++] = (byte)((data >> 8) & 0xFF);
         _memory[_position++] = (byte)((data >> 16) & 0xFF);
         _memory[_position++] = (byte)((data >> 24) & 0xFF);
      }else{
         _memory[_position++] = (byte)((data >> 24) & 0xFF);
         _memory[_position++] = (byte)((data >> 16) & 0xFF);
         _memory[_position++] = (byte)((data >> 8) & 0xFF);
         _memory[_position++] = (byte)((data) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个64位浮点数。</T>
   //
   // @param value 64位浮点数
   //============================================================
   @Override
   public void writeDouble(double value){
      ensureSize(_position + 8);
      long data = Double.doubleToLongBits(value);
      if(_endianCd == EByteEndian.Little){
         _memory[_position++] = (byte)((data) & 0xFF);
         _memory[_position++] = (byte)((data >> 8) & 0xFF);
         _memory[_position++] = (byte)((data >> 16) & 0xFF);
         _memory[_position++] = (byte)((data >> 24) & 0xFF);
         _memory[_position++] = (byte)((data >> 32) & 0xFF);
         _memory[_position++] = (byte)((data >> 40) & 0xFF);
         _memory[_position++] = (byte)((data >> 48) & 0xFF);
         _memory[_position++] = (byte)((data >> 56) & 0xFF);
      }else{
         _memory[_position++] = (byte)((data >> 56) & 0xFF);
         _memory[_position++] = (byte)((data >> 48) & 0xFF);
         _memory[_position++] = (byte)((data >> 40) & 0xFF);
         _memory[_position++] = (byte)((data >> 32) & 0xFF);
         _memory[_position++] = (byte)((data >> 24) & 0xFF);
         _memory[_position++] = (byte)((data >> 16) & 0xFF);
         _memory[_position++] = (byte)((data >> 8) & 0xFF);
         _memory[_position++] = (byte)((data) & 0xFF);
      }
      if(_position > _length){
         _length = _position;
      }
   }

   //============================================================
   // <T>向字节流中写入一个字符串。</T>
   //
   // @param value 字符串
   //============================================================
   @Override
   public void writeString(String value){
      if(RString.isEmpty(value)){
         // 写入空字符串
         writeUint16(0);
      }else{
         // 写入字符串
         int length = value.length();
         writeUint16(length);
         for(int n = 0; n < length; n++){
            writeUint16(value.charAt(n));
         }
      }
   }

   //============================================================
   // <T>加载输入数据流。</T>
   //
   // @param input 输入数据流
   //============================================================
   public void loadStream(InputStream input){
      int bufferLength = RInteger.SIZE_16K;
      byte[] buffer = new byte[bufferLength];
      try{
         BufferedInputStream inputStream = new BufferedInputStream(input);
         while(true){
            int readed = inputStream.read(buffer, 0, bufferLength);
            if(readed != -1){
               append(buffer, 0, readed);
            }else{
               break;
            }
         }
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
