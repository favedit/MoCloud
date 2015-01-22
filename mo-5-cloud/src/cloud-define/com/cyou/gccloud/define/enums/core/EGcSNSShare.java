//============================================================
// <T>社交分享。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>社交分享枚举定义。</T>
//
// @enum
//============================================================
public class EGcSNSShare
{
   // 枚举名称
   public final static String DefineName = "GcSNSShare";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 移动QQ
   public final static int MQQ = 1;

   // 移动QQ字符串
   public final static String MQQString = "MQQ";

   // 移动QQ标签
   public final static String MQQLabel = "移动QQ";

   // QQ空间
   public final static int QQZone = 2;

   // QQ空间字符串
   public final static String QQZoneString = "QQZone";

   // QQ空间标签
   public final static String QQZoneLabel = "QQ空间";

   // 微信
   public final static int WX = 3;

   // 微信字符串
   public final static String WXString = "WX";

   // 微信标签
   public final static String WXLabel = "微信";

   // 微信朋友圈
   public final static int WXFriend = 4;

   // 微信朋友圈字符串
   public final static String WXFriendString = "WXFriend";

   // 微信朋友圈标签
   public final static String WXFriendLabel = "微信朋友圈";

   // 新浪微博
   public final static int SinaWeiBo = 5;

   // 新浪微博字符串
   public final static String SinaWeiBoString = "SinaWeiBo";

   // 新浪微博标签
   public final static String SinaWeiBoLabel = "新浪微博";

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
         case MQQ:
            return MQQString;
         case QQZone:
            return QQZoneString;
         case WX:
            return WXString;
         case WXFriend:
            return WXFriendString;
         case SinaWeiBo:
            return SinaWeiBoString;
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
         case MQQ:
            return MQQLabel;
         case QQZone:
            return QQZoneLabel;
         case WX:
            return WXLabel;
         case WXFriend:
            return WXFriendLabel;
         case SinaWeiBo:
            return SinaWeiBoLabel;
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
         case MQQString:
            return MQQ;
         case QQZoneString:
            return QQZone;
         case WXString:
            return WX;
         case WXFriendString:
            return WXFriend;
         case SinaWeiBoString:
            return SinaWeiBo;
         default:
            return 0;
      }
   }
}
