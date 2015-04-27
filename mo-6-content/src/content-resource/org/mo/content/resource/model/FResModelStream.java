package org.mo.content.resource.model;

import org.mo.content.resource.common.FResStream;

//============================================================
// <T>资源模型数据流。</T>
//============================================================
public class FResModelStream
      extends FResStream
{
   // 网格
   protected FResModelMesh _mesh;

   //============================================================
   // <T>构造资源模型数据流。</T>
   //============================================================
   public FResModelStream(){
      _typeName = "ModelStream";
   }

   //============================================================
   // <T>获得网格。</T>
   //
   // @return 网格
   //============================================================
   public FResModelMesh mesh(){
      return _mesh;
   }

   //============================================================
   // <T>设置网格。</T>
   //
   // @param mesh 网格
   //============================================================
   public void setMesh(FResModelMesh mesh){
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
