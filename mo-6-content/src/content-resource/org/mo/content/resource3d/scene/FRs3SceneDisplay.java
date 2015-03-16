package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.content.resource3d.common.SFloatMatrix3d;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FRs3SceneDisplay
      extends FRs3Object
{
   // 模板唯一编号
   protected String _templateGuid;

   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   // 场景动画集合
   protected FObjects<FRs3SceneAnimation> _animations;

   // 场景剪辑集合
   protected FObjects<FRs3SceneMovie> _movies;

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
   // <T>获得模板唯一编号。</T>
   //
   // @return 模板唯一编号
   //============================================================
   public String templateGuid(){
      return _templateGuid;
   }

   //============================================================
   // <T>设置模板唯一编号。</T>
   //
   // @param templateGuid 模板唯一编号
   //============================================================
   public void setTemplateGuid(String templateGuid){
      _templateGuid = templateGuid;
   }

   //============================================================
   // <T>获得矩阵。</T>
   //
   // @return 矩阵
   //============================================================
   public SFloatMatrix3d matrix(){
      return _matrix;
   }

   //============================================================
   // <T>判断是否含有动画。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasAnimation(){
      return (_animations != null) ? !_animations.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找动画对象。</T>
   //
   // @param guid 唯一编号
   // @return 动画对象
   //============================================================
   public FRs3SceneAnimation findAnimationByGuid(String guid){
      if(!RString.isEmpty(guid) && (_animations != null)){
         for(FRs3SceneAnimation animation : _animations){
            if(guid.equals(animation.guid())){
               return animation;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>根据唯一编号查找动画对象。</T>
   //
   // @param guid 唯一编号
   // @return 动画对象
   //============================================================
   public FRs3SceneAnimation syncAnimationByGuid(String guid){
      FRs3SceneAnimation animation = findAnimationByGuid(guid);
      if(animation == null){
         animation = new FRs3SceneAnimation();
         animation.setGuid(guid);
         pushAnimation(animation);
      }
      return animation;
   }

   //============================================================
   // <T>获得场景动画集合。</T>
   //
   // @return 场景动画集合
   //============================================================
   public FObjects<FRs3SceneAnimation> animations(){
      return _animations;
   }

   //============================================================
   // <T>增加一个场景动画。</T>
   //
   // @param movie 场景动画
   //============================================================
   public void pushAnimation(FRs3SceneAnimation animation){
      if(_animations == null){
         _animations = new FObjects<FRs3SceneAnimation>(FRs3SceneAnimation.class);
      }
      _animations.push(animation);
   }

   //============================================================
   // <T>判断是否含有动画。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasMovie(){
      return (_movies != null) ? !_movies.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找动画对象。</T>
   //
   // @param guid 唯一编号
   // @return 动画对象
   //============================================================
   public FRs3SceneMovie findMovieByGuid(String guid){
      if(!RString.isEmpty(guid) && (_movies != null)){
         for(FRs3SceneMovie movie : _movies){
            if(guid.equals(movie.guid())){
               return movie;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得场景动画集合。</T>
   //
   // @return 场景动画集合
   //============================================================
   public FObjects<FRs3SceneMovie> movies(){
      return _movies;
   }

   //============================================================
   // <T>增加一个场景动画。</T>
   //
   // @param movie 场景动画
   //============================================================
   public void pushMovie(FRs3SceneMovie movie){
      if(_movies == null){
         _movies = new FObjects<FRs3SceneMovie>(FRs3SceneMovie.class);
      }
      _movies.push(movie);
   }

   //============================================================
   // <T>判断是否含有材质。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasMaterial(){
      return (_materials != null) ? !_materials.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找材质对象。</T>
   //
   // @param guid 唯一编号
   // @return 材质对象
   //============================================================
   public FRs3SceneMaterial findMaterialByGuid(String guid){
      if(!RString.isEmpty(guid) && (_materials != null)){
         for(FRs3SceneMaterial material : _materials){
            if(guid.equals(material.guid())){
               return material;
            }
         }
      }
      return null;
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
   // <T>根据唯一编号查找渲染对象。</T>
   //
   // @param guid 唯一编号
   // @return 渲染对象
   //============================================================
   public FRs3SceneRenderable findRenderableByGuid(String guid){
      if(!RString.isEmpty(guid) && (_renderables != null)){
         for(FRs3SceneRenderable renderable : _renderables){
            if(guid.equals(renderable.guid())){
               return renderable;
            }
         }
      }
      return null;
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
      output.writeString(_templateGuid);
      _matrix.serialize(output);
      // 存储动画集合
      if(_animations != null){
         int count = _animations.count();
         output.writeUint16(count);
         for(FRs3SceneAnimation animation : _animations){
            animation.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
      // 存储动画集合
      if(_movies != null){
         int count = _movies.count();
         output.writeUint16(count);
         for(FRs3SceneMovie movie : _movies){
            movie.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
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
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _templateGuid = xconfig.get("template_guid", _templateGuid);
      // 读取节点集合
      for(FXmlNode xnode : xconfig.nodes()){
         if(xnode.isName("Matrix")){
            // 读取矩阵
            _matrix.loadConfig(xnode);
         }else if(xnode.isName("AnimationCollection")){
            // 读取动画集合
            for(FXmlNode xanimation : xnode){
               FRs3SceneAnimation animation = new FRs3SceneAnimation();
               animation.loadConfig(xanimation);
               pushAnimation(animation);
            }
         }else if(xnode.isName("MovieCollection")){
            // 读取剪辑集合
            for(FXmlNode xmovie : xnode){
               FRs3SceneMovie movie = new FRs3SceneMovie();
               movie.loadConfig(xmovie);
               pushMovie(movie);
            }
         }else if(xnode.isName("MaterialCollection")){
            // 读取材质集合
            for(FXmlNode xmaterial : xnode){
               FRs3SceneMaterial material = new FRs3SceneMaterial();
               material.loadConfig(xmaterial);
               pushMaterial(material);
            }
         }else if(xnode.isName("RenderableCollection")){
            // 读取渲染集合
            for(FXmlNode xrenderable : xnode){
               FRs3SceneRenderable renderable = new FRs3SceneRenderable();
               renderable.loadConfig(xrenderable);
               pushRenderable(renderable);
            }
         }else{
            throw new FFatalError("Unknown node type.");
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
      // 读取节点集合
      for(FXmlNode xnode : xconfig.nodes()){
         if(xnode.isName("Matrix")){
            // 读取矩阵
            _matrix.loadConfig(xnode);
         }else if(xnode.isName("AnimationCollection")){
            // 读取动画集合
            for(FXmlNode xanimation : xnode){
               String animationGuid = xanimation.get("guid");
               FRs3SceneAnimation animation = syncAnimationByGuid(animationGuid);
               animation.mergeConfig(xanimation);
            }
         }else if(xnode.isName("MovieCollection")){
            // 读取剪辑集合
            for(FXmlNode xmovie : xnode){
               String movieGuid = xmovie.get("guid");
               FRs3SceneMovie movie = findMovieByGuid(movieGuid);
               movie.mergeConfig(xmovie);
            }
         }else if(xnode.isName("MaterialCollection")){
            // 读取材质集合
            for(FXmlNode xmaterial : xnode){
               String materialGuid = xmaterial.get("guid");
               FRs3SceneMaterial material = findMaterialByGuid(materialGuid);
               material.mergeConfig(xmaterial);
            }
         }else if(xnode.isName("RenderableCollection")){
            // 读取渲染集合
            for(FXmlNode xrenderable : xnode){
               String renderableGuid = xrenderable.get("guid");
               FRs3SceneRenderable renderable = findRenderableByGuid(renderableGuid);
               renderable.mergeConfig(xrenderable);
            }
         }else{
            throw new FFatalError("Unknown node type.");
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
      // 存储属性
      xconfig.set("template_guid", _templateGuid);
      _matrix.saveConfig(xconfig.createNode("Matrix"));
      // 存储动画集合
      if(_animations != null){
         FXmlNode xanimation = xconfig.createNode("AnimationCollection");
         for(FRs3SceneAnimation animation : _animations){
            animation.saveConfig(xanimation.createNode("Animation"));
         }
      }
      // 存储剪辑集合
      if(_movies != null){
         FXmlNode xmovies = xconfig.createNode("MovieCollection");
         for(FRs3SceneMovie movie : _movies){
            movie.saveConfig(xmovies.createNode("Movie"));
         }
      }
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
      // 读取剪辑集合
      int movieCount = input.readInt32();
      for(int n = 0; n < movieCount; n++){
         FRs3SceneMovie movie = new FRs3SceneMovie();
         movie.importData(input);
         pushMovie(movie);
      }
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
