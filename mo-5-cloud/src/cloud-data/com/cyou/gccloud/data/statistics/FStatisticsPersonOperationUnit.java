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
// <T>用户操作统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsPersonOperationUnit
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

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段激活总数的定义。
   private int __activeCount;

   // 字段激活总数的定义。
   protected int _activeCount;

   // 存储字段注册总数的定义。
   private int __registerTotal;

   // 字段注册总数的定义。
   protected int _registerTotal;

   // 存储字段注册次数的定义。
   private int __registerCount;

   // 字段注册次数的定义。
   protected int _registerCount;

   // 存储字段登录总数的定义。
   private int __lognTotal;

   // 字段登录总数的定义。
   protected int _lognTotal;

   // 存储字段登录次数的定义。
   private int __loginCount;

   // 字段登录次数的定义。
   protected int _loginCount;

   // 存储字段登出总数的定义。
   private int __logoutTotal;

   // 字段登出总数的定义。
   protected int _logoutTotal;

   // 存储字段登出次数的定义。
   private int __logoutCount;

   // 字段登出次数的定义。
   protected int _logoutCount;

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
   // <T>构造用户操作统计表逻辑单元。</T>
   //============================================================
   public FStatisticsPersonOperationUnit(){
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
   // <T>判断用户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserIdChanged(){
      return __userId != _userId;
   }

   //============================================================
   // <T>获得用户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserId(long value){
      _userId = value;
   }

   //============================================================
   // <T>判断激活总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isActiveCountChanged(){
      return __activeCount != _activeCount;
   }

   //============================================================
   // <T>获得激活总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int activeCount(){
      return _activeCount;
   }

   //============================================================
   // <T>设置激活总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setActiveCount(int value){
      _activeCount = value;
   }

   //============================================================
   // <T>判断注册总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegisterTotalChanged(){
      return __registerTotal != _registerTotal;
   }

   //============================================================
   // <T>获得注册总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int registerTotal(){
      return _registerTotal;
   }

   //============================================================
   // <T>设置注册总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegisterTotal(int value){
      _registerTotal = value;
   }

   //============================================================
   // <T>判断注册次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegisterCountChanged(){
      return __registerCount != _registerCount;
   }

   //============================================================
   // <T>获得注册次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int registerCount(){
      return _registerCount;
   }

   //============================================================
   // <T>设置注册次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegisterCount(int value){
      _registerCount = value;
   }

   //============================================================
   // <T>判断登录总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLognTotalChanged(){
      return __lognTotal != _lognTotal;
   }

   //============================================================
   // <T>获得登录总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int lognTotal(){
      return _lognTotal;
   }

   //============================================================
   // <T>设置登录总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLognTotal(int value){
      _lognTotal = value;
   }

   //============================================================
   // <T>判断登录次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLoginCountChanged(){
      return __loginCount != _loginCount;
   }

   //============================================================
   // <T>获得登录次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int loginCount(){
      return _loginCount;
   }

   //============================================================
   // <T>设置登录次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLoginCount(int value){
      _loginCount = value;
   }

   //============================================================
   // <T>判断登出总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLogoutTotalChanged(){
      return __logoutTotal != _logoutTotal;
   }

   //============================================================
   // <T>获得登出总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int logoutTotal(){
      return _logoutTotal;
   }

   //============================================================
   // <T>设置登出总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLogoutTotal(int value){
      _logoutTotal = value;
   }

   //============================================================
   // <T>判断登出次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLogoutCountChanged(){
      return __logoutCount != _logoutCount;
   }

   //============================================================
   // <T>获得登出次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int logoutCount(){
      return _logoutCount;
   }

   //============================================================
   // <T>设置登出次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLogoutCount(int value){
      _logoutCount = value;
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
         case "user_id":
            return Long.toString(_userId);
         case "active_count":
            return RInteger.toString(_activeCount);
         case "register_total":
            return RInteger.toString(_registerTotal);
         case "register_count":
            return RInteger.toString(_registerCount);
         case "logn_total":
            return RInteger.toString(_lognTotal);
         case "login_count":
            return RInteger.toString(_loginCount);
         case "logout_total":
            return RInteger.toString(_logoutTotal);
         case "logout_count":
            return RInteger.toString(_logoutCount);
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
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "active_count":
            _activeCount = RInteger.parse(value);
            break;
         case "register_total":
            _registerTotal = RInteger.parse(value);
            break;
         case "register_count":
            _registerCount = RInteger.parse(value);
            break;
         case "logn_total":
            _lognTotal = RInteger.parse(value);
            break;
         case "login_count":
            _loginCount = RInteger.parse(value);
            break;
         case "logout_total":
            _logoutTotal = RInteger.parse(value);
            break;
         case "logout_count":
            _logoutCount = RInteger.parse(value);
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
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "active_count":
               __activeCount = RInteger.parse(value);
               _activeCount = __activeCount;
               break;
            case "register_total":
               __registerTotal = RInteger.parse(value);
               _registerTotal = __registerTotal;
               break;
            case "register_count":
               __registerCount = RInteger.parse(value);
               _registerCount = __registerCount;
               break;
            case "logn_total":
               __lognTotal = RInteger.parse(value);
               _lognTotal = __lognTotal;
               break;
            case "login_count":
               __loginCount = RInteger.parse(value);
               _loginCount = __loginCount;
               break;
            case "logout_total":
               __logoutTotal = RInteger.parse(value);
               _logoutTotal = __logoutTotal;
               break;
            case "logout_count":
               __logoutCount = RInteger.parse(value);
               _logoutCount = __logoutCount;
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
      row.set("userId", _userId);
      row.set("activeCount", _activeCount);
      row.set("registerTotal", _registerTotal);
      row.set("registerCount", _registerCount);
      row.set("lognTotal", _lognTotal);
      row.set("loginCount", _loginCount);
      row.set("logoutTotal", _logoutTotal);
      row.set("logoutCount", _logoutCount);
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
      map.put("userId", RLong.toString(_userId));
      map.put("activeCount", RInteger.toString(_activeCount));
      map.put("registerTotal", RInteger.toString(_registerTotal));
      map.put("registerCount", RInteger.toString(_registerCount));
      map.put("lognTotal", RInteger.toString(_lognTotal));
      map.put("loginCount", RInteger.toString(_loginCount));
      map.put("logoutTotal", RInteger.toString(_logoutTotal));
      map.put("logoutCount", RInteger.toString(_logoutCount));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
