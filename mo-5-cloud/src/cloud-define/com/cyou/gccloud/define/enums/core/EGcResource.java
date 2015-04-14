//============================================================
// <T>资源类型。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.define.enums.core;

//============================================================
// <T>资源类型枚举定义。</T>
//
// @enum
//============================================================
public class EGcResource
{
   // 枚举名称
   public final static String DefineName = "GcResource";

   // 未知
   public final static int Unknown = 0;

   // 未知字符串
   public final static String UnknownString = "Unknown";

   // 未知标签
   public final static String UnknownLabel = "未知";

   // 位图
   public final static int Bitmap = 1;

   // 位图字符串
   public final static String BitmapString = "Bitmap";

   // 位图标签
   public final static String BitmapLabel = "位图";

   // 材质
   public final static int Material = 2;

   // 材质字符串
   public final static String MaterialString = "Material";

   // 材质标签
   public final static String MaterialLabel = "材质";

   // 网格
   public final static int Mesh = 3;

   // 网格字符串
   public final static String MeshString = "Mesh";

   // 网格标签
   public final static String MeshLabel = "网格";

   // 模型
   public final static int Model = 4;

   // 模型字符串
   public final static String ModelString = "Model";

   // 模型标签
   public final static String ModelLabel = "模型";

   // 模板
   public final static int Template = 5;

   // 模板字符串
   public final static String TemplateString = "Template";

   // 模板标签
   public final static String TemplateLabel = "模板";

   // 场景
   public final static int Scene = 6;

   // 场景字符串
   public final static String SceneString = "Scene";

   // 场景标签
   public final static String SceneLabel = "场景";

   // 项目
   public final static int Project = 7;

   // 项目字符串
   public final static String ProjectString = "Project";

   // 项目标签
   public final static String ProjectLabel = "项目";

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
         case Bitmap:
            return BitmapString;
         case Material:
            return MaterialString;
         case Mesh:
            return MeshString;
         case Model:
            return ModelString;
         case Template:
            return TemplateString;
         case Scene:
            return SceneString;
         case Project:
            return ProjectString;
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
         case Bitmap:
            return BitmapLabel;
         case Material:
            return MaterialLabel;
         case Mesh:
            return MeshLabel;
         case Model:
            return ModelLabel;
         case Template:
            return TemplateLabel;
         case Scene:
            return SceneLabel;
         case Project:
            return ProjectLabel;
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
         case BitmapString:
            return Bitmap;
         case MaterialString:
            return Material;
         case MeshString:
            return Mesh;
         case ModelString:
            return Model;
         case TemplateString:
            return Template;
         case SceneString:
            return Scene;
         case ProjectString:
            return Project;
         default:
            return 0;
      }
   }
}
