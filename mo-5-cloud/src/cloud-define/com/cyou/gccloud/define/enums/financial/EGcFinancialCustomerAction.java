//============================================================
// <T>客户命令。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.financial;

//============================================================
// <T>客户命令枚举定义。</T>
//
// @enum
//============================================================
public class EGcFinancialCustomerAction
{
   // 枚举名称
   public final static String DefineName = "GcFinancialCustomerAction";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 投资
   public final static int Investment = 1;

   // 投资字符串
   public final static String InvestmentString = "Investment";

   // 投资标签
   public final static String InvestmentLabel = "投资";

   // 赎回
   public final static int Redemption = 2;

   // 赎回字符串
   public final static String RedemptionString = "Redemption";

   // 赎回标签
   public final static String RedemptionLabel = "赎回";

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
         case Investment:
            return InvestmentString;
         case Redemption:
            return RedemptionString;
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
         case Investment:
            return InvestmentLabel;
         case Redemption:
            return RedemptionLabel;
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
         case InvestmentString:
            return Investment;
         case RedemptionString:
            return Redemption;
         default:
            return 0;
      }
   }
}
