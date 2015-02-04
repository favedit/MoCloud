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
public class FDataResourceBitmapImageUnit
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

   // 存储字段位图编号的定义。
   private long __bitmapId;

   // 字段位图编号的定义。
   protected long _bitmapId;

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

   // 存储字段大小宽度的定义。
   private int __sizeWidth;

   // 字段大小宽度的定义。
   protected int _sizeWidth;

   // 存储字段大小高度的定义。
   private int __sizeHeight;

   // 字段大小高度的定义。
   protected int _sizeHeight;

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
   public FDataResourceBitmapImageUnit(){
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
   // <T>判断位图编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBitmapIdChanged(){
      return __bitmapId != _bitmapId;
   }

   //============================================================
   // <T>获得位图编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long bitmapId(){
      return _bitmapId;
   }

   //============================================================
   // <T>获得位图编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataResourceBitmapUnit bitmap(){
      FDataResourceBitmapLogic logic = _logicContext.findLogic(FDataResourceBitmapLogic.class);
      FDataResourceBitmapUnit unit = logic.find(_bitmapId);
      return unit;
   }

   //============================================================
   // <T>设置位图编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBitmapId(long value){
      _bitmapId = value;
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
   // <T>判断大小宽度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSizeWidthChanged(){
      return __sizeWidth != _sizeWidth;
   }

   //============================================================
   // <T>获得大小宽度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int sizeWidth(){
      return _sizeWidth;
   }

   //============================================================
   // <T>设置大小宽度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSizeWidth(int value){
      _sizeWidth = value;
   }

   //============================================================
   // <T>判断大小高度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSizeHeightChanged(){
      return __sizeHeight != _sizeHeight;
   }

   //============================================================
   // <T>获得大小高度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int sizeHeight(){
      return _sizeHeight;
   }

   //============================================================
   // <T>设置大小高度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSizeHeight(int value){
      _sizeHeight = value;
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
         case "bitmap_id":
            return Long.toString(_bitmapId);
         case "code":
            return _code;
         case "label":
            return _label;
         case "format_code":
            return _formatCode;
         case "size_width":
            return RInteger.toString(_sizeWidth);
         case "size_height":
            return RInteger.toString(_sizeHeight);
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
         case "bitmap_id":
            _bitmapId = RLong.parse(value);
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
         case "size_width":
            _sizeWidth = RInteger.parse(value);
            break;
         case "size_height":
            _sizeHeight = RInteger.parse(value);
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
            case "bitmap_id":
               __bitmapId = RLong.parse(value);
               _bitmapId = __bitmapId;
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
            case "size_width":
               __sizeWidth = RInteger.parse(value);
               _sizeWidth = __sizeWidth;
               break;
            case "size_height":
               __sizeHeight = RInteger.parse(value);
               _sizeHeight = __sizeHeight;
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
      row.set("bitmapId", _bitmapId);
      row.set("code", _code);
      row.set("label", _label);
      row.set("formatCode", _formatCode);
      row.set("sizeWidth", _sizeWidth);
      row.set("sizeHeight", _sizeHeight);
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
      map.put("bitmapId", RLong.toString(_bitmapId));
      map.put("code", _code);
      map.put("label", _label);
      map.put("formatCode", _formatCode);
      map.put("sizeWidth", RInteger.toString(_sizeWidth));
      map.put("sizeHeight", RInteger.toString(_sizeHeight));
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
