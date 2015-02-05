package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源3D蒙皮。</T>
//============================================================
public class FRs3SkeletonSkin
      extends FRs3Obejct
{
   // 网格唯一编号
   protected String _meshGuid;

   // 数据流集合
   protected FObjects<FRs3Stream> _streams;

   // 骨头引用集合
   protected FObjects<FRs3BoneRefer> _boneRefers;

   //============================================================
   // <T>构造资源3D蒙皮。</T>
   //============================================================
   public FRs3SkeletonSkin(){
   }

   //============================================================
   // <T>获得网格唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public String meshGuid(){
      return _meshGuid;
   }

   //============================================================
   // <T>设置网格唯一编号。</T>
   //
   // @param meshGuid 唯一编号
   //============================================================
   public void setMeshGuid(String meshGuid){
      _meshGuid = meshGuid;
   }

   //============================================================
   // <T>获得数据流集合。</T>
   //
   // @return 数据流集合
   //============================================================
   public FObjects<FRs3Stream> streams(){
      return _streams;
   }

   //============================================================
   // <T>增加一个数据流。</T>
   //
   // @param stream 数据流
   //============================================================
   public void pushStream(FRs3Stream stream){
      if(_streams == null){
         _streams = new FObjects<FRs3Stream>(FRs3Stream.class);
      }
      _streams.push(stream);
   }

   //============================================================
   // <T>增加一个骨头引用。</T>
   //
   // @param boneRefer 骨头引用
   //============================================================
   public void pushBoneRefer(FRs3BoneRefer boneRefer){
      if(_boneRefers == null){
         _boneRefers = new FObjects<FRs3BoneRefer>(FRs3BoneRefer.class);
      }
      _boneRefers.push(boneRefer);
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
      output.writeString(_meshGuid);
      // 存储属性流集合
      if(_streams != null){
         output.writeUint8((short)_streams.count());
         for(FRs3Stream stream : _streams){
            stream.serialize(output);
         }
      }else{
         output.writeUint8((short)0);
      }
      // 存储骨头引用集合
      if(_boneRefers != null){
         output.writeUint8((short)_boneRefers.count());
         for(FRs3BoneRefer boneRefer : _boneRefers){
            boneRefer.serialize(output);
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
      // 读取骨头集合
      FXmlNode xboneRefers = xconfig.findNode("BoneReferCollection");
      if(xboneRefers != null){
         for(FXmlNode xbone : xboneRefers.nodes()){
            if(xbone.isName("BoneRefer")){
               FRs3BoneRefer boneRefer = new FRs3BoneRefer();
               boneRefer.loadConfig(xbone);
               pushBoneRefer(boneRefer);
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
      xconfig.set("code", _code);
      // 存储骨头引用集合
      FXmlNode xboneRefers = xconfig.createNode("BoneReferCollection");
      if(_boneRefers != null){
         for(FRs3BoneRefer boneRefer : _boneRefers){
            boneRefer.saveConfig(xboneRefers.createNode("BoneRefer"));
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
      // 读取数据流集合
      int streamCount = input.readInt32();
      for(int n = 0; n < streamCount; n++){
         FRs3Stream stream = new FRs3Stream();
         stream.importData(input);
         pushStream(stream);
      }
      // 读取数据流集合
      int boneCount = input.readInt32();
      for(int n = 0; n < boneCount; n++){
         FRs3BoneRefer boneRefer = new FRs3BoneRefer();
         boneRefer.importData(input);
         pushBoneRefer(boneRefer);
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dSkeletonSkinUnit unit){
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
      // 加载配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      this.loadConfig(xdocument.root());
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dSkeletonSkinUnit unit){
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
      FXmlNode xconfig = new FXmlNode("Skin");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }
}
