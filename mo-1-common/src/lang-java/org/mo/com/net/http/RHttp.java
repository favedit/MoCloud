package org.mo.com.net.http;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FString;

//============================================================
// <T>网络工具。</T>
//============================================================
public class RHttp
{
   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param params 参数集合
   // @return 文件名称
   //============================================================
   public static String makeUrl(String... params){
      FString result = new FString();
      if(params != null){
         int count = params.length;
         for(int n = 0; n < count; n++){
            String param = params[n];
            if(param != null){
               // 写入内容
               if(n < count - 1){
                  if(param.endsWith("/")){
                     result.append(param);
                  }else{
                     result.append(param);
                     result.append("/");
                  }
               }else{
                  result.append(param);
               }
            }
         }
      }
      return result.toString();
   }

   //============================================================
   // <T>获得指定网络地址的数据。</T>
   //
   // @param url 网络地址
   // @return 数据
   //============================================================
   public static byte[] loadUrlBytes(String url){
      try(FHttpConnection http = new FHttpConnection(url)){
         http.connect();
         http.fetch();
         http.disconnect();
         return http.response().data();
      }
   }

   //============================================================
   // <T>获得指定网络地址的字符串。</T>
   //
   // @param url 网络地址
   // @return 字符串
   //============================================================
   public static String loadUrlString(String url){
      byte[] data = loadUrlBytes(url);
      if(data != null){
         return new String(loadUrlBytes(url));
      }
      return null;
   }

   //============================================================
   // <T>获得指定网络地址的字符串。</T>
   //
   // @param url 网络地址
   // @param charset 编码
   // @return 字符串
   //============================================================
   public static String loadUrlString(String url,
                                      String charset){
      byte[] data = loadUrlBytes(url);
      if(data != null){
         try{
            return new String(data, charset);
         }catch(Exception e){
            throw new FFatalError(e);
         }
      }
      return null;
   }

   //============================================================
   // <T>获得指定网络地址的服务。</T>
   //
   // @param url 网络地址
   // @return 处理结果
   //============================================================
   public static boolean loadService(String url){
      FHttpService service = new FHttpService();
      return service.load(url);
   }

   //============================================================
   // <T>获得指定网络地址的服务。</T>
   //
   // @param url 网络地址
   // @param service 服务
   // @return 处理结果
   //============================================================
   public static boolean loadService(String url,
                                     FHttpService service){
      // 检查参数
      if(service == null){
         return false;
      }
      return service.load(url);
   }
}
