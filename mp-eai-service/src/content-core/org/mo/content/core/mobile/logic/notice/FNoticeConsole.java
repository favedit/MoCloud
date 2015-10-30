package org.mo.content.core.mobile.logic.notice;

import com.ahyc.eai.core.common.EDatabaseConnection;
import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import java.util.Iterator;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>号令控制台接口。</T>
//============================================================
public class FNoticeConsole extends FObject implements INoticeConsole {
    // 日志输出接口
    private static ILogger _logger = RLogger.find(FMobileService.class);
    // GcSession会话控制台
    @ALink
    protected IGcSessionConsole _sessionConsole;
    // 资源访问接口
    private static IResource _resource = RResource.find(FNoticeConsole.class);

    // ============================================================
    // <T>构造资源</T>
    // ============================================================
    public FNoticeConsole() {

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

    // ============================================================
    // <T>标记号令已读</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    @Override
    public String markRead(String noticeGuid, long userId,
            float locationLongitude, float locationLatitude,
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
            tempUnit.setLocationLongitude(locationLongitude);
            tempUnit.setLocationLatitude(locationLatitude);
            // 同时更新通知的view_count字段,,累加阅读次数
            noticeUnit.setViewCount(noticeUnit.viewCount() + 1);
            noticeLogic.doUpdate(noticeUnit);
            personUserNoticeLogic.doInsert(tempUnit);

        }
        return "Success";
    }

    // ============================================================
    // <T>号令发布</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    @Override
    public String noticePublish(String label, String content,
            ILogicContext logicContext) {
        FSql modelSql = _resource.findString(FSql.class, "sql.notice.publish");
        ISqlConnection connection = logicContext
                .activeConnection(EDatabaseConnection.Data);
        FDataset fetchDataset = connection.fetchDataset(modelSql);
        int maxDisplayOrder = -1;
        for (Iterator<FRow> iterator = fetchDataset.iterator(); iterator
                .hasNext();) {
            FRow row = iterator.next();
            maxDisplayOrder = row.getInt(0);
        }
        FDataLogicNoticeLogic noticeLogic = logicContext
                .findLogic(FDataLogicNoticeLogic.class);
        FDataLogicNoticeUnit tempUnit = new FDataLogicNoticeUnit();
        tempUnit.setStatusCd(EGcResourceStatus.Publish);
        tempUnit.setDisplayCd(EGcDisplay.Enabled);
        tempUnit.setDisplayOrder(maxDisplayOrder + 1);
        tempUnit.setOvld(true);
        tempUnit.setLabel(label);
        tempUnit.setDescription("紧急号令!");
        tempUnit.setContent(content);
        noticeLogic.doInsert(tempUnit);
        return null;
    }
}
