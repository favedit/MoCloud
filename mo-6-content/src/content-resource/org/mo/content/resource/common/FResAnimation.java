package org.mo.content.resource.common;

import java.text.DecimalFormat;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.content.geom.common.SFloatMatrixQuat;

//============================================================
// <T>资源3D动画精灵。</T>
//============================================================
public class FResAnimation
      extends FResResource
{
   // 位置格式器
   public static DecimalFormat FormatTranslate = new DecimalFormat("0.0000");

   // 旋转格式器
   public static DecimalFormat FormatRotation = new DecimalFormat("0.00");

   // 缩放格式器
   public static DecimalFormat FormatScale = new DecimalFormat("0.00");

   // 骨骼唯一编号
   protected String _skeletonGuid;

   // 帧总长
   protected int _frameCount;

   // 帧间隔
   protected int _frameTick;

   // 帧总数
   protected int _frameSpan;

   // 跟踪集合
   protected FObjects<FResTrack> _tracks;

   // 帧缩放字典
   protected FDictionary<FResFrameTranslate> _frameTranslates = new FDictionary<FResFrameTranslate>(FResFrameTranslate.class);

   // 帧旋转字典
   protected FDictionary<FResFrameRotation> _frameRotations = new FDictionary<FResFrameRotation>(FResFrameRotation.class);

   // 帧缩放字典
   protected FDictionary<FResFrameScale> _frameScales = new FDictionary<FResFrameScale>(FResFrameScale.class);

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FResAnimation(){
      _typeName = "Animation";
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
   public FObjects<FResTrack> tracks(){
      return _tracks;
   }

   //============================================================
   // <T>增加一个跟踪。</T>
   //
   // @param track 跟踪
   //============================================================
   public void pushTrack(FResTrack track){
      if(_tracks == null){
         _tracks = new FObjects<FResTrack>(FResTrack.class);
      }
      _tracks.push(track);
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
      //............................................................
      // 存储所有帧平移信息
      int translateCount = _frameTranslates.count();
      int translateBytes = RInteger.strideByte(translateCount);
      output.writeUint32(translateCount);
      for(int n = 0; n < translateCount; n++){
         FResFrameTranslate translate = _frameTranslates.value(n);
         translate.serialize(output);
      }
      // 存储所有帧旋转信息
      int rotationCount = _frameRotations.count();
      int rotationBytes = RInteger.strideByte(rotationCount);
      output.writeUint32(rotationCount);
      for(int n = 0; n < rotationCount; n++){
         FResFrameRotation rotation = _frameRotations.value(n);
         rotation.serialize(output);
      }
      // 存储所有帧缩放信息
      int scaleCount = _frameScales.count();
      int scaleBytes = RInteger.strideByte(scaleCount);
      output.writeUint32(scaleCount);
      for(int n = 0; n < scaleCount; n++){
         FResFrameScale scale = _frameScales.value(n);
         scale.serialize(output);
      }
      //............................................................
      // 输出跟踪集合
      if(_tracks != null){
         output.writeInt16((short)_tracks.count());
         for(FResTrack track : _tracks){
            track.serialize2(output, translateBytes, rotationBytes, scaleBytes);
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
   public void loadUnit(FGcResModelAnimationInfo info){
      // 加载属性
      _ouid = info.ouid();
      _guid = info.guid();
      _code = info.code();
      _label = info.label();
      _frameCount = info.frameCount();
      _frameTick = info.frameTick();
      _frameSpan = info.frameSpan();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FGcResModelAnimationInfo info){
      info.setCode(_code);
      info.setLabel(_label);
      info.setFrameCount(_frameCount);
      info.setFrameTick(_frameTick);
      info.setFrameSpan(_frameSpan);
   }

   //============================================================
   // <T>打包数据。</T>
   //============================================================
   public void pack(){
      // 清空字典
      _frameTranslates.clear();
      _frameRotations.clear();
      _frameScales.clear();
      for(FResTrack track : _tracks){
         // 建立帧
         for(FResFrame frame : track.frames()){
            SFloatMatrixQuat matrix = frame.matrix();
            // 设置帧平移
            String translateFlag = FormatTranslate.format(matrix.tx) + "|" + FormatTranslate.format(matrix.ty) + "|" + FormatTranslate.format(matrix.tz);
            FResFrameTranslate translate = _frameTranslates.find(translateFlag);
            if(translate == null){
               translate = new FResFrameTranslate();
               translate.setIndex(_frameTranslates.count());
               translate.data().set(matrix.tx, matrix.ty, matrix.tz);
               _frameTranslates.set(translateFlag, translate);
            }
            frame.setFrameTranslate(translate);
            // 设置帧平移
            String rotationFlag = FormatRotation.format(matrix.qx) + "|" + FormatRotation.format(matrix.qy) + "|" + FormatRotation.format(matrix.qz) + "|" + FormatRotation.format(matrix.qw);
            FResFrameRotation rotation = _frameRotations.find(rotationFlag);
            if(rotation == null){
               rotation = new FResFrameRotation();
               rotation.setIndex(_frameRotations.count());
               rotation.data().set(matrix.qx, matrix.qy, matrix.qz, matrix.qw);
               _frameRotations.set(rotationFlag, rotation);
            }
            frame.setFrameRotation(rotation);
            // 设置帧缩放 
            String scaleFlag = FormatScale.format(matrix.sx) + "|" + FormatScale.format(matrix.sy) + "|" + FormatScale.format(matrix.sz);
            FResFrameScale scale = _frameScales.find(scaleFlag);
            if(scale == null){
               scale = new FResFrameScale();
               scale.setIndex(_frameScales.count());
               scale.data().set(matrix.sx, matrix.sy, matrix.sz);
               _frameScales.set(scaleFlag, scale);
            }
            frame.setFrameScale(scale);
         }
      }
   }

   //============================================================
   // <T>从输入流中导入数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _frameCount = input.readInt32();
      _frameTick = input.readInt32();
      _frameSpan = input.readInt32();
      // 读取骨头集合
      int trackCount = input.readInt32();
      for(int n = 0; n < trackCount; n++){
         FResTrack track = new FResTrack();
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
