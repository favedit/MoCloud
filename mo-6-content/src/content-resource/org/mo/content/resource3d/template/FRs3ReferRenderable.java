package org.mo.content.resource3d.template;

import org.mo.content.resource3d.common.FRs3Drawable;

//============================================================
// <T>资源渲染对象。</T>
//============================================================
public class FRs3ReferRenderable
      extends FRs3Drawable
{
   // 网格唯一编号
   protected String _meshGuid;

   // 材质唯一编号
   protected String _materialGuid;

   //============================================================
   // <T>构造资源渲染对象。</T>
   //============================================================
   public FRs3ReferRenderable(){
   }

   //============================================================
   // <T>获得网格唯一编号。</T>
   //
   // @return 网格唯一编号
   //============================================================
   public String meshGuid(){
      return _meshGuid;
   }

   //============================================================
   // <T>设置网格唯一编号。</T>
   //
   // @return 网格唯一编号
   //============================================================
   public void setMeshGuid(String meshGuid){
      _meshGuid = meshGuid;
   }

   //============================================================
   // <T>获得材质唯一编号。</T>
   //
   // @return 材质唯一编号
   //============================================================
   public String materialGuid(){
      return _materialGuid;
   }

   //============================================================
   // <T>设置材质唯一编号。</T>
   //
   // @param materialGuid 材质唯一编号
   //============================================================
   public void setMaterialGuid(String materialGuid){
      _materialGuid = materialGuid;
   }
}
