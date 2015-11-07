//============================================================
// <T>是否有效。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>是否有效枚举定义。</T>
//
// @enum
//============================================================
public class EGcValid
{
   // 枚举名称
   public final static String DefineName = "GcValid";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 有效
   public final static int Valid = 1;

   // 有效字符串
   public final static String ValidString = "Valid";

   // 有效标签
   public final static String ValidLabel = "有效";

   // 无效
   public final static int Nullity = 2;

   // 无效字符串
   public final static String NullityString = "Nullity";

   // 无效标签
   public final static String NullityLabel = "无效";

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
         case Valid:
            return ValidString;
         case Nullity:
            return NullityString;
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
         case Valid:
            return ValidLabel;
         case Nullity:
            return NullityLabel;
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
         case ValidString:
            return Valid;
         case NullityString:
            return Nullity;
         default:
            return 0;
      }
   }
}
