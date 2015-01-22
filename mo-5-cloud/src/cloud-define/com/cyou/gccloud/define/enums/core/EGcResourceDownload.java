//============================================================
// <T>资源下载。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源下载枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceDownload
{
   // 枚举名称
   public final static String DefineName = "GcResourceDownload";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 开始
   public final static int Begin = 1;

   // 开始字符串
   public final static String BeginString = "Begin";

   // 开始标签
   public final static String BeginLabel = "开始";

   // 完成
   public final static int Finish = 2;

   // 完成字符串
   public final static String FinishString = "Finish";

   // 完成标签
   public final static String FinishLabel = "完成";

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
         case Begin:
            return BeginString;
         case Finish:
            return FinishString;
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
         case Begin:
            return BeginLabel;
         case Finish:
            return FinishLabel;
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
         case BeginString:
            return Begin;
         case FinishString:
            return Finish;
         default:
            return 0;
      }
   }
}
