package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.lang.*;
import org.mo.com.lang.type.*;
import org.mo.com.collections.*;
import org.mo.com.io.*;
import org.mo.core.aop.face.*;
import org.mo.data.logic.*;

//============================================================
// <T>控制角色模块表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataControlRoleModuleUnit extends FLogicUnit
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

   // 存储字段角色编号的定义。
   private long __roleId;

   // 字段角色编号的定义。
   protected long _roleId;

   // 存储字段模块编号的定义。
   private long __moduleId;

   // 字段模块编号的定义。
   protected long _moduleId;

   // 存储字段查看有效类型的定义。
   private int __viewValidCd;

   // 字段查看有效类型的定义。
   protected int _viewValidCd;

   // 存储字段新建有效类型的定义。
   private int __insertValidCd;

   // 字段新建有效类型的定义。
   protected int _insertValidCd;

   // 存储字段修改有效类型的定义。
   private int __updateValidCd;

   // 字段修改有效类型的定义。
   protected int _updateValidCd;

   // 存储字段删除有效类型的定义。
   private int __deleteValidCd;

   // 字段删除有效类型的定义。
   protected int _deleteValidCd;

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
   // <T>构造控制角色模块表逻辑单元。</T>
   //============================================================
   public FDataControlRoleModuleUnit(){
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
   // <T>判断角色编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleIdChanged(){
      return __roleId != _roleId;
   }

   //============================================================
   // <T>获得角色编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long roleId(){
      return _roleId;
   }

   //============================================================
   // <T>获得角色编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataControlRoleUnit role(){
      FDataControlRoleLogic logic = _logicContext.findLogic(FDataControlRoleLogic.class);
      FDataControlRoleUnit unit = logic.find(_roleId);
      return unit;
   }

   //============================================================
   // <T>设置角色编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleId(long value){
      _roleId = value;
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
   public FDataControlModuleUnit module(){
      FDataControlModuleLogic logic = _logicContext.findLogic(FDataControlModuleLogic.class);
      FDataControlModuleUnit unit = logic.find(_moduleId);
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
   // <T>判断查看有效类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isViewValidCdChanged(){
      return __viewValidCd != _viewValidCd;
   }

   //============================================================
   // <T>获得查看有效类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int viewValidCd(){
      return _viewValidCd;
   }

   //============================================================
   // <T>设置查看有效类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setViewValidCd(int value){
      _viewValidCd = value;
   }

   //============================================================
   // <T>判断新建有效类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInsertValidCdChanged(){
      return __insertValidCd != _insertValidCd;
   }

   //============================================================
   // <T>获得新建有效类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int insertValidCd(){
      return _insertValidCd;
   }

   //============================================================
   // <T>设置新建有效类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInsertValidCd(int value){
      _insertValidCd = value;
   }

   //============================================================
   // <T>判断修改有效类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateValidCdChanged(){
      return __updateValidCd != _updateValidCd;
   }

   //============================================================
   // <T>获得修改有效类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int updateValidCd(){
      return _updateValidCd;
   }

   //============================================================
   // <T>设置修改有效类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateValidCd(int value){
      _updateValidCd = value;
   }

   //============================================================
   // <T>判断删除有效类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeleteValidCdChanged(){
      return __deleteValidCd != _deleteValidCd;
   }

   //============================================================
   // <T>获得删除有效类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int deleteValidCd(){
      return _deleteValidCd;
   }

   //============================================================
   // <T>设置删除有效类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeleteValidCd(int value){
      _deleteValidCd = value;
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
         case "role_id":
            return Long.toString(_roleId);
         case "module_id":
            return Long.toString(_moduleId);
         case "view_valid_cd":
            return RInteger.toString(_viewValidCd);
         case "insert_valid_cd":
            return RInteger.toString(_insertValidCd);
         case "update_valid_cd":
            return RInteger.toString(_updateValidCd);
         case "delete_valid_cd":
            return RInteger.toString(_deleteValidCd);
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
         case "role_id":
            _roleId = RLong.parse(value);
            break;
         case "module_id":
            _moduleId = RLong.parse(value);
            break;
         case "view_valid_cd":
            _viewValidCd = RInteger.parse(value);
            break;
         case "insert_valid_cd":
            _insertValidCd = RInteger.parse(value);
            break;
         case "update_valid_cd":
            _updateValidCd = RInteger.parse(value);
            break;
         case "delete_valid_cd":
            _deleteValidCd = RInteger.parse(value);
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
            case "role_id":
               __roleId = RLong.parse(value);
               _roleId = __roleId;
               break;
            case "module_id":
               __moduleId = RLong.parse(value);
               _moduleId = __moduleId;
               break;
            case "view_valid_cd":
               __viewValidCd = RInteger.parse(value);
               _viewValidCd = __viewValidCd;
               break;
            case "insert_valid_cd":
               __insertValidCd = RInteger.parse(value);
               _insertValidCd = __insertValidCd;
               break;
            case "update_valid_cd":
               __updateValidCd = RInteger.parse(value);
               _updateValidCd = __updateValidCd;
               break;
            case "delete_valid_cd":
               __deleteValidCd = RInteger.parse(value);
               _deleteValidCd = __deleteValidCd;
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
      row.set("roleId", _roleId);
      row.set("moduleId", _moduleId);
      row.set("viewValidCd", _viewValidCd);
      row.set("insertValidCd", _insertValidCd);
      row.set("updateValidCd", _updateValidCd);
      row.set("deleteValidCd", _deleteValidCd);
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
      map.put("roleId", RLong.toString(_roleId));
      map.put("moduleId", RLong.toString(_moduleId));
      map.put("viewValidCd", RInteger.toString(_viewValidCd));
      map.put("insertValidCd", RInteger.toString(_insertValidCd));
      map.put("updateValidCd", RInteger.toString(_updateValidCd));
      map.put("deleteValidCd", RInteger.toString(_deleteValidCd));
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
      _roleId = input.readInt64();
      _moduleId = input.readInt64();
      _viewValidCd = input.readInt32();
      _insertValidCd = input.readInt32();
      _updateValidCd = input.readInt32();
      _deleteValidCd = input.readInt32();
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
      output.writeInt64(_roleId);
      output.writeInt64(_moduleId);
      output.writeInt32(_viewValidCd);
      output.writeInt32(_insertValidCd);
      output.writeInt32(_updateValidCd);
      output.writeInt32(_deleteValidCd);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
