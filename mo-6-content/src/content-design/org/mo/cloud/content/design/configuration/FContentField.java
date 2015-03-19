package org.mo.cloud.content.design.configuration;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RSet;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.FField;

//============================================================
// <T>构造内容字段。</T>
//============================================================
public class FContentField
      extends FObject
{
   // 类名称
   protected String _name;

   // 数据类型
   protected EContentData _dataCd;

   // 类名称
   protected String _linkName;

   // 数据分组
   protected String _dataGroup;

   // 数据代码
   protected String _dataCode;

   // 数据默认
   protected String _dataDefault;

   // 配置存储（存储到文件内）
   protected boolean _isStore;

   // 配置设置（发送到前端）
   protected boolean _isConfig;

   // 配置抽象
   protected boolean _isAbstract;

   // 配置默认
   protected boolean _isDefault;

   // 字段
   protected FField _field;

   // 分组字段
   protected FField _groupField;

   //============================================================
   // <T>构造内容字段。</T>
   //============================================================
   public FContentField(){
   }

   //============================================================
   // <T>构造内容类对象。</T>
   //
   // @param name 名称
   //============================================================
   public FContentField(String name,
                        String linkName,
                        EContentData dataCd,
                        String dataGroup,
                        String dataCode,
                        String dataDefault,
                        String flags){
      // 设置名称
      _name = name;
      _linkName = linkName;
      // 设置数据
      _dataCd = dataCd;
      _dataGroup = RString.empty(dataGroup);
      _dataCode = RString.empty(dataCode);
      _dataDefault = RString.empty(dataDefault);
      if((_dataGroup != null) && (_dataCode == null)){
         throw new FFatalError("Group data is valid. (data_group={1}, data_code={2})", _dataGroup, _dataCode);
      }
      // 设置标志
      if(flags.length() != 4){
         throw new FFatalError("Invalid flag. (flags={1})", flags);
      }
      _isStore = RBoolean.parse(flags.charAt(0));
      _isConfig = RBoolean.parse(flags.charAt(1));
      _isAbstract = RBoolean.parse(flags.charAt(2));
      _isDefault = RBoolean.parse(flags.charAt(3));
   }

   //============================================================
   // <T>获得节点名称。</T>
   //
   // @return 节点名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>获得关联名称。</T>
   //
   // @return 关联名称
   //============================================================
   public String linkName(){
      return _linkName;
   }

   //============================================================
   // <T>获得数据类型。</T>
   //
   // @return 数据类型
   //============================================================
   public EContentData dataCd(){
      return _dataCd;
   }

   //============================================================
   // <T>获得数据分组。</T>
   //
   // @return 数据分组
   //============================================================
   public String dataGroup(){
      return _dataGroup;
   }

   //============================================================
   // <T>获得数据代码。</T>
   //
   // @return 数据代码
   //============================================================
   public String dataCode(){
      return _dataCode;
   }

   //============================================================
   // <T>获得数据默认。</T>
   //
   // @return 数据默认
   //============================================================
   public String dataDefault(){
      return _dataDefault;
   }

   //============================================================
   // <T>获得配置存储。</T>
   //
   // @return 配置存储
   //============================================================
   public boolean isStore(){
      return _isStore;
   }

   //============================================================
   // <T>获得配置设置。</T>
   //
   // @return 配置设置
   //============================================================
   public boolean isConfig(){
      return _isConfig;
   }

   //============================================================
   // <T>获得配置抽象。</T>
   //
   // @return 配置抽象
   //============================================================
   public boolean isAbstract(){
      return _isAbstract;
   }

   //============================================================
   // <T>获得配置默认。</T>
   //
   // @return 配置默认
   //============================================================
   public boolean isDefault(){
      return _isDefault;
   }

   //============================================================
   // <T>关联字段信息。</T>
   //
   // @param field 字段信息
   //============================================================
   public void link(FField field){
      _field = field;
      _field.setAccessible(true);
   }

   //============================================================
   // <T>关联分组字段信息。</T>
   //
   // @param field 字段信息
   //============================================================
   public void linkGroup(FField field){
      _groupField = field;
      _groupField.setAccessible(true);
   }

   //============================================================
   // <T>获得实例内容。</T>
   //
   // @param instance 实例
   // @return 内容
   //============================================================
   public Object get(Object instance){
      // 获得内容
      Object fieldValue = _field.get(instance);
      // 类型处理
      Object result = null;
      switch(_dataCd){
         case Boolean:{
            boolean value = RBoolean.parse(fieldValue);
            if(value){
               result = RBoolean.TRUE_STR;
            }
            break;
         }
         case Integer:{
            int value = RInteger.parse(fieldValue);
            if(value != 0){
               result = value;
            }
            break;
         }
         case Float:{
            float value = RFloat.parse(fieldValue);
            if(value != 0){
               result = value;
            }
            break;
         }
         case String:{
            String valueString = RString.toString(fieldValue);
            if(!RString.isEmpty(valueString)){
               result = valueString;
            }
            break;
         }
         default:
            result = _field.get(instance);
      }
      return result;
   }

   //============================================================
   // <T>设置实例内容。</T>
   //
   // @param instance 实例
   // @param value 内容
   //============================================================
   public void set(Object instance,
                   Object value){
      // 设置内容
      switch(_dataCd){
         case Boolean:
            _field.set(instance, RBoolean.parse(value));
            break;
         default:
            _field.set(instance, value);
      }
      // 设置分组内容
      if(_groupField != null){
         boolean flag = RBoolean.parse(value);
         Object groupValue = _groupField.get(instance);
         String groupString = RSet.stringSet(groupValue, _dataCode, flag);
         _groupField.set(instance, groupString);
      }
   }
}
