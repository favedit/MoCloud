//============================================================
// <T>人员权限。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员权限枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonSecurity
{
   // 枚举名称
   public final static String DefineName = "GcPersonSecurity";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 仅自己可见
   public final static int Self = 1;

   // 仅自己可见字符串
   public final static String SelfString = "Self";

   // 仅自己可见标签
   public final static String SelfLabel = "仅自己可见";

   // 自己的好友可见
   public final static int Friend = 2;

   // 自己的好友可见字符串
   public final static String FriendString = "Friend";

   // 自己的好友可见标签
   public final static String FriendLabel = "自己的好友可见";

   // 全部关注者可见
   public final static int Attention = 3;

   // 全部关注者可见字符串
   public final static String AttentionString = "Attention";

   // 全部关注者可见标签
   public final static String AttentionLabel = "全部关注者可见";

   // 全部可见
   public final static int All = 4;

   // 全部可见字符串
   public final static String AllString = "All";

   // 全部可见标签
   public final static String AllLabel = "全部可见";

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
         case Self:
            return SelfString;
         case Friend:
            return FriendString;
         case Attention:
            return AttentionString;
         case All:
            return AllString;
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
         case Self:
            return SelfLabel;
         case Friend:
            return FriendLabel;
         case Attention:
            return AttentionLabel;
         case All:
            return AllLabel;
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
         case SelfString:
            return Self;
         case FriendString:
            return Friend;
         case AttentionString:
            return Attention;
         case AllString:
            return All;
         default:
            return 0;
      }
   }
}
