package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>动态投标表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialTenderUnit
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

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段记录时间的定义。
   private TDateTime __linkDate = new TDateTime();

   // 字段记录时间的定义。
   protected TDateTime _linkDate = new TDateTime();

   // 存储字段标题的定义。
   private String __label;

   // 字段标题的定义。
   protected String _label;

   // 存储字段借款类型的定义。
   private String __borrowModel;

   // 字段借款类型的定义。
   protected String _borrowModel;

   // 存储字段借款期限的定义。
   private int __borrowDuration;

   // 字段借款期限的定义。
   protected int _borrowDuration;

   // 存储字段借款金额的定义。
   private double __borrowMoney;

   // 字段借款金额的定义。
   protected double _borrowMoney;

   // 存储字段借款利率的定义。
   private double __borrowInerest;

   // 字段借款利率的定义。
   protected double _borrowInerest;

   // 存储字段借款利率的定义。
   private float __borrowInerestRate;

   // 字段借款利率的定义。
   protected float _borrowInerestRate;

   // 存储字段信息的定义。
   private String __info;

   // 字段信息的定义。
   protected String _info;

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
   // <T>构造动态投标表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialTenderUnit(){
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
   // <T>判断关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkIdChanged(){
      return __linkId != _linkId;
   }

   //============================================================
   // <T>获得关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkId(){
      return _linkId;
   }

   //============================================================
   // <T>设置关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkId(long value){
      _linkId = value;
   }

   //============================================================
   // <T>判断记录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkDateChanged(){
      return !__linkDate.equals(_linkDate);
   }

   //============================================================
   // <T>获得记录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime linkDate(){
      return _linkDate;
   }

   //============================================================
   // <T>设置记录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkDate(TDateTime value){
      _linkDate = value;
   }

   //============================================================
   // <T>判断标题的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得标题的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标题的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断借款类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowModelChanged(){
      return !RString.equals(__borrowModel, _borrowModel);
   }

   //============================================================
   // <T>获得借款类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String borrowModel(){
      return _borrowModel;
   }

   //============================================================
   // <T>设置借款类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowModel(String value){
      _borrowModel = value;
   }

   //============================================================
   // <T>判断借款期限的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowDurationChanged(){
      return __borrowDuration != _borrowDuration;
   }

   //============================================================
   // <T>获得借款期限的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int borrowDuration(){
      return _borrowDuration;
   }

   //============================================================
   // <T>设置借款期限的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowDuration(int value){
      _borrowDuration = value;
   }

   //============================================================
   // <T>判断借款金额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowMoneyChanged(){
      return __borrowMoney != _borrowMoney;
   }

   //============================================================
   // <T>获得借款金额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double borrowMoney(){
      return _borrowMoney;
   }

   //============================================================
   // <T>设置借款金额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowMoney(double value){
      _borrowMoney = value;
   }

   //============================================================
   // <T>判断借款利率的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowInerestChanged(){
      return __borrowInerest != _borrowInerest;
   }

   //============================================================
   // <T>获得借款利率的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double borrowInerest(){
      return _borrowInerest;
   }

   //============================================================
   // <T>设置借款利率的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowInerest(double value){
      _borrowInerest = value;
   }

   //============================================================
   // <T>判断借款利率的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowInerestRateChanged(){
      return __borrowInerestRate != _borrowInerestRate;
   }

   //============================================================
   // <T>获得借款利率的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float borrowInerestRate(){
      return _borrowInerestRate;
   }

   //============================================================
   // <T>设置借款利率的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowInerestRate(float value){
      _borrowInerestRate = value;
   }

   //============================================================
   // <T>判断信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInfoChanged(){
      return !RString.equals(__info, _info);
   }

   //============================================================
   // <T>获得信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String info(){
      return _info;
   }

   //============================================================
   // <T>设置信息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInfo(String value){
      _info = value;
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
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "label":
            return _label;
         case "borrow_model":
            return _borrowModel;
         case "borrow_duration":
            return RInteger.toString(_borrowDuration);
         case "borrow_money":
            return RDouble.toString(_borrowMoney);
         case "borrow_inerest":
            return RDouble.toString(_borrowInerest);
         case "borrow_inerest_rate":
            return RFloat.toString(_borrowInerestRate);
         case "info":
            return _info;
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
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "link_date":
            _linkDate.parse(value);
            break;
         case "label":
            _label = value;
            break;
         case "borrow_model":
            _borrowModel = value;
            break;
         case "borrow_duration":
            _borrowDuration = RInteger.parse(value);
            break;
         case "borrow_money":
            _borrowMoney = RDouble.parse(value);
            break;
         case "borrow_inerest":
            _borrowInerest = RDouble.parse(value);
            break;
         case "borrow_inerest_rate":
            _borrowInerestRate = RFloat.parse(value);
            break;
         case "info":
            _info = value;
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
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "link_date":
               __linkDate.parse(value);
               _linkDate.assign(__linkDate);
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "borrow_model":
               __borrowModel = value;
               _borrowModel = __borrowModel;
               break;
            case "borrow_duration":
               __borrowDuration = RInteger.parse(value);
               _borrowDuration = __borrowDuration;
               break;
            case "borrow_money":
               __borrowMoney = RDouble.parse(value);
               _borrowMoney = __borrowMoney;
               break;
            case "borrow_inerest":
               __borrowInerest = RDouble.parse(value);
               _borrowInerest = __borrowInerest;
               break;
            case "borrow_inerest_rate":
               __borrowInerestRate = RFloat.parse(value);
               _borrowInerestRate = __borrowInerestRate;
               break;
            case "info":
               __info = value;
               _info = __info;
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
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("label", _label);
      row.set("borrowModel", _borrowModel);
      row.set("borrowDuration", _borrowDuration);
      row.set("borrowMoney", _borrowMoney);
      row.set("borrowInerest", _borrowInerest);
      row.set("borrowInerestRate", _borrowInerestRate);
      row.set("info", _info);
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
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("label", _label);
      map.put("borrowModel", _borrowModel);
      map.put("borrowDuration", RInteger.toString(_borrowDuration));
      map.put("borrowMoney", RDouble.toString(_borrowMoney));
      map.put("borrowInerest", RDouble.toString(_borrowInerest));
      map.put("borrowInerestRate", RFloat.toString(_borrowInerestRate));
      map.put("info", _info);
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
      _linkId = input.readInt64();
      _linkDate.set(input.readInt64());
      _label = input.readString();
      _borrowModel = input.readString();
      _borrowDuration = input.readInt32();
      _info = input.readString();
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
      output.writeInt64(_linkId);
      output.writeInt64(_linkDate.get());
      output.writeString(_label);
      output.writeString(_borrowModel);
      output.writeInt32(_borrowDuration);
      output.writeString(_info);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
