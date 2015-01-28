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
// <T>资源图片数据表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataResourcePictureDataUnit
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

   // 存储字段全局版本标识的定义。
   private String __gvid;

   // 字段全局版本标识的定义。
   protected String _gvid;

   // 存储字段图片编号的定义。
   private long __pictureId;

   // 字段图片编号的定义。
   protected long _pictureId;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段格式的定义。
   private String __formatCode;

   // 字段格式的定义。
   protected String _formatCode;

   // 存储字段宽度的定义。
   private int __width;

   // 字段宽度的定义。
   protected int _width;

   // 存储字段高度的定义。
   private int __height;

   // 字段高度的定义。
   protected int _height;

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
   // <T>构造资源图片数据表逻辑单元。</T>
   //============================================================
   public FDataResourcePictureDataUnit(){
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
   // <T>判断全局版本标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGvidChanged(){
      return !RString.equals(__gvid, _gvid);
   }

   //============================================================
   // <T>获得全局版本标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String gvid(){
      return _gvid;
   }

   //============================================================
   // <T>设置全局版本标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGvid(String value){
      _gvid = value;
   }

   //============================================================
   // <T>判断图片编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPictureIdChanged(){
      return __pictureId != _pictureId;
   }

   //============================================================
   // <T>获得图片编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long pictureId(){
      return _pictureId;
   }

   //============================================================
   // <T>获得图片编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourcePictureUnit picture(){
      FDataResourcePictureLogic logic = _logicContext.findLogic(FDataResourcePictureLogic.class);
      FDataResourcePictureUnit unit = logic.find(_pictureId);
      return unit;
   }

   //============================================================
   // <T>设置图片编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPictureId(long value){
      _pictureId = value;
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
   // <T>判断格式的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isFormatCodeChanged(){
      return !RString.equals(__formatCode, _formatCode);
   }

   //============================================================
   // <T>获得格式的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String formatCode(){
      return _formatCode;
   }

   //============================================================
   // <T>设置格式的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setFormatCode(String value){
      _formatCode = value;
   }

   //============================================================
   // <T>判断宽度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isWidthChanged(){
      return __width != _width;
   }

   //============================================================
   // <T>获得宽度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int width(){
      return _width;
   }

   //============================================================
   // <T>设置宽度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setWidth(int value){
      _width = value;
   }

   //============================================================
   // <T>判断高度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHeightChanged(){
      return __height != _height;
   }

   //============================================================
   // <T>获得高度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int height(){
      return _height;
   }

   //============================================================
   // <T>设置高度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHeight(int value){
      _height = value;
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
         case "gvid":
            return _gvid;
         case "picture_id":
            return Long.toString(_pictureId);
         case "code":
            return _code;
         case "label":
            return _label;
         case "format_code":
            return _formatCode;
         case "width":
            return RInteger.toString(_width);
         case "height":
            return RInteger.toString(_height);
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
         case "gvid":
            _gvid = value;
            break;
         case "picture_id":
            _pictureId = RLong.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "label":
            _label = value;
            break;
         case "format_code":
            _formatCode = value;
            break;
         case "width":
            _width = RInteger.parse(value);
            break;
         case "height":
            _height = RInteger.parse(value);
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
            case "gvid":
               __gvid = value;
               _gvid = __gvid;
               break;
            case "picture_id":
               __pictureId = RLong.parse(value);
               _pictureId = __pictureId;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "format_code":
               __formatCode = value;
               _formatCode = __formatCode;
               break;
            case "width":
               __width = RInteger.parse(value);
               _width = __width;
               break;
            case "height":
               __height = RInteger.parse(value);
               _height = __height;
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
      row.set("gvid", _gvid);
      row.set("pictureId", _pictureId);
      row.set("code", _code);
      row.set("label", _label);
      row.set("formatCode", _formatCode);
      row.set("width", _width);
      row.set("height", _height);
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
      map.put("gvid", _gvid);
      map.put("pictureId", RLong.toString(_pictureId));
      map.put("code", _code);
      map.put("label", _label);
      map.put("formatCode", _formatCode);
      map.put("width", RInteger.toString(_width));
      map.put("height", RInteger.toString(_height));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
