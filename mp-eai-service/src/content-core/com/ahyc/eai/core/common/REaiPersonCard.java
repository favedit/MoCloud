package com.ahyc.eai.core.common;

import org.mo.com.lang.RString;

//============================================================
// <T>城市卡片工具类。</T>
//============================================================
public class REaiPersonCard
{
   //============================================================
   // <T>生成城市卡片。</T>
   //
   // @param card 身份证号
   // @return 城市卡片
   //============================================================
   public static String makeCityCard(String card){
      String cityCard = null;
      if(!RString.isEmpty(card)){
         int cardLength = card.length();
         if((cardLength == 8) || (cardLength == 10)){
            return "999999";
         }
         cityCard = RString.left(card, 6);
      }
      return cityCard;
   }
}
