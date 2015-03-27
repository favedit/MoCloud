package org.mo.content.face.resource3d.mesh;

import com.cyou.gccloud.logic.resource3d.mesh.FGcRs3MeshUnit;
import com.cyou.gccloud.logic.resource3d.mesh.IGcRs3MeshConsole;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.engine3d.core.mesh.IRs3MeshConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FMeshServlet
      extends FObject
      implements
         IMeshServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMeshServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 数据网格控制台
   @ALink
   protected IGcRs3MeshConsole _dataMeshConsole;

   // 资源网格接口
   @ALink
   protected IRs3MeshConsole _meshConsole;

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
      // 检查参数
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Mesh guid and code is empty.");
      }
      // 获得唯一编号
      if(RString.isEmpty(guid)){
         FGcRs3MeshUnit unit = _dataMeshConsole.findByFullCode(logicContext, code);
         if(unit == null){
            unit = _dataMeshConsole.findByCode(logicContext, code);
         }
         if(unit != null){
            guid = unit.guid();
         }else{
            throw new FFatalError("process", "Model guid is not exists. (code={1})", code);
         }
      }
      //............................................................
      // 生成数据
      byte[] data = _meshConsole.makeMeshData(logicContext, guid);
      if(data == null){
         throw new FFatalError("process", "Model is not exists. (guid={1}, code={2})", guid, code);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send model data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }
}
