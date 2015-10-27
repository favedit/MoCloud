package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>通告服务接口。</T>
//============================================================
public class FNoticeConsole extends FObject implements INoticeConsole {
    // 日志输出接口
    private static ILogger _logger = RLogger.find(FNoticeConsole.class);

    // ============================================================
    // <T>构造资源</T>
    // ============================================================
    public FNoticeConsole() {

    }

    // ============================================================
    // <T>根据guid获取通告信息。</T>
    // @param guid
    // @param logicContext 逻辑上下文
    // ============================================================
    @Override
    public FDataLogicNoticeUnit getNewsByGuid(String guid,
            ILogicContext logicContext) {
        _logger.debug(this, "getNewsByGuid", "getNewsByGuid start guid={1}",
                guid);
        FDataLogicNoticeLogic logic = logicContext
                .findLogic(FDataLogicNoticeLogic.class);
        return logic.findByGuid(guid);
    }

}
