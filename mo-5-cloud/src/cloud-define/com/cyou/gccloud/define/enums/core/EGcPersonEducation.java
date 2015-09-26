//============================================================
// <T>教育。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>教育枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonEducation
{
   // 枚举名称
   public final static String DefineName = "GcPersonEducation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 高中以下
   public final static int HighschoolLess = 1;

   // 高中以下字符串
   public final static String HighschoolLessString = "HighschoolLess";

   // 高中以下标签
   public final static String HighschoolLessLabel = "高中以下";

   // 大专或本科
   public final static int CollegeOrBachelor = 2;

   // 大专或本科字符串
   public final static String CollegeOrBachelorString = "CollegeOrBachelor";

   // 大专或本科标签
   public final static String CollegeOrBachelorLabel = "大专或本科";

   // 硕士或硕士以上
   public final static int MasterOrMasterUp = 3;

   // 硕士或硕士以上字符串
   public final static String MasterOrMasterUpString = "MasterOrMasterUp";

   // 硕士或硕士以上标签
   public final static String MasterOrMasterUpLabel = "硕士或硕士以上";

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
         case HighschoolLess:
            return HighschoolLessString;
         case CollegeOrBachelor:
            return CollegeOrBachelorString;
         case MasterOrMasterUp:
            return MasterOrMasterUpString;
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
         case HighschoolLess:
            return HighschoolLessLabel;
         case CollegeOrBachelor:
            return CollegeOrBachelorLabel;
         case MasterOrMasterUp:
            return MasterOrMasterUpLabel;
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
         case HighschoolLessString:
            return HighschoolLess;
         case CollegeOrBachelorString:
            return CollegeOrBachelor;
         case MasterOrMasterUpString:
            return MasterOrMasterUp;
         default:
            return 0;
      }
   }
}
