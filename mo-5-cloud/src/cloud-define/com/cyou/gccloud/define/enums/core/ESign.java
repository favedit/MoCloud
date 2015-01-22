//============================================================
// <T>签到。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>签到枚举定义。</T>
//
// @enum
//============================================================
public class ESign
{
   // 枚举名称
   public final static String DefineName = "Sign";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 签到
   public final static int Signup = 1;

   // 签到字符串
   public final static String SignupString = "Signup";

   // 未签到
   public final static int Unsignup = 2;

   // 未签到字符串
   public final static String UnsignupString = "Unsignup";

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
         case Signup:
            return SignupString;
         case Unsignup:
            return UnsignupString;
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
         case SignupString:
            return Signup;
         case UnsignupString:
            return Unsignup;
         default:
            return 0;
      }
   }
}
