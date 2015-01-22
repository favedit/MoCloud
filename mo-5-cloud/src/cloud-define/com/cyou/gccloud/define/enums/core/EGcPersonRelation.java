//============================================================
// <T>人员关系。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员关系枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonRelation
{
   // 枚举名称
   public final static String DefineName = "GcPersonRelation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 好友
   public final static int Friend = 1;

   // 好友字符串
   public final static String FriendString = "Friend";

   // 好友标签
   public final static String FriendLabel = "好友";

   // 跟随
   public final static int Follow = 2;

   // 跟随字符串
   public final static String FollowString = "Follow";

   // 跟随标签
   public final static String FollowLabel = "跟随";

   // 关注
   public final static int Attention = 3;

   // 关注字符串
   public final static String AttentionString = "Attention";

   // 关注标签
   public final static String AttentionLabel = "关注";

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
         case Friend:
            return FriendString;
         case Follow:
            return FollowString;
         case Attention:
            return AttentionString;
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
         case Friend:
            return FriendLabel;
         case Follow:
            return FollowLabel;
         case Attention:
            return AttentionLabel;
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
         case FriendString:
            return Friend;
         case FollowString:
            return Follow;
         case AttentionString:
            return Attention;
         default:
            return 0;
      }
   }
}
