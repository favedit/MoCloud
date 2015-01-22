//============================================================
// <T>学校类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>学校类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcSchool
{
   // 枚举名称
   public final static String DefineName = "GcSchool";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 小学
   public final static int Primary = 1;

   // 小学字符串
   public final static String PrimaryString = "Primary";

   // 小学标签
   public final static String PrimaryLabel = "小学";

   // 中学
   public final static int Middle = 2;

   // 中学字符串
   public final static String MiddleString = "Middle";

   // 中学标签
   public final static String MiddleLabel = "中学";

   // 大学
   public final static int College = 3;

   // 大学字符串
   public final static String CollegeString = "College";

   // 大学标签
   public final static String CollegeLabel = "大学";

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
         case Primary:
            return PrimaryString;
         case Middle:
            return MiddleString;
         case College:
            return CollegeString;
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
         case Primary:
            return PrimaryLabel;
         case Middle:
            return MiddleLabel;
         case College:
            return CollegeLabel;
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
         case PrimaryString:
            return Primary;
         case MiddleString:
            return Middle;
         case CollegeString:
            return College;
         default:
            return 0;
      }
   }
}
