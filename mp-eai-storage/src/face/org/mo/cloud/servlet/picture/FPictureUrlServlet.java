package org.mo.cloud.servlet.picture;

import org.mo.com.lang.RString;
import org.mo.web.core.servlet.IWebServletConstant;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>图片服务。</T>
//============================================================
public class FPictureUrlServlet
      extends FPictureServlet
      implements
         IPictureUrlServlet
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查参数
      String uri = context.parameter(IWebServletConstant.PARAMETER_URI);
      if(RString.isEmpty(uri)){
         sendData(response, null, null);
         return;
      }
      // 分解参数
      String[] codes = RString.splitLastTwo(uri, '/');
      if(codes.length != 2){
         sendData(response, null, null);
         return;
      }
      //      String extension = RFile.extension(codes[1]);
      //      String[] items = RString.splitTwo(codes[1], '_');
      // 解析参数
      //      String stylePack = null;
      //      String resource = null;
      //      if(items.length == 2){
      //         resource = codes[0] + "/" + items[0] + "." + extension;
      //         stylePack = items[1];
      //      }else{
      //         resource = uri;
      //         stylePack = RString.EMPTY;
      //      }
      // 解析样式
      //      SGcStorageImageStyle style = null;
      //      if(!RString.isEmpty(stylePack)){
      //         style = new SGcStorageImageStyle();
      //         style.unpack(stylePack);
      //      }
      // 根据样式处理
      //      if(style == null){
      //         processNoStyle(context, request, response, resource);
      //      }else{
      //         processStyle(context, request, response, resource, style);
      //      }
   }
}
