//============================================================
// <T>商品状态。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>商品状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcGoodsStatus
{
   // 枚举名称
   public final static String DefineName = "GcGoodsStatus";

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

   // 发布
   public final static int Publish = 2;

   // 发布字符串
   public final static String PublishString = "Publish";

   // 发布标签
   public final static String PublishLabel = "发布";

   // 废除
   public final static int Depose = 3;

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
         case Apply:
            return ApplyString;
         case Publish:
            return PublishString;
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
         case Apply:
            return ApplyLabel;
         case Publish:
            return PublishLabel;
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
         case ApplyString:
            return Apply;
         case PublishString:
            return Publish;
         case DeposeString:
            return Depose;
         default:
            return 0;
      }
   }
}
