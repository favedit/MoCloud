package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResource3dAnimationUnit;
import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;

//============================================================
// <T>资源3D动画精灵。</T>
//============================================================
public class FRs3Animation
      extends FRs3Resource
{
   // 骨骼唯一编号
   protected String _skeletonGuid;

   // 帧总长
   protected int _frameCount;

   // 帧间隔
   protected int _frameTick;

   // 帧总数
   protected int _frameSpan;

   // 跟踪集合
   protected FObjects<FRs3Track> _tracks;

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FRs3Animation(){
   }

   //============================================================
   // <T>获得骨骼唯一编号。</T>
   //
   // @return 骨骼唯一编号
   //============================================================
   public String skeletonGuid(){
      return _skeletonGuid;
   }

   //============================================================
   // <T>设置骨骼唯一编号。</T>
   //
   // @param skeletonGuid 骨骼唯一编号
   //============================================================
   public void setSkeletonGuid(String skeletonGuid){
      _skeletonGuid = skeletonGuid;
   }

   //============================================================
   // <T>获得跟踪集合。</T>
   //
   // @return 跟踪集合
   //============================================================
   public FObjects<FRs3Track> tracks(){
      if(_tracks == null){
         _tracks = new FObjects<FRs3Track>(FRs3Track.class);
      }
      return _tracks;
   }

   //============================================================
   // <T>增加一个跟踪。</T>
   //
   // @param track 跟踪
   //============================================================
   public void pushTrack(FRs3Track track){
      tracks().push(track);
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
      output.writeString(_skeletonGuid);
      output.writeUint16(_frameCount);
      output.writeUint16(_frameTick);
      output.writeInt32(_frameSpan);
      // 输出跟踪集合
      if(_tracks != null){
         output.writeInt16((short)_tracks.count());
         for(FRs3Track track : _tracks){
            byte[] trackData = track.data();
            if(trackData != null){
               output.write(trackData, 0, trackData.length);
            }else{
               track.serialize(output);
            }
         }
      }else{
         output.writeInt16((short)0);
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dAnimationUnit unit){
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
      _frameCount = unit.frameCount();
      _frameTick = unit.frameTick();
      _frameSpan = unit.frameSpan();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dAnimationUnit unit){
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setFrameCount(_frameCount);
      unit.setFrameTick(_frameTick);
      unit.setFrameSpan(_frameSpan);
   }

   //============================================================
   // <T>从输入流中导入数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _frameCount = input.readInt32();
      _frameTick = input.readInt32();
      _frameSpan = input.readInt32();
      // 读取骨头集合
      int trackCount = input.readInt32();
      for(int n = 0; n < trackCount; n++){
         FRs3Track track = new FRs3Track();
         track.importData(input);
         pushTrack(track);
      }
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
