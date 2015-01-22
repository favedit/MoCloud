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
// <T>系统角色模块表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataSystemRoleModuleUnit
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

   // 存储字段角色编号的定义。
   private long __roleId;

   // 字段角色编号的定义。
   protected long _roleId;

   // 存储字段模块编号的定义。
   private long __moduleId;

   // 字段模块编号的定义。
   protected long _moduleId;

   // 存储字段查看权限类型的定义。
   private int __viewSecurityCd;

   // 字段查看权限类型的定义。
   protected int _viewSecurityCd;

   // 存储字段新建权限类型的定义。
   private int __insertSecurityCd;

   // 字段新建权限类型的定义。
   protected int _insertSecurityCd;

   // 存储字段修改权限类型的定义。
   private int __updateSecurityCd;

   // 字段修改权限类型的定义。
   protected int _updateSecurityCd;

   // 存储字段删除权限类型的定义。
   private int __deleteSecurityCd;

   // 字段删除权限类型的定义。
   protected int _deleteSecurityCd;

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
   // <T>构造系统角色模块表逻辑单元。</T>
   //============================================================
   public FDataSystemRoleModuleUnit(){
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
   public FDataSystemRoleUnit role(){
      FDataSystemRoleLogic logic = _logicContext.findLogic(FDataSystemRoleLogic.class);
      FDataSystemRoleUnit unit = logic.find(_roleId);
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
   public FDataSystemModuleUnit module(){
      FDataSystemModuleLogic logic = _logicContext.findLogic(FDataSystemModuleLogic.class);
      FDataSystemModuleUnit unit = logic.find(_moduleId);
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
   // <T>判断查看权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isViewSecurityCdChanged(){
      return __viewSecurityCd != _viewSecurityCd;
   }

   //============================================================
   // <T>获得查看权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int viewSecurityCd(){
      return _viewSecurityCd;
   }

   //============================================================
   // <T>设置查看权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setViewSecurityCd(int value){
      _viewSecurityCd = value;
   }

   //============================================================
   // <T>判断新建权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInsertSecurityCdChanged(){
      return __insertSecurityCd != _insertSecurityCd;
   }

   //============================================================
   // <T>获得新建权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int insertSecurityCd(){
      return _insertSecurityCd;
   }

   //============================================================
   // <T>设置新建权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInsertSecurityCd(int value){
      _insertSecurityCd = value;
   }

   //============================================================
   // <T>判断修改权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateSecurityCdChanged(){
      return __updateSecurityCd != _updateSecurityCd;
   }

   //============================================================
   // <T>获得修改权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int updateSecurityCd(){
      return _updateSecurityCd;
   }

   //============================================================
   // <T>设置修改权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateSecurityCd(int value){
      _updateSecurityCd = value;
   }

   //============================================================
   // <T>判断删除权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDeleteSecurityCdChanged(){
      return __deleteSecurityCd != _deleteSecurityCd;
   }

   //============================================================
   // <T>获得删除权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int deleteSecurityCd(){
      return _deleteSecurityCd;
   }

   //============================================================
   // <T>设置删除权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDeleteSecurityCd(int value){
      _deleteSecurityCd = value;
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
         case "view_security_cd":
            return RInteger.toString(_viewSecurityCd);
         case "insert_security_cd":
            return RInteger.toString(_insertSecurityCd);
         case "update_security_cd":
            return RInteger.toString(_updateSecurityCd);
         case "delete_security_cd":
            return RInteger.toString(_deleteSecurityCd);
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
         case "view_security_cd":
            _viewSecurityCd = RInteger.parse(value);
            break;
         case "insert_security_cd":
            _insertSecurityCd = RInteger.parse(value);
            break;
         case "update_security_cd":
            _updateSecurityCd = RInteger.parse(value);
            break;
         case "delete_security_cd":
            _deleteSecurityCd = RInteger.parse(value);
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
            case "view_security_cd":
               __viewSecurityCd = RInteger.parse(value);
               _viewSecurityCd = __viewSecurityCd;
               break;
            case "insert_security_cd":
               __insertSecurityCd = RInteger.parse(value);
               _insertSecurityCd = __insertSecurityCd;
               break;
            case "update_security_cd":
               __updateSecurityCd = RInteger.parse(value);
               _updateSecurityCd = __updateSecurityCd;
               break;
            case "delete_security_cd":
               __deleteSecurityCd = RInteger.parse(value);
               _deleteSecurityCd = __deleteSecurityCd;
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
      row.set("viewSecurityCd", _viewSecurityCd);
      row.set("insertSecurityCd", _insertSecurityCd);
      row.set("updateSecurityCd", _updateSecurityCd);
      row.set("deleteSecurityCd", _deleteSecurityCd);
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
      map.put("viewSecurityCd", RInteger.toString(_viewSecurityCd));
      map.put("insertSecurityCd", RInteger.toString(_insertSecurityCd));
      map.put("updateSecurityCd", RInteger.toString(_updateSecurityCd));
      map.put("deleteSecurityCd", RInteger.toString(_deleteSecurityCd));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
