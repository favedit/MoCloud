//============================================================
// <T>人员用户来源。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员用户来源枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonUserFrom
{
   // 枚举名称
   public final static String DefineName = "GcPersonUserFrom";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 账号
   public final static int Passport = 1;

   // 账号字符串
   public final static String PassportString = "Passport";

   // 账号标签
   public final static String PassportLabel = "账号";

   // EAI-OA系统
   public final static int EaiOa = 2;

   // EAI-OA系统字符串
   public final static String EaiOaString = "EaiOa";

   // EAI-OA系统标签
   public final static String EaiOaLabel = "EAI-OA系统";

   // EAI-白名单
   public final static int EaiHost = 3;

   // EAI-白名单字符串
   public final static String EaiHostString = "EaiHost";

   // EAI-白名单标签
   public final static String EaiHostLabel = "EAI-白名单";

   // EAI-e租宝账号
   public final static int EaiEzubao = 4;

   // EAI-e租宝账号字符串
   public final static String EaiEzubaoString = "EaiEzubao";

   // EAI-e租宝账号标签
   public final static String EaiEzubaoLabel = "EAI-e租宝账号";

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
         case Passport:
            return PassportString;
         case EaiOa:
            return EaiOaString;
         case EaiHost:
            return EaiHostString;
         case EaiEzubao:
            return EaiEzubaoString;
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
         case Passport:
            return PassportLabel;
         case EaiOa:
            return EaiOaLabel;
         case EaiHost:
            return EaiHostLabel;
         case EaiEzubao:
            return EaiEzubaoLabel;
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
         case PassportString:
            return Passport;
         case EaiOaString:
            return EaiOa;
         case EaiHostString:
            return EaiHost;
         case EaiEzubaoString:
            return EaiEzubao;
         default:
            return 0;
      }
   }
}
