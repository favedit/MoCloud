//============================================================
// <T>资源关注。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源关注枚举定义。</T>
//
// @enum
//============================================================
public class EGcResourceAttention
{
   // 枚举名称
   public final static String DefineName = "GcResourceAttention";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 申请
   public final static int Apply = 1;

   // 申请字符串
   public final static String ApplyString = "Apply";

   // 申请标签
   public final static String ApplyLabel = "申请";

   // 关联
   public final static int Link = 2;

   // 关联字符串
   public final static String LinkString = "Link";

   // 关联标签
   public final static String LinkLabel = "关联";

   // 未关联
   public final static int Unlink = 3;

   // 未关联字符串
   public final static String UnlinkString = "Unlink";

   // 未关联标签
   public final static String UnlinkLabel = "未关联";

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
         case Apply:
            return ApplyString;
         case Link:
            return LinkString;
         case Unlink:
            return UnlinkString;
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
         case Apply:
            return ApplyLabel;
         case Link:
            return LinkLabel;
         case Unlink:
            return UnlinkLabel;
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
         case ApplyString:
            return Apply;
         case LinkString:
            return Link;
         case UnlinkString:
            return Unlink;
         default:
            return 0;
      }
   }
}
