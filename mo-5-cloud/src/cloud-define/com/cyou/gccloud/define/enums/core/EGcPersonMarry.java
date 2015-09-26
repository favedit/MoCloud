//============================================================
// <T>婚姻状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>婚姻状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonMarry
{
   // 枚举名称
   public final static String DefineName = "GcPersonMarry";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 已婚
   public final static int Married = 1;

   // 已婚字符串
   public final static String MarriedString = "Married";

   // 已婚标签
   public final static String MarriedLabel = "已婚";

   // 未婚
   public final static int Unmarried = 2;

   // 未婚字符串
   public final static String UnmarriedString = "Unmarried";

   // 未婚标签
   public final static String UnmarriedLabel = "未婚";

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
         case Married:
            return MarriedString;
         case Unmarried:
            return UnmarriedString;
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
         case Married:
            return MarriedLabel;
         case Unmarried:
            return UnmarriedLabel;
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
         case MarriedString:
            return Married;
         case UnmarriedString:
            return Unmarried;
         default:
            return 0;
      }
   }
}
