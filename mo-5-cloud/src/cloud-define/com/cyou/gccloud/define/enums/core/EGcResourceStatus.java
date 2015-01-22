//============================================================
// <T>资源状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceStatus
{
   // 枚举名称
   public final static String DefineName = "GcResourceStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 申请
   public final static int Apply = 1;

   // 申请字符串
   public final static String ApplyString = "Apply";

   // 申请标签
   public final static String ApplyLabel = "申请";

   // 发布
   public final static int Publish = 2;

   // 发布字符串
   public final static String PublishString = "Publish";

   // 发布标签
   public final static String PublishLabel = "发布";

   // 审核未通过
   public final static int CheckFail = 3;

   // 审核未通过字符串
   public final static String CheckFailString = "CheckFail";

   // 审核未通过标签
   public final static String CheckFailLabel = "审核未通过";

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
         case Apply:
            return ApplyString;
         case Publish:
            return PublishString;
         case CheckFail:
            return CheckFailString;
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
         case Apply:
            return ApplyLabel;
         case Publish:
            return PublishLabel;
         case CheckFail:
            return CheckFailLabel;
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
         case ApplyString:
            return Apply;
         case PublishString:
            return Publish;
         case CheckFailString:
            return CheckFail;
         default:
            return 0;
      }
   }
}
