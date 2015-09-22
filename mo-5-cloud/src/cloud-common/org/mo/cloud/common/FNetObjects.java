package org.mo.cloud.common;

import org.mo.com.lang.FObjects;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>网络对象集合。</T>
//============================================================
public class FNetObjects<V extends INetObject>
      extends FObjects<V>
{
   // 类型名称
   protected String _typeName;

   //============================================================
   // <T>构造对象集合。</T>
   //
   // @param clazz 类对象
   //============================================================
   public FNetObjects(Class<V> clazz,
                      String typeName){
      super(clazz);
      _typeName = typeName;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      FXmlNode xnodes = xconfig.findNode(_typeName + "Collection");
      if(xnodes != null){
         for(FXmlNode xnode : xnodes.nodes()){
            if(xnode.isName(_typeName)){
               V instance = RClass.newInstance(_clazz);
               instance.loadConfig(xnode);
            }
         }
      }
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      if(_count > 0){
         FXmlNode xnodes = xconfig.createNode(_typeName + "Collection");
         xnodes.setIsCollection(true);
         for(int n = 0; n < _count; n++){
            V instance = _items[n];
            instance.saveConfig(xnodes.createNode(_typeName));
         }
      }
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   public void reset(){
      clear();
   }
}
