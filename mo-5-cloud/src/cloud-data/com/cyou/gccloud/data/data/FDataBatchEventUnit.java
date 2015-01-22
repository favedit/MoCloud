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
// <T>后台事件表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataBatchEventUnit
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

   // 存储字段事件类型的定义。
   private int __typeCd;

   // 字段事件类型的定义。
   protected int _typeCd;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段关联类型的定义。
   private int __linkCd;

   // 字段关联类型的定义。
   protected int _linkCd;

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段状态类型的定义。
   private int __statusCd;

   // 字段状态类型的定义。
   protected int _statusCd;

   // 存储字段输入参数集合的定义。
   private String __inputParameters;

   // 字段输入参数集合的定义。
   protected String _inputParameters;

   // 存储字段输出参数集合的定义。
   private String __outputParameters;

   // 字段输出参数集合的定义。
   protected String _outputParameters;

   // 存储字段开始时间的定义。
   private TDateTime __beginDate = new TDateTime();

   // 字段开始时间的定义。
   protected TDateTime _beginDate = new TDateTime();

   // 存储字段结束时间的定义。
   private TDateTime __endDate = new TDateTime();

   // 字段结束时间的定义。
   protected TDateTime _endDate = new TDateTime();

   // 存储字段结果类型的定义。
   private int __resultCd;

   // 字段结果类型的定义。
   protected int _resultCd;

   // 存储字段结果描述的定义。
   private String __resultNote;

   // 字段结果描述的定义。
   protected String _resultNote;

   // 存储字段描述的定义。
   private String __note;

   // 字段描述的定义。
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
   // <T>构造后台事件表逻辑单元。</T>
   //============================================================
   public FDataBatchEventUnit(){
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
   // <T>判断事件类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTypeCdChanged(){
      return __typeCd != _typeCd;
   }

   //============================================================
   // <T>获得事件类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置事件类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTypeCd(int value){
      _typeCd = value;
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
   // <T>判断关联类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkCdChanged(){
      return __linkCd != _linkCd;
   }

   //============================================================
   // <T>获得关联类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int linkCd(){
      return _linkCd;
   }

   //============================================================
   // <T>设置关联类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkCd(int value){
      _linkCd = value;
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
   // <T>判断输入参数集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInputParametersChanged(){
      return !RString.equals(__inputParameters, _inputParameters);
   }

   //============================================================
   // <T>获得输入参数集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String inputParameters(){
      return _inputParameters;
   }

   //============================================================
   // <T>设置输入参数集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInputParameters(String value){
      _inputParameters = value;
   }

   //============================================================
   // <T>判断输出参数集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOutputParametersChanged(){
      return !RString.equals(__outputParameters, _outputParameters);
   }

   //============================================================
   // <T>获得输出参数集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String outputParameters(){
      return _outputParameters;
   }

   //============================================================
   // <T>设置输出参数集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOutputParameters(String value){
      _outputParameters = value;
   }

   //============================================================
   // <T>判断开始时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBeginDateChanged(){
      return !__beginDate.equals(_beginDate);
   }

   //============================================================
   // <T>获得开始时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime beginDate(){
      return _beginDate;
   }

   //============================================================
   // <T>设置开始时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBeginDate(TDateTime value){
      _beginDate = value;
   }

   //============================================================
   // <T>判断结束时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEndDateChanged(){
      return !__endDate.equals(_endDate);
   }

   //============================================================
   // <T>获得结束时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime endDate(){
      return _endDate;
   }

   //============================================================
   // <T>设置结束时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEndDate(TDateTime value){
      _endDate = value;
   }

   //============================================================
   // <T>判断结果类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResultCdChanged(){
      return __resultCd != _resultCd;
   }

   //============================================================
   // <T>获得结果类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int resultCd(){
      return _resultCd;
   }

   //============================================================
   // <T>设置结果类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResultCd(int value){
      _resultCd = value;
   }

   //============================================================
   // <T>判断结果描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isResultNoteChanged(){
      return !RString.equals(__resultNote, _resultNote);
   }

   //============================================================
   // <T>获得结果描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String resultNote(){
      return _resultNote;
   }

   //============================================================
   // <T>设置结果描述的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setResultNote(String value){
      _resultNote = value;
   }

   //============================================================
   // <T>判断描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置描述的数据内容。</T>
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
         case "type_cd":
            return RInteger.toString(_typeCd);
         case "code":
            return _code;
         case "user_id":
            return Long.toString(_userId);
         case "link_cd":
            return RInteger.toString(_linkCd);
         case "link_id":
            return Long.toString(_linkId);
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "input_parameters":
            return _inputParameters;
         case "output_parameters":
            return _outputParameters;
         case "begin_date":
            return _beginDate.toString();
         case "end_date":
            return _endDate.toString();
         case "result_cd":
            return RInteger.toString(_resultCd);
         case "result_note":
            return _resultNote;
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
         case "type_cd":
            _typeCd = RInteger.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "link_cd":
            _linkCd = RInteger.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "input_parameters":
            _inputParameters = value;
            break;
         case "output_parameters":
            _outputParameters = value;
            break;
         case "begin_date":
            _beginDate.parse(value);
            break;
         case "end_date":
            _endDate.parse(value);
            break;
         case "result_cd":
            _resultCd = RInteger.parse(value);
            break;
         case "result_note":
            _resultNote = value;
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
            case "type_cd":
               __typeCd = RInteger.parse(value);
               _typeCd = __typeCd;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "link_cd":
               __linkCd = RInteger.parse(value);
               _linkCd = __linkCd;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "input_parameters":
               __inputParameters = value;
               _inputParameters = __inputParameters;
               break;
            case "output_parameters":
               __outputParameters = value;
               _outputParameters = __outputParameters;
               break;
            case "begin_date":
               __beginDate.parse(value);
               _beginDate.assign(__beginDate);
               break;
            case "end_date":
               __endDate.parse(value);
               _endDate.assign(__endDate);
               break;
            case "result_cd":
               __resultCd = RInteger.parse(value);
               _resultCd = __resultCd;
               break;
            case "result_note":
               __resultNote = value;
               _resultNote = __resultNote;
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
      row.set("typeCd", _typeCd);
      row.set("code", _code);
      row.set("userId", _userId);
      row.set("linkCd", _linkCd);
      row.set("linkId", _linkId);
      row.set("statusCd", _statusCd);
      row.set("inputParameters", _inputParameters);
      row.set("outputParameters", _outputParameters);
      row.set("beginDate", _beginDate);
      row.set("endDate", _endDate);
      row.set("resultCd", _resultCd);
      row.set("resultNote", _resultNote);
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
      map.put("typeCd", RInteger.toString(_typeCd));
      map.put("code", _code);
      map.put("userId", RLong.toString(_userId));
      map.put("linkCd", RInteger.toString(_linkCd));
      map.put("linkId", RLong.toString(_linkId));
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("inputParameters", _inputParameters);
      map.put("outputParameters", _outputParameters);
      map.put("beginDate", _beginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("endDate", _endDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("resultCd", RInteger.toString(_resultCd));
      map.put("resultNote", _resultNote);
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
