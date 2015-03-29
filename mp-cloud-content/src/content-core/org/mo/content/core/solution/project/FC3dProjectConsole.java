package org.mo.content.core.solution.project;

import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import com.cyou.gccloud.data.data.FDataSolutionProjectUnit;
import org.mo.cloud.logic.solution.IGcProjectConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>方案项目控制台。</T>
//============================================================
public class FC3dProjectConsole
      implements
         IC3dProjectConsole
{
   // 方案项目接口
   @ALink
   protected IGcProjectConsole _projectConsole;

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
         whereSql = FDataSolutionProjectLogic.CODE + " LIKE '%" + serach + "%'";
      }
      // 查询数据
      FDataSolutionProjectLogic logic = context.findLogic(FDataSolutionProjectLogic.class);
      FLogicDataset<FDataSolutionProjectUnit> dataset = logic.fetch(whereSql, pageSize, page);
      xoutput.set("total", dataset.total());
      xoutput.set("count", dataset.count());
      xoutput.set("page_size", dataset.pageSize());
      xoutput.set("page_count", dataset.pageCount());
      xoutput.set("page", dataset.page());
      for(FDataSolutionProjectUnit unit : dataset){
         FXmlNode xitem = xoutput.createNode("Item");
         xitem.set("guid", unit.guid());
         xitem.set("type", "model");
         xitem.set("code", unit.code());
         xitem.set("label", unit.label());
      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询数据处理。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   @Override
   public FDataSolutionProjectUnit query(ILogicContext context,
                                         String guid){
      return _projectConsole.findByGuid(context, guid);
   }
}
