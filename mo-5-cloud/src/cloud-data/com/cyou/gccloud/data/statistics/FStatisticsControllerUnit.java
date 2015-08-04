package com.cyou.gccloud.data.statistics;

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
// <T>统计控制表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsControllerUnit
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

   // 存储字段有效的定义。
   private boolean __isValid;

   // 字段有效的定义。
   protected boolean _isValid;

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段记录时间的定义。
   private TDateTime __linkDate = new TDateTime();

   // 字段记录时间的定义。
   protected TDateTime _linkDate = new TDateTime();

   // 存储字段处理类的定义。
   private String __processClass;

   // 字段处理类的定义。
   protected String _processClass;

   // 存储字段处理参数集合的定义。
   private String __processParameters;

   // 字段处理参数集合的定义。
   protected String _processParameters;

   // 存储字段处理次数的定义。
   private int __processCount;

   // 字段处理次数的定义。
   protected int _processCount;

   // 存储字段处理单元总数的定义。
   private int __processUnitTotal;

   // 字段处理单元总数的定义。
   protected int _processUnitTotal;

   // 存储字段处理单元数的定义。
   private int __processUnitCount;

   // 字段处理单元数的定义。
   protected int _processUnitCount;

   // 存储字段处理结果的定义。
   private String __processResult;

   // 字段处理结果的定义。
   protected String _processResult;

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
   // <T>构造统计控制表逻辑单元。</T>
   //============================================================
   public FStatisticsControllerUnit(){
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
   // <T>判断有效的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIsValidChanged(){
      return __isValid != _isValid;
   }

   //============================================================
   // <T>获得有效的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isValid(){
      return _isValid;
   }

   //============================================================
   // <T>设置有效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIsValid(boolean value){
      _isValid = value;
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
   // <T>判断记录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkDateChanged(){
      return !__linkDate.equals(_linkDate);
   }

   //============================================================
   // <T>获得记录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime linkDate(){
      return _linkDate;
   }

   //============================================================
   // <T>设置记录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkDate(TDateTime value){
      _linkDate = value;
   }

   //============================================================
   // <T>判断处理类的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessClassChanged(){
      return !RString.equals(__processClass, _processClass);
   }

   //============================================================
   // <T>获得处理类的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String processClass(){
      return _processClass;
   }

   //============================================================
   // <T>设置处理类的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessClass(String value){
      _processClass = value;
   }

   //============================================================
   // <T>判断处理参数集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessParametersChanged(){
      return !RString.equals(__processParameters, _processParameters);
   }

   //============================================================
   // <T>获得处理参数集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String processParameters(){
      return _processParameters;
   }

   //============================================================
   // <T>设置处理参数集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessParameters(String value){
      _processParameters = value;
   }

   //============================================================
   // <T>判断处理次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessCountChanged(){
      return __processCount != _processCount;
   }

   //============================================================
   // <T>获得处理次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int processCount(){
      return _processCount;
   }

   //============================================================
   // <T>设置处理次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessCount(int value){
      _processCount = value;
   }

   //============================================================
   // <T>判断处理单元总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessUnitTotalChanged(){
      return __processUnitTotal != _processUnitTotal;
   }

   //============================================================
   // <T>获得处理单元总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int processUnitTotal(){
      return _processUnitTotal;
   }

   //============================================================
   // <T>设置处理单元总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessUnitTotal(int value){
      _processUnitTotal = value;
   }

   //============================================================
   // <T>判断处理单元数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessUnitCountChanged(){
      return __processUnitCount != _processUnitCount;
   }

   //============================================================
   // <T>获得处理单元数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int processUnitCount(){
      return _processUnitCount;
   }

   //============================================================
   // <T>设置处理单元数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessUnitCount(int value){
      _processUnitCount = value;
   }

   //============================================================
   // <T>判断处理结果的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProcessResultChanged(){
      return !RString.equals(__processResult, _processResult);
   }

   //============================================================
   // <T>获得处理结果的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String processResult(){
      return _processResult;
   }

   //============================================================
   // <T>设置处理结果的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProcessResult(String value){
      _processResult = value;
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
         case "is_valid":
            return RBoolean.toString(_isValid);
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "process_class":
            return _processClass;
         case "process_parameters":
            return _processParameters;
         case "process_count":
            return RInteger.toString(_processCount);
         case "process_unit_total":
            return RInteger.toString(_processUnitTotal);
         case "process_unit_count":
            return RInteger.toString(_processUnitCount);
         case "process_result":
            return _processResult;
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
         case "is_valid":
            _isValid = RBoolean.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "link_date":
            _linkDate.parse(value);
            break;
         case "process_class":
            _processClass = value;
            break;
         case "process_parameters":
            _processParameters = value;
            break;
         case "process_count":
            _processCount = RInteger.parse(value);
            break;
         case "process_unit_total":
            _processUnitTotal = RInteger.parse(value);
            break;
         case "process_unit_count":
            _processUnitCount = RInteger.parse(value);
            break;
         case "process_result":
            _processResult = value;
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
            case "is_valid":
               __isValid = RBoolean.parse(value);
               _isValid = __isValid;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "link_date":
               __linkDate.parse(value);
               _linkDate.assign(__linkDate);
               break;
            case "process_class":
               __processClass = value;
               _processClass = __processClass;
               break;
            case "process_parameters":
               __processParameters = value;
               _processParameters = __processParameters;
               break;
            case "process_count":
               __processCount = RInteger.parse(value);
               _processCount = __processCount;
               break;
            case "process_unit_total":
               __processUnitTotal = RInteger.parse(value);
               _processUnitTotal = __processUnitTotal;
               break;
            case "process_unit_count":
               __processUnitCount = RInteger.parse(value);
               _processUnitCount = __processUnitCount;
               break;
            case "process_result":
               __processResult = value;
               _processResult = __processResult;
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
      row.set("isValid", _isValid);
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("processClass", _processClass);
      row.set("processParameters", _processParameters);
      row.set("processCount", _processCount);
      row.set("processUnitTotal", _processUnitTotal);
      row.set("processUnitCount", _processUnitCount);
      row.set("processResult", _processResult);
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
      map.put("isValid", RBoolean.toString(_isValid));
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("processClass", _processClass);
      map.put("processParameters", _processParameters);
      map.put("processCount", RInteger.toString(_processCount));
      map.put("processUnitTotal", RInteger.toString(_processUnitTotal));
      map.put("processUnitCount", RInteger.toString(_processUnitCount));
      map.put("processResult", _processResult);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
