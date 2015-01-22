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
// <T>资源信息表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourceResourceUnit
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

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __name;

   // 字段名称的定义。
   protected String _name;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段模块编号的定义。
   private long __moduleId;

   // 字段模块编号的定义。
   protected long _moduleId;

   // 存储字段频道编号的定义。
   private long __channelId;

   // 字段频道编号的定义。
   protected long _channelId;

   // 存储字段类型编号的定义。
   private long __typeId;

   // 字段类型编号的定义。
   protected long _typeId;

   // 存储字段学校编号的定义。
   private long __schoolId;

   // 字段学校编号的定义。
   protected long _schoolId;

   // 存储字段提供商编号的定义。
   private long __vendorId;

   // 字段提供商编号的定义。
   protected long _vendorId;

   // 存储字段老师编号的定义。
   private long __teacherId;

   // 字段老师编号的定义。
   protected long _teacherId;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段活动编号的定义。
   private long __activityId;

   // 字段活动编号的定义。
   protected long _activityId;

   // 存储字段状态类型的定义。
   private int __statusCd;

   // 字段状态类型的定义。
   protected int _statusCd;

   // 存储字段资源类型的定义。
   private int __resourceCd;

   // 字段资源类型的定义。
   protected int _resourceCd;

   // 存储字段资源部署状态的定义。
   private int __resourceDeployCd;

   // 字段资源部署状态的定义。
   protected int _resourceDeployCd;

   // 存储字段显示类型的定义。
   private int __displayCd;

   // 字段显示类型的定义。
   protected int _displayCd;

   // 存储字段排序值的定义。
   private int __displayOrder;

   // 字段排序值的定义。
   protected int _displayOrder;

   // 存储字段审核日期的定义。
   private TDateTime __examineDate = new TDateTime();

   // 字段审核日期的定义。
   protected TDateTime _examineDate = new TDateTime();

   // 存储字段审核结果类型的定义。
   private int __examineResultCd;

   // 字段审核结果类型的定义。
   protected int _examineResultCd;

   // 存储字段推荐类型的定义。
   private int __recommendCd;

   // 字段推荐类型的定义。
   protected int _recommendCd;

   // 存储字段图标地址的定义。
   private String __iconUrl;

   // 字段图标地址的定义。
   protected String _iconUrl;

   // 存储字段外链地址的定义。
   private String __linkUrl;

   // 字段外链地址的定义。
   protected String _linkUrl;

   // 存储字段版本编号的定义。
   private int __versionNumber;

   // 字段版本编号的定义。
   protected int _versionNumber;

   // 存储字段版本代码的定义。
   private String __versionCode;

   // 字段版本代码的定义。
   protected String _versionCode;

   // 存储字段关键字的定义。
   private String __keywords;

   // 字段关键字的定义。
   protected String _keywords;

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

   // 存储字段播放次数的定义。
   private int __playCount;

   // 字段播放次数的定义。
   protected int _playCount;

   // 存储字段点攒次数的定义。
   private int __praiseCount;

   // 字段点攒次数的定义。
   protected int _praiseCount;

   // 存储字段关注(收藏)次数的定义。
   private int __attentionCount;

   // 字段关注(收藏)次数的定义。
   protected int _attentionCount;

   // 存储字段分享次数的定义。
   private int __shareCount;

   // 字段分享次数的定义。
   protected int _shareCount;

   // 存储字段浏览次数的定义。
   private int __viewCount;

   // 字段浏览次数的定义。
   protected int _viewCount;

   // 存储字段详细描述的定义。
   private String __description;

   // 字段详细描述的定义。
   protected String _description;

   // 存储字段内容的定义。
   private String __content;

   // 字段内容的定义。
   protected String _content;

   // 存储字段注释内容的定义。
   private String __note;

   // 字段注释内容的定义。
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
   // <T>构造资源信息表逻辑单元。</T>
   //============================================================
   public FDataResourceResourceUnit(){
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
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNameChanged(){
      return !RString.equals(__name, _name);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setName(String value){
      _name = value;
   }

   //============================================================
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断模块编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModuleIdChanged(){
      return __moduleId != _moduleId;
   }

   //============================================================
   // <T>获得模块编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long moduleId(){
      return _moduleId;
   }

   //============================================================
   // <T>获得模块编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModuleUnit module(){
      FDataResourceModuleLogic logic = _logicContext.findLogic(FDataResourceModuleLogic.class);
      FDataResourceModuleUnit unit = logic.find(_moduleId);
      return unit;
   }

   //============================================================
   // <T>设置模块编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModuleId(long value){
      _moduleId = value;
   }

   //============================================================
   // <T>判断频道编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isChannelIdChanged(){
      return __channelId != _channelId;
   }

   //============================================================
   // <T>获得频道编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long channelId(){
      return _channelId;
   }

   //============================================================
   // <T>获得频道编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceChannelUnit channel(){
      FDataResourceChannelLogic logic = _logicContext.findLogic(FDataResourceChannelLogic.class);
      FDataResourceChannelUnit unit = logic.find(_channelId);
      return unit;
   }

   //============================================================
   // <T>设置频道编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setChannelId(long value){
      _channelId = value;
   }

   //============================================================
   // <T>判断类型编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTypeIdChanged(){
      return __typeId != _typeId;
   }

   //============================================================
   // <T>获得类型编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long typeId(){
      return _typeId;
   }

   //============================================================
   // <T>获得类型编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceTypeUnit type(){
      FDataResourceTypeLogic logic = _logicContext.findLogic(FDataResourceTypeLogic.class);
      FDataResourceTypeUnit unit = logic.find(_typeId);
      return unit;
   }

   //============================================================
   // <T>设置类型编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTypeId(long value){
      _typeId = value;
   }

   //============================================================
   // <T>判断学校编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolIdChanged(){
      return __schoolId != _schoolId;
   }

   //============================================================
   // <T>获得学校编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long schoolId(){
      return _schoolId;
   }

   //============================================================
   // <T>获得学校编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataCommonSchoolUnit school(){
      FDataCommonSchoolLogic logic = _logicContext.findLogic(FDataCommonSchoolLogic.class);
      FDataCommonSchoolUnit unit = logic.find(_schoolId);
      return unit;
   }

   //============================================================
   // <T>设置学校编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolId(long value){
      _schoolId = value;
   }

   //============================================================
   // <T>判断提供商编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isVendorIdChanged(){
      return __vendorId != _vendorId;
   }

   //============================================================
   // <T>获得提供商编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long vendorId(){
      return _vendorId;
   }

   //============================================================
   // <T>获得提供商编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataLogicVendorUnit vendor(){
      FDataLogicVendorLogic logic = _logicContext.findLogic(FDataLogicVendorLogic.class);
      FDataLogicVendorUnit unit = logic.find(_vendorId);
      return unit;
   }

   //============================================================
   // <T>设置提供商编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setVendorId(long value){
      _vendorId = value;
   }

   //============================================================
   // <T>判断老师编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTeacherIdChanged(){
      return __teacherId != _teacherId;
   }

   //============================================================
   // <T>获得老师编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long teacherId(){
      return _teacherId;
   }

   //============================================================
   // <T>获得老师编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataPersonUserUnit teacher(){
      FDataPersonUserLogic logic = _logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit unit = logic.find(_teacherId);
      return unit;
   }

   //============================================================
   // <T>设置老师编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTeacherId(long value){
      _teacherId = value;
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
   // <T>判断活动编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isActivityIdChanged(){
      return __activityId != _activityId;
   }

   //============================================================
   // <T>获得活动编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long activityId(){
      return _activityId;
   }

   //============================================================
   // <T>设置活动编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setActivityId(long value){
      _activityId = value;
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
   // <T>判断资源部署状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResourceDeployCdChanged(){
      return __resourceDeployCd != _resourceDeployCd;
   }

   //============================================================
   // <T>获得资源部署状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int resourceDeployCd(){
      return _resourceDeployCd;
   }

   //============================================================
   // <T>设置资源部署状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResourceDeployCd(int value){
      _resourceDeployCd = value;
   }

   //============================================================
   // <T>判断显示类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDisplayCdChanged(){
      return __displayCd != _displayCd;
   }

   //============================================================
   // <T>获得显示类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int displayCd(){
      return _displayCd;
   }

   //============================================================
   // <T>设置显示类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDisplayCd(int value){
      _displayCd = value;
   }

   //============================================================
   // <T>判断排序值的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDisplayOrderChanged(){
      return __displayOrder != _displayOrder;
   }

   //============================================================
   // <T>获得排序值的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int displayOrder(){
      return _displayOrder;
   }

   //============================================================
   // <T>设置排序值的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDisplayOrder(int value){
      _displayOrder = value;
   }

   //============================================================
   // <T>判断审核日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isExamineDateChanged(){
      return !__examineDate.equals(_examineDate);
   }

   //============================================================
   // <T>获得审核日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime examineDate(){
      return _examineDate;
   }

   //============================================================
   // <T>设置审核日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setExamineDate(TDateTime value){
      _examineDate = value;
   }

   //============================================================
   // <T>判断审核结果类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isExamineResultCdChanged(){
      return __examineResultCd != _examineResultCd;
   }

   //============================================================
   // <T>获得审核结果类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int examineResultCd(){
      return _examineResultCd;
   }

   //============================================================
   // <T>设置审核结果类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setExamineResultCd(int value){
      _examineResultCd = value;
   }

   //============================================================
   // <T>判断推荐类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendCdChanged(){
      return __recommendCd != _recommendCd;
   }

   //============================================================
   // <T>获得推荐类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int recommendCd(){
      return _recommendCd;
   }

   //============================================================
   // <T>设置推荐类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendCd(int value){
      _recommendCd = value;
   }

   //============================================================
   // <T>判断图标地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIconUrlChanged(){
      return !RString.equals(__iconUrl, _iconUrl);
   }

   //============================================================
   // <T>获得图标地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String iconUrl(){
      return _iconUrl;
   }

   //============================================================
   // <T>设置图标地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIconUrl(String value){
      _iconUrl = value;
   }

   //============================================================
   // <T>判断外链地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkUrlChanged(){
      return !RString.equals(__linkUrl, _linkUrl);
   }

   //============================================================
   // <T>获得外链地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String linkUrl(){
      return _linkUrl;
   }

   //============================================================
   // <T>设置外链地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkUrl(String value){
      _linkUrl = value;
   }

   //============================================================
   // <T>判断版本编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isVersionNumberChanged(){
      return __versionNumber != _versionNumber;
   }

   //============================================================
   // <T>获得版本编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int versionNumber(){
      return _versionNumber;
   }

   //============================================================
   // <T>设置版本编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setVersionNumber(int value){
      _versionNumber = value;
   }

   //============================================================
   // <T>判断版本代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isVersionCodeChanged(){
      return !RString.equals(__versionCode, _versionCode);
   }

   //============================================================
   // <T>获得版本代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String versionCode(){
      return _versionCode;
   }

   //============================================================
   // <T>设置版本代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setVersionCode(String value){
      _versionCode = value;
   }

   //============================================================
   // <T>判断关键字的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isKeywordsChanged(){
      return !RString.equals(__keywords, _keywords);
   }

   //============================================================
   // <T>获得关键字的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String keywords(){
      return _keywords;
   }

   //============================================================
   // <T>设置关键字的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setKeywords(String value){
      _keywords = value;
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
   // <T>判断播放次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPlayCountChanged(){
      return __playCount != _playCount;
   }

   //============================================================
   // <T>获得播放次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int playCount(){
      return _playCount;
   }

   //============================================================
   // <T>设置播放次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPlayCount(int value){
      _playCount = value;
   }

   //============================================================
   // <T>判断点攒次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPraiseCountChanged(){
      return __praiseCount != _praiseCount;
   }

   //============================================================
   // <T>获得点攒次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int praiseCount(){
      return _praiseCount;
   }

   //============================================================
   // <T>设置点攒次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPraiseCount(int value){
      _praiseCount = value;
   }

   //============================================================
   // <T>判断关注(收藏)次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAttentionCountChanged(){
      return __attentionCount != _attentionCount;
   }

   //============================================================
   // <T>获得关注(收藏)次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int attentionCount(){
      return _attentionCount;
   }

   //============================================================
   // <T>设置关注(收藏)次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAttentionCount(int value){
      _attentionCount = value;
   }

   //============================================================
   // <T>判断分享次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isShareCountChanged(){
      return __shareCount != _shareCount;
   }

   //============================================================
   // <T>获得分享次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int shareCount(){
      return _shareCount;
   }

   //============================================================
   // <T>设置分享次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setShareCount(int value){
      _shareCount = value;
   }

   //============================================================
   // <T>判断浏览次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isViewCountChanged(){
      return __viewCount != _viewCount;
   }

   //============================================================
   // <T>获得浏览次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int viewCount(){
      return _viewCount;
   }

   //============================================================
   // <T>设置浏览次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setViewCount(int value){
      _viewCount = value;
   }

   //============================================================
   // <T>判断详细描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDescriptionChanged(){
      return !RString.equals(__description, _description);
   }

   //============================================================
   // <T>获得详细描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置详细描述的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDescription(String value){
      _description = value;
   }

   //============================================================
   // <T>判断内容的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContentChanged(){
      return !RString.equals(__content, _content);
   }

   //============================================================
   // <T>获得内容的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String content(){
      return _content;
   }

   //============================================================
   // <T>设置内容的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContent(String value){
      _content = value;
   }

   //============================================================
   // <T>判断注释内容的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得注释内容的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置注释内容的数据内容。</T>
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
         case "code":
            return _code;
         case "name":
            return _name;
         case "label":
            return _label;
         case "module_id":
            return Long.toString(_moduleId);
         case "channel_id":
            return Long.toString(_channelId);
         case "type_id":
            return Long.toString(_typeId);
         case "school_id":
            return Long.toString(_schoolId);
         case "vendor_id":
            return Long.toString(_vendorId);
         case "teacher_id":
            return Long.toString(_teacherId);
         case "user_id":
            return Long.toString(_userId);
         case "activity_id":
            return Long.toString(_activityId);
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "resource_cd":
            return RInteger.toString(_resourceCd);
         case "resource_deploy_cd":
            return RInteger.toString(_resourceDeployCd);
         case "display_cd":
            return RInteger.toString(_displayCd);
         case "display_order":
            return RInteger.toString(_displayOrder);
         case "examine_date":
            return _examineDate.toString();
         case "examine_result_cd":
            return RInteger.toString(_examineResultCd);
         case "recommend_cd":
            return RInteger.toString(_recommendCd);
         case "icon_url":
            return _iconUrl;
         case "link_url":
            return _linkUrl;
         case "version_number":
            return RInteger.toString(_versionNumber);
         case "version_code":
            return _versionCode;
         case "keywords":
            return _keywords;
         case "score_bean":
            return RInteger.toString(_scoreBean);
         case "score_point":
            return RInteger.toString(_scorePoint);
         case "score_gold":
            return RFloat.toString(_scoreGold);
         case "play_count":
            return RInteger.toString(_playCount);
         case "praise_count":
            return RInteger.toString(_praiseCount);
         case "attention_count":
            return RInteger.toString(_attentionCount);
         case "share_count":
            return RInteger.toString(_shareCount);
         case "view_count":
            return RInteger.toString(_viewCount);
         case "description":
            return _description;
         case "content":
            return _content;
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
         case "code":
            _code = value;
            break;
         case "name":
            _name = value;
            break;
         case "label":
            _label = value;
            break;
         case "module_id":
            _moduleId = RLong.parse(value);
            break;
         case "channel_id":
            _channelId = RLong.parse(value);
            break;
         case "type_id":
            _typeId = RLong.parse(value);
            break;
         case "school_id":
            _schoolId = RLong.parse(value);
            break;
         case "vendor_id":
            _vendorId = RLong.parse(value);
            break;
         case "teacher_id":
            _teacherId = RLong.parse(value);
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "activity_id":
            _activityId = RLong.parse(value);
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "resource_cd":
            _resourceCd = RInteger.parse(value);
            break;
         case "resource_deploy_cd":
            _resourceDeployCd = RInteger.parse(value);
            break;
         case "display_cd":
            _displayCd = RInteger.parse(value);
            break;
         case "display_order":
            _displayOrder = RInteger.parse(value);
            break;
         case "examine_date":
            _examineDate.parse(value);
            break;
         case "examine_result_cd":
            _examineResultCd = RInteger.parse(value);
            break;
         case "recommend_cd":
            _recommendCd = RInteger.parse(value);
            break;
         case "icon_url":
            _iconUrl = value;
            break;
         case "link_url":
            _linkUrl = value;
            break;
         case "version_number":
            _versionNumber = RInteger.parse(value);
            break;
         case "version_code":
            _versionCode = value;
            break;
         case "keywords":
            _keywords = value;
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
         case "play_count":
            _playCount = RInteger.parse(value);
            break;
         case "praise_count":
            _praiseCount = RInteger.parse(value);
            break;
         case "attention_count":
            _attentionCount = RInteger.parse(value);
            break;
         case "share_count":
            _shareCount = RInteger.parse(value);
            break;
         case "view_count":
            _viewCount = RInteger.parse(value);
            break;
         case "description":
            _description = value;
            break;
         case "content":
            _content = value;
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
            case "code":
               __code = value;
               _code = __code;
               break;
            case "name":
               __name = value;
               _name = __name;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "module_id":
               __moduleId = RLong.parse(value);
               _moduleId = __moduleId;
               break;
            case "channel_id":
               __channelId = RLong.parse(value);
               _channelId = __channelId;
               break;
            case "type_id":
               __typeId = RLong.parse(value);
               _typeId = __typeId;
               break;
            case "school_id":
               __schoolId = RLong.parse(value);
               _schoolId = __schoolId;
               break;
            case "vendor_id":
               __vendorId = RLong.parse(value);
               _vendorId = __vendorId;
               break;
            case "teacher_id":
               __teacherId = RLong.parse(value);
               _teacherId = __teacherId;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "activity_id":
               __activityId = RLong.parse(value);
               _activityId = __activityId;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "resource_cd":
               __resourceCd = RInteger.parse(value);
               _resourceCd = __resourceCd;
               break;
            case "resource_deploy_cd":
               __resourceDeployCd = RInteger.parse(value);
               _resourceDeployCd = __resourceDeployCd;
               break;
            case "display_cd":
               __displayCd = RInteger.parse(value);
               _displayCd = __displayCd;
               break;
            case "display_order":
               __displayOrder = RInteger.parse(value);
               _displayOrder = __displayOrder;
               break;
            case "examine_date":
               __examineDate.parse(value);
               _examineDate.assign(__examineDate);
               break;
            case "examine_result_cd":
               __examineResultCd = RInteger.parse(value);
               _examineResultCd = __examineResultCd;
               break;
            case "recommend_cd":
               __recommendCd = RInteger.parse(value);
               _recommendCd = __recommendCd;
               break;
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "link_url":
               __linkUrl = value;
               _linkUrl = __linkUrl;
               break;
            case "version_number":
               __versionNumber = RInteger.parse(value);
               _versionNumber = __versionNumber;
               break;
            case "version_code":
               __versionCode = value;
               _versionCode = __versionCode;
               break;
            case "keywords":
               __keywords = value;
               _keywords = __keywords;
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
            case "play_count":
               __playCount = RInteger.parse(value);
               _playCount = __playCount;
               break;
            case "praise_count":
               __praiseCount = RInteger.parse(value);
               _praiseCount = __praiseCount;
               break;
            case "attention_count":
               __attentionCount = RInteger.parse(value);
               _attentionCount = __attentionCount;
               break;
            case "share_count":
               __shareCount = RInteger.parse(value);
               _shareCount = __shareCount;
               break;
            case "view_count":
               __viewCount = RInteger.parse(value);
               _viewCount = __viewCount;
               break;
            case "description":
               __description = value;
               _description = __description;
               break;
            case "content":
               __content = value;
               _content = __content;
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
      row.set("code", _code);
      row.set("name", _name);
      row.set("label", _label);
      row.set("moduleId", _moduleId);
      row.set("channelId", _channelId);
      row.set("typeId", _typeId);
      row.set("schoolId", _schoolId);
      row.set("vendorId", _vendorId);
      row.set("teacherId", _teacherId);
      row.set("userId", _userId);
      row.set("activityId", _activityId);
      row.set("statusCd", _statusCd);
      row.set("resourceCd", _resourceCd);
      row.set("resourceDeployCd", _resourceDeployCd);
      row.set("displayCd", _displayCd);
      row.set("displayOrder", _displayOrder);
      row.set("examineDate", _examineDate);
      row.set("examineResultCd", _examineResultCd);
      row.set("recommendCd", _recommendCd);
      row.set("iconUrl", _iconUrl);
      row.set("linkUrl", _linkUrl);
      row.set("versionNumber", _versionNumber);
      row.set("versionCode", _versionCode);
      row.set("keywords", _keywords);
      row.set("scoreBean", _scoreBean);
      row.set("scorePoint", _scorePoint);
      row.set("scoreGold", _scoreGold);
      row.set("playCount", _playCount);
      row.set("praiseCount", _praiseCount);
      row.set("attentionCount", _attentionCount);
      row.set("shareCount", _shareCount);
      row.set("viewCount", _viewCount);
      row.set("description", _description);
      row.set("content", _content);
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
      map.put("code", _code);
      map.put("name", _name);
      map.put("label", _label);
      map.put("moduleId", RLong.toString(_moduleId));
      map.put("channelId", RLong.toString(_channelId));
      map.put("typeId", RLong.toString(_typeId));
      map.put("schoolId", RLong.toString(_schoolId));
      map.put("vendorId", RLong.toString(_vendorId));
      map.put("teacherId", RLong.toString(_teacherId));
      map.put("userId", RLong.toString(_userId));
      map.put("activityId", RLong.toString(_activityId));
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("resourceCd", RInteger.toString(_resourceCd));
      map.put("resourceDeployCd", RInteger.toString(_resourceDeployCd));
      map.put("displayCd", RInteger.toString(_displayCd));
      map.put("displayOrder", RInteger.toString(_displayOrder));
      map.put("examineDate", _examineDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("examineResultCd", RInteger.toString(_examineResultCd));
      map.put("recommendCd", RInteger.toString(_recommendCd));
      map.put("iconUrl", _iconUrl);
      map.put("linkUrl", _linkUrl);
      map.put("versionNumber", RInteger.toString(_versionNumber));
      map.put("versionCode", _versionCode);
      map.put("keywords", _keywords);
      map.put("scoreBean", RInteger.toString(_scoreBean));
      map.put("scorePoint", RInteger.toString(_scorePoint));
      map.put("scoreGold", RFloat.toString(_scoreGold));
      map.put("playCount", RInteger.toString(_playCount));
      map.put("praiseCount", RInteger.toString(_praiseCount));
      map.put("attentionCount", RInteger.toString(_attentionCount));
      map.put("shareCount", RInteger.toString(_shareCount));
      map.put("viewCount", RInteger.toString(_viewCount));
      map.put("description", _description);
      map.put("content", _content);
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
