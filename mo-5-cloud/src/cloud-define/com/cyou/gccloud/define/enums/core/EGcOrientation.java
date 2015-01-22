//============================================================
// <T>游戏方向。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>游戏方向枚举定义。</T>
//
// @enum
//============================================================
public class EGcOrientation
{
   // 枚举名称
   public final static String DefineName = "GcOrientation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 水平
   public final static int Horizontal = 1;

   // 水平字符串
   public final static String HorizontalString = "Horizontal";

   // 水平标签
   public final static String HorizontalLabel = "水平";

   // 垂直
   public final static int Vertical = 2;

   // 垂直字符串
   public final static String VerticalString = "Vertical";

   // 垂直标签
   public final static String VerticalLabel = "垂直";

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
         case Horizontal:
            return HorizontalString;
         case Vertical:
            return VerticalString;
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
         case Horizontal:
            return HorizontalLabel;
         case Vertical:
            return VerticalLabel;
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
         case HorizontalString:
            return Horizontal;
         case VerticalString:
            return Vertical;
         default:
            return 0;
      }
   }
}
