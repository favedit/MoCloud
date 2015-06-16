package org.mo.cloud.content.design.persistence;

import org.mo.cloud.content.design.configuration.EContentData;
import org.mo.cloud.content.design.configuration.FContentClass;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FMultiString;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>内容持久化。</T>
//============================================================
public class FPersistence
      extends FObject
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FPersistence.class);

   // 存储名称
   protected String _storageName;

   // 持久名称
   protected String _persistenceName;

   // 内容类字典
   protected FDictionary<FContentClass> _classes = new FDictionary<FContentClass>(FContentClass.class);

   //============================================================
   // <T>构造内容持久化。</T>
   //============================================================
   public FPersistence(){
   }

   //============================================================
   // <T>获得存储名称。</T>
   //
   // @return 存储名称
   //============================================================
   public String storageName(){
      return _storageName;
   }

   //============================================================
   // <T>设置存储名称。</T>
   //
   // @param storageName 存储名称
   //============================================================
   public void setStorageName(String storageName){
      _storageName = storageName;
   }

   //============================================================
   // <T>获得持久名称。</T>
   //
   // @return 持久名称
   //============================================================
   public String persistenceName(){
      return _persistenceName;
   }

   //============================================================
   // <T>设置持久名称。</T>
   //
   // @param persistenceName 持久名称
   //============================================================
   public void setPersistenceName(String persistenceName){
      _persistenceName = persistenceName;
   }

   //============================================================
   // <T>获得内容类。</T>
   //
   // @param className 类名称
   // @return 内容类
   //============================================================
   public FContentClass findClass(String className){
      return _classes.get(className);
   }

   //============================================================
   // <T>获得内容类字典。</T>
   //
   // @return 内容类字典
   //============================================================
   public FDictionary<FContentClass> classes(){
      return _classes;
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @return 实例
   //============================================================
   public <T extends XContentObject> T createInstance(String name){
      // 获得类对象
      FContentClass clazz = _classes.find(name);
      if(clazz == null){
         throw new FFatalError("Content class is not found. (name={1})", name);
      }
      // 创建实例
      T instance = clazz.newInstance();
      instance.linkContentClass(clazz);
      return instance;
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 实例
   //============================================================
   public void setAttributes(XContentObject xinsance,
                             IAttributes attributes,
                             EPersistenceMode modeCd){
      FContentClass clazz = xinsance.contentClass();
      for(INamePair<FContentField> pair : clazz.fields()){
         String name = pair.name();
         String value = attributes.get(name, null);
         FContentField field = pair.value();
         field.set(xinsance, value);
         //         String name = pair.name();
         //         FContentField field = pair.value();
         //         // 存储模式
         //         if(modeCd == EPersistenceMode.Store){
         //            if(field.isStore()){
         //               String value = attributes.get(name, null);
         //               field.set(xinsance, value);
         //            }
         //         }
         //         // 配置模式
         //         if(modeCd == EPersistenceMode.Config){
         //            if(field.isConfig()){
         //               String value = attributes.get(name, null);
         //               field.set(xinsance, value);
         //            }
         //         }
      }
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 实例
   //============================================================
   public void setAttributeValue(IAttributes attributes,
                                 FContentField field,
                                 Object value,
                                 EPersistenceMode modeCd){
      // 处理所有节点
      String name = field.linkName();
      if(value != null){
         String contentValue = null;
         // 数据类型判断
         EContentData dataCd = field.dataCd();
         if(dataCd == EContentData.Boolean){
            if(RBoolean.parse(value)){
               contentValue = RBoolean.TRUE_STR;
            }
         }else if(dataCd == EContentData.String){
            String valueString = value.toString();
            if(!RString.isEmpty(valueString)){
               contentValue = valueString;
            }

         }else{
            contentValue = value.toString();
         }
         // 存储模式
         if(modeCd == EPersistenceMode.Store){
            if(field.isStore()){
               attributes.set(name, contentValue);
            }
         }
         // 配置模式
         if(modeCd == EPersistenceMode.Config){
            if(field.isConfig()){
               attributes.set(name, contentValue);
            }
         }
      }
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 实例
   //============================================================
   public void setAttributes(IAttributes attributes,
                             XContentObject xinsance,
                             EPersistenceMode modeCd){
      FContentClass clazz = xinsance.contentClass();
      for(INamePair<FContentField> pair : clazz.fields()){
         FContentField field = pair.value();
         Object value = field.get(xinsance);
         setAttributeValue(attributes, field, value, modeCd);
      }
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 实例
   //============================================================
   public void setAttributes(String className,
                             IAttributes attributes,
                             IAttributes values,
                             EPersistenceMode modeCd){
      // 查找内容类对象
      FContentClass clazz = findClass(className);
      if(clazz == null){
         throw new FFatalError("Content class is not exists. (class_name={1})", className);
      }
      // 处理所有节点
      for(INamePair<FContentField> pair : clazz.fields()){
         FContentField field = pair.value();
         String value = values.get(field.linkName(), null);
         setAttributeValue(attributes, field, value, modeCd);
      }
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public <T extends XContentObject> T convertInstance(FContentObject xconfig){
      return convertInstance(xconfig, EPersistenceMode.Config);
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   // @param modeCd 模式类型
   //============================================================
   public <T extends XContentObject> T convertInstance(FContentObject xconfig,
                                                       EPersistenceMode modeCd){
      String name = xconfig.name();
      T xinstance = createInstance(name);
      if(xconfig.hasAttribute()){
         setAttributes(xinstance, xconfig.attributes(), modeCd);
      }
      if(xconfig.hasNode()){
         for(FContentObject xobject : xconfig.nodes()){
            XContentObject xchild = convertInstance(xobject, modeCd);
            xinstance.children().push(xchild);
         }
      }
      return xinstance;
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   // @param modeCd 模式类型
   //============================================================
   public void mergeConfig(FContentObject xinstance,
                           FContentObject xconfig,
                           EPersistenceMode modeCd){
      // 查找内容类对象
      String className = xconfig.name();
      FContentClass clazz = findClass(className);
      if(clazz == null){
         throw new FFatalError("Content class is not exists. (class_name={1})", className);
      }
      // 合并属性
      if(xconfig.hasAttribute()){
         for(INamePair<FContentField> pair : clazz.fields()){
            FContentField field = pair.value();
            String name = field.name();
            String value = xconfig.get(name);
            xinstance.set(name, value);
         }
      }
      // 合并节点
      if(xinstance.hasNode()){
         for(FContentObject xchild : xinstance.nodes()){
            String obejctId = xchild.objectId();
            FContentObject xnode = xconfig.find(obejctId);
            if(xnode != null){
               mergeConfig(xchild, xnode, modeCd);
            }
         }
      }
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public <T extends XContentObject> FContentObject convertConfig(T instance){
      return convertConfig(instance, EPersistenceMode.Config);
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   // @param modeCd 模式类型
   //============================================================
   public <T extends XContentObject> FContentObject convertConfig(T instance,
                                                                  EPersistenceMode modeCd){
      FContentObject content = new FContentObject();
      content.setName(instance.name());
      setAttributes(content.attributes(), instance, modeCd);
      if(instance.hasChild()){
         for(XContentObject xchildren : instance.children()){
            content.push(convertConfig(xchildren, modeCd));
         }
      }
      return content;
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void load(FContentObject xconfig){
      for(FContentObject xobject : xconfig.nodes()){
         String name = xobject.get("name");
         FContentClass clazz = _classes.find(name);
         if(clazz == null){
            clazz = new FContentClass();
            clazz.load(xobject);
            _logger.debug(this, "load", "Create content class. (storage={1}, persistence={2}, class={3})", _storageName, _persistenceName, clazz.name());
            _classes.set(name, clazz);
         }
      }
   }

   //============================================================
   // <T>创建实例。</T>
   //
   // @param name 名称
   // @param attributes 属性集合
   // @return 实例
   //============================================================
   public void format(FContentObject contentObject,
                      EPersistenceMode modeCd){
      // 重新设置属性集合
      String type = contentObject.name();
      FAttributes attributes = new FAttributes();
      setAttributes(type, attributes, contentObject.attributes(), modeCd);
      for(IStringPair pair : attributes){
         String value = pair.value();
         if(!RString.isEmpty(value)){
            if(value.startsWith("M#")){
               FMultiString source = new FMultiString();
               source.unpack(value);
               if(source.contains("cn")){
                  value = source.get("cn");
               }else if(!source.isEmpty()){
                  value = source.value(0);
               }
               attributes.set(pair.name(), value);
            }
         }
      }
      contentObject.attributes().assignNotEmpty(attributes);
      // 处理所有节点
      if(contentObject.hasNode()){
         for(FContentObject contentNode : contentObject.nodes()){
            format(contentNode, modeCd);
         }
      }
   }
}
