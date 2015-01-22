package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>共通设备表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataCommonDeviceUnit
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

   // 存储字段制造商代码的定义。
   private String __manufacturerCode;

   // 字段制造商代码的定义。
   protected String _manufacturerCode;

   // 存储字段设备代码的定义。
   private String __deviceCode;

   // 字段设备代码的定义。
   protected String _deviceCode;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段屏幕DPI的定义。
   private float __screenDpi;

   // 字段屏幕DPI的定义。
   protected float _screenDpi;

   // 存储字段屏幕宽度的定义。
   private int __screenWidth;

   // 字段屏幕宽度的定义。
   protected int _screenWidth;

   // 存储字段屏幕高度的定义。
   private int __screenHeight;

   // 字段屏幕高度的定义。
   protected int _screenHeight;

   // 存储字段备注的定义。
   private String __note;

   // 字段备注的定义。
   protected String _note;

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
   // <T>构造共通设备表逻辑单元。</T>
   //============================================================
   public FDataCommonDeviceUnit(){
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
   // <T>判断制造商代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isManufacturerCodeChanged(){
      return !RString.equals(__manufacturerCode, _manufacturerCode);
   }

   //============================================================
   // <T>获得制造商代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String manufacturerCode(){
      return _manufacturerCode;
   }

   //============================================================
   // <T>设置制造商代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setManufacturerCode(String value){
      _manufacturerCode = value;
   }

   //============================================================
   // <T>判断设备代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeviceCodeChanged(){
      return !RString.equals(__deviceCode, _deviceCode);
   }

   //============================================================
   // <T>获得设备代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String deviceCode(){
      return _deviceCode;
   }

   //============================================================
   // <T>设置设备代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeviceCode(String value){
      _deviceCode = value;
   }

   //============================================================
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断屏幕DPI的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScreenDpiChanged(){
      return __screenDpi != _screenDpi;
   }

   //============================================================
   // <T>获得屏幕DPI的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float screenDpi(){
      return _screenDpi;
   }

   //============================================================
   // <T>设置屏幕DPI的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScreenDpi(float value){
      _screenDpi = value;
   }

   //============================================================
   // <T>判断屏幕宽度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScreenWidthChanged(){
      return __screenWidth != _screenWidth;
   }

   //============================================================
   // <T>获得屏幕宽度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int screenWidth(){
      return _screenWidth;
   }

   //============================================================
   // <T>设置屏幕宽度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScreenWidth(int value){
      _screenWidth = value;
   }

   //============================================================
   // <T>判断屏幕高度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScreenHeightChanged(){
      return __screenHeight != _screenHeight;
   }

   //============================================================
   // <T>获得屏幕高度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int screenHeight(){
      return _screenHeight;
   }

   //============================================================
   // <T>设置屏幕高度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScreenHeight(int value){
      _screenHeight = value;
   }

   //============================================================
   // <T>判断备注的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNote(String value){
      _note = value;
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
         case "manufacturer_code":
            return _manufacturerCode;
         case "device_code":
            return _deviceCode;
         case "label":
            return _label;
         case "screen_dpi":
            return RFloat.toString(_screenDpi);
         case "screen_width":
            return RInteger.toString(_screenWidth);
         case "screen_height":
            return RInteger.toString(_screenHeight);
         case "note":
            return _note;
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
         case "manufacturer_code":
            _manufacturerCode = value;
            break;
         case "device_code":
            _deviceCode = value;
            break;
         case "label":
            _label = value;
            break;
         case "screen_dpi":
            _screenDpi = RFloat.parse(value);
            break;
         case "screen_width":
            _screenWidth = RInteger.parse(value);
            break;
         case "screen_height":
            _screenHeight = RInteger.parse(value);
            break;
         case "note":
            _note = value;
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
            case "manufacturer_code":
               __manufacturerCode = value;
               _manufacturerCode = __manufacturerCode;
               break;
            case "device_code":
               __deviceCode = value;
               _deviceCode = __deviceCode;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "screen_dpi":
               __screenDpi = RFloat.parse(value);
               _screenDpi = __screenDpi;
               break;
            case "screen_width":
               __screenWidth = RInteger.parse(value);
               _screenWidth = __screenWidth;
               break;
            case "screen_height":
               __screenHeight = RInteger.parse(value);
               _screenHeight = __screenHeight;
               break;
            case "note":
               __note = value;
               _note = __note;
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
      row.set("manufacturerCode", _manufacturerCode);
      row.set("deviceCode", _deviceCode);
      row.set("label", _label);
      row.set("screenDpi", _screenDpi);
      row.set("screenWidth", _screenWidth);
      row.set("screenHeight", _screenHeight);
      row.set("note", _note);
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
      map.put("manufacturerCode", _manufacturerCode);
      map.put("deviceCode", _deviceCode);
      map.put("label", _label);
      map.put("screenDpi", RFloat.toString(_screenDpi));
      map.put("screenWidth", RInteger.toString(_screenWidth));
      map.put("screenHeight", RInteger.toString(_screenHeight));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
