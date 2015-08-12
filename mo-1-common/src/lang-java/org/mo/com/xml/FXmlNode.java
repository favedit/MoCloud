package org.mo.com.xml;

import java.util.Iterator;
import org.mo.com.lang.EDumpLevel;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjectId;
import org.mo.com.lang.FString;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.IComparable;
import org.mo.com.lang.ICopyable;
import org.mo.com.lang.INameValue;
import org.mo.com.lang.IObjects;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RDump;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>XML节点。</T>
//
// @history 051014 MAOCY 创建
//============================================================
public class FXmlNode
      extends FObjectId
      implements
         IObjects<FXmlNode>,
         IComparable<FXmlNode>,
         INameValue<String, String>,
         ICopyable,
         Iterable<FXmlNode>
{
   // 文档
   protected FXmlDocument _document;

   // 父节点
   protected FXmlNode _parent;

   // 节点类型
   protected EXmlNode _typeCd = EXmlNode.Node;

   // 是否集合
   protected boolean _isCollection;

   // 节点名称
   protected String _name;

   // 节点内容
   protected String _text;

   // 属性列表
   protected FAttributes _attributes;

   // 子节点列表
   protected FXmlNodes _nodes;

   //============================================================
   // <T>构造XML节点。</T>
   //============================================================
   public FXmlNode(){
      _name = RXml.DEFAULT_NODE_NAME;
   }

   //============================================================
   // <T>构造XML节点。</T>
   //
   // @param name 节点名称
   //============================================================
   public FXmlNode(String name){
      _name = name;
   }

   //============================================================
   // <T>构造XML节点。</T>
   //
   // @param name 节点名称
   // @param text 节点内容
   //============================================================
   public FXmlNode(String name,
                   String text){
      _name = name;
      _text = text;
   }

   //============================================================
   // <T>构造XML节点。</T>
   //
   // @param name 节点名称
   // @param text 节点内容
   // @param attributes 属性集合
   //============================================================
   public FXmlNode(String name,
                   String text,
                   String... attributes){
      _name = name;
      _text = text;
      if(null != attributes){
         int ml = attributes.length - 1;
         for(int n = 0; n < ml; n += 2){
            this.set(attributes[n], attributes[n + 1]);
         }
      }
   }

   //============================================================
   // <T>获得文档。</T>
   //
   // @return 文档
   //============================================================
   public FXmlDocument document(){
      return _document;
   }

   //============================================================
   // <T>获得节点类型。</T>
   //
   // @return 节点类型
   //============================================================
   public EXmlNode typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>获得节点类型。</T>
   //
   // @return 节点类型
   //============================================================
   public FXmlNode parent(){
      return _parent;
   }

   //============================================================
   // <T>判断是否为集合。</T>
   //
   // @return 是否为集合
   //============================================================
   public boolean isCollection(){
      return _isCollection;
   }

   //============================================================
   // <T>设置是否为集合。</T>
   //
   // @param isCollection 是否为集合
   //============================================================
   public void setIsCollection(boolean isCollection){
      _isCollection = isCollection;
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
   // <T>获得节点文本。</T>
   //
   // @return 节点文本
   //============================================================
   public String text(){
      return _text;
   }

   //============================================================
   // <T>设置节点文本。</T>
   //
   // @param text 节点文本
   //============================================================
   public void setText(int value){
      _text = Integer.toString(value);
   }

   //============================================================
   // <T>设置节点文本。</T>
   //
   // @param text 节点文本
   //============================================================
   public void setText(long value){
      _text = Long.toString(value);
   }

   //============================================================
   // <T>设置节点文本。</T>
   //
   // @param text 节点文本
   //============================================================
   public void setText(String text){
      _text = text;
   }

   //============================================================
   // <T>是否含有属性。</T>
   //
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean equals(String name){
      return _name.equalsIgnoreCase(name);
   }

   //============================================================
   // <T>是否含有指定属性。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean equals(String name,
                         String... attributes){
      // 比较名称
      if((name != null) && !_name.equalsIgnoreCase(name)){
         return false;
      }
      // 比较属性为空的状况
      if(null == attributes){
         return true;
      }
      if(attributes.length == 0){
         return true;
      }
      // 比较属性
      int loop = attributes.length - 1;
      for(int n = 0; n < loop; n += 2){
         String value = attributes[n + 1];
         if(null == value){
            return false;
         }else{
            String attributeName = attributes[n];
            String attributeValue = _attributes.find(attributeName);
            if(!value.equalsIgnoreCase(attributeValue)){
               return false;
            }
         }
      }
      return true;
   }

   //============================================================
   // <T>是否含有属性。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean equalsAttribute(String attrName,
                                  String attrValue){
      if(!hasAttribute()){
         return false;
      }
      String value = _attributes.get(attrName);
      if(!RString.equals(value, attrValue)){
         return false;
      }
      return true;
   }

   //============================================================
   // <T>是否含有属性。</T>
   //
   // @param name 名称
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return TRUE：是<br>FALSE：否
   //============================================================
   public boolean equalsAttribute(String name,
                                  String attrName,
                                  String attrValue){
      // 比较名称
      if(!_name.equals(name)){
         return false;
      }
      // 比较属性
      if(!hasAttribute()){
         return false;
      }
      String value = _attributes.get(attrName);
      if(!RString.equals(value, attrValue)){
         return false;
      }
      return true;
   }

   //============================================================
   // <T>是否含有指定名称。</T>
   //
   // @param name 指定名称
   // @return 是否含有
   //============================================================
   public boolean contains(String name){
      return (null != _attributes) ? _attributes.contains(name) : false;
   }

   //============================================================
   // <T>根据参数进行节点的比较。</T>
   //
   // @param node 节点
   // @param params 参数集合
   // @return 比较结果
   //============================================================
   @Override
   public int compare(FXmlNode node,
                      Object... params){
      if(params != null){
         int count = params.length;
         for(int n = 0; n < count; n++){
            String name = (String)params[n];
            String sourceValue = _attributes.find(name);
            String targetValue = node._attributes.find(name);
            int result = RString.compare(sourceValue, targetValue, false);
            if(result != 0){
               return result;
            }
         }
      }
      return 0;
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
   // <T>在当前列表下查找是否存在一个指定信息的节点。</T>
   //
   // @param name 节点名称
   // @return TRUE：存在<br>FALSE：不存在
   //============================================================
   public boolean hasNode(String name){
      return (findNode(name) != null);
   }

   //============================================================
   // <T>在当前列表下查找是否存在一个指定信息的节点。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return TRUE：存在<br>FALSE：不存在
   //============================================================
   public boolean hasNode(String attrName,
                          String attrValue){
      return (findNode(attrName, attrValue) != null);
   }

   //============================================================
   // <T>在当前列表下查找是否存在一个指定信息的节点。</T>
   //
   // @param name 节点名称
   // @param attrValue 属性内容
   // @return TRUE：存在<br>FALSE：不存在
   //============================================================
   public boolean hasNode(String name,
                          String attrName,
                          String attrValue){
      return (findNode(name, attrName, attrValue) != null);
   }

   //============================================================
   // <T>在当前列表下查找是否存在一个指定信息的节点。</T>
   //
   // @param name 节点名称
   // @param attrName1 属性名称1
   // @param attrValue1 属性内容2
   // @param attrName 属性名称2
   // @param attrValue2 属性内容2
   // @return TRUE：存在<br>FALSE：不存在
   //============================================================
   public boolean hasNode(String name,
                          String attrName1,
                          String attrValue1,
                          String attrName,
                          String attrValue2){
      return (findNode(name, attrName1, attrName1, attrName, attrName) != null);
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
   // <T>查找指定路径的节点。</T>
   // <P>节点名称中用“.”分开，每个可以代表一个单独节点的名称。</P>
   //
   // @param path 节点路径
   // @return 节点
   //============================================================
   public FXmlNode findPath(String path){
      FXmlNode node = this;
      if(!RString.isEmpty(path)){
         // 去掉开始符号
         if(path.startsWith("\\")){
            path = path.substring(1);
         }
         // 分割路径进行查找
         String[] paths = path.split("\\.");
         int count = paths.length;
         for(int i = 0; i < count; i++){
            if(!RString.isEmpty(paths[i])){
               node = node.findNode(paths[i]);
               if(null == node){
                  break;
               }
            }
         }
      }
      return node;
   }

   //============================================================
   // <T>查找指定路径的节点。</T>
   // <P>节点名称中用“.”分开，每个可以代表一个单独节点的名称。</P>
   //
   // @param path 节点路径
   // @param split 路径分隔
   // @return 节点
   //============================================================
   public FXmlNode findPath(String path,
                            char split){
      FXmlNode node = this;
      if(!RString.isEmpty(path)){
         // 去掉开始符号
         if(0 == path.indexOf(split)){
            path = path.substring(1);
         }
         // 分割路径进行查找
         String[] paths = RString.split(path, split);
         int count = paths.length;
         for(int i = 0; i < count; i++){
            if(!RString.isEmpty(paths[i])){
               node = node.findNode(paths[i]);
               if(null == node){
                  break;
               }
            }
         }
      }
      return node;
   }

   //============================================================
   // <T>获得全路径。</T>
   //
   // @params attribute 属性
   // @params split 分割符
   // @return 全路径
   //============================================================
   public String fullPath(String attribute,
                          char split){
      FXmlNode loop = this;
      if(null == loop._parent){
         return Character.toString(split);
      }
      String path = "";
      while(null != loop._parent){
         path = split + loop.get(attribute) + path;
         loop = loop._parent;
      }
      return path;
   }

   //============================================================
   // <T>在当前节点下查找一个指定信息的节点。</T>
   //
   // @param name 节点名称
   // @return 节点
   //============================================================
   public FXmlNode findNode(String name){
      return (_nodes != null) ? _nodes.findNode(name) : null;
   }

   //============================================================
   // <T>在当前节点下查找一个指定信息的节点。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode findNode(String attrName,
                            String attrValue){
      return hasNode() ? nodes().findNode(null, attrName, attrValue) : null;
   }

   //============================================================
   // <T>在当前节点下查找一个指定信息的节点。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 节点
   //============================================================
   public FXmlNode findNode(String name,
                            String... attributes){
      return hasNode() ? nodes().findNode(name, attributes) : null;
   }

   //============================================================
   // <T>在当前节点下查找最后一个指定信息的节点。</T>
   //
   // @param name 节点名称
   // @return 节点
   //============================================================
   public FXmlNode findLastNode(String name){
      return (_nodes != null) ? _nodes.findLastNode(name) : null;
   }

   //============================================================
   // <T>在当前节点下查找最后一个指定信息的节点。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode findLastNode(String attrName,
                                String attrValue){
      return hasNode() ? nodes().findLastNode(null, attrName, attrValue) : null;
   }

   //============================================================
   // <T>在当前节点下查找最后一个指定信息的节点。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 节点
   //============================================================
   public FXmlNode findLastNode(String name,
                                String... attributes){
      return hasNode() ? nodes().findLastNode(name, attributes) : null;
   }

   //============================================================
   // <T>在当前节点下的所有节点中查找一个指定信息的节点。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode findAllNode(String attrName,
                               String attrValue){
      if(hasAttribute()){
         if(RString.equalsIgnoreCase(get(attrName), attrValue)){
            return this;
         }
      }
      if(hasNode()){
         for(FXmlNode node : _nodes){
            if(RString.equalsIgnoreCase(node.get(attrName), attrValue)){
               return node;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>递归查询当前所有子节点满足条件的节点。</T>
   //
   // @param name 名称
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode search(){
      FXmlNode find = this;
      while(find.hasNode()){
         find = find.nodes().first();
      }
      return find;
   }

   //============================================================
   // <T>递归查询当前所有子节点满足条件的节点。</T>
   //
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode search(String attrName,
                          String attrValue){
      if(equalsAttribute(attrName, attrValue)){
         return this;
      }
      if(_nodes != null){
         int count = _nodes.count();
         for(int n = 0; n < count; n++){
            FXmlNode node = _nodes.get(n);
            FXmlNode find = node.search(attrName, attrValue);
            if(find != null){
               return find;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>递归查询当前所有子节点满足条件的节点。</T>
   //
   // @param name 名称
   // @param attrName 属性名称
   // @param attrValue 属性内容
   // @return 节点
   //============================================================
   public FXmlNode search(String name,
                          String attrName,
                          String attrValue){
      if(equalsAttribute(name, attrName, attrValue)){
         return this;
      }
      if(_nodes != null){
         int count = _nodes.count();
         for(int n = 0; n < count; n++){
            FXmlNode node = _nodes.get(n);
            FXmlNode find = node.search(attrName, attrValue);
            if(find != null){
               return find;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>增加符合指定信息的所有节点到节点列表中。</T>
   //
   // @param nodes 节点集合
   // @param node 节点集合
   // @param name 节点集合
   // @return 节点集合
   //============================================================
   protected FXmlNodes innerAllNodes(FXmlNodes nodes,
                                     FXmlNode node){
      if(node != null){
         for(FXmlNode itemNode : node.nodes()){
            nodes.push(itemNode);
            if(itemNode.hasNode()){
               innerAllNodes(nodes, itemNode);
            }
         }
      }
      return nodes;
   }

   //============================================================
   // <T>增加符合指定信息的所有节点到节点列表中。</T>
   //
   // @param nodes 节点集合
   // @param node 节点集合
   // @param name 节点集合
   // @return 节点集合
   //============================================================
   protected FXmlNodes innerAllNodes(FXmlNodes nodes,
                                     FXmlNode node,
                                     String name){
      if(node != null){
         for(FXmlNode itemNode : node.nodes()){
            if(itemNode.equals(name)){
               nodes.push(itemNode);
            }
            if(itemNode.hasNode()){
               innerAllNodes(nodes, itemNode, name);
            }
         }
      }
      return nodes;
   }

   //============================================================
   // <T>增加符合指定信息的所有节点到节点列表中。</T>
   //
   // @param nodes 节点集合
   // @param node 节点集合
   // @param name 节点集合
   // @param attributes 节点集合
   // @return 节点集合
   //============================================================
   protected FXmlNodes innerAllNodes(FXmlNodes nodes,
                                     FXmlNode node,
                                     String name,
                                     String... attributes){
      if(node != null){
         for(FXmlNode itemNode : node.nodes()){
            if(itemNode.equals(name, attributes)){
               nodes.push(itemNode);
            }
            if(itemNode.hasNode()){
               innerAllNodes(nodes, itemNode, name, attributes);
            }
         }
      }
      return nodes;
   }

   //============================================================
   // <T>获得当前节点下所有符合指定信息的节点的节点列表。</T>
   // <P>搜索当前节点和当前节点下所有子节点。</P>
   //
   // @return 节点集合
   //============================================================
   public FXmlNodes allNodes(){
      FXmlNodes nodes = new FXmlNodes();
      if(hasNode()){
         innerAllNodes(nodes, this);
      }
      return nodes;
   }

   //============================================================
   // <T>获得当前节点下所有符合指定信息的节点的节点列表。</T>
   // <P>搜索当前节点和当前节点下所有子节点。</P>
   //
   // @param name 节点名称
   // @return 节点集合
   //============================================================
   public FXmlNodes allNodes(String name){
      FXmlNodes nodes = new FXmlNodes();
      if(hasNode()){
         innerAllNodes(nodes, this, name);
      }
      return nodes;
   }

   //============================================================
   // <T>获得当前节点下所有符合指定信息的节点的节点列表。</T>
   // <P>搜索当前节点和当前节点下所有子节点。</P>
   //
   // @param name 节点名称
   // @param attributes 属性集合
   // @return 节点集合
   //============================================================
   public FXmlNodes allNodes(String name,
                             String... attributes){
      FXmlNodes nodes = new FXmlNodes();
      if(hasNode()){
         innerAllNodes(nodes, this, name, attributes);
      }
      return nodes;
   }

   //============================================================
   // <T>查找指定路径的节点。</T>
   // <P>节点名称中用“.”分开，每个可以代表一个单独节点的名称。</P>
   //
   // @param path 节点路径
   // @param split 路径分隔
   // @param name 属性名称
   // @return 节点
   //============================================================
   public FXmlNode findPath(String path,
                            char split,
                            String name){
      FXmlNode node = this;
      if(!RString.isEmpty(path)){
         // 去掉开始符号
         if(0 == path.indexOf(split)){
            path = path.substring(1);
         }
         // 分割路径进行查找
         String[] paths = RString.split(path, split);
         int count = paths.length;
         for(int n = 0; n < count; n++){
            if(!RString.isEmpty(paths[n])){
               node = node.findNode(name, paths[n]);
               if(node == null){
                  break;
               }
            }
         }
      }
      return node;
   }

   //============================================================
   // <T>获得迭代器。</T>
   //
   // @return 迭代器
   //============================================================
   @Override
   public Iterator<FXmlNode> iterator(){
      return nodes().iterator();
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @return 子节点
   //============================================================
   public FXmlNode createNode(){
      return nodes().create(RXml.DEFAULT_NODE_NAME);
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @return 子节点
   //============================================================
   public FXmlNode createNode(String name){
      if(RString.isEmpty(name)){
         throw new NullPointerException("name");
      }
      return nodes().create(name);
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @param text 节点文本
   // @return 子节点
   //============================================================
   public FXmlNode createNode(String name,
                              int text){
      return createNode(name, Integer.toString(text));
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @param text 节点文本
   // @return 子节点
   //============================================================
   public FXmlNode createNode(String name,
                              String text){
      if(RString.isEmpty(name)){
         throw new NullPointerException("name");
      }
      FXmlNode node = new FXmlNode(name, text);
      nodes().push(node);
      return node;
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @param text 节点文本
   // @param attributes 属性集合
   // @return 子节点
   //============================================================
   public FXmlNode createNode(String name,
                              String text,
                              String... attributes){
      if(RString.isEmpty(name)){
         throw new NullPointerException("name");
      }
      FXmlNode node = new FXmlNode(name, text, attributes);
      nodes().push(node);
      return node;
   }

   //============================================================
   // <T>创建一个子节点。</T>
   //
   // @param name 节点名称
   // @param attributes 属性集合
   // @return 子节点
   //============================================================
   public FXmlNode createNode(String name,
                              IAttributes attributes){
      if(RString.isEmpty(name)){
         throw new NullPointerException("name");
      }
      FXmlNode xnode = nodes().create(name);
      xnode.attributes().assign(attributes);
      return xnode;
   }

   //============================================================
   // <T>复制指定节点内容到当前节点内。</T>
   //
   // @param node 指定节点
   //============================================================
   public void assign(FXmlNode node){
      _name = node._name;
      _text = node._text;
      if(node.hasAttribute()){
         attributes().assign(node._attributes);
      }
      if(node.hasNode()){
         nodes().assign(node._nodes);
      }
   }

   //============================================================
   // <T>复制指定节点内容到当前节点内。</T>
   //
   // @param node 指定节点
   // @param deep 深度
   //============================================================
   public void assign(FXmlNode node,
                      boolean deep){
      attributes().assign(node.attributes());
      if(deep){
         nodes().clear();
         //nodes().assign((FAbstractNamedList)node.nodes().copy());
      }else{
         nodes().clear();
         nodes().assign(node.nodes());
      }
   }

   //============================================================
   // <T>获得指定属性名称的字符串属性内容。</T>
   //
   // @param name 属性名称
   // @return 属性内容
   //============================================================
   @Override
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
   @Override
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
         String value = get(name);
         return RInteger.parse(value, defaultValue);
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
         String value = get(name);
         return RLong.parse(value, defaultValue);
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
         String value = get(name);
         return RFloat.parse(value, defaultValue);
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
         String value = get(name);
         return RDouble.parse(value, defaultValue);
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
   @Override
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
   // <p>设置属性名称和字符串属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void set(String name,
                   Object value){
      String valueString = RString.toString(value);
      attributes().set(name, valueString);
   }

   //============================================================
   // <p>设置属性名称和字符串属性内容。</p>
   //
   // @param name 属性名称
   // @param value 属性内容
   //============================================================
   public void setNvl(String name,
                      Object value){
      String valueString = RString.toString(value);
      if(!RString.isEmpty(valueString)){
         attributes().set(name, valueString);
      }
   }

   //============================================================
   // <T>根据索引位置，获得节点。</T>
   //
   // @return 节点
   //============================================================
   public FXmlNode node(int index){
      return nodes().get(index);
   }

   //============================================================
   // <T>根据子节点名称，获得节点。</T>
   //
   // @param name 子节点名称
   // @return 子节点
   //============================================================
   public FXmlNode node(String name){
      return nodes().findNode(name);
   }

   //============================================================
   // <T>获得节点列表。</T>
   //
   // @return 节点集合
   //============================================================
   public FXmlNodes nodes(){
      if(_nodes == null){
         _nodes = new FXmlNodes(this);
      }
      return _nodes;
   }

   //============================================================
   // <T>在当前列表下查找一个指定信息的节点列表。</T>
   //
   // @param name 节点名称
   // @return 节点集合
   //============================================================
   public FXmlNodes nodes(String name){
      FXmlNodes nodes = new FXmlNodes();
      if(_nodes != null){
         int n = -1;
         int count = _nodes.count();
         while(++n < count){
            if(_nodes.get(n).equals(name)){
               nodes.push(_nodes.get(n));
            }
         }
      }
      return nodes;
   }

   //============================================================
   // <T>在当前列表下查找一个指定信息的节点列表。</T>
   //
   // @param name 节点名称
   // @param attributes 属性集合
   // @return 节点集合
   //============================================================
   public FXmlNodes nodes(String name,
                          String... attributes){
      FXmlNodes nodes = new FXmlNodes();
      if(hasNode()){
         for(FXmlNode node : nodes()){
            if(node.equals(name, attributes)){
               nodes.push(node);
            }
         }
      }
      return nodes;
   }

   //============================================================
   // <T>获得节点列表中指定节点的文本。</T>
   //
   // @param name 节点名称
   // @return 节点文本
   //============================================================
   public String nodeText(String name){
      String text = null;
      if(hasNode()){
         FXmlNode node = _nodes.findNode(name);
         if(node != null){
            text = node.text();
         }
      }
      return text;
   }

   //============================================================
   // <T>获得节点列表中指定节点的指定属性内容。</T>
   //
   // @param name 节点名称
   // @param attributes 属性集合
   // @return 属性内容
   //============================================================
   public String nodeText(String name,
                          String... attributes){
      String text = null;
      if(hasNode()){
         FXmlNode node = _nodes.findNode(name, attributes);
         if(node != null){
            text = node.text();
         }
      }
      return text;
   }

   //============================================================
   // <T>获得节点列表中指定节点的整数。</T>
   //
   // @param name 节点名称
   // @return 整数
   //============================================================
   public int nodeTextAsInt(String name){
      int result = 0;
      String text = nodeText(name);
      if(text != null){
         result = RInteger.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的整数。</T>
   //
   // @param name 节点名称
   // @param defaultValue 默认内容
   // @return 整数
   //============================================================
   public int nodeTextAsInt(String name,
                            int defaultValue){
      int result = defaultValue;
      String text = nodeText(name);
      if(text != null){
         result = RInteger.parse(text, defaultValue);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的长整数。</T>
   //
   // @param name 节点名称
   // @return 长整数
   //============================================================
   public long nodeTextAsLong(String name){
      long result = 0;
      String text = nodeText(name);
      if(text != null){
         result = RLong.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的长整数。</T>
   //
   // @param name 节点名称
   // @param defaultValue 默认内容
   // @return 长整数
   //============================================================
   public long nodeTextAsLong(String name,
                              long defaultValue){
      long result = defaultValue;
      String text = nodeText(name);
      if(text != null){
         result = RLong.parse(text, defaultValue);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的浮点数整数。</T>
   //
   // @param name 节点名称
   // @return 浮点数整数
   //============================================================
   public float nodeTextAsFloat(String name){
      float result = 0;
      String text = nodeText(name);
      if(text != null){
         result = RFloat.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的浮点数整数。</T>
   //
   // @param name 节点名称
   // @param defaultValue 默认内容
   // @return 浮点数整数
   //============================================================
   public float nodeTextAsFloat(String name,
                                float defaultValue){
      float result = defaultValue;
      String text = nodeText(name);
      if(text != null){
         result = RFloat.parse(text, defaultValue);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的双精度浮点数整数。</T>
   //
   // @param name 节点名称
   // @return 双精度浮点数整数
   //============================================================
   public double nodeTextAsDouble(String name){
      double result = 0;
      String text = nodeText(name);
      if(text != null){
         result = RDouble.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>获得节点列表中指定节点的双精度浮点数整数。</T>
   //
   // @param name 节点名称
   // @param defaultValue 默认内容
   // @return 双精度浮点数整数
   //============================================================
   public double nodeTextAsDouble(String name,
                                  double defaultValue){
      double result = defaultValue;
      String text = nodeText(name);
      if(text != null){
         result = RDouble.parse(text, defaultValue);
      }
      return result;
   }

   //============================================================
   // <T>推入一个子节点。</T>
   //
   // @param node 子节点
   //============================================================
   public void push(FXmlNode node){
      nodes().push(node);
   }

   //============================================================
   // <T>推入一个子节点集合。</T>
   //
   // @param nodes 子节点集合
   //============================================================
   public void pushNodes(FXmlNodes nodes){
      nodes().append(nodes);
   }

   //============================================================
   // <T>根据属性名称和属性内容，查找节点，如果不存在则创建一个新的节点。</T>
   //
   // @param name 节点名称
   // @return 节点
   //============================================================
   public FXmlNode syncNode(String name){
      FXmlNode node = findNode(name);
      if(null == node){
         node = createNode(name);
      }
      return node;
   }

   //============================================================
   // <T>根据属性名称和属性内容，查找节点，如果不存在则创建一个新的节点。</T>
   //
   // @param name 节点名称
   // @param attributes... 属性名称/属性内容
   // @return 节点
   //============================================================
   public FXmlNode syncNode(String name,
                            String... attributes){
      FXmlNode node = findNode(name, attributes);
      if(null == node){
         node = createNode(name, null, attributes);
      }
      return node;
   }

   //============================================================
   // <T>按照节点的名称进行排序。</T>
   //
   // @param asc 排序方式
   //============================================================
   public void sort(boolean asc){
      nodes().sortByAttribute(asc);
   }

   //============================================================
   // <T>按照节点指定属性名称进行排序。</T>
   //
   // @param attrNames 属性名称集合
   //============================================================
   public void sort(String... attrNames){
      nodes().sortByAttribute(true, attrNames);
   }

   //============================================================
   // <T>按照节点指定属性名称进行排序。</T>
   //
   // @param asc 排序方式
   // @param attrNames 属性名称集合
   //============================================================
   public void sort(boolean asc,
                    String... attrNames){
      nodes().sortByAttribute(asc, attrNames);
   }

   //============================================================
   // <T>移除指定属性名称的属性内容。</T>
   //
   // @param attrName 属性名称
   // @return 属性内容
   //============================================================
   public String removeAttribute(String attrName){
      return attributes().remove(attrName);
   }

   //============================================================
   // <T>移除指定的节点。</T>
   //
   // @param name 节点名称
   // @param attributes 属性集合
   // @return 属性内容
   //============================================================
   public void removeNode(String name,
                          String... attributes){
      if(hasNode()){
         FXmlNodes removes = null;
         for(FXmlNode node : nodes()){
            if(node.equals(name, attributes)){
               if(removes == null){
                  removes = new FXmlNodes();
               }
               removes.push(node);
            }
         }
         if(null != removes){
            throw new NoSuchMethodError();
            //nodes().remove(removes);
         }
      }
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
                           boolean optionDeep,
                           boolean optionText){
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
      boolean hasText = !RString.isEmpty(_text);
      boolean hasNode = (null != _nodes) ? !_nodes.isEmpty() : false;
      if(optionText && (hasText | hasNode)){
         xml.append(">");
         if(hasText){
            xml.append(RXml.formatNote(_text));
         }
         if(optionDeep && hasNode){
            xml.append("\n");
            int count = _nodes.count();
            for(int n = 0; n < count; n++){
               _nodes.get(n).buildXml(xml, level + 1, optionDeep, optionText);
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
      buildXml(xml, 0, true, true);
      return xml;
   }

   //============================================================
   // <T>获得简单字符串。</T>
   //
   // @return 简单字符串
   //============================================================
   public String simpleXml(){
      FString xml = new FString();
      buildXml(xml, 0, false, false);
      return xml.toString();
   }

   //============================================================
   // <T>获得当前实例的一份拷贝。</T>
   //
   // @return 实例的拷贝
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public FXmlNode copy(){
      // 复制节点
      FXmlNode node = new FXmlNode();
      node._document = _document;
      node._isCollection = _isCollection;
      node._name = _name;
      node._text = _text;
      // 复制属性
      if(_attributes != null){
         FAttributes attributes = new FAttributes();
         attributes.assign(_attributes);
         node._attributes = attributes;
      }
      // 复制子节点集合
      if(_nodes != null){
         node._nodes = _nodes.copy();
      }
      return node;
   }

   //============================================================
   // <T>获得对象数组。</T>
   //
   // @return 对象数组
   //============================================================
   @Override
   public FXmlNode[] toObjects(){
      return nodes().toObjects();
   }

   //============================================================
   // <T>清除当前节点的所有信息。</T>
   //============================================================
   public void clear(){
      _document = null;
      _parent = null;
      _name = null;
      _text = null;
      if(null != _attributes){
         _attributes.clear();
         _attributes = null;
      }
      if(null != _nodes){
         _nodes.clear();
         _nodes = null;
      }
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return dump().toString();
   }

   //============================================================
   // <T>获得JSON字符串。</T>
   //
   // @param source 来源代码
   // @param level 层级
   // @return JSON字符串
   //============================================================
   public FDictionary<FXmlNodes> makeJsonCollection(FXmlNode xconfig){
      FDictionary<FXmlNodes> result = null;
      if(xconfig.hasNode()){
         result = new FDictionary<FXmlNodes>();
         int count = xconfig.nodeCount();
         for(int n = 0; n < count; n++){
            FXmlNode xchild = xconfig.node(n);
            String name = xchild.name();
            // 增加对象
            FXmlNodes nodes = result.get(name);
            if(nodes == null){
               nodes = new FXmlNodes();
               result.set(name, nodes);
            }
            nodes.push(xchild);
         }
      }
      return result;
   }

   //============================================================
   // <T>获得JSON字符串。</T>
   //
   // @return JSON字符串
   //============================================================
   public String toJson(){
      FString source = new FString();
      toJson(source, true, 0);
      return source.toString();
   }

   //============================================================
   // <T>获得JSON字符串。</T>
   //
   // @param source 来源代码
   // @param level 层级
   // @return JSON字符串
   //============================================================
   public void toJson(FString source,
                      boolean top,
                      int level){
      boolean hasAttributes = hasAttribute();
      boolean hasNode = hasNode();
      FDictionary<FXmlNodes> map = makeJsonCollection(this);
      if(map == null){
         attributes().toJson(source, true);
      }

      if(_isCollection){
         // 集合处理
         int count = _nodes.count();
         for(int n = 0; n < count; n++){
            FXmlNode xchild = _nodes.get(n);
            source.appendRepeat(RDump.LEVEL_SPACE, level + 1);
            xchild.attributes().toJson(source, true);
            if(n < count - 1){
               source.append(',');
            }
            source.append('\n');
         }
      }else{
         // 开始节点
         if(!top && hasNode){
            source.appendRepeat(RDump.LEVEL_SPACE, level);
            source.append('"');
            source.append(_name);
            source.append("\":");
         }
         // 输出属性开始
         if(hasAttributes){
            source.append('{');
            if(hasNode){
               source.appendRepeat(RDump.LEVEL_SPACE, level + 1);
            }
            _attributes.toJson(source, false);
         }
         // 输出节点集合
         if(hasNode){
            if(hasAttributes){
               source.append(",");
            }
            source.append("[\n");
            int count = _nodes.count();
            for(int n = 0; n < count; n++){
               FXmlNode xchild = _nodes.get(n);
               xchild.toJson(source, false, level + 1);
               if(n < count - 1){
                  source.append(',');
               }
            }
            source.append(']');
         }
         source.append('\n');
         // 输出属性结束
         if(hasAttributes){
            source.append('}');
         }
      }
   }

   //============================================================
   // <T>获得Xml节点运行实例信息。</T>
   //
   // @param info 运行信息
   // @param node 节点
   // @param typeCd 类型
   // @param level 级别
   // @return 运行信息
   //============================================================
   protected TDumpInfo dump(TDumpInfo info,
                            FXmlNode node,
                            EDumpLevel typeCd,
                            int level){
      // 检查参数
      if((null == info) || (null == node) || (level > 99)){
         return info;
      }
      // 获得当前节点信息
      info.append(RDump.levelSpace(level));
      RDump.dump(info, node);
      info.append(' ');
      info.append(node.name());
      if(node.hasAttribute()){
         FAttributes attrs = node.attributes();
         int count = attrs.count();
         if(count > 0){
            info.append(" { ");
            attrs.toString(info, "=", ", ");
            info.append(" }");
         }
      }
      if(!RString.isEmpty(node.text())){
         info.append(" - [");
         info.append(node.text());
         info.append("]");
      }
      // 获得子节点信息
      if(node.hasNode()){
         for(FXmlNode child : node.nodes()){
            info.appendLine();
            dump(info, child, typeCd, level + 1);
         }
      }
      return info;
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      return dump(info, this, EDumpLevel.Normal, info.level());
   }
}
