package org.mo.web.protocol.common;

//============================================================
// <T>WEB应用程序类型标识。</T>
//============================================================
public interface IWebContentType
{
   // HTML
   public final static String HTML = "text/html;charset=UTF-8";

   // WML
   public final static String WML = "text/vnd.wap.wml;charset=UTF-8";

   // XML
   public final static String XML = "text/xml";

   // JSON
   public final static String JSON = "text/plain";

   // PDF
   public final static String PDF = "application/pdf";

   // Stream
   public final static String STREAM = "application/octet-stream";
}
