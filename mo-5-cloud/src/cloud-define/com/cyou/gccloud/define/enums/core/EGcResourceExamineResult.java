//============================================================
// <T>资源审核结果类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源审核结果类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceExamineResult
{
   // 枚举名称
   public final static String DefineName = "GcResourceExamineResult";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 通过
   public final static int Pass = 1;

   // 通过字符串
   public final static String PassString = "Pass";

   // 通过标签
   public final static String PassLabel = "通过";

   // 未通过
   public final static int Nopass = 2;

   // 未通过字符串
   public final static String NopassString = "Nopass";

   // 未通过标签
   public final static String NopassLabel = "未通过";

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
         case Pass:
            return PassString;
         case Nopass:
            return NopassString;
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
         case Pass:
            return PassLabel;
         case Nopass:
            return NopassLabel;
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
         case PassString:
            return Pass;
         case NopassString:
            return Nopass;
         default:
            return 0;
      }
   }
}
