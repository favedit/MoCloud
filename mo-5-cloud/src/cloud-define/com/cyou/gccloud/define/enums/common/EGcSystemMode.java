//============================================================
// <T>系统模式。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>系统模式枚举定义。</T>
//
// @enum
//============================================================
public class EGcSystemMode
{
   // 枚举名称
   public final static String DefineName = "GcSystemMode";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 正式
   public final static int Release = 1;

   // 正式字符串
   public final static String ReleaseString = "Release";

   // 正式标签
   public final static String ReleaseLabel = "正式";

   // 调试
   public final static int Debug = 2;

   // 调试字符串
   public final static String DebugString = "Debug";

   // 调试标签
   public final static String DebugLabel = "调试";

   // 测试
   public final static int Test = 3;

   // 测试字符串
   public final static String TestString = "Test";

   // 测试标签
   public final static String TestLabel = "测试";

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
         case Release:
            return ReleaseString;
         case Debug:
            return DebugString;
         case Test:
            return TestString;
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
         case Release:
            return ReleaseLabel;
         case Debug:
            return DebugLabel;
         case Test:
            return TestLabel;
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
         case ReleaseString:
            return Release;
         case DebugString:
            return Debug;
         case TestString:
            return Test;
         default:
            return 0;
      }
   }
}
