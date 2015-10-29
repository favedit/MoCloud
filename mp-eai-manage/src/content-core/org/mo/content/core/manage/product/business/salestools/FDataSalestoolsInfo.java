package org.mo.content.core.manage.product.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import java.util.Map;

public class FDataSalestoolsInfo
      extends FDataLogicSalestoolsUnit
{

   // 状态字符串
   private String _statusCdStr;

   // 外链状态字符串
   private String _linkCdStr;

   // 显示字符串
   private String _displayCdStr;

   private String _imageName;

   private String _makeUrl;

   public String makeUrl(){
      return _makeUrl;
   }

   public void setMakeUrl(String _makeUrl){
      this._makeUrl = _makeUrl;
   }

   public String getLinkCdStr(){
      return _linkCdStr;
   }

   public void setLinkCdStr(String _linkCdStr){
      this._linkCdStr = _linkCdStr;
   }

   public String getStatusCdStr(){
      return _statusCdStr;
   }

   public void setStatusCdStr(String _statusCdStr){
      this._statusCdStr = _statusCdStr;
   }

   public String getImageName(){
      return _imageName;
   }

   public void setImageName(String _imageName){
      this._imageName = _imageName;
   }

   public String getDisplayCdStr(){
      return _displayCdStr;
   }

   public void setDisplayCdStr(String _displayCdStr){
      this._displayCdStr = _displayCdStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("linkCdStr", _linkCdStr);
      map.put("displayCdStr", _displayCdStr);
      map.put("imageName", _imageName);
      map.put("makeUrl", _makeUrl);
   }
}
