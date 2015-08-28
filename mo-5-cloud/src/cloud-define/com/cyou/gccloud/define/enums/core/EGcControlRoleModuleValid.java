//============================================================
// <T>控制角色模块有效性。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>控制角色模块有效性枚举定义。</T>
//
// @enum
//============================================================
public class EGcControlRoleModuleValid
{
   // 枚举名称
   public final static String DefineName = "GcControlRoleModuleValid";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 有效
   public final static int Valid = 1;

   // 有效字符串
   public final static String ValidString = "Valid";

   // 有效标签
   public final static String ValidLabel = "有效";

   // 非法
   public final static int Invlaid = 2;

   // 非法字符串
   public final static String InvlaidString = "Invlaid";

   // 非法标签
   public final static String InvlaidLabel = "非法";

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
         case Valid:
            return ValidString;
         case Invlaid:
            return InvlaidString;
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
         case Valid:
            return ValidLabel;
         case Invlaid:
            return InvlaidLabel;
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
         case ValidString:
            return Valid;
         case InvlaidString:
            return Invlaid;
         default:
            return 0;
      }
   }
}
