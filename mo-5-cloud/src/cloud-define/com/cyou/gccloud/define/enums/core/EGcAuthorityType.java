//============================================================
// <T>授权方式。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>授权方式枚举定义。</T>
//
// @enum
//============================================================
public class EGcAuthorityType
{
   // 枚举名称
   public final static String DefineName = "GcAuthorityType";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 永久
   public final static int Permanent = 1;

   // 永久字符串
   public final static String PermanentString = "Permanent";

   // 永久标签
   public final static String PermanentLabel = "永久";

   // 临时
   public final static int Temporary = 2;

   // 临时字符串
   public final static String TemporaryString = "Temporary";

   // 临时标签
   public final static String TemporaryLabel = "临时";

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
         case Permanent:
            return PermanentString;
         case Temporary:
            return TemporaryString;
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
         case Permanent:
            return PermanentLabel;
         case Temporary:
            return TemporaryLabel;
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
         case PermanentString:
            return Permanent;
         case TemporaryString:
            return Temporary;
         default:
            return 0;
      }
   }
}
