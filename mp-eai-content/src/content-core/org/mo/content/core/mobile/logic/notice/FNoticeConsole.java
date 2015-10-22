package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeUnit;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

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

    // ============================================================
    // <T>标记通告已读务接口。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    @Override
    public FDataLogicNoticeUnit markRead(long userId,
            IWebSession sessionContext, ILogicContext logicContext) {
        FLoggerPersonUserNoticeLogic personUserNoticeLogic = logicContext
                .findLogic(FLoggerPersonUserNoticeLogic.class);
        FDataLogicNoticeLogic noticeLogic = logicContext
                .findLogic(FDataLogicNoticeLogic.class);
        long resultLong = personUserNoticeLogic.connection().executeLong(
                "SELECT MIN(`NOTICE_ID`) FROM `LG_PSN_USER_NOTICE` WHERE `USER_ID`="
                        + userId);
        _logger.debug(this, "markRead",
                "markRead From FNoticeConsole begin resultLong={1}", resultLong);
        // 如果是0意味着没有找到,把该用户的最新公告标志已读同时返回下一条最新公告
        FSql whereSqlFirst = new FSql();
        whereSqlFirst.append(FDataLogicNoticeLogic.CREATE_DATE);
        whereSqlFirst
                .append(" =(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1)");
        FLogicDataset<FDataLogicNoticeUnit> noticeUnitsFirst = noticeLogic
                .fetch(whereSqlFirst);
        if (resultLong == 0) {
            if (noticeUnitsFirst != null && noticeUnitsFirst.count() > 0) {
                FDataLogicNoticeUnit noticeUnit = noticeUnitsFirst.first();
                FLoggerPersonUserNoticeUnit tempUnit = new FLoggerPersonUserNoticeUnit();
                tempUnit.setUserId(userId);
                tempUnit.setNoticeId(noticeUnit.ouid());
                tempUnit.setOvld(true);
                personUserNoticeLogic.doInsert(tempUnit);
                FSql whereSql2 = new FSql();
                whereSql2.append(FDataLogicNoticeLogic.CREATE_DATE);
                whereSql2
                        .append(" =(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1 AND `N1`.`OUID`<"
                                + noticeUnit.ouid() + ")");
                return noticeLogic.fetch(whereSql2).first();
            }
        } else {
            // 如果找到,意味着用户已经读过公告,继续标志下一条已读
            // 1 × 2 × 3 × 4 ×
            FSql whereSql3 = new FSql();
            whereSql3.append(FDataLogicNoticeLogic.CREATE_DATE);
            whereSql3
                    .append(" =(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `STATUS_CD`=2 AND `DISPLAY_CD`=1 AND `OUID`<"
                            + resultLong + ")");
            FLogicDataset<FDataLogicNoticeUnit> noticeUnits = noticeLogic
                    .fetch(whereSql3);
            if (noticeUnits != null && noticeUnits.count() > 0) {
                FLoggerPersonUserNoticeUnit tempUnit = new FLoggerPersonUserNoticeUnit();
                tempUnit.setOvld(true);
                tempUnit.setUserId(userId);
                tempUnit.setNoticeId(noticeUnits.first().ouid());
                personUserNoticeLogic.doInsert(tempUnit);
                FSql whereSql4 = new FSql();
                whereSql4.append(FDataLogicNoticeLogic.CREATE_DATE);
                whereSql4
                        .append(" =(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1 AND `N1`.`OUID`<"
                                + noticeUnits.first().ouid() + ")");
                return noticeLogic.fetch(whereSql4).first();
            } else {
                // 1 √ 2 √ 3 × 4 ×逻辑
                FSql whereSql5 = new FSql();
                whereSql5.append(FLoggerPersonUserNoticeLogic.CREATE_DATE);
                whereSql5
                        .append("=(SELECT MIN(`CREATE_DATE`) FROM `LG_PSN_USER_NOTICE` AS PUN1  WHERE PUN1.`USER_ID`="
                                + userId + ")");
                FLoggerPersonUserNoticeUnit minUnit1 = personUserNoticeLogic
                        .fetch(whereSql5).first();

                FSql whereSql6 = new FSql();
                whereSql6.append(FLoggerPersonUserNoticeLogic.CREATE_DATE);
                whereSql6
                        .append("=(SELECT MAX(`CREATE_DATE`) FROM `LG_PSN_USER_NOTICE` AS PUN1  WHERE PUN1.`USER_ID`="
                                + userId + ")");
                FLoggerPersonUserNoticeUnit maxUnit2 = personUserNoticeLogic
                        .fetch(whereSql6).first();

                FSql whereSql7 = new FSql();
                whereSql7.append(FLoggerPersonUserNoticeLogic.CREATE_DATE);
                whereSql7
                        .append("=(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1 AND N1.OUID<"
                                + maxUnit2.noticeId()
                                + " AND N1.OUID>"
                                + minUnit1.noticeId() + ")");
                FLogicDataset<FDataLogicNoticeUnit> noticeUnits2 = noticeLogic
                        .fetch(whereSql7);
                FDataLogicNoticeUnit noticeUnitFirst = noticeUnitsFirst.first();
                long noticeUnitFirstOuid = noticeUnitFirst.ouid();
                FSql whereSql10 = new FSql();
                whereSql10.append(FLoggerPersonUserNoticeLogic.NOTICE_ID);
                whereSql10.append("=");
                whereSql10.append(noticeUnitFirstOuid);
                FLogicDataset<FLoggerPersonUserNoticeUnit> fetch2 = personUserNoticeLogic
                        .fetch(whereSql10);
                if (fetch2 == null || fetch2.count() < 1) {
                    FLoggerPersonUserNoticeUnit tempUnit = new FLoggerPersonUserNoticeUnit();
                    tempUnit.setOvld(true);
                    tempUnit.setUserId(userId);
                    tempUnit.setNoticeId(noticeUnitFirstOuid);
                    personUserNoticeLogic.doInsert(tempUnit);
                    FSql whereSql9 = new FSql();
                    whereSql9.append(FDataLogicNoticeLogic.CREATE_DATE);
                    whereSql9
                            .append("=(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1 AND N1.OUID<"
                                    + noticeUnitFirstOuid + ")");
                    FLogicDataset<FDataLogicNoticeUnit> fetchSS = noticeLogic
                            .fetch(whereSql9);
                    if (fetchSS != null && fetchSS.count() > 0) {
                        return fetchSS.first();
                    }
                }
                if (noticeUnits2 != null && noticeUnits2.count() > 0) {
                    FLoggerPersonUserNoticeUnit tempUnit = new FLoggerPersonUserNoticeUnit();
                    tempUnit.setOvld(true);
                    tempUnit.setUserId(userId);
                    tempUnit.setNoticeId(noticeUnits2.first().ouid());
                    personUserNoticeLogic.doInsert(tempUnit);
                    FSql whereSql8 = new FSql();
                    whereSql8.append(FDataLogicNoticeLogic.CREATE_DATE);
                    whereSql8
                            .append("=(SELECT MAX(`CREATE_DATE`) FROM `DT_LGC_NOTICE` AS N1 WHERE `N1`.`STATUS_CD`=2 AND `N1`.`DISPLAY_CD`=1 AND N1.OUID<"
                                    + noticeUnits2.first().ouid()
                                    + " AND N1.OUID>"
                                    + minUnit1.noticeId()
                                    + ")");
                    FLogicDataset<FDataLogicNoticeUnit> fetch = noticeLogic
                            .fetch(whereSql8);
                    if (fetch != null && fetch.count() > 0) {
                        return fetch.first();
                    }

                }
            }

        }
        return null;
    }
}
