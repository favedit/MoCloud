//============================================================
// <T>人员性别。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员性别枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonGender
{
   // 枚举名称
   public final static String DefineName = "GcPersonGender";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 男
   public final static int Male = 1;

   // 男字符串
   public final static String MaleString = "Male";

   // 男标签
   public final static String MaleLabel = "男";

   // 女
   public final static int Female = 2;

   // 女字符串
   public final static String FemaleString = "Female";

   // 女标签
   public final static String FemaleLabel = "女";

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
         case Male:
            return MaleString;
         case Female:
            return FemaleString;
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
         case Male:
            return MaleLabel;
         case Female:
            return FemaleLabel;
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
         case MaleString:
            return Male;
         case FemaleString:
            return Female;
         default:
            return 0;
      }
   }
}
