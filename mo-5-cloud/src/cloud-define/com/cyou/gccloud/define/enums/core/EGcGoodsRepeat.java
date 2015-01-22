//============================================================
// <T>商品重复。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>商品重复枚举定义。</T>
//
// @enum
//============================================================
public class EGcGoodsRepeat
{
   // 枚举名称
   public final static String DefineName = "GcGoodsRepeat";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 单次
   public final static int Single = 1;

   // 单次字符串
   public final static String SingleString = "Single";

   // 单次标签
   public final static String SingleLabel = "单次";

   // 订制
   public final static int Custom = 2;

   // 订制字符串
   public final static String CustomString = "Custom";

   // 订制标签
   public final static String CustomLabel = "订制";

   // 无限
   public final static int Forever = 3;

   // 无限字符串
   public final static String ForeverString = "Forever";

   // 无限标签
   public final static String ForeverLabel = "无限";

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
         case Single:
            return SingleString;
         case Custom:
            return CustomString;
         case Forever:
            return ForeverString;
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
         case Single:
            return SingleLabel;
         case Custom:
            return CustomLabel;
         case Forever:
            return ForeverLabel;
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
         case SingleString:
            return Single;
         case CustomString:
            return Custom;
         case ForeverString:
            return Forever;
         default:
            return 0;
      }
   }
}
