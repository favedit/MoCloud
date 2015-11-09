//============================================================
// <T>金融资金分级。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.financial;

//============================================================
// <T>金融资金分级枚举定义。</T>
//
// @enum
//============================================================
public class EGcFinancialAmountLevel
{
   // 枚举名称
   public final static String DefineName = "GcFinancialAmountLevel";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 小于1W
   public final static int Level1 = 1;

   // 小于1W字符串
   public final static String Level1String = "Level1";

   // 小于1W标签
   public final static String Level1Label = "小于1W";

   // 不小于1W并且小于10W
   public final static int Level2 = 2;

   // 不小于1W并且小于10W字符串
   public final static String Level2String = "Level2";

   // 不小于1W并且小于10W标签
   public final static String Level2Label = "不小于1W并且小于10W";

   // 不小于10W并且小于50W
   public final static int Level3 = 3;

   // 不小于10W并且小于50W字符串
   public final static String Level3String = "Level3";

   // 不小于10W并且小于50W标签
   public final static String Level3Label = "不小于10W并且小于50W";

   // 不小于50W并且小于100W
   public final static int Level4 = 4;

   // 不小于50W并且小于100W字符串
   public final static String Level4String = "Level4";

   // 不小于50W并且小于100W标签
   public final static String Level4Label = "不小于50W并且小于100W";

   // 不小于100W并且小于500W
   public final static int Level5 = 5;

   // 不小于100W并且小于500W字符串
   public final static String Level5String = "Level5";

   // 不小于100W并且小于500W标签
   public final static String Level5Label = "不小于100W并且小于500W";

   // 不小于500W并且小于1000W
   public final static int Level6 = 6;

   // 不小于500W并且小于1000W字符串
   public final static String Level6String = "Level6";

   // 不小于500W并且小于1000W标签
   public final static String Level6Label = "不小于500W并且小于1000W";

   // 不小于1000W
   public final static int Level7 = 7;

   // 不小于1000W字符串
   public final static String Level7String = "Level7";

   // 不小于1000W标签
   public final static String Level7Label = "不小于1000W";

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
         case Level1:
            return Level1String;
         case Level2:
            return Level2String;
         case Level3:
            return Level3String;
         case Level4:
            return Level4String;
         case Level5:
            return Level5String;
         case Level6:
            return Level6String;
         case Level7:
            return Level7String;
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
         case Level1:
            return Level1Label;
         case Level2:
            return Level2Label;
         case Level3:
            return Level3Label;
         case Level4:
            return Level4Label;
         case Level5:
            return Level5Label;
         case Level6:
            return Level6Label;
         case Level7:
            return Level7Label;
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
         case Level1String:
            return Level1;
         case Level2String:
            return Level2;
         case Level3String:
            return Level3;
         case Level4String:
            return Level4;
         case Level5String:
            return Level5;
         case Level6String:
            return Level6;
         case Level7String:
            return Level7;
         default:
            return 0;
      }
   }
}
