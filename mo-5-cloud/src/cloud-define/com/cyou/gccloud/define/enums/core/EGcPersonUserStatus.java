//============================================================
// <T>人员用户状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员用户状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonUserStatus
{
   // 枚举名称
   public final static String DefineName = "GcPersonUserStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 正常
   public final static int Normal = 1;

   // 正常字符串
   public final static String NormalString = "Normal";

   // 正常标签
   public final static String NormalLabel = "正常";

   // 锁定
   public final static int Lock = 2;

   // 锁定字符串
   public final static String LockString = "Lock";

   // 锁定标签
   public final static String LockLabel = "锁定";

   // 禁止
   public final static int Forbid = 3;

   // 禁止字符串
   public final static String ForbidString = "Forbid";

   // 禁止标签
   public final static String ForbidLabel = "禁止";

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
         case Normal:
            return NormalString;
         case Lock:
            return LockString;
         case Forbid:
            return ForbidString;
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
         case Normal:
            return NormalLabel;
         case Lock:
            return LockLabel;
         case Forbid:
            return ForbidLabel;
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
         case NormalString:
            return Normal;
         case LockString:
            return Lock;
         case ForbidString:
            return Forbid;
         default:
            return 0;
      }
   }
}
