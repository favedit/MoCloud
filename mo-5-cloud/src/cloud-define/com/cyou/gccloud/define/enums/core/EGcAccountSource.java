//============================================================
// <T>帐号来源。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>帐号来源枚举定义。</T>
//
// @enum
//============================================================
public class EGcAccountSource
{
   // 枚举名称
   public final static String DefineName = "GcAccountSource";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 游戏学院
   public final static int GameCollege = 1;

   // 游戏学院字符串
   public final static String GameCollegeString = "GameCollege";

   // 游戏学院标签
   public final static String GameCollegeLabel = "游戏学院";

   // GameMei
   public final static int GameMei = 2;

   // GameMei字符串
   public final static String GameMeiString = "GameMei";

   // GameMei标签
   public final static String GameMeiLabel = "GameMei";

   // 游戏学院XMPP用户
   public final static int GameCollegeXmpp = 3;

   // 游戏学院XMPP用户字符串
   public final static String GameCollegeXmppString = "GameCollegeXmpp";

   // 游戏学院XMPP用户标签
   public final static String GameCollegeXmppLabel = "游戏学院XMPP用户";

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
         case GameCollege:
            return GameCollegeString;
         case GameMei:
            return GameMeiString;
         case GameCollegeXmpp:
            return GameCollegeXmppString;
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
         case GameCollege:
            return GameCollegeLabel;
         case GameMei:
            return GameMeiLabel;
         case GameCollegeXmpp:
            return GameCollegeXmppLabel;
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
         case GameCollegeString:
            return GameCollege;
         case GameMeiString:
            return GameMei;
         case GameCollegeXmppString:
            return GameCollegeXmpp;
         default:
            return 0;
      }
   }
}
