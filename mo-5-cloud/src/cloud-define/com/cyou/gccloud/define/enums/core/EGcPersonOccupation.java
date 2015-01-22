//============================================================
// <T>用户职业。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>用户职业枚举定义。</T>
//
// @enum
//============================================================
public class EGcPersonOccupation
{
   // 枚举名称
   public final static String DefineName = "GcPersonOccupation";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 开发者
   public final static int Develop = 1;

   // 开发者字符串
   public final static String DevelopString = "Develop";

   // 开发者标签
   public final static String DevelopLabel = "开发者";

   // 玩家
   public final static int Player = 2;

   // 玩家字符串
   public final static String PlayerString = "Player";

   // 玩家标签
   public final static String PlayerLabel = "玩家";

   // 教师
   public final static int Teacher = 3;

   // 教师字符串
   public final static String TeacherString = "Teacher";

   // 教师标签
   public final static String TeacherLabel = "教师";

   // 游客
   public final static int Visitor = 4;

   // 游客字符串
   public final static String VisitorString = "Visitor";

   // 游客标签
   public final static String VisitorLabel = "游客";

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
         case Develop:
            return DevelopString;
         case Player:
            return PlayerString;
         case Teacher:
            return TeacherString;
         case Visitor:
            return VisitorString;
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
         case Develop:
            return DevelopLabel;
         case Player:
            return PlayerLabel;
         case Teacher:
            return TeacherLabel;
         case Visitor:
            return VisitorLabel;
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
         case DevelopString:
            return Develop;
         case PlayerString:
            return Player;
         case TeacherString:
            return Teacher;
         case VisitorString:
            return Visitor;
         default:
            return 0;
      }
   }
}
