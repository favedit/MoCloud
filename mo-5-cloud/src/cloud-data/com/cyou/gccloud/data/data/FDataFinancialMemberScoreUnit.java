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
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>金融成员考评分逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialMemberScoreUnit
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

   // 存储字段账号的定义。
   private String __passport;

   // 字段账号的定义。
   protected String _passport;

   // 存储字段理财师编号的定义。
   private long __marketerId;

   // 字段理财师编号的定义。
   protected long _marketerId;

   // 存储字段城市编号的定义。
   private long __cityId;

   // 字段城市编号的定义。
   protected long _cityId;

   // 存储字段生日的定义。
   private TDateTime __birthday = new TDateTime();

   // 字段生日的定义。
   protected TDateTime _birthday = new TDateTime();

   // 存储字段注册时间的定义。
   private TDateTime __registerDate = new TDateTime();

   // 字段注册时间的定义。
   protected TDateTime _registerDate = new TDateTime();

   // 存储字段最后登录时间的定义。
   private TDateTime __lastLoginDate = new TDateTime();

   // 字段最后登录时间的定义。
   protected TDateTime _lastLoginDate = new TDateTime();

   // 存储字段推荐评分的定义。
   private int __recommendScore;

   // 字段推荐评分的定义。
   protected int _recommendScore;

   // 存储字段备注信息的定义。
   private String __note;

   // 字段备注信息的定义。
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
   // <T>构造金融成员考评分逻辑单元。</T>
   //============================================================
   public FDataFinancialMemberScoreUnit(){
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
   // <T>判断账号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得账号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置账号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
   }

   //============================================================
   // <T>判断理财师编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerIdChanged(){
      return __marketerId != _marketerId;
   }

   //============================================================
   // <T>获得理财师编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long marketerId(){
      return _marketerId;
   }

   //============================================================
   // <T>设置理财师编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerId(long value){
      _marketerId = value;
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
   // <T>设置城市编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityId(long value){
      _cityId = value;
   }

   //============================================================
   // <T>判断生日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBirthdayChanged(){
      return !__birthday.equals(_birthday);
   }

   //============================================================
   // <T>获得生日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime birthday(){
      return _birthday;
   }

   //============================================================
   // <T>设置生日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBirthday(TDateTime value){
      _birthday = value;
   }

   //============================================================
   // <T>判断注册时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegisterDateChanged(){
      return !__registerDate.equals(_registerDate);
   }

   //============================================================
   // <T>获得注册时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime registerDate(){
      return _registerDate;
   }

   //============================================================
   // <T>设置注册时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegisterDate(TDateTime value){
      _registerDate = value;
   }

   //============================================================
   // <T>判断最后登录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLastLoginDateChanged(){
      return !__lastLoginDate.equals(_lastLoginDate);
   }

   //============================================================
   // <T>获得最后登录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime lastLoginDate(){
      return _lastLoginDate;
   }

   //============================================================
   // <T>设置最后登录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLastLoginDate(TDateTime value){
      _lastLoginDate = value;
   }

   //============================================================
   // <T>判断推荐评分的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendScoreChanged(){
      return __recommendScore != _recommendScore;
   }

   //============================================================
   // <T>获得推荐评分的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int recommendScore(){
      return _recommendScore;
   }

   //============================================================
   // <T>设置推荐评分的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendScore(int value){
      _recommendScore = value;
   }

   //============================================================
   // <T>判断备注信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注信息的数据内容。</T>
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
         case "passport":
            return _passport;
         case "marketer_id":
            return Long.toString(_marketerId);
         case "city_id":
            return Long.toString(_cityId);
         case "birthday":
            return _birthday.toString();
         case "register_date":
            return _registerDate.toString();
         case "last_login_date":
            return _lastLoginDate.toString();
         case "recommend_score":
            return RInteger.toString(_recommendScore);
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
         case "passport":
            _passport = value;
            break;
         case "marketer_id":
            _marketerId = RLong.parse(value);
            break;
         case "city_id":
            _cityId = RLong.parse(value);
            break;
         case "birthday":
            _birthday.parse(value);
            break;
         case "register_date":
            _registerDate.parse(value);
            break;
         case "last_login_date":
            _lastLoginDate.parse(value);
            break;
         case "recommend_score":
            _recommendScore = RInteger.parse(value);
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
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "marketer_id":
               __marketerId = RLong.parse(value);
               _marketerId = __marketerId;
               break;
            case "city_id":
               __cityId = RLong.parse(value);
               _cityId = __cityId;
               break;
            case "birthday":
               __birthday.parse(value);
               _birthday.assign(__birthday);
               break;
            case "register_date":
               __registerDate.parse(value);
               _registerDate.assign(__registerDate);
               break;
            case "last_login_date":
               __lastLoginDate.parse(value);
               _lastLoginDate.assign(__lastLoginDate);
               break;
            case "recommend_score":
               __recommendScore = RInteger.parse(value);
               _recommendScore = __recommendScore;
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
      row.set("passport", _passport);
      row.set("marketerId", _marketerId);
      row.set("cityId", _cityId);
      row.set("birthday", _birthday);
      row.set("registerDate", _registerDate);
      row.set("lastLoginDate", _lastLoginDate);
      row.set("recommendScore", _recommendScore);
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
      map.put("passport", _passport);
      map.put("marketerId", RLong.toString(_marketerId));
      map.put("cityId", RLong.toString(_cityId));
      map.put("birthday", _birthday.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("registerDate", _registerDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("lastLoginDate", _lastLoginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recommendScore", RInteger.toString(_recommendScore));
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
      _passport = input.readString();
      _marketerId = input.readInt64();
      _cityId = input.readInt64();
      _birthday.set(input.readInt64());
      _registerDate.set(input.readInt64());
      _lastLoginDate.set(input.readInt64());
      _recommendScore = input.readInt32();
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
      output.writeString(_passport);
      output.writeInt64(_marketerId);
      output.writeInt64(_cityId);
      output.writeInt64(_birthday.get());
      output.writeInt64(_registerDate.get());
      output.writeInt64(_lastLoginDate.get());
      output.writeInt32(_recommendScore);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
