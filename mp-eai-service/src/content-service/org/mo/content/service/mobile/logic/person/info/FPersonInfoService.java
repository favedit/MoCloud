package org.mo.content.service.mobile.logic.person.info;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.logic.person.info.FDataPersonInfo;
import org.mo.content.core.mobile.logic.person.info.IPersonInfoConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>登录服务。</T>
//============================================================
public class FPersonInfoService extends FObject implements IPersonInfoService {
    // 日志输出接口
    private static ILogger _logger = RLogger.find(FPersonInfoService.class);

    // 登录逻辑控制台
    @ALink
    protected IPersonInfoConsole _personInfoConsole;

    // GcSession会话控制台
    @ALink
    protected IGcSessionConsole _sessionConsole;

    // WebSession会话控制台
    @ALink
    protected IWebSessionConsole _webSessionConsole;
    // content项目地址
    @AProperty
    protected String contentServiceHost;

    // ============================================================
    // <T>默认逻辑。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    @Override
    public EResult process(IWebContext context, IWebInput input,
            IWebOutput output) {
        _logger.debug(this, "process", "process begin. ");
        return EResult.Success;
    }

    // ============================================================
    // <T>个人中心</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // @logicContext 逻辑上下文
    // @sessionContext session上下文
    // ============================================================
    @Override
    public EResult personInfo(IWebContext context, IWebInput input,
            IWebOutput output, ILogicContext logicContext,
            IWebSession sessionContext) {
        String sessionCode = context.head("mo-session-id");
        if (sessionCode == null || "".equals(sessionCode)) {
            FXmlNode status_cd = output.config().createNode("status_cd");
            status_cd.setText(EGcAuthorityResult.Unknown);
            return EResult.Failure;
        }
        // sessionCode不可以重复!!
        FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(
                logicContext, sessionCode);
        if (sessionInfo == null) {
            // session已经失效
            output.config().createNode("session_status").setText(0);
            return EResult.Success;
        }
        // 返回上一次的打卡时间和用户的个人信息
        FDataPersonInfo userInfo = _personInfoConsole.getUserInfo(
                sessionInfo.userId(), logicContext);
        if (userInfo != null) {
            FXmlNode last_sign_date = output.config().createNode(
                    "last_sign_date");
            if (userInfo.last_sign_date() != null
                    && (!"".equals(userInfo.last_sign_date()))) {
                last_sign_date.setText(userInfo.last_sign_date());
            } else {
                last_sign_date.setText("-1");
            }
        }
        // 查看用户是否有最新的公告
        FLogicDataset<FDataLogicNoticeUnit> noticeUnits = _personInfoConsole
                .isThereNotices(sessionInfo.userId(), sessionContext,
                        logicContext, _sessionConsole, _webSessionConsole);
        if (noticeUnits != null && noticeUnits.count() > 0) {
            output.config().createNode("notice").setText(noticeUnits.count());
        } else {
            output.config().createNode("notice").setText(-1);
        }
        return EResult.Success;
    }

}
