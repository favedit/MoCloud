//============================================================
// <T>资源投票。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源投票枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceVote
{
   // 枚举名称
   public final static String DefineName = "GcResourceVote";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 投票
   public final static int Voted = 1;

   // 投票字符串
   public final static String VotedString = "Voted";

   // 投票标签
   public final static String VotedLabel = "投票";

   // 未投票
   public final static int Unvote = 2;

   // 未投票字符串
   public final static String UnvoteString = "Unvote";

   // 未投票标签
   public final static String UnvoteLabel = "未投票";

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
         case Voted:
            return VotedString;
         case Unvote:
            return UnvoteString;
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
         case Voted:
            return VotedLabel;
         case Unvote:
            return UnvoteLabel;
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
         case VotedString:
            return Voted;
         case UnvoteString:
            return Unvote;
         default:
            return 0;
      }
   }
}
