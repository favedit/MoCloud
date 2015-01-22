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
// <T>用户商品表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserGoodsUnit
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

   // 存储字段商品编号的定义。
   private long __goodsId;

   // 字段商品编号的定义。
   protected long _goodsId;

   // 存储字段状态类型的定义。
   private int __statusCd;

   // 字段状态类型的定义。
   protected int _statusCd;

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

   // 存储字段接收类型的定义。
   private int __acceptCd;

   // 字段接收类型的定义。
   protected int _acceptCd;

   // 存储字段接收个数的定义。
   private int __acceptCount;

   // 字段接收个数的定义。
   protected int _acceptCount;

   // 存储字段接收用户名称的定义。
   private String __acceptUserLabel;

   // 字段接收用户名称的定义。
   protected String _acceptUserLabel;

   // 存储字段接收手机号码的定义。
   private String __acceptPhoneNumber;

   // 字段接收手机号码的定义。
   protected String _acceptPhoneNumber;

   // 存储字段接收地址的定义。
   private String __acceptAddress;

   // 字段接收地址的定义。
   protected String _acceptAddress;

   // 存储字段接收备注的定义。
   private String __acceptNote;

   // 字段接收备注的定义。
   protected String _acceptNote;

   // 存储字段完成类型的定义。
   private int __finishCd;

   // 字段完成类型的定义。
   protected int _finishCd;

   // 存储字段完成个数的定义。
   private int __finishCount;

   // 字段完成个数的定义。
   protected int _finishCount;

   // 存储字段完成备注的定义。
   private String __finishNote;

   // 字段完成备注的定义。
   protected String _finishNote;

   // 存储字段备注信息的定义。
   private String __note;

   // 字段备注信息的定义。
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
   // <T>构造用户商品表逻辑单元。</T>
   //============================================================
   public FDataPersonUserGoodsUnit(){
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
   // <T>判断商品编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGoodsIdChanged(){
      return __goodsId != _goodsId;
   }

   //============================================================
   // <T>获得商品编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long goodsId(){
      return _goodsId;
   }

   //============================================================
   // <T>获得商品编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataLogicGoodsUnit goods(){
      FDataLogicGoodsLogic logic = _logicContext.findLogic(FDataLogicGoodsLogic.class);
      FDataLogicGoodsUnit unit = logic.find(_goodsId);
      return unit;
   }

   //============================================================
   // <T>设置商品编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGoodsId(long value){
      _goodsId = value;
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
   // <T>判断接收类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptCdChanged(){
      return __acceptCd != _acceptCd;
   }

   //============================================================
   // <T>获得接收类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int acceptCd(){
      return _acceptCd;
   }

   //============================================================
   // <T>设置接收类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptCd(int value){
      _acceptCd = value;
   }

   //============================================================
   // <T>判断接收个数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptCountChanged(){
      return __acceptCount != _acceptCount;
   }

   //============================================================
   // <T>获得接收个数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int acceptCount(){
      return _acceptCount;
   }

   //============================================================
   // <T>设置接收个数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptCount(int value){
      _acceptCount = value;
   }

   //============================================================
   // <T>判断接收用户名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptUserLabelChanged(){
      return !RString.equals(__acceptUserLabel, _acceptUserLabel);
   }

   //============================================================
   // <T>获得接收用户名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String acceptUserLabel(){
      return _acceptUserLabel;
   }

   //============================================================
   // <T>设置接收用户名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptUserLabel(String value){
      _acceptUserLabel = value;
   }

   //============================================================
   // <T>判断接收手机号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptPhoneNumberChanged(){
      return !RString.equals(__acceptPhoneNumber, _acceptPhoneNumber);
   }

   //============================================================
   // <T>获得接收手机号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String acceptPhoneNumber(){
      return _acceptPhoneNumber;
   }

   //============================================================
   // <T>设置接收手机号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptPhoneNumber(String value){
      _acceptPhoneNumber = value;
   }

   //============================================================
   // <T>判断接收地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptAddressChanged(){
      return !RString.equals(__acceptAddress, _acceptAddress);
   }

   //============================================================
   // <T>获得接收地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String acceptAddress(){
      return _acceptAddress;
   }

   //============================================================
   // <T>设置接收地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptAddress(String value){
      _acceptAddress = value;
   }

   //============================================================
   // <T>判断接收备注的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAcceptNoteChanged(){
      return !RString.equals(__acceptNote, _acceptNote);
   }

   //============================================================
   // <T>获得接收备注的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String acceptNote(){
      return _acceptNote;
   }

   //============================================================
   // <T>设置接收备注的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAcceptNote(String value){
      _acceptNote = value;
   }

   //============================================================
   // <T>判断完成类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFinishCdChanged(){
      return __finishCd != _finishCd;
   }

   //============================================================
   // <T>获得完成类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int finishCd(){
      return _finishCd;
   }

   //============================================================
   // <T>设置完成类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFinishCd(int value){
      _finishCd = value;
   }

   //============================================================
   // <T>判断完成个数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFinishCountChanged(){
      return __finishCount != _finishCount;
   }

   //============================================================
   // <T>获得完成个数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int finishCount(){
      return _finishCount;
   }

   //============================================================
   // <T>设置完成个数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFinishCount(int value){
      _finishCount = value;
   }

   //============================================================
   // <T>判断完成备注的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFinishNoteChanged(){
      return !RString.equals(__finishNote, _finishNote);
   }

   //============================================================
   // <T>获得完成备注的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String finishNote(){
      return _finishNote;
   }

   //============================================================
   // <T>设置完成备注的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFinishNote(String value){
      _finishNote = value;
   }

   //============================================================
   // <T>判断备注信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注信息的数据内容。</T>
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
         case "user_id":
            return Long.toString(_userId);
         case "goods_id":
            return Long.toString(_goodsId);
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "score_bean":
            return RInteger.toString(_scoreBean);
         case "score_point":
            return RInteger.toString(_scorePoint);
         case "score_gold":
            return RFloat.toString(_scoreGold);
         case "accept_cd":
            return RInteger.toString(_acceptCd);
         case "accept_count":
            return RInteger.toString(_acceptCount);
         case "accept_user_label":
            return _acceptUserLabel;
         case "accept_phone_number":
            return _acceptPhoneNumber;
         case "accept_address":
            return _acceptAddress;
         case "accept_note":
            return _acceptNote;
         case "finish_cd":
            return RInteger.toString(_finishCd);
         case "finish_count":
            return RInteger.toString(_finishCount);
         case "finish_note":
            return _finishNote;
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
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "goods_id":
            _goodsId = RLong.parse(value);
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
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
         case "accept_cd":
            _acceptCd = RInteger.parse(value);
            break;
         case "accept_count":
            _acceptCount = RInteger.parse(value);
            break;
         case "accept_user_label":
            _acceptUserLabel = value;
            break;
         case "accept_phone_number":
            _acceptPhoneNumber = value;
            break;
         case "accept_address":
            _acceptAddress = value;
            break;
         case "accept_note":
            _acceptNote = value;
            break;
         case "finish_cd":
            _finishCd = RInteger.parse(value);
            break;
         case "finish_count":
            _finishCount = RInteger.parse(value);
            break;
         case "finish_note":
            _finishNote = value;
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
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "goods_id":
               __goodsId = RLong.parse(value);
               _goodsId = __goodsId;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
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
            case "accept_cd":
               __acceptCd = RInteger.parse(value);
               _acceptCd = __acceptCd;
               break;
            case "accept_count":
               __acceptCount = RInteger.parse(value);
               _acceptCount = __acceptCount;
               break;
            case "accept_user_label":
               __acceptUserLabel = value;
               _acceptUserLabel = __acceptUserLabel;
               break;
            case "accept_phone_number":
               __acceptPhoneNumber = value;
               _acceptPhoneNumber = __acceptPhoneNumber;
               break;
            case "accept_address":
               __acceptAddress = value;
               _acceptAddress = __acceptAddress;
               break;
            case "accept_note":
               __acceptNote = value;
               _acceptNote = __acceptNote;
               break;
            case "finish_cd":
               __finishCd = RInteger.parse(value);
               _finishCd = __finishCd;
               break;
            case "finish_count":
               __finishCount = RInteger.parse(value);
               _finishCount = __finishCount;
               break;
            case "finish_note":
               __finishNote = value;
               _finishNote = __finishNote;
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
      row.set("userId", _userId);
      row.set("goodsId", _goodsId);
      row.set("statusCd", _statusCd);
      row.set("scoreBean", _scoreBean);
      row.set("scorePoint", _scorePoint);
      row.set("scoreGold", _scoreGold);
      row.set("acceptCd", _acceptCd);
      row.set("acceptCount", _acceptCount);
      row.set("acceptUserLabel", _acceptUserLabel);
      row.set("acceptPhoneNumber", _acceptPhoneNumber);
      row.set("acceptAddress", _acceptAddress);
      row.set("acceptNote", _acceptNote);
      row.set("finishCd", _finishCd);
      row.set("finishCount", _finishCount);
      row.set("finishNote", _finishNote);
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
      map.put("userId", RLong.toString(_userId));
      map.put("goodsId", RLong.toString(_goodsId));
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("scoreBean", RInteger.toString(_scoreBean));
      map.put("scorePoint", RInteger.toString(_scorePoint));
      map.put("scoreGold", RFloat.toString(_scoreGold));
      map.put("acceptCd", RInteger.toString(_acceptCd));
      map.put("acceptCount", RInteger.toString(_acceptCount));
      map.put("acceptUserLabel", _acceptUserLabel);
      map.put("acceptPhoneNumber", _acceptPhoneNumber);
      map.put("acceptAddress", _acceptAddress);
      map.put("acceptNote", _acceptNote);
      map.put("finishCd", RInteger.toString(_finishCd));
      map.put("finishCount", RInteger.toString(_finishCount));
      map.put("finishNote", _finishNote);
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
