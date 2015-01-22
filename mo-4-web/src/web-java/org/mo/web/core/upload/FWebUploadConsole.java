/*
 * @(#)FWebUploadConsole.java
 *
 * Copyright 2005 microbject, All Rights Reserved.
 *
 */
package org.mo.web.core.upload;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.mo.com.console.FConsole;
import org.mo.com.lang.IAttributes;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;
import org.mo.web.protocol.common.FWebUpdateParser;
import org.mo.web.protocol.common.FWebUploadFiles;

//============================================================
// <T>文件上传控制台。</T>
//============================================================
public class FWebUploadConsole
      extends FConsole
      implements
         IWebUploadConsole
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FWebUploadConsole.class);

   // 上传临时路径
   @AProperty
   private String _directory;

   // 上传字符编码
   @AProperty
   private String _encoding;

   //============================================================
   // <T>构造文件上传控制台。</T>
   //============================================================
   public FWebUploadConsole(){
   }

   //============================================================
   // <T>获得上传临时路径。</T>
   //
   // @return 上传临时路径
   //============================================================
   @Override
   public String directory(){
      return _directory;
   }

   //============================================================
   // <T>判断是否是上传模式。</T>
   //
   // @param request WEB输入对象
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean isMultipart(HttpServletRequest request){
      return FWebUpdateParser.isMultipart(request);
   }

   //============================================================
   // <T>分解传入的信息。</T>
   //
   // @param request WEB输入对象
   // @param parameters 参数列表
   // @param files 文件列表
   //============================================================
   @Override
   @SuppressWarnings("rawtypes")
   public void parse(HttpServletRequest request,
                     IAttributes parameters,
                     FWebUploadFiles files){
      // 设置文件解析器
      FWebUpdateParser updateParser = new FWebUpdateParser();
      updateParser.setCharacterEncoding(_encoding);
      updateParser.setUploadTempDir(_directory);
      // 解析上传文件
      _logger.info(this, "parse", "Parse http request. (encoding={1}, directory={2})", _encoding, _directory);
      updateParser.parse(request);
      // 设置参数
      String name = null;
      Enumeration names = request.getParameterNames();
      while(names.hasMoreElements()){
         name = (String)names.nextElement();
         parameters.set(name, request.getParameter(name));
      }
      // 接收上传参数
      parameters.append(updateParser.parameters());
      // 接收上传文件
      files.append(updateParser.files());
   }
}
