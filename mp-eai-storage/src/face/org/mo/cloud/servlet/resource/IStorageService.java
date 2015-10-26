package org.mo.cloud.servlet.resource;

import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源存储服务接口。</T>
//============================================================
public interface IStorageService
{
   //============================================================
   // <T>资源存储查询处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult query(IWebContext context,
                 ISqlContext sqlContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>资源存储检查处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult check(IWebContext context,
                 ISqlContext sqlContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>删除文件处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult deleteFile(IWebContext context,
                      ISqlContext sqlContext,
                      IWebInput input,
                      IWebOutput output);

   //============================================================
   // <T>删除文件集合。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult deleteFiles(IWebContext context,
                       ISqlContext sqlContext,
                       IWebInput input,
                       IWebOutput output);

   //============================================================
   // <T>删除目录处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult deleteDirectory(IWebContext context,
                           ISqlContext sqlContext,
                           IWebInput input,
                           IWebOutput output);
}
