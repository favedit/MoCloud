package org.mo.content.core.excel.synchronize;

import org.mo.com.net.http.FHttpConnection;
import org.mo.com.xml.FXmlNode;

public class RStatisticsMobile
{

   public static void main(String[] args){
      FXmlNode inputNode = new FXmlNode("Service");
      inputNode.set("action", "getMobileInfo");
      inputNode.createNode("mobile").setText("18710555908");

      FHttpConnection connection = new FHttpConnection("http://localhost:8099/eai.info.mobile.ws");
      //      try(FHttpConnection connection = new FHttpConnection("http://localhost:8099/eai.info.mobile.ws")){
      //         result = connection.fetch();
      //      }
      //FHttpConnection connection = new FHttpConnection("http://10.12.20.218:8019/cloud.person.user.ws");
      connection.connect();
      connection.request().setText(inputNode.xml().toString());
      connection.request().send();
      connection.response().receive();
      connection.disconnect();

      String content = connection.response().content();
      System.out.println(content);

      //      CloseableHttpClient httpclient = HttpClients.createDefault();
      //      JSONObject jo = JSONObject.fromObject("{}");
      //      try{
      //         //创建HttpGet
      //         String url = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?mobile=18710555908&amount=10&callname=getPhoneNumInfoExtCallback";
      //         //         String url = "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18710555908";
      //         HttpGet httpGet = new HttpGet(url);
      //         //执行get请求
      //         CloseableHttpResponse response = httpclient.execute(httpGet);
      //         try{
      //            HttpEntity entity = response.getEntity();
      //            if(entity != null){
      //               String responseContent = EntityUtils.toString(entity);
      //               String result = new String(responseContent.getBytes("utf-8"));
      //               System.out.println(result);
      //               jo = JSONObject.fromObject(result.substring(result.indexOf('(') + 1, result.lastIndexOf(')')));
      //               if(jo.get("province").equals("未知")){
      //                  jo = JSONObject.fromObject("{}");
      //               }
      //            }
      //         }finally{
      //            response.close();
      //         }
      //      }catch(ClientProtocolException e){
      //         e.printStackTrace();
      //      }catch(UnsupportedEncodingException e1){
      //         e1.printStackTrace();
      //      }catch(IOException e){
      //         e.printStackTrace();
      //      }catch(Exception e){
      //         e.printStackTrace();
      //      }finally{
      //         // 关闭连接,释放资源    
      //         try{
      //            httpclient.close();
      //         }catch(IOException e){
      //            e.printStackTrace();
      //         }
      //         System.out.println(jo);
      //      }

   }
}
