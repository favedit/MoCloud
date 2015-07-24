package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.lang.*;
import org.mo.com.lang.type.*;
import org.mo.com.collections.*;
import org.mo.core.aop.face.*;
import org.mo.data.logic.*;

//============================================================
// <T>资源网格数据流表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourceModelMeshStreamUnit extends FLogicUnit
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

   // 存储字段网格编号的定义。
   private long __meshId;

   // 字段网格编号的定义。
   protected long _meshId;

   // 存储字段排序索引的定义。
   private int __sortIndex;

   // 字段排序索引的定义。
   protected int _sortIndex;

   // 存储字段全代码的定义。
   private String __fullCode;

   // 字段全代码的定义。
   protected String _fullCode;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段元素数据类型的定义。
   private int __elementDataCd;

   // 字段元素数据类型的定义。
   protected int _elementDataCd;

   // 存储字段元素个数的定义。
   private int __elementCount;

   // 字段元素个数的定义。
   protected int _elementCount;

   // 存储字段数据宽度的定义。
   private int __dataStride;

   // 字段数据宽度的定义。
   protected int _dataStride;

   // 存储字段数据个数的定义。
   private int __dataCount;

   // 字段数据个数的定义。
   protected int _dataCount;

   // 存储字段数据长度的定义。
   private int __dataLength;

   // 字段数据长度的定义。
   protected int _dataLength;

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
   // <T>构造资源网格数据流表逻辑单元。</T>
   //============================================================
   public FDataResourceModelMeshStreamUnit(){
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
   // <T>判断网格编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMeshIdChanged(){
      return __meshId != _meshId;
   }

   //============================================================
   // <T>获得网格编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long meshId(){
      return _meshId;
   }

   //============================================================
   // <T>获得网格编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceModelMeshUnit mesh(){
      FDataResourceModelMeshLogic logic = _logicContext.findLogic(FDataResourceModelMeshLogic.class);
      FDataResourceModelMeshUnit unit = logic.find(_meshId);
      return unit;
   }

   //============================================================
   // <T>设置网格编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMeshId(long value){
      _meshId = value;
   }

   //============================================================
   // <T>判断排序索引的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSortIndexChanged(){
      return __sortIndex != _sortIndex;
   }

   //============================================================
   // <T>获得排序索引的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int sortIndex(){
      return _sortIndex;
   }

   //============================================================
   // <T>设置排序索引的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSortIndex(int value){
      _sortIndex = value;
   }

   //============================================================
   // <T>判断全代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFullCodeChanged(){
      return !RString.equals(__fullCode, _fullCode);
   }

   //============================================================
   // <T>获得全代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String fullCode(){
      return _fullCode;
   }

   //============================================================
   // <T>设置全代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFullCode(String value){
      _fullCode = value;
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
   // <T>判断元素数据类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isElementDataCdChanged(){
      return __elementDataCd != _elementDataCd;
   }

   //============================================================
   // <T>获得元素数据类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int elementDataCd(){
      return _elementDataCd;
   }

   //============================================================
   // <T>设置元素数据类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setElementDataCd(int value){
      _elementDataCd = value;
   }

   //============================================================
   // <T>判断元素个数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isElementCountChanged(){
      return __elementCount != _elementCount;
   }

   //============================================================
   // <T>获得元素个数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int elementCount(){
      return _elementCount;
   }

   //============================================================
   // <T>设置元素个数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setElementCount(int value){
      _elementCount = value;
   }

   //============================================================
   // <T>判断数据宽度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDataStrideChanged(){
      return __dataStride != _dataStride;
   }

   //============================================================
   // <T>获得数据宽度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int dataStride(){
      return _dataStride;
   }

   //============================================================
   // <T>设置数据宽度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDataStride(int value){
      _dataStride = value;
   }

   //============================================================
   // <T>判断数据个数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDataCountChanged(){
      return __dataCount != _dataCount;
   }

   //============================================================
   // <T>获得数据个数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int dataCount(){
      return _dataCount;
   }

   //============================================================
   // <T>设置数据个数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDataCount(int value){
      _dataCount = value;
   }

   //============================================================
   // <T>判断数据长度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDataLengthChanged(){
      return __dataLength != _dataLength;
   }

   //============================================================
   // <T>获得数据长度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int dataLength(){
      return _dataLength;
   }

   //============================================================
   // <T>设置数据长度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDataLength(int value){
      _dataLength = value;
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
         case "mesh_id":
            return Long.toString(_meshId);
         case "sort_index":
            return RInteger.toString(_sortIndex);
         case "full_code":
            return _fullCode;
         case "code":
            return _code;
         case "element_data_cd":
            return RInteger.toString(_elementDataCd);
         case "element_count":
            return RInteger.toString(_elementCount);
         case "data_stride":
            return RInteger.toString(_dataStride);
         case "data_count":
            return RInteger.toString(_dataCount);
         case "data_length":
            return RInteger.toString(_dataLength);
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
         case "mesh_id":
            _meshId = RLong.parse(value);
            break;
         case "sort_index":
            _sortIndex = RInteger.parse(value);
            break;
         case "full_code":
            _fullCode = value;
            break;
         case "code":
            _code = value;
            break;
         case "element_data_cd":
            _elementDataCd = RInteger.parse(value);
            break;
         case "element_count":
            _elementCount = RInteger.parse(value);
            break;
         case "data_stride":
            _dataStride = RInteger.parse(value);
            break;
         case "data_count":
            _dataCount = RInteger.parse(value);
            break;
         case "data_length":
            _dataLength = RInteger.parse(value);
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
            case "mesh_id":
               __meshId = RLong.parse(value);
               _meshId = __meshId;
               break;
            case "sort_index":
               __sortIndex = RInteger.parse(value);
               _sortIndex = __sortIndex;
               break;
            case "full_code":
               __fullCode = value;
               _fullCode = __fullCode;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "element_data_cd":
               __elementDataCd = RInteger.parse(value);
               _elementDataCd = __elementDataCd;
               break;
            case "element_count":
               __elementCount = RInteger.parse(value);
               _elementCount = __elementCount;
               break;
            case "data_stride":
               __dataStride = RInteger.parse(value);
               _dataStride = __dataStride;
               break;
            case "data_count":
               __dataCount = RInteger.parse(value);
               _dataCount = __dataCount;
               break;
            case "data_length":
               __dataLength = RInteger.parse(value);
               _dataLength = __dataLength;
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
      row.set("meshId", _meshId);
      row.set("sortIndex", _sortIndex);
      row.set("fullCode", _fullCode);
      row.set("code", _code);
      row.set("elementDataCd", _elementDataCd);
      row.set("elementCount", _elementCount);
      row.set("dataStride", _dataStride);
      row.set("dataCount", _dataCount);
      row.set("dataLength", _dataLength);
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
      map.put("meshId", RLong.toString(_meshId));
      map.put("sortIndex", RInteger.toString(_sortIndex));
      map.put("fullCode", _fullCode);
      map.put("code", _code);
      map.put("elementDataCd", RInteger.toString(_elementDataCd));
      map.put("elementCount", RInteger.toString(_elementCount));
      map.put("dataStride", RInteger.toString(_dataStride));
      map.put("dataCount", RInteger.toString(_dataCount));
      map.put("dataLength", RInteger.toString(_dataLength));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
