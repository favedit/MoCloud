package org.mo.cloud.content.design.configuration;

import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.lang.face.AName;
import org.mo.com.lang.reflect.FClass;
import org.mo.com.lang.reflect.FField;
import org.mo.com.lang.reflect.RClass;

//============================================================
// <T>内容类对象。</T>
//============================================================
public class FContentClass
      extends FObject
{
   // 名称
   protected String _name;

   // 标签
   protected String _label;

   // 是否接口
   protected boolean _interface;

   // 类名称
   protected String _className;

   // 继承集合
   protected FObjects<FContentClass> _inherits = new FObjects<FContentClass>(FContentClass.class);

   // 字段集合
   protected FDictionary<FContentField> _fields = new FDictionary<FContentField>(FContentField.class);

   //============================================================
   // <T>构造内容类对象。</T>
   //============================================================
   public FContentClass(){
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得标签。</T>
   //
   // @return 标签
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签。</T>
   //
   // @param label 标签
   //============================================================
   public void setLabel(String label){
      _label = label;
   }

   //============================================================
   // <T>判断是否接口。</T>
   //
   // @return 是否接口
   //============================================================
   public boolean isInterface(){
      return _interface;
   }

   //============================================================
   // <T>获得继承集合。</T>
   //
   // @return 继承集合
   //============================================================
   public FObjects<FContentClass> inherits(){
      return _inherits;
   }

   //============================================================
   // <T>获得字段。</T>
   //
   // @param name 名称
   // @return 字段
   //============================================================
   public FContentField findField(String name){
      return _fields.find(name);
   }

   //============================================================
   // <T>获得字段集合。</T>
   //
   // @return 字段集合
   //============================================================
   public FDictionary<FContentField> fields(){
      return _fields;
   }

   //============================================================
   // <T>创建新实例。</T>
   //
   // @return 实例
   //============================================================
   @SuppressWarnings("unchecked")
   public <T> T newInstance(){
      return (T)RClass.newInstance(_className);
   }

   //============================================================
   // <T>加载配置信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void load(FContentObject xconfig){
      _name = xconfig.get("name");
      _className = xconfig.get("class_name");
      _interface = "Interface".equals(xconfig.name());
      if(!RString.isEmpty(_className)){
         if(!_interface){
            build();
         }
      }
   }

   //============================================================
   // <T>查找指定名称的节点。</T>
   //============================================================
   protected FField findField(FField[] fields,
                              String name){
      for(FField field : fields){
         if(!field.isStatic()){
            AName aname = field.getAnnotation(AName.class);
            if(aname != null){
               String linkName = aname.value();
               if(linkName.equals(name)){
                  return field;
               }
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>建立内部信息。</T>
   //============================================================
   protected void build(){
      FClass<?> clazz = RClass.find(_className);
      // 查找所有内容字段声明
      FField[] fields = clazz.allDeclaredFields();
      for(FField field : fields){
         if(field.isStatic()){
            // 获得内容字段
            AContentField afield = field.getAnnotation(AContentField.class);
            if(afield != null){
               FContentField contentField = (FContentField)field.get(clazz.nativeObject());
               _fields.set(contentField.linkName(), contentField);
            }
         }
      }
      // 设置所有内容字段关联
      for(FField field : fields){
         if(!field.isStatic()){
            // 获得内容字段
            AName aname = field.getAnnotation(AName.class);
            if(aname != null){
               String linkName = aname.value();
               // 查找名称
               FContentField contentField = _fields.find(linkName);
               if(contentField == null){
                  throw new FFatalError("Content field is not exists. (link_name={1})", linkName);
               }
               // 关联字段
               contentField.link(field);
               // 设置分组字段
               String dataGroup = contentField.dataGroup();
               if(dataGroup != null){
                  FField groupField = findField(fields, dataGroup);
                  if(groupField == null){
                     throw new FFatalError("Content group field is not exists. (link_name={1}, data_group={2})", linkName, dataGroup);
                  }
                  contentField.linkGroup(groupField);
               }
            }
         }
      }
   }
}
