package org.mo.com.io;

import org.mo.com.io.base.MByteStream;
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
   //============================================================
   // <T>构造字节数据流。</T>
   //============================================================
   public FByteStream(){
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
   // <T>忽略指定长度。</T>
   //
   // @param length 长度
   //============================================================
   public void skip(int length){
      _position += length;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
      value |= (_memory[_position++] & 0xFF) << 16;
      value |= (_memory[_position++] & 0xFF) << 24;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
      value |= (_memory[_position++] & 0xFF) << 16;
      value |= (_memory[_position++] & 0xFF) << 24;
      value |= (_memory[_position++] & 0xFF) << 32;
      value |= (_memory[_position++] & 0xFF) << 40;
      value |= (_memory[_position++] & 0xFF) << 48;
      value |= (_memory[_position++] & 0xFF) << 56;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
      value |= (_memory[_position++] & 0xFF) << 16;
      value |= (_memory[_position++] & 0xFF) << 24;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
      value |= (_memory[_position++] & 0xFF) << 16;
      value |= (_memory[_position++] & 0xFF) << 24;
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
      value |= (_memory[_position++] & 0xFF);
      value |= (_memory[_position++] & 0xFF) << 8;
      value |= (_memory[_position++] & 0xFF) << 16;
      value |= (_memory[_position++] & 0xFF) << 24;
      value |= (_memory[_position++] & 0xFF) << 32;
      value |= (_memory[_position++] & 0xFF) << 40;
      value |= (_memory[_position++] & 0xFF) << 48;
      value |= (_memory[_position++] & 0xFF) << 56;
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
      _memory[_position++] = (byte)((value) & 0xFF);
      _memory[_position++] = (byte)((value >> 8) & 0xFF);
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
      _memory[_position++] = (byte)((value) & 0xFF);
      _memory[_position++] = (byte)((value >> 8) & 0xFF);
      _memory[_position++] = (byte)((value >> 16) & 0xFF);
      _memory[_position++] = (byte)((value >> 24) & 0xFF);
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
      _memory[_position++] = (byte)((value) & 0xFF);
      _memory[_position++] = (byte)((value >> 8) & 0xFF);
      _memory[_position++] = (byte)((value >> 16) & 0xFF);
      _memory[_position++] = (byte)((value >> 24) & 0xFF);
      _memory[_position++] = (byte)((value >> 32) & 0xFF);
      _memory[_position++] = (byte)((value >> 40) & 0xFF);
      _memory[_position++] = (byte)((value >> 48) & 0xFF);
      _memory[_position++] = (byte)((value >> 56) & 0xFF);
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
      _memory[_position++] = (byte)((value) & 0xFF);
      _memory[_position++] = (byte)((value >> 8) & 0xFF);
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
      _memory[_position++] = (byte)((value) & 0xFF);
      _memory[_position++] = (byte)((value >> 8) & 0xFF);
      _memory[_position++] = (byte)((value >> 16) & 0xFF);
      _memory[_position++] = (byte)((value >> 24) & 0xFF);
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
      _memory[_position++] = (byte)((data) & 0xFF);
      _memory[_position++] = (byte)((data >> 8) & 0xFF);
      _memory[_position++] = (byte)((data >> 16) & 0xFF);
      _memory[_position++] = (byte)((data >> 24) & 0xFF);
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
      _memory[_position++] = (byte)((data) & 0xFF);
      _memory[_position++] = (byte)((data >> 8) & 0xFF);
      _memory[_position++] = (byte)((data >> 16) & 0xFF);
      _memory[_position++] = (byte)((data >> 24) & 0xFF);
      _memory[_position++] = (byte)((data >> 32) & 0xFF);
      _memory[_position++] = (byte)((data >> 40) & 0xFF);
      _memory[_position++] = (byte)((data >> 48) & 0xFF);
      _memory[_position++] = (byte)((data >> 56) & 0xFF);
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
   //   // <T>写入一个字节数组。</T>
   //   //
   //   // @param bytes 字节数组
   //   // @param offset 位置
   //   // @param length 长度
   //   //============================================================
   //   @Override
   //   public void WriteBytes(byte[] bytes, int offset, int length){
   //      ensureSize(_position + length);
   //      System.arraycopy(bytes, offset, _memory, _position, length);
   //      _position += length;
   //      if(_position > _length){
   //         _length = _position;
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>将float型数值写入</T>
   //   //
   //   // @param value 待写入的值
   //   //============================================================
   //   @Override
   //   public void WriteFloat(float value){
   //      ensureSize(_position + 4);
   //      bb = ByteBuffer.allocate(4);
   //      byte[] ret = new byte[4];
   //      FloatBuffer fb = bb.asFloatBuffer();
   //      fb.put(value);
   //      bb.get(ret);
   //      System.arraycopy(ret, 0, _memory, _position, ret.length);
   //      _position += 4;
   //      if(_position > _length){
   //         _length = _position;
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>将double型数值写入</T>
   //   //
   //   // @param value 待写入的值
   //   //============================================================
   //   @Override
   //   public void WriteDouble(double value){
   //      ensureSize(_position + 8);
   //      bb = ByteBuffer.allocate(8);
   //      byte[] ret = new byte[8];
   //      DoubleBuffer fb = bb.asDoubleBuffer();
   //      fb.put(value);
   //      bb.get(ret);
   //      System.arraycopy(ret, 0, _memory, _position, ret.length);
   //      _position += 8;
   //      if(_position > _length){
   //         _length = _position;
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>将字符串写入</T>
   //   //
   //   // @param value 待写入的值
   //   //============================================================
   //   @Override
   //   public void WriteString(String value){
   //      if(null == value){
   //         WriteInt16((short)0);
   //      }else{
   //         WriteInt16((short)value.length());
   //         byte[] bytes = value.getBytes();
   //         ensureSize(_position + bytes.length);
   //         System.arraycopy(bytes, 0, _memory, _position, bytes.length);
   //         _position += value.length();
   //         if(_position > _length){
   //            _length = _position;
   //         }
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个byte类型数字。</T>
   //   //
   //   // @return byte数字
   //   //============================================================
   //   @Override
   //   public byte ReadInt8(){
   //      return _memory[_position++];
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个short类型数字。</T>
   //   //
   //   // @return short数字
   //   //============================================================
   //   @Override
   //   public short ReadInt16(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 2);
   //      bb = ByteBuffer.wrap(bytes);
   //      ShortBuffer sb = bb.asShortBuffer();
   //      _position += 2;
   //      return sb.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个int类型数字。</T>
   //   //
   //   // @return int数字
   //   //============================================================
   //   @Override
   //   public int ReadInt32(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 4);
   //      _position += 4;
   //      bb = ByteBuffer.wrap(bytes);
   //      IntBuffer ib = bb.asIntBuffer();
   //      return ib.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个long类型数字。</T>
   //   //
   //   // @return long数字
   //   //============================================================
   //   @Override
   //   public long ReadInt64(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 8);
   //      _position += 8;
   //      bb = ByteBuffer.wrap(bytes);
   //      LongBuffer lb = bb.asLongBuffer();
   //      return lb.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个byte类型数字。</T>
   //   //
   //   // @return byte数字
   //   //============================================================
   //   @Override
   //   public byte ReadUInt8(){
   //      return _memory[_position++];
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个short类型数字。</T>
   //   //
   //   // @return short数字
   //   //============================================================
   //   @Override
   //   public short ReadUInt16(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 2);
   //      bb = ByteBuffer.wrap(bytes);
   //      ShortBuffer sb = bb.asShortBuffer();
   //      _position += 2;
   //      return sb.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个int类型数字。</T>
   //   //
   //   // @return int数字
   //   //============================================================
   //   @Override
   //   public int ReadUInt32(){
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个long类型数字。</T>
   //   //
   //   // @return long数字
   //   //============================================================
   //   @Override
   //   public long ReadUInt64(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 8);
   //      _position += 8;
   //      bb = ByteBuffer.wrap(bytes);
   //      LongBuffer lb = bb.asLongBuffer();
   //      return lb.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个float类型数字。</T>
   //   //
   //   // @return float数字
   //   //============================================================
   //   @Override
   //   public float ReadFloat(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 4);
   //      bb = ByteBuffer.wrap(bytes);
   //      FloatBuffer fb = bb.asFloatBuffer();
   //      _position += 4;
   //      return fb.get();
   //   }
   //
   //   //============================================================
   //   // <T>读取指定位置的一个double类型数字。</T>
   //   //
   //   // @return double数
   //   //============================================================
   //   @Override
   //   public double ReadDouble(){
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, _position + 8);
   //      bb = ByteBuffer.wrap(bytes);
   //      DoubleBuffer fb = bb.asDoubleBuffer();
   //      _position += 8;
   //      return fb.get();
   //   }
   //   //============================================================
   //   // <T>读取指定位置的一个字符串。</T>
   //   //
   //   // @return 字符串 
   //   //============================================================
   //   @Override
   //   public String ReadString(){
   //      String str = "";
   //      int result = ReadInt16();
   //      byte[] bytes = Arrays.copyOfRange(_memory, _position, result + _position);
   //      if(result > 0){
   //         str = new String(bytes);
   //      }
   //      _position += result;
   //      return str;
   //   }
   //
   //   //============================================================
   //   // <T>读取从指定位置到结尾的所有数值</T>
   //   //
   //   // @return byte数组
   //   //============================================================
   //   @Override
   //   public byte[] ReadAll(){
   //      int length = _length - _position;
   //      byte[] bytes = new byte[length];
   //      System.arraycopy(_memory, _position, bytes, 0, length);
   //      return bytes;
   //   }
   //
   //   //============================================================
   //   // <T>清除所有数据内容。</T>
   //   //============================================================
   //   @Override
   //   public void Reset(){
   //      Arrays.copyOf(_memory, 0);
   //      _position = 0;
   //   }
   //
   //   //============================================================
   //   // <T>清除所有数据内容。</T>
   //   // <P>不清空数据，只是重设长度和位置。</P>
   //   //============================================================
   //   @Override
   //   public void Clear(){
   //      _length = 0;
   //      _position = 0;
   //
   //   }
   //============================================================
   // <T>重设数据开始位置和长度。</T>
   //============================================================
   public void Flip(){
      _length = _position;
      _position = 0;
   }
}
