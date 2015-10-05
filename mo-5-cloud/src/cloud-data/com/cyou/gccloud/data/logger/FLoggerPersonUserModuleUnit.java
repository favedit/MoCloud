package com.cyou.gccloud.data.logger;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>人员模块访问逻辑单元。</T>
//============================================================
@ASourceMachine
public class FLoggerPersonUserModuleUnit
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

   // 存储字段登录名称的定义。
   private String __passport;

   // 字段登录名称的定义。
   protected String _passport;

   // 存储字段模块代码的定义。
   private String __moduleCode;

   // 字段模块代码的定义。
   protected String _moduleCode;

   // 存储字段模块命令的定义。
   private String __moduleAction;

   // 字段模块命令的定义。
   protected String _moduleAction;

   // 存储字段模块结果的定义。
   private String __moduleResult;

   // 字段模块结果的定义。
   protected String _moduleResult;

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
   // <T>构造人员模块访问逻辑单元。</T>
   //============================================================
   public FLoggerPersonUserModuleUnit(){
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
   // <T>判断模块代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModuleCodeChanged(){
      return !RString.equals(__moduleCode, _moduleCode);
   }

   //============================================================
   // <T>获得模块代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String moduleCode(){
      return _moduleCode;
   }

   //============================================================
   // <T>设置模块代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModuleCode(String value){
      _moduleCode = value;
   }

   //============================================================
   // <T>判断模块命令的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModuleActionChanged(){
      return !RString.equals(__moduleAction, _moduleAction);
   }

   //============================================================
   // <T>获得模块命令的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String moduleAction(){
      return _moduleAction;
   }

   //============================================================
   // <T>设置模块命令的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModuleAction(String value){
      _moduleAction = value;
   }

   //============================================================
   // <T>判断模块结果的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModuleResultChanged(){
      return !RString.equals(__moduleResult, _moduleResult);
   }

   //============================================================
   // <T>获得模块结果的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String moduleResult(){
      return _moduleResult;
   }

   //============================================================
   // <T>设置模块结果的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModuleResult(String value){
      _moduleResult = value;
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
         case "passport":
            return _passport;
         case "module_code":
            return _moduleCode;
         case "module_action":
            return _moduleAction;
         case "module_result":
            return _moduleResult;
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
         case "passport":
            _passport = value;
            break;
         case "module_code":
            _moduleCode = value;
            break;
         case "module_action":
            _moduleAction = value;
            break;
         case "module_result":
            _moduleResult = value;
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
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "module_code":
               __moduleCode = value;
               _moduleCode = __moduleCode;
               break;
            case "module_action":
               __moduleAction = value;
               _moduleAction = __moduleAction;
               break;
            case "module_result":
               __moduleResult = value;
               _moduleResult = __moduleResult;
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
      row.set("passport", _passport);
      row.set("moduleCode", _moduleCode);
      row.set("moduleAction", _moduleAction);
      row.set("moduleResult", _moduleResult);
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
      map.put("passport", _passport);
      map.put("moduleCode", _moduleCode);
      map.put("moduleAction", _moduleAction);
      map.put("moduleResult", _moduleResult);
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
      _passport = input.readString();
      _moduleCode = input.readString();
      _moduleAction = input.readString();
      _moduleResult = input.readString();
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
      output.writeString(_passport);
      output.writeString(_moduleCode);
      output.writeString(_moduleAction);
      output.writeString(_moduleResult);
      output.writeString(_browserUri);
      output.writeString(_pageInfo);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
