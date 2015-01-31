package org.mo.cloud.design.describe.dataset;

import org.mo.cloud.content.design.list.common.XList;

import org.mo.cloud.content.design.list.IListConsole;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FDatasetService
      implements
         IDatasetService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容列表控制台接口
   @ALink
   protected IListConsole _listConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FDatasetService(){
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
