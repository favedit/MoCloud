package org.mo.web.core.service.common;

import java.io.UnsupportedEncodingException;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;

//============================================================
// <T>页面服务功能。</T>
//============================================================
public class RWebService
{
   // 格式类型
   public final static String PtyFormatCd = "format_cd";

   // 结果类型
   public final static String PtyResultCd = "result_cd";

   // 消息类型
   public final static String PtyMessageCd = "message_cd";

   //============================================================
   // <T>XML转换为JSON。</T>
   //============================================================
   public static String xml2json(String xml){
      XMLSerializer xmlSerializer = new XMLSerializer();
      xmlSerializer.setSkipNamespaces(true);
      xmlSerializer.setTypeHintsEnabled(false);
      xmlSerializer.setTypeHintsCompatibility(false);
      JSON json = xmlSerializer.read(xml);
      String jsonString = json.toString(3);
      jsonString = RString.replace(jsonString, "\"@", "\"");
      return jsonString;
   }

   //============================================================
   // <T>XML转换为JSON。</T>
   //============================================================
   public static byte[] xml2json(FXmlDocument document){
      //                  String xml = outputDoc.root().xml().toString();
      //                  // 输出JSON格式
      //                  StringWriter writer = new StringWriter();
      //                  JsonParser jsonParser = xmlMapper.getFactory().createParser(xml);
      //                  JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(writer);
      //                  while(jsonParser.nextToken() != null){
      //                     jsonGenerator.copyCurrentEvent(jsonParser);
      //                  }
      //                  jsonParser.close();
      //                  jsonGenerator.close();
      //                  String jsonString = writer.toString();
      //                  String json = outputDoc.root().toJson();
      //                  byte[] jsonData = json.getBytes("utf-8");
      //                  outputStream.write(jsonData);
      String xml = document.xml();
      XMLSerializer xmlSerializer = new XMLSerializer();
      xmlSerializer.setSkipNamespaces(true);
      xmlSerializer.setTypeHintsEnabled(false);
      xmlSerializer.setTypeHintsCompatibility(false);
      JSON json = xmlSerializer.read(xml);
      String jsonString = json.toString(3);
      jsonString = RString.replace(jsonString, "\"@", "\"");
      byte[] jsonData = null;
      try{
         jsonData = jsonString.getBytes("utf-8");
      }catch(UnsupportedEncodingException e){
         throw new FFatalError(e);
      }
      return jsonData;
   }
}
