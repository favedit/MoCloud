//============================================================
// <T>用户活动操作。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>用户活动操作枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonActivityOperation
{
   // 枚举名称
   public final static String DefineName = "GcPersonActivityOperation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 参加
   public final static int Join = 1;

   // 参加字符串
   public final static String JoinString = "Join";

   // 参加标签
   public final static String JoinLabel = "参加";

   // 提交
   public final static int Submit = 2;

   // 提交字符串
   public final static String SubmitString = "Submit";

   // 提交标签
   public final static String SubmitLabel = "提交";

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
         case Join:
            return JoinString;
         case Submit:
            return SubmitString;
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
         case Join:
            return JoinLabel;
         case Submit:
            return SubmitLabel;
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
         case JoinString:
            return Join;
         case SubmitString:
            return Submit;
         default:
            return 0;
      }
   }
}
