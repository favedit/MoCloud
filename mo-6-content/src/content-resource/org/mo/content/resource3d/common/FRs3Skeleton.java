package org.mo.content.resource3d.common;

import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源3D骨骼。</T>
//============================================================
public class FRs3Skeleton
      extends FRs3Resource
{
   // 骨头集合
   protected FObjects<FRs3Bone> _bones;

   // 蒙皮集合
   protected FObjects<FRs3SkeletonSkin> _skins;

   //============================================================
   // <T>构造资源3D骨骼。</T>
   //============================================================
   public FRs3Skeleton(){
   }

   //============================================================
   // <T>获得骨头集合。</T>
   //
   // @return 骨头集合
   //============================================================
   public FObjects<FRs3Bone> bones(){
      return _bones;
   }

   //============================================================
   // <T>增加一个骨头。</T>
   //
   // @param bone 骨头
   //============================================================
   public void pushBone(FRs3Bone bone){
      if(_bones == null){
         _bones = new FObjects<FRs3Bone>(FRs3Bone.class);
      }
      _bones.push(bone);
   }

   //============================================================
   // <T>获得蒙皮集合。</T>
   //
   // @return 蒙皮集合
   //============================================================
   public FObjects<FRs3SkeletonSkin> skins(){
      return _skins;
   }

   //============================================================
   // <T>增加一个蒙皮。</T>
   //
   // @param skin 蒙皮
   //============================================================
   public void pushSkin(FRs3SkeletonSkin skin){
      if(_skins == null){
         _skins = new FObjects<FRs3SkeletonSkin>(FRs3SkeletonSkin.class);
      }
      _skins.push(skin);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储骨头集合
      if(_bones != null){
         output.writeUint8((short)_bones.count());
         for(FRs3Bone bone : _bones){
            bone.serialize(output);
         }
      }else{
         output.writeUint8((short)0);
      }
      // 存储蒙皮集合
      if(_skins != null){
         output.writeUint8((short)_skins.count());
         for(FRs3SkeletonSkin skin : _skins){
            skin.serialize(output);
         }
      }else{
         output.writeUint8((short)0);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取骨头集合
      FXmlNode xbones = xconfig.findNode("BoneCollection");
      if(xbones != null){
         for(FXmlNode xbone : xbones.nodes()){
            if(xbone.isName("Bone")){
               FRs3Bone bone = new FRs3Bone();
               bone.loadConfig(xbone);
               pushBone(bone);
            }
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
      // 存储骨头集合
      FXmlNode xbones = xconfig.createNode("BoneCollection");
      if(_bones != null){
         for(FRs3Bone bone : _bones){
            bone.saveConfig(xbones.createNode("Bone"));
         }
      }
      // 存储蒙皮集合
      FXmlNode xskins = xconfig.createNode("SkinCollection");
      if(_skins != null){
         for(FRs3SkeletonSkin skin : _skins){
            skin.saveConfig(xskins.createNode("Skin"));
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
      _code = input.readString();
      // 读取骨头集合
      int boneCount = input.readInt32();
      for(int n = 0; n < boneCount; n++){
         FRs3Bone bone = new FRs3Bone();
         bone.importData(input);
         pushBone(bone);
      }
      // 读取蒙皮集合
      int skinCount = input.readInt32();
      for(int n = 0; n < skinCount; n++){
         FRs3SkeletonSkin skin = new FRs3SkeletonSkin();
         skin.importData(input);
         pushSkin(skin);
      }
      //System.out.println(dump());
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FGcResModelSkeletonInfo unit){
      // 加载配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      loadConfig(xdocument.root());
      // 加载属性
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
   public void saveUnit(FGcResModelSkeletonInfo unit){
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setContent(toXml());
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Skeleton");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public String dump(){
      TDumpInfo info = new TDumpInfo();
      // 读取骨头集合
      if(_bones != null){
         for(FRs3Bone bone : _bones){
            bone.dump(info);
         }
      }
      return info.toString();
   }

   //============================================================
   // <T>加载文件数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void importFile(String fileName){
      try(FByteFile file = new FByteFile(fileName)){
         importData(file);
      }
   }
}
