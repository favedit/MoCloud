package com.cyou.gccloud.data.logger;

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
// <T>人员用户访问逻辑单元。</T>
//============================================================
@ASourceMachine
public class FLoggerPersonUserAccessUnit
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

   // 存储字段全局唯一标识的定义。
   private String __guid;

   // 字段全局唯一标识的定义。
   protected String _guid;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段逻辑代码的定义。
   private String __logicCode;

   // 字段逻辑代码的定义。
   protected String _logicCode;

   // 存储字段逻辑结果的定义。
   private String __logicResult;

   // 字段逻辑结果的定义。
   protected String _logicResult;

   // 存储字段逻辑消息的定义。
   private String __logicMessage;

   // 字段逻辑消息的定义。
   protected String _logicMessage;

   // 存储字段登录地址的定义。
   private String __hostAddress;

   // 字段登录地址的定义。
   protected String _hostAddress;

   // 存储字段登录端口的定义。
   private int __hostPort;

   // 字段登录端口的定义。
   protected int _hostPort;

   // 存储字段登录名称的定义。
   private String __passport;

   // 字段登录名称的定义。
   protected String _passport;

   // 存储字段登录密码的定义。
   private String __password;

   // 字段登录密码的定义。
   protected String _password;

   // 存储字段浏览地址的定义。
   private String __browserUri;

   // 字段浏览地址的定义。
   protected String _browserUri;

   // 存储字段页面信息的定义。
   private String __pageInfo;

   // 字段页面信息的定义。
   protected String _pageInfo;

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
   // <T>构造人员用户访问逻辑单元。</T>
   //============================================================
   public FLoggerPersonUserAccessUnit(){
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
   // <T>判断全局唯一标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGuidChanged(){
      return !RString.equals(__guid, _guid);
   }

   //============================================================
   // <T>获得全局唯一标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置全局唯一标识的数据内容。</T>
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
   // <T>判断逻辑结果的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLogicResultChanged(){
      return !RString.equals(__logicResult, _logicResult);
   }

   //============================================================
   // <T>获得逻辑结果的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String logicResult(){
      return _logicResult;
   }

   //============================================================
   // <T>设置逻辑结果的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLogicResult(String value){
      _logicResult = value;
   }

   //============================================================
   // <T>判断逻辑消息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLogicMessageChanged(){
      return !RString.equals(__logicMessage, _logicMessage);
   }

   //============================================================
   // <T>获得逻辑消息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String logicMessage(){
      return _logicMessage;
   }

   //============================================================
   // <T>设置逻辑消息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLogicMessage(String value){
      _logicMessage = value;
   }

   //============================================================
   // <T>判断登录地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHostAddressChanged(){
      return !RString.equals(__hostAddress, _hostAddress);
   }

   //============================================================
   // <T>获得登录地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String hostAddress(){
      return _hostAddress;
   }

   //============================================================
   // <T>设置登录地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHostAddress(String value){
      _hostAddress = value;
   }

   //============================================================
   // <T>判断登录端口的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHostPortChanged(){
      return __hostPort != _hostPort;
   }

   //============================================================
   // <T>获得登录端口的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int hostPort(){
      return _hostPort;
   }

   //============================================================
   // <T>设置登录端口的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHostPort(int value){
      _hostPort = value;
   }

   //============================================================
   // <T>判断登录名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得登录名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置登录名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
   }

   //============================================================
   // <T>判断登录密码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPasswordChanged(){
      return !RString.equals(__password, _password);
   }

   //============================================================
   // <T>获得登录密码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String password(){
      return _password;
   }

   //============================================================
   // <T>设置登录密码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassword(String value){
      _password = value;
   }

   //============================================================
   // <T>判断浏览地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBrowserUriChanged(){
      return !RString.equals(__browserUri, _browserUri);
   }

   //============================================================
   // <T>获得浏览地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String browserUri(){
      return _browserUri;
   }

   //============================================================
   // <T>设置浏览地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBrowserUri(String value){
      _browserUri = value;
   }

   //============================================================
   // <T>判断页面信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPageInfoChanged(){
      return !RString.equals(__pageInfo, _pageInfo);
   }

   //============================================================
   // <T>获得页面信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String pageInfo(){
      return _pageInfo;
   }

   //============================================================
   // <T>设置页面信息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPageInfo(String value){
      _pageInfo = value;
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
         case "logic_code":
            return _logicCode;
         case "logic_result":
            return _logicResult;
         case "logic_message":
            return _logicMessage;
         case "host_address":
            return _hostAddress;
         case "host_port":
            return RInteger.toString(_hostPort);
         case "passport":
            return _passport;
         case "password":
            return _password;
         case "browser_uri":
            return _browserUri;
         case "page_info":
            return _pageInfo;
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
         case "logic_code":
            _logicCode = value;
            break;
         case "logic_result":
            _logicResult = value;
            break;
         case "logic_message":
            _logicMessage = value;
            break;
         case "host_address":
            _hostAddress = value;
            break;
         case "host_port":
            _hostPort = RInteger.parse(value);
            break;
         case "passport":
            _passport = value;
            break;
         case "password":
            _password = value;
            break;
         case "browser_uri":
            _browserUri = value;
            break;
         case "page_info":
            _pageInfo = value;
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
            case "logic_code":
               __logicCode = value;
               _logicCode = __logicCode;
               break;
            case "logic_result":
               __logicResult = value;
               _logicResult = __logicResult;
               break;
            case "logic_message":
               __logicMessage = value;
               _logicMessage = __logicMessage;
               break;
            case "host_address":
               __hostAddress = value;
               _hostAddress = __hostAddress;
               break;
            case "host_port":
               __hostPort = RInteger.parse(value);
               _hostPort = __hostPort;
               break;
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "password":
               __password = value;
               _password = __password;
               break;
            case "browser_uri":
               __browserUri = value;
               _browserUri = __browserUri;
               break;
            case "page_info":
               __pageInfo = value;
               _pageInfo = __pageInfo;
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
      row.set("logicCode", _logicCode);
      row.set("logicResult", _logicResult);
      row.set("logicMessage", _logicMessage);
      row.set("hostAddress", _hostAddress);
      row.set("hostPort", _hostPort);
      row.set("passport", _passport);
      row.set("password", _password);
      row.set("browserUri", _browserUri);
      row.set("pageInfo", _pageInfo);
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
      map.put("logicCode", _logicCode);
      map.put("logicResult", _logicResult);
      map.put("logicMessage", _logicMessage);
      map.put("hostAddress", _hostAddress);
      map.put("hostPort", RInteger.toString(_hostPort));
      map.put("passport", _passport);
      map.put("password", _password);
      map.put("browserUri", _browserUri);
      map.put("pageInfo", _pageInfo);
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
      _userId = input.readInt64();
      _logicCode = input.readString();
      _logicResult = input.readString();
      _logicMessage = input.readString();
      _hostAddress = input.readString();
      _hostPort = input.readInt32();
      _passport = input.readString();
      _password = input.readString();
      _browserUri = input.readString();
      _pageInfo = input.readString();
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
      output.writeInt64(_userId);
      output.writeString(_logicCode);
      output.writeString(_logicResult);
      output.writeString(_logicMessage);
      output.writeString(_hostAddress);
      output.writeInt32(_hostPort);
      output.writeString(_passport);
      output.writeString(_password);
      output.writeString(_browserUri);
      output.writeString(_pageInfo);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
