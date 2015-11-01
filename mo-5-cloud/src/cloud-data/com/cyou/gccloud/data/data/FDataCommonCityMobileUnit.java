package com.cyou.gccloud.data.data;

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
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>共通城市手机关联表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataCommonCityMobileUnit
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

   // 存储字段手机号码的定义。
   private String __phone;

   // 字段手机号码的定义。
   protected String _phone;

   // 存储字段省份的定义。
   private String __province;

   // 字段省份的定义。
   protected String _province;

   // 存储字段城市的定义。
   private String __city;

   // 字段城市的定义。
   protected String _city;

   // 存储字段运营商的定义。
   private String __operators;

   // 字段运营商的定义。
   protected String _operators;

   // 存储字段是否下架的定义。
   private int __stock;

   // 字段是否下架的定义。
   protected int _stock;

   // 存储字段数量的定义。
   private int __amount;

   // 字段数量的定义。
   protected int _amount;

   // 存储字段最大价格的定义。
   private double __maxPrice;

   // 字段最大价格的定义。
   protected double _maxPrice;

   // 存储字段最小价格的定义。
   private double __minPrice;

   // 字段最小价格的定义。
   protected double _minPrice;

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
   // <T>构造共通城市手机关联表逻辑单元。</T>
   //============================================================
   public FDataCommonCityMobileUnit(){
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
   // <T>判断手机号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPhoneChanged(){
      return !RString.equals(__phone, _phone);
   }

   //============================================================
   // <T>获得手机号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String phone(){
      return _phone;
   }

   //============================================================
   // <T>设置手机号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPhone(String value){
      _phone = value;
   }

   //============================================================
   // <T>判断省份的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceChanged(){
      return !RString.equals(__province, _province);
   }

   //============================================================
   // <T>获得省份的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String province(){
      return _province;
   }

   //============================================================
   // <T>设置省份的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvince(String value){
      _province = value;
   }

   //============================================================
   // <T>判断城市的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCityChanged(){
      return !RString.equals(__city, _city);
   }

   //============================================================
   // <T>获得城市的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String city(){
      return _city;
   }

   //============================================================
   // <T>设置城市的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCity(String value){
      _city = value;
   }

   //============================================================
   // <T>判断运营商的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOperatorsChanged(){
      return !RString.equals(__operators, _operators);
   }

   //============================================================
   // <T>获得运营商的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String operators(){
      return _operators;
   }

   //============================================================
   // <T>设置运营商的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOperators(String value){
      _operators = value;
   }

   //============================================================
   // <T>判断是否下架的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStockChanged(){
      return __stock != _stock;
   }

   //============================================================
   // <T>获得是否下架的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int stock(){
      return _stock;
   }

   //============================================================
   // <T>设置是否下架的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStock(int value){
      _stock = value;
   }

   //============================================================
   // <T>判断数量的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAmountChanged(){
      return __amount != _amount;
   }

   //============================================================
   // <T>获得数量的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int amount(){
      return _amount;
   }

   //============================================================
   // <T>设置数量的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAmount(int value){
      _amount = value;
   }

   //============================================================
   // <T>判断最大价格的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMaxPriceChanged(){
      return __maxPrice != _maxPrice;
   }

   //============================================================
   // <T>获得最大价格的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double maxPrice(){
      return _maxPrice;
   }

   //============================================================
   // <T>设置最大价格的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMaxPrice(double value){
      _maxPrice = value;
   }

   //============================================================
   // <T>判断最小价格的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMinPriceChanged(){
      return __minPrice != _minPrice;
   }

   //============================================================
   // <T>获得最小价格的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double minPrice(){
      return _minPrice;
   }

   //============================================================
   // <T>设置最小价格的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMinPrice(double value){
      _minPrice = value;
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
         case "phone":
            return _phone;
         case "province":
            return _province;
         case "city":
            return _city;
         case "operators":
            return _operators;
         case "stock":
            return RInteger.toString(_stock);
         case "amount":
            return RInteger.toString(_amount);
         case "max_price":
            return RDouble.toString(_maxPrice);
         case "min_price":
            return RDouble.toString(_minPrice);
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
         case "phone":
            _phone = value;
            break;
         case "province":
            _province = value;
            break;
         case "city":
            _city = value;
            break;
         case "operators":
            _operators = value;
            break;
         case "stock":
            _stock = RInteger.parse(value);
            break;
         case "amount":
            _amount = RInteger.parse(value);
            break;
         case "max_price":
            _maxPrice = RDouble.parse(value);
            break;
         case "min_price":
            _minPrice = RDouble.parse(value);
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
            case "phone":
               __phone = value;
               _phone = __phone;
               break;
            case "province":
               __province = value;
               _province = __province;
               break;
            case "city":
               __city = value;
               _city = __city;
               break;
            case "operators":
               __operators = value;
               _operators = __operators;
               break;
            case "stock":
               __stock = RInteger.parse(value);
               _stock = __stock;
               break;
            case "amount":
               __amount = RInteger.parse(value);
               _amount = __amount;
               break;
            case "max_price":
               __maxPrice = RDouble.parse(value);
               _maxPrice = __maxPrice;
               break;
            case "min_price":
               __minPrice = RDouble.parse(value);
               _minPrice = __minPrice;
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
      row.set("phone", _phone);
      row.set("province", _province);
      row.set("city", _city);
      row.set("operators", _operators);
      row.set("stock", _stock);
      row.set("amount", _amount);
      row.set("maxPrice", _maxPrice);
      row.set("minPrice", _minPrice);
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
      map.put("phone", _phone);
      map.put("province", _province);
      map.put("city", _city);
      map.put("operators", _operators);
      map.put("stock", RInteger.toString(_stock));
      map.put("amount", RInteger.toString(_amount));
      map.put("maxPrice", RDouble.toString(_maxPrice));
      map.put("minPrice", RDouble.toString(_minPrice));
      map.put("note", _note);
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
      _phone = input.readString();
      _province = input.readString();
      _city = input.readString();
      _operators = input.readString();
      _stock = input.readInt32();
      _amount = input.readInt32();
      _note = input.readString();
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
      output.writeString(_phone);
      output.writeString(_province);
      output.writeString(_city);
      output.writeString(_operators);
      output.writeInt32(_stock);
      output.writeInt32(_amount);
      output.writeString(_note);
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
      FDataCommonCityMobileUnit unit = (FDataCommonCityMobileUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setPhone(_phone);
      unit.setProvince(_province);
      unit.setCity(_city);
      unit.setOperators(_operators);
      unit.setStock(_stock);
      unit.setAmount(_amount);
      unit.setMaxPrice(_maxPrice);
      unit.setMinPrice(_minPrice);
      unit.setNote(_note);
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
   public FDataCommonCityMobileUnit clone(){
      FDataCommonCityMobileUnit unit = RClass.newInstance(FDataCommonCityMobileUnit.class);
      copy(unit);
      return unit;
   }
}
