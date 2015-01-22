package org.mo.content.data.list;

import org.mo.com.xml.FXmlNode;
import org.mo.content.core.list.IContentListConsole;
import org.mo.content.core.list.common.XList;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FContentListDataService
      implements
         IContentListDataService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容列表控制台接口
   @ALink
   protected IContentListConsole _listConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FContentListDataService(){
      //_storageName = "cloud";
      //_spaceName = "design.form";
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
      XList[] xlists = _listConsole.list(_storageName);
      FXmlNode xconfig = output.config();
      for(XList xlist : xlists){
         FXmlNode xnode = xconfig.createNode("Node");
         xnode.set("name", xlist.getName());
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
