package org.mo.content.engine3d.core.material;

import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureUnit;
import com.cyou.gccloud.data.data.FDataResource3dMaterialUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialTexture;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3MaterialConsole
{
   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                       String code);

   //============================================================
   // <T>新建一个材质。</T>
   //
   // @param logicContext 逻辑环境
   // @param material 材质
   // @return 材质单元
   //============================================================
   FDataResource3dMaterialUnit insertMaterial(ILogicContext logicContext,
                                              long themeId,
                                              long materialGroupId,
                                              FRs3Material material);

   //============================================================
   // <T>新建一个材质纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param materialId 材质编号
   // @param materialTexture 材质纹理
   // @return 材质纹理单元
   //============================================================
   FDataResource3dMaterialTextureUnit insertMaterialTexture(ILogicContext logicContext,
                                                            long materialId,
                                                            FRs3MaterialTexture materialTexture);
}
