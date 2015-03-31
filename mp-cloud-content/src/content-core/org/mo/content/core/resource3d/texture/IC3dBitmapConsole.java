package org.mo.content.core.resource3d.texture;

import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容图片控制台接口。</T>
//============================================================
public interface IC3dBitmapConsole
      extends
         IGcResBitmapConsole
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 搜索内容
   // @param orderSql 排序内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   FLogicDataset<FLogicUnit> list(ILogicContext logicContext,
                                  String whereSql,
                                  String orderSql,
                                  int pageSize,
                                  int page);

   //============================================================
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   byte[] makeData(ILogicContext context,
                   String guid);
}
