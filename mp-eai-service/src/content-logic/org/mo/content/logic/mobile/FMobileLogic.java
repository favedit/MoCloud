package org.mo.content.logic.mobile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;

//============================================================
// <T>手机服务接口。</T>
//============================================================
public class FMobileLogic
      extends FObject
      implements
         IMobileLogic
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FMobileLogic(){
   }

   //============================================================
   // <T>根据手机号获取相关信息。</T>
   //
   // @param mobile 手机号码
   //============================================================
   @Override
   public Map<String, String> getMobileInfo(String mobile){

      CloseableHttpClient httpclient = HttpClients.createDefault();
      Map<String, String> mobileInfo = new HashMap<String, String>();
      try{
         //创建HttpGet
         HttpGet httpGet = new HttpGet("http://virtual.paipai.com/extinfo/GetMobileProductInfo?mobile=" + mobile + "&amount=10000&callname=getPhoneNumInfoExtCallback");
         //执行get请求
         CloseableHttpResponse response = httpclient.execute(httpGet);
         try{
            HttpEntity entity = response.getEntity();
            if(entity != null){
               String responseContent = EntityUtils.toString(entity);
               String result = new String(responseContent);
               JSONObject jo = JSONObject.fromObject(result.substring(result.indexOf('(') + 1, result.lastIndexOf(')')));
               _logger.debug(this, "getMobileInfo", "getMobileInfo. (mobileInfo={1})", jo);
               if(!jo.get("province").equals("未知")){
                  mobileInfo.put("province", jo.get("province").toString());
                  mobileInfo.put("city", jo.get("cityname").toString());
                  mobileInfo.put("telString", jo.get("mobile").toString());
                  mobileInfo.put("operators", jo.get("isp").toString());
               }
            }
         }finally{
            response.close();
         }
      }catch(ClientProtocolException e){
         e.printStackTrace();
      }catch(UnsupportedEncodingException e1){
         e1.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         // 关闭连接,释放资源    
         try{
            httpclient.close();
         }catch(IOException e){
            e.printStackTrace();
         }
      }
      return mobileInfo;
   }
}
