package org.mo.cloud.logic.data.resource;

import com.cyou.gccloud.data.data.FDataResourceCatalogLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源目录控制台。</T>
//============================================================
public class FGcResourceCatalogConsole
      extends FAbstractLogicUnitConsole<FDataResourceCatalogLogic, FGcResourceCatalogInfo>
      implements
         IGcResourceCatalogConsole
{
   //============================================================
   // <T>构造资源目录控制台。</T>
   //============================================================
   public FGcResourceCatalogConsole(){
      super(FDataResourceCatalogLogic.class, FGcResourceCatalogInfo.class);
   }

   //============================================================
   // <T>计算节点下所有子节点的总数。</T>
   //
   // @param logicContext 逻辑环境
   // @param nodeId 节点编号
   // @return 子节点总数
   //============================================================
   @Override
   public int calculateChildCount(ILogicContext logicContext,
                                  long nodeId){
      String sql = "SELECT COUNT(*) FROM " + FDataResourceCatalogLogic.TABLE;
      sql += " WHERE PARENT_ID=" + nodeId;
      ISqlConnection connection = logicContext.activeConnection(FDataResourceCatalogLogic.CONNECTION.toString());
      int count = connection.executeInteger(sql);
      return count;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param catalog 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteBefore(ILogicContext logicContext,
                                    FGcResourceCatalogInfo catalog){
      long nodeId = catalog.ouid();
      if(nodeId > 0){
         String whereSql = FDataResourceCatalogLogic.PARENT_ID + "=" + nodeId;
         FLogicDataset<FGcResourceCatalogInfo> dataset = fetch(logicContext, whereSql);
         for(FGcResourceCatalogInfo child : dataset){
            doDelete(logicContext, child);
         }
      }
      return EResult.Success;
   }
}
