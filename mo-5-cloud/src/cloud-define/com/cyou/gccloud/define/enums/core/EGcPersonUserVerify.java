//============================================================
// <T>人员用户验证。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员用户验证枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonUserVerify
{
   // 枚举名称
   public final static String DefineName = "GcPersonUserVerify";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 无效
   public final static int Invalid = 1;

   // 无效字符串
   public final static String InvalidString = "Invalid";

   // 无效标签
   public final static String InvalidLabel = "无效";

   // 有效
   public final static int Valid = 2;

   // 有效字符串
   public final static String ValidString = "Valid";

   // 有效标签
   public final static String ValidLabel = "有效";

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
         case Invalid:
            return InvalidString;
         case Valid:
            return ValidString;
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
         case Invalid:
            return InvalidLabel;
         case Valid:
            return ValidLabel;
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
         case InvalidString:
            return Invalid;
         case ValidString:
            return Valid;
         default:
            return 0;
      }
   }
}
