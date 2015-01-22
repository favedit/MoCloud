//============================================================
// <T>存储显示。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>存储显示枚举定义。</T>
//
// @enum
//============================================================
public class EGcStorageDisplay
{
   // 枚举名称
   public final static String DefineName = "GcStorageDisplay";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 列表
   public final static int List = 1;

   // 列表字符串
   public final static String ListString = "List";

   // 列表标签
   public final static String ListLabel = "列表";

   // 详细
   public final static int Detail = 2;

   // 详细字符串
   public final static String DetailString = "Detail";

   // 详细标签
   public final static String DetailLabel = "详细";

   // 缩略图列表
   public final static int ThumbList = 3;

   // 缩略图列表字符串
   public final static String ThumbListString = "ThumbList";

   // 缩略图列表标签
   public final static String ThumbListLabel = "缩略图列表";

   // 缩略图详细
   public final static int ThumbDetail = 4;

   // 缩略图详细字符串
   public final static String ThumbDetailString = "ThumbDetail";

   // 缩略图详细标签
   public final static String ThumbDetailLabel = "缩略图详细";

   // 全部
   public final static int All = 5;

   // 全部字符串
   public final static String AllString = "All";

   // 全部标签
   public final static String AllLabel = "全部";

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
         case List:
            return ListString;
         case Detail:
            return DetailString;
         case ThumbList:
            return ThumbListString;
         case ThumbDetail:
            return ThumbDetailString;
         case All:
            return AllString;
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
         case List:
            return ListLabel;
         case Detail:
            return DetailLabel;
         case ThumbList:
            return ThumbListLabel;
         case ThumbDetail:
            return ThumbDetailLabel;
         case All:
            return AllLabel;
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
         case ListString:
            return List;
         case DetailString:
            return Detail;
         case ThumbListString:
            return ThumbList;
         case ThumbDetailString:
            return ThumbDetail;
         case AllString:
            return All;
         default:
            return 0;
      }
   }
}
