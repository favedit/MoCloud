//============================================================
// <T>邀请。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>邀请枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonInvite
{
   // 枚举名称
   public final static String DefineName = "GcPersonInvite";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 短信
   public final static int SMS = 1;

   // 短信字符串
   public final static String SMSString = "SMS";

   // 短信标签
   public final static String SMSLabel = "短信";

   // 邮箱
   public final static int Mail = 2;

   // 邮箱字符串
   public final static String MailString = "Mail";

   // 邮箱标签
   public final static String MailLabel = "邮箱";

   // 微信
   public final static int WeiXin = 3;

   // 微信字符串
   public final static String WeiXinString = "WeiXin";

   // 微信标签
   public final static String WeiXinLabel = "微信";

   // 微信朋友圈
   public final static int WeiXinFriend = 4;

   // 微信朋友圈字符串
   public final static String WeiXinFriendString = "WeiXinFriend";

   // 微信朋友圈标签
   public final static String WeiXinFriendLabel = "微信朋友圈";

   // 移动QQ
   public final static int MobileQQ = 5;

   // 移动QQ字符串
   public final static String MobileQQString = "MobileQQ";

   // 移动QQ标签
   public final static String MobileQQLabel = "移动QQ";

   // QQ空间
   public final static int QQZone = 6;

   // QQ空间字符串
   public final static String QQZoneString = "QQZone";

   // QQ空间标签
   public final static String QQZoneLabel = "QQ空间";

   // 新浪微博
   public final static int SinaWeiBo = 7;

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
         case SMS:
            return SMSString;
         case Mail:
            return MailString;
         case WeiXin:
            return WeiXinString;
         case WeiXinFriend:
            return WeiXinFriendString;
         case MobileQQ:
            return MobileQQString;
         case QQZone:
            return QQZoneString;
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
         case SMS:
            return SMSLabel;
         case Mail:
            return MailLabel;
         case WeiXin:
            return WeiXinLabel;
         case WeiXinFriend:
            return WeiXinFriendLabel;
         case MobileQQ:
            return MobileQQLabel;
         case QQZone:
            return QQZoneLabel;
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
         case SMSString:
            return SMS;
         case MailString:
            return Mail;
         case WeiXinString:
            return WeiXin;
         case WeiXinFriendString:
            return WeiXinFriend;
         case MobileQQString:
            return MobileQQ;
         case QQZoneString:
            return QQZone;
         case SinaWeiBoString:
            return SinaWeiBo;
         default:
            return 0;
      }
   }
}
