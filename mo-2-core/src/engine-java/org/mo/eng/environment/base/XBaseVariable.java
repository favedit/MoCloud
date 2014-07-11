/*
 * @(#)XBaseVariable.java
 *
 * Copyright 2008 microbject, All Rights Reserved.
 *
 */
package org.mo.eng.environment.base;

import org.mo.com.lang.FMultiString;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.lang.face.AName;
import org.mo.com.xml.EXmlConfig;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlObject;
import org.mo.com.xml.IXmlObject;

/**
 * <p>变量对象的XML节点基类</p>
 *
 * @author system
 */
public abstract class XBaseVariable
      extends FXmlObject
{
   public static final String NAME = "Variable";

   /**
    * 名称的名称定义
    */
   public static final String PTY_NAME = "name";

   /**
    * 标签的名称定义
    */
   public static final String PTY_LABEL = "label";

   /**
    * 有效性的名称定义
    */
   public static final String PTY_IS_VALID = "is_valid";

   /**
    * 注释信息的名称定义
    */
   public static final String PTY_NOTE = "note";

   /**
    * 服务的名称定义
    */
   public static final String PTY_SERVER = "server";

   /**
    * 数据内容的名称定义
    */
   public static final String PTY_DATA_VALUE = "data_value";

   /**
    * 数据提示的名称定义
    */
   public static final String PTY_DATA_HINT = "data_hint";

   public static boolean isInstance(IXmlObject xobject){
      return NAME.equals(xobject.name());
   }

   public static boolean isName(String name){
      return NAME.equals(name);
   }

   /**
    * 名称的定义
    */
   @AName("name")
   protected String _name;

   /**
    * 标签的定义
    */
   @AName("label")
   protected FMultiString _label = new FMultiString();

   /**
    * 有效性的定义
    */
   @AName("is_valid")
   protected Boolean _isValid = Boolean.FALSE;

   /**
    * 注释信息的定义
    */
   @AName("note")
   protected FMultiString _note = new FMultiString();

   /**
    * 服务的定义
    */
   @AName("server")
   protected String _server;

   /**
    * 数据内容的定义
    */
   @AName("data_value")
   protected String _dataValue;

   /**
    * 数据提示的定义
    */
   @AName("data_hint")
   protected String _dataHint;

   /**
    * 获得数据提示的内容。
    *
    * @return 数据提示
    */
   public String getDataHint(){
      return _dataHint;
   }

   /**
    * 获得数据内容的内容。
    *
    * @return 数据内容
    */
   public String getDataValue(){
      return _dataValue;
   }

   /**
    * 获得有效性的内容。
    *
    * @return 有效性
    */
   public Boolean getIsValid(){
      return _isValid;
   }

   /**
    * 获得标签的内容。
    *
    * @return 标签
    */
   public String getLabel(){
      return _label.get();
   }

   /**
    * 获得名称的内容。
    *
    * @return 名称
    */
   public String getName(){
      return _name;
   }

   /**
    * 获得注释信息的内容。
    *
    * @return 注释信息
    */
   public String getNote(){
      return _note.get();
   }

   /**
    * 获得服务的内容。
    *
    * @return 服务
    */
   public String getServer(){
      return _server;
   }

   @Override
   public String innerGet(String name){
      if(RString.isEmpty(name)){
         return null;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         return getName();
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         return getLabel();
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         return RBoolean.toString(getIsValid());
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         return getNote();
      }else if(PTY_SERVER.equalsIgnoreCase(name)){
         return getServer();
      }else if(PTY_DATA_VALUE.equalsIgnoreCase(name)){
         return getDataValue();
      }else if(PTY_DATA_HINT.equalsIgnoreCase(name)){
         return getDataHint();
      }
      return null;
   }

   @Override
   public void innerSet(String name,
                        String value){
      if(RString.isEmpty(name)){
         return;
      }else if(PTY_NAME.equalsIgnoreCase(name)){
         setName(value);
      }else if(PTY_LABEL.equalsIgnoreCase(name)){
         setLabel(value);
      }else if(PTY_IS_VALID.equalsIgnoreCase(name)){
         setIsValid(RBoolean.parse(value));
      }else if(PTY_NOTE.equalsIgnoreCase(name)){
         setNote(value);
      }else if(PTY_SERVER.equalsIgnoreCase(name)){
         setServer(value);
      }else if(PTY_DATA_VALUE.equalsIgnoreCase(name)){
         setDataValue(value);
      }else if(PTY_DATA_HINT.equalsIgnoreCase(name)){
         setDataHint(value);
      }
   }

   @Override
   public void loadConfig(FXmlNode config,
                          EXmlConfig type){
      super.loadConfig(config, type);
      if(EXmlConfig.Full == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            _label.unpack(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            _note.unpack(config.get(PTY_NOTE));
         }
         if(config.contains("server")){
            setServer(config.get(PTY_SERVER));
         }
         if(config.contains("data_value")){
            setDataValue(config.get(PTY_DATA_VALUE));
         }
      }else if(EXmlConfig.Simple == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("server")){
            setServer(config.get(PTY_SERVER));
         }
         if(config.contains("data_value")){
            setDataValue(config.get(PTY_DATA_VALUE));
         }
         if(config.contains("data_hint")){
            setDataHint(config.get(PTY_DATA_HINT));
         }
      }else if(EXmlConfig.Value == type){
         if(config.contains("name")){
            setName(config.get(PTY_NAME));
         }
         if(config.contains("label")){
            setLabel(config.get(PTY_LABEL));
         }
         if(config.contains("is_valid")){
            setIsValid(RBoolean.parse(config.get(PTY_IS_VALID)));
         }
         if(config.contains("note")){
            setNote(config.get(PTY_NOTE));
         }
         if(config.contains("server")){
            setServer(config.get(PTY_SERVER));
         }
         if(config.contains("data_value")){
            setDataValue(config.get(PTY_DATA_VALUE));
         }
         if(config.contains("data_hint")){
            setDataHint(config.get(PTY_DATA_HINT));
         }
      }else if(EXmlConfig.Default == type){
      }
   }

   @Override
   public String name(){
      return NAME;
   }

   @Override
   public void saveConfig(FXmlNode config,
                          EXmlConfig type){
      config.setName(NAME);
      super.saveConfig(config, type);
      if(EXmlConfig.Full == type){
         if(!RString.isEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         String label = _label.pack().toString();
         if(!RString.isEmpty(label)){
            config.set(PTY_LABEL, label);
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         String note = _note.pack().toString();
         if(!RString.isEmpty(note)){
            config.set(PTY_NOTE, note);
         }
         if(!RString.isEmpty(getServer())){
            config.set(PTY_SERVER, getServer());
         }
         if(!RString.isEmpty(getDataValue())){
            config.set(PTY_DATA_VALUE, getDataValue());
         }
      }else if(EXmlConfig.Simple == type){
         if(!RString.isEmpty(getName())){
            config.set(PTY_NAME, getName());
         }
         if(!RString.isEmpty(getLabel())){
            config.set(PTY_LABEL, getLabel());
         }
         if(RBoolean.parse(getIsValid())){
            config.set(PTY_IS_VALID, RBoolean.toString(getIsValid()));
         }
         if(!RString.isEmpty(getNote())){
            config.set(PTY_NOTE, getNote());
         }
         if(!RString.isEmpty(getServer())){
            config.set(PTY_SERVER, getServer());
         }
         if(!RString.isEmpty(getDataValue())){
            config.set(PTY_DATA_VALUE, getDataValue());
         }
         if(!RString.isEmpty(getDataHint())){
            config.set(PTY_DATA_HINT, getDataHint());
         }
      }else if(EXmlConfig.Value == type){
         String sName = getName();
         if(!RString.isEmpty(sName)){
            config.set(PTY_NAME, sName);
         }
         String sLabel = getLabel();
         if(!RString.isEmpty(sLabel)){
            config.set(PTY_LABEL, sLabel);
         }
         Boolean bIsValid = getIsValid();
         if(RBoolean.parse(bIsValid)){
            config.set(PTY_IS_VALID, RBoolean.toString(bIsValid));
         }
         String sNote = getNote();
         if(!RString.isEmpty(sNote)){
            config.set(PTY_NOTE, sNote);
         }
         String sServer = getServer();
         if(!RString.isEmpty(sServer)){
            config.set(PTY_SERVER, sServer);
         }
         String sDataValue = getDataValue();
         if(!RString.isEmpty(sDataValue)){
            config.set(PTY_DATA_VALUE, sDataValue);
         }
         String sDataHint = getDataHint();
         if(!RString.isEmpty(sDataHint)){
            config.set(PTY_DATA_HINT, sDataHint);
         }
      }else if(EXmlConfig.Default == type){
      }
   }

   /**
    * 设置数据提示的内容。
    *
    * @param value 数据提示
    */
   public void setDataHint(String value){
      _dataHint = value;
   }

   /**
    * 设置数据内容的内容。
    *
    * @param value 数据内容
    */
   public void setDataValue(String value){
      _dataValue = value;
   }

   /**
    * 设置有效性的内容。
    *
    * @param value 有效性
    */
   public void setIsValid(Boolean value){
      _isValid = value;
   }

   /**
    * 设置标签的内容。
    *
    * @param value 标签
    */
   public void setLabel(String value){
      _label.set(value);
   }

   /**
    * 设置名称的内容。
    *
    * @param value 名称
    */
   public void setName(String value){
      _name = value;
   }

   /**
    * 设置注释信息的内容。
    *
    * @param value 注释信息
    */
   public void setNote(String value){
      _note.set(value);
   }

   /**
    * 设置服务的内容。
    *
    * @param value 服务
    */
   public void setServer(String value){
      _server = value;
   }
}
