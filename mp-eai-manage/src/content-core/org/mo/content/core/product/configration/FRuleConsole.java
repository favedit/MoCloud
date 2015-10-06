package org.mo.content.core.product.configration;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataControlRuleLogic;
import com.cyou.gccloud.data.data.FDataControlRuleUnit;
import com.cyou.gccloud.define.enums.core.EGcRule;
//============================================================
//<P>规则配置信息操作接口</P>
//
//@class FConfigrationConsole
//@author Zxh
//@Date 2015.10.06
//@version 1.0.0
//============================================================
public class FRuleConsole 
               extends 
               FAbstractLogicUnitConsole<FDataControlRuleLogic, FDataControlRuleUnit>
               implements IRuleConsole {

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造规则配置控制台。</T>
   //============================================================
   public FRuleConsole() {
      super(FDataControlRuleLogic.class, FDataControlRuleUnit.class);
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
   public FLogicDataset<FDataRuleInfo> select(ILogicContext logicContext,
                                                             FDataRuleInfo unit,
                                                             int pageNum,
                                                             int pageSize){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
//      if(RString.equals(EGcRule.Unknown,unit.ruleCd())||RString.equals(EGcRule.LastLogin,unit.ruleCd())||
//            RString.equals(EGcRule.BrowseCount,unit.ruleCd())||RString.equals(EGcRule.Income,unit.ruleCd())
//            ||RString.equals(EGcRule.Age,unit.ruleCd())){
//         whereSql.append(FDataControlRuleLogic.RULE_CD + " = '{rulecd}'");
//         whereSql.bind("rulecd", RString.parse(unit.ruleCd()));
//      }
      FDataControlRuleLogic logic = logicContext.findLogic(FDataControlRuleLogic.class);
      FLogicDataset<FDataRuleInfo> moduleList = logic.fetchClass(FDataRuleInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      return moduleList;
   }

}
