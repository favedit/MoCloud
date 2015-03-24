package org.mo.cloud.design.data.frame;

import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.frame.IFrameConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
//<T>数据表单服务。</T>
//============================================================
public class FFrameService
      implements
         IFrameService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容表单控制台接口
   @ALink
   protected IFrameConsole _frameConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FFrameService(){
   }

   //============================================================
   // <T>获取数据集合。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public EResult fetchDataset(IWebContext context,
                               ISqlContext sqlContext,
                               FXmlNode xconfig,
                               FXmlNode xoutput){
      String name = xconfig.get("name");
      XContentObject xframe = _frameConsole.find(_storageName, name, EPersistenceMode.Config);
      ISqlConnection connection = sqlContext.activeConnection();
      // 生成查询命令
      FDataCommandBuilder builder = new FDataCommandBuilder();
      builder.setDataName((String)xframe.get("dataset_name"));
      for(XContentObject child : xframe.children()){
         FDataField field = new FDataField();
         field.setDataName((String)child.get("data_name"));
         builder.fields().push(field);
      }
      String sql = builder.makeFetchCommand();
      // 生成数据集合
      FXmlNode xdataset = xoutput.createNode("Dataset");
      xdataset.set("name", name);
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FXmlNode xrow = xdataset.createNode("Row");
         xrow.attributes().assign(row);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获取数据集合。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ISqlContext sqlContext,
                        IWebInput input,
                        IWebOutput output){
      FXmlNode xinput = input.config();
      FXmlNode xoutput = output.config();
      for(FXmlNode xnode : xinput){
         if(xnode.isName("Frame")){
            fetchDataset(context, sqlContext, xnode, xoutput);
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>数据准备处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult prepare(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>数据新建处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult insert(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
