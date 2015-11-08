package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>部门用户表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataOrganizationDepartmentUserUnit
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

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段部门编号的定义。
   private int __departmentId;

   // 字段部门编号的定义。
   protected int _departmentId;

   // 存储字段用户编号的定义。
   private int __userId;

   // 字段用户编号的定义。
   protected int _userId;

   // 存储字段雇佣关系的定义。
   private long __statusCd;

   // 字段雇佣关系的定义。
   protected long _statusCd;

   // 存储字段关联关系的定义。
   private int __relationCd;

   // 字段关联关系的定义。
   protected int _relationCd;

   // 存储字段入职时间的定义。
   private TDateTime __entryDate = new TDateTime();

   // 字段入职时间的定义。
   protected TDateTime _entryDate = new TDateTime();

   // 存储字段离职时间的定义。
   private TDateTime __leaveDate = new TDateTime();

   // 字段离职时间的定义。
   protected TDateTime _leaveDate = new TDateTime();

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
   // <T>构造部门用户表逻辑单元。</T>
   //============================================================
   public FDataOrganizationDepartmentUserUnit(){
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
   // <T>判断标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断部门编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentIdChanged(){
      return __departmentId != _departmentId;
   }

   //============================================================
   // <T>获得部门编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int departmentId(){
      return _departmentId;
   }

   //============================================================
   // <T>获得部门编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataOrganizationDepartmentUnit department(){
      FDataOrganizationDepartmentLogic logic = _logicContext.findLogic(FDataOrganizationDepartmentLogic.class);
      FDataOrganizationDepartmentUnit unit = logic.find(_departmentId);
      return unit;
   }

   //============================================================
   // <T>设置部门编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentId(int value){
      _departmentId = value;
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
   public int userId(){
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
   public void setUserId(int value){
      _userId = value;
   }

   //============================================================
   // <T>判断雇佣关系的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatusCdChanged(){
      return __statusCd != _statusCd;
   }

   //============================================================
   // <T>获得雇佣关系的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long statusCd(){
      return _statusCd;
   }

   //============================================================
   // <T>设置雇佣关系的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatusCd(long value){
      _statusCd = value;
   }

   //============================================================
   // <T>判断关联关系的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRelationCdChanged(){
      return __relationCd != _relationCd;
   }

   //============================================================
   // <T>获得关联关系的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int relationCd(){
      return _relationCd;
   }

   //============================================================
   // <T>设置关联关系的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRelationCd(int value){
      _relationCd = value;
   }

   //============================================================
   // <T>判断入职时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEntryDateChanged(){
      return !__entryDate.equals(_entryDate);
   }

   //============================================================
   // <T>获得入职时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime entryDate(){
      return _entryDate;
   }

   //============================================================
   // <T>设置入职时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEntryDate(TDateTime value){
      _entryDate = value;
   }

   //============================================================
   // <T>判断离职时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLeaveDateChanged(){
      return !__leaveDate.equals(_leaveDate);
   }

   //============================================================
   // <T>获得离职时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime leaveDate(){
      return _leaveDate;
   }

   //============================================================
   // <T>设置离职时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLeaveDate(TDateTime value){
      _leaveDate = value;
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
         case "name":
            return _name;
         case "label":
            return _label;
         case "department_id":
            return RInteger.toString(_departmentId);
         case "user_id":
            return RInteger.toString(_userId);
         case "status_cd":
            return Long.toString(_statusCd);
         case "relation_cd":
            return RInteger.toString(_relationCd);
         case "entry_date":
            return _entryDate.toString();
         case "leave_date":
            return _leaveDate.toString();
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
         case "department_id":
            _departmentId = RInteger.parse(value);
            break;
         case "user_id":
            _userId = RInteger.parse(value);
            break;
         case "status_cd":
            _statusCd = RLong.parse(value);
            break;
         case "relation_cd":
            _relationCd = RInteger.parse(value);
            break;
         case "entry_date":
            _entryDate.parse(value);
            break;
         case "leave_date":
            _leaveDate.parse(value);
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
            case "department_id":
               __departmentId = RInteger.parse(value);
               _departmentId = __departmentId;
               break;
            case "user_id":
               __userId = RInteger.parse(value);
               _userId = __userId;
               break;
            case "status_cd":
               __statusCd = RLong.parse(value);
               _statusCd = __statusCd;
               break;
            case "relation_cd":
               __relationCd = RInteger.parse(value);
               _relationCd = __relationCd;
               break;
            case "entry_date":
               __entryDate.parse(value);
               _entryDate.assign(__entryDate);
               break;
            case "leave_date":
               __leaveDate.parse(value);
               _leaveDate.assign(__leaveDate);
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
      row.set("departmentId", _departmentId);
      row.set("userId", _userId);
      row.set("statusCd", _statusCd);
      row.set("relationCd", _relationCd);
      row.set("entryDate", _entryDate);
      row.set("leaveDate", _leaveDate);
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
      map.put("departmentId", RInteger.toString(_departmentId));
      map.put("userId", RInteger.toString(_userId));
      map.put("statusCd", RLong.toString(_statusCd));
      map.put("relationCd", RInteger.toString(_relationCd));
      map.put("entryDate", _entryDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("leaveDate", _leaveDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }

   //============================================================
   // <T>反序列化数据到内容。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
      super.unserialize(input);
      _ouid = input.readInt64();
      _ovld = input.readBoolean();
      _guid = input.readString();
      _code = input.readString();
      _name = input.readString();
      _label = input.readString();
      _departmentId = input.readInt32();
      _userId = input.readInt32();
      _statusCd = input.readInt64();
      _relationCd = input.readInt32();
      _entryDate.set(input.readInt64());
      _leaveDate.set(input.readInt64());
      _note = input.readString();
      _createUserId = input.readInt64();
      _createDate.set(input.readInt64());
      _updateUserId = input.readInt64();
      _updateDate.set(input.readInt64());
   }

   //============================================================
   // <T>序列化内容到数据。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeInt64(_ouid);
      output.writeBoolean(_ovld);
      output.writeString(_guid);
      output.writeString(_code);
      output.writeString(_name);
      output.writeString(_label);
      output.writeInt32(_departmentId);
      output.writeInt32(_userId);
      output.writeInt64(_statusCd);
      output.writeInt32(_relationCd);
      output.writeInt64(_entryDate.get());
      output.writeInt64(_leaveDate.get());
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }

   //============================================================
   // <T>复制当前对象。</T>
   //
   // @param unit 对象
   // @return 对象
   //============================================================
   @Override
   public void copy(FLogicUnit logicUnit){
      super.copy(logicUnit);
      FDataOrganizationDepartmentUserUnit unit = (FDataOrganizationDepartmentUserUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setCode(_code);
      unit.setName(_name);
      unit.setLabel(_label);
      unit.setDepartmentId(_departmentId);
      unit.setUserId(_userId);
      unit.setStatusCd(_statusCd);
      unit.setRelationCd(_relationCd);
      unit.entryDate().assign(_entryDate);
      unit.leaveDate().assign(_leaveDate);
      unit.setNote(_note);
      unit.setCreateUserId(_createUserId);
      unit.createDate().assign(_createDate);
      unit.setUpdateUserId(_updateUserId);
      unit.updateDate().assign(_updateDate);
   }

   //============================================================
   // <T>克隆当前对象。</T>
   //
   // @return 对象
   //============================================================
   @Override
   public FDataOrganizationDepartmentUserUnit clone(){
      FDataOrganizationDepartmentUserUnit unit = RClass.newInstance(FDataOrganizationDepartmentUserUnit.class);
      copy(unit);
      return unit;
   }
}
