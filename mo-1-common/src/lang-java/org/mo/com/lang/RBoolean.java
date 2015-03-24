package org.mo.com.lang;

import org.mo.com.lang.type.RBaseBoolean;

//============================================================
// <T>布尔数据类型工具类。</T>
//
// @history 130220 创建
//============================================================
public class RBoolean
      extends RBaseBoolean
{
   // 存储位长度
   public final static int BIT_LENGTH = 1;

   // 存储字节长度
   public final static int BYTE_LENGTH = 1;

   // 内存容量
   public final static int CAPACITY = 32;

   // 内存增长率
   public final static int MULTIPLIER = 2;

   // 布尔值为真的字符
   public final static char TRUE_CHAR = 'Y';

   // 布尔值为真的字符串
   public final static String TRUE_STR = "Y";

   // 布尔值为假的字符
   public final static char FALSE_CHAR = 'N';

   // 布尔值为假的字符串
   public final static String FALSE_STR = "N";

   // 布尔值为真的所有字符串
   public final static String TRUE_STRS = ",y,yes,t,true,on,1,";

   // 布尔值为真的所有字符集合
   public final static char[] TRUE_STRS_CHARS = TRUE_STRS.toCharArray();

   //============================================================
   // <T>判断指定内容是否为真</T>
   //
   // @param value 内容
   // @return 是否为真
   //============================================================
   public final static boolean parse(Boolean value){
      return (null != value) ? value.booleanValue() : false;
   }

   //============================================================
   // <T>判断指定内容是否为真</T>
   //
   // @param value 内容
   // @return 是否为真
   //============================================================
   public final static boolean parse(char value){
      if((value == 'y') || (value == 'Y')){
         return true;
      }
      if((value == 't') || (value == 'T')){
         return true;
      }
      if((value == 'o') || (value == 'O')){
         return true;
      }
      if((value == '1')){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>判断指定内容是否为真</T>
   //
   // @param value 内容
   // @return 是否为真
   //============================================================
   public final static boolean parse(int value){
      return (value > 0);
   }

   //============================================================
   // <T>判断指定内容是否为真</T>
   //
   // @param value 内容
   // @return 是否为真
   //============================================================
   public final static boolean parse(String value){
      if(value != null){
         value = value.toLowerCase();
         if("y".equals(value) || "yes".equals(value)){
            return true;
         }
         if("t".equals(value) || "true".equals(value)){
            return true;
         }
         if("o".equals(value) || "ok".equals(value) || "on".equals(value)){
            return true;
         }
         if("1".equals(value)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>判断指定内容是否为真</T>
   //
   // @param value 内容
   // @return 是否为真
   //============================================================
   public final static boolean parse(Object item){
      if(item != null){
         Class<?> clazz = item.getClass();
         String type = clazz.getName();
         if(clazz == String.class){
            String value = (String)item;
            return parse(value);
         }else if(clazz == Boolean.class || "boolean".equals(type)){
            return ((Boolean)item).booleanValue();
         }else if(clazz == Integer.class || "int".equals(type)){
            return ((Integer)item).intValue() > 0;
         }else if(clazz == Long.class || "long".equals(type)){
            return ((Long)item).longValue() > 0;
         }else if(clazz == Float.class || "float".equals(type)){
            return ((Float)item).floatValue() > 0;
         }else{
            throw new FFatalError("Unknown format. (item={1})", item);
         }
      }
      return DEFAULT;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @return 字符
   //============================================================
   public final static char toChar(boolean value){
      return value ? TRUE_CHAR : FALSE_CHAR;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @return 字符
   //============================================================
   public final static char toChar(Boolean value){
      if(value != null){
         if(value.booleanValue()){
            return TRUE_CHAR;
         }
      }
      return FALSE_CHAR;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @param trueValue 真值
   // @param falseValue 假值
   // @return 字符
   //============================================================
   public final static char toChar(Boolean value,
                                   char trueValue,
                                   char falseValue){
      boolean result = parse(value);
      if(result){
         return trueValue;
      }
      return falseValue;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @return 字符
   //============================================================
   public final static char toChar(int value){
      return (value > 0) ? TRUE_CHAR : FALSE_CHAR;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @return 字符
   //============================================================
   public final static char toChar(String value){
      boolean result = parse(value);
      if(result){
         return TRUE_CHAR;
      }
      return FALSE_CHAR;
   }

   //============================================================
   // <T>获得布尔值的字符。</T>
   //
   // @param value 内容
   // @param trueValue 真值
   // @param falseValue 假值
   // @return 字符
   //============================================================
   public final static char toChar(String value,
                                   char trueValue,
                                   char falseValue){
      boolean result = parse(value);
      if(result){
         return trueValue;
      }
      return falseValue;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(boolean value){
      return value ? TRUE_STR : FALSE_STR;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(Boolean value){
      if(value != null){
         if(value.booleanValue()){
            return TRUE_STR;
         }
      }
      return FALSE_STR;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(int value){
      return (value > 0) ? TRUE_STR : FALSE_STR;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(String value){
      return parse(value) ? TRUE_STR : FALSE_STR;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public final static String toString(Object value){
      if(value != null){
         Class<?> valueClass = value.getClass();
         if(valueClass == Boolean.class){
            if(((Boolean)value).booleanValue()){
               return TRUE_STR;
            }
         }else{
            return RBoolean.toString(value.toString());
         }
      }
      return FALSE_STR;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @param trueValue 真值
   // @param falseValue 假值
   // @return 字符串
   //============================================================
   public final static String toString(String value,
                                       String trueValue,
                                       String falseValue){
      return parse(value) ? trueValue : falseValue;
   }

   //============================================================
   // <T>获得布尔值的字符串。</T>
   //
   // @param value 内容
   // @param trueValue 真值
   // @param falseValue 假值
   // @return 字符串
   //============================================================
   public final static String toString(Object value,
                                       String trueValue,
                                       String falseValue){
      return parse(value) ? trueValue : falseValue;
   }
}
