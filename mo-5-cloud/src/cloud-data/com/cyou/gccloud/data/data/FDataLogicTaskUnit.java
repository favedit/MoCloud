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
// <T>业务任务表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataLogicTaskUnit
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

   // 存储字段任务标题的定义。
   private String __label;

   // 字段任务标题的定义。
   protected String _label;

   // 存储字段任务图标的定义。
   private String __iconUrl;

   // 字段任务图标的定义。
   protected String _iconUrl;

   // 存储字段状态的定义。
   private int __statusCd;

   // 字段状态的定义。
   protected int _statusCd;

   // 存储字段是否显示的定义。
   private int __displayCd;

   // 字段是否显示的定义。
   protected int _displayCd;

   // 存储字段排序值的定义。
   private int __displayOrder;

   // 字段排序值的定义。
   protected int _displayOrder;

   // 存储字段分组枚举的定义。
   private int __groupCd;

   // 字段分组枚举的定义。
   protected int _groupCd;

   // 存储字段类型枚举的定义。
   private int __typeCd;

   // 字段类型枚举的定义。
   protected int _typeCd;

   // 存储字段接受枚举的定义。
   private int __acceptCd;

   // 字段接受枚举的定义。
   protected int _acceptCd;

   // 存储字段完成枚举的定义。
   private int __finishCd;

   // 字段完成枚举的定义。
   protected int _finishCd;

   // 存储字段重复枚举的定义。
   private int __repeatCd;

   // 字段重复枚举的定义。
   protected int _repeatCd;

   // 存储字段得分枚举的定义。
   private int __scoreCd;

   // 字段得分枚举的定义。
   protected int _scoreCd;

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

   // 存储字段关联类型编号的定义。
   private long __linkTypeId;

   // 字段关联类型编号的定义。
   protected long _linkTypeId;

   // 存储字段关键字的定义。
   private String __keywords;

   // 字段关键字的定义。
   protected String _keywords;

   // 存储字段浏览次数的定义。
   private int __viewCount;

   // 字段浏览次数的定义。
   protected int _viewCount;

   // 存储字段任务描述的定义。
   private String __description;

   // 字段任务描述的定义。
   protected String _description;

   // 存储字段内容的定义。
   private String __content;

   // 字段内容的定义。
   protected String _content;

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
   // <T>构造业务任务表逻辑单元。</T>
   //============================================================
   public FDataLogicTaskUnit(){
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
   // <T>判断任务标题的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得任务标题的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置任务标题的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断任务图标的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIconUrlChanged(){
      return !RString.equals(__iconUrl, _iconUrl);
   }

   //============================================================
   // <T>获得任务图标的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String iconUrl(){
      return _iconUrl;
   }

   //============================================================
   // <T>设置任务图标的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIconUrl(String value){
      _iconUrl = value;
   }

   //============================================================
   // <T>判断状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatusCdChanged(){
      return __statusCd != _statusCd;
   }

   //============================================================
   // <T>获得状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int statusCd(){
      return _statusCd;
   }

   //============================================================
   // <T>设置状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatusCd(int value){
      _statusCd = value;
   }

   //============================================================
   // <T>判断是否显示的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDisplayCdChanged(){
      return __displayCd != _displayCd;
   }

   //============================================================
   // <T>获得是否显示的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int displayCd(){
      return _displayCd;
   }

   //============================================================
   // <T>设置是否显示的数据内容。</T>
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
   // <T>判断分组枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGroupCdChanged(){
      return __groupCd != _groupCd;
   }

   //============================================================
   // <T>获得分组枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int groupCd(){
      return _groupCd;
   }

   //============================================================
   // <T>设置分组枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGroupCd(int value){
      _groupCd = value;
   }

   //============================================================
   // <T>判断类型枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTypeCdChanged(){
      return __typeCd != _typeCd;
   }

   //============================================================
   // <T>获得类型枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTypeCd(int value){
      _typeCd = value;
   }

   //============================================================
   // <T>判断接受枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptCdChanged(){
      return __acceptCd != _acceptCd;
   }

   //============================================================
   // <T>获得接受枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int acceptCd(){
      return _acceptCd;
   }

   //============================================================
   // <T>设置接受枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptCd(int value){
      _acceptCd = value;
   }

   //============================================================
   // <T>判断完成枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFinishCdChanged(){
      return __finishCd != _finishCd;
   }

   //============================================================
   // <T>获得完成枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int finishCd(){
      return _finishCd;
   }

   //============================================================
   // <T>设置完成枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFinishCd(int value){
      _finishCd = value;
   }

   //============================================================
   // <T>判断重复枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRepeatCdChanged(){
      return __repeatCd != _repeatCd;
   }

   //============================================================
   // <T>获得重复枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int repeatCd(){
      return _repeatCd;
   }

   //============================================================
   // <T>设置重复枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRepeatCd(int value){
      _repeatCd = value;
   }

   //============================================================
   // <T>判断得分枚举的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreCdChanged(){
      return __scoreCd != _scoreCd;
   }

   //============================================================
   // <T>获得得分枚举的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreCd(){
      return _scoreCd;
   }

   //============================================================
   // <T>设置得分枚举的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreCd(int value){
      _scoreCd = value;
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
   // <T>判断关联类型编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkTypeIdChanged(){
      return __linkTypeId != _linkTypeId;
   }

   //============================================================
   // <T>获得关联类型编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkTypeId(){
      return _linkTypeId;
   }

   //============================================================
   // <T>设置关联类型编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkTypeId(long value){
      _linkTypeId = value;
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
   // <T>判断任务描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDescriptionChanged(){
      return !RString.equals(__description, _description);
   }

   //============================================================
   // <T>获得任务描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置任务描述的数据内容。</T>
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
         case "code":
            return _code;
         case "label":
            return _label;
         case "icon_url":
            return _iconUrl;
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "display_cd":
            return RInteger.toString(_displayCd);
         case "display_order":
            return RInteger.toString(_displayOrder);
         case "group_cd":
            return RInteger.toString(_groupCd);
         case "type_cd":
            return RInteger.toString(_typeCd);
         case "accept_cd":
            return RInteger.toString(_acceptCd);
         case "finish_cd":
            return RInteger.toString(_finishCd);
         case "repeat_cd":
            return RInteger.toString(_repeatCd);
         case "score_cd":
            return RInteger.toString(_scoreCd);
         case "score_bean":
            return RInteger.toString(_scoreBean);
         case "score_point":
            return RInteger.toString(_scorePoint);
         case "score_gold":
            return RFloat.toString(_scoreGold);
         case "link_type_id":
            return Long.toString(_linkTypeId);
         case "keywords":
            return _keywords;
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
         case "label":
            _label = value;
            break;
         case "icon_url":
            _iconUrl = value;
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "display_cd":
            _displayCd = RInteger.parse(value);
            break;
         case "display_order":
            _displayOrder = RInteger.parse(value);
            break;
         case "group_cd":
            _groupCd = RInteger.parse(value);
            break;
         case "type_cd":
            _typeCd = RInteger.parse(value);
            break;
         case "accept_cd":
            _acceptCd = RInteger.parse(value);
            break;
         case "finish_cd":
            _finishCd = RInteger.parse(value);
            break;
         case "repeat_cd":
            _repeatCd = RInteger.parse(value);
            break;
         case "score_cd":
            _scoreCd = RInteger.parse(value);
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
         case "link_type_id":
            _linkTypeId = RLong.parse(value);
            break;
         case "keywords":
            _keywords = value;
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
            case "label":
               __label = value;
               _label = __label;
               break;
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "display_cd":
               __displayCd = RInteger.parse(value);
               _displayCd = __displayCd;
               break;
            case "display_order":
               __displayOrder = RInteger.parse(value);
               _displayOrder = __displayOrder;
               break;
            case "group_cd":
               __groupCd = RInteger.parse(value);
               _groupCd = __groupCd;
               break;
            case "type_cd":
               __typeCd = RInteger.parse(value);
               _typeCd = __typeCd;
               break;
            case "accept_cd":
               __acceptCd = RInteger.parse(value);
               _acceptCd = __acceptCd;
               break;
            case "finish_cd":
               __finishCd = RInteger.parse(value);
               _finishCd = __finishCd;
               break;
            case "repeat_cd":
               __repeatCd = RInteger.parse(value);
               _repeatCd = __repeatCd;
               break;
            case "score_cd":
               __scoreCd = RInteger.parse(value);
               _scoreCd = __scoreCd;
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
            case "link_type_id":
               __linkTypeId = RLong.parse(value);
               _linkTypeId = __linkTypeId;
               break;
            case "keywords":
               __keywords = value;
               _keywords = __keywords;
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
      row.set("label", _label);
      row.set("iconUrl", _iconUrl);
      row.set("statusCd", _statusCd);
      row.set("displayCd", _displayCd);
      row.set("displayOrder", _displayOrder);
      row.set("groupCd", _groupCd);
      row.set("typeCd", _typeCd);
      row.set("acceptCd", _acceptCd);
      row.set("finishCd", _finishCd);
      row.set("repeatCd", _repeatCd);
      row.set("scoreCd", _scoreCd);
      row.set("scoreBean", _scoreBean);
      row.set("scorePoint", _scorePoint);
      row.set("scoreGold", _scoreGold);
      row.set("linkTypeId", _linkTypeId);
      row.set("keywords", _keywords);
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
      map.put("label", _label);
      map.put("iconUrl", _iconUrl);
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("displayCd", RInteger.toString(_displayCd));
      map.put("displayOrder", RInteger.toString(_displayOrder));
      map.put("groupCd", RInteger.toString(_groupCd));
      map.put("typeCd", RInteger.toString(_typeCd));
      map.put("acceptCd", RInteger.toString(_acceptCd));
      map.put("finishCd", RInteger.toString(_finishCd));
      map.put("repeatCd", RInteger.toString(_repeatCd));
      map.put("scoreCd", RInteger.toString(_scoreCd));
      map.put("scoreBean", RInteger.toString(_scoreBean));
      map.put("scorePoint", RInteger.toString(_scorePoint));
      map.put("scoreGold", RFloat.toString(_scoreGold));
      map.put("linkTypeId", RLong.toString(_linkTypeId));
      map.put("keywords", _keywords);
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
