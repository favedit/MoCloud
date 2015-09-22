package org.mo.cloud.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>逻辑单元工具类。</T>
//============================================================
public class RLogicUnit
{
   //============================================================
   // <T>数据单元转换为JSON列表。</T>
   //
   // @param units 数据单元集合
   // @return JSON对象
   //============================================================
   @SuppressWarnings({"rawtypes", "unchecked"})
   public static String toJsonList(FLogicUnit[] units,
                                   int total){
      List list = new ArrayList();
      if(units != null){
         for(FLogicUnit unit : units){
            Map<String, String> map = new HashMap<>();
            unit.saveMap(map);
            JSONObject rowObject = JSONObject.fromObject(map);
            list.add(rowObject);
         }
      }

      String json = "{\"total\":" + total + ",\"rows\":" + list + "}";
      return json;
   }

}
