//============================================================
// <T>资源评价。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源评价枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceEstimate
{
   // 枚举名称
   public final static String DefineName = "GcResourceEstimate";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 赞扬
   public final static int Praise = 1;

   // 赞扬字符串
   public final static String PraiseString = "Praise";

   // 赞扬标签
   public final static String PraiseLabel = "赞扬";

   // 批评
   public final static int Criticize = 2;

   // 批评字符串
   public final static String CriticizeString = "Criticize";

   // 批评标签
   public final static String CriticizeLabel = "批评";

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
         case Praise:
            return PraiseString;
         case Criticize:
            return CriticizeString;
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
         case Praise:
            return PraiseLabel;
         case Criticize:
            return CriticizeLabel;
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
         case PraiseString:
            return Praise;
         case CriticizeString:
            return Criticize;
         default:
            return 0;
      }
   }
}
