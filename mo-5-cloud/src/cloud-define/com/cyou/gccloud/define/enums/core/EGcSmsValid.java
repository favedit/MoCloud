//============================================================
// <T>短信认证。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>短信认证枚举定义。</T>
//
// @enum
//============================================================
public class EGcSmsValid
{
   // 枚举名称
   public final static String DefineName = "GcSmsValid";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 注册
   public final static int Register = 1;

   // 注册字符串
   public final static String RegisterString = "Register";

   // 注册标签
   public final static String RegisterLabel = "注册";

   // 修改手机号
   public final static int ChangeCheck = 2;

   // 修改手机号字符串
   public final static String ChangeCheckString = "ChangeCheck";

   // 修改手机号标签
   public final static String ChangeCheckLabel = "修改手机号";

   // 忘记密码
   public final static int ForgetPass = 3;

   // 忘记密码字符串
   public final static String ForgetPassString = "ForgetPass";

   // 忘记密码标签
   public final static String ForgetPassLabel = "忘记密码";

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
         case Register:
            return RegisterString;
         case ChangeCheck:
            return ChangeCheckString;
         case ForgetPass:
            return ForgetPassString;
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
         case Register:
            return RegisterLabel;
         case ChangeCheck:
            return ChangeCheckLabel;
         case ForgetPass:
            return ForgetPassLabel;
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
         case RegisterString:
            return Register;
         case ChangeCheckString:
            return ChangeCheck;
         case ForgetPassString:
            return ForgetPass;
         default:
            return 0;
      }
   }
}
