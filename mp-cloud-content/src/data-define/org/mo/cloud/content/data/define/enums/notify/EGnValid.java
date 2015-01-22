//============================================================
// <T>校验消息。</T>
//
// @version 1.0.1
//============================================================
package org.mo.cloud.content.data.define.enums.notify;

//============================================================
// <T>校验消息枚举定义。</T>
//
// @enum
//============================================================
public class EGnValid
{
   // 枚举名称
   public final static String DefineName = "GnValid";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 内容为空
   public final static int Empty = 1;

   // 内容为空字符串
   public final static String EmptyString = "Empty";

   // 内容为空标签
   public final static String EmptyLabel = "内容为空";

   // 小于最小长度
   public final static int LengthMin = 2;

   // 小于最小长度字符串
   public final static String LengthMinString = "LengthMin";

   // 小于最小长度标签
   public final static String LengthMinLabel = "小于最小长度";

   // 大于最大长度
   public final static int LengthMax = 3;

   // 大于最大长度字符串
   public final static String LengthMaxString = "LengthMax";

   // 大于最大长度标签
   public final static String LengthMaxLabel = "大于最大长度";

   // 长度不在指定范围内
   public final static int LengthRange = 4;

   // 长度不在指定范围内字符串
   public final static String LengthRangeString = "LengthRange";

   // 长度不在指定范围内标签
   public final static String LengthRangeLabel = "长度不在指定范围内";

   // 小于最小数据
   public final static int ValueMin = 5;

   // 小于最小数据字符串
   public final static String ValueMinString = "ValueMin";

   // 小于最小数据标签
   public final static String ValueMinLabel = "小于最小数据";

   // 大于最大数据
   public final static int ValueMax = 6;

   // 大于最大数据字符串
   public final static String ValueMaxString = "ValueMax";

   // 大于最大数据标签
   public final static String ValueMaxLabel = "大于最大数据";

   // 数据不在指定范围内
   public final static int ValueRange = 7;

   // 数据不在指定范围内字符串
   public final static String ValueRangeString = "ValueRange";

   // 数据不在指定范围内标签
   public final static String ValueRangeLabel = "数据不在指定范围内";

   // 非法的Email格式
   public final static int Email = 8;

   // 非法的Email格式字符串
   public final static String EmailString = "Email";

   // 非法的Email格式标签
   public final static String EmailLabel = "非法的Email格式";

   // 非法的电话号码格式
   public final static int Phone = 9;

   // 非法的电话号码格式字符串
   public final static String PhoneString = "Phone";

   // 非法的电话号码格式标签
   public final static String PhoneLabel = "非法的电话号码格式";

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
         case Empty:
            return EmptyString;
         case LengthMin:
            return LengthMinString;
         case LengthMax:
            return LengthMaxString;
         case LengthRange:
            return LengthRangeString;
         case ValueMin:
            return ValueMinString;
         case ValueMax:
            return ValueMaxString;
         case ValueRange:
            return ValueRangeString;
         case Email:
            return EmailString;
         case Phone:
            return PhoneString;
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
         case Empty:
            return EmptyLabel;
         case LengthMin:
            return LengthMinLabel;
         case LengthMax:
            return LengthMaxLabel;
         case LengthRange:
            return LengthRangeLabel;
         case ValueMin:
            return ValueMinLabel;
         case ValueMax:
            return ValueMaxLabel;
         case ValueRange:
            return ValueRangeLabel;
         case Email:
            return EmailLabel;
         case Phone:
            return PhoneLabel;
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
         case EmptyString:
            return Empty;
         case LengthMinString:
            return LengthMin;
         case LengthMaxString:
            return LengthMax;
         case LengthRangeString:
            return LengthRange;
         case ValueMinString:
            return ValueMin;
         case ValueMaxString:
            return ValueMax;
         case ValueRangeString:
            return ValueRange;
         case EmailString:
            return Email;
         case PhoneString:
            return Phone;
         default:
            return 0;
      }
   }
}
