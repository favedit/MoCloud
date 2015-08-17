package org.mo.com.resource;

import java.io.InputStream;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FMultiString;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.cultrue.RCulture;
import org.mo.com.lang.generic.IStringBuilder;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.com.xml.FXmlNodeDictionary;

//============================================================
// <T>资源对象。</T>
//============================================================
public class FResource
      implements
         IResource
{
   // 设置信息
   protected FXmlNode _config;

   // 设置节点表
   protected final FXmlNodeDictionary _configs = new FXmlNodeDictionary();

   // 类引用对象
   protected Class<?> _reference;

   //============================================================
   // <T>构造资源对象。</T>
   //============================================================
   protected FResource(){
   }

   //============================================================
   // <T>获得引用对象。</T>
   //
   // @return 引用对象
   //============================================================
   @Override
   public Class<?> reference(){
      return _reference;
   }

   //============================================================
   // <T>获得设置信息。</T>
   //
   // @return 设置信息
   //============================================================
   @Override
   public FXmlNode config(){
      return _config;
   }

   //============================================================
   // <T>根据类对象构造。</T>
   //
   // @param clazz 类对象
   //============================================================
   public void construct(Class<?> clazz){
      _reference = clazz;
      String name = RClass.shortName(clazz) + ".xml";
      InputStream input = clazz.getResourceAsStream(name);
      if(input == null){
         throw new FFatalError("Can't open resource stream. (name={1})", name);
      }
      FXmlDocument doc = new FXmlDocument();
      doc.loadStream(input);
      _config = doc.root();
      for(FXmlNode node : doc.root().nodes()){
         if(node.isName("Resource")){
            _configs.set(node.get("name"), node);
         }
      }
   }

   //============================================================
   // <T>根据名称查找布尔值。</T>
   //
   // @param name 名称
   // @return 布尔值
   //============================================================
   @Override
   public boolean findBoolean(String name){
      boolean result = false;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         String text = xconfig.text();
         result = RBoolean.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找整数。</T>
   //
   // @param name 名称
   // @return 整数
   //============================================================
   @Override
   public int findInteger(String name){
      int result = 0;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         String text = xconfig.text();
         result = RInteger.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找长整数。</T>
   //
   // @param name 名称
   // @return 长整数
   //============================================================
   @Override
   public long findLong(String name){
      long result = 0;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         String text = xconfig.text();
         result = RLong.parse(text);
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找字符串。</T>
   //
   // @param name 名称
   // @return 字符串
   //============================================================
   @Override
   public String findString(String name){
      String result = null;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         result = xconfig.text();
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找字符串。</T>
   //
   // @param clazz 类对象
   // @param name 名称
   // @return 字符串
   //============================================================
   public <T extends IStringBuilder> T findString(Class<T> clazz,
                                                  String name){
      T result = RClass.newInstance(clazz);
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         String text = xconfig.text();
         result.assign(text);
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找字符串。</T>
   //
   // @param name 名称
   // @param language 语言
   // @return 字符串
   //============================================================
   @Override
   public String findString(String name,
                            String language){
      String result = null;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         result = xconfig.nodeText(language);
         if(RString.isEmpty(result)){
            if(RString.isEmpty(language)){
               language = RCulture.currentLanguage();
            }
            result = xconfig.nodeText(language);
         }
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找显示内容。</T>
   //
   // @param name 名称
   // @return 显示内容
   //============================================================
   @Override
   public String findDisplay(String name){
      String language = RCulture.currentLanguage();
      return findString(name, language);
   }

   //============================================================
   // <T>根据名称查找多语言字符串。</T>
   //
   // @param name 名称
   // @return 多语言字符串
   //============================================================
   @Override
   public FMultiString findMultiString(String name){
      FMultiString result = null;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         result = new FMultiString();
         result.unpack(xconfig.text());
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找多语言字符串。</T>
   //
   // @param name 名称
   // @param language 语言
   // @return 多语言字符串
   //============================================================
   @Override
   public String findMultiString(String name,
                                 String language){
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         FMultiString result = new FMultiString();
         result.unpack(xconfig.text());
         result.get(language);
      }
      return null;
   }

   //============================================================
   // <T>根据名称查找类对象。</T>
   //
   // @param name 名称
   // @return 类对象
   //============================================================
   @Override
   public Class<?> findClass(String name){
      Class<?> result = null;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         String text = xconfig.text();
         result = RClass.findClass(text);
      }
      return result;
   }

   //============================================================
   // <T>根据名称查找配置节点。</T>
   //
   // @param name 名称
   // @return 配置节点
   //============================================================
   @Override
   public FXmlNode findConfig(String name){
      return _configs.get(name);
   }

   //============================================================
   // <T>根据名称查找配置节点属性。</T>
   //
   // @param name 名称
   // @param attributeName 属性名称
   // @return 节点属性
   //============================================================
   @Override
   public String findConfigAttribute(String name,
                                     String attributeName){

      String result = null;
      FXmlNode xconfig = _configs.get(name);
      if(xconfig != null){
         result = xconfig.get(attributeName, null);
      }
      return result;
   }
}
