package com.cyou.gccloud.data.cache;

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
// <T>系统短信效验表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FCacheSystemValidationUnit
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

   // 存储字段账户名的定义。
   private String __passport;

   // 字段账户名的定义。
   protected String _passport;

   // 存储字段手机号的定义。
   private String __mobileNumber;

   // 字段手机号的定义。
   protected String _mobileNumber;

   // 存储字段校验类型的定义。
   private int __validateCd;

   // 字段校验类型的定义。
   protected int _validateCd;

   // 存储字段检查代码的定义。
   private String __checkCode;

   // 字段检查代码的定义。
   protected String _checkCode;

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
   // <T>构造系统短信效验表逻辑单元。</T>
   //============================================================
   public FCacheSystemValidationUnit(){
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
   // <T>判断账户名的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得账户名的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置账户名的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
   }

   //============================================================
   // <T>判断手机号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMobileNumberChanged(){
      return !RString.equals(__mobileNumber, _mobileNumber);
   }

   //============================================================
   // <T>获得手机号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String mobileNumber(){
      return _mobileNumber;
   }

   //============================================================
   // <T>设置手机号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMobileNumber(String value){
      _mobileNumber = value;
   }

   //============================================================
   // <T>判断校验类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isValidateCdChanged(){
      return __validateCd != _validateCd;
   }

   //============================================================
   // <T>获得校验类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int validateCd(){
      return _validateCd;
   }

   //============================================================
   // <T>设置校验类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setValidateCd(int value){
      _validateCd = value;
   }

   //============================================================
   // <T>判断检查代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCheckCodeChanged(){
      return !RString.equals(__checkCode, _checkCode);
   }

   //============================================================
   // <T>获得检查代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String checkCode(){
      return _checkCode;
   }

   //============================================================
   // <T>设置检查代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCheckCode(String value){
      _checkCode = value;
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
         case "mobile_number":
            return _mobileNumber;
         case "validate_cd":
            return RInteger.toString(_validateCd);
         case "check_code":
            return _checkCode;
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
         case "mobile_number":
            _mobileNumber = value;
            break;
         case "validate_cd":
            _validateCd = RInteger.parse(value);
            break;
         case "check_code":
            _checkCode = value;
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
            case "mobile_number":
               __mobileNumber = value;
               _mobileNumber = __mobileNumber;
               break;
            case "validate_cd":
               __validateCd = RInteger.parse(value);
               _validateCd = __validateCd;
               break;
            case "check_code":
               __checkCode = value;
               _checkCode = __checkCode;
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
      row.set("mobileNumber", _mobileNumber);
      row.set("validateCd", _validateCd);
      row.set("checkCode", _checkCode);
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
      map.put("mobileNumber", _mobileNumber);
      map.put("validateCd", RInteger.toString(_validateCd));
      map.put("checkCode", _checkCode);
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
      _mobileNumber = input.readString();
      _validateCd = input.readInt32();
      _checkCode = input.readString();
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
      output.writeString(_mobileNumber);
      output.writeInt32(_validateCd);
      output.writeString(_checkCode);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
