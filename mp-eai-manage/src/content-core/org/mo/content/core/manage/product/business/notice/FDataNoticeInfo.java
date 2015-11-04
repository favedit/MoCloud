package org.mo.content.core.manage.product.business.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import java.util.Map;

public class FDataNoticeInfo 
      extends 
         FDataLogicNoticeUnit 
{
   // 状态字符串
   private String _statusCdStr;
   // 外链状态字符串
   private String _linkCdStr;
   // 显示字符串
   private String _displayCdStr;

   private String _imageName;
   //用户名称
   private String _userName;
   
   public String getUserName() {
      return _userName;
   }

   public void setUserName(String _userName) {
      this._userName = _userName;
   }
   
   public String getLinkCdStr() {
      return _userName;
   }

   public void setLinkCdStr(String _linkCdStr) {
      this._linkCdStr = _linkCdStr;
   }

   public String getStatusCdStr() {
      return _statusCdStr;
   }

   public void setStatusCdStr(String _statusCdStr) {
      this._statusCdStr = _statusCdStr;
   }

   public String getImageName() {
      return _imageName;
   }

   public void setImageName(String _imageName) {
      this._imageName = _imageName;
   }

   public String getDisplayCdStr() {
      return _displayCdStr;
   }

   public void setDisplayCdStr(String _displayCdStr) {
      this._displayCdStr = _displayCdStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("linkCdStr", _linkCdStr);
      map.put("displayCdStr", _displayCdStr);
      map.put("imageName", _imageName);
      map.put("userName", _userName);
   }
}
