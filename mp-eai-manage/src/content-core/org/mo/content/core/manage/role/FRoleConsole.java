package org.mo.content.core.manage.role;

import com.cyou.gccloud.data.data.FDataControlRoleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FRoleConsole
      extends FAbstractLogicUnitConsole<FDataControlRoleLogic, FDataControlRoleUnit>
      implements
         IRoleConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FRoleConsole(){
      super(FDataControlRoleLogic.class, FDataControlRoleUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataControlRoleUnit> selectDataByPageAndSomerow(ILogicContext logicContext,
                                                                         FDataControlRoleUnit roleUnit,
                                                                         int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      StringBuffer whereSql = new StringBuffer();
      if(!RString.isEmpty(roleUnit.code())){
         whereSql.append(FDataControlRoleLogic.CODE).append(" LIKE '").append(roleUnit.code() + "%'");
      }
      FDataControlRoleLogic roleLogic = logicContext.findLogic(FDataControlRoleLogic.class);
      FLogicDataset<FDataControlRoleUnit> roleList = roleLogic.fetch(whereSql.toString(), _pageSize, pageNum);
      return roleList;
   }

}
