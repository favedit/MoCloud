package org.mo.content.core.product.system.version;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;

public class FVersionConsole 
               extends FAbstractLogicUnitConsole<FDataSystemVersionLogic, FDataSystemVersionUnit>
               implements IVersionConsole {

   // 每页条数
   static final int _pageSize = 20;
   
   public FVersionConsole() {
      super(FDataSystemVersionLogic.class, FDataSystemVersionUnit.class);
   }
   
   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataVersionInfo> select(ILogicContext logicContext,
                                                           FDataSystemVersionUnit unit,
                                                           int pageNum,
                                                           int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataSystemVersionLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", unit.label());
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataVersionInfo> moduleList = logic.fetchClass(FDataVersionInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      return moduleList;
   }
   
   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataSystemVersionUnit findByLable(ILogicContext logicContext,
                                             String label){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(label)){
         whereSql.append(FDataSystemVersionLogic.LABEL);
         whereSql.append(" like '%");
         whereSql.append("{label}");
         whereSql.bind("label", label);
         whereSql.append("%'");
      }
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FLogicDataset<FDataSystemVersionUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}
