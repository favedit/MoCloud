package org.mo.content.core.product.configration;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import com.cyou.gccloud.data.data.FDataControlRuleUnit;

//============================================================
//<P>规则配置信息操作接口</P>
//
//@class IRuleConsole
//@author Zxh
//@Date 2015.10.6
//@version 1.0.0
//============================================================
public interface IRuleConsole extends IAbstractLogicUnitConsole<FDataControlRuleUnit> {

// ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataRuleInfo> select(ILogicContext logicContext,
                                                      FDataRuleInfo unit,
                                                      int pageNum,
                                                      int pageSize);

}
