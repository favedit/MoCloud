//============================================================
// <T>授权数据。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>授权数据枚举定义。</T>
//
// @enum
//============================================================
public class EGcAuthorityAccess
{
   // 枚举名称
   public final static String DefineName = "GcAuthorityAccess";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 允许
   public final static int Allow = 1;

   // 允许字符串
   public final static String AllowString = "Allow";

   // 允许标签
   public final static String AllowLabel = "允许";

   // 禁止
   public final static int Forbid = 2;

   // 禁止字符串
   public final static String ForbidString = "Forbid";

   // 禁止标签
   public final static String ForbidLabel = "禁止";

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
         case Allow:
            return AllowString;
         case Forbid:
            return ForbidString;
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
         case Allow:
            return AllowLabel;
         case Forbid:
            return ForbidLabel;
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
         case AllowString:
            return Allow;
         case ForbidString:
            return Forbid;
         default:
            return 0;
      }
   }
}
