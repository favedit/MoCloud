package org.mo.content.face.mobile.logic.notice;

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

public class TestNoticeAction {
    @Test
    public void testMarkRead() throws ParseException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://10.13.0.16:8010/mobile/logic/notice/Notice.wa?do=markRead";
        HttpPost post = new HttpPost(url);
        List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
        post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421023");
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
