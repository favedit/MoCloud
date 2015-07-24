//============================================================
// <T>授权结果。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>授权结果枚举定义。</T>
//
// @enum
//============================================================
public class EGcAuthorityResult
{
   // 枚举名称
   public final static String DefineName = "GcAuthorityResult";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 账号错误
   public final static int PassportInvalid = 1;

   // 账号错误字符串
   public final static String PassportInvalidString = "PassportInvalid";

   // 账号错误标签
   public final static String PassportInvalidLabel = "账号错误";

   // 密码错误
   public final static int PasswordInvalid = 2;

   // 密码错误字符串
   public final static String PasswordInvalidString = "PasswordInvalid";

   // 密码错误标签
   public final static String PasswordInvalidLabel = "密码错误";

   // 日期错误
   public final static int DateInvalid = 3;

   // 日期错误字符串
   public final static String DateInvalidString = "DateInvalid";

   // 日期错误标签
   public final static String DateInvalidLabel = "日期错误";

   // 成功
   public final static int Success = 4;

   // 成功字符串
   public final static String SuccessString = "Success";

   // 成功标签
   public final static String SuccessLabel = "成功";

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
         case PassportInvalid:
            return PassportInvalidString;
         case PasswordInvalid:
            return PasswordInvalidString;
         case DateInvalid:
            return DateInvalidString;
         case Success:
            return SuccessString;
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
         case PassportInvalid:
            return PassportInvalidLabel;
         case PasswordInvalid:
            return PasswordInvalidLabel;
         case DateInvalid:
            return DateInvalidLabel;
         case Success:
            return SuccessLabel;
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
         case PassportInvalidString:
            return PassportInvalid;
         case PasswordInvalidString:
            return PasswordInvalid;
         case DateInvalidString:
            return DateInvalid;
         case SuccessString:
            return Success;
         default:
            return 0;
      }
   }
}
