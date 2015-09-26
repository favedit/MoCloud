//============================================================
// <T>月收入。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>月收入枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonIncome
{
   // 枚举名称
   public final static String DefineName = "GcPersonIncome";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 5000以下
   public final static int LessThan5000 = 1;

   // 5000以下字符串
   public final static String LessThan5000String = "LessThan5000";

   // 5000以下标签
   public final static String LessThan5000Label = "5000以下";

   // 5000－10000
   public final static int In5000to10000 = 2;

   // 5000－10000字符串
   public final static String In5000to10000String = "In5000to10000";

   // 5000－10000标签
   public final static String In5000to10000Label = "5000－10000";

   // 10000－50000
   public final static int In10000to50000 = 3;

   // 10000－50000字符串
   public final static String In10000to50000String = "In10000to50000";

   // 10000－50000标签
   public final static String In10000to50000Label = "10000－50000";

   // 50000以上
   public final static int MoreThan50000 = 4;

   // 50000以上字符串
   public final static String MoreThan50000String = "MoreThan50000";

   // 50000以上标签
   public final static String MoreThan50000Label = "50000以上";

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
         case LessThan5000:
            return LessThan5000String;
         case In5000to10000:
            return In5000to10000String;
         case In10000to50000:
            return In10000to50000String;
         case MoreThan50000:
            return MoreThan50000String;
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
         case LessThan5000:
            return LessThan5000Label;
         case In5000to10000:
            return In5000to10000Label;
         case In10000to50000:
            return In10000to50000Label;
         case MoreThan50000:
            return MoreThan50000Label;
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
         case LessThan5000String:
            return LessThan5000;
         case In5000to10000String:
            return In5000to10000;
         case In10000to50000String:
            return In10000to50000;
         case MoreThan50000String:
            return MoreThan50000;
         default:
            return 0;
      }
   }
}
