package org.mo.content.core.product.configration;

import com.cyou.gccloud.data.data.FDataCommonConfigurationLogic;
import com.cyou.gccloud.data.data.FDataCommonConfigurationUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>配置信息操作接口</P>
//
//@class FConfigrationConsole
//@author Sunhr
//@Date 2015.09.09  
//@version 1.0.0
//============================================================

public class FConfigrationConsole
      extends FAbstractLogicUnitConsole<FDataCommonConfigurationLogic, FDataCommonConfigurationUnit>
      implements
         IConfigrationConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FConfigrationConsole(){
      super(FDataCommonConfigurationLogic.class, FDataCommonConfigurationUnit.class);
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
   public FLogicDataset<FDataCommonConfigurationUnit> select(ILogicContext logicContext,
                                                             FDataCommonConfigurationUnit unit,
                                                             int pageNum,
                                                             int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if(!RString.isEmpty(unit.code())){
         whereSql.append(FDataCommonConfigurationLogic.CODE);
         whereSql.append(" LIKE '%");
         whereSql.append(unit.code() + "%'");
      }
      String orderBy = String.format("%s %s", FDataCommonConfigurationLogic.CODE, "ASC");
      FDataCommonConfigurationLogic logic = logicContext.findLogic(FDataCommonConfigurationLogic.class);
      FLogicDataset<FDataCommonConfigurationUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

   @Override
   public FDataCommonConfigurationUnit findByCode(ILogicContext logicContext,
                                                  String code){
      StringBuffer whereSql = new StringBuffer();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataCommonConfigurationLogic.CODE).append("='").append(code + "'");
      }
      FDataCommonConfigurationLogic logic = logicContext.findLogic(FDataCommonConfigurationLogic.class);
      FLogicDataset<FDataCommonConfigurationUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }
}
