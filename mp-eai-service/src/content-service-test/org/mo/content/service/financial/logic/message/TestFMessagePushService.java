package org.mo.content.service.financial.logic.message;

import com.jianzhou.sdk.BusinessService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.mo.com.lang.type.TDateTime;

public class TestFMessagePushService {
    @Test
    public void testPushSMS() throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.100:8020/eai.financial.logic.message.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("link_id", "33"));
        listPram.add(new BasicNameValuePair("login_date", new TDateTime(
                new Date()).toString()));// 20151019103636时间戳
        // listPram.add(new BasicNameValuePair("mo-session-id",
        // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
        post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
        listPram.add(new BasicNameValuePair("action", "pushSMS"));
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        System.out.println(EntityUtils.toString(post.getEntity()));
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }

    }

    @Test
    public void testSendMessage() {
        BusinessService bs = new BusinessService();
        bs.setWebService("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService");
        /*
         * System.out.println("短信接口返回:" + bs.sendBatchMessage("sdk_yucheng",
         * "1qazxsw2", "15311444853", "测试短信接口来自钰诚集团测试【钰诚办公平台】"));
         */
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()));
    }

}
