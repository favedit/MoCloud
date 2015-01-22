//============================================================
// <T>系统日志。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>系统日志枚举定义。</T>
//
// @enum
//============================================================
public class EGcSystemLogger
{
   // 枚举名称
   public final static String DefineName = "GcSystemLogger";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 调试
   public final static int Debug = 1;

   // 调试字符串
   public final static String DebugString = "Debug";

   // 调试标签
   public final static String DebugLabel = "调试";

   // 消息
   public final static int Info = 2;

   // 消息字符串
   public final static String InfoString = "Info";

   // 消息标签
   public final static String InfoLabel = "消息";

   // 警告
   public final static int Warn = 3;

   // 警告字符串
   public final static String WarnString = "Warn";

   // 警告标签
   public final static String WarnLabel = "警告";

   // 错误
   public final static int Error = 4;

   // 错误字符串
   public final static String ErrorString = "Error";

   // 错误标签
   public final static String ErrorLabel = "错误";

   // 例外
   public final static int Fatal = 5;

   // 例外字符串
   public final static String FatalString = "Fatal";

   // 例外标签
   public final static String FatalLabel = "例外";

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
         case Debug:
            return DebugString;
         case Info:
            return InfoString;
         case Warn:
            return WarnString;
         case Error:
            return ErrorString;
         case Fatal:
            return FatalString;
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
         case Debug:
            return DebugLabel;
         case Info:
            return InfoLabel;
         case Warn:
            return WarnLabel;
         case Error:
            return ErrorLabel;
         case Fatal:
            return FatalLabel;
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
         case DebugString:
            return Debug;
         case InfoString:
            return Info;
         case WarnString:
            return Warn;
         case ErrorString:
            return Error;
         case FatalString:
            return Fatal;
         default:
            return 0;
      }
   }
}
