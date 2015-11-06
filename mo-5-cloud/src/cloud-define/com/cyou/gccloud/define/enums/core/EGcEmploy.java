//============================================================
// <T>是否雇佣。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>是否雇佣枚举定义。</T>
//
// @enum
//============================================================
public class EGcEmploy
{
   // 枚举名称
   public final static String DefineName = "GcEmploy";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 在职
   public final static int Incumbency = 1;

   // 在职字符串
   public final static String IncumbencyString = "Incumbency";

   // 在职标签
   public final static String IncumbencyLabel = "在职";

   // 离职
   public final static int Leave = 2;

   // 离职字符串
   public final static String LeaveString = "Leave";

   // 离职标签
   public final static String LeaveLabel = "离职";

   // 待定
   public final static int Undetermined = 3;

   // 待定字符串
   public final static String UndeterminedString = "Undetermined";

   // 待定标签
   public final static String UndeterminedLabel = "待定";

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
         case Incumbency:
            return IncumbencyString;
         case Leave:
            return LeaveString;
         case Undetermined:
            return UndeterminedString;
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
         case Incumbency:
            return IncumbencyLabel;
         case Leave:
            return LeaveLabel;
         case Undetermined:
            return UndeterminedLabel;
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
         case IncumbencyString:
            return Incumbency;
         case LeaveString:
            return Leave;
         case UndeterminedString:
            return Undetermined;
         default:
            return 0;
      }
   }
}
