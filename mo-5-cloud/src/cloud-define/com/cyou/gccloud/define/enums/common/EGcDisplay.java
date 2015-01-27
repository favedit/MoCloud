//============================================================
// <T>显示。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>显示枚举定义。</T>
//
// @enum
//============================================================
public class EGcDisplay
{
   // 枚举名称
   public final static String DefineName = "GcDisplay";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 展示
   public final static int Enabled = 1;

   // 展示字符串
   public final static String EnabledString = "Enabled";

   // 展示标签
   public final static String EnabledLabel = "展示";

   // 未展示
   public final static int Disable = 2;

   // 未展示字符串
   public final static String DisableString = "Disable";

   // 未展示标签
   public final static String DisableLabel = "未展示";

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
         case Enabled:
            return EnabledString;
         case Disable:
            return DisableString;
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
         case Enabled:
            return EnabledLabel;
         case Disable:
            return DisableLabel;
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
         case EnabledString:
            return Enabled;
         case DisableString:
            return Disable;
         default:
            return 0;
      }
   }
}
