//============================================================
// <T>消息类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>消息类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcMessageType
{
   // 枚举名称
   public final static String DefineName = "GcMessageType";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 聊天
   public final static int Chat = 1;

   // 聊天字符串
   public final static String ChatString = "Chat";

   // 聊天标签
   public final static String ChatLabel = "聊天";

   // 事件
   public final static int Event = 2;

   // 事件字符串
   public final static String EventString = "Event";

   // 事件标签
   public final static String EventLabel = "事件";

   // 通知
   public final static int Notify = 3;

   // 通知字符串
   public final static String NotifyString = "Notify";

   // 通知标签
   public final static String NotifyLabel = "通知";

   // 任务
   public final static int Task = 4;

   // 任务字符串
   public final static String TaskString = "Task";

   // 任务标签
   public final static String TaskLabel = "任务";

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
         case Chat:
            return ChatString;
         case Event:
            return EventString;
         case Notify:
            return NotifyString;
         case Task:
            return TaskString;
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
         case Chat:
            return ChatLabel;
         case Event:
            return EventLabel;
         case Notify:
            return NotifyLabel;
         case Task:
            return TaskLabel;
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
         case ChatString:
            return Chat;
         case EventString:
            return Event;
         case NotifyString:
            return Notify;
         case TaskString:
            return Task;
         default:
            return 0;
      }
   }
}
