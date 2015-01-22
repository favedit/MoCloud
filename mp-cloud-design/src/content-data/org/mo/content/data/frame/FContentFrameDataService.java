package org.mo.content.data.frame;

import org.mo.content.core.frame.IContentFormConsole;

import org.mo.com.xml.FXmlNode;
import org.mo.content.core.configuration.XContentObject;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FContentFrameDataService
      implements
         IContentFrameDataService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容表单控制台接口
   @ALink
   protected IContentFormConsole _formConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FContentFrameDataService(){
   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void list(IWebContext context,
                    IWebInput input,
                    IWebOutput output){
      XContentObject[] xwindows = _formConsole.list(_storageName);
      FXmlNode xconfig = output.config();
      for(XContentObject xwindow : xwindows){
         FXmlNode xnode = xconfig.createNode("Window");
         xnode.set("type", xwindow.name());
         xnode.set("name", xwindow.get("name"));
         xnode.set("label", xwindow.get("label"));
      }
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void query(IWebContext context,
                     IWebInput input,
                     IWebOutput output){
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void insert(IWebContext context,
                      IWebInput input,
                      IWebOutput output){
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void update(IWebContext context,
                      IWebInput input,
                      IWebOutput output){
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void delete(IWebContext context,
                      IWebInput input,
                      IWebOutput output){
   }
}
