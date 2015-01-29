package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源纹理控制台接口。</T>
//============================================================
public interface IRs3TextureBitmapConsole
{
   //============================================================
   // <T>根据代码查找纹理位图单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param textureId 纹理编号
   // @param code 代码
   // @return 纹理单元
   //============================================================
   FDataResource3dTextureBitmapUnit findByCode(ILogicContext logicContext,
                                               long textureId,
                                               String code);

}
