//============================================================
// <T>状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcStatus
{
   // 枚举名称
   public final static String DefineName = "GcStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 活动
   public final static int Active = 1;

   // 活动字符串
   public final static String ActiveString = "Active";

   // 活动标签
   public final static String ActiveLabel = "活动";

   // 未活动
   public final static int Unactive = 2;

   // 未活动字符串
   public final static String UnactiveString = "Unactive";

   // 未活动标签
   public final static String UnactiveLabel = "未活动";

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
         case Active:
            return ActiveString;
         case Unactive:
            return UnactiveString;
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
         case Active:
            return ActiveLabel;
         case Unactive:
            return UnactiveLabel;
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
         case ActiveString:
            return Active;
         case UnactiveString:
            return Unactive;
         default:
            return 0;
      }
   }
}
