//============================================================
// <T>任务状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>任务状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcTaskStatus
{
   // 枚举名称
   public final static String DefineName = "GcTaskStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 接受
   public final static int Accept = 1;

   // 接受字符串
   public final static String AcceptString = "Accept";

   // 接受标签
   public final static String AcceptLabel = "接受";

   // 完成
   public final static int Finish = 2;

   // 完成字符串
   public final static String FinishString = "Finish";

   // 完成标签
   public final static String FinishLabel = "完成";

   // 待审核
   public final static int Checking = 3;

   // 待审核字符串
   public final static String CheckingString = "Checking";

   // 待审核标签
   public final static String CheckingLabel = "待审核";

   // 失败
   public final static int Fail = 4;

   // 失败字符串
   public final static String FailString = "Fail";

   // 失败标签
   public final static String FailLabel = "失败";

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
         case Accept:
            return AcceptString;
         case Finish:
            return FinishString;
         case Checking:
            return CheckingString;
         case Fail:
            return FailString;
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
         case Accept:
            return AcceptLabel;
         case Finish:
            return FinishLabel;
         case Checking:
            return CheckingLabel;
         case Fail:
            return FailLabel;
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
         case AcceptString:
            return Accept;
         case FinishString:
            return Finish;
         case CheckingString:
            return Checking;
         case FailString:
            return Fail;
         default:
            return 0;
      }
   }
}
