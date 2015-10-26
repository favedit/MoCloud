package org.mo.content.service.mobile.logic.notice;

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

public class TestFNoticeService {
    @Test
    public void testSelect() throws ParseException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.16:8020/eai.mobile.logic.notice.wsp";
        // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("page_size", "9"));
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        listPram.add(new BasicNameValuePair("page_number", "1"));
        listPram.add(new BasicNameValuePair("action", "select"));
        post.setHeader("mo-session-id", "5E4137EB3AD343507454DC0719502E8D");
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }
    }

    @Test
    public void testMarkRead() throws ParseException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.16:8020/eai.mobile.logic.notice.wsp";
        // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        listPram.add(new BasicNameValuePair("format_cd", "json"));
        listPram.add(new BasicNameValuePair("action", "markRead"));
        listPram.add(new BasicNameValuePair("notice_id",
                "9EECE08E649C49CC982414BEBB511C69"));
        post.setHeader("mo-session-id", "5E4137EB3AD343507454DC0719502E8D");
        post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
        CloseableHttpResponse response = httpclient.execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
            System.out.println(result);
        }
    }
}
