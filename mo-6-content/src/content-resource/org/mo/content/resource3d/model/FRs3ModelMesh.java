package org.mo.content.resource3d.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.content.resource3d.common.SFloatOutline3;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3ModelMesh
      extends FRs3Object
{
   // 模型
   protected FRs3Model _model;

   // 轮廓
   protected SFloatOutline3 _outline = new SFloatOutline3();

   // 数据流集合
   protected FObjects<FRs3Stream> _streams = new FObjects<FRs3Stream>(FRs3Stream.class);

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
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   public String fullCode(){
      return _model.code() + "|" + _code;
   }

   //============================================================
   // <T>获得轮廓。</T>
   //
   // @return 轮廓
   //============================================================
   public SFloatOutline3 outline(){
      return _outline;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3Stream> streams(){
      return _streams;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 输出属性
      super.serialize(output);
      // 输出轮廓
      _outline.serialize(output);
      // 输出数据流集合
      int streamCount = _streams.count();
      output.writeInt8((byte)streamCount);
      for(int i = 0; i < streamCount; i++){
         FRs3Stream stream = _streams.get(i);
         stream.serialize(output);
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
      // 读取轮廓
      _outline.unserialize(input);
      // 读取数据流集合
      int count = input.readInt32();
      for(int n = 0; n < count; n++){
         FRs3ModelStream stream = new FRs3ModelStream();
         stream.setMesh(this);
         stream.importData(input);
         _streams.push(stream);
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dMeshUnit unit){
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
      _outline.min.parse(unit.outlineMin());
      _outline.max.parse(unit.outlineMax());
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dMeshUnit unit){
      unit.setFullCode(fullCode());
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setOutlineMin(_outline.min.toString());
      unit.setOutlineMax(_outline.max.toString());
   }
}
