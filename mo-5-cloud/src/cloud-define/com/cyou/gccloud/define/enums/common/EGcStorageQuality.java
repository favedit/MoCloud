//============================================================
// <T>存储品质。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>存储品质枚举定义。</T>
//
// @enum
//============================================================
public class EGcStorageQuality
{
   // 枚举名称
   public final static String DefineName = "GcStorageQuality";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 低
   public final static int Lower = 1;

   // 低字符串
   public final static String LowerString = "Lower";

   // 低标签
   public final static String LowerLabel = "低";

   // 中
   public final static int Middle = 2;

   // 中字符串
   public final static String MiddleString = "Middle";

   // 中标签
   public final static String MiddleLabel = "中";

   // 高
   public final static int High = 3;

   // 高字符串
   public final static String HighString = "High";

   // 高标签
   public final static String HighLabel = "高";

   // 全部
   public final static int All = 4;

   // 全部字符串
   public final static String AllString = "All";

   // 全部标签
   public final static String AllLabel = "全部";

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
         case Lower:
            return LowerString;
         case Middle:
            return MiddleString;
         case High:
            return HighString;
         case All:
            return AllString;
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
         case Lower:
            return LowerLabel;
         case Middle:
            return MiddleLabel;
         case High:
            return HighLabel;
         case All:
            return AllLabel;
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
         case LowerString:
            return Lower;
         case MiddleString:
            return Middle;
         case HighString:
            return High;
         case AllString:
            return All;
         default:
            return 0;
      }
   }
}
