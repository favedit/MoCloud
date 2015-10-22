package org.mo.content.core.mobile.account;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>d登录控制台接口。</T>
//============================================================
public interface ILoginConsole {
    // ============================================================
    // @登录逻辑处理
    // @param context 页面环境
    // @param passport 用户名
    // @param password 密码
    // @logicContext 逻辑上下文
    // @sessionContext session上下文
    // ============================================================
    public FDataPersonUserUnit login(IWebContext context, String passport,
            String password, ILogicContext logicContext,
            IWebSession sessionContext);

    // ============================================================
    // <T>请求OA登录接口</T>
    //
    // @param url 接口链接
    // @param passport 用户名
    // @param password 密码
    // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
    // ============================================================
    public String oaLogin(String passport, String password);

    // ============================================================
    // @同步oa用户到数据库中
    // @param logicContext 逻辑上下文
    // @param backUser oa接口返回的用户
    // @param from 是通过什么身份登录的系统
    // @param changePass 以何种身份登录的用户名
    // ============================================================
    public FDataPersonUserUnit synchronizeData(ILogicContext logicContext,
            FDataPersonUserUnit backUser, int from, String changePass);

    // ============================================================
    // @注销
    // @param context 页面环境
    // @param sessionId sessionCode
    // @param logicContext 逻辑上下文
    // @param sessionContext session上下文
    // ============================================================
    public FDataPersonUserUnit logout(IWebContext context, String sessionId,
            ILogicContext logicContext, IWebSession sessionContext);

    // ============================================================
    // @根据guid查询用户
    // @param context 页面环境
    // @param userGuid 用户guid
    // @param logicContext 逻辑上下文
    // @param sessionContext session上下文
    // ============================================================
    public FDataPersonUserUnit query(IWebContext context, String userGuid,
            ILogicContext logicContext, IWebSession sessionContext);

    // ============================================================
    // @更新用户
    // @param context 页面环境
    // @param unit 用户
    // @param logicContext 逻辑上下文
    // @param sessionContext session上下文
    // ============================================================
    public FDataPersonUserUnit update(IWebContext context,
            FDataPersonUserUnit unit, ILogicContext logicContext,
            IWebSession sessionContext);

    // ============================================================
    // @获取已经登录的用户信息
    // @param user_id 用户id
    // @param logicContext 逻辑上下文
    // ============================================================
    public FDataPersonUserInfo getUserInfo(long user_id,
            ILogicContext logicContext);

    // ============================================================
    // @根据app_key获取应用
    // @param applicationGuid 应用的guid
    // @param logicContext 逻辑上下文
    // ============================================================
    public FDataSystemApplicationUnit getApplicationUnitByGuid(
            ILogicContext logicContext, String applicationGuid);

    // ============================================================
    // @通过用户的ouid和appid清空session
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // @logicContext 逻辑上下文
    // @sessionContext session上下文
    // ============================================================
    public void clearSessionByUserId(long userId, long appId,
            IWebSession sessionContext, ILogicContext logicContext,
            IGcSessionConsole _sessionConsole,
            IWebSessionConsole _webSessionConsole);

    // ============================================================
    // @查看当前用户是否有最新的公告
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // @logicContext 逻辑上下文
    // @sessionContext session上下文
    // ============================================================
    public String isThereNotices(long userId, IWebSession sessionContext,
            ILogicContext logicContext, IGcSessionConsole _sessionConsole,
            IWebSessionConsole _webSessionConsole);
}
