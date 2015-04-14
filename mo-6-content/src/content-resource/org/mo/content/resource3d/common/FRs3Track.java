package org.mo.content.resource3d.common;

import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.common.SFloatMatrix3d;

//============================================================
// <T>资源精灵。</T>
//============================================================
public class FRs3Track
      extends FRs3Object
{
   // 网格代码
   protected String _meshCode;

   // 骨头索引
   protected int _boneIndex;

   // 帧间隔
   protected int _frameTick;

   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   // 数据长度
   protected byte[] _data;

   protected FObjects<FRs3Frame> _frames = new FObjects<FRs3Frame>(FRs3Frame.class);

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FRs3Track(){
   }

   //============================================================
   // <T>获得网格代码。</T>
   //
   // @return 网格代码
   //============================================================
   public String meshCode(){
      return _meshCode;
   }

   //============================================================
   // <T>获得骨头索引。</T>
   //
   // @return 骨头索引
   //============================================================
   public int boneIndex(){
      return _boneIndex;
   }

   //============================================================
   // <T>获得帧间隔。</T>
   //
   // @return 帧间隔
   //============================================================
   public int frameTick(){
      return _frameTick;
   }

   //============================================================
   // <T>获得帧个数。</T>
   //
   // @return 帧个数
   //============================================================
   public int frameCount(){
      return _frames.count();
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] data(){
      return _data;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param data 代码
   //============================================================
   public void setData(byte[] data){
      _data = data;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 读取属性
      output.writeString(_meshCode);
      output.writeUint8((short)_boneIndex);
      output.writeUint16(_frameTick);
      _matrix.serialize(output);
      // 读取所有帧信息
      int frameCount = _frames.count();
      output.writeUint16(frameCount);
      for(int n = 0; n < frameCount; n++){
         FRs3Frame frame = _frames.get(n);
         frame.serialize(output);
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _meshCode = input.readString();
      _boneIndex = input.readInt32();
      _frameTick = input.readInt32();
      _matrix.unserialize(input);
      // 读取所有帧信息
      int frameCount = input.readInt32();
      for(int n = 0; n < frameCount; n++){
         FRs3Frame frame = new FRs3Frame();
         frame.unserialize(input);
         _frames.push(frame);
      }
   }

   //============================================================
   // <T>从输入流中导入数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _meshCode = input.readString();
      _boneIndex = input.readInt32();
      _frameTick = input.readInt32();
      _matrix.unserialize(input);
      // 读取所有帧信息
      int frameCount = input.readInt32();
      for(int n = 0; n < frameCount; n++){
         FRs3Frame frame = new FRs3Frame();
         frame.importData(input);
         _frames.push(frame);
      }
   }

   //   //============================================================
   //   // <T>从数据单元中导入配置。</T>
   //   //
   //   // @param unit 数据单元
   //   //============================================================
   //   public void loadUnit(FDataResource3dTrackUnit unit){
   //      // 加载属性
   //      _ouid = unit.ouid();
   //      _guid = unit.guid();
   //      _code = unit.code();
   //      _label = unit.label();
   //   }
   //
   //   //============================================================
   //   // <T>将配置信息存入数据单元中。</T>
   //   //
   //   // @param unit 数据单元
   //   //============================================================
   //   public void saveUnit(FDataResource3dTrackUnit unit){
   //      unit.setCode(_code);
   //      unit.setLabel(_label);
   //      unit.setFrameCount(_frames.count());
   //      unit.setFrameTick(_frameTick);
   //      unit.setFrameTotal(_frameTick * _frames.count());
   //   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] toArray(){
      FByteStream stream = new FByteStream();
      serialize(stream);
      return stream.toArray();
   }
}
