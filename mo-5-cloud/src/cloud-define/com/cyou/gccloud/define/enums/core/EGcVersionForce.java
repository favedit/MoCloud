//============================================================
// <T>版本更新规则。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>版本更新规则枚举定义。</T>
//
// @enum
//============================================================
public class EGcVersionForce
{
   // 枚举名称
   public final static String DefineName = "GcVersionForce";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 可选
   public final static int Optional = 1;

   // 可选字符串
   public final static String OptionalString = "Optional";

   // 可选标签
   public final static String OptionalLabel = "可选";

   // 强制
   public final static int Force = 2;

   // 强制字符串
   public final static String ForceString = "Force";

   // 强制标签
   public final static String ForceLabel = "强制";

   // 自动
   public final static int Auto = 3;

   // 自动字符串
   public final static String AutoString = "Auto";

   // 自动标签
   public final static String AutoLabel = "自动";

   // 不更新
   public final static int NoUpdate = 4;

   // 不更新字符串
   public final static String NoUpdateString = "NoUpdate";

   // 不更新标签
   public final static String NoUpdateLabel = "不更新";

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
         case Optional:
            return OptionalString;
         case Force:
            return ForceString;
         case Auto:
            return AutoString;
         case NoUpdate:
            return NoUpdateString;
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
         case Optional:
            return OptionalLabel;
         case Force:
            return ForceLabel;
         case Auto:
            return AutoLabel;
         case NoUpdate:
            return NoUpdateLabel;
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
         case OptionalString:
            return Optional;
         case ForceString:
            return Force;
         case AutoString:
            return Auto;
         case NoUpdateString:
            return NoUpdate;
         default:
            return 0;
      }
   }
}
