package org.mo.cloud.content.design.persistence;

import org.mo.cloud.content.design.configuration.FContentClass;
import org.mo.cloud.content.design.configuration.FContentField;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.INamePair;
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
   public void setAttributes(IAttributes attributes,
                             XContentObject xinsance,
                             EPersistenceMode modeCd){
      FContentClass clazz = xinsance.contentClass();
      for(INamePair<FContentField> pair : clazz.fields()){
         String name = pair.name();
         FContentField field = pair.value();
         Object value = field.get(xinsance);
         if(value != null){
            // 存储模式
            if(modeCd == EPersistenceMode.Store){
               if(field.isStore()){
                  attributes.set(name, value.toString());
               }
            }
            // 配置模式
            if(modeCd == EPersistenceMode.Config){
               if(field.isConfig()){
                  attributes.set(name, value.toString());
               }
            }
         }
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
}
