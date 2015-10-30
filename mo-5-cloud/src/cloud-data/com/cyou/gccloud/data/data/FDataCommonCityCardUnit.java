package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>共通城市表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataCommonCityCardUnit
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

   // 存储字段国家编号的定义。
   private long __countryId;

   // 字段国家编号的定义。
   protected long _countryId;

   // 存储字段地区编号的定义。
   private long __areaId;

   // 字段地区编号的定义。
   protected long _areaId;

   // 存储字段省份编号的定义。
   private long __provinceId;

   // 字段省份编号的定义。
   protected long _provinceId;

   // 存储字段城市编号的定义。
   private long __cityId;

   // 字段城市编号的定义。
   protected long _cityId;

   // 存储字段身份证前4位的定义。
   private int __cardCode;

   // 字段身份证前4位的定义。
   protected int _cardCode;

   // 存储字段排序值的定义。
   private int __displayOrder;

   // 字段排序值的定义。
   protected int _displayOrder;

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
   // <T>构造共通城市表逻辑单元。</T>
   //============================================================
   public FDataCommonCityCardUnit(){
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
   // <T>判断国家编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCountryIdChanged(){
      return __countryId != _countryId;
   }

   //============================================================
   // <T>获得国家编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long countryId(){
      return _countryId;
   }

   //============================================================
   // <T>设置国家编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCountryId(long value){
      _countryId = value;
   }

   //============================================================
   // <T>判断地区编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAreaIdChanged(){
      return __areaId != _areaId;
   }

   //============================================================
   // <T>获得地区编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long areaId(){
      return _areaId;
   }

   //============================================================
   // <T>设置地区编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAreaId(long value){
      _areaId = value;
   }

   //============================================================
   // <T>判断省份编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceIdChanged(){
      return __provinceId != _provinceId;
   }

   //============================================================
   // <T>获得省份编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long provinceId(){
      return _provinceId;
   }

   //============================================================
   // <T>设置省份编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceId(long value){
      _provinceId = value;
   }

   //============================================================
   // <T>判断城市编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCityIdChanged(){
      return __cityId != _cityId;
   }

   //============================================================
   // <T>获得城市编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long cityId(){
      return _cityId;
   }

   //============================================================
   // <T>获得城市编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataCommonCityUnit city(){
      FDataCommonCityLogic logic = _logicContext.findLogic(FDataCommonCityLogic.class);
      FDataCommonCityUnit unit = logic.find(_cityId);
      return unit;
   }

   //============================================================
   // <T>设置城市编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityId(long value){
      _cityId = value;
   }

   //============================================================
   // <T>判断身份证前4位的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardCodeChanged(){
      return __cardCode != _cardCode;
   }

   //============================================================
   // <T>获得身份证前4位的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int cardCode(){
      return _cardCode;
   }

   //============================================================
   // <T>设置身份证前4位的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCardCode(int value){
      _cardCode = value;
   }

   //============================================================
   // <T>判断排序值的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDisplayOrderChanged(){
      return __displayOrder != _displayOrder;
   }

   //============================================================
   // <T>获得排序值的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int displayOrder(){
      return _displayOrder;
   }

   //============================================================
   // <T>设置排序值的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDisplayOrder(int value){
      _displayOrder = value;
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
         case "country_id":
            return Long.toString(_countryId);
         case "area_id":
            return Long.toString(_areaId);
         case "province_id":
            return Long.toString(_provinceId);
         case "city_id":
            return Long.toString(_cityId);
         case "card_code":
            return RInteger.toString(_cardCode);
         case "display_order":
            return RInteger.toString(_displayOrder);
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
         case "country_id":
            _countryId = RLong.parse(value);
            break;
         case "area_id":
            _areaId = RLong.parse(value);
            break;
         case "province_id":
            _provinceId = RLong.parse(value);
            break;
         case "city_id":
            _cityId = RLong.parse(value);
            break;
         case "card_code":
            _cardCode = RInteger.parse(value);
            break;
         case "display_order":
            _displayOrder = RInteger.parse(value);
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
            case "country_id":
               __countryId = RLong.parse(value);
               _countryId = __countryId;
               break;
            case "area_id":
               __areaId = RLong.parse(value);
               _areaId = __areaId;
               break;
            case "province_id":
               __provinceId = RLong.parse(value);
               _provinceId = __provinceId;
               break;
            case "city_id":
               __cityId = RLong.parse(value);
               _cityId = __cityId;
               break;
            case "card_code":
               __cardCode = RInteger.parse(value);
               _cardCode = __cardCode;
               break;
            case "display_order":
               __displayOrder = RInteger.parse(value);
               _displayOrder = __displayOrder;
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
      row.set("countryId", _countryId);
      row.set("areaId", _areaId);
      row.set("provinceId", _provinceId);
      row.set("cityId", _cityId);
      row.set("cardCode", _cardCode);
      row.set("displayOrder", _displayOrder);
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
      map.put("countryId", RLong.toString(_countryId));
      map.put("areaId", RLong.toString(_areaId));
      map.put("provinceId", RLong.toString(_provinceId));
      map.put("cityId", RLong.toString(_cityId));
      map.put("cardCode", RInteger.toString(_cardCode));
      map.put("displayOrder", RInteger.toString(_displayOrder));
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
      _countryId = input.readInt64();
      _areaId = input.readInt64();
      _provinceId = input.readInt64();
      _cityId = input.readInt64();
      _cardCode = input.readInt32();
      _displayOrder = input.readInt32();
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
      output.writeInt64(_countryId);
      output.writeInt64(_areaId);
      output.writeInt64(_provinceId);
      output.writeInt64(_cityId);
      output.writeInt32(_cardCode);
      output.writeInt32(_displayOrder);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }

   //============================================================
   // <T>复制当前对象。</T>
   //
   // @param unit 对象
   // @return 对象
   //============================================================
   @Override
   public void copy(FLogicUnit logicUnit){
      super.copy(logicUnit);
      FDataCommonCityCardUnit unit = (FDataCommonCityCardUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setCountryId(_countryId);
      unit.setAreaId(_areaId);
      unit.setProvinceId(_provinceId);
      unit.setCityId(_cityId);
      unit.setCardCode(_cardCode);
      unit.setDisplayOrder(_displayOrder);
      unit.setCreateUserId(_createUserId);
      unit.createDate().assign(_createDate);
      unit.setUpdateUserId(_updateUserId);
      unit.updateDate().assign(_updateDate);
   }

   //============================================================
   // <T>克隆当前对象。</T>
   //
   // @return 对象
   //============================================================
   @Override
   public FDataCommonCityCardUnit clone(){
      FDataCommonCityCardUnit unit = RClass.newInstance(FDataCommonCityCardUnit.class);
      copy(unit);
      return unit;
   }
}
