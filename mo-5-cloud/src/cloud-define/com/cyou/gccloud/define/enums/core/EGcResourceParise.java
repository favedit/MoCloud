//============================================================
// <T>资源点赞。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源点赞枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceParise
{
   // 枚举名称
   public final static String DefineName = "GcResourceParise";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 点赞
   public final static int Praised = 1;

   // 点赞字符串
   public final static String PraisedString = "Praised";

   // 点赞标签
   public final static String PraisedLabel = "点赞";

   // 未点赞
   public final static int Unparise = 2;

   // 未点赞字符串
   public final static String UnpariseString = "Unparise";

   // 未点赞标签
   public final static String UnpariseLabel = "未点赞";

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
         case Praised:
            return PraisedString;
         case Unparise:
            return UnpariseString;
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
         case Praised:
            return PraisedLabel;
         case Unparise:
            return UnpariseLabel;
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
         case PraisedString:
            return Praised;
         case UnpariseString:
            return Unparise;
         default:
            return 0;
      }
   }
}
