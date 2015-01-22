//============================================================
// <T>系统处理。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>系统处理枚举定义。</T>
//
// @enum
//============================================================
public class EGcSystemProcess
{
   // 枚举名称
   public final static String DefineName = "GcSystemProcess";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 存储过程
   public final static int Procedure = 1;

   // 存储过程字符串
   public final static String ProcedureString = "Procedure";

   // 存储过程标签
   public final static String ProcedureLabel = "存储过程";

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
         case Procedure:
            return ProcedureString;
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
         case Procedure:
            return ProcedureLabel;
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
         case ProcedureString:
            return Procedure;
         default:
            return 0;
      }
   }
}
