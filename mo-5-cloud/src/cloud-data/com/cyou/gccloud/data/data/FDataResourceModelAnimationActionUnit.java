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
// <T>资源模型动画动作表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourceModelAnimationActionUnit
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

   // 存储字段项目编号的定义。
   private long __projectId;

   // 字段项目编号的定义。
   protected long _projectId;

   // 存储字段模型编号的定义。
   private long __modelId;

   // 字段模型编号的定义。
   protected long _modelId;

   // 存储字段动画编号的定义。
   private long __animationId;

   // 字段动画编号的定义。
   protected long _animationId;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段开始帧的定义。
   private int __frameBegin;

   // 字段开始帧的定义。
   protected int _frameBegin;

   // 存储字段结束帧的定义。
   private int __frameEnd;

   // 字段结束帧的定义。
   protected int _frameEnd;

   // 存储字段帧率的定义。
   private float __frameRate;

   // 字段帧率的定义。
   protected float _frameRate;

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
   // <T>构造资源模型动画动作表逻辑单元。</T>
   //============================================================
   public FDataResourceModelAnimationActionUnit(){
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
   // <T>判断项目编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProjectIdChanged(){
      return __projectId != _projectId;
   }

   //============================================================
   // <T>获得项目编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long projectId(){
      return _projectId;
   }

   //============================================================
   // <T>获得项目编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataSolutionProjectUnit project(){
      FDataSolutionProjectLogic logic = _logicContext.findLogic(FDataSolutionProjectLogic.class);
      FDataSolutionProjectUnit unit = logic.find(_projectId);
      return unit;
   }

   //============================================================
   // <T>设置项目编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProjectId(long value){
      _projectId = value;
   }

   //============================================================
   // <T>判断模型编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isModelIdChanged(){
      return __modelId != _modelId;
   }

   //============================================================
   // <T>获得模型编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long modelId(){
      return _modelId;
   }

   //============================================================
   // <T>获得模型编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelUnit model(){
      FDataResourceModelLogic logic = _logicContext.findLogic(FDataResourceModelLogic.class);
      FDataResourceModelUnit unit = logic.find(_modelId);
      return unit;
   }

   //============================================================
   // <T>设置模型编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setModelId(long value){
      _modelId = value;
   }

   //============================================================
   // <T>判断动画编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAnimationIdChanged(){
      return __animationId != _animationId;
   }

   //============================================================
   // <T>获得动画编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long animationId(){
      return _animationId;
   }

   //============================================================
   // <T>获得动画编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelAnimationUnit animation(){
      FDataResourceModelAnimationLogic logic = _logicContext.findLogic(FDataResourceModelAnimationLogic.class);
      FDataResourceModelAnimationUnit unit = logic.find(_animationId);
      return unit;
   }

   //============================================================
   // <T>设置动画编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAnimationId(long value){
      _animationId = value;
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
   // <T>判断开始帧的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameBeginChanged(){
      return __frameBegin != _frameBegin;
   }

   //============================================================
   // <T>获得开始帧的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int frameBegin(){
      return _frameBegin;
   }

   //============================================================
   // <T>设置开始帧的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameBegin(int value){
      _frameBegin = value;
   }

   //============================================================
   // <T>判断结束帧的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameEndChanged(){
      return __frameEnd != _frameEnd;
   }

   //============================================================
   // <T>获得结束帧的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int frameEnd(){
      return _frameEnd;
   }

   //============================================================
   // <T>设置结束帧的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameEnd(int value){
      _frameEnd = value;
   }

   //============================================================
   // <T>判断帧率的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFrameRateChanged(){
      return __frameRate != _frameRate;
   }

   //============================================================
   // <T>获得帧率的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float frameRate(){
      return _frameRate;
   }

   //============================================================
   // <T>设置帧率的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFrameRate(float value){
      _frameRate = value;
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
         case "user_id":
            return Long.toString(_userId);
         case "project_id":
            return Long.toString(_projectId);
         case "model_id":
            return Long.toString(_modelId);
         case "animation_id":
            return Long.toString(_animationId);
         case "code":
            return _code;
         case "label":
            return _label;
         case "frame_begin":
            return RInteger.toString(_frameBegin);
         case "frame_end":
            return RInteger.toString(_frameEnd);
         case "frame_rate":
            return RFloat.toString(_frameRate);
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
         case "project_id":
            _projectId = RLong.parse(value);
            break;
         case "model_id":
            _modelId = RLong.parse(value);
            break;
         case "animation_id":
            _animationId = RLong.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "label":
            _label = value;
            break;
         case "frame_begin":
            _frameBegin = RInteger.parse(value);
            break;
         case "frame_end":
            _frameEnd = RInteger.parse(value);
            break;
         case "frame_rate":
            _frameRate = RFloat.parse(value);
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
            case "project_id":
               __projectId = RLong.parse(value);
               _projectId = __projectId;
               break;
            case "model_id":
               __modelId = RLong.parse(value);
               _modelId = __modelId;
               break;
            case "animation_id":
               __animationId = RLong.parse(value);
               _animationId = __animationId;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "frame_begin":
               __frameBegin = RInteger.parse(value);
               _frameBegin = __frameBegin;
               break;
            case "frame_end":
               __frameEnd = RInteger.parse(value);
               _frameEnd = __frameEnd;
               break;
            case "frame_rate":
               __frameRate = RFloat.parse(value);
               _frameRate = __frameRate;
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
      row.set("projectId", _projectId);
      row.set("modelId", _modelId);
      row.set("animationId", _animationId);
      row.set("code", _code);
      row.set("label", _label);
      row.set("frameBegin", _frameBegin);
      row.set("frameEnd", _frameEnd);
      row.set("frameRate", _frameRate);
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
      map.put("projectId", RLong.toString(_projectId));
      map.put("modelId", RLong.toString(_modelId));
      map.put("animationId", RLong.toString(_animationId));
      map.put("code", _code);
      map.put("label", _label);
      map.put("frameBegin", RInteger.toString(_frameBegin));
      map.put("frameEnd", RInteger.toString(_frameEnd));
      map.put("frameRate", RFloat.toString(_frameRate));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
