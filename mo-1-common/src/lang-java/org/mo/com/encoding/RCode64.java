/*
 * @(#)FBase64.java
 *
 * Copyright 2008 microbject, All Rights Reserved.
 *
 */
package org.mo.com.encoding;

import java.io.UnsupportedEncodingException;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>BASE64编码器。</T>
//============================================================
public class RCode64
{
   // 编码字符集合
   private static char[] ENCODE_CHARS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
         'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

   //============================================================
   // <T>对字节数组进行编码。</T>
   //
   // @param data 字节数组
   // @return 编码字符串
   //============================================================
   public static String encode(byte[] data){
      StringBuffer result = new StringBuffer();
      int length = data.length;
      int i = 0;
      int b1, b2, b3;
      while(i < length){
         b1 = data[i++] & 0xff;
         if(i == length){
            result.append(ENCODE_CHARS[b1 >>> 2]);
            result.append(ENCODE_CHARS[(b1 & 0x3) << 4]);
            break;
         }
         b2 = data[i++] & 0xff;
         if(i == length){
            result.append(ENCODE_CHARS[b1 >>> 2]);
            result.append(ENCODE_CHARS[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            result.append(ENCODE_CHARS[(b2 & 0x0f) << 2]);
            break;
         }
         b3 = data[i++] & 0xff;
         result.append(ENCODE_CHARS[b1 >>> 2]);
         result.append(ENCODE_CHARS[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
         result.append(ENCODE_CHARS[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
         result.append(ENCODE_CHARS[b3 & 0x3f]);
      }
      return result.toString();
   }

   //============================================================
   // <T>对字符串进行编码。</T>
   //
   // @param source 来源字符串
   // @param encode 来源编码
   // @return 编码字符串
   //============================================================
   public static String encode(String source,
                               String encode){
      try{
         return encode(source.getBytes(encode));
      }catch(UnsupportedEncodingException e){
         throw new FFatalError(e);
      }
   }
}
