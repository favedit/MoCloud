package org.mo.content.core.configuration;

import org.mo.com.lang.RString;
import org.mo.com.lang.generic.MObjects;
import org.mo.com.xml.FXmlNodes;

//============================================================
// <T>内容对象集合。</T>
//============================================================
public class FContentObjects
      extends MObjects<FContentObject>
{
   // 父节点
   protected FContentObject _parent;

   //============================================================
   // <T>构造内容对象集合。</T>
   //============================================================
   public FContentObjects(){
      super(FContentObject.class);
   }

   //============================================================
   // <T>构造内容对象集合。</T>
   //============================================================
   public FContentObjects(FContentObject parent){
      super(FContentObject.class);
      _parent = parent;
   }

   //============================================================
   // <T>查询指定编号的内容节点。</T>
   //
   // @param objectId 对象编号
   // @return 内容节点
   //============================================================
   public FContentObject find(String objectId){
      for(int n = 0; n < _count; n++){
         FContentObject xobject = _items[n];
         if(xobject.objectId().equals(objectId)){
            return xobject;
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
      for(int n = 0; n < _count; n++){
         FContentObject xobject = _items[n];
         if(xobject.hasAttribute()){
            String value = xobject.get(attributeName);
            if(RString.equals(value, attributeValue)){
               return xobject;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>追加一个数据到尾部。</T>
   //
   // @param value 数据
   //============================================================
   @Override
   public void push(FContentObject value){
      value.setParent(_parent);
      super.push(value);
   }

   //============================================================
   // <T>获得节点。</T>
   //
   // @return 节点
   //============================================================
   public FXmlNodes makeConfig(){
      FXmlNodes xconfig = new FXmlNodes();
      for(int n = 0; n < _count; n++){
         FContentObject xobject = _items[n];
         xconfig.push(xobject.makeConfig());
      }
      return xconfig;
   }
}
