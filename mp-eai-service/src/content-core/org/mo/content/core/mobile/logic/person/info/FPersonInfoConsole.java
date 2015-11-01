package org.mo.content.core.mobile.logic.person.info;

import org.mo.content.service.city.info.FMobileService;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;

//============================================================
// <T>登录控制台。</T>
//============================================================
public class FPersonInfoConsole
      extends FObject
      implements
         IPersonInfoConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   // 用户添加日志控制台
   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   // 从src/config/service/core.xml配置文件注入属性
   @AProperty
   protected boolean _oaLoginEnable;

   // 从src/config/service/core.xml配置文件注入属性
   @AProperty
   protected String _oaLoginUrl;

   // ============================================================
   // <T>构造资源</T>
   // ============================================================
   public FPersonInfoConsole(){

   }

   // ============================================================
   // @获取已经登录的用户信息
   // @param user_id 用户id
   // @param logicContext 逻辑上下文
   // ============================================================
   @Override
   public FDataPersonInfo getUserInfo(long user_id,
                                      ILogicContext logicContext){
      FDataPersonInfo userInfo = new FDataPersonInfo();
      FDataPersonUserSigningLogic signingLogic = logicContext.findLogic(FDataPersonUserSigningLogic.class);
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FSql userFSql = new FSql();
      userFSql.append(FDataPersonUserLogic.OUID);
      userFSql.append("=");
      userFSql.append(user_id);
      FLogicDataset<FDataPersonInfo> userInfos = userLogic.fetchClass(FDataPersonInfo.class, userFSql);
      if(userInfos != null && userInfos.count() > 0){
         userInfo = userInfos.first();
      }

      // %Y-%m-%d %T
      String sql = "SELECT DATE_FORMAT(MAX(SINGN_DATE) ,'%Y-%m-%d %H:%i:%s') AS LAST_SIGN_DATE FROM DT_PSN_USER_SIGNING WHERE `USER_ID`=" + user_id;
      FRow rowData = signingLogic.connection().find(sql);
      String Last_sign_date = rowData.get("last_sign_date");
      _logger.debug(this, "getUserInfo", "----------------------------*****>Last_sign_date={1}", Last_sign_date);
      userInfo.setLast_sign_date(Last_sign_date);
      return userInfo;
   }

   // ============================================================
   // @查看当前用户是否有最新的公告
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================

   @Override
   public FLogicDataset<FDataLogicNoticeUnit> isThereNotices(long userId,
                                                             IWebSession sessionContext,
                                                             ILogicContext logicContext,
                                                             IGcSessionConsole _sessionConsole,
                                                             IWebSessionConsole _webSessionConsole){
      FDataLogicNoticeLogic noticeLogic = logicContext.findLogic(FDataLogicNoticeLogic.class);
      FSql whereSql2 = new FSql();
      whereSql2.append(FDataLogicNoticeLogic.STATUS_CD);
      whereSql2.append("=");
      whereSql2.append(EGcResourceStatus.Publish);
      whereSql2.append(" AND ");
      whereSql2.append(FDataLogicNoticeLogic.DISPLAY_CD);
      whereSql2.append("=");
      whereSql2.append(EGcDisplay.Enabled);
      whereSql2.append(" AND ");
      whereSql2.append(FDataLogicNoticeLogic.OUID);
      whereSql2.append(" NOT in (SELECT `NOTICE_ID` FROM `EAI_DATA`.`DT_PSN_USER_NOTICE` WHERE `USER_ID`=" + userId);
      whereSql2.append(")");
      FLogicDataset<FDataLogicNoticeUnit> moduleList = noticeLogic.fetch(whereSql2);
      return moduleList;

   }
}
