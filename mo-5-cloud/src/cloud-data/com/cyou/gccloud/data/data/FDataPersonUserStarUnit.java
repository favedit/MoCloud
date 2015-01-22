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
// <T>用户明星表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserStarUnit
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

   // 存储字段用户编码的定义。
   private long __userId;

   // 字段用户编码的定义。
   protected long _userId;

   // 存储字段明星头像地址的定义。
   private String __starImgUrl;

   // 字段明星头像地址的定义。
   protected String _starImgUrl;

   // 存储字段明星简介的定义。
   private String __starIntroduce;

   // 字段明星简介的定义。
   protected String _starIntroduce;

   // 存储字段职位描述的定义。
   private String __jobDesign;

   // 字段职位描述的定义。
   protected String _jobDesign;

   // 存储字段得分的定义。
   private int __score;

   // 字段得分的定义。
   protected int _score;

   // 存储字段角色的定义。
   private int __roleCd;

   // 字段角色的定义。
   protected int _roleCd;

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
   // <T>构造用户明星表逻辑单元。</T>
   //============================================================
   public FDataPersonUserStarUnit(){
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
   // <T>判断用户编码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserIdChanged(){
      return __userId != _userId;
   }

   //============================================================
   // <T>获得用户编码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>获得用户编码的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataPersonUserUnit user(){
      FDataPersonUserLogic logic = _logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit unit = logic.find(_userId);
      return unit;
   }

   //============================================================
   // <T>设置用户编码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserId(long value){
      _userId = value;
   }

   //============================================================
   // <T>判断明星头像地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStarImgUrlChanged(){
      return !RString.equals(__starImgUrl, _starImgUrl);
   }

   //============================================================
   // <T>获得明星头像地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String starImgUrl(){
      return _starImgUrl;
   }

   //============================================================
   // <T>设置明星头像地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStarImgUrl(String value){
      _starImgUrl = value;
   }

   //============================================================
   // <T>判断明星简介的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStarIntroduceChanged(){
      return !RString.equals(__starIntroduce, _starIntroduce);
   }

   //============================================================
   // <T>获得明星简介的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String starIntroduce(){
      return _starIntroduce;
   }

   //============================================================
   // <T>设置明星简介的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStarIntroduce(String value){
      _starIntroduce = value;
   }

   //============================================================
   // <T>判断职位描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isJobDesignChanged(){
      return !RString.equals(__jobDesign, _jobDesign);
   }

   //============================================================
   // <T>获得职位描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String jobDesign(){
      return _jobDesign;
   }

   //============================================================
   // <T>设置职位描述的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setJobDesign(String value){
      _jobDesign = value;
   }

   //============================================================
   // <T>判断得分的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreChanged(){
      return __score != _score;
   }

   //============================================================
   // <T>获得得分的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int score(){
      return _score;
   }

   //============================================================
   // <T>设置得分的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScore(int value){
      _score = value;
   }

   //============================================================
   // <T>判断角色的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleCdChanged(){
      return __roleCd != _roleCd;
   }

   //============================================================
   // <T>获得角色的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int roleCd(){
      return _roleCd;
   }

   //============================================================
   // <T>设置角色的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleCd(int value){
      _roleCd = value;
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
         case "star_img_url":
            return _starImgUrl;
         case "star_introduce":
            return _starIntroduce;
         case "job_design":
            return _jobDesign;
         case "score":
            return RInteger.toString(_score);
         case "role_cd":
            return RInteger.toString(_roleCd);
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
         case "star_img_url":
            _starImgUrl = value;
            break;
         case "star_introduce":
            _starIntroduce = value;
            break;
         case "job_design":
            _jobDesign = value;
            break;
         case "score":
            _score = RInteger.parse(value);
            break;
         case "role_cd":
            _roleCd = RInteger.parse(value);
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
            case "star_img_url":
               __starImgUrl = value;
               _starImgUrl = __starImgUrl;
               break;
            case "star_introduce":
               __starIntroduce = value;
               _starIntroduce = __starIntroduce;
               break;
            case "job_design":
               __jobDesign = value;
               _jobDesign = __jobDesign;
               break;
            case "score":
               __score = RInteger.parse(value);
               _score = __score;
               break;
            case "role_cd":
               __roleCd = RInteger.parse(value);
               _roleCd = __roleCd;
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
      row.set("starImgUrl", _starImgUrl);
      row.set("starIntroduce", _starIntroduce);
      row.set("jobDesign", _jobDesign);
      row.set("score", _score);
      row.set("roleCd", _roleCd);
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
      map.put("starImgUrl", _starImgUrl);
      map.put("starIntroduce", _starIntroduce);
      map.put("jobDesign", _jobDesign);
      map.put("score", RInteger.toString(_score));
      map.put("roleCd", RInteger.toString(_roleCd));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
