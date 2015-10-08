package org.mo.content.face.manage.product.common.configration.rule;

import com.cyou.gccloud.data.data.FDataControlRuleUnit;
import com.cyou.gccloud.define.enums.core.EGcRule;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.common.configration.rule.FDataRuleInfo;
import org.mo.content.core.manage.product.common.configration.rule.IRuleConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>规则配置信息接口。</P>
//
//@author sunhr
//@version 150909
//============================================================
public class FRuleAction implements IRuleAction {

    // 日志输出接口
    private static ILogger _logger = RLogger.find(FRuleAction.class);

    // 配置控制台
    @ALink
    protected IRuleConsole _ruleConsole;

    // ============================================================
    // <T>默认逻辑处理。</T>
    //
    // @param context 页面环境
    // @param page 页面
    // ============================================================
    @Override
    public String construct(IWebContext context, ILogicContext logicContext, FBasePage page) {
        _logger.debug(this, "Construct-------------------------------------", "Construct begin. (userId={1})", page.userId());
        if (!page.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        return "/manage/product/common/configration/rule/RuleList";
    }

    // ============================================================
    // <T>查询</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String select(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        if (null != context.parameter("page")) {
            String num = context.parameter("page");
            page.setPageCurrent(Integer.parseInt(num));
        } else {
            page.setPageCurrent(0);
        }
        FDataRuleInfo unit = new FDataRuleInfo();
        FLogicDataset<FDataRuleInfo> unitList = null;
        String cdr = context.parameter("ruleCdStr");
        if (RString.isEmpty(cdr)) {
            unitList = _ruleConsole.select(logicContext, unit, page.pageCurrent() - 1);
        } else {
            setRuleInfo(unit, context, cdr);
            unitList = _ruleConsole.selectByRuleCd(logicContext, unit, page.pageCurrent() - 1);
        }
        basePage.setJson(unitList.toJsonListString());
        _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
        return "/manage/common/ajax";
    }

    // ============================================================
    // <T>增加之前</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String insertBefore(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        return "/manage/product/common/configration/rule/InsertRule";
    }

    // ============================================================
    // <T>增加</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String insert(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        FDataControlRuleUnit unit = _ruleConsole.doPrepare(logicContext);
        unit.setRuleCd(context.parameterAsInteger("ruleCd"));
        setRuleData(unit, context);
        EResult result = _ruleConsole.doInsert(logicContext, unit);
        if (!result.equals(EResult.Success)) {
            page.setResult("增加失败");
            return "/manage/product/configration/InsertRule";
        }
        _logger.debug(this, "InsertAfter", "InsertBefore finish. (userId={1})", "SUCCESS");
        return "/manage/product/common/configration/rule/RuleList";
    }

    // ============================================================
    // <T>更新之前</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String updateBefore(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        long id = context.parameterAsLong("id");

        FDataControlRuleUnit unit = _ruleConsole.find(logicContext, id);
        FDataRuleInfo info = new FDataRuleInfo();
        info.setOuid(unit.ouid());
        info.setNote(unit.note());
        info.setParameters1(unit.parameters1());
        info.setParameters2(unit.parameters2());
        info.setParameters3(unit.parameters3());
        info.setParameters4(unit.parameters4());
        info.setScorePoint(unit.scorePoint());
        info.setPercentage(unit.percentage());
        if (RString.equals(EGcRule.Unknown, unit.ruleCd())) {
            info.setRuleCdStr(EGcRule.UnknownLabel);
        }
        if (RString.equals(EGcRule.LastLogin, unit.ruleCd())) {
            info.setRuleCdStr(EGcRule.LastLoginLabel);
        }
        if (RString.equals(EGcRule.BrowseCount, unit.ruleCd())) {
            info.setRuleCdStr(EGcRule.BrowseCountLabel);
        }
        if (RString.equals(EGcRule.Income, unit.ruleCd())) {
            info.setRuleCdStr(EGcRule.IncomeLabel);
        }
        if (RString.equals(EGcRule.Age, unit.ruleCd())) {
            info.setRuleCdStr(EGcRule.AgeLabel);
        }
        page.setUnit(info);
        _ruleConsole.doUpdate(logicContext, unit);
        return "/manage/product/common/configration/rule/UpdateRule";
    }

    // ============================================================
    // <T>更新</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String update(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        _logger.debug(this, "Update", "Update Begin.(id={1})", context.parameter("configInfoId"));
        FDataControlRuleUnit unit = new FDataControlRuleUnit();
        unit.setOuid(Long.parseLong(context.parameter("ouid")));
        setRuleData(unit, context);
        String cdr = context.parameter("ruleCdStr");
        setRuleInfo(unit, context, cdr);
        _ruleConsole.doUpdate(logicContext, unit);
        return "/manage/common/ajax";
    }

    // ============================================================
    // <T>删除</T>
    //
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String delete(IWebContext context, ILogicContext logicContext, FRulePage page, FBasePage basePage) {
        _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
        if (!basePage.userExists()) {
            return "/manage/common/ConnectTimeout";
        }
        long id = context.parameterAsLong("id");
        FDataControlRuleUnit unit = _ruleConsole.find(logicContext, id);
        if (unit == null) {
            throw new FFatalError("id not exists.");
        }
        EResult result = _ruleConsole.doDelete(logicContext, unit);
        if (!result.equals(EResult.Success)) {
            throw new FFatalError("Delete failure.");
        } else {
            return "/manage/product/common/configration/rule/RuleList";
        }
    }

    // ============================================================
    // <T>抽取公共方法</T>
    //
    // @param context 网络环境
    // ============================================================
    public void setRuleData(FDataControlRuleUnit unit, IWebContext context) {
        unit.setPercentage(context.parameterAsInteger("percentage"));
        unit.setScorePoint(context.parameterAsInteger("scorePoint"));
        unit.setParameters1(context.parameter("parameters1"));
        unit.setParameters2(context.parameter("parameters2"));
        unit.setParameters3(context.parameter("parameters3"));
        unit.setParameters4(context.parameter("parameters4"));
        unit.setNote(context.parameter("note"));
        unit.setCreateUserId(context.parameterAsLong("adminId"));
    }

    // ============================================================
    // <T>抽取公共枚举</T>
    //
    // @param context 网络环境
    // ============================================================
    public void setRuleInfo(FDataControlRuleUnit unit, IWebContext context, String cdr) {
        if (RString.equals(EGcRule.UnknownLabel, cdr)) {
            unit.setRuleCd(EGcRule.Unknown);
        } else if (RString.equals(EGcRule.LastLoginLabel, cdr)) {
            unit.setRuleCd(EGcRule.LastLogin);
        } else if (RString.equals(EGcRule.BrowseCountLabel, cdr)) {
            unit.setRuleCd(EGcRule.BrowseCount);
        } else if (RString.equals(EGcRule.IncomeLabel, cdr)) {
            unit.setRuleCd(EGcRule.Income);
        } else if (RString.equals(EGcRule.AgeLabel, cdr)) {
            unit.setRuleCd(EGcRule.Age);
        }
    }
}
