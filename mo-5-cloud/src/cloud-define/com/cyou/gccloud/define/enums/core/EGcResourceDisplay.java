//============================================================
// <T>资源展示。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源展示枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceDisplay
{
   // 枚举名称
   public final static String DefineName = "GcResourceDisplay";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 展示
   public final static int Enabled = 1;

   // 展示字符串
   public final static String EnabledString = "Enabled";

   // 未展示
   public final static int Disable = 2;

   // 未展示字符串
   public final static String DisableString = "Disable";

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
