//============================================================
// <T>短信校验类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>短信校验类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcValidationValidate
{
   // 枚举名称
   public final static String DefineName = "GcValidationValidate";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 理财师帐号绑定
   public final static int EaiMarketer = 1;

   // 理财师帐号绑定字符串
   public final static String EaiMarketerString = "EaiMarketer";

   // 理财师帐号绑定标签
   public final static String EaiMarketerLabel = "理财师帐号绑定";

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
         case EaiMarketer:
            return EaiMarketerString;
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
         case EaiMarketer:
            return EaiMarketerLabel;
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
         case EaiMarketerString:
            return EaiMarketer;
         default:
            return 0;
      }
   }
}
