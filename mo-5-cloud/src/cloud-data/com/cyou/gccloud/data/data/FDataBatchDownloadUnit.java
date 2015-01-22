package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>后台下载表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataBatchDownloadUnit
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

   // 存储字段下载类型的定义。
   private int __typeCd;

   // 字段下载类型的定义。
   protected int _typeCd;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段状态类型的定义。
   private int __statusCd;

   // 字段状态类型的定义。
   protected int _statusCd;

   // 存储字段下载地址的定义。
   private String __downloadUrl;

   // 字段下载地址的定义。
   protected String _downloadUrl;

   // 存储字段下载大小的定义。
   private int __downloadSize;

   // 字段下载大小的定义。
   protected int _downloadSize;

   // 存储字段存储访问地址的定义。
   private String __storageUri;

   // 字段存储访问地址的定义。
   protected String _storageUri;

   // 存储字段存储文件的定义。
   private String __storageFile;

   // 字段存储文件的定义。
   protected String _storageFile;

   // 存储字段存储命令的定义。
   private int __storageActionCd;

   // 字段存储命令的定义。
   protected int _storageActionCd;

   // 存储字段存储状态的定义。
   private int __storageStatusCd;

   // 字段存储状态的定义。
   protected int _storageStatusCd;

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
   // <T>构造后台下载表逻辑单元。</T>
   //============================================================
   public FDataBatchDownloadUnit(){
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
   // <T>判断下载类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTypeCdChanged(){
      return __typeCd != _typeCd;
   }

   //============================================================
   // <T>获得下载类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置下载类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTypeCd(int value){
      _typeCd = value;
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
   // <T>获得用户编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataPersonUserUnit user(){
      FDataPersonUserLogic logic = _logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit unit = logic.find(_userId);
      return unit;
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
   // <T>判断状态类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatusCdChanged(){
      return __statusCd != _statusCd;
   }

   //============================================================
   // <T>获得状态类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int statusCd(){
      return _statusCd;
   }

   //============================================================
   // <T>设置状态类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatusCd(int value){
      _statusCd = value;
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
   // <T>判断存储访问地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStorageUriChanged(){
      return !RString.equals(__storageUri, _storageUri);
   }

   //============================================================
   // <T>获得存储访问地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String storageUri(){
      return _storageUri;
   }

   //============================================================
   // <T>设置存储访问地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStorageUri(String value){
      _storageUri = value;
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
   // <T>判断存储命令的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStorageActionCdChanged(){
      return __storageActionCd != _storageActionCd;
   }

   //============================================================
   // <T>获得存储命令的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int storageActionCd(){
      return _storageActionCd;
   }

   //============================================================
   // <T>设置存储命令的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStorageActionCd(int value){
      _storageActionCd = value;
   }

   //============================================================
   // <T>判断存储状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStorageStatusCdChanged(){
      return __storageStatusCd != _storageStatusCd;
   }

   //============================================================
   // <T>获得存储状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int storageStatusCd(){
      return _storageStatusCd;
   }

   //============================================================
   // <T>设置存储状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStorageStatusCd(int value){
      _storageStatusCd = value;
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
         case "type_cd":
            return RInteger.toString(_typeCd);
         case "user_id":
            return Long.toString(_userId);
         case "link_id":
            return Long.toString(_linkId);
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "download_url":
            return _downloadUrl;
         case "download_size":
            return RInteger.toString(_downloadSize);
         case "storage_uri":
            return _storageUri;
         case "storage_file":
            return _storageFile;
         case "storage_action_cd":
            return RInteger.toString(_storageActionCd);
         case "storage_status_cd":
            return RInteger.toString(_storageStatusCd);
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
         case "type_cd":
            _typeCd = RInteger.parse(value);
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "download_url":
            _downloadUrl = value;
            break;
         case "download_size":
            _downloadSize = RInteger.parse(value);
            break;
         case "storage_uri":
            _storageUri = value;
            break;
         case "storage_file":
            _storageFile = value;
            break;
         case "storage_action_cd":
            _storageActionCd = RInteger.parse(value);
            break;
         case "storage_status_cd":
            _storageStatusCd = RInteger.parse(value);
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
            case "type_cd":
               __typeCd = RInteger.parse(value);
               _typeCd = __typeCd;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "download_url":
               __downloadUrl = value;
               _downloadUrl = __downloadUrl;
               break;
            case "download_size":
               __downloadSize = RInteger.parse(value);
               _downloadSize = __downloadSize;
               break;
            case "storage_uri":
               __storageUri = value;
               _storageUri = __storageUri;
               break;
            case "storage_file":
               __storageFile = value;
               _storageFile = __storageFile;
               break;
            case "storage_action_cd":
               __storageActionCd = RInteger.parse(value);
               _storageActionCd = __storageActionCd;
               break;
            case "storage_status_cd":
               __storageStatusCd = RInteger.parse(value);
               _storageStatusCd = __storageStatusCd;
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
      row.set("typeCd", _typeCd);
      row.set("userId", _userId);
      row.set("linkId", _linkId);
      row.set("statusCd", _statusCd);
      row.set("downloadUrl", _downloadUrl);
      row.set("downloadSize", _downloadSize);
      row.set("storageUri", _storageUri);
      row.set("storageFile", _storageFile);
      row.set("storageActionCd", _storageActionCd);
      row.set("storageStatusCd", _storageStatusCd);
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
      map.put("typeCd", RInteger.toString(_typeCd));
      map.put("userId", RLong.toString(_userId));
      map.put("linkId", RLong.toString(_linkId));
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("downloadUrl", _downloadUrl);
      map.put("downloadSize", RInteger.toString(_downloadSize));
      map.put("storageUri", _storageUri);
      map.put("storageFile", _storageFile);
      map.put("storageActionCd", RInteger.toString(_storageActionCd));
      map.put("storageStatusCd", RInteger.toString(_storageStatusCd));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
