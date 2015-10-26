package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>新闻服务接口。</T>
//============================================================
public class FNoticeConsole extends FObject implements INoticeConsole {
    // 日志输出接口
    private static ILogger _logger = RLogger.find(FMobileService.class);
    // GcSession会话控制台
    @ALink
    protected IGcSessionConsole _sessionConsole;

    // ============================================================
    // <T>构造资源</T>
    // ============================================================
    public FNoticeConsole() {

    }

    // ============================================================
    // <T>根据guid获取新闻相关信息。</T>
    // @param guid
    // @param logicContext 逻辑上下文
    // ============================================================
    @Override
    public FDataLogicNoticeUnit getNewsByGuid(String guid,
            ILogicContext logicContext) {
        _logger.debug(this, "getNewsByGuid", "getNewsByGuid start guid={1}",
                guid);
        // FDataPersonUserLogic logic = logicContext
        // .findLogic(FDataPersonUserLogic.class);
        return null;
    }

    // ============================================================
    // <T>分页获取当前用户未读的相关号令。</T>
    // @param pageNum 页数
    // @param pageSize 每页的行数
    // @param logicContext 逻辑上下文
    // ============================================================
    @Override
    public FLogicDataset<FDataLogicNoticeUnit> select(int pageNum,
            int pageSize, String sessionCode, ILogicContext logicContext) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        FSql whereSql = new FSql();

        FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(
                logicContext, sessionCode);
        long userId = sessionInfo.userId();
        whereSql.append(FDataLogicNoticeLogic.STATUS_CD);
        whereSql.append("=");
        whereSql.append(EGcResourceStatus.Publish);
        whereSql.append(" AND ");
        whereSql.append(FDataLogicNoticeLogic.DISPLAY_CD);
        whereSql.append("=");
        whereSql.append(EGcDisplay.Enabled);
        whereSql.append(" AND ");
        whereSql.append(FDataLogicNoticeLogic.OUID);
        whereSql.append(" NOT in (SELECT `NOTICE_ID` FROM `EAI_LOGGER`.`LG_PSN_USER_NOTICE` WHERE `USER_ID`="
                + userId);
        whereSql.append(")");

        String orderBy = String.format("%s %s %s %s",
                FDataLogicNoticeLogic.DISPLAY_ORDER, "DESC,",
                FDataLogicNoticeLogic.CREATE_DATE, "DESC");
        FDataLogicNoticeLogic logic = logicContext
                .findLogic(FDataLogicNoticeLogic.class);
        FLogicDataset<FDataLogicNoticeUnit> moduleList = logic.fetch(
                whereSql.toString(), orderBy, pageSize, pageNum - 1);
        return moduleList;
    }

    // ============================================================
    // <T>分页获取当前用户未读的相关号令。</T>
    // @param pageNum 页数
    // @param pageSize 每页的行数
    // @param logicContext 逻辑上下文
    // ============================================================
    @Override
    public FLogicDataset<FDataPersonUserUnit> getUserCount(
            ILogicContext logicContext) {
        FSql whereSql = new FSql();
        whereSql.append(FDataPersonUserLogic.OVLD);
        whereSql.append("=");
        whereSql.append(1);
        whereSql.append(" AND ");
        whereSql.append(FDataPersonUserLogic.PASSPORT);
        whereSql.append(" LIKE 'oa%'");
        FDataPersonUserLogic logic = logicContext
                .findLogic(FDataPersonUserLogic.class);
        FLogicDataset<FDataPersonUserUnit> moduleList = logic.fetch(whereSql);
        return moduleList;
    }

    @Override
    public String markRead(String noticeGuid, long userId,
            ILogicContext logicContext) {
        FLoggerPersonUserNoticeLogic personUserNoticeLogic = logicContext
                .findLogic(FLoggerPersonUserNoticeLogic.class);
        FDataLogicNoticeLogic noticeLogic = logicContext
                .findLogic(FDataLogicNoticeLogic.class);
        FDataLogicNoticeUnit noticeUnit = noticeLogic.findByGuid(noticeGuid);

        FSql whereFSql = new FSql();
        whereFSql.append(FLoggerPersonUserNoticeLogic.NOTICE_ID);
        whereFSql.append("=");
        whereFSql.append(noticeUnit.ouid());
        whereFSql.append(" AND ");
        whereFSql.append(FLoggerPersonUserNoticeLogic.USER_ID);
        whereFSql.append("=");
        whereFSql.append(userId);
        FLogicDataset<FLoggerPersonUserNoticeUnit> units = personUserNoticeLogic
                .fetch(whereFSql);
        if (units != null && units.count() > 0) {
            // 如果已经阅读了不操作
        } else {
            // 如果还没有阅读,标志阅读
            FLoggerPersonUserNoticeUnit tempUnit = new FLoggerPersonUserNoticeUnit();
            tempUnit.setUserId(userId);
            tempUnit.setNoticeId(noticeUnit.ouid());
            personUserNoticeLogic.doInsert(tempUnit);
        }
        return "Success";
    }
}
