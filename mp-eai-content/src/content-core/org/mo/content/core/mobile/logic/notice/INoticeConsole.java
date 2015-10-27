package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import org.mo.data.logic.ILogicContext;

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

}
