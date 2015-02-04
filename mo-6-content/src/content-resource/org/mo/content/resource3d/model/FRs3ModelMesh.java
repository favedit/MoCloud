package org.mo.content.resource3d.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.content.resource3d.common.FRs3Track;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3ModelMesh
      extends FObject
{
   // 模型
   protected FRs3Model _model;

   // 唯一编号
   protected String _guid;

   // 代码
   protected String _code;

   // 数据流集合
   protected FObjects<FRs3ModelStream> _streams = new FObjects<FRs3ModelStream>(FRs3ModelStream.class);

   // 骨头集合
   protected FObjects<FRs3ModelMeshBone> _bones = new FObjects<FRs3ModelMeshBone>(FRs3ModelMeshBone.class);

   // 跟踪集合
   protected FObjects<FRs3Track> _tracks = new FObjects<FRs3Track>(FRs3Track.class);

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FRs3ModelMesh(){
   }

   //============================================================
   // <T>获得模型。</T>
   //
   // @return 模型
   //============================================================
   public FRs3Model model(){
      return _model;
   }

   //============================================================
   // <T>设置模型。</T>
   //
   // @param model 模型
   //============================================================
   public void setModel(FRs3Model model){
      _model = model;
   }

   //============================================================
   // <T>获得唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public String _guid(){
      return _guid;
   }

   //============================================================
   // <T>设置唯一编号。</T>
   //
   // @param guid 唯一编号
   //============================================================
   public void setGuid(String guid){
      _guid = guid;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   public String fullCode(){
      return _model.code() + "|" + _code;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3ModelStream> streams(){
      return _streams;
   }

   //============================================================
   // <T>获得骨头集合。</T>
   //
   // @return 骨头集合
   //============================================================
   public FObjects<FRs3ModelMeshBone> bones(){
      return _bones;
   }

   //============================================================
   // <T>获得跟踪集合。</T>
   //
   // @return 跟踪集合
   //============================================================
   public FObjects<FRs3Track> tracks(){
      return _tracks;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出属性
      output.writeString(_guid);
      // 输出数据流集合
      int streamCount = _streams.count();
      output.writeInt8((byte)streamCount);
      for(int i = 0; i < streamCount; i++){
         FRs3ModelStream stream = _streams.get(i);
         stream.serialize(output);
      }
      // 输出跟踪集合
      int trackCount = _tracks.count();
      output.writeInt8((byte)trackCount);
      for(int i = 0; i < trackCount; i++){
         FRs3Track track = _tracks.get(i);
         output.write(track.data(), 0, track.data().length);
         //track.serialize(output);
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取数据流集合
      int count = input.readInt16();
      for(int n = 0; n < count; n++){
         FRs3ModelStream stream = new FRs3ModelStream();
         stream.setMesh(this);
         stream.unserialize(input);
         _streams.push(stream);
      }
      // 读取骨头集合
      int boneCount = input.readInt32();
      for(int n = 0; n < boneCount; n++){
         FRs3ModelMeshBone bone = new FRs3ModelMeshBone();
         bone.unserialize(input);
         _bones.push(bone);
      }
      // 读取跟踪
      if(input.readBoolean()){
         FRs3Track track = new FRs3Track();
         track.unserialize(input);
         _tracks.push(track);
      }
   }
}
