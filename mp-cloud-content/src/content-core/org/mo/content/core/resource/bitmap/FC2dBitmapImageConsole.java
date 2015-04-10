package org.mo.content.core.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResource3dTextureLogic;
import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import org.mo.cloud.logic.resource.bitmap.FGcResBitmapImageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容纹理控制台。</T>
//============================================================
public class FC2dBitmapImageConsole
      extends FGcResBitmapImageConsole
      implements
         IC2dBitmapImageConsole
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 逻辑环境
   // @param xoutput 输出内容
   // @param serach 搜索内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult fetch(ILogicContext context,
                        FXmlNode xoutput,
                        String serach,
                        int pageSize,
                        int page){
      // 生成查询脚本
      String whereSql = null;
      if(!RString.isEmpty(serach)){
         whereSql = FDataResource3dTextureLogic.FULL_CODE + " LIKE '%" + serach + "%'";
      }
      // 查询数据
      FDataResource3dTextureLogic logic = context.findLogic(FDataResource3dTextureLogic.class);
      FLogicDataset<FDataResource3dTextureUnit> dataset = logic.fetch(whereSql, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FDataResource3dTextureUnit unit : dataset){
         FXmlNode xitem = xoutput.createNode("Item");
         xitem.set("guid", unit.guid());
         xitem.set("type", "texture");
         xitem.set("code", unit.fullCode());
         xitem.set("label", unit.label());
      }
      return EResult.Success;
   }
}
