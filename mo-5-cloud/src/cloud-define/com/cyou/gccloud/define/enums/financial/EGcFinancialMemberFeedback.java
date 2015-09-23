//============================================================
// <T>理财师客户关系解除反馈类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.financial;

//============================================================
// <T>理财师客户关系解除反馈类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcFinancialMemberFeedback
{
   // 枚举名称
   public final static String DefineName = "GcFinancialMemberFeedback";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 已确认理财师
   public final static int ConfiMaketer = 1;

   // 已确认理财师字符串
   public final static String ConfiMaketerString = "ConfiMaketer";

   // 已确认理财师标签
   public final static String ConfiMaketerLabel = "已确认理财师";

   // 已购买其它理财产品
   public final static int POFProduct = 2;

   // 已购买其它理财产品字符串
   public final static String POFProductString = "POFProduct";

   // 已购买其它理财产品标签
   public final static String POFProductLabel = "已购买其它理财产品";

   // 没有投资意向
   public final static int NIIntentions = 3;

   // 没有投资意向字符串
   public final static String NIIntentionsString = "NIIntentions";

   // 没有投资意向标签
   public final static String NIIntentionsLabel = "没有投资意向";

   // 对产品不满意
   public final static int NSWithProduct = 4;

   // 对产品不满意字符串
   public final static String NSWithProductString = "NSWithProduct";

   // 对产品不满意标签
   public final static String NSWithProductLabel = "对产品不满意";

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
         case ConfiMaketer:
            return ConfiMaketerString;
         case POFProduct:
            return POFProductString;
         case NIIntentions:
            return NIIntentionsString;
         case NSWithProduct:
            return NSWithProductString;
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
         case ConfiMaketer:
            return ConfiMaketerLabel;
         case POFProduct:
            return POFProductLabel;
         case NIIntentions:
            return NIIntentionsLabel;
         case NSWithProduct:
            return NSWithProductLabel;
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
         case ConfiMaketerString:
            return ConfiMaketer;
         case POFProductString:
            return POFProduct;
         case NIIntentionsString:
            return NIIntentions;
         case NSWithProductString:
            return NSWithProduct;
         default:
            return 0;
      }
   }
}
