package org.mo.content.face.resource.material;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.FObject;
import org.mo.content.engine3d.core.model.IRs3ModelConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FMaterialServlet
      extends FObject
      implements
         IMaterialServlet
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FStorageServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源模型接口
   @ALink
   protected IRs3ModelConsole _modelConsole;

   //============================================================
   // <T>逻辑处理。</T>
   // <P>catalog:分类</P>
   // <P>date:日期</P>
   // <P>code:代码</P>
   // <P>version:版本</P>
   // <P>type:类型，没有的话，存储为 bin</P>
   // <P>size:大小</P>
   // <P>存储位置：\{catalog}\{date:yyyymmdd}\{code}\{version}.{type}</P>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
   }
}
