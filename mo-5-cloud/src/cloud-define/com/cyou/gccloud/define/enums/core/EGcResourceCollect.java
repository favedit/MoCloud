//============================================================
// <T>资源收藏。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源收藏枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceCollect
{
   // 枚举名称
   public final static String DefineName = "GcResourceCollect";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 已收藏
   public final static int collected = 1;

   // 已收藏字符串
   public final static String collectedString = "collected";

   // 已收藏标签
   public final static String collectedLabel = "已收藏";

   // 未收藏
   public final static int Uncollect = 2;

   // 未收藏字符串
   public final static String UncollectString = "Uncollect";

   // 未收藏标签
   public final static String UncollectLabel = "未收藏";

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
         case collected:
            return collectedString;
         case Uncollect:
            return UncollectString;
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
         case collected:
            return collectedLabel;
         case Uncollect:
            return UncollectLabel;
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
         case collectedString:
            return collected;
         case UncollectString:
            return Uncollect;
         default:
            return 0;
      }
   }
}
