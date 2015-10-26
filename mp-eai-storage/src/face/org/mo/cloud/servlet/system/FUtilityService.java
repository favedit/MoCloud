package org.mo.cloud.servlet.system;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>服务器工具服务。</T>
//============================================================
public class FUtilityService
      extends FObject
      implements
         IUtilityService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUtilityService.class);

   //============================================================
   // <T>服务器运行信息查询。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult info(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      // 获得主机信息
      String hostName = null;
      try{
         hostName = InetAddress.getLocalHost().getHostName();
      }catch(UnknownHostException e){
         throw new FFatalError(e);
      }
      // 设置数据
      FXmlNode xmachine = output.config().createNode("Machine");
      xmachine.set("host", hostName);
      //............................................................
      // 获得内存信息
      Runtime runtime = Runtime.getRuntime();
      long availableProcessors = runtime.availableProcessors();
      long totalMemory = runtime.totalMemory();
      long maxMemory = runtime.maxMemory();
      long freeMemory = runtime.freeMemory();
      _logger.debug(this, "info", "Memory: total={1}", totalMemory);
      // 设置数据
      FXmlNode xruntime = output.config().createNode("Runtime");
      xruntime.set("processor_count", availableProcessors);
      xruntime.set("total_memory", totalMemory);
      xruntime.set("max_memory", maxMemory);
      xruntime.set("free_memory", freeMemory);
      return EResult.Success;
   }
}
