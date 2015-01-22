//============================================================
// <T>职业级别。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>职业级别枚举定义。</T>
//
// @enum
//============================================================
public class EGcOccupationLevel
{
   // 枚举名称
   public final static String DefineName = "GcOccupationLevel";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 初级
   public final static int Elementary = 1;

   // 初级字符串
   public final static String ElementaryString = "Elementary";

   // 初级标签
   public final static String ElementaryLabel = "初级";

   // 高级
   public final static int Advanced = 2;

   // 高级字符串
   public final static String AdvancedString = "Advanced";

   // 高级标签
   public final static String AdvancedLabel = "高级";

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
         case Elementary:
            return ElementaryString;
         case Advanced:
            return AdvancedString;
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
         case Elementary:
            return ElementaryLabel;
         case Advanced:
            return AdvancedLabel;
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
         case ElementaryString:
            return Elementary;
         case AdvancedString:
            return Advanced;
         default:
            return 0;
      }
   }
}
