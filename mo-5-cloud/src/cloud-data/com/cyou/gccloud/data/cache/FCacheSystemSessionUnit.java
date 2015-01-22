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

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段项目编号的定义。
   private long __proectId;

   // 字段项目编号的定义。
   protected long _proectId;

   // 存储字段来源类型的定义。
   private int __fromCd;

   // 字段来源类型的定义。
   protected int _fromCd;

   // 存储字段设备编号的定义。
   private long __deviceId;

   // 字段设备编号的定义。
   protected long _deviceId;

   // 存储字段设备品质的定义。
   private String __deviceQuality;

   // 字段设备品质的定义。
   protected String _deviceQuality;

   // 存储字段设备宽度的定义。
   private int __deviceWidth;

   // 字段设备宽度的定义。
   protected int _deviceWidth;

   // 存储字段设备高度的定义。
   private int __deviceHeight;

   // 字段设备高度的定义。
   protected int _deviceHeight;

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
   public boolean isProectIdChanged(){
      return __proectId != _proectId;
   }

   //============================================================
   // <T>获得项目编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long proectId(){
      return _proectId;
   }

   //============================================================
   // <T>设置项目编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProectId(long value){
      _proectId = value;
   }

   //============================================================
   // <T>判断来源类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFromCdChanged(){
      return __fromCd != _fromCd;
   }

   //============================================================
   // <T>获得来源类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int fromCd(){
      return _fromCd;
   }

   //============================================================
   // <T>设置来源类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFromCd(int value){
      _fromCd = value;
   }

   //============================================================
   // <T>判断设备编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeviceIdChanged(){
      return __deviceId != _deviceId;
   }

   //============================================================
   // <T>获得设备编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long deviceId(){
      return _deviceId;
   }

   //============================================================
   // <T>设置设备编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeviceId(long value){
      _deviceId = value;
   }

   //============================================================
   // <T>判断设备品质的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeviceQualityChanged(){
      return !RString.equals(__deviceQuality, _deviceQuality);
   }

   //============================================================
   // <T>获得设备品质的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String deviceQuality(){
      return _deviceQuality;
   }

   //============================================================
   // <T>设置设备品质的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeviceQuality(String value){
      _deviceQuality = value;
   }

   //============================================================
   // <T>判断设备宽度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeviceWidthChanged(){
      return __deviceWidth != _deviceWidth;
   }

   //============================================================
   // <T>获得设备宽度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int deviceWidth(){
      return _deviceWidth;
   }

   //============================================================
   // <T>设置设备宽度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeviceWidth(int value){
      _deviceWidth = value;
   }

   //============================================================
   // <T>判断设备高度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeviceHeightChanged(){
      return __deviceHeight != _deviceHeight;
   }

   //============================================================
   // <T>获得设备高度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int deviceHeight(){
      return _deviceHeight;
   }

   //============================================================
   // <T>设置设备高度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeviceHeight(int value){
      _deviceHeight = value;
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
         case "user_id":
            return Long.toString(_userId);
         case "proect_id":
            return Long.toString(_proectId);
         case "from_cd":
            return RInteger.toString(_fromCd);
         case "device_id":
            return Long.toString(_deviceId);
         case "device_quality":
            return _deviceQuality;
         case "device_width":
            return RInteger.toString(_deviceWidth);
         case "device_height":
            return RInteger.toString(_deviceHeight);
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
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "proect_id":
            _proectId = RLong.parse(value);
            break;
         case "from_cd":
            _fromCd = RInteger.parse(value);
            break;
         case "device_id":
            _deviceId = RLong.parse(value);
            break;
         case "device_quality":
            _deviceQuality = value;
            break;
         case "device_width":
            _deviceWidth = RInteger.parse(value);
            break;
         case "device_height":
            _deviceHeight = RInteger.parse(value);
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
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "proect_id":
               __proectId = RLong.parse(value);
               _proectId = __proectId;
               break;
            case "from_cd":
               __fromCd = RInteger.parse(value);
               _fromCd = __fromCd;
               break;
            case "device_id":
               __deviceId = RLong.parse(value);
               _deviceId = __deviceId;
               break;
            case "device_quality":
               __deviceQuality = value;
               _deviceQuality = __deviceQuality;
               break;
            case "device_width":
               __deviceWidth = RInteger.parse(value);
               _deviceWidth = __deviceWidth;
               break;
            case "device_height":
               __deviceHeight = RInteger.parse(value);
               _deviceHeight = __deviceHeight;
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
      row.set("userId", _userId);
      row.set("proectId", _proectId);
      row.set("fromCd", _fromCd);
      row.set("deviceId", _deviceId);
      row.set("deviceQuality", _deviceQuality);
      row.set("deviceWidth", _deviceWidth);
      row.set("deviceHeight", _deviceHeight);
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
      map.put("userId", RLong.toString(_userId));
      map.put("proectId", RLong.toString(_proectId));
      map.put("fromCd", RInteger.toString(_fromCd));
      map.put("deviceId", RLong.toString(_deviceId));
      map.put("deviceQuality", _deviceQuality);
      map.put("deviceWidth", RInteger.toString(_deviceWidth));
      map.put("deviceHeight", RInteger.toString(_deviceHeight));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
