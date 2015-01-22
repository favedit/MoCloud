//============================================================
// <T>用户。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.notify;

//============================================================
// <T>用户枚举定义。</T>
//
// @enum
//============================================================
public class EGnPerson
{
   // 枚举名称
   public final static String DefineName = "GnPerson";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 用户已存在
   public final static int Exists = 1;

   // 用户已存在字符串
   public final static String ExistsString = "Exists";

   // 用户已存在标签
   public final static String ExistsLabel = "用户已存在";

   // 用户不存在
   public final static int NotExists = 2;

   // 用户不存在字符串
   public final static String NotExistsString = "NotExists";

   // 用户不存在标签
   public final static String NotExistsLabel = "用户不存在";

   // 用户已经被锁定
   public final static int Lock = 3;

   // 用户已经被锁定字符串
   public final static String LockString = "Lock";

   // 用户已经被锁定标签
   public final static String LockLabel = "用户已经被锁定";

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
         case Exists:
            return ExistsString;
         case NotExists:
            return NotExistsString;
         case Lock:
            return LockString;
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
         case Exists:
            return ExistsLabel;
         case NotExists:
            return NotExistsLabel;
         case Lock:
            return LockLabel;
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
         case ExistsString:
            return Exists;
         case NotExistsString:
            return NotExists;
         case LockString:
            return Lock;
         default:
            return 0;
      }
   }
}
