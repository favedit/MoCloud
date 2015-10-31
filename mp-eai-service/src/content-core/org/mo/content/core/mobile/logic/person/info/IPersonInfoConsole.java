package org.mo.content.core.mobile.logic.person.info;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;

//============================================================
//<T>d登录控制台接口。</T>
//============================================================
public interface IPersonInfoConsole
{
   // ============================================================
   // @获取已经登录的用户信息
   // @param user_id 用户id
   // @param logicContext 逻辑上下文
   // ============================================================
   public FDataPersonInfo getUserInfo(long user_id,
                                      ILogicContext logicContext);

   // ============================================================
   // @查看当前用户是否有最新的公告
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================
   public FLogicDataset<FDataLogicNoticeUnit> isThereNotices(long userId,
                                                             IWebSession sessionContext,
                                                             ILogicContext logicContext,
                                                             IGcSessionConsole _sessionConsole,
                                                             IWebSessionConsole _webSessionConsole);
}
