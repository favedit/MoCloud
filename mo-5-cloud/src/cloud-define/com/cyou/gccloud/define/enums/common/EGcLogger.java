//============================================================
// <T>日志类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>日志类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcLogger
{
   // 枚举名称
   public final static String DefineName = "GcLogger";

   // 系统日志
   public final static int SystemLogger = 0;

   // 系统日志字符串
   public final static String SystemLoggerString = "SystemLogger";

   // 系统日志标签
   public final static String SystemLoggerLabel = "系统日志";

   // 系统例外
   public final static int SystemException = 1;

   // 系统例外字符串
   public final static String SystemExceptionString = "SystemException";

   // 系统例外标签
   public final static String SystemExceptionLabel = "系统例外";

   // 用户操作
   public final static int PersonOperation = 2;

   // 用户操作字符串
   public final static String PersonOperationString = "PersonOperation";

   // 用户操作标签
   public final static String PersonOperationLabel = "用户操作";

   // 用户活动
   public final static int PersonActivity = 3;

   // 用户活动字符串
   public final static String PersonActivityString = "PersonActivity";

   // 用户活动标签
   public final static String PersonActivityLabel = "用户活动";

   // 资源操作
   public final static int ResourceOperation = 4;

   // 资源操作字符串
   public final static String ResourceOperationString = "ResourceOperation";

   // 资源操作标签
   public final static String ResourceOperationLabel = "资源操作";

   // 未知
   public final static int Unknown = 5;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

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
         case SystemLogger:
            return SystemLoggerString;
         case SystemException:
            return SystemExceptionString;
         case PersonOperation:
            return PersonOperationString;
         case PersonActivity:
            return PersonActivityString;
         case ResourceOperation:
            return ResourceOperationString;
         case Unknown:
            return UnknownString;
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
         case SystemLogger:
            return SystemLoggerLabel;
         case SystemException:
            return SystemExceptionLabel;
         case PersonOperation:
            return PersonOperationLabel;
         case PersonActivity:
            return PersonActivityLabel;
         case ResourceOperation:
            return ResourceOperationLabel;
         case Unknown:
            return UnknownLabel;
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
         case SystemLoggerString:
            return SystemLogger;
         case SystemExceptionString:
            return SystemException;
         case PersonOperationString:
            return PersonOperation;
         case PersonActivityString:
            return PersonActivity;
         case ResourceOperationString:
            return ResourceOperation;
         case UnknownString:
            return Unknown;
         default:
            return 0;
      }
   }
}
