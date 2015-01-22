//============================================================
// <T>会话来源。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>会话来源枚举定义。</T>
//
// @enum
//============================================================
public class EGcSessionFrom
{
   // 枚举名称
   public final static String DefineName = "GcSessionFrom";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 浏览器
   public final static int Browser = 1;

   // 浏览器字符串
   public final static String BrowserString = "Browser";

   // 浏览器标签
   public final static String BrowserLabel = "浏览器";

   // 移动设备
   public final static int Mobile = 2;

   // 移动设备字符串
   public final static String MobileString = "Mobile";

   // 移动设备标签
   public final static String MobileLabel = "移动设备";

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
         case Browser:
            return BrowserString;
         case Mobile:
            return MobileString;
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
         case Browser:
            return BrowserLabel;
         case Mobile:
            return MobileLabel;
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
         case BrowserString:
            return Browser;
         case MobileString:
            return Mobile;
         default:
            return 0;
      }
   }
}
