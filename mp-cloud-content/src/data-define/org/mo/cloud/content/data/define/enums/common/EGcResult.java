//============================================================
// <T>结果。</T>
//
// @version 1.0.1
//============================================================
package org.mo.cloud.content.data.define.enums.common;

//============================================================
// <T>结果枚举定义。</T>
//
// @enum
//============================================================
public class EGcResult
{
   // 枚举名称
   public final static String DefineName = "GcResult";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 成功
   public final static int Success = 1;

   // 成功字符串
   public final static String SuccessString = "Success";

   // 成功标签
   public final static String SuccessLabel = "成功";

   // 失败
   public final static int Fail = 2;

   // 失败字符串
   public final static String FailString = "Fail";

   // 失败标签
   public final static String FailLabel = "失败";

   // 继续
   public final static int Continue = 3;

   // 继续字符串
   public final static String ContinueString = "Continue";

   // 继续标签
   public final static String ContinueLabel = "继续";

   // 完成
   public final static int Finish = 4;

   // 完成字符串
   public final static String FinishString = "Finish";

   // 完成标签
   public final static String FinishLabel = "完成";

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
         case Success:
            return SuccessString;
         case Fail:
            return FailString;
         case Continue:
            return ContinueString;
         case Finish:
            return FinishString;
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
         case Success:
            return SuccessLabel;
         case Fail:
            return FailLabel;
         case Continue:
            return ContinueLabel;
         case Finish:
            return FinishLabel;
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
         case SuccessString:
            return Success;
         case FailString:
            return Fail;
         case ContinueString:
            return Continue;
         case FinishString:
            return Finish;
         default:
            return 0;
      }
   }
}
