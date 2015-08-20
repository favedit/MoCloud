package org.mo.content.core.manage.module;

import com.cyou.gccloud.data.data.FDataControlModuleLogic;
import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FModuleConsole
      extends FAbstractLogicUnitConsole<FDataControlModuleLogic, FDataControlModuleUnit>
      implements
         IModuleConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FModuleConsole(){
      super(FDataControlModuleLogic.class, FDataControlModuleUnit.class);
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
   public FLogicDataset<FDataControlModuleUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                           FDataControlModuleUnit moduleUnit,
                                                                           int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      StringBuffer whereSql = new StringBuffer();
      if(!RString.isEmpty(moduleUnit.code())){
         whereSql.append(FDataControlModuleLogic.CODE).append(" LIKE '").append(moduleUnit.code() + "%'");
      }
      String orderBy = String.format("%s %s", FDataControlModuleLogic.CODE, "ASC");
      FDataControlModuleLogic moduleLogic = logicContext.findLogic(FDataControlModuleLogic.class);
      FLogicDataset<FDataControlModuleUnit> moduleList = moduleLogic.fetch(whereSql.toString(), orderBy, _pageSize, pageNum);
      return moduleList;
   }

   // ============================================================
   // <T>查询一个角色所拥有的模块/T>
   //
   // @param logicContext 链接对象
   // @param unit 更新数据
   // ============================================================
   @Override
   public FLogicDataset<FDataControlModuleInfo> selectModule(ILogicContext logicContext,
                                                             int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FDataControlModuleLogic.CODE, " ASC ");
      FLogicDataset<FDataControlModuleInfo> moduleInfoList = logicContext.findLogic(FDataControlModuleLogic.class).fetchClass(FDataControlModuleInfo.class, null, null, orderBy, -1, -1);
      return moduleInfoList;
   }
}
