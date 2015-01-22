//============================================================
// <T>游戏适配。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>游戏适配枚举定义。</T>
//
// @enum
//============================================================
public class EGcAdapter
{
   // 枚举名称
   public final static String DefineName = "GcAdapter";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 苹果
   public final static int IOS = 1;

   // 苹果字符串
   public final static String IOSString = "IOS";

   // 苹果标签
   public final static String IOSLabel = "苹果";

   // 安卓
   public final static int Android = 2;

   // 安卓字符串
   public final static String AndroidString = "Android";

   // 安卓标签
   public final static String AndroidLabel = "安卓";

   // 网页
   public final static int HTML5 = 3;

   // 网页字符串
   public final static String HTML5String = "HTML5";

   // 网页标签
   public final static String HTML5Label = "网页";

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
         case IOS:
            return IOSString;
         case Android:
            return AndroidString;
         case HTML5:
            return HTML5String;
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
         case IOS:
            return IOSLabel;
         case Android:
            return AndroidLabel;
         case HTML5:
            return HTML5Label;
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
         case IOSString:
            return IOS;
         case AndroidString:
            return Android;
         case HTML5String:
            return HTML5;
         default:
            return 0;
      }
   }
}
