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

   // 项目
   public final static int Project = 1;

   // 项目字符串
   public final static String ProjectString = "Project";

   // 项目标签
   public final static String ProjectLabel = "项目";

   // 位图
   public final static int Bitmap = 2;

   // 位图字符串
   public final static String BitmapString = "Bitmap";

   // 位图标签
   public final static String BitmapLabel = "位图";

   // 纹理3D
   public final static int Texture3d = 3;

   // 纹理3D字符串
   public final static String Texture3dString = "Texture3d";

   // 纹理3D标签
   public final static String Texture3dLabel = "纹理3D";

   // 材质3D
   public final static int Material3d = 4;

   // 材质3D字符串
   public final static String Material3dString = "Material3d";

   // 材质3D标签
   public final static String Material3dLabel = "材质3D";

   // 主题3D
   public final static int Theme3d = 5;

   // 主题3D字符串
   public final static String Theme3dString = "Theme3d";

   // 主题3D标签
   public final static String Theme3dLabel = "主题3D";

   // 网格3d
   public final static int Mesh3d = 6;

   // 网格3d字符串
   public final static String Mesh3dString = "Mesh3d";

   // 网格3d标签
   public final static String Mesh3dLabel = "网格3d";

   // 模型3D
   public final static int Model3d = 7;

   // 模型3D字符串
   public final static String Model3dString = "Model3d";

   // 模型3D标签
   public final static String Model3dLabel = "模型3D";

   // 模板3D
   public final static int Template3d = 8;

   // 模板3D字符串
   public final static String Template3dString = "Template3d";

   // 模板3D标签
   public final static String Template3dLabel = "模板3D";

   // 场景3D
   public final static int Scene3d = 9;

   // 场景3D字符串
   public final static String Scene3dString = "Scene3d";

   // 场景3D标签
   public final static String Scene3dLabel = "场景3D";

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
         case Project:
            return ProjectString;
         case Bitmap:
            return BitmapString;
         case Texture3d:
            return Texture3dString;
         case Material3d:
            return Material3dString;
         case Theme3d:
            return Theme3dString;
         case Mesh3d:
            return Mesh3dString;
         case Model3d:
            return Model3dString;
         case Template3d:
            return Template3dString;
         case Scene3d:
            return Scene3dString;
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
         case Project:
            return ProjectLabel;
         case Bitmap:
            return BitmapLabel;
         case Texture3d:
            return Texture3dLabel;
         case Material3d:
            return Material3dLabel;
         case Theme3d:
            return Theme3dLabel;
         case Mesh3d:
            return Mesh3dLabel;
         case Model3d:
            return Model3dLabel;
         case Template3d:
            return Template3dLabel;
         case Scene3d:
            return Scene3dLabel;
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
         case ProjectString:
            return Project;
         case BitmapString:
            return Bitmap;
         case Texture3dString:
            return Texture3d;
         case Material3dString:
            return Material3d;
         case Theme3dString:
            return Theme3d;
         case Mesh3dString:
            return Mesh3d;
         case Model3dString:
            return Model3d;
         case Template3dString:
            return Template3d;
         case Scene3dString:
            return Scene3d;
         default:
            return 0;
      }
   }
}
