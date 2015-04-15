package org.mo.content.resource3d.model;

import org.mo.content.resource3d.common.FRs3Stream;

//============================================================
// <T>资源模型数据流。</T>
//============================================================
public class FRs3ModelStream
      extends FRs3Stream
{
   // 网格
   protected FRs3ModelMesh _mesh;

   //============================================================
   // <T>构造资源模型数据流。</T>
   //============================================================
   public FRs3ModelStream(){
      _typeName = "ModelStream";
   }

   //============================================================
   // <T>获得网格。</T>
   //
   // @return 网格
   //============================================================
   public FRs3ModelMesh mesh(){
      return _mesh;
   }

   //============================================================
   // <T>设置网格。</T>
   //
   // @param mesh 网格
   //============================================================
   public void setMesh(FRs3ModelMesh mesh){
      _mesh = mesh;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   @Override
   public String fullCode(){
      return _mesh.fullCode() + "|" + _code;
   }
}
