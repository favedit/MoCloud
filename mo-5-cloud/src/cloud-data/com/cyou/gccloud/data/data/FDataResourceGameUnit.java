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
// <T>资源游戏表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourceGameUnit
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

   // 存储字段资源编号的定义。
   private long __resourceId;

   // 字段资源编号的定义。
   protected long _resourceId;

   // 存储字段游戏截图1的定义。
   private String __snapshoot1Url;

   // 字段游戏截图1的定义。
   protected String _snapshoot1Url;

   // 存储字段游戏截图2的定义。
   private String __snapshoot2Url;

   // 字段游戏截图2的定义。
   protected String _snapshoot2Url;

   // 存储字段游戏截图3的定义。
   private String __snapshoot3Url;

   // 字段游戏截图3的定义。
   protected String _snapshoot3Url;

   // 存储字段游戏截图4的定义。
   private String __snapshoot4Url;

   // 字段游戏截图4的定义。
   protected String _snapshoot4Url;

   // 存储字段游戏截图5的定义。
   private String __snapshoot5Url;

   // 字段游戏截图5的定义。
   protected String _snapshoot5Url;

   // 存储字段适配机型的定义。
   private int __adapterCd;

   // 字段适配机型的定义。
   protected int _adapterCd;

   // 存储字段游戏方向的定义。
   private int __orientationCd;

   // 字段游戏方向的定义。
   protected int _orientationCd;

   // 存储字段下载大小的定义。
   private int __downloadSize;

   // 字段下载大小的定义。
   protected int _downloadSize;

   // 存储字段下载次数的定义。
   private int __downloadCount;

   // 字段下载次数的定义。
   protected int _downloadCount;

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
   // <T>构造资源游戏表逻辑单元。</T>
   //============================================================
   public FDataResourceGameUnit(){
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
   // <T>判断资源编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResourceIdChanged(){
      return __resourceId != _resourceId;
   }

   //============================================================
   // <T>获得资源编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long resourceId(){
      return _resourceId;
   }

   //============================================================
   // <T>获得资源编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceResourceUnit resource(){
      FDataResourceResourceLogic logic = _logicContext.findLogic(FDataResourceResourceLogic.class);
      FDataResourceResourceUnit unit = logic.find(_resourceId);
      return unit;
   }

   //============================================================
   // <T>设置资源编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResourceId(long value){
      _resourceId = value;
   }

   //============================================================
   // <T>判断游戏截图1的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSnapshoot1UrlChanged(){
      return !RString.equals(__snapshoot1Url, _snapshoot1Url);
   }

   //============================================================
   // <T>获得游戏截图1的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String snapshoot1Url(){
      return _snapshoot1Url;
   }

   //============================================================
   // <T>设置游戏截图1的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSnapshoot1Url(String value){
      _snapshoot1Url = value;
   }

   //============================================================
   // <T>判断游戏截图2的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSnapshoot2UrlChanged(){
      return !RString.equals(__snapshoot2Url, _snapshoot2Url);
   }

   //============================================================
   // <T>获得游戏截图2的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String snapshoot2Url(){
      return _snapshoot2Url;
   }

   //============================================================
   // <T>设置游戏截图2的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSnapshoot2Url(String value){
      _snapshoot2Url = value;
   }

   //============================================================
   // <T>判断游戏截图3的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSnapshoot3UrlChanged(){
      return !RString.equals(__snapshoot3Url, _snapshoot3Url);
   }

   //============================================================
   // <T>获得游戏截图3的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String snapshoot3Url(){
      return _snapshoot3Url;
   }

   //============================================================
   // <T>设置游戏截图3的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSnapshoot3Url(String value){
      _snapshoot3Url = value;
   }

   //============================================================
   // <T>判断游戏截图4的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSnapshoot4UrlChanged(){
      return !RString.equals(__snapshoot4Url, _snapshoot4Url);
   }

   //============================================================
   // <T>获得游戏截图4的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String snapshoot4Url(){
      return _snapshoot4Url;
   }

   //============================================================
   // <T>设置游戏截图4的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSnapshoot4Url(String value){
      _snapshoot4Url = value;
   }

   //============================================================
   // <T>判断游戏截图5的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSnapshoot5UrlChanged(){
      return !RString.equals(__snapshoot5Url, _snapshoot5Url);
   }

   //============================================================
   // <T>获得游戏截图5的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String snapshoot5Url(){
      return _snapshoot5Url;
   }

   //============================================================
   // <T>设置游戏截图5的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSnapshoot5Url(String value){
      _snapshoot5Url = value;
   }

   //============================================================
   // <T>判断适配机型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAdapterCdChanged(){
      return __adapterCd != _adapterCd;
   }

   //============================================================
   // <T>获得适配机型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int adapterCd(){
      return _adapterCd;
   }

   //============================================================
   // <T>设置适配机型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAdapterCd(int value){
      _adapterCd = value;
   }

   //============================================================
   // <T>判断游戏方向的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOrientationCdChanged(){
      return __orientationCd != _orientationCd;
   }

   //============================================================
   // <T>获得游戏方向的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int orientationCd(){
      return _orientationCd;
   }

   //============================================================
   // <T>设置游戏方向的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOrientationCd(int value){
      _orientationCd = value;
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
   // <T>判断下载次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDownloadCountChanged(){
      return __downloadCount != _downloadCount;
   }

   //============================================================
   // <T>获得下载次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int downloadCount(){
      return _downloadCount;
   }

   //============================================================
   // <T>设置下载次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDownloadCount(int value){
      _downloadCount = value;
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
         case "resource_id":
            return Long.toString(_resourceId);
         case "snapshoot1_url":
            return _snapshoot1Url;
         case "snapshoot2_url":
            return _snapshoot2Url;
         case "snapshoot3_url":
            return _snapshoot3Url;
         case "snapshoot4_url":
            return _snapshoot4Url;
         case "snapshoot5_url":
            return _snapshoot5Url;
         case "adapter_cd":
            return RInteger.toString(_adapterCd);
         case "orientation_cd":
            return RInteger.toString(_orientationCd);
         case "download_size":
            return RInteger.toString(_downloadSize);
         case "download_count":
            return RInteger.toString(_downloadCount);
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
         case "resource_id":
            _resourceId = RLong.parse(value);
            break;
         case "snapshoot1_url":
            _snapshoot1Url = value;
            break;
         case "snapshoot2_url":
            _snapshoot2Url = value;
            break;
         case "snapshoot3_url":
            _snapshoot3Url = value;
            break;
         case "snapshoot4_url":
            _snapshoot4Url = value;
            break;
         case "snapshoot5_url":
            _snapshoot5Url = value;
            break;
         case "adapter_cd":
            _adapterCd = RInteger.parse(value);
            break;
         case "orientation_cd":
            _orientationCd = RInteger.parse(value);
            break;
         case "download_size":
            _downloadSize = RInteger.parse(value);
            break;
         case "download_count":
            _downloadCount = RInteger.parse(value);
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
            case "resource_id":
               __resourceId = RLong.parse(value);
               _resourceId = __resourceId;
               break;
            case "snapshoot1_url":
               __snapshoot1Url = value;
               _snapshoot1Url = __snapshoot1Url;
               break;
            case "snapshoot2_url":
               __snapshoot2Url = value;
               _snapshoot2Url = __snapshoot2Url;
               break;
            case "snapshoot3_url":
               __snapshoot3Url = value;
               _snapshoot3Url = __snapshoot3Url;
               break;
            case "snapshoot4_url":
               __snapshoot4Url = value;
               _snapshoot4Url = __snapshoot4Url;
               break;
            case "snapshoot5_url":
               __snapshoot5Url = value;
               _snapshoot5Url = __snapshoot5Url;
               break;
            case "adapter_cd":
               __adapterCd = RInteger.parse(value);
               _adapterCd = __adapterCd;
               break;
            case "orientation_cd":
               __orientationCd = RInteger.parse(value);
               _orientationCd = __orientationCd;
               break;
            case "download_size":
               __downloadSize = RInteger.parse(value);
               _downloadSize = __downloadSize;
               break;
            case "download_count":
               __downloadCount = RInteger.parse(value);
               _downloadCount = __downloadCount;
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
      row.set("resourceId", _resourceId);
      row.set("snapshoot1Url", _snapshoot1Url);
      row.set("snapshoot2Url", _snapshoot2Url);
      row.set("snapshoot3Url", _snapshoot3Url);
      row.set("snapshoot4Url", _snapshoot4Url);
      row.set("snapshoot5Url", _snapshoot5Url);
      row.set("adapterCd", _adapterCd);
      row.set("orientationCd", _orientationCd);
      row.set("downloadSize", _downloadSize);
      row.set("downloadCount", _downloadCount);
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
      map.put("resourceId", RLong.toString(_resourceId));
      map.put("snapshoot1Url", _snapshoot1Url);
      map.put("snapshoot2Url", _snapshoot2Url);
      map.put("snapshoot3Url", _snapshoot3Url);
      map.put("snapshoot4Url", _snapshoot4Url);
      map.put("snapshoot5Url", _snapshoot5Url);
      map.put("adapterCd", RInteger.toString(_adapterCd));
      map.put("orientationCd", RInteger.toString(_orientationCd));
      map.put("downloadSize", RInteger.toString(_downloadSize));
      map.put("downloadCount", RInteger.toString(_downloadCount));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
