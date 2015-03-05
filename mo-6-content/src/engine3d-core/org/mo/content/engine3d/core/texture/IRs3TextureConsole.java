package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.texture.FRs3Texture;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源纹理控制台接口。</T>
//============================================================
public interface IRs3TextureConsole
{
   //============================================================
   // <T>根据代码查找纹理单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 纹理单元
   //============================================================
   FDataResource3dTextureUnit findByCode(ILogicContext logicContext,
                                         String code);

   //============================================================
   // <T>生成纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   FRs3Texture makeTexture(ILogicContext logicContext,
                           String guid);

   //============================================================
   // <T>生成纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   byte[] makeTextureData(ILogicContext logicContext,
                          String guid);

   //============================================================
   // <T>导入纹理。</T>
   //
   // @param logicContext 逻辑环境
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult importTexture(ILogicContext logicContext,
                         String path);
}
