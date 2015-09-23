//============================================================
// <T>理财师客户关系类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.financial;

//============================================================
// <T>理财师客户关系类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcFinancialMemberRelation
{
   // 枚举名称
   public final static String DefineName = "GcFinancialMemberRelation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 关注
   public final static int Follow = 1;

   // 关注字符串
   public final static String FollowString = "Follow";

   // 关注标签
   public final static String FollowLabel = "关注";

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
         case Follow:
            return FollowString;
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
         case Follow:
            return FollowLabel;
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
         case FollowString:
            return Follow;
         default:
            return 0;
      }
   }
}
