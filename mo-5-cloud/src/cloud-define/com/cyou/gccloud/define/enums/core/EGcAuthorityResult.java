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

   // 成功
   public final static int Success = 1;

   // 成功字符串
   public final static String SuccessString = "Success";

   // 成功标签
   public final static String SuccessLabel = "成功";

   // 账号错误
   public final static int PassportInvalid = 2;

   // 账号错误字符串
   public final static String PassportInvalidString = "PassportInvalid";

   // 账号错误标签
   public final static String PassportInvalidLabel = "账号错误";

   // 密码错误
   public final static int PasswordInvalid = 3;

   // 密码错误字符串
   public final static String PasswordInvalidString = "PasswordInvalid";

   // 密码错误标签
   public final static String PasswordInvalidLabel = "密码错误";

   // 日期错误
   public final static int DateInvalid = 4;

   // 日期错误字符串
   public final static String DateInvalidString = "DateInvalid";

   // 日期错误标签
   public final static String DateInvalidLabel = "日期错误";

   // OA系统登录成功
   public final static int OaSuccess = 5;

   // OA系统登录成功字符串
   public final static String OaSuccessString = "OaSuccess";

   // OA系统登录成功标签
   public final static String OaSuccessLabel = "OA系统登录成功";

   // OA密码错误
   public final static int OaPasswordInvald = 6;

   // OA密码错误字符串
   public final static String OaPasswordInvaldString = "OaPasswordInvald";

   // OA密码错误标签
   public final static String OaPasswordInvaldLabel = "OA密码错误";

   // OA主机非法
   public final static int OaHostInvalid = 7;

   // OA主机非法字符串
   public final static String OaHostInvalidString = "OaHostInvalid";

   // OA主机非法标签
   public final static String OaHostInvalidLabel = "OA主机非法";

   // 用户名非法
   public final static int PassportIllegal = 8;

   // 用户名非法字符串
   public final static String PassportIllegalString = "PassportIllegal";

   // 用户名非法标签
   public final static String PassportIllegalLabel = "用户名非法";

   // 密码非法
   public final static int PasswordIllegal = 9;

   // 密码非法字符串
   public final static String PasswordIllegalString = "PasswordIllegal";

   // 密码非法标签
   public final static String PasswordIllegalLabel = "密码非法";

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
         case Success:
            return SuccessString;
         case PassportInvalid:
            return PassportInvalidString;
         case PasswordInvalid:
            return PasswordInvalidString;
         case DateInvalid:
            return DateInvalidString;
         case OaSuccess:
            return OaSuccessString;
         case OaPasswordInvald:
            return OaPasswordInvaldString;
         case OaHostInvalid:
            return OaHostInvalidString;
         case PassportIllegal:
            return PassportIllegalString;
         case PasswordIllegal:
            return PasswordIllegalString;
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
         case Success:
            return SuccessLabel;
         case PassportInvalid:
            return PassportInvalidLabel;
         case PasswordInvalid:
            return PasswordInvalidLabel;
         case DateInvalid:
            return DateInvalidLabel;
         case OaSuccess:
            return OaSuccessLabel;
         case OaPasswordInvald:
            return OaPasswordInvaldLabel;
         case OaHostInvalid:
            return OaHostInvalidLabel;
         case PassportIllegal:
            return PassportIllegalLabel;
         case PasswordIllegal:
            return PasswordIllegalLabel;
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
         case SuccessString:
            return Success;
         case PassportInvalidString:
            return PassportInvalid;
         case PasswordInvalidString:
            return PasswordInvalid;
         case DateInvalidString:
            return DateInvalid;
         case OaSuccessString:
            return OaSuccess;
         case OaPasswordInvaldString:
            return OaPasswordInvald;
         case OaHostInvalidString:
            return OaHostInvalid;
         case PassportIllegalString:
            return PassportIllegal;
         case PasswordIllegalString:
            return PasswordIllegal;
         default:
            return 0;
      }
   }
}
