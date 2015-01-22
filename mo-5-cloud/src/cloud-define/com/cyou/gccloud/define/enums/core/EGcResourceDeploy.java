//============================================================
// <T>资源部署状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源部署状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceDeploy
{
   // 枚举名称
   public final static String DefineName = "GcResourceDeploy";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 等待下载
   public final static int Waiting = 1;

   // 等待下载字符串
   public final static String WaitingString = "Waiting";

   // 等待下载标签
   public final static String WaitingLabel = "等待下载";

   // 部署完成
   public final static int Complete = 2;

   // 部署完成字符串
   public final static String CompleteString = "Complete";

   // 部署完成标签
   public final static String CompleteLabel = "部署完成";

   // 下载失败
   public final static int DownloadFailure = 3;

   // 下载失败字符串
   public final static String DownloadFailureString = "DownloadFailure";

   // 下载失败标签
   public final static String DownloadFailureLabel = "下载失败";

   // 部署失败
   public final static int DeployFailure = 4;

   // 部署失败字符串
   public final static String DeployFailureString = "DeployFailure";

   // 部署失败标签
   public final static String DeployFailureLabel = "部署失败";

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
         case Waiting:
            return WaitingString;
         case Complete:
            return CompleteString;
         case DownloadFailure:
            return DownloadFailureString;
         case DeployFailure:
            return DeployFailureString;
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
         case Waiting:
            return WaitingLabel;
         case Complete:
            return CompleteLabel;
         case DownloadFailure:
            return DownloadFailureLabel;
         case DeployFailure:
            return DeployFailureLabel;
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
         case WaitingString:
            return Waiting;
         case CompleteString:
            return Complete;
         case DownloadFailureString:
            return DownloadFailure;
         case DeployFailureString:
            return DeployFailure;
         default:
            return 0;
      }
   }
}
