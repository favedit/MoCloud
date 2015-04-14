package org.mo.content.resource3d.model;

import org.mo.content.resource3d.mesh.FRs3MeshDisplay;

import com.cyou.gccloud.data.data.FDataResourceModelUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3Space;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Model
      extends FRs3Space
{
   // 网格集合
   protected FObjects<FRs3ModelMesh> _meshs;

   // 骨骼集合
   protected FObjects<FRs3Skeleton> _skeletons;

   // 动画集合
   protected FObjects<FRs3Animation> _animations;

   // 显示对象
   protected FRs3MeshDisplay _display = new FRs3MeshDisplay();

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Model(){
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
   public FObjects<FRs3ModelMesh> meshs(){
      return _meshs;
   }

   //============================================================
   // <T>增加一个网格。</T>
   //
   // @param mesh 网格
   //============================================================
   public void pushMesh(FRs3ModelMesh mesh){
      if(_meshs == null){
         _meshs = new FObjects<FRs3ModelMesh>(FRs3ModelMesh.class);
      }
      _meshs.push(mesh);
   }

   //============================================================
   // <T>获得骨骼集合。</T>
   //
   // @return 骨骼集合
   //============================================================
   public FObjects<FRs3Skeleton> skeletons(){
      if(_skeletons == null){
         _skeletons = new FObjects<FRs3Skeleton>(FRs3Skeleton.class);
      }
      return _skeletons;
   }

   //============================================================
   // <T>获得动画集合。</T>
   //
   // @return 动画集合
   //============================================================
   public FObjects<FRs3Animation> animations(){
      if(_animations == null){
         _animations = new FObjects<FRs3Animation>(FRs3Animation.class);
      }
      return _animations;
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
            FRs3ModelMesh mesh = _meshs.get(i);
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
            FRs3Skeleton skeleton = _skeletons.get(i);
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
            FRs3Animation animation = _animations.get(i);
            animation.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
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
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.setModel(this);
         mesh.importData(input);
         meshs().push(mesh);
      }
   }
}
