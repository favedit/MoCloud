package com.cyou.gccloud.data.cache;

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
// <T>系统会话表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FCacheSystemSessionUnit
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

   // 存储字段服务器代码的定义。
   private String __serverCode;

   // 字段服务器代码的定义。
   protected String _serverCode;

   // 存储字段逻辑代码的定义。
   private String __logicCode;

   // 字段逻辑代码的定义。
   protected String _logicCode;

   // 存储字段会话代码的定义。
   private String __sessionCode;

   // 字段会话代码的定义。
   protected String _sessionCode;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段项目编号的定义。
   private long __projectId;

   // 字段项目编号的定义。
   protected long _projectId;

   // 存储字段来源方式的定义。
   private int __fromCd;

   // 字段来源方式的定义。
   protected int _fromCd;

   // 存储字段来源代码的定义。
   private String __fromCode;

   // 字段来源代码的定义。
   protected String _fromCode;

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
   // <T>构造系统会话表逻辑单元。</T>
   //============================================================
   public FCacheSystemSessionUnit(){
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
   // <T>判断服务器代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isServerCodeChanged(){
      return !RString.equals(__serverCode, _serverCode);
   }

   //============================================================
   // <T>获得服务器代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String serverCode(){
      return _serverCode;
   }

   //============================================================
   // <T>设置服务器代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setServerCode(String value){
      _serverCode = value;
   }

   //============================================================
   // <T>判断逻辑代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLogicCodeChanged(){
      return !RString.equals(__logicCode, _logicCode);
   }

   //============================================================
   // <T>获得逻辑代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String logicCode(){
      return _logicCode;
   }

   //============================================================
   // <T>设置逻辑代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLogicCode(String value){
      _logicCode = value;
   }

   //============================================================
   // <T>判断会话代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSessionCodeChanged(){
      return !RString.equals(__sessionCode, _sessionCode);
   }

   //============================================================
   // <T>获得会话代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String sessionCode(){
      return _sessionCode;
   }

   //============================================================
   // <T>设置会话代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSessionCode(String value){
      _sessionCode = value;
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
   // <T>判断项目编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProjectIdChanged(){
      return __projectId != _projectId;
   }

   //============================================================
   // <T>获得项目编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long projectId(){
      return _projectId;
   }

   //============================================================
   // <T>设置项目编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProjectId(long value){
      _projectId = value;
   }

   //============================================================
   // <T>判断来源方式的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFromCdChanged(){
      return __fromCd != _fromCd;
   }

   //============================================================
   // <T>获得来源方式的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int fromCd(){
      return _fromCd;
   }

   //============================================================
   // <T>设置来源方式的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFromCd(int value){
      _fromCd = value;
   }

   //============================================================
   // <T>判断来源代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFromCodeChanged(){
      return !RString.equals(__fromCode, _fromCode);
   }

   //============================================================
   // <T>获得来源代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String fromCode(){
      return _fromCode;
   }

   //============================================================
   // <T>设置来源代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFromCode(String value){
      _fromCode = value;
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
         case "server_code":
            return _serverCode;
         case "logic_code":
            return _logicCode;
         case "session_code":
            return _sessionCode;
         case "user_id":
            return Long.toString(_userId);
         case "project_id":
            return Long.toString(_projectId);
         case "from_cd":
            return RInteger.toString(_fromCd);
         case "from_code":
            return _fromCode;
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
         case "server_code":
            _serverCode = value;
            break;
         case "logic_code":
            _logicCode = value;
            break;
         case "session_code":
            _sessionCode = value;
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "project_id":
            _projectId = RLong.parse(value);
            break;
         case "from_cd":
            _fromCd = RInteger.parse(value);
            break;
         case "from_code":
            _fromCode = value;
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
            case "server_code":
               __serverCode = value;
               _serverCode = __serverCode;
               break;
            case "logic_code":
               __logicCode = value;
               _logicCode = __logicCode;
               break;
            case "session_code":
               __sessionCode = value;
               _sessionCode = __sessionCode;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "project_id":
               __projectId = RLong.parse(value);
               _projectId = __projectId;
               break;
            case "from_cd":
               __fromCd = RInteger.parse(value);
               _fromCd = __fromCd;
               break;
            case "from_code":
               __fromCode = value;
               _fromCode = __fromCode;
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
      row.set("serverCode", _serverCode);
      row.set("logicCode", _logicCode);
      row.set("sessionCode", _sessionCode);
      row.set("userId", _userId);
      row.set("projectId", _projectId);
      row.set("fromCd", _fromCd);
      row.set("fromCode", _fromCode);
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
      map.put("serverCode", _serverCode);
      map.put("logicCode", _logicCode);
      map.put("sessionCode", _sessionCode);
      map.put("userId", RLong.toString(_userId));
      map.put("projectId", RLong.toString(_projectId));
      map.put("fromCd", RInteger.toString(_fromCd));
      map.put("fromCode", _fromCode);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
