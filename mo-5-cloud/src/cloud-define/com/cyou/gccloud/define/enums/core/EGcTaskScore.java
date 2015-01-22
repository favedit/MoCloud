//============================================================
// <T>任务分数。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>任务分数枚举定义。</T>
//
// @enum
//============================================================
public class EGcTaskScore
{
   // 枚举名称
   public final static String DefineName = "GcTaskScore";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 定义
   public final static int Define = 1;

   // 定义字符串
   public final static String DefineString = "Define";

   // 定义标签
   public final static String DefineLabel = "定义";

   // 调整
   public final static int Adjust = 2;

   // 调整字符串
   public final static String AdjustString = "Adjust";

   // 调整标签
   public final static String AdjustLabel = "调整";

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
         case Define:
            return DefineString;
         case Adjust:
            return AdjustString;
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
         case Define:
            return DefineLabel;
         case Adjust:
            return AdjustLabel;
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
         case DefineString:
            return Define;
         case AdjustString:
            return Adjust;
         default:
            return 0;
      }
   }
}
