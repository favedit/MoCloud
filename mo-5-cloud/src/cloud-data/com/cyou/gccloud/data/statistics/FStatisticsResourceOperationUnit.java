package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>资源操作统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsResourceOperationUnit
      extends FLogicUnit
{
   // 存储字段对象标识的定义。
   private long __ouid;

   // 字段对象标识的定义。
   protected long _ouid;

   // 存储字段有效性的定义。
   private boolean __ovld;

   // 字段有效性的定义。
   protected boolean _ovld;

   // 存储字段对象唯一标识的定义。
   private String __guid;

   // 字段对象唯一标识的定义。
   protected String _guid;

   // 存储字段记录年的定义。
   private TDateTime __recordYear = new TDateTime();

   // 字段记录年的定义。
   protected TDateTime _recordYear = new TDateTime();

   // 存储字段记录月的定义。
   private TDateTime __recordMonth = new TDateTime();

   // 字段记录月的定义。
   protected TDateTime _recordMonth = new TDateTime();

   // 存储字段记录周的定义。
   private TDateTime __recordWeek = new TDateTime();

   // 字段记录周的定义。
   protected TDateTime _recordWeek = new TDateTime();

   // 存储字段记录日的定义。
   private TDateTime __recordDay = new TDateTime();

   // 字段记录日的定义。
   protected TDateTime _recordDay = new TDateTime();

   // 存储字段记录小时的定义。
   private TDateTime __recordHour = new TDateTime();

   // 字段记录小时的定义。
   protected TDateTime _recordHour = new TDateTime();

   // 存储字段记录日期的定义。
   private TDateTime __recordDate = new TDateTime();

   // 字段记录日期的定义。
   protected TDateTime _recordDate = new TDateTime();

   // 存储字段资源编号的定义。
   private long __resourceId;

   // 字段资源编号的定义。
   protected long _resourceId;

   // 存储字段查看总数的定义。
   private int __viewTotal;

   // 字段查看总数的定义。
   protected int _viewTotal;

   // 存储字段查看次数的定义。
   private int __viewCount;

   // 字段查看次数的定义。
   protected int _viewCount;

   // 存储字段播放总数的定义。
   private int __playTotal;

   // 字段播放总数的定义。
   protected int _playTotal;

   // 存储字段播放次数的定义。
   private int __playCount;

   // 字段播放次数的定义。
   protected int _playCount;

   // 存储字段点攒总数的定义。
   private int __pariseTotal;

   // 字段点攒总数的定义。
   protected int _pariseTotal;

   // 存储字段点攒次数的定义。
   private int __pariseCount;

   // 字段点攒次数的定义。
   protected int _pariseCount;

   // 存储字段下载总数的定义。
   private int __downloadTotal;

   // 字段下载总数的定义。
   protected int _downloadTotal;

   // 存储字段下载次数的定义。
   private int __downloadCount;

   // 字段下载次数的定义。
   protected int _downloadCount;

   // 存储字段创建用户标识的定义。
   private long __createUserId;

   // 字段创建用户标识的定义。
   protected long _createUserId;

   // 存储字段创建日期的定义。
   private TDateTime __createDate = new TDateTime();

   // 字段创建日期的定义。
   protected TDateTime _createDate = new TDateTime();

   // 存储字段更新者标识的定义。
   private long __updateUserId;

   // 字段更新者标识的定义。
   protected long _updateUserId;

   // 存储字段更新时间的定义。
   private TDateTime __updateDate = new TDateTime();

   // 字段更新时间的定义。
   protected TDateTime _updateDate = new TDateTime();

   //============================================================
   // <T>构造资源操作统计表逻辑单元。</T>
   //============================================================
   public FStatisticsResourceOperationUnit(){
   }

   //============================================================
   // <T>判断对象标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOuidChanged(){
      return __ouid != _ouid;
   }

   //============================================================
   // <T>获得对象标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long ouid(){
      return _ouid;
   }

   //============================================================
   // <T>设置对象标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOuid(long value){
      _ouid = value;
   }

   //============================================================
   // <T>判断有效性的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOvldChanged(){
      return __ovld != _ovld;
   }

   //============================================================
   // <T>获得有效性的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean ovld(){
      return _ovld;
   }

   //============================================================
   // <T>设置有效性的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOvld(boolean value){
      _ovld = value;
   }

   //============================================================
   // <T>判断对象唯一标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGuidChanged(){
      return !RString.equals(__guid, _guid);
   }

   //============================================================
   // <T>获得对象唯一标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置对象唯一标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGuid(String value){
      _guid = value;
   }

   //============================================================
   // <T>判断记录年的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordYearChanged(){
      return !__recordYear.equals(_recordYear);
   }

   //============================================================
   // <T>获得记录年的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordYear(){
      return _recordYear;
   }

   //============================================================
   // <T>设置记录年的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordYear(TDateTime value){
      _recordYear = value;
   }

   //============================================================
   // <T>判断记录月的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordMonthChanged(){
      return !__recordMonth.equals(_recordMonth);
   }

   //============================================================
   // <T>获得记录月的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordMonth(){
      return _recordMonth;
   }

   //============================================================
   // <T>设置记录月的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordMonth(TDateTime value){
      _recordMonth = value;
   }

   //============================================================
   // <T>判断记录周的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordWeekChanged(){
      return !__recordWeek.equals(_recordWeek);
   }

   //============================================================
   // <T>获得记录周的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordWeek(){
      return _recordWeek;
   }

   //============================================================
   // <T>设置记录周的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordWeek(TDateTime value){
      _recordWeek = value;
   }

   //============================================================
   // <T>判断记录日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordDayChanged(){
      return !__recordDay.equals(_recordDay);
   }

   //============================================================
   // <T>获得记录日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordDay(){
      return _recordDay;
   }

   //============================================================
   // <T>设置记录日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordDay(TDateTime value){
      _recordDay = value;
   }

   //============================================================
   // <T>判断记录小时的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordHourChanged(){
      return !__recordHour.equals(_recordHour);
   }

   //============================================================
   // <T>获得记录小时的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordHour(){
      return _recordHour;
   }

   //============================================================
   // <T>设置记录小时的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordHour(TDateTime value){
      _recordHour = value;
   }

   //============================================================
   // <T>判断记录日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordDateChanged(){
      return !__recordDate.equals(_recordDate);
   }

   //============================================================
   // <T>获得记录日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordDate(){
      return _recordDate;
   }

   //============================================================
   // <T>设置记录日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordDate(TDateTime value){
      _recordDate = value;
   }

   //============================================================
   // <T>判断资源编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResourceIdChanged(){
      return __resourceId != _resourceId;
   }

   //============================================================
   // <T>获得资源编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long resourceId(){
      return _resourceId;
   }

   //============================================================
   // <T>设置资源编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResourceId(long value){
      _resourceId = value;
   }

   //============================================================
   // <T>判断查看总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isViewTotalChanged(){
      return __viewTotal != _viewTotal;
   }

   //============================================================
   // <T>获得查看总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int viewTotal(){
      return _viewTotal;
   }

   //============================================================
   // <T>设置查看总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setViewTotal(int value){
      _viewTotal = value;
   }

   //============================================================
   // <T>判断查看次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isViewCountChanged(){
      return __viewCount != _viewCount;
   }

   //============================================================
   // <T>获得查看次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int viewCount(){
      return _viewCount;
   }

   //============================================================
   // <T>设置查看次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setViewCount(int value){
      _viewCount = value;
   }

   //============================================================
   // <T>判断播放总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPlayTotalChanged(){
      return __playTotal != _playTotal;
   }

   //============================================================
   // <T>获得播放总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int playTotal(){
      return _playTotal;
   }

   //============================================================
   // <T>设置播放总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPlayTotal(int value){
      _playTotal = value;
   }

   //============================================================
   // <T>判断播放次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPlayCountChanged(){
      return __playCount != _playCount;
   }

   //============================================================
   // <T>获得播放次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int playCount(){
      return _playCount;
   }

   //============================================================
   // <T>设置播放次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPlayCount(int value){
      _playCount = value;
   }

   //============================================================
   // <T>判断点攒总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPariseTotalChanged(){
      return __pariseTotal != _pariseTotal;
   }

   //============================================================
   // <T>获得点攒总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int pariseTotal(){
      return _pariseTotal;
   }

   //============================================================
   // <T>设置点攒总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPariseTotal(int value){
      _pariseTotal = value;
   }

   //============================================================
   // <T>判断点攒次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPariseCountChanged(){
      return __pariseCount != _pariseCount;
   }

   //============================================================
   // <T>获得点攒次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int pariseCount(){
      return _pariseCount;
   }

   //============================================================
   // <T>设置点攒次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPariseCount(int value){
      _pariseCount = value;
   }

   //============================================================
   // <T>判断下载总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDownloadTotalChanged(){
      return __downloadTotal != _downloadTotal;
   }

   //============================================================
   // <T>获得下载总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int downloadTotal(){
      return _downloadTotal;
   }

   //============================================================
   // <T>设置下载总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDownloadTotal(int value){
      _downloadTotal = value;
   }

   //============================================================
   // <T>判断下载次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDownloadCountChanged(){
      return __downloadCount != _downloadCount;
   }

   //============================================================
   // <T>获得下载次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int downloadCount(){
      return _downloadCount;
   }

   //============================================================
   // <T>设置下载次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDownloadCount(int value){
      _downloadCount = value;
   }

   //============================================================
   // <T>判断创建用户标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateUserIdChanged(){
      return __createUserId != _createUserId;
   }

   //============================================================
   // <T>获得创建用户标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long createUserId(){
      return _createUserId;
   }

   //============================================================
   // <T>设置创建用户标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateUserId(long value){
      _createUserId = value;
   }

   //============================================================
   // <T>判断创建日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateDateChanged(){
      return !__createDate.equals(_createDate);
   }

   //============================================================
   // <T>获得创建日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime createDate(){
      return _createDate;
   }

   //============================================================
   // <T>设置创建日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateDate(TDateTime value){
      _createDate = value;
   }

   //============================================================
   // <T>判断更新者标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateUserIdChanged(){
      return __updateUserId != _updateUserId;
   }

   //============================================================
   // <T>获得更新者标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long updateUserId(){
      return _updateUserId;
   }

   //============================================================
   // <T>设置更新者标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateUserId(long value){
      _updateUserId = value;
   }

   //============================================================
   // <T>判断更新时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateDateChanged(){
      return !__updateDate.equals(_updateDate);
   }

   //============================================================
   // <T>获得更新时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime updateDate(){
      return _updateDate;
   }

   //============================================================
   // <T>设置更新时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateDate(TDateTime value){
      _updateDate = value;
   }

   //============================================================
   // <T>根据名称获得内容。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   @Override
   public String get(String name){
      switch(name){
         case "ouid":
            return Long.toString(_ouid);
         case "ovld":
            return RBoolean.toString(_ovld);
         case "guid":
            return _guid;
         case "record_year":
            return _recordYear.toString();
         case "record_month":
            return _recordMonth.toString();
         case "record_week":
            return _recordWeek.toString();
         case "record_day":
            return _recordDay.toString();
         case "record_hour":
            return _recordHour.toString();
         case "record_date":
            return _recordDate.toString();
         case "resource_id":
            return Long.toString(_resourceId);
         case "view_total":
            return RInteger.toString(_viewTotal);
         case "view_count":
            return RInteger.toString(_viewCount);
         case "play_total":
            return RInteger.toString(_playTotal);
         case "play_count":
            return RInteger.toString(_playCount);
         case "parise_total":
            return RInteger.toString(_pariseTotal);
         case "parise_count":
            return RInteger.toString(_pariseCount);
         case "download_total":
            return RInteger.toString(_downloadTotal);
         case "download_count":
            return RInteger.toString(_downloadCount);
         case "create_user_id":
            return Long.toString(_createUserId);
         case "create_date":
            return _createDate.toString();
         case "update_user_id":
            return Long.toString(_updateUserId);
         case "update_date":
            return _updateDate.toString();
      }
      return null;
   }

   //============================================================
   // <T>根据名称设置内容。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void set(String name,
                   String value){
      switch(name){
         case "ouid":
            _ouid = RLong.parse(value);
            break;
         case "ovld":
            _ovld = RBoolean.parse(value);
            break;
         case "guid":
            _guid = value;
            break;
         case "record_year":
            _recordYear.parse(value);
            break;
         case "record_month":
            _recordMonth.parse(value);
            break;
         case "record_week":
            _recordWeek.parse(value);
            break;
         case "record_day":
            _recordDay.parse(value);
            break;
         case "record_hour":
            _recordHour.parse(value);
            break;
         case "record_date":
            _recordDate.parse(value);
            break;
         case "resource_id":
            _resourceId = RLong.parse(value);
            break;
         case "view_total":
            _viewTotal = RInteger.parse(value);
            break;
         case "view_count":
            _viewCount = RInteger.parse(value);
            break;
         case "play_total":
            _playTotal = RInteger.parse(value);
            break;
         case "play_count":
            _playCount = RInteger.parse(value);
            break;
         case "parise_total":
            _pariseTotal = RInteger.parse(value);
            break;
         case "parise_count":
            _pariseCount = RInteger.parse(value);
            break;
         case "download_total":
            _downloadTotal = RInteger.parse(value);
            break;
         case "download_count":
            _downloadCount = RInteger.parse(value);
            break;
         case "create_user_id":
            _createUserId = RLong.parse(value);
            break;
         case "create_date":
            _createDate.parse(value);
            break;
         case "update_user_id":
            _updateUserId = RLong.parse(value);
            break;
         case "update_date":
            _updateDate.parse(value);
            break;
      }
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void load(FRow row){
      super.load(row);
      for(IStringPair pair : row){
         String name = pair.name();
         String value = pair.value();
         switch(name){
            case "ouid":
               __ouid = RLong.parse(value);
               _ouid = __ouid;
               break;
            case "ovld":
               __ovld = RBoolean.parse(value);
               _ovld = __ovld;
               break;
            case "guid":
               __guid = value;
               _guid = __guid;
               break;
            case "record_year":
               __recordYear.parse(value);
               _recordYear.assign(__recordYear);
               break;
            case "record_month":
               __recordMonth.parse(value);
               _recordMonth.assign(__recordMonth);
               break;
            case "record_week":
               __recordWeek.parse(value);
               _recordWeek.assign(__recordWeek);
               break;
            case "record_day":
               __recordDay.parse(value);
               _recordDay.assign(__recordDay);
               break;
            case "record_hour":
               __recordHour.parse(value);
               _recordHour.assign(__recordHour);
               break;
            case "record_date":
               __recordDate.parse(value);
               _recordDate.assign(__recordDate);
               break;
            case "resource_id":
               __resourceId = RLong.parse(value);
               _resourceId = __resourceId;
               break;
            case "view_total":
               __viewTotal = RInteger.parse(value);
               _viewTotal = __viewTotal;
               break;
            case "view_count":
               __viewCount = RInteger.parse(value);
               _viewCount = __viewCount;
               break;
            case "play_total":
               __playTotal = RInteger.parse(value);
               _playTotal = __playTotal;
               break;
            case "play_count":
               __playCount = RInteger.parse(value);
               _playCount = __playCount;
               break;
            case "parise_total":
               __pariseTotal = RInteger.parse(value);
               _pariseTotal = __pariseTotal;
               break;
            case "parise_count":
               __pariseCount = RInteger.parse(value);
               _pariseCount = __pariseCount;
               break;
            case "download_total":
               __downloadTotal = RInteger.parse(value);
               _downloadTotal = __downloadTotal;
               break;
            case "download_count":
               __downloadCount = RInteger.parse(value);
               _downloadCount = __downloadCount;
               break;
            case "create_user_id":
               __createUserId = RLong.parse(value);
               _createUserId = __createUserId;
               break;
            case "create_date":
               __createDate.parse(value);
               _createDate.assign(__createDate);
               break;
            case "update_user_id":
               __updateUserId = RLong.parse(value);
               _updateUserId = __updateUserId;
               break;
            case "update_date":
               __updateDate.parse(value);
               _updateDate.assign(__updateDate);
               break;
         }
      }
   }

   //============================================================
   // <T>存储行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void save(FRow row){
      super.load(row);
      row.set("ouid", _ouid);
      row.set("ovld", _ovld);
      row.set("guid", _guid);
      row.set("recordYear", _recordYear);
      row.set("recordMonth", _recordMonth);
      row.set("recordWeek", _recordWeek);
      row.set("recordDay", _recordDay);
      row.set("recordHour", _recordHour);
      row.set("recordDate", _recordDate);
      row.set("resourceId", _resourceId);
      row.set("viewTotal", _viewTotal);
      row.set("viewCount", _viewCount);
      row.set("playTotal", _playTotal);
      row.set("playCount", _playCount);
      row.set("pariseTotal", _pariseTotal);
      row.set("pariseCount", _pariseCount);
      row.set("downloadTotal", _downloadTotal);
      row.set("downloadCount", _downloadCount);
      row.set("createUserId", _createUserId);
      row.set("createDate", _createDate);
      row.set("updateUserId", _updateUserId);
      row.set("updateDate", _updateDate);
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("ouid", RLong.toString(_ouid));
      map.put("ovld", RBoolean.toString(_ovld));
      map.put("guid", _guid);
      map.put("recordYear", _recordYear.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordMonth", _recordMonth.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordWeek", _recordWeek.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordDay", _recordDay.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordHour", _recordHour.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordDate", _recordDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("resourceId", RLong.toString(_resourceId));
      map.put("viewTotal", RInteger.toString(_viewTotal));
      map.put("viewCount", RInteger.toString(_viewCount));
      map.put("playTotal", RInteger.toString(_playTotal));
      map.put("playCount", RInteger.toString(_playCount));
      map.put("pariseTotal", RInteger.toString(_pariseTotal));
      map.put("pariseCount", RInteger.toString(_pariseCount));
      map.put("downloadTotal", RInteger.toString(_downloadTotal));
      map.put("downloadCount", RInteger.toString(_downloadCount));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
