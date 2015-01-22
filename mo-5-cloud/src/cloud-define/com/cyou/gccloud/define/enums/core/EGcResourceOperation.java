//============================================================
// <T>资源操作。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源操作枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceOperation
{
   // 枚举名称
   public final static String DefineName = "GcResourceOperation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 查看
   public final static int View = 1;

   // 查看字符串
   public final static String ViewString = "View";

   // 查看标签
   public final static String ViewLabel = "查看";

   // 播放
   public final static int Play = 2;

   // 播放字符串
   public final static String PlayString = "Play";

   // 播放标签
   public final static String PlayLabel = "播放";

   // 下载
   public final static int Download = 3;

   // 下载字符串
   public final static String DownloadString = "Download";

   // 下载标签
   public final static String DownloadLabel = "下载";

   // 评论
   public final static int Discuss = 4;

   // 评论字符串
   public final static String DiscussString = "Discuss";

   // 评论标签
   public final static String DiscussLabel = "评论";

   // 点赞
   public final static int Praise = 5;

   // 点赞字符串
   public final static String PraiseString = "Praise";

   // 点赞标签
   public final static String PraiseLabel = "点赞";

   // 分享
   public final static int Share = 6;

   // 分享字符串
   public final static String ShareString = "Share";

   // 分享标签
   public final static String ShareLabel = "分享";

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
         case View:
            return ViewString;
         case Play:
            return PlayString;
         case Download:
            return DownloadString;
         case Discuss:
            return DiscussString;
         case Praise:
            return PraiseString;
         case Share:
            return ShareString;
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
         case View:
            return ViewLabel;
         case Play:
            return PlayLabel;
         case Download:
            return DownloadLabel;
         case Discuss:
            return DiscussLabel;
         case Praise:
            return PraiseLabel;
         case Share:
            return ShareLabel;
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
         case ViewString:
            return View;
         case PlayString:
            return Play;
         case DownloadString:
            return Download;
         case DiscussString:
            return Discuss;
         case PraiseString:
            return Praise;
         case ShareString:
            return Share;
         default:
            return 0;
      }
   }
}
