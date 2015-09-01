package org.mo.com.io;

import org.mo.com.io.base.MCharStream;
import org.mo.com.lang.FString;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;

//============================================================
//<T>字符数据流。</T>
//============================================================
public class FCharStream
      extends MCharStream
      implements
         IDataInput,
         IDataOutput
{
   // 标志字符
   public final static char FLAG = 'A';

   //============================================================
   // <T>构造字符数据流。</T>
   //============================================================
   public FCharStream(){
   }

   //============================================================
   // <T>构造字符数据流。</T>
   //
   // @param capacity 容量
   //============================================================
   public FCharStream(int capacity){
      super(capacity);
   }

   //============================================================
   // <T>构造字节数据流。</T>
   //
   // @param memory 内存
   //============================================================
   public FCharStream(char[] memory){
      super(memory, memory.length);
   }

   //============================================================
   // <T>构造字节数据流。</T>
   //
   // @param memory 内存
   // @param length 长度
   //============================================================
   public FCharStream(char[] memory,
                      int length){
      super(memory, length);
   }

   //============================================================
   // <T>从字节流中读取一个布尔值。</T>
   // <P>占用一个字节，为1表示真，为0表示假。</P>
   //
   // @return 布尔值
   //============================================================
   @Override
   public boolean readBoolean(){
      char value = _memory[_position++];
      return (value == 'Y');
   }

   //============================================================
   // <T>从字节流中读取一个有符号8位整数。</T>
   //
   // @return 有符号8位整数
   //============================================================
   @Override
   public byte readInt8(){
      return (byte)readInt32();
   }

   //============================================================
   // <T>从字节流中读取一个有符号16位整数。</T>
   //
   // @return 有符号16位整数
   //============================================================
   @Override
   public short readInt16(){
      return (short)readInt32();
   }

   //============================================================
   // <T>从字节流中读取一个有符号32位整数。</T>
   //
   // @return 有符号32位整数
   //============================================================
   @Override
   public int readInt32(){
      int length = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, length);
      _position += length;
      return RInteger.parse(source.toString());
   }

   //============================================================
   // <T>从字节流中读取一个有符号64位整数。</T>
   //
   // @return 有符号64位整数
   //============================================================
   @Override
   public long readInt64(){
      int length = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, length);
      _position += length;
      return RLong.parse(source.toString());
   }

   //============================================================
   // <T>从字节流中读取一个无符号8位整数。</T>
   //
   // @return 无符号8位整数
   //============================================================
   @Override
   public short readUint8(){
      return (short)readInt32();
   }

   //============================================================
   // <T>从字节流中读取一个无符号16位整数。</T>
   //
   // @return 无符号16位整数
   //============================================================
   @Override
   public int readUint16(){
      return readInt32();
   }

   //============================================================
   // <T>从字节流中读取一个无符号32位整数。</T>
   //
   // @return 无符号32位整数
   //============================================================
   @Override
   public long readUint32(){
      int length = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, length);
      _position += length;
      return RLong.parse(source.toString());
   }

   //============================================================
   // <T>从字节流中读取一个32位浮点数。</T>
   //
   // @return 32位浮点数
   //============================================================
   @Override
   public float readFloat(){
      int length = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, length);
      _position += length;
      return RFloat.parse(source.toString());
   }

   //============================================================
   // <T>从字节流中读取一个64位浮点数。</T>
   //
   // @return 64位浮点数
   //============================================================
   @Override
   public double readDouble(){
      int length = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, length);
      _position += length;
      return RDouble.parse(source.toString());
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
      int flag = _memory[_position++] - FLAG;
      FString source = new FString(_memory, _position, flag);
      _position += flag;
      // 读取内容
      int length = RInteger.parse(source.toString());
      FString value = new FString(_memory, _position, flag);
      _position += length;
      return value.toString();
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
      _memory[_position++] = value ? 'Y' : 'N';
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
      writeInt32(value);
   }

   //============================================================
   // <T>向字节流中写入一个有符号8位整数。</T>
   //
   // @param value 有符号8位整数
   //============================================================
   @Override
   public void writeInt8(byte value){
      writeInt32(value);

   }

   //============================================================
   // <T>在字节流中写入一个有符号16位整数。</T>
   //
   // @param value 有符号16位整数
   //============================================================
   @Override
   public void writeInt16(short value){
      writeInt32(value);
   }

   //============================================================
   // <T>在字节流中写入一个有符号32位整数。</T>
   //
   // @param value 有符号32位整数
   //============================================================
   @Override
   public void writeInt32(int value){
      // 计算容量
      String source = Integer.toString(value);
      int sourceLength = source.length();
      ensureSize(_position + 1 + sourceLength);
      // 写入长度
      _memory[_position++] = (char)(FLAG + source.length());
      for(int i = 0; i < sourceLength; i++){
         _memory[_position++] = source.charAt(i);
      }
      // 调整长度
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
      // 计算容量
      String source = Long.toString(value);
      int sourceLength = source.length();
      ensureSize(_position + 1 + sourceLength);
      // 写入长度
      _memory[_position++] = (char)(FLAG + source.length());
      for(int i = 0; i < sourceLength; i++){
         _memory[_position++] = source.charAt(i);
      }
      // 调整长度
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
      writeInt32(value);
   }

   //============================================================
   // <T>向字节流中写入一个无符号16位整数。</T>
   //
   // @param value 无符号16位整数
   //============================================================
   @Override
   public void writeUint16(int value){
      writeInt32(value);
   }

   //============================================================
   // <T>向字节流中写入一个无符号32位整数。</T>
   //
   // @param value 无符号32位整数
   //============================================================
   @Override
   public void writeUint32(long value){
      writeInt64(value);
   }

   //============================================================
   // <T>向字节流中写入一个32位浮点数。</T>
   //
   // @param value 32位浮点数
   //============================================================
   @Override
   public void writeFloat(float value){
      // 计算容量
      String source = Float.toString(value);
      int sourceLength = source.length();
      ensureSize(_position + 1 + sourceLength);
      // 写入长度
      _memory[_position++] = (char)(FLAG + source.length());
      for(int i = 0; i < sourceLength; i++){
         _memory[_position++] = source.charAt(i);
      }
      // 调整长度
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
      // 计算容量
      String source = Double.toString(value);
      int sourceLength = source.length();
      ensureSize(_position + 1 + sourceLength);
      // 写入长度
      _memory[_position++] = (char)(FLAG + source.length());
      for(int i = 0; i < sourceLength; i++){
         _memory[_position++] = source.charAt(i);
      }
      // 调整长度
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
      // 计算容量
      int valueLength = (value != null) ? value.length() : 0;
      String length = Integer.toString(valueLength);
      int lengthLength = length.length();
      ensureSize(_position + 1 + lengthLength + valueLength);
      // 写入长度
      _memory[_position++] = (char)(FLAG + lengthLength);
      for(int i = 0; i < lengthLength; i++){
         _memory[_position++] = length.charAt(i);
      }
      // 写入内容
      for(int i = 0; i < valueLength; i++){
         _memory[_position++] = value.charAt(i);
      }
      // 调整长度
      if(_position > _length){
         _length = _position;
      }
   }

   @Override
   public int read(byte[] data,
                   int offset,
                   int length){
      return 0;
   }

   @Override
   public int write(byte[] data,
                    int offset,
                    int length){
      return 0;
   }
}
