package org.mo.content.core.manage.system.logger.user.notice;

import com.cyou.gccloud.data.data.FDataPersonUserNoticeUnit;
import java.util.Map;

//============================================================
//<T>用户访问信息</T>
//============================================================
public class FDataNoticeInfo
      extends FDataPersonUserNoticeUnit
{

   // 开始时间字符串
   protected String _beginDateStr;

   // 结束时间符串
   protected String _endDateStr;

   protected String _activeCdStr;
   //用户名
   protected String _userName;
   //公告标题
   protected String _noticeLabel;

   public String userName(){
      return _userName;
   }

   public void setUserName(String _userName){
      this._userName = _userName;
   }
   public String noticeLabel(){
      return _activeCdStr;
   }
   
   public void setNoticeLabel(String _noticeLabel){
      this._noticeLabel = _noticeLabel;
   }
   public String activeCdStr(){
      return _activeCdStr;
   }
   
   public void setActiveCdStr(String _activeCdStr){
      this._activeCdStr = _activeCdStr;
   }

   public String beginDateStr(){
      return _beginDateStr;
   }

   public void setBeginDateStr(String _beginDateStr){
      this._beginDateStr = _beginDateStr;
   }

   public String endDateStr(){
      return _endDateStr;
   }

   public void setEndDateStr(String _endDateStr){
      this._endDateStr = _endDateStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("beginDateStr", _beginDateStr);
      map.put("endDateStr", _endDateStr);
      map.put("activeCdStr", _activeCdStr);
      map.put("userName", _userName);
      map.put("noticeLabel", _noticeLabel);
   }
}
