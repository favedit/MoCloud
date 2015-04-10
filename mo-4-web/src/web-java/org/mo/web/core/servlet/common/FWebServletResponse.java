package org.mo.web.core.servlet.common;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>网页应答。</T>
//============================================================
public class FWebServletResponse
      implements
         IWebServletResponse
{
   // 应答内容
   private final HttpServletResponse _response;

   //============================================================
   // <T>构造网页应答。</T>
   //
   // @param response 应答
   //============================================================
   public FWebServletResponse(HttpServletResponse response){
      _response = response;
   }

   //============================================================
   // <T>设置容量长度。</T>
   //
   // @param length 长度
   //============================================================
   @Override
   public void setContentLength(int length){
      _response.setContentLength(length);
   }

   //============================================================
   // <T>设置编码形式。</T>
   //
   // @param encoding 编码形式
   //============================================================
   @Override
   public void setCharacterEncoding(String encoding){
      _response.setCharacterEncoding(encoding);
   }

   //============================================================
   // <T>设置内容类型。</T>
   //
   // @param contentType 内容类型
   //============================================================
   @Override
   public void setContentType(String contentType){
      _response.setContentType(contentType);
   }

   //============================================================
   // <T>设置状态。</T>
   //
   // @param value 内容
   //============================================================
   @Override
   public void setStatus(int value){
      _response.setStatus(value);
   }

   //============================================================
   // <T>增加一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void addHeader(String name,
                         int value){
      _response.addIntHeader(name, value);
   }

   //============================================================
   // <T>增加一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void addHeader(String name,
                         long value){
      _response.addDateHeader(name, value);
   }

   //============================================================
   // <T>增加一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void addHeader(String name,
                         String value){
      _response.addHeader(name, value);
   }

   //============================================================
   // <T>设置一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void setHeader(String name,
                         int value){
      _response.setIntHeader(name, value);
   }

   //============================================================
   // <T>设置一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void setHeader(String name,
                         long value){
      _response.setDateHeader(name, value);
   }

   //============================================================
   // <T>设置一个头信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void setHeader(String name,
                         String value){
      _response.setHeader(name, value);
   }

   //============================================================
   // <T>写入数据。</T>
   //
   // @param data 数据内容
   //============================================================
   @Override
   public void write(byte[] data){
      try{
         _response.getOutputStream().write(data);
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>写入数据。</T>
   //
   // @param data 数据内容
   // @param offset 数据位置
   // @param length 数据长度
   //============================================================
   @Override
   public void write(byte[] data,
                     int offset,
                     int length){
      if((data != null) && (length > 0)){
         try{
            _response.getOutputStream().write(data, offset, length);
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
   }

   //============================================================
   // <T>刷新数据。</T>
   //============================================================
   @Override
   public void flush(){
      try{
         _response.flushBuffer();
      }catch(Exception e){
         throw new FFatalError(e);
      }
   }
}
