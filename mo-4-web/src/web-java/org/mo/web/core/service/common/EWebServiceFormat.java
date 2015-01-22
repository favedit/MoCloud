package org.mo.web.core.service.common;

//============================================================
// <T>服务格式。</T>
//============================================================
public class EWebServiceFormat
{
   // XML格式
   public final static int Xml = 1;

   // XML格式
   public final static String XmlStr = "xml";

   // JSON格式
   public final static int Json = 2;

   // JSON格式
   public final static String JsonStr = "json";

   //============================================================
   // <T>判断是否为XML格式。</T>
   //
   // @param formatCd 格式类型
   // @return 是否为指定格式
   //============================================================
   public static boolean isXml(String formatCd){
      if(formatCd != null){
         if(formatCd.equals(XmlStr)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>判断是否为JSON格式。</T>
   //
   // @param formatCd 格式类型
   // @return 是否为指定格式
   //============================================================
   public static boolean isJson(String formatCd){
      if(formatCd != null){
         if(formatCd.equals(JsonStr)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>解析格式。</T>
   //
   // @param formatCd 格式类型
   // @return 格式
   //============================================================
   public static int parse(String formatCd){
      if(formatCd != null){
         if(formatCd.equals(XmlStr)){
            return Xml;
         }
         if(formatCd.equals(JsonStr)){
            return Json;
         }
      }
      return Xml;
   }

}
