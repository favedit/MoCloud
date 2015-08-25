package org.mo.content.face;

import com.jianzhou.sdk.BusinessService;
import java.util.Random;

public class FTestFile
{

   public static void main(String[] args){
      BusinessService bs = new BusinessService();
      bs.setWebService("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService");

      //      int result = bs.sendBatchMessage("sdk_yucheng", "1qazxsw2", "18710555908", "您正在使用[全球实时数据中心系统]进行账户绑定，验证码" + FTestFile.game(4) + ",打死都不要告诉别人哟。[智慧企业]【钰诚办公平台】");
      System.out.println(FTestFile.game(4));
   }

   /**
    * 获取count个随机数
    * @param count 随机数个数
    * @return
    */
   public static String game(int count){
      StringBuffer sb = new StringBuffer();
      String str = "0123456789abcdefghijklmnopqrstuvwxyz";
      Random r = new Random();
      for(int i = 0; i < count; i++){
         int num = r.nextInt(str.length());
         sb.append(str.charAt(num));
         str = str.replace((str.charAt(num) + ""), "");
      }
      return sb.toString();
   }
}
