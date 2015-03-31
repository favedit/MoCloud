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
public class EGcAccountFrom
{
   // 枚举名称
   public final static String DefineName = "GcAccountFrom";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 服务
   public final static int Service = 1;

   // 服务字符串
   public final static String ServiceString = "Service";

   // 服务标签
   public final static String ServiceLabel = "服务";

   // 网页站点
   public final static int Web = 2;

   // 网页站点字符串
   public final static String WebString = "Web";

   // 网页站点标签
   public final static String WebLabel = "网页站点";

   // 移动设备
   public final static int Mobile = 3;

   // 移动设备字符串
   public final static String MobileString = "Mobile";

   // 移动设备标签
   public final static String MobileLabel = "移动设备";

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
         case Service:
            return ServiceString;
         case Web:
            return WebString;
         case Mobile:
            return MobileString;
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
         case Service:
            return ServiceLabel;
         case Web:
            return WebLabel;
         case Mobile:
            return MobileLabel;
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
         case ServiceString:
            return Service;
         case WebString:
            return Web;
         case MobileString:
            return Mobile;
         default:
            return 0;
      }
   }
}
