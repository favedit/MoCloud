package org.mo.content.core.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface INoticeConsole {
    // ============================================================
    // <T>根据guid获取新闻相关信息。</T>
    // @param guid
    // @param logicContext 逻辑上下文
    // ============================================================
    FDataLogicNoticeUnit getNewsByGuid(String guid, ILogicContext logicContext);

    // ============================================================
    // <T>分页获取新闻相关信息。</T>
    // @param pageNum 页数
    // @param pageSize 每页的行数
    // @param logicContext 逻辑上下文
    // ============================================================
    FLogicDataset<FDataLogicNoticeUnit> select(int pageNum, int pageSize,
            String sessionCode, ILogicContext logicContext);

    // ============================================================
    // <T>分页获取新闻相关信息。</T>
    // @param pageNum 页数
    // @param pageSize 每页的行数
    // @param logicContext 逻辑上下文
    // ============================================================

    public FLogicDataset<FDataPersonUserUnit> getUserCount(
            ILogicContext logicContext);

    // ============================================================
    // <T>分页获取号令相关信息。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    String markRead(String noticeGuid, long userId, float locationLongitude,
            float locationLatitude, ILogicContext logicContext);

    // ============================================================
    // <T>分页获取号令相关信息。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    String noticePublish(String label, String content,
            ILogicContext logicContext);
}
