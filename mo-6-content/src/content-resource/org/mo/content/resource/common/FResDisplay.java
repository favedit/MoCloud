package org.mo.content.resource.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源显示对象。</T>
//============================================================
public class FResDisplay
      extends FResDrawable
{
   // 渲染集合
   protected FObjects<FResRenderable> _renderables;

   //============================================================
   // <T>构造资源显示对象。</T>
   //============================================================
   public FResDisplay(){
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   public FResObject createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "Renderable":
            return new FResRenderable();
      }
      throw new FFatalError("Invalid config type. (type_name={1})", typeName);
   }

   //============================================================
   // <T>判断是否含有渲染对象。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasRenderable(){
      return (_renderables != null) ? !_renderables.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找渲染对象。</T>
   //
   // @param guid 唯一编号
   // @return 渲染对象
   //============================================================
   public FResRenderable findRenderableByGuid(String guid){
      if(!RString.isEmpty(guid)){
         for(FResRenderable renderable : _renderables){
            if(guid.equals(renderable.guid())){
               return renderable;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得渲染集合。</T>
   //
   // @return 渲染集合
   //============================================================
   public FObjects<FResRenderable> renderables(){
      return _renderables;
   }

   //============================================================
   // <T>增加一个渲染对象。</T>
   //
   // @param renderable 渲染对象
   //============================================================
   public void pushRenderable(FResRenderable renderable){
      if(_renderables == null){
         _renderables = new FObjects<FResRenderable>(FResRenderable.class);
      }
      renderable.setParent(this);
      _renderables.push(renderable);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出渲染集合
      if(hasRenderable()){
         int count = _renderables.count();
         output.writeUint16(count);
         for(FResRenderable renderable : _renderables){
            renderable.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 处理所有节点
      FXmlNode xrenderables = xconfig.findNode("RenderableCollection");
      if(xrenderables != null){
         for(FXmlNode xrenderable : xrenderables){
            FResRenderable renderable = (FResRenderable)createChild(xrenderable);
            renderable.loadConfig(xrenderable);
            pushRenderable(renderable);
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 处理所有节点
      if(hasRenderable()){
         FXmlNode xrenderables = xconfig.createNode("RenderableCollection");
         for(FResRenderable renderable : _renderables){
            renderable.saveConfig(xrenderables.createNode("Renderable"));
         }
      }
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 处理所有节点
      FXmlNode xrenderables = xconfig.findNode("RenderableCollection");
      if(xrenderables != null){
         for(FXmlNode xrenderable : xrenderables){
            String guid = xrenderable.get("guid");
            FResRenderable renderable = findRenderableByGuid(guid);
            renderable.mergeConfig(xrenderable);
         }
      }
   }
}
