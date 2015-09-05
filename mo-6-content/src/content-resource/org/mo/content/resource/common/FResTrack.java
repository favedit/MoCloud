package org.mo.content.resource.common;

import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationTrackInfo;

import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.content.geom.common.SFloatMatrix3d;

//============================================================
// <T>资源精灵。</T>
//============================================================
public class FResTrack
      extends FResObject
{
   // 网格代码
   protected String _meshCode;

   // 骨头索引
   protected int _boneIndex;

   // 帧间隔
   protected int _frameTick;

   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   // 帧集合
   protected FObjects<FResFrame> _frames = new FObjects<FResFrame>(FResFrame.class);

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FResTrack(){
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
   // <T>获得帧集合。</T>
   //
   // @return 帧集合
   //============================================================
   public FObjects<FResFrame> frames(){
      return _frames;
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
      // 存储所有帧索引信息
      int frameCount = _frames.count();
      output.writeUint16(frameCount);
      for(int n = 0; n < frameCount; n++){
         FResFrame frame = _frames.get(n);
         //frame.serialize(output);
         output.writeUint16(frame.frameTranslate().index());
         output.writeUint16(frame.frameRotation().index());
         output.writeUint16(frame.frameScale().index());
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize2(IDataOutput output,
                          int translateBytes,
                          int rotationBytes,
                          int scaleBytes){
      // 读取属性
      output.writeString(_meshCode);
      output.writeUint16(_boneIndex);
      output.writeUint16(_frameTick);
      _matrix.serialize(output);
      // 存储所有帧索引信息
      int frameCount = _frames.count();
      output.writeUint16(frameCount);
      for(int n = 0; n < frameCount; n++){
         FResFrame frame = _frames.get(n);
         // 输出位移索引
         int translateIndex = frame.frameTranslate().index();
         if(translateBytes == 4){
            output.writeUint32(translateIndex);
         }else if(translateBytes == 2){
            output.writeUint16(translateIndex);
         }else{
            output.writeUint8((short)translateIndex);
         }
         // 输出旋转索引
         int rotationIndex = frame.frameRotation().index();
         if(rotationBytes == 4){
            output.writeUint32(rotationIndex);
         }else if(rotationBytes == 2){
            output.writeUint16(rotationIndex);
         }else{
            output.writeUint8((short)rotationIndex);
         }
         // 输出缩放索引
         int scaleIndex = frame.frameScale().index();
         if(scaleBytes == 4){
            output.writeUint32(scaleIndex);
         }else if(scaleBytes == 2){
            output.writeUint16(scaleIndex);
         }else{
            output.writeUint8((short)scaleIndex);
         }
      }
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void loadData(IDataInput input){
      // 读取属性
      _meshCode = input.readString();
      _boneIndex = input.readInt32();
      _frameTick = input.readInt32();
      _matrix.unserialize(input);
      // 读取所有帧信息
      int frameCount = input.readInt32();
      for(int n = 0; n < frameCount; n++){
         FResFrame frame = new FResFrame();
         frame.loadData(input);
         _frames.push(frame);
      }
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param data 数据 
   //============================================================
   public void loadData(byte[] data){
      loadData(new FByteStream(data));
   }

   //============================================================
   // <T>保存数据。</T>
   //
   // @param output 输出流
   //============================================================
   public void saveData(IDataOutput output){
      // 读取属性
      output.writeString(_meshCode);
      output.writeInt32(_boneIndex);
      output.writeInt32(_frameTick);
      _matrix.serialize(output);
      // 读取所有帧信息
      int frameCount = _frames.count();
      output.writeInt32(frameCount);
      for(int n = 0; n < frameCount; n++){
         FResFrame frame = _frames.get(n);
         frame.saveData(output);
      }
   }

   //============================================================
   // <T>保存数据。</T>
   //
   // @return 数据 
   //============================================================
   public byte[] saveData(){
      FByteStream stream = new FByteStream();
      saveData(stream);
      return stream.toArray();
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FGcResModelAnimationTrackInfo unit){
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
   public void saveUnit(FGcResModelAnimationTrackInfo unit){
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setFrameCount(_frames.count());
      unit.setFrameTick(_frameTick);
      unit.setFrameTotal(_frameTick * _frames.count());
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
         FResFrame frame = new FResFrame();
         frame.importData(input);
         _frames.push(frame);
      }
   }
}
