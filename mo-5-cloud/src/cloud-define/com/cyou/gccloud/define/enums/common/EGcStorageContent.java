//============================================================
// <T>存储内容。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.common;

//============================================================
// <T>存储内容枚举定义。</T>
//
// @enum
//============================================================
public class EGcStorageContent
{
   // 枚举名称
   public final static String DefineName = "GcStorageContent";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 文本
   public final static int Text = 1;

   // 文本字符串
   public final static String TextString = "Text";

   // 文本标签
   public final static String TextLabel = "文本";

   // 文档
   public final static int Document = 2;

   // 文档字符串
   public final static String DocumentString = "Document";

   // 文档标签
   public final static String DocumentLabel = "文档";

   // 图标
   public final static int Icon = 3;

   // 图标字符串
   public final static String IconString = "Icon";

   // 图标标签
   public final static String IconLabel = "图标";

   // 图片
   public final static int Picture = 4;

   // 图片字符串
   public final static String PictureString = "Picture";

   // 图片标签
   public final static String PictureLabel = "图片";

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
         case Text:
            return TextString;
         case Document:
            return DocumentString;
         case Icon:
            return IconString;
         case Picture:
            return PictureString;
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
         case Text:
            return TextLabel;
         case Document:
            return DocumentLabel;
         case Icon:
            return IconLabel;
         case Picture:
            return PictureLabel;
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
         case TextString:
            return Text;
         case DocumentString:
            return Document;
         case IconString:
            return Icon;
         case PictureString:
            return Picture;
         default:
            return 0;
      }
   }
}
