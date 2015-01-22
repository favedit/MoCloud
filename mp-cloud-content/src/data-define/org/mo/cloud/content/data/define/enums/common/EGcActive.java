//============================================================
// <T>激活状态。</T>
//
// @version 1.0.1
//============================================================
package org.mo.cloud.content.data.define.enums.common;

//============================================================
// <T>激活状态枚举定义。</T>
//
// @enum
//============================================================
public class EGcActive
{
   // 枚举名称
   public final static String DefineName = "GcActive";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 激活
   public final static int Active = 1;

   // 激活字符串
   public final static String ActiveString = "Active";

   // 激活标签
   public final static String ActiveLabel = "激活";

   // 不激活
   public final static int Deactive = 2;

   // 不激活字符串
   public final static String DeactiveString = "Deactive";

   // 不激活标签
   public final static String DeactiveLabel = "不激活";

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
         case Active:
            return ActiveString;
         case Deactive:
            return DeactiveString;
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
         case Active:
            return ActiveLabel;
         case Deactive:
            return DeactiveLabel;
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
         case ActiveString:
            return Active;
         case DeactiveString:
            return Deactive;
         default:
            return 0;
      }
   }
}
