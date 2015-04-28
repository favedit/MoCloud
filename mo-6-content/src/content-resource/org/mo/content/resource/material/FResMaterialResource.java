package org.mo.content.resource.material;

import org.mo.com.io.IDataOutput;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.common.FResResource;

//============================================================
// <T>资源材质资源。</T>
//============================================================
public class FResMaterialResource
      extends FResResource
{
   // 材质
   protected FResMaterial _material;

   //============================================================
   // <T>构造资源材质资源。</T>
   //============================================================
   public FResMaterialResource(){
   }

   //============================================================
   // <T>获得材质。</T>
   //
   // @return 材质
   //============================================================
   public FResMaterial material(){
      return _material;
   }

   //============================================================
   // <T>设置材质。</T>
   //
   // @param material 材质
   //============================================================
   public void setMaterial(FResMaterial material){
      _material = material;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储材质
      _material.serialize(output);
   }
}
