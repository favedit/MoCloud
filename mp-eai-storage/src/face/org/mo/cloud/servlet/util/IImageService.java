package org.mo.cloud.servlet.util;

import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源存储服务接口。</T>
//============================================================
public interface IImageService
{
   //============================================================
   // <T>图片处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   ISqlContext sqlContext,
                   IWebInput input,
                   IWebOutput output);
}
