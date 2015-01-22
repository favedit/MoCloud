//============================================================
// <T>人员操作。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员操作枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonOperation
{
   // 枚举名称
   public final static String DefineName = "GcPersonOperation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 登录
   public final static int Login = 1;

   // 登录字符串
   public final static String LoginString = "Login";

   // 登录标签
   public final static String LoginLabel = "登录";

   // 登出
   public final static int Logout = 2;

   // 登出字符串
   public final static String LogoutString = "Logout";

   // 登出标签
   public final static String LogoutLabel = "登出";

   // 分享
   public final static int Share = 3;

   // 分享字符串
   public final static String ShareString = "Share";

   // 分享标签
   public final static String ShareLabel = "分享";

   // 玩游戏
   public final static int Play = 4;

   // 玩游戏字符串
   public final static String PlayString = "Play";

   // 玩游戏标签
   public final static String PlayLabel = "玩游戏";

   // 发表评论
   public final static int Discuss = 5;

   // 发表评论字符串
   public final static String DiscussString = "Discuss";

   // 发表评论标签
   public final static String DiscussLabel = "发表评论";

   // 邀请好友
   public final static int Invite = 6;

   // 邀请好友字符串
   public final static String InviteString = "Invite";

   // 邀请好友标签
   public final static String InviteLabel = "邀请好友";

   // 点赞
   public final static int Praise = 7;

   // 点赞字符串
   public final static String PraiseString = "Praise";

   // 点赞标签
   public final static String PraiseLabel = "点赞";

   // 注册
   public final static int Register = 8;

   // 注册字符串
   public final static String RegisterString = "Register";

   // 注册标签
   public final static String RegisterLabel = "注册";

   // 注销
   public final static int Unregister = 9;

   // 注销字符串
   public final static String UnregisterString = "Unregister";

   // 注销标签
   public final static String UnregisterLabel = "注销";

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
         case Login:
            return LoginString;
         case Logout:
            return LogoutString;
         case Share:
            return ShareString;
         case Play:
            return PlayString;
         case Discuss:
            return DiscussString;
         case Invite:
            return InviteString;
         case Praise:
            return PraiseString;
         case Register:
            return RegisterString;
         case Unregister:
            return UnregisterString;
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
         case Login:
            return LoginLabel;
         case Logout:
            return LogoutLabel;
         case Share:
            return ShareLabel;
         case Play:
            return PlayLabel;
         case Discuss:
            return DiscussLabel;
         case Invite:
            return InviteLabel;
         case Praise:
            return PraiseLabel;
         case Register:
            return RegisterLabel;
         case Unregister:
            return UnregisterLabel;
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
         case LoginString:
            return Login;
         case LogoutString:
            return Logout;
         case ShareString:
            return Share;
         case PlayString:
            return Play;
         case DiscussString:
            return Discuss;
         case InviteString:
            return Invite;
         case PraiseString:
            return Praise;
         case RegisterString:
            return Register;
         case UnregisterString:
            return Unregister;
         default:
            return 0;
      }
   }
}
