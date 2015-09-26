//============================================================
// <T>职业。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>职业枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonBusiness
{
   // 枚举名称
   public final static String DefineName = "GcPersonBusiness";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 金融
   public final static int Financial = 1;

   // 金融字符串
   public final static String FinancialString = "Financial";

   // 金融标签
   public final static String FinancialLabel = "金融";

   // 科技
   public final static int Science = 2;

   // 科技字符串
   public final static String ScienceString = "Science";

   // 科技标签
   public final static String ScienceLabel = "科技";

   // 教育
   public final static int Education = 3;

   // 教育字符串
   public final static String EducationString = "Education";

   // 教育标签
   public final static String EducationLabel = "教育";

   // 运输
   public final static int Transport = 4;

   // 运输字符串
   public final static String TransportString = "Transport";

   // 运输标签
   public final static String TransportLabel = "运输";

   // 房产
   public final static int HouseProperty = 5;

   // 房产字符串
   public final static String HousePropertyString = "HouseProperty";

   // 房产标签
   public final static String HousePropertyLabel = "房产";

   // 制造
   public final static int Manufacture = 6;

   // 制造字符串
   public final static String ManufactureString = "Manufacture";

   // 制造标签
   public final static String ManufactureLabel = "制造";

   // 餐饮
   public final static int Restaurant = 7;

   // 餐饮字符串
   public final static String RestaurantString = "Restaurant";

   // 餐饮标签
   public final static String RestaurantLabel = "餐饮";

   // 广告
   public final static int Advertisement = 8;

   // 广告字符串
   public final static String AdvertisementString = "Advertisement";

   // 广告标签
   public final static String AdvertisementLabel = "广告";

   // 旅游
   public final static int Tourism = 9;

   // 旅游字符串
   public final static String TourismString = "Tourism";

   // 旅游标签
   public final static String TourismLabel = "旅游";

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
         case Financial:
            return FinancialString;
         case Science:
            return ScienceString;
         case Education:
            return EducationString;
         case Transport:
            return TransportString;
         case HouseProperty:
            return HousePropertyString;
         case Manufacture:
            return ManufactureString;
         case Restaurant:
            return RestaurantString;
         case Advertisement:
            return AdvertisementString;
         case Tourism:
            return TourismString;
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
         case Financial:
            return FinancialLabel;
         case Science:
            return ScienceLabel;
         case Education:
            return EducationLabel;
         case Transport:
            return TransportLabel;
         case HouseProperty:
            return HousePropertyLabel;
         case Manufacture:
            return ManufactureLabel;
         case Restaurant:
            return RestaurantLabel;
         case Advertisement:
            return AdvertisementLabel;
         case Tourism:
            return TourismLabel;
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
         case FinancialString:
            return Financial;
         case ScienceString:
            return Science;
         case EducationString:
            return Education;
         case TransportString:
            return Transport;
         case HousePropertyString:
            return HouseProperty;
         case ManufactureString:
            return Manufacture;
         case RestaurantString:
            return Restaurant;
         case AdvertisementString:
            return Advertisement;
         case TourismString:
            return Tourism;
         default:
            return 0;
      }
   }
}
