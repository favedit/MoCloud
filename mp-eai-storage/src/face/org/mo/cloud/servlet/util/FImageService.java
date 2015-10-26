package org.mo.cloud.servlet.util;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源存储服务接口。</T>
//============================================================
public class FImageService
      extends FObject
      implements
         IImageService
{
   // 会话控制台
   //   @ALink
   //   protected IGcSessionConsole _sessionConsole;

   //============================================================
   // <T>图片缩放处理。</T>
   //
   // @param xconfig 配置信息
   // @return 处理结果
   //============================================================
   public EResult processResize(FXmlNode xconfig){
      //      String sourceName = xconfig.get("source");
      //      int radius = xconfig.getInt("radius");
      //      FImage image = new FImage(sourceName);
      //      image.round(radius);
      //      image.saveFile(sourceName + "-" + radius);
      return EResult.Success;
   }

   //============================================================
   // <T>图片圆角处理。</T>
   //
   // @param xconfig 配置信息
   // @return 处理结果
   //============================================================
   public EResult processRound(FXmlNode xconfig){
      return EResult.Success;
   }

   //============================================================
   // <T>图片处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          ISqlContext sqlContext,
                          IWebInput input,
                          IWebOutput output){
      // 获得参数
      FXmlNode xinput = input.config();
      FXmlNode xprocessList = xinput.findNode("ProcessList");
      for(FXmlNode xprocess : xprocessList.nodes()){
         if(xprocess.isName("Process")){
            String typeCd = xprocess.get("type");
            switch(typeCd){
               case "Resize":
                  processResize(xprocess);
                  break;
               case "Round":
                  processRound(xprocess);
                  break;
               default:
                  throw new FFatalError("Process type is invalid. (type={1})", typeCd);
            }
         }
      }
      return EResult.Success;
   }
}
