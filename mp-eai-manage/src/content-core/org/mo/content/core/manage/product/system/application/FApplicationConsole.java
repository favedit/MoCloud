package org.mo.content.core.manage.product.system.application;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataSystemApplicationLogic;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>应用控制台</P>
//@class FApplicationConsole
//@version 1.0.0
//============================================================
public class FApplicationConsole
      extends 
         FAbstractLogicUnitConsole<FDataSystemApplicationLogic, FDataSystemApplicationUnit>
      implements
         IApplicationConsole
{

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造应用控制台。</T>
   // ============================================================
   public FApplicationConsole(){
      super(FDataSystemApplicationLogic.class, FDataSystemApplicationUnit.class);
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
   public FLogicDataset<FDataSystemApplicationUnit> select(ILogicContext logicContext,
                                                           FDataSystemApplicationUnit unit,
                                                           int pageNum,
                                                           int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.label())){
         whereSql.append(FDataLogicNewsLogic.LABEL + " LIKE '%{label}%'");
         whereSql.bind("label", RString.parse(unit.label()));
      }
      FDataSystemApplicationLogic logic = logicContext.findLogic(FDataSystemApplicationLogic.class);
      FLogicDataset<FDataSystemApplicationUnit> moduleList = logic.fetch(whereSql.toString(), pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   @Override
   public FDataSystemApplicationUnit findByLable(ILogicContext logicContext,
                                                 String label){
      FSql whereSql = new FSql();
      if(!RString.isEmpty(label)){
         whereSql.append(FDataSystemApplicationLogic.LABEL);
         whereSql.append(" like '%");
         whereSql.append("{label}");
         whereSql.bind("label", label);
         whereSql.append("%'");
      }
      FDataSystemApplicationLogic logic = logicContext.findLogic(FDataSystemApplicationLogic.class);
      FLogicDataset<FDataSystemApplicationUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataSystemApplicationUnit> selectAll(ILogicContext logicContext){
      FDataSystemApplicationLogic logic = logicContext.findLogic(FDataSystemApplicationLogic.class);
      FLogicDataset<FDataSystemApplicationUnit> List = logic.fetchAll();
      return List;
   }
}
