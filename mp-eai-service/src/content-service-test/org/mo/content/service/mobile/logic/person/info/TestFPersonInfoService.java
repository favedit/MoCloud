package org.mo.content.service.mobile.logic.person.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFPersonInfoService {
    @Test
    public void testPersonInfo() throws ParseException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.16:8020/eai.mobile.logic.person.info.wsp";
        // String url = "http://eai.ezubo.com:8089/eai.mobile.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421023");
        listPram.add(new BasicNameValuePair("action", "personInfo"));
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

}
