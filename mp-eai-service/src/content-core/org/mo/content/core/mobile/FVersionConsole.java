package org.mo.content.core.mobile;

import com.cyou.gccloud.data.data.FDataSystemApplicationLogic;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import java.util.HashMap;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>版本更新控制台。</T>
//============================================================
public class FVersionConsole
      extends FObject
      implements
         IVersionConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FVersionConsole(){

   }

   //============================================================
   // @连接服务器获得新版本
   // @param context 页面环境
   // @param versionStr 版本号
   // @param applicationStr 应用程序id
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public HashMap<String, Object> connect(IWebContext context,
                                          String versionStr,
                                          String applicationStr,
                                          ILogicContext logicContext,
                                          IWebSession sessionContext){
      _logger.debug(this, "************************FVersionConsole_connect", "versionStr={1},applicationStr={2}", versionStr, applicationStr);
      HashMap<String, Object> map = new HashMap<String, Object>();
      FDataSystemApplicationLogic applicationLogic = logicContext.findLogic(FDataSystemApplicationLogic.class);
      //根据applicationStr找见对应应用的id
      FSql whereSql4 = new FSql();
      whereSql4.append(FDataSystemApplicationLogic.GUID);
      whereSql4.append("='");
      whereSql4.append(applicationStr);
      whereSql4.append("'");
      FLogicDataset<FDataSystemApplicationUnit> applications = applicationLogic.fetch(whereSql4);
      long applicationOuid = -1;
      if(applications != null && applications.count() > 0){
         applicationOuid = applications.first().ouid();
         map.put("app_os", applications.first().code());
      }
      FDataSystemVersionLogic versionLogic = logicContext.findLogic(FDataSystemVersionLogic.class);
      double lastVersionCode = versionLogic.connection().executeDouble("SELECT MAX(NUMBER) AS LASTVERSION FROM `DT_SYS_VERSION` WHERE `APPLICATION_ID`=" + applicationOuid + " AND `STATUS_CD`=" + EGcResourceStatus.Publish);
      //如果是0,,意味着没有找到对应的app
      if(lastVersionCode != 0){
         //拿出来最新的version
         FSql where = new FSql();
         where.append(FDataSystemVersionLogic.APPLICATION_ID);
         where.append("=");
         where.append(applicationOuid);
         where.append(" AND ");
         where.append(FDataSystemVersionLogic.NUMBER);
         where.append("=");
         where.append(lastVersionCode);
         FLogicDataset<FDataSystemVersionUnit> lastVersionUnits = versionLogic.fetch(where);
         if(lastVersionUnits != null && lastVersionUnits.count() > 0){
            FDataSystemVersionUnit lastVersionUnit = lastVersionUnits.first();
            map.put("lastVersion", lastVersionUnit);
            //获取版本id
            _logger.debug(this, "************************getLastVersion", "version_code={1},version_label={2}", lastVersionUnit.code(), lastVersionUnit.label());
         }

      }
      return map;
   }

   //============================================================
   // @断开与服务器的连接
   // @param context 页面环境
   // @param sessionCode 会话码
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult disconnect(IWebContext context,
                             String sessionCode,
                             ILogicContext logicContext,
                             IWebSession sessionContext,
                             IWebSessionConsole _sessionConsole){
      _logger.debug(this, "************************FVersionConsole_disconnect", "sessionCode={1},sessionContext={2}", sessionCode, sessionContext);
      // 清空session
      FGcWebSession session = (FGcWebSession)sessionContext;
      EResult result = _sessionConsole.close(session);
      return result;
   }

}
