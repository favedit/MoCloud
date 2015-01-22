package org.mo.web.core.upload;

import javax.servlet.http.HttpServletRequest;
import org.mo.com.lang.IAttributes;
import org.mo.web.protocol.common.FWebUploadFiles;

//============================================================
// <T>文件上传控制台接口。</T>
//============================================================
public interface IWebUploadConsole
{
   String directory();

   void parse(HttpServletRequest request,
              IAttributes parameters,
              FWebUploadFiles files);

}
