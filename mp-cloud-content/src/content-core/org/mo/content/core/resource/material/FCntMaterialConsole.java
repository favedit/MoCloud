package org.mo.content.core.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialLogic;
import com.cyou.gccloud.data.data.FDataResourceMaterialUnit;
import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容材质控制台。</T>
//============================================================
public class FCntMaterialConsole
      extends FConsole
      implements
         ICntMaterialConsole
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
         whereSql = FDataResourceMaterialLogic.FULL_CODE + " LIKE '%" + serach + "%'";
      }
      // 查询数据
      FDataResourceMaterialLogic logic = context.findLogic(FDataResourceMaterialLogic.class);
      FLogicDataset<FDataResourceMaterialUnit> dataset = logic.fetch(whereSql, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FDataResourceMaterialUnit unit : dataset){
         FXmlNode xitem = xoutput.createNode("Item");
         xitem.set("guid", unit.guid());
         xitem.set("type", "material");
         xitem.set("code", unit.fullCode());
         xitem.set("label", unit.label());
      }
      return EResult.Success;
   }
}
