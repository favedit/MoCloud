//============================================================
// <T>人员角色。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>人员角色枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonRole
{
   // 枚举名称
   public final static String DefineName = "GcPersonRole";

   // 未知
   public final static int Unknow = 0;

   // 未知字符串
   public final static String UnknowString = "Unknow";

   // 未知标签
   public final static String UnknowLabel = "未知";

   // 管理员
   public final static int Admin = 1;

   // 管理员字符串
   public final static String AdminString = "Admin";

   // 管理员标签
   public final static String AdminLabel = "管理员";

   // 用户
   public final static int Normal = 2;

   // 用户字符串
   public final static String NormalString = "Normal";

   // 用户标签
   public final static String NormalLabel = "用户";

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
         case Unknow:
            return UnknowString;
         case Admin:
            return AdminString;
         case Normal:
            return NormalString;
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
         case Unknow:
            return UnknowLabel;
         case Admin:
            return AdminLabel;
         case Normal:
            return NormalLabel;
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
         case UnknowString:
            return Unknow;
         case AdminString:
            return Admin;
         case NormalString:
            return Normal;
         default:
            return 0;
      }
   }
}
