//============================================================
// <T>理财师客户短信提示类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.financial;

//============================================================
// <T>理财师客户短信提示类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcFinancialMemberContact
{
   // 枚举名称
   public final static String DefineName = "GcFinancialMemberContact";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 上线提醒
   public final static int Online = 1;

   // 上线提醒字符串
   public final static String OnlineString = "Online";

   // 上线提醒标签
   public final static String OnlineLabel = "上线提醒";

   // 关注提醒
   public final static int Follow = 2;

   // 关注提醒字符串
   public final static String FollowString = "Follow";

   // 关注提醒标签
   public final static String FollowLabel = "关注提醒";

   // 购买提醒
   public final static int Purchase = 3;

   // 购买提醒字符串
   public final static String PurchaseString = "Purchase";

   // 购买提醒标签
   public final static String PurchaseLabel = "购买提醒";

   // 充值提醒
   public final static int Recharge = 4;

   // 充值提醒字符串
   public final static String RechargeString = "Recharge";

   // 充值提醒标签
   public final static String RechargeLabel = "充值提醒";

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
         case Online:
            return OnlineString;
         case Follow:
            return FollowString;
         case Purchase:
            return PurchaseString;
         case Recharge:
            return RechargeString;
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
         case Online:
            return OnlineLabel;
         case Follow:
            return FollowLabel;
         case Purchase:
            return PurchaseLabel;
         case Recharge:
            return RechargeLabel;
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
         case OnlineString:
            return Online;
         case FollowString:
            return Follow;
         case PurchaseString:
            return Purchase;
         case RechargeString:
            return Recharge;
         default:
            return 0;
      }
   }
}
