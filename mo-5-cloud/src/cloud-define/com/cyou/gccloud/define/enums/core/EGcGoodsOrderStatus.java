//============================================================
// <T>商品订购状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>商品订购状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcGoodsOrderStatus
{
   // 枚举名称
   public final static String DefineName = "GcGoodsOrderStatus";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 正常
   public final static int Normal = 1;

   // 正常字符串
   public final static String NormalString = "Normal";

   // 正常标签
   public final static String NormalLabel = "正常";

   // 处理中
   public final static int Process = 2;

   // 处理中字符串
   public final static String ProcessString = "Process";

   // 处理中标签
   public final static String ProcessLabel = "处理中";

   // 完成
   public final static int Finish = 3;

   // 完成字符串
   public final static String FinishString = "Finish";

   // 完成标签
   public final static String FinishLabel = "完成";

   // 废除
   public final static int Depose = 4;

   // 废除字符串
   public final static String DeposeString = "Depose";

   // 废除标签
   public final static String DeposeLabel = "废除";

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
         case Normal:
            return NormalString;
         case Process:
            return ProcessString;
         case Finish:
            return FinishString;
         case Depose:
            return DeposeString;
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
         case Normal:
            return NormalLabel;
         case Process:
            return ProcessLabel;
         case Finish:
            return FinishLabel;
         case Depose:
            return DeposeLabel;
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
         case NormalString:
            return Normal;
         case ProcessString:
            return Process;
         case FinishString:
            return Finish;
         case DeposeString:
            return Depose;
         default:
            return 0;
      }
   }
}
