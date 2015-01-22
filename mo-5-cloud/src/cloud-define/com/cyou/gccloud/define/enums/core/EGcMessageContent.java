//============================================================
// <T>消息内容。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>消息内容枚举定义。</T>
//
// @enum
//============================================================
public class EGcMessageContent
{
   // 枚举名称
   public final static String DefineName = "GcMessageContent";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 文本
   public final static int Text = 1;

   // 文本字符串
   public final static String TextString = "Text";

   // 文本标签
   public final static String TextLabel = "文本";

   // 声音
   public final static int Sound = 2;

   // 声音字符串
   public final static String SoundString = "Sound";

   // 声音标签
   public final static String SoundLabel = "声音";

   // 图片
   public final static int Picture = 3;

   // 图片字符串
   public final static String PictureString = "Picture";

   // 图片标签
   public final static String PictureLabel = "图片";

   // 应用
   public final static int Application = 4;

   // 应用字符串
   public final static String ApplicationString = "Application";

   // 应用标签
   public final static String ApplicationLabel = "应用";

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
         case Text:
            return TextString;
         case Sound:
            return SoundString;
         case Picture:
            return PictureString;
         case Application:
            return ApplicationString;
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
         case Text:
            return TextLabel;
         case Sound:
            return SoundLabel;
         case Picture:
            return PictureLabel;
         case Application:
            return ApplicationLabel;
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
         case TextString:
            return Text;
         case SoundString:
            return Sound;
         case PictureString:
            return Picture;
         case ApplicationString:
            return Application;
         default:
            return 0;
      }
   }
}
