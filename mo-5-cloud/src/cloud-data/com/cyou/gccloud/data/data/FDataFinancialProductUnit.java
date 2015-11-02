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
// <T>金融产品信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialProductUnit
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

   // 存储字段名称的定义。
   private String __code;

   // 字段名称的定义。
   protected String _code;

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段图标的定义。
   private String __iconUrl;

   // 字段图标的定义。
   protected String _iconUrl;

   // 存储字段收益率的定义。
   private double __rate;

   // 字段收益率的定义。
   protected double _rate;

   // 存储字段投资期限的定义。
   private int __horizonCount;

   // 字段投资期限的定义。
   protected int _horizonCount;

   // 存储字段投资期限类型的定义。
   private String __horizonUnit;

   // 字段投资期限类型的定义。
   protected String _horizonUnit;

   // 存储字段关闭期的定义。
   private int __horizonClosed;

   // 字段关闭期的定义。
   protected int _horizonClosed;

   // 存储字段等待期的定义。
   private int __horizonWait;

   // 字段等待期的定义。
   protected int _horizonWait;

   // 存储字段业绩计算的定义。
   private double __factor;

   // 字段业绩计算的定义。
   protected double _factor;

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
   // <T>构造金融产品信息逻辑单元。</T>
   //============================================================
   public FDataFinancialProductUnit(){
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
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCodeChanged(){
      return !RString.equals(__code, _code);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCode(String value){
      _code = value;
   }

   //============================================================
   // <T>判断标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断图标的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIconUrlChanged(){
      return !RString.equals(__iconUrl, _iconUrl);
   }

   //============================================================
   // <T>获得图标的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String iconUrl(){
      return _iconUrl;
   }

   //============================================================
   // <T>设置图标的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIconUrl(String value){
      _iconUrl = value;
   }

   //============================================================
   // <T>判断收益率的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRateChanged(){
      return __rate != _rate;
   }

   //============================================================
   // <T>获得收益率的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double rate(){
      return _rate;
   }

   //============================================================
   // <T>设置收益率的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRate(double value){
      _rate = value;
   }

   //============================================================
   // <T>判断投资期限的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHorizonCountChanged(){
      return __horizonCount != _horizonCount;
   }

   //============================================================
   // <T>获得投资期限的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int horizonCount(){
      return _horizonCount;
   }

   //============================================================
   // <T>设置投资期限的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHorizonCount(int value){
      _horizonCount = value;
   }

   //============================================================
   // <T>判断投资期限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHorizonUnitChanged(){
      return !RString.equals(__horizonUnit, _horizonUnit);
   }

   //============================================================
   // <T>获得投资期限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String horizonUnit(){
      return _horizonUnit;
   }

   //============================================================
   // <T>设置投资期限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHorizonUnit(String value){
      _horizonUnit = value;
   }

   //============================================================
   // <T>判断关闭期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHorizonClosedChanged(){
      return __horizonClosed != _horizonClosed;
   }

   //============================================================
   // <T>获得关闭期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int horizonClosed(){
      return _horizonClosed;
   }

   //============================================================
   // <T>设置关闭期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHorizonClosed(int value){
      _horizonClosed = value;
   }

   //============================================================
   // <T>判断等待期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHorizonWaitChanged(){
      return __horizonWait != _horizonWait;
   }

   //============================================================
   // <T>获得等待期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int horizonWait(){
      return _horizonWait;
   }

   //============================================================
   // <T>设置等待期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHorizonWait(int value){
      _horizonWait = value;
   }

   //============================================================
   // <T>判断业绩计算的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFactorChanged(){
      return __factor != _factor;
   }

   //============================================================
   // <T>获得业绩计算的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double factor(){
      return _factor;
   }

   //============================================================
   // <T>设置业绩计算的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFactor(double value){
      _factor = value;
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
         case "code":
            return _code;
         case "label":
            return _label;
         case "icon_url":
            return _iconUrl;
         case "rate":
            return RDouble.toString(_rate);
         case "horizon_count":
            return RInteger.toString(_horizonCount);
         case "horizon_unit":
            return _horizonUnit;
         case "horizon_closed":
            return RInteger.toString(_horizonClosed);
         case "horizon_wait":
            return RInteger.toString(_horizonWait);
         case "factor":
            return RDouble.toString(_factor);
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
         case "code":
            _code = value;
            break;
         case "label":
            _label = value;
            break;
         case "icon_url":
            _iconUrl = value;
            break;
         case "rate":
            _rate = RDouble.parse(value);
            break;
         case "horizon_count":
            _horizonCount = RInteger.parse(value);
            break;
         case "horizon_unit":
            _horizonUnit = value;
            break;
         case "horizon_closed":
            _horizonClosed = RInteger.parse(value);
            break;
         case "horizon_wait":
            _horizonWait = RInteger.parse(value);
            break;
         case "factor":
            _factor = RDouble.parse(value);
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
            case "code":
               __code = value;
               _code = __code;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "rate":
               __rate = RDouble.parse(value);
               _rate = __rate;
               break;
            case "horizon_count":
               __horizonCount = RInteger.parse(value);
               _horizonCount = __horizonCount;
               break;
            case "horizon_unit":
               __horizonUnit = value;
               _horizonUnit = __horizonUnit;
               break;
            case "horizon_closed":
               __horizonClosed = RInteger.parse(value);
               _horizonClosed = __horizonClosed;
               break;
            case "horizon_wait":
               __horizonWait = RInteger.parse(value);
               _horizonWait = __horizonWait;
               break;
            case "factor":
               __factor = RDouble.parse(value);
               _factor = __factor;
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
      row.set("code", _code);
      row.set("label", _label);
      row.set("iconUrl", _iconUrl);
      row.set("rate", _rate);
      row.set("horizonCount", _horizonCount);
      row.set("horizonUnit", _horizonUnit);
      row.set("horizonClosed", _horizonClosed);
      row.set("horizonWait", _horizonWait);
      row.set("factor", _factor);
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
      map.put("code", _code);
      map.put("label", _label);
      map.put("iconUrl", _iconUrl);
      map.put("rate", RDouble.toString(_rate));
      map.put("horizonCount", RInteger.toString(_horizonCount));
      map.put("horizonUnit", _horizonUnit);
      map.put("horizonClosed", RInteger.toString(_horizonClosed));
      map.put("horizonWait", RInteger.toString(_horizonWait));
      map.put("factor", RDouble.toString(_factor));
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
      _code = input.readString();
      _label = input.readString();
      _iconUrl = input.readString();
      _horizonCount = input.readInt32();
      _horizonUnit = input.readString();
      _horizonClosed = input.readInt32();
      _horizonWait = input.readInt32();
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
      output.writeString(_code);
      output.writeString(_label);
      output.writeString(_iconUrl);
      output.writeInt32(_horizonCount);
      output.writeString(_horizonUnit);
      output.writeInt32(_horizonClosed);
      output.writeInt32(_horizonWait);
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
      FDataFinancialProductUnit unit = (FDataFinancialProductUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setIconUrl(_iconUrl);
      unit.setRate(_rate);
      unit.setHorizonCount(_horizonCount);
      unit.setHorizonUnit(_horizonUnit);
      unit.setHorizonClosed(_horizonClosed);
      unit.setHorizonWait(_horizonWait);
      unit.setFactor(_factor);
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
   public FDataFinancialProductUnit clone(){
      FDataFinancialProductUnit unit = RClass.newInstance(FDataFinancialProductUnit.class);
      copy(unit);
      return unit;
   }
}
