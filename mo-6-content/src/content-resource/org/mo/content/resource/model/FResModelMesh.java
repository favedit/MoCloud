package org.mo.content.resource.model;

import org.mo.content.resource.common.FResGeometry;

import com.cyou.gccloud.data.data.FDataResourceModelMeshUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FResModelMesh
      extends FResGeometry
{
   // 模型
   protected FResModel _model;

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FResModelMesh(){
      _typeName = "ModelMesh";
   }

   //============================================================
   // <T>获得模型。</T>
   //
   // @return 模型
   //============================================================
   public FResModel model(){
      return _model;
   }

   //============================================================
   // <T>设置模型。</T>
   //
   // @param model 模型
   //============================================================
   public void setModel(FResModel model){
      _model = model;
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   @Override
   public String fullCode(){
      if(_model != null){
         return _model.code() + "|" + _code;
      }
      return _code;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResourceModelMeshUnit unit){
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
   public void saveUnit(FDataResourceModelMeshUnit unit){
      unit.setFullCode(fullCode());
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setOutlineMin(_outline.min.toString());
      unit.setOutlineMax(_outline.max.toString());
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
         FResModelStream stream = new FResModelStream();
         stream.setMesh(this);
         stream.importData(input);
         pushStream(stream);
      }
   }
}
