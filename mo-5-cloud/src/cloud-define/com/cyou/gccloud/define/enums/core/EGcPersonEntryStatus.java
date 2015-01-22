//============================================================
// <T>用户入口状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>用户入口状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonEntryStatus
{
   // 枚举名称
   public final static String DefineName = "GcPersonEntryStatus";

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

   // 异常
   public final static int Abnormal = 2;

   // 异常字符串
   public final static String AbnormalString = "Abnormal";

   // 异常标签
   public final static String AbnormalLabel = "异常";

   // 创建
   public final static int Creating = 3;

   // 创建字符串
   public final static String CreatingString = "Creating";

   // 创建标签
   public final static String CreatingLabel = "创建";

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
         case Abnormal:
            return AbnormalString;
         case Creating:
            return CreatingString;
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
         case Abnormal:
            return AbnormalLabel;
         case Creating:
            return CreatingLabel;
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
         case AbnormalString:
            return Abnormal;
         case CreatingString:
            return Creating;
         default:
            return 0;
      }
   }
}
