package org.mo.content.resource.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源3D骨头。</T>
//============================================================
public class FResBone
      extends FObject
{
   // 索引位置
   protected int _index;

   // 子骨头集合
   protected FObjects<FResBone> _bones;

   //============================================================
   // <T>构造资源3D骨头。</T>
   //============================================================
   public FResBone(){
   }

   //============================================================
   // <T>增加一个子骨头。</T>
   //
   // @param bone 子骨头
   //============================================================
   public void pushBone(FResBone bone){
      if(_bones == null){
         _bones = new FObjects<FResBone>(FResBone.class);
      }
      _bones.push(bone);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 存储属性
      output.writeUint8((short)_index);
      // 输出子骨头集合
      if(_bones != null){
         output.writeUint8((short)_bones.count());
         for(FResBone bone : _bones){
            bone.serialize(output);
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
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _index = xconfig.getInt("index");
      // 存储子骨头集合
      if(xconfig.hasNode()){
         for(FXmlNode xnode : xconfig.nodes()){
            if(xnode.isName("Bone")){
               FResBone bone = new FResBone();
               bone.loadConfig(xnode);
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("index", _index);
      // 存储子骨头集合
      if(_bones != null){
         for(FResBone bone : _bones){
            bone.saveConfig(xconfig.createNode("Bone"));
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
      _index = input.readInt32();
      // 读取子骨头集合
      int count = input.readInt32();
      for(int n = 0; n < count; n++){
         FResBone bone = new FResBone();
         bone.importData(input);
         pushBone(bone);
      }
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.appendLine();
      info.appendRepeat("   ", info.level());
      info.append("id: " + RInteger.format(_index, 2));
      // 读取子骨头集合
      if(_bones != null){
         for(FResBone bone : _bones){
            info.increaseLevel(this);
            bone.dump(info);
            info.decreaseLevel();
         }
      }
      return info;
   }
}
