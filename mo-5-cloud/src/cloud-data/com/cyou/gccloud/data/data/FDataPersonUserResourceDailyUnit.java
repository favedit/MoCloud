package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>用户资源日常表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserResourceDailyUnit
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

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段资源类型的定义。
   private int __resourceCd;

   // 字段资源类型的定义。
   protected int _resourceCd;

   // 存储字段资源编号的定义。
   private long __resourceId;

   // 字段资源编号的定义。
   protected long _resourceId;

   // 存储字段记录日期的定义。
   private TDateTime __recordDate = new TDateTime();

   // 字段记录日期的定义。
   protected TDateTime _recordDate = new TDateTime();

   // 存储字段是否点赞的定义。
   private int __pariseCd;

   // 字段是否点赞的定义。
   protected int _pariseCd;

   // 存储字段是否投票的定义。
   private int __voteCd;

   // 字段是否投票的定义。
   protected int _voteCd;

   // 存储字段点数(豆豆)的定义。
   private int __scoreBean;

   // 字段点数(豆豆)的定义。
   protected int _scoreBean;

   // 存储字段点数(豆币)的定义。
   private int __scorePoint;

   // 字段点数(豆币)的定义。
   protected int _scorePoint;

   // 存储字段点数(金币)的定义。
   private float __scoreGold;

   // 字段点数(金币)的定义。
   protected float _scoreGold;

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
   // <T>构造用户资源日常表逻辑单元。</T>
   //============================================================
   public FDataPersonUserResourceDailyUnit(){
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
   // <T>判断资源类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResourceCdChanged(){
      return __resourceCd != _resourceCd;
   }

   //============================================================
   // <T>获得资源类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int resourceCd(){
      return _resourceCd;
   }

   //============================================================
   // <T>设置资源类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResourceCd(int value){
      _resourceCd = value;
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
   // <T>判断记录日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordDateChanged(){
      return !__recordDate.equals(_recordDate);
   }

   //============================================================
   // <T>获得记录日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordDate(){
      return _recordDate;
   }

   //============================================================
   // <T>设置记录日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordDate(TDateTime value){
      _recordDate = value;
   }

   //============================================================
   // <T>判断是否点赞的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPariseCdChanged(){
      return __pariseCd != _pariseCd;
   }

   //============================================================
   // <T>获得是否点赞的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int pariseCd(){
      return _pariseCd;
   }

   //============================================================
   // <T>设置是否点赞的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPariseCd(int value){
      _pariseCd = value;
   }

   //============================================================
   // <T>判断是否投票的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isVoteCdChanged(){
      return __voteCd != _voteCd;
   }

   //============================================================
   // <T>获得是否投票的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int voteCd(){
      return _voteCd;
   }

   //============================================================
   // <T>设置是否投票的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setVoteCd(int value){
      _voteCd = value;
   }

   //============================================================
   // <T>判断点数(豆豆)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreBeanChanged(){
      return __scoreBean != _scoreBean;
   }

   //============================================================
   // <T>获得点数(豆豆)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreBean(){
      return _scoreBean;
   }

   //============================================================
   // <T>设置点数(豆豆)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreBean(int value){
      _scoreBean = value;
   }

   //============================================================
   // <T>判断点数(豆币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScorePointChanged(){
      return __scorePoint != _scorePoint;
   }

   //============================================================
   // <T>获得点数(豆币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scorePoint(){
      return _scorePoint;
   }

   //============================================================
   // <T>设置点数(豆币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScorePoint(int value){
      _scorePoint = value;
   }

   //============================================================
   // <T>判断点数(金币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreGoldChanged(){
      return __scoreGold != _scoreGold;
   }

   //============================================================
   // <T>获得点数(金币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float scoreGold(){
      return _scoreGold;
   }

   //============================================================
   // <T>设置点数(金币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreGold(float value){
      _scoreGold = value;
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
         case "resource_cd":
            return RInteger.toString(_resourceCd);
         case "resource_id":
            return Long.toString(_resourceId);
         case "record_date":
            return _recordDate.toString();
         case "parise_cd":
            return RInteger.toString(_pariseCd);
         case "vote_cd":
            return RInteger.toString(_voteCd);
         case "score_bean":
            return RInteger.toString(_scoreBean);
         case "score_point":
            return RInteger.toString(_scorePoint);
         case "score_gold":
            return RFloat.toString(_scoreGold);
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
         case "resource_cd":
            _resourceCd = RInteger.parse(value);
            break;
         case "resource_id":
            _resourceId = RLong.parse(value);
            break;
         case "record_date":
            _recordDate.parse(value);
            break;
         case "parise_cd":
            _pariseCd = RInteger.parse(value);
            break;
         case "vote_cd":
            _voteCd = RInteger.parse(value);
            break;
         case "score_bean":
            _scoreBean = RInteger.parse(value);
            break;
         case "score_point":
            _scorePoint = RInteger.parse(value);
            break;
         case "score_gold":
            _scoreGold = RFloat.parse(value);
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
            case "resource_cd":
               __resourceCd = RInteger.parse(value);
               _resourceCd = __resourceCd;
               break;
            case "resource_id":
               __resourceId = RLong.parse(value);
               _resourceId = __resourceId;
               break;
            case "record_date":
               __recordDate.parse(value);
               _recordDate.assign(__recordDate);
               break;
            case "parise_cd":
               __pariseCd = RInteger.parse(value);
               _pariseCd = __pariseCd;
               break;
            case "vote_cd":
               __voteCd = RInteger.parse(value);
               _voteCd = __voteCd;
               break;
            case "score_bean":
               __scoreBean = RInteger.parse(value);
               _scoreBean = __scoreBean;
               break;
            case "score_point":
               __scorePoint = RInteger.parse(value);
               _scorePoint = __scorePoint;
               break;
            case "score_gold":
               __scoreGold = RFloat.parse(value);
               _scoreGold = __scoreGold;
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
      row.set("resourceCd", _resourceCd);
      row.set("resourceId", _resourceId);
      row.set("recordDate", _recordDate);
      row.set("pariseCd", _pariseCd);
      row.set("voteCd", _voteCd);
      row.set("scoreBean", _scoreBean);
      row.set("scorePoint", _scorePoint);
      row.set("scoreGold", _scoreGold);
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
      map.put("resourceCd", RInteger.toString(_resourceCd));
      map.put("resourceId", RLong.toString(_resourceId));
      map.put("recordDate", _recordDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("pariseCd", RInteger.toString(_pariseCd));
      map.put("voteCd", RInteger.toString(_voteCd));
      map.put("scoreBean", RInteger.toString(_scoreBean));
      map.put("scorePoint", RInteger.toString(_scorePoint));
      map.put("scoreGold", RFloat.toString(_scoreGold));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
