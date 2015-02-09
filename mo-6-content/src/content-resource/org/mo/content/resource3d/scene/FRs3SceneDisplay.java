package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.content.resource3d.common.SFloatMatrix3d;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FRs3SceneDisplay
      extends FRs3Object
{
   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   // 场景材质集合
   protected FObjects<FRs3SceneMaterial> _materials;

   // 场景渲染集合
   protected FObjects<FRs3SceneRenderable> _renderables;

   //============================================================
   // <T>构造场景显示。</T>
   //============================================================
   public FRs3SceneDisplay(){
   }

   //============================================================
   // <T>获得场景材质集合。</T>
   //
   // @return 场景材质集合
   //============================================================
   public FObjects<FRs3SceneMaterial> materials(){
      return _materials;
   }

   //============================================================
   // <T>增加一个场景材质。</T>
   //
   // @param material 场景材质
   //============================================================
   public void pushMaterial(FRs3SceneMaterial material){
      if(_materials == null){
         _materials = new FObjects<FRs3SceneMaterial>(FRs3SceneMaterial.class);
      }
      _materials.push(material);
   }

   //============================================================
   // <T>获得场景渲染集合。</T>
   //
   // @return 场景渲染集合
   //============================================================
   public FObjects<FRs3SceneRenderable> renderables(){
      return _renderables;
   }

   //============================================================
   // <T>增加一个场景渲染。</T>
   //
   // @param renderable 场景渲染
   //============================================================
   public void pushRenderable(FRs3SceneRenderable renderable){
      if(_renderables == null){
         _renderables = new FObjects<FRs3SceneRenderable>(FRs3SceneRenderable.class);
      }
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
      // 存储属性
      _matrix.serialize(output);
      // 存储材质集合
      if(_materials != null){
         int count = _materials.count();
         output.writeUint16(count);
         for(FRs3SceneMaterial material : _materials){
            material.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
      // 存储渲染集合
      if(_renderables != null){
         int count = _renderables.count();
         output.writeUint16(count);
         for(FRs3SceneRenderable renderable : _renderables){
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
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      // 读取材质集合
      FXmlNode xmaterials = xconfig.findNode("MaterialCollection");
      if(xmaterials != null){
         for(FXmlNode xmaterial : xmaterials){
            FRs3SceneMaterial material = new FRs3SceneMaterial();
            material.loadConfig(xmaterial);
            pushMaterial(material);
         }
      }
      // 读取材质集合
      FXmlNode xrenderables = xconfig.findNode("RenderableCollection");
      if(xrenderables != null){
         for(FXmlNode xrenderable : xrenderables){
            FRs3SceneRenderable renderable = new FRs3SceneRenderable();
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("code", _code);
      // 存储材质集合
      if(_materials != null){
         FXmlNode xmaterials = xconfig.createNode("MaterialCollection");
         for(FRs3SceneMaterial material : _materials){
            material.saveConfig(xmaterials.createNode("Material"));
         }
      }
      // 存储渲染集合
      if(_renderables != null){
         FXmlNode xrenderables = xconfig.createNode("RenderableCollection");
         for(FRs3SceneRenderable renderable : _renderables){
            renderable.saveConfig(xrenderables.createNode("Renderable"));
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _matrix.unserialize(input);
      // 读取材质集合
      int materialCount = input.readInt32();
      for(int n = 0; n < materialCount; n++){
         FRs3SceneMaterial material = new FRs3SceneMaterial();
         material.importData(input);
         pushMaterial(material);
      }
      // 读取渲染集合
      int renderableCount = input.readInt32();
      for(int n = 0; n < renderableCount; n++){
         FRs3SceneRenderable renderable = new FRs3SceneRenderable();
         renderable.importData(input);
         pushRenderable(renderable);
      }
   }
}
