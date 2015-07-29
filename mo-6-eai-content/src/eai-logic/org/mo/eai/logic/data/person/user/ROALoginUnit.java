package org.mo.eai.logic.data.person.user;

import com.ycjt.ead.ThreeDes;
import java.util.Date;
import org.mo.com.encoding.RMd5;
import org.mo.com.net.http.FHttpConnection;
//============================================================
//<T>OA接口工具类。</T>
//============================================================

public class ROALoginUnit
{

   //============================================================
   // <T>请求OA登录接口</T>
   //
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
   //============================================================
   public static String oaLogin(String url,
                                String passport,
                                String password){
      //设置参数
      String key = "ycjt*&^%$3fyg";

      String encodePassport = ThreeDes.encode(key, passport);
      String encodePassword = ThreeDes.encode(key, password);
      String appDate = String.valueOf(new Date().getTime());
      String from = "H5";
      String validate = RMd5.encode(encodePassport + encodePassword + appDate + from + key);
      //拼装参数
      String parem = "?username=" + encodePassport + "&pwd=" + encodePassword + "&appDate=" + appDate + "&from=" + from + "&validate=" + validate;
      System.out.println("==========================OALogin  OAlogin  url. url=" + url + parem);
      //发送http请求
      FHttpConnection connection = new FHttpConnection(url + parem);
      connection.connect();
      connection.request().send();
      connection.response().receive();
      connection.disconnect();
      //获取结果并关闭请求
      String result = connection.response().content();
      connection.close();
      return result.trim();
   }
}
