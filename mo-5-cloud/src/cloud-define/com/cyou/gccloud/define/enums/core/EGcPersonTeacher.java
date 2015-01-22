//============================================================
// <T>人员导师。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员导师枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonTeacher
{
   // 枚举名称
   public final static String DefineName = "GcPersonTeacher";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 普通
   public final static int Normal = 1;

   // 普通字符串
   public final static String NormalString = "Normal";

   // 普通标签
   public final static String NormalLabel = "普通";

   // 导师
   public final static int Teacher = 2;

   // 导师字符串
   public final static String TeacherString = "Teacher";

   // 导师标签
   public final static String TeacherLabel = "导师";

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
         case Normal:
            return NormalString;
         case Teacher:
            return TeacherString;
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
         case Normal:
            return NormalLabel;
         case Teacher:
            return TeacherLabel;
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
         case NormalString:
            return Normal;
         case TeacherString:
            return Teacher;
         default:
            return 0;
      }
   }
}
