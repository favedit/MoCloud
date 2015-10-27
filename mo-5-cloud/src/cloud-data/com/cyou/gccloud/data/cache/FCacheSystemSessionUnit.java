package com.cyou.gccloud.data.cache;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
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

   // 存储字段逻辑代码的定义。
   private String __logicCode;

   // 字段逻辑代码的定义。
   protected String _logicCode;

   // 存储字段来源方式的定义。
   private int __fromCd;

   // 字段来源方式的定义。
   protected int _fromCd;

   // 存储字段来源代码的定义。
   private String __fromCode;

   // 字段来源代码的定义。
   protected String _fromCode;

   // 存储字段会话代码的定义。
   private String __sessionCode;

   // 字段会话代码的定义。
   protected String _sessionCode;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段角色标签的定义。
   private String __userLabel;

   // 字段角色标签的定义。
   protected String _userLabel;

   // 存储字段角色编号的定义。
   private long __roleId;

   // 字段角色编号的定义。
   protected long _roleId;

   // 存储字段角色代码的定义。
   private String __roleCode;

   // 字段角色代码的定义。
   protected String _roleCode;

   // 存储字段角色模块集合的定义。
   private String __roleModules;

   // 字段角色模块集合的定义。
   protected String _roleModules;

   // 存储字段位置经度的定义。
   private double __locationLongitude;

   // 字段位置经度的定义。
   protected double _locationLongitude;

   // 存储字段位置纬度的定义。
   private double __locationLatitude;

   // 字段位置纬度的定义。
   protected double _locationLatitude;

   // 存储字段项目编号的定义。
   private long __projectId;

   // 字段项目编号的定义。
   protected long _projectId;

   // 存储字段应用编号的定义。
   private long __applicationId;

   // 字段应用编号的定义。
   protected long _applicationId;

   // 存储字段参数集合的定义。
   private String __parameters;

   // 字段参数集合的定义。
   protected String _parameters;

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
   // <T>判断角色标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserLabelChanged(){
      return !RString.equals(__userLabel, _userLabel);
   }

   //============================================================
   // <T>获得角色标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String userLabel(){
      return _userLabel;
   }

   //============================================================
   // <T>设置角色标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserLabel(String value){
      _userLabel = value;
   }

   //============================================================
   // <T>判断角色编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleIdChanged(){
      return __roleId != _roleId;
   }

   //============================================================
   // <T>获得角色编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long roleId(){
      return _roleId;
   }

   //============================================================
   // <T>设置角色编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleId(long value){
      _roleId = value;
   }

   //============================================================
   // <T>判断角色代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleCodeChanged(){
      return !RString.equals(__roleCode, _roleCode);
   }

   //============================================================
   // <T>获得角色代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String roleCode(){
      return _roleCode;
   }

   //============================================================
   // <T>设置角色代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleCode(String value){
      _roleCode = value;
   }

   //============================================================
   // <T>判断角色模块集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleModulesChanged(){
      return !RString.equals(__roleModules, _roleModules);
   }

   //============================================================
   // <T>获得角色模块集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String roleModules(){
      return _roleModules;
   }

   //============================================================
   // <T>设置角色模块集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleModules(String value){
      _roleModules = value;
   }

   //============================================================
   // <T>判断位置经度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLocationLongitudeChanged(){
      return __locationLongitude != _locationLongitude;
   }

   //============================================================
   // <T>获得位置经度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double locationLongitude(){
      return _locationLongitude;
   }

   //============================================================
   // <T>设置位置经度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLocationLongitude(double value){
      _locationLongitude = value;
   }

   //============================================================
   // <T>判断位置纬度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLocationLatitudeChanged(){
      return __locationLatitude != _locationLatitude;
   }

   //============================================================
   // <T>获得位置纬度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double locationLatitude(){
      return _locationLatitude;
   }

   //============================================================
   // <T>设置位置纬度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLocationLatitude(double value){
      _locationLatitude = value;
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
   // <T>判断应用编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isApplicationIdChanged(){
      return __applicationId != _applicationId;
   }

   //============================================================
   // <T>获得应用编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long applicationId(){
      return _applicationId;
   }

   //============================================================
   // <T>设置应用编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setApplicationId(long value){
      _applicationId = value;
   }

   //============================================================
   // <T>判断参数集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isParametersChanged(){
      return !RString.equals(__parameters, _parameters);
   }

   //============================================================
   // <T>获得参数集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String parameters(){
      return _parameters;
   }

   //============================================================
   // <T>设置参数集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setParameters(String value){
      _parameters = value;
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
         case "logic_code":
            return _logicCode;
         case "from_cd":
            return RInteger.toString(_fromCd);
         case "from_code":
            return _fromCode;
         case "session_code":
            return _sessionCode;
         case "user_id":
            return Long.toString(_userId);
         case "user_label":
            return _userLabel;
         case "role_id":
            return Long.toString(_roleId);
         case "role_code":
            return _roleCode;
         case "role_modules":
            return _roleModules;
         case "location_longitude":
            return RDouble.toString(_locationLongitude);
         case "location_latitude":
            return RDouble.toString(_locationLatitude);
         case "project_id":
            return Long.toString(_projectId);
         case "application_id":
            return Long.toString(_applicationId);
         case "parameters":
            return _parameters;
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
         case "logic_code":
            _logicCode = value;
            break;
         case "from_cd":
            _fromCd = RInteger.parse(value);
            break;
         case "from_code":
            _fromCode = value;
            break;
         case "session_code":
            _sessionCode = value;
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "user_label":
            _userLabel = value;
            break;
         case "role_id":
            _roleId = RLong.parse(value);
            break;
         case "role_code":
            _roleCode = value;
            break;
         case "role_modules":
            _roleModules = value;
            break;
         case "location_longitude":
            _locationLongitude = RDouble.parse(value);
            break;
         case "location_latitude":
            _locationLatitude = RDouble.parse(value);
            break;
         case "project_id":
            _projectId = RLong.parse(value);
            break;
         case "application_id":
            _applicationId = RLong.parse(value);
            break;
         case "parameters":
            _parameters = value;
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
            case "logic_code":
               __logicCode = value;
               _logicCode = __logicCode;
               break;
            case "from_cd":
               __fromCd = RInteger.parse(value);
               _fromCd = __fromCd;
               break;
            case "from_code":
               __fromCode = value;
               _fromCode = __fromCode;
               break;
            case "session_code":
               __sessionCode = value;
               _sessionCode = __sessionCode;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "user_label":
               __userLabel = value;
               _userLabel = __userLabel;
               break;
            case "role_id":
               __roleId = RLong.parse(value);
               _roleId = __roleId;
               break;
            case "role_code":
               __roleCode = value;
               _roleCode = __roleCode;
               break;
            case "role_modules":
               __roleModules = value;
               _roleModules = __roleModules;
               break;
            case "location_longitude":
               __locationLongitude = RDouble.parse(value);
               _locationLongitude = __locationLongitude;
               break;
            case "location_latitude":
               __locationLatitude = RDouble.parse(value);
               _locationLatitude = __locationLatitude;
               break;
            case "project_id":
               __projectId = RLong.parse(value);
               _projectId = __projectId;
               break;
            case "application_id":
               __applicationId = RLong.parse(value);
               _applicationId = __applicationId;
               break;
            case "parameters":
               __parameters = value;
               _parameters = __parameters;
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
      row.set("logicCode", _logicCode);
      row.set("fromCd", _fromCd);
      row.set("fromCode", _fromCode);
      row.set("sessionCode", _sessionCode);
      row.set("userId", _userId);
      row.set("userLabel", _userLabel);
      row.set("roleId", _roleId);
      row.set("roleCode", _roleCode);
      row.set("roleModules", _roleModules);
      row.set("locationLongitude", _locationLongitude);
      row.set("locationLatitude", _locationLatitude);
      row.set("projectId", _projectId);
      row.set("applicationId", _applicationId);
      row.set("parameters", _parameters);
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
      map.put("logicCode", _logicCode);
      map.put("fromCd", RInteger.toString(_fromCd));
      map.put("fromCode", _fromCode);
      map.put("sessionCode", _sessionCode);
      map.put("userId", RLong.toString(_userId));
      map.put("userLabel", _userLabel);
      map.put("roleId", RLong.toString(_roleId));
      map.put("roleCode", _roleCode);
      map.put("roleModules", _roleModules);
      map.put("locationLongitude", RDouble.toString(_locationLongitude));
      map.put("locationLatitude", RDouble.toString(_locationLatitude));
      map.put("projectId", RLong.toString(_projectId));
      map.put("applicationId", RLong.toString(_applicationId));
      map.put("parameters", _parameters);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }

   //============================================================
   // <T>反序列化数据到内容。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
      super.unserialize(input);
      _ouid = input.readInt64();
      _ovld = input.readBoolean();
      _guid = input.readString();
      _logicCode = input.readString();
      _fromCd = input.readInt32();
      _fromCode = input.readString();
      _sessionCode = input.readString();
      _userId = input.readInt64();
      _userLabel = input.readString();
      _roleId = input.readInt64();
      _roleCode = input.readString();
      _roleModules = input.readString();
      _projectId = input.readInt64();
      _applicationId = input.readInt64();
      _parameters = input.readString();
      _createUserId = input.readInt64();
      _createDate.set(input.readInt64());
      _updateUserId = input.readInt64();
      _updateDate.set(input.readInt64());
   }

   //============================================================
   // <T>序列化内容到数据。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeInt64(_ouid);
      output.writeBoolean(_ovld);
      output.writeString(_guid);
      output.writeString(_logicCode);
      output.writeInt32(_fromCd);
      output.writeString(_fromCode);
      output.writeString(_sessionCode);
      output.writeInt64(_userId);
      output.writeString(_userLabel);
      output.writeInt64(_roleId);
      output.writeString(_roleCode);
      output.writeString(_roleModules);
      output.writeInt64(_projectId);
      output.writeInt64(_applicationId);
      output.writeString(_parameters);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
