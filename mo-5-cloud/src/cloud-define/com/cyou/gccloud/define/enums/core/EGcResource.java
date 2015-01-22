//============================================================
// <T>资源类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcResource
{
   // 枚举名称
   public final static String DefineName = "GcResource";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 应用
   public final static int Application = 1;

   // 应用字符串
   public final static String ApplicationString = "Application";

   // 应用标签
   public final static String ApplicationLabel = "应用";

   // 资源
   public final static int Resource = 2;

   // 资源字符串
   public final static String ResourceString = "Resource";

   // 资源标签
   public final static String ResourceLabel = "资源";

   // 课程
   public final static int Lesson = 3;

   // 课程字符串
   public final static String LessonString = "Lesson";

   // 课程标签
   public final static String LessonLabel = "课程";

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
         case Application:
            return ApplicationString;
         case Resource:
            return ResourceString;
         case Lesson:
            return LessonString;
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
         case Application:
            return ApplicationLabel;
         case Resource:
            return ResourceLabel;
         case Lesson:
            return LessonLabel;
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
         case ApplicationString:
            return Application;
         case ResourceString:
            return Resource;
         case LessonString:
            return Lesson;
         default:
            return 0;
      }
   }
}
