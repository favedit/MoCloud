//============================================================
// <T>批处理下载状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>批处理下载状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcBatchDownloadStatus
{
   // 枚举名称
   public final static String DefineName = "GcBatchDownloadStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 准备下载
   public final static int Prepare = 1;

   // 准备下载字符串
   public final static String PrepareString = "Prepare";

   // 准备下载标签
   public final static String PrepareLabel = "准备下载";

   // 下载中
   public final static int Downloading = 2;

   // 下载中字符串
   public final static String DownloadingString = "Downloading";

   // 下载中标签
   public final static String DownloadingLabel = "下载中";

   // 下载完成
   public final static int Finish = 3;

   // 下载完成字符串
   public final static String FinishString = "Finish";

   // 下载完成标签
   public final static String FinishLabel = "下载完成";

   // 下载失败
   public final static int Failure = 4;

   // 下载失败字符串
   public final static String FailureString = "Failure";

   // 下载失败标签
   public final static String FailureLabel = "下载失败";

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
         case Prepare:
            return PrepareString;
         case Downloading:
            return DownloadingString;
         case Finish:
            return FinishString;
         case Failure:
            return FailureString;
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
         case Prepare:
            return PrepareLabel;
         case Downloading:
            return DownloadingLabel;
         case Finish:
            return FinishLabel;
         case Failure:
            return FailureLabel;
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
         case PrepareString:
            return Prepare;
         case DownloadingString:
            return Downloading;
         case FinishString:
            return Finish;
         case FailureString:
            return Failure;
         default:
            return 0;
      }
   }
}
