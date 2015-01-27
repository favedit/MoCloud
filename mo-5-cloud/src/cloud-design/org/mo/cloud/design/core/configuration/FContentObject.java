package org.mo.cloud.design.core.configuration;

import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FString;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.RXml;

//============================================================
// <T>内容对象。</T>
//============================================================
public class FContentObject
      extends FObject
{
   // 父内容对象
   protected FContentObject _parent;

   // 对象编号
   protected String _objectId;

   // 节点名称
   protected String _name = "Object";

   // 属性列表
   protected FAttributes _attributes;

   // 节点集合
   protected FContentObjects _nodes;

   //============================================================
   // <T>构造内容对象。</T>
   //============================================================
   public FContentObject(){
      _objectId = RUuid.makeUniqueIdLower();
   }

   //============================================================
   // <T>获得父内容对象。</T>
   //
   // @param 父内容对象
   //============================================================
   public FContentObject parent(){
      return _parent;
   }

   //============================================================
   // <T>设置父内容对象。</T>
   //
   // @param parent 父内容对象
   //============================================================
   public void setParent(FContentObject parent){
      _parent = parent;
   }

   //============================================================
   // <T>获得对象编号。</T>
   //
   // @param 对象编号
   //============================================================
   public String objectId(){
      return _objectId;
   }

   //============================================================
   // <T>判断是否为指定名称。</T>
   //
   // @param name 节点名称
   // @return 是否是
   //============================================================
   public boolean isName(String name){
      return RString.equalsIgnoreCase(_name, name);
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
   // <T>设置节点名称。</T>
   //
   // @param name 节点名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>是否含有属性。</T>
   //
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean hasAttribute(){
      if(_attributes != null){
         return !_attributes.isEmpty();
      }
      return false;
   }

   //============================================================
   // <T>是否含有属性。</T>
   //
   // @param name 属性名称
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean hasAttribute(String name){
      if(_attributes != null){
         return _attributes.contains(name);
      }
      return false;
   }

   //============================================================
   // <T>获得属性列表。</T>
   //
   // @return 属性列表
   //============================================================
   public FAttributes attributes(){
      if(_attributes == null){
         _attributes = new FAttributes();
      }
      return _attributes;
   }

   //============================================================
   // <T>是否含有子节点。</T>
   //
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean hasNode(){
      return (_nodes != null) ? !_nodes.isEmpty() : false;
   }

   //============================================================
   // <T>获得节点总数。</T>
   //
   // @return 节点总数
   //============================================================
   public int nodeCount(){
      return (_nodes != null) ? _nodes.count() : 0;
   }

   //============================================================
   // <T>获得节点列表。</T>
   //
   // @return 节点集合
   //============================================================
   public FContentObjects nodes(){
      if(_nodes == null){
         _nodes = new FContentObjects(this);
      }
      return _nodes;
   }

   //============================================================
   // <T>获得指定属性名称的字符串属性内容。</T>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public String get(String name){
      if(hasAttribute()){
         return attributes().get(name);
      }
      return null;
   }

   //============================================================
   // <T>获得指定属性名称的字符串属性内容。</T>
   //
   // @param name 属性名称
   // @param value 属性内容
   // @return 属性内容
   //============================================================
   public String get(String name,
                     String defaultValue){
      if(hasAttribute()){
         return attributes().get(name, defaultValue);
      }
      return defaultValue;
   }

   //============================================================
   // <T>获得指定属性名称的字符串属性内容。</T>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public String getNvl(String name){
      return attributes().find(name);
   }

   //============================================================
   // <p>获得指定属性名称的布尔属性内容。</p>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public boolean getBoolean(String name){
      String value = get(name);
      return RBoolean.parse(value);
   }

   //============================================================
   // <p>获得指定属性名称的布尔属性内容。</p>
   //
   // @param name 属性名称
   // @param defaultValue 默认内容
   // @return 属性内容
   //============================================================
   public boolean getBoolean(String name,
                             boolean defaultValue){
      if(hasAttribute(name)){
         return getBoolean(name);
      }
      return defaultValue;
   }

   //============================================================
   // <p>获得指定属性名称的整数属性内容。</p>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public int getInt(String name){
      String value = get(name);
      return RInteger.parse(value);
   }

   //============================================================
   // <p>获得指定属性名称的整数属性内容。</p>
   //
   // @param name 属性名称
   // @param defaultValue 默认内容
   // @return 属性内容
   //============================================================
   public int getInt(String name,
                     int defaultValue){
      if(hasAttribute(name)){
         return getInt(name);
      }
      return defaultValue;
   }

   //============================================================
   // <p>获得指定属性名称的长整数属性内容。</p>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public long getLong(String name){
      String value = get(name);
      return RLong.parse(value);
   }

   //============================================================
   // <p>获得指定属性名称的长整数属性内容。</p>
   //
   // @param name 属性名称
   // @param defaultValue 默认内容
   // @return 属性内容
   //============================================================
   public long getLong(String name,
                       int defaultValue){
      if(hasAttribute(name)){
         return getLong(name);
      }
      return defaultValue;
   }

   //============================================================
   // <p>获得指定属性名称的浮点数属性内容。</p>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public float getFloat(String name){
      String value = get(name);
      return RFloat.parse(value);
   }

   //============================================================
   // <p>获得指定属性名称的浮点数属性内容。</p>
   //
   // @param name 属性名称
   // @param defaultValue 默认内容
   // @return 属性内容
   //============================================================
   public float getFloat(String name,
                         float defaultValue){
      if(hasAttribute(name)){
         return getFloat(name);
      }
      return defaultValue;
   }

   //============================================================
   // <p>获得指定属性名称的双精度浮点数属性内容。</p>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   public double getDouble(String name){
      String value = get(name);
      return RDouble.parse(value);
   }

   //============================================================
   // <p>获得指定属性名称的双精度浮点数属性内容。</p>
   //
   // @param name 属性名称
   // @param defaultValue 默认内容
   // @return 属性内容
   //============================================================
   public double getDouble(String name,
                           double defaultValue){
      if(hasAttribute(name)){
         return getDouble(name);
      }
      return defaultValue;
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   boolean value){
      attributes().set(name, RBoolean.toString(value));
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      boolean value){
      if(value){
         attributes().set(name, RBoolean.toString(value));
      }
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   int value){
      attributes().set(name, Integer.toString(value));
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      int value){
      if(value != 0){
         attributes().set(name, Integer.toString(value));
      }
   }

   //============================================================
   // <p>设置属性名称和长整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   long value){
      attributes().set(name, Long.toString(value));
   }

   //============================================================
   // <p>设置属性名称和长整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      long value){
      if(value != 0){
         attributes().set(name, Long.toString(value));
      }
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   float value){
      attributes().set(name, Float.toString(value));
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      float value){
      if(value != 0){
         attributes().set(name, Float.toString(value));
      }
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   double value){
      attributes().set(name, Double.toString(value));
   }

   //============================================================
   // <p>设置属性名称和整数属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      double value){
      if(value != 0){
         attributes().set(name, Double.toString(value));
      }
   }

   //============================================================
   // <p>设置属性名称和字符串属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   String value){
      attributes().set(name, RString.nvl(value));
   }

   //============================================================
   // <p>设置属性名称和字符串属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      String value){
      if(!RString.isEmpty(value)){
         attributes().set(name, value);
      }
   }

   //============================================================
   // <T>查询指定编号的内容节点。</T>
   //
   // @param objectId 对象编号
   // @return 内容节点
   //============================================================
   public FContentObject find(String objectId){
      return (_nodes != null) ? _nodes.find(objectId) : null;
   }

   //============================================================
   // <T>递归查询指定编号的内容节点。</T>
   //
   // @param objectId 对象编号
   // @return 内容节点
   //============================================================
   public FContentObject search(String objectId){
      if(_objectId.equals(objectId)){
         return this;
      }
      if(_nodes != null){
         int count = _nodes.count();
         for(int n = 0; n < count; n++){
            FContentObject xobject = _nodes.get(n);
            FContentObject xfind = xobject.search(objectId);
            if(xfind != null){
               return xfind;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>查找一个指定属性名称和属性内容的内容节点。</T>
   //
   // @param attributeName 属性名称
   // @param attributeValue 属性内容
   // @return 内容节点
   //============================================================
   public FContentObject findObject(String attributeName,
                                    String attributeValue){
      if(hasNode()){
         return _nodes.findObject(attributeName, attributeValue);
      }
      return null;
   }

   //============================================================
   // <T>获得属性列表。</T>
   //
   // @return 属性列表
   //============================================================
   public void assignAttributes(IAttributes attributes){
      for(IStringPair pair : attributes){
         String name = pair.name();
         if(name.startsWith("_")){
            continue;
         }
         set(name, pair.value());
      }
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @return 子节点
   //============================================================
   public FContentObject createNode(){
      FContentObject xobject = new FContentObject();
      push(xobject);
      return xobject;
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @return 子节点
   //============================================================
   public FContentObject createNode(String name){
      FContentObject xobject = new FContentObject();
      xobject.setName(name);
      push(xobject);
      return xobject;
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param xconfig 节点名称
   // @return 子节点
   //============================================================
   public FContentObject createNode(FXmlNode xconfig){
      FContentObject xobject = new FContentObject();
      xobject.setName(xconfig.name());
      xobject.assignAttributes(xconfig.attributes());
      push(xobject);
      return xobject;
   }

   //============================================================
   // <T>推入一个子节点。</T>
   //
   // @param node 子节点
   //============================================================
   public void push(FContentObject node){
      nodes().push(node);
   }

   //============================================================
   // <T>建立XML字符串。</T>
   //
   // @param xml XML字符串
   // @param level 级别
   // @param optionDeep 深度设置
   // @param optionText 文本设置
   //============================================================
   protected void buildXml(FString xml,
                           int level,
                           boolean optionDeep){
      if(optionDeep){
         xml.appendRepeat("   ", level);
      }
      // 建立属性列表
      xml.append('<');
      xml.append(_name);
      if(null != _attributes){
         int count = _attributes.count();
         for(int n = 0; n < count; n++){
            xml.append(' ');
            xml.append(_attributes.name(n));
            xml.append('=');
            xml.append('"');
            xml.append(RXml.formatText(_attributes.value(n)));
            xml.append('"');
         }
      }
      // 建立文本和节点对象
      boolean hasNode = (_nodes != null) ? !_nodes.isEmpty() : false;
      if(optionDeep && hasNode){
         xml.append(">");
         if(hasNode){
            xml.append("\n");
            int count = _nodes.count();
            for(int n = 0; n < count; n++){
               _nodes.get(n).buildXml(xml, level + 1, optionDeep);
               xml.append("\n");
            }
            xml.appendRepeat("   ", level);
         }
         xml.append("</", _name, ">");
      }else{
         xml.append("/>");
      }
   }

   //============================================================
   // <T>获得XML字符串。</T>
   //
   // @return XML字符串
   //============================================================
   public FString xml(){
      FString xml = new FString();
      buildXml(xml, 0, true);
      return xml;
   }

   //============================================================
   // <T>获得节点。</T>
   //
   // @return 节点
   //============================================================
   public FXmlNode makeConfig(){
      FXmlNode xconfig = new FXmlNode();
      saveConfig(xconfig);
      return xconfig;
   }

   //============================================================
   // <T>获得简单字符串。</T>
   //
   // @return 简单字符串
   //============================================================
   public String simpleXml(){
      FString xml = new FString();
      buildXml(xml, 0, false);
      return xml.toString();
   }

   //============================================================
   // <T>获得简单节点。</T>
   //
   // @return 简单节点
   //============================================================
   public FXmlNode simpleNode(){
      FXmlNode xnode = new FXmlNode(_name);
      if(hasAttribute()){
         xnode.attributes().assign(_attributes);
      }
      return xnode;
   }

   //============================================================
   // <T>保存配置节点。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      saveConfig(xconfig, true);
   }

   //============================================================
   // <T>保存配置节点。</T>
   //
   // @param xconfig 配置节点
   // @param deep 支持深度 
   //============================================================
   public void saveConfig(FXmlNode xconfig,
                          boolean deep){
      // 设置属性
      xconfig.setName(_name);
      // 设置属性集合
      if(hasAttribute()){
         xconfig.attributes().assign(_attributes);
      }
      // 设置节点集合
      if(deep && hasNode()){
         for(FContentObject xobject : _nodes){
            FXmlNode xnode = xconfig.createNode();
            xobject.saveConfig(xnode, deep);
         }
      }
   }

   //============================================================
   // <T>加载配置节点。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 设置属性
      setName(xconfig.name());
      // 设置属性集合
      if(xconfig.hasAttribute()){
         attributes().assign(xconfig.attributes());
      }
      // 设置节点集合
      if(xconfig.hasNode()){
         for(FXmlNode xnode : xconfig.nodes()){
            FContentObject xobject = new FContentObject();
            xobject.loadConfig(xnode);
            push(xobject);
         }
      }
   }

   //============================================================
   // <T>根据配置信息排序。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public boolean sortByConfig(FXmlNode xconfig){
      // 检查参数
      if(!hasNode()){
         return false;
      }
      if(xconfig == null){
         return false;
      }
      // 存储要排序的对象
      FContentObjects xstores = new FContentObjects();
      xstores.append(_nodes);
      // 根据对象名称进行排序
      FContentObjects xsort = new FContentObjects();
      for(FXmlNode node : xconfig.nodes()){
         String name = node.get("name");
         FContentObject xstore = _nodes.find(name);
         if(xstore == null){
            throw new FFatalError("Can't find xobject by uuid (uuid={1})", name);
         }
         xsort.push(xstore);
      }
      // 存储对象
      _nodes.assign(xsort);
      return true;
   }
}
