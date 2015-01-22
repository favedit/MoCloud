package org.mo.content.face.design.list;

import org.mo.content.core.configuration.common.FAbstractConfigurationService;

import org.mo.content.core.list.IContentListConsole;
import org.mo.content.core.list.common.XList;
import org.mo.core.aop.RAop;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容列表服务。</T>
//============================================================
public class FContentListService
      extends FAbstractConfigurationService
      implements
         IContentListService
{
   //============================================================
   // <T>构造内容列表服务。</T>
   //============================================================
   public FContentListService(){
      _storageName = "cloud";
      _spaceName = "design.list";
   }

   //============================================================
   // <T>从配置文件中加载树目录。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public void catalog(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      IContentListConsole _listConsole = RAop.find(IContentListConsole.class);
      XList xlist = _listConsole.find("cloud", "system.culture.Language");
      System.out.println(xlist.getName());
      super.catalog(context, input, output);
   }
}
