//============================================================
// <T>任务分组。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>任务分组枚举定义。</T>
//
// @enum
//============================================================
public class EGcTaskGroup
{
   // 枚举名称
   public final static String DefineName = "GcTaskGroup";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 日常任务
   public final static int Daily = 1;

   // 日常任务字符串
   public final static String DailyString = "Daily";

   // 日常任务标签
   public final static String DailyLabel = "日常任务";

   // 审核任务
   public final static int Examine = 2;

   // 审核任务字符串
   public final static String ExamineString = "Examine";

   // 审核任务标签
   public final static String ExamineLabel = "审核任务";

   // 悬赏任务
   public final static int Reward = 3;

   // 悬赏任务字符串
   public final static String RewardString = "Reward";

   // 悬赏任务标签
   public final static String RewardLabel = "悬赏任务";

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
         case Daily:
            return DailyString;
         case Examine:
            return ExamineString;
         case Reward:
            return RewardString;
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
         case Daily:
            return DailyLabel;
         case Examine:
            return ExamineLabel;
         case Reward:
            return RewardLabel;
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
         case DailyString:
            return Daily;
         case ExamineString:
            return Examine;
         case RewardString:
            return Reward;
         default:
            return 0;
      }
   }
}
