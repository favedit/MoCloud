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
// <T>组织部门逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataOrganizationDepartmentUnit
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

   // 存储字段图标地址的定义。
   private String __iconUrl;

   // 字段图标地址的定义。
   protected String _iconUrl;

   // 存储字段是否有效的定义。
   private int __validCd;

   // 字段是否有效的定义。
   protected int _validCd;

   // 存储字段父编号的定义。
   private long __parentId;

   // 字段父编号的定义。
   protected long _parentId;

   // 存储字段当前路径的定义。
   private String __pathIds;

   // 字段当前路径的定义。
   protected String _pathIds;

   // 存储字段当前的所有父名称的定义。
   private String __pathLabels;

   // 字段当前的所有父名称的定义。
   protected String _pathLabels;

   // 存储字段总人数的定义。
   private int __userCount;

   // 字段总人数的定义。
   protected int _userCount;

   // 存储字段创建时间的定义。
   private TDateTime __buildDate = new TDateTime();

   // 字段创建时间的定义。
   protected TDateTime _buildDate = new TDateTime();

   // 存储字段描述的定义。
   private String __description;

   // 字段描述的定义。
   protected String _description;

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
   // <T>构造组织部门逻辑单元。</T>
   //============================================================
   public FDataOrganizationDepartmentUnit(){
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
   // <T>判断是否有效的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isValidCdChanged(){
      return __validCd != _validCd;
   }

   //============================================================
   // <T>获得是否有效的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int validCd(){
      return _validCd;
   }

   //============================================================
   // <T>设置是否有效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setValidCd(int value){
      _validCd = value;
   }

   //============================================================
   // <T>判断父编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isParentIdChanged(){
      return __parentId != _parentId;
   }

   //============================================================
   // <T>获得父编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long parentId(){
      return _parentId;
   }

   //============================================================
   // <T>设置父编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setParentId(long value){
      _parentId = value;
   }

   //============================================================
   // <T>判断当前路径的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPathIdsChanged(){
      return !RString.equals(__pathIds, _pathIds);
   }

   //============================================================
   // <T>获得当前路径的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String pathIds(){
      return _pathIds;
   }

   //============================================================
   // <T>设置当前路径的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPathIds(String value){
      _pathIds = value;
   }

   //============================================================
   // <T>判断当前的所有父名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPathLabelsChanged(){
      return !RString.equals(__pathLabels, _pathLabels);
   }

   //============================================================
   // <T>获得当前的所有父名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String pathLabels(){
      return _pathLabels;
   }

   //============================================================
   // <T>设置当前的所有父名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPathLabels(String value){
      _pathLabels = value;
   }

   //============================================================
   // <T>判断总人数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserCountChanged(){
      return __userCount != _userCount;
   }

   //============================================================
   // <T>获得总人数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int userCount(){
      return _userCount;
   }

   //============================================================
   // <T>设置总人数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserCount(int value){
      _userCount = value;
   }

   //============================================================
   // <T>判断创建时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBuildDateChanged(){
      return !__buildDate.equals(_buildDate);
   }

   //============================================================
   // <T>获得创建时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime buildDate(){
      return _buildDate;
   }

   //============================================================
   // <T>设置创建时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBuildDate(TDateTime value){
      _buildDate = value;
   }

   //============================================================
   // <T>判断描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDescriptionChanged(){
      return !RString.equals(__description, _description);
   }

   //============================================================
   // <T>获得描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置描述的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDescription(String value){
      _description = value;
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
         case "icon_url":
            return _iconUrl;
         case "valid_cd":
            return RInteger.toString(_validCd);
         case "parent_id":
            return Long.toString(_parentId);
         case "path_ids":
            return _pathIds;
         case "path_labels":
            return _pathLabels;
         case "user_count":
            return RInteger.toString(_userCount);
         case "build_date":
            return _buildDate.toString();
         case "description":
            return _description;
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
         case "icon_url":
            _iconUrl = value;
            break;
         case "valid_cd":
            _validCd = RInteger.parse(value);
            break;
         case "parent_id":
            _parentId = RLong.parse(value);
            break;
         case "path_ids":
            _pathIds = value;
            break;
         case "path_labels":
            _pathLabels = value;
            break;
         case "user_count":
            _userCount = RInteger.parse(value);
            break;
         case "build_date":
            _buildDate.parse(value);
            break;
         case "description":
            _description = value;
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
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "valid_cd":
               __validCd = RInteger.parse(value);
               _validCd = __validCd;
               break;
            case "parent_id":
               __parentId = RLong.parse(value);
               _parentId = __parentId;
               break;
            case "path_ids":
               __pathIds = value;
               _pathIds = __pathIds;
               break;
            case "path_labels":
               __pathLabels = value;
               _pathLabels = __pathLabels;
               break;
            case "user_count":
               __userCount = RInteger.parse(value);
               _userCount = __userCount;
               break;
            case "build_date":
               __buildDate.parse(value);
               _buildDate.assign(__buildDate);
               break;
            case "description":
               __description = value;
               _description = __description;
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
      row.set("iconUrl", _iconUrl);
      row.set("validCd", _validCd);
      row.set("parentId", _parentId);
      row.set("pathIds", _pathIds);
      row.set("pathLabels", _pathLabels);
      row.set("userCount", _userCount);
      row.set("buildDate", _buildDate);
      row.set("description", _description);
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
      map.put("iconUrl", _iconUrl);
      map.put("validCd", RInteger.toString(_validCd));
      map.put("parentId", RLong.toString(_parentId));
      map.put("pathIds", _pathIds);
      map.put("pathLabels", _pathLabels);
      map.put("userCount", RInteger.toString(_userCount));
      map.put("buildDate", _buildDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("description", _description);
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
      _iconUrl = input.readString();
      _validCd = input.readInt32();
      _parentId = input.readInt64();
      _pathIds = input.readString();
      _pathLabels = input.readString();
      _userCount = input.readInt32();
      _buildDate.set(input.readInt64());
      _description = input.readString();
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
      output.writeString(_iconUrl);
      output.writeInt32(_validCd);
      output.writeInt64(_parentId);
      output.writeString(_pathIds);
      output.writeString(_pathLabels);
      output.writeInt32(_userCount);
      output.writeInt64(_buildDate.get());
      output.writeString(_description);
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
      FDataOrganizationDepartmentUnit unit = (FDataOrganizationDepartmentUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setCode(_code);
      unit.setName(_name);
      unit.setLabel(_label);
      unit.setIconUrl(_iconUrl);
      unit.setValidCd(_validCd);
      unit.setParentId(_parentId);
      unit.setPathIds(_pathIds);
      unit.setPathLabels(_pathLabels);
      unit.setUserCount(_userCount);
      unit.buildDate().assign(_buildDate);
      unit.setDescription(_description);
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
   public FDataOrganizationDepartmentUnit clone(){
      FDataOrganizationDepartmentUnit unit = RClass.newInstance(FDataOrganizationDepartmentUnit.class);
      copy(unit);
      return unit;
   }
}
