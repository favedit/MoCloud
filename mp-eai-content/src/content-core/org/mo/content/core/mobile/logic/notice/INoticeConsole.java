package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface INoticeConsole {
    // ============================================================
    // <T>根据guid获取通告信息。</T>
    // @param guid
    // @param logicContext 逻辑上下文
    // ============================================================
    FDataLogicNoticeUnit getNewsByGuid(String guid, ILogicContext logicContext);

    // ============================================================
    // <T>标记通告已读务接口。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    public FDataLogicNoticeUnit markRead(long userId,
            IWebSession sessionContext, ILogicContext logicContext);
}
