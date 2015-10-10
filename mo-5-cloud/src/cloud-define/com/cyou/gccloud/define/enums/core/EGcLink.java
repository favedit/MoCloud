//============================================================
// <T>是否是外链新闻。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>是否是外链新闻枚举定义。</T>
//
// @enum
//============================================================
public class EGcLink
{
   // 枚举名称
   public final static String DefineName = "GcLink";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 内容
   public final static int Content = 1;

   // 内容字符串
   public final static String ContentString = "Content";

   // 内容标签
   public final static String ContentLabel = "内容";

   // 外链
   public final static int Link = 2;

   // 外链字符串
   public final static String LinkString = "Link";

   // 外链标签
   public final static String LinkLabel = "外链";

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
         case Content:
            return ContentString;
         case Link:
            return LinkString;
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
         case Content:
            return ContentLabel;
         case Link:
            return LinkLabel;
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
         case ContentString:
            return Content;
         case LinkString:
            return Link;
         default:
            return 0;
      }
   }
}
