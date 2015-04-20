//============================================================
// <T>资源分享类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源分享类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceShare
{
   // 枚举名称
   public final static String DefineName = "GcResourceShare";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 私有
   public final static int Private = 1;

   // 私有字符串
   public final static String PrivateString = "Private";

   // 私有标签
   public final static String PrivateLabel = "私有";

   // 团队
   public final static int Team = 2;

   // 团队字符串
   public final static String TeamString = "Team";

   // 团队标签
   public final static String TeamLabel = "团队";

   // 公开
   public final static int Public = 3;

   // 公开字符串
   public final static String PublicString = "Public";

   // 公开标签
   public final static String PublicLabel = "公开";

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
         case Private:
            return PrivateString;
         case Team:
            return TeamString;
         case Public:
            return PublicString;
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
         case Private:
            return PrivateLabel;
         case Team:
            return TeamLabel;
         case Public:
            return PublicLabel;
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
         case PrivateString:
            return Private;
         case TeamString:
            return Team;
         case PublicString:
            return Public;
         default:
            return 0;
      }
   }
}
