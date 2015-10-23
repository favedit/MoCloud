package org.mo.content.face.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.RString;
import org.mo.content.core.mobile.logic.notice.INoticeConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息控制器</P>
//@class FCustomerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FNoticeAction implements INoticeAction {
    // 日志输出接口
    // private static ILogger _logger = RLogger.find(FSalesToolsAction.class);

    // 新闻逻辑控制台
    @ALink
    protected INoticeConsole _noticeConsole;
    // GcSession会话控制台
    @ALink
    protected IGcSessionConsole _sessionConsole;

    // ============================================================
    // <T>默认逻辑处理。</T>
    // @param context 页面环境
    // @param page 页面
    // ============================================================
    @Override
    public String construct(IWebContext context, ILogicContext logicContext,
            FNoticePage page, FBasePage basePage) {

        return "";
    }

    // ============================================================
    // <T>根据guid获取通告</T>
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    @Override
    public String getInfo(IWebContext context, ILogicContext logicContext,
            FNoticePage page, FBasePage basePage) {
        String notice_id = context.parameter("notice_id");
        FDataLogicNoticeUnit noticeUnit = _noticeConsole.getNewsByGuid(
                notice_id, logicContext);
        page.setUnit(noticeUnit);
        return "/manage/mobile/notices/NoticeInfo";
    }

    // ============================================================
    // <T>标记已读务接口。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    @Override
    public String markRead(IWebContext context, IWebSession sessionContext,
            ILogicContext logicContext, FNoticePage Page, FBasePage basePage) {
        String sessionCode = context.head("mo-session-id");
        if (RString.isNotEmpty(sessionCode)) {
            FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(
                    logicContext, sessionCode);
            long userId = sessionInfo.userId();
            FDataLogicNoticeUnit unit = _noticeConsole.markRead(userId,
                    sessionContext, logicContext);
            Page.setUnit(unit);
            // 没有公告
            if (unit == null) {
                basePage.setJson("{\"message\":\"empty\"}");
                return "/manage/common/ajax";
            }
        }
        return "/manage/mobile/notices/NoticeInfo";
    }
}
