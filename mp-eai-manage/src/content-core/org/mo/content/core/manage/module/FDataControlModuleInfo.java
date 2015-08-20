package org.mo.content.core.manage.module;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import java.util.Map;
import org.mo.com.lang.RInteger;

public class FDataControlModuleInfo
      extends FDataControlModuleUnit
{
   // 字段查看有效类型的定义。
   protected int _viewValidCd;

   public int viewValidCd(){
      return _viewValidCd;
   }

   public void setViewValidCd(int _viewValidCd){
      this._viewValidCd = _viewValidCd;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("viewValidCd", RInteger.toString(_viewValidCd));
   }
}
