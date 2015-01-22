//============================================================
// <T>任务类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>任务类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcTaskType
{
   // 枚举名称
   public final static String DefineName = "GcTaskType";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 查看
   public final static int View = 1;

   // 查看字符串
   public final static String ViewString = "View";

   // 查看标签
   public final static String ViewLabel = "查看";

   // 播放
   public final static int Play = 2;

   // 播放字符串
   public final static String PlayString = "Play";

   // 播放标签
   public final static String PlayLabel = "播放";

   // 日常
   public final static int Daily = 3;

   // 日常字符串
   public final static String DailyString = "Daily";

   // 日常标签
   public final static String DailyLabel = "日常";

   // 审核
   public final static int Examine = 4;

   // 审核字符串
   public final static String ExamineString = "Examine";

   // 审核标签
   public final static String ExamineLabel = "审核";

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
         case View:
            return ViewString;
         case Play:
            return PlayString;
         case Daily:
            return DailyString;
         case Examine:
            return ExamineString;
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
         case View:
            return ViewLabel;
         case Play:
            return PlayLabel;
         case Daily:
            return DailyLabel;
         case Examine:
            return ExamineLabel;
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
         case ViewString:
            return View;
         case PlayString:
            return Play;
         case DailyString:
            return Daily;
         case ExamineString:
            return Examine;
         default:
            return 0;
      }
   }
}
