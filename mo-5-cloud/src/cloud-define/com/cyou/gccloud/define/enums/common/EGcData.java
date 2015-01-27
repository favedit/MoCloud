//============================================================
// <T>数据类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>数据类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcData
{
   // 枚举名称
   public final static String DefineName = "GcData";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 8位有符号整数
   public final static int Int8 = 1;

   // 8位有符号整数字符串
   public final static String Int8String = "Int8";

   // 8位有符号整数标签
   public final static String Int8Label = "8位有符号整数";

   // 16位有符号整数
   public final static int Int16 = 2;

   // 16位有符号整数字符串
   public final static String Int16String = "Int16";

   // 16位有符号整数标签
   public final static String Int16Label = "16位有符号整数";

   // 32位有符号整数
   public final static int Int32 = 3;

   // 32位有符号整数字符串
   public final static String Int32String = "Int32";

   // 32位有符号整数标签
   public final static String Int32Label = "32位有符号整数";

   // 64位有符号整数
   public final static int Int64 = 4;

   // 64位有符号整数字符串
   public final static String Int64String = "Int64";

   // 64位有符号整数标签
   public final static String Int64Label = "64位有符号整数";

   // 8位无符号整数
   public final static int Uint8 = 5;

   // 8位无符号整数字符串
   public final static String Uint8String = "Uint8";

   // 8位无符号整数标签
   public final static String Uint8Label = "8位无符号整数";

   // 16位无符号整数
   public final static int Uint16 = 6;

   // 16位无符号整数字符串
   public final static String Uint16String = "Uint16";

   // 16位无符号整数标签
   public final static String Uint16Label = "16位无符号整数";

   // 32位无符号整数
   public final static int Uint32 = 7;

   // 32位无符号整数字符串
   public final static String Uint32String = "Uint32";

   // 32位无符号整数标签
   public final static String Uint32Label = "32位无符号整数";

   // 64位无符号整数
   public final static int Uint64 = 8;

   // 64位无符号整数字符串
   public final static String Uint64String = "Uint64";

   // 64位无符号整数标签
   public final static String Uint64Label = "64位无符号整数";

   // 32位浮点数
   public final static int Float = 9;

   // 32位浮点数字符串
   public final static String FloatString = "Float";

   // 32位浮点数标签
   public final static String FloatLabel = "32位浮点数";

   // 64位双精度浮点数
   public final static int Double = 10;

   // 64位双精度浮点数字符串
   public final static String DoubleString = "Double";

   // 64位双精度浮点数标签
   public final static String DoubleLabel = "64位双精度浮点数";

   // 字符串
   public final static int String = 11;

   // 字符串字符串
   public final static String StringString = "String";

   // 字符串标签
   public final static String StringLabel = "字符串";

   //============================================================
   // <T>是否含有指定内容</T>
   //
   // @param value 内容
   // @return 是否含有
   //============================================================
   public static boolean contains(int value){
      String result = format(value);
      return !result.equals("Unknown");
   }

   //============================================================
   // <T>是否含有指定内容</T>
   //
   // @param value 内容
   // @return 是否含有
   //============================================================
   public static boolean contains(String value){
      int result = parse(value);
      return (result != 0);
   }

   //============================================================
   // <T>格式化数字为字符串。<T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public static String format(int value){
      switch(value){
         case Unknown:
            return UnknownString;
         case Int8:
            return Int8String;
         case Int16:
            return Int16String;
         case Int32:
            return Int32String;
         case Int64:
            return Int64String;
         case Uint8:
            return Uint8String;
         case Uint16:
            return Uint16String;
         case Uint32:
            return Uint32String;
         case Uint64:
            return Uint64String;
         case Float:
            return FloatString;
         case Double:
            return DoubleString;
         case String:
            return StringString;
         default:
            return "Unknown";
      }
   }

   //============================================================
   // <T>格式化数字为字符串。<T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public static String formatLabel(int value){
      switch(value){
         case Unknown:
            return UnknownLabel;
         case Int8:
            return Int8Label;
         case Int16:
            return Int16Label;
         case Int32:
            return Int32Label;
         case Int64:
            return Int64Label;
         case Uint8:
            return Uint8Label;
         case Uint16:
            return Uint16Label;
         case Uint32:
            return Uint32Label;
         case Uint64:
            return Uint64Label;
         case Float:
            return FloatLabel;
         case Double:
            return DoubleLabel;
         case String:
            return StringLabel;
         default:
            return "Unknown";
      }
   }

   //============================================================
   // <T>解析数字为字符串</T>
   //
   // @param value 内容
   // @return 字符串
   //============================================================
   public static int parse(String value){
      switch(value){
         case UnknownString:
            return Unknown;
         case Int8String:
            return Int8;
         case Int16String:
            return Int16;
         case Int32String:
            return Int32;
         case Int64String:
            return Int64;
         case Uint8String:
            return Uint8;
         case Uint16String:
            return Uint16;
         case Uint32String:
            return Uint32;
         case Uint64String:
            return Uint64;
         case FloatString:
            return Float;
         case DoubleString:
            return Double;
         case StringString:
            return String;
         default:
            return 0;
      }
   }
}
