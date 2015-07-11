package org.mo.eai.template.card;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceConfiguration;

//============================================================
// <T>卡片模板。</T>
//============================================================
public class FCardTemplate
{
   // 卡片资源
   protected FDictionary<FCardResource> _cards = new FDictionary<FCardResource>(FCardResource.class);

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FDictionary<FCardResource> cards(){
      return _cards;
   }

   //============================================================
   // <T>获得卡片。</T>
   //
   // @return 卡片
   //============================================================
   public String findCityCode(String card){
      String cityCode = null;
      FCardResource cardResource = _cards.find(card);
      if(cardResource != null){
         cityCode = cardResource.cityCode();
      }
      return cityCode;
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      // 打开文件
      FLinesFile file = new FLinesFile();
      file.loadFile(RResourceConfiguration.HomeData + "/card.csv", "GB2312");
      // 读取所有行
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',');
            if(items.length != 3){
               throw new FFatalError("Line is invalid.");
            }
            // 创建卡片
            FCardResource city = new FCardResource();
            city.setCardCode(RString.trim(items[0]));
            city.setCityCode(RString.trim(items[1]));
            _cards.set(city.cardCode(), city);
            System.out.println("Card: " + items[0] + " - " + items[1]);
         }
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_cards.count());
      for(INamePair<FCardResource> pair : _cards){
         pair.value().serialize(output);
      }
   }
}
