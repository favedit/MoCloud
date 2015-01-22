//============================================================
// <T>存储状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>存储状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcBatchStorageStatus
{
   // 枚举名称
   public final static String DefineName = "GcBatchStorageStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 成功
   public final static int Success = 1;

   // 成功字符串
   public final static String SuccessString = "Success";

   // 成功标签
   public final static String SuccessLabel = "成功";

   // 失败
   public final static int Failure = 2;

   // 失败字符串
   public final static String FailureString = "Failure";

   // 失败标签
   public final static String FailureLabel = "失败";

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
         case Success:
            return SuccessString;
         case Failure:
            return FailureString;
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
         case Success:
            return SuccessLabel;
         case Failure:
            return FailureLabel;
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
         case SuccessString:
            return Success;
         case FailureString:
            return Failure;
         default:
            return 0;
      }
   }
}
