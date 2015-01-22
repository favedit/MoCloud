//============================================================
// <T>技能。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>技能枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonSkill
{
   // 枚举名称
   public final static String DefineName = "GcPersonSkill";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 策划
   public final static int Plan = 1;

   // 策划字符串
   public final static String PlanString = "Plan";

   // 策划标签
   public final static String PlanLabel = "策划";

   // 美术
   public final static int Art = 2;

   // 美术字符串
   public final static String ArtString = "Art";

   // 美术标签
   public final static String ArtLabel = "美术";

   // 程序
   public final static int Procedure = 3;

   // 程序字符串
   public final static String ProcedureString = "Procedure";

   // 程序标签
   public final static String ProcedureLabel = "程序";

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
         case Plan:
            return PlanString;
         case Art:
            return ArtString;
         case Procedure:
            return ProcedureString;
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
         case Plan:
            return PlanLabel;
         case Art:
            return ArtLabel;
         case Procedure:
            return ProcedureLabel;
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
         case PlanString:
            return Plan;
         case ArtString:
            return Art;
         case ProcedureString:
            return Procedure;
         default:
            return 0;
      }
   }
}
