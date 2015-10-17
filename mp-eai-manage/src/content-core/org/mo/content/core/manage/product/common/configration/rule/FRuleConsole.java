package org.mo.content.core.manage.product.common.configration.rule;

import java.util.Iterator;

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
//@class FConfigrationConsole
//@version 1.0.0
//============================================================
public class FRuleConsole 
               extends 
                  FAbstractLogicUnitConsole<FDataControlRuleLogic, FDataControlRuleUnit>
               implements 
                  IRuleConsole 
{

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
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataRuleInfo> select(ILogicContext logicContext,
                                              FDataRuleInfo unit,
                                              int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      FDataControlRuleLogic logic = logicContext.findLogic(FDataControlRuleLogic.class);
      FLogicDataset<FDataRuleInfo> moduleList = logic.fetchClass(FDataRuleInfo.class, null, whereSql.toString(), null, _pageSize, pageNum);
      for(Iterator<FDataRuleInfo> iterator = moduleList.iterator(); iterator.hasNext();){
         FDataRuleInfo tunit = iterator.next();
         if(RString.equals(EGcRule.Unknown,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.UnknownLabel);
         }
         if(RString.equals(EGcRule.LastLogin,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.LastLoginLabel);
         }
         if(RString.equals(EGcRule.BrowseCount,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.BrowseCountLabel);
         }
         if(RString.equals(EGcRule.Income,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.IncomeLabel);
         }
         if(RString.equals(EGcRule.Age,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.AgeLabel);
         }
      }
      return moduleList;
   }
   // ============================================================
   // <T>获得分页数据列表byRuleCd</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataRuleInfo> selectByRuleCd(ILogicContext logicContext,
                                                      FDataRuleInfo unit,
                                                      int pageNum){
      if(pageNum < 0){
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataControlRuleLogic.RULE_CD + " = '{rulecd}'");
      whereSql.bind("rulecd", RString.parse(unit.ruleCd()));
      FDataControlRuleLogic logic = logicContext.findLogic(FDataControlRuleLogic.class);
      FLogicDataset<FDataRuleInfo> moduleList = logic.fetchClass(FDataRuleInfo.class, null, whereSql.toString(), null, _pageSize, pageNum);
      for(Iterator<FDataRuleInfo> iterator = moduleList.iterator(); iterator.hasNext();){
         FDataRuleInfo tunit = iterator.next();
         if(RString.equals(EGcRule.Unknown,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.UnknownLabel);
         }
         if(RString.equals(EGcRule.LastLogin,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.LastLoginLabel);
         }
         if(RString.equals(EGcRule.BrowseCount,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.BrowseCountLabel);
         }
         if(RString.equals(EGcRule.Income,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.IncomeLabel);
         }
         if(RString.equals(EGcRule.Age,tunit.ruleCd())){
            tunit.setRuleCdStr(EGcRule.AgeLabel);
         }
      }
      return moduleList;
   }

}
