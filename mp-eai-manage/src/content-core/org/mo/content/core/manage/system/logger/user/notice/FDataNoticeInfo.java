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
   }
}
