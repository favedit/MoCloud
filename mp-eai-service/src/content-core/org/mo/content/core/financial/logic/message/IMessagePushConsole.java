package org.mo.content.core.financial.logic.message;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<T>短信推送服务接口。</T>
//============================================================
public interface IMessagePushConsole {
    // ============================================================
    // <T>短信推送</T>
    // @param pageNum 页数
    // @param pageSize 每页的行数
    // @param logicContext 逻辑上下文
    // ============================================================
    FLogicDataset<FDataLogicNewsUnit> pushSMS(String linkIdStr,
            String dateTimeStr, ILogicContext logicContext,
            IWebContext context, IWebSession sessionContext);
}
