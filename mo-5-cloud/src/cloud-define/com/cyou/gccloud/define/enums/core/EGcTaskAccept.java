//============================================================
// <T>任务接受。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>任务接受枚举定义。</T>
//
// @enum
//============================================================
public class EGcTaskAccept
{
   // 枚举名称
   public final static String DefineName = "GcTaskAccept";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 可
   public final static int Able = 1;

   // 可字符串
   public final static String AbleString = "Able";

   // 可标签
   public final static String AbleLabel = "可";

   // 不可
   public final static int Disable = 2;

   // 不可字符串
   public final static String DisableString = "Disable";

   // 不可标签
   public final static String DisableLabel = "不可";

   // 锁定
   public final static int Lock = 3;

   // 锁定字符串
   public final static String LockString = "Lock";

   // 锁定标签
   public final static String LockLabel = "锁定";

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
         case Able:
            return AbleString;
         case Disable:
            return DisableString;
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
         case Able:
            return AbleLabel;
         case Disable:
            return DisableLabel;
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
         case AbleString:
            return Able;
         case DisableString:
            return Disable;
         case LockString:
            return Lock;
         default:
            return 0;
      }
   }
}
