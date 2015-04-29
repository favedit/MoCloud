package org.mo.content.resource.model;

import com.cyou.gccloud.data.data.FDataResourceModelUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource.common.FResAnimation;
import org.mo.content.resource.common.FResSkeleton;
import org.mo.content.resource.common.FResSpace;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FResModel
      extends FResSpace
{
   // 网格集合
   protected FObjects<FResModelMesh> _meshs;

   // 骨骼集合
   protected FObjects<FResSkeleton> _skeletons;

   // 动画集合
   protected FObjects<FResAnimation> _animations;

   // 显示对象
   protected FResModelDisplay _display = new FResModelDisplay();

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FResModel(){
      _typeName = "Model";
   }

   //============================================================
   // <T>判断时候含有网格。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasMesh(){
      return (_meshs != null) ? !_meshs.isEmpty() : false;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FResModelMesh> meshs(){
      return _meshs;
   }

   //============================================================
   // <T>增加一个网格。</T>
   //
   // @param mesh 网格
   //============================================================
   public void pushMesh(FResModelMesh mesh){
      if(_meshs == null){
         _meshs = new FObjects<FResModelMesh>(FResModelMesh.class);
      }
      mesh.setModel(this);
      _meshs.push(mesh);
   }

   //============================================================
   // <T>获得骨骼集合。</T>
   //
   // @return 骨骼集合
   //============================================================
   public FObjects<FResSkeleton> skeletons(){
      return _skeletons;
   }

   //============================================================
   // <T>增加一个骨骼。</T>
   //
   // @param skeleton 骨骼
   //============================================================
   public void pushSkeleton(FResSkeleton skeleton){
      if(_skeletons == null){
         _skeletons = new FObjects<FResSkeleton>(FResSkeleton.class);
      }
      _skeletons.push(skeleton);
   }

   //============================================================
   // <T>获得动画集合。</T>
   //
   // @return 动画集合
   //============================================================
   public FObjects<FResAnimation> animations(){
      return _animations;
   }

   //============================================================
   // <T>增加一个动画。</T>
   //
   // @param animation 动画
   //============================================================
   public void pushAnimation(FResAnimation animation){
      if(_animations == null){
         _animations = new FObjects<FResAnimation>(FResAnimation.class);
      }
      _animations.push(animation);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出网格集合
      if(_meshs != null){
         int count = _meshs.count();
         output.writeInt16((short)count);
         for(int i = 0; i < count; i++){
            FResModelMesh mesh = _meshs.get(i);
            mesh.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
      // 输出骨骼集合
      if(_skeletons != null){
         int count = _skeletons.count();
         output.writeInt16((short)count);
         for(int i = 0; i < count; i++){
            FResSkeleton skeleton = _skeletons.get(i);
            skeleton.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
      // 输出动画集合
      if(_animations != null){
         int count = _animations.count();
         output.writeInt16((short)count);
         for(int i = 0; i < count; i++){
            FResAnimation animation = _animations.get(i);
            animation.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
      // 输出显示对象
      _display.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 存储显示对象
      FXmlNode xdisplay = xconfig.findNode("ModelDisplay");
      if(xdisplay != null){
         _display.loadConfig(xdisplay);
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
      // 存储显示对象
      _display.saveConfig(xconfig.createNode("ModelDisplay"));
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResourceModelUnit unit){
      // 读取配置
      if(!RString.isEmpty(unit.content())){
         FXmlDocument xdocument = new FXmlDocument();
         xdocument.loadString(unit.content());
         loadConfig(xdocument.root());
      }
      // 读取属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _fullCode = unit.fullCode();
      _code = unit.code();
      _label = unit.label();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResourceModelUnit unit){
      // 存储属性
      unit.setFullCode(fullCode());
      unit.setCode(_code);
      unit.setLabel(_label);
      // 存储配置
      FXmlNode xconfig = new FXmlNode("Model");
      saveConfig(xconfig);
      unit.setContent(xconfig.xml().toString());
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void build(){
      if(_display.hasRenderable()){
         _display.renderables().clear();
      }
      if(hasMesh()){
         for(FResModelMesh mesh : _meshs){
            // 构建处理
            mesh.build();
            // 建立渲染信息
            FResModelRenderable renderable = new FResModelRenderable();
            renderable.setMeshGuid(mesh.guid());
            _display.pushRenderable(renderable);
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void importData(IDataInput input){
      super.importData(input);
      _fullCode = input.readString();
      _label = input.readString();
      _keywords = input.readString();
      // 读取网格集合
      int meshCount = input.readInt32();
      for(int n = 0; n < meshCount; n++){
         FResModelMesh mesh = new FResModelMesh();
         mesh.setModel(this);
         mesh.importData(input);
         pushMesh(mesh);
      }
      // 构建处理
      build();
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
      FXmlNode xdisplay = xconfig.findNode("ModelDisplay");
      if(xdisplay != null){
         _display.mergeConfig(xdisplay);
      }
   }
}
