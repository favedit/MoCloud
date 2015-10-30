package org.mo.eai.resource.card;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.INamePair;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.eai.resource.REaiResourceExportor;

//============================================================
// <T>卡片模板。</T>
//============================================================
public class FEaiCardTemplate
{
   // 资源访问接口
   private final static IResource _resource = RResource.find(FEaiCardTemplate.class);

   // 卡片资源
   protected FDictionary<FEaiCardResource> _cards = new FDictionary<FEaiCardResource>(FEaiCardResource.class);

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FDictionary<FEaiCardResource> cards(){
      return _cards;
   }

   //============================================================
   // <T>获得卡片。</T>
   //
   // @return 卡片
   //============================================================
   public String findCityCode(String card){
      String cityCode = null;
      FEaiCardResource cardResource = _cards.find(card);
      if(cardResource != null){
         cityCode = cardResource.cityCode();
      }
      return cityCode;
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      ISqlConnection connection = REaiResourceExportor.logicContext.activeConnection(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.card");
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FEaiCardResource city = new FEaiCardResource();
         city.setCityCode(row.get("city_code"));
         city.setCardCode(row.get("card_code"));
         _cards.set(city.cardCode(), city);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_cards.count());
      for(INamePair<FEaiCardResource> pair : _cards){
         pair.value().serialize(output);
      }
   }
}
