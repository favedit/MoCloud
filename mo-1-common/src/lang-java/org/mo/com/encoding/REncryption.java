package org.mo.com.encoding;

import java.security.MessageDigest;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RByte;
import org.mo.com.lang.RString;

//============================================================
// <T>编码器工具。</T>
//============================================================
public class REncryption
{
   // 代码
   public static final String CODE = "SHA-1";

   // 字符代码
   public static final String CODE_CHAR = "ISO-8859-1";

   //============================================================
   // <T>加密一个字符串，返回加密后的字符串。</T>
   //
   // @param key 密钥
   // @param source 字符串
   // @return 加密字符串
   //============================================================
   public static String encodeString(String key,
                                     String value){
      // 检查参数
      if(RString.isEmpty(key)){
         throw new FFatalError("Key is empty.");
      }
      if(RString.isEmpty(value)){
         throw new FFatalError("Value is empty.");
      }
      // 获得KEY
      try{
         // 创建服务实例
         MessageDigest provider = MessageDigest.getInstance(CODE);
         provider.update(key.getBytes(CODE_CHAR));
         byte[] keyData = provider.digest();
         int keyLength = keyData.length;
         // 转换字符串
         byte[] valueData = value.getBytes(CODE_CHAR);
         int valueLength = valueData.length;
         for(int i = 0; i < valueLength; i++){
            byte keyByte = keyData[i % keyLength];
            valueData[i] ^= keyByte;
         }
         // 转换数组为字符串
         return RByte.toHexString(valueData);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>解密一个字符串，返回解密的字符串。</T>
   //
   // @param key 密钥
   // @param source 加密字符串
   // @return 字符串
   //============================================================
   public static String decodeString(String key,
                                     String value){
      // 检查参数
      if(RString.isEmpty(key)){
         throw new FFatalError("Key is empty.");
      }
      if(RString.isEmpty(value)){
         throw new FFatalError("Value is empty.");
      }
      // 获得KEY
      try{
         // 创建服务实例
         MessageDigest provider = MessageDigest.getInstance(CODE);
         provider.update(key.getBytes(CODE_CHAR));
         byte[] keyData = provider.digest();
         int keyLength = keyData.length;
         // 转换字符串
         byte[] valueData = RByte.fromHexString(value);
         int valueLength = valueData.length;
         for(int i = 0; i < valueLength; i++){
            byte keyByte = keyData[i % keyLength];
            valueData[i] ^= keyByte;
         }
         // 转换数组为字符串
         return new String(valueData, CODE_CHAR);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>加密一个数字，XOR运算，两次运算还原数据。</T>
   //
   // @param key 密钥
   // @param source 字符串
   // @return 处理结果
   //============================================================
   public static boolean encodeBytes(byte[] data,
                                     int offset,
                                     int length,
                                     int key){
      // 检查参数
      if(data == null){
         return false;
      }
      byte[] sign = new byte[8];
      sign[0] = (byte)((key >> 16) & 0xFF);
      sign[1] = (byte)((key >> 8) & 0xFF);
      sign[2] = (byte)((key) & 0xFF);
      sign[3] = (byte)((key >> 24) & 0xFF);
      sign[4] = (byte)((key) & 0xFF);
      sign[5] = (byte)((key >> 24) & 0xFF);
      sign[6] = (byte)((key >> 16) & 0xFF);
      sign[7] = (byte)((key >> 8) & 0xFF);
      // 数据运算
      for(int i = 0; i < length; i++){
         data[offset + i] ^= sign[i % 8];
      }
      return true;
   }

   //============================================================
   // <T>加密一个数字，XOR运算，两次运算还原数据。</T>
   //
   // @param key 密钥
   // @param source 字符串
   // @return 处理结果
   //============================================================
   public static boolean encodeBytes(byte[] data,
                                     int offset,
                                     int length,
                                     byte[] key){
      // 检查参数
      if((data == null) || (key == null)){
         return false;
      }
      // 数据运算
      int keyLength = key.length;
      for(int i = 0; i < length; i++){
         byte keyByte = key[i % keyLength];
         data[offset + i] ^= keyByte;
      }
      return true;
   }
}
