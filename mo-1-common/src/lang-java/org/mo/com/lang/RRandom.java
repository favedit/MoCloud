package org.mo.com.lang;

import java.util.Random;
//============================================================
//<T>随机数工具类。</T>
//
//@class
//@author SUNHR
//@history 150825 Create
//============================================================

public class RRandom
{

   //============================================================
   // <T>获取指定位数的数字随机数。</T>
   //
   // @param count 位数
   // @return 随机数
   //============================================================
   public static String getNumberRandom(int count){
      StringBuffer sb = new StringBuffer();
      String str = "0123456789";
      Random r = new Random();
      for(int i = 0; i < count; i++){
         int num = r.nextInt(str.length());
         sb.append(str.charAt(num));
         str = str.replace((str.charAt(num) + ""), "");
      }
      return sb.toString();
   }
}
