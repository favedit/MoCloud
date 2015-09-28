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
// <T>方案项目信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataSystemVersionResourceUnit extends FLogicUnit
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

   // 存储字段应用编号的定义。
   private long __applicationId;

   // 字段应用编号的定义。
   protected long _applicationId;

   // 存储字段版本编号的定义。
   private long __versionId;

   // 字段版本编号的定义。
   protected long _versionId;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段存储文件的定义。
   private String __storageFile;

   // 字段存储文件的定义。
   protected String _storageFile;

   // 存储字段下载地址的定义。
   private String __downloadUrl;

   // 字段下载地址的定义。
   protected String _downloadUrl;

   // 存储字段下载大小的定义。
   private int __downloadSize;

   // 字段下载大小的定义。
   protected int _downloadSize;

   // 存储字段指定存储地址的定义。
   private String __customStorageFile;

   // 字段指定存储地址的定义。
   protected String _customStorageFile;

   // 存储字段指定下载地址的定义。
   private String __customDownloadUrl;

   // 字段指定下载地址的定义。
   protected String _customDownloadUrl;

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
   // <T>构造方案项目信息逻辑单元。</T>
   //============================================================
   public FDataSystemVersionResourceUnit(){
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
   // <T>判断应用编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isApplicationIdChanged(){
      return __applicationId != _applicationId;
   }

   //============================================================
   // <T>获得应用编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long applicationId(){
      return _applicationId;
   }

   //============================================================
   // <T>获得应用编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataSystemApplicationUnit application(){
      FDataSystemApplicationLogic logic = _logicContext.findLogic(FDataSystemApplicationLogic.class);
      FDataSystemApplicationUnit unit = logic.find(_applicationId);
      return unit;
   }

   //============================================================
   // <T>设置应用编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setApplicationId(long value){
      _applicationId = value;
   }

   //============================================================
   // <T>判断版本编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isVersionIdChanged(){
      return __versionId != _versionId;
   }

   //============================================================
   // <T>获得版本编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long versionId(){
      return _versionId;
   }

   //============================================================
   // <T>获得版本编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataSystemVersionUnit version(){
      FDataSystemVersionLogic logic = _logicContext.findLogic(FDataSystemVersionLogic.class);
      FDataSystemVersionUnit unit = logic.find(_versionId);
      return unit;
   }

   //============================================================
   // <T>设置版本编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setVersionId(long value){
      _versionId = value;
   }

   //============================================================
   // <T>判断代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCodeChanged(){
      return !RString.equals(__code, _code);
   }

   //============================================================
   // <T>获得代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCode(String value){
      _code = value;
   }

   //============================================================
   // <T>判断存储文件的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStorageFileChanged(){
      return !RString.equals(__storageFile, _storageFile);
   }

   //============================================================
   // <T>获得存储文件的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String storageFile(){
      return _storageFile;
   }

   //============================================================
   // <T>设置存储文件的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStorageFile(String value){
      _storageFile = value;
   }

   //============================================================
   // <T>判断下载地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDownloadUrlChanged(){
      return !RString.equals(__downloadUrl, _downloadUrl);
   }

   //============================================================
   // <T>获得下载地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String downloadUrl(){
      return _downloadUrl;
   }

   //============================================================
   // <T>设置下载地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDownloadUrl(String value){
      _downloadUrl = value;
   }

   //============================================================
   // <T>判断下载大小的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDownloadSizeChanged(){
      return __downloadSize != _downloadSize;
   }

   //============================================================
   // <T>获得下载大小的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int downloadSize(){
      return _downloadSize;
   }

   //============================================================
   // <T>设置下载大小的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDownloadSize(int value){
      _downloadSize = value;
   }

   //============================================================
   // <T>判断指定存储地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomStorageFileChanged(){
      return !RString.equals(__customStorageFile, _customStorageFile);
   }

   //============================================================
   // <T>获得指定存储地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customStorageFile(){
      return _customStorageFile;
   }

   //============================================================
   // <T>设置指定存储地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomStorageFile(String value){
      _customStorageFile = value;
   }

   //============================================================
   // <T>判断指定下载地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomDownloadUrlChanged(){
      return !RString.equals(__customDownloadUrl, _customDownloadUrl);
   }

   //============================================================
   // <T>获得指定下载地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customDownloadUrl(){
      return _customDownloadUrl;
   }

   //============================================================
   // <T>设置指定下载地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomDownloadUrl(String value){
      _customDownloadUrl = value;
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
         case "application_id":
            return Long.toString(_applicationId);
         case "version_id":
            return Long.toString(_versionId);
         case "code":
            return _code;
         case "storage_file":
            return _storageFile;
         case "download_url":
            return _downloadUrl;
         case "download_size":
            return RInteger.toString(_downloadSize);
         case "custom_storage_file":
            return _customStorageFile;
         case "custom_download_url":
            return _customDownloadUrl;
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
         case "application_id":
            _applicationId = RLong.parse(value);
            break;
         case "version_id":
            _versionId = RLong.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "storage_file":
            _storageFile = value;
            break;
         case "download_url":
            _downloadUrl = value;
            break;
         case "download_size":
            _downloadSize = RInteger.parse(value);
            break;
         case "custom_storage_file":
            _customStorageFile = value;
            break;
         case "custom_download_url":
            _customDownloadUrl = value;
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
            case "application_id":
               __applicationId = RLong.parse(value);
               _applicationId = __applicationId;
               break;
            case "version_id":
               __versionId = RLong.parse(value);
               _versionId = __versionId;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "storage_file":
               __storageFile = value;
               _storageFile = __storageFile;
               break;
            case "download_url":
               __downloadUrl = value;
               _downloadUrl = __downloadUrl;
               break;
            case "download_size":
               __downloadSize = RInteger.parse(value);
               _downloadSize = __downloadSize;
               break;
            case "custom_storage_file":
               __customStorageFile = value;
               _customStorageFile = __customStorageFile;
               break;
            case "custom_download_url":
               __customDownloadUrl = value;
               _customDownloadUrl = __customDownloadUrl;
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
      row.set("applicationId", _applicationId);
      row.set("versionId", _versionId);
      row.set("code", _code);
      row.set("storageFile", _storageFile);
      row.set("downloadUrl", _downloadUrl);
      row.set("downloadSize", _downloadSize);
      row.set("customStorageFile", _customStorageFile);
      row.set("customDownloadUrl", _customDownloadUrl);
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
      map.put("applicationId", RLong.toString(_applicationId));
      map.put("versionId", RLong.toString(_versionId));
      map.put("code", _code);
      map.put("storageFile", _storageFile);
      map.put("downloadUrl", _downloadUrl);
      map.put("downloadSize", RInteger.toString(_downloadSize));
      map.put("customStorageFile", _customStorageFile);
      map.put("customDownloadUrl", _customDownloadUrl);
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
      _applicationId = input.readInt64();
      _versionId = input.readInt64();
      _code = input.readString();
      _storageFile = input.readString();
      _downloadUrl = input.readString();
      _downloadSize = input.readInt32();
      _customStorageFile = input.readString();
      _customDownloadUrl = input.readString();
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
      output.writeInt64(_applicationId);
      output.writeInt64(_versionId);
      output.writeString(_code);
      output.writeString(_storageFile);
      output.writeString(_downloadUrl);
      output.writeInt32(_downloadSize);
      output.writeString(_customStorageFile);
      output.writeString(_customDownloadUrl);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
