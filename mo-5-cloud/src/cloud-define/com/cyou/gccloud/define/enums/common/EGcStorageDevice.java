//============================================================
// <T>存储设备。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>存储设备枚举定义。</T>
//
// @enum
//============================================================
public class EGcStorageDevice
{
   // 枚举名称
   public final static String DefineName = "GcStorageDevice";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 个人电脑
   public final static int Pc = 1;

   // 个人电脑字符串
   public final static String PcString = "Pc";

   // 个人电脑标签
   public final static String PcLabel = "个人电脑";

   // 移动IOS
   public final static int Ios = 2;

   // 移动IOS字符串
   public final static String IosString = "Ios";

   // 移动IOS标签
   public final static String IosLabel = "移动IOS";

   // 移动Android
   public final static int Android = 4;

   // 移动Android字符串
   public final static String AndroidString = "Android";

   // 移动Android标签
   public final static String AndroidLabel = "移动Android";

   // 移动Window
   public final static int Window = 8;

   // 移动Window字符串
   public final static String WindowString = "Window";

   // 移动Window标签
   public final static String WindowLabel = "移动Window";

   // 移动
   public final static int Mobile = 14;

   // 移动字符串
   public final static String MobileString = "Mobile";

   // 移动标签
   public final static String MobileLabel = "移动";

   // 全部
   public final static int All = 15;

   // 全部字符串
   public final static String AllString = "All";

   // 全部标签
   public final static String AllLabel = "全部";

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
         case Pc:
            return PcString;
         case Ios:
            return IosString;
         case Android:
            return AndroidString;
         case Window:
            return WindowString;
         case Mobile:
            return MobileString;
         case All:
            return AllString;
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
         case Pc:
            return PcLabel;
         case Ios:
            return IosLabel;
         case Android:
            return AndroidLabel;
         case Window:
            return WindowLabel;
         case Mobile:
            return MobileLabel;
         case All:
            return AllLabel;
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
         case PcString:
            return Pc;
         case IosString:
            return Ios;
         case AndroidString:
            return Android;
         case WindowString:
            return Window;
         case MobileString:
            return Mobile;
         case AllString:
            return All;
         default:
            return 0;
      }
   }
}
