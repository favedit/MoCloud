//============================================================
// <T>数据挖掘规则类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>数据挖掘规则类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcRule
{
   // 枚举名称
   public final static String DefineName = "GcRule";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 最后登录
   public final static int LastLogin = 1;

   // 最后登录字符串
   public final static String LastLoginString = "LastLogin";

   // 最后登录标签
   public final static String LastLoginLabel = "最后登录";

   // 周浏览次数
   public final static int BrowseCount = 2;

   // 周浏览次数字符串
   public final static String BrowseCountString = "BrowseCount";

   // 周浏览次数标签
   public final static String BrowseCountLabel = "周浏览次数";

   // 月收入
   public final static int Income = 3;

   // 月收入字符串
   public final static String IncomeString = "Income";

   // 月收入标签
   public final static String IncomeLabel = "月收入";

   // 年龄
   public final static int Age = 4;

   // 年龄字符串
   public final static String AgeString = "Age";

   // 年龄标签
   public final static String AgeLabel = "年龄";

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
         case LastLogin:
            return LastLoginString;
         case BrowseCount:
            return BrowseCountString;
         case Income:
            return IncomeString;
         case Age:
            return AgeString;
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
         case LastLogin:
            return LastLoginLabel;
         case BrowseCount:
            return BrowseCountLabel;
         case Income:
            return IncomeLabel;
         case Age:
            return AgeLabel;
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
         case LastLoginString:
            return LastLogin;
         case BrowseCountString:
            return BrowseCount;
         case IncomeString:
            return Income;
         case AgeString:
            return Age;
         default:
            return 0;
      }
   }
}
