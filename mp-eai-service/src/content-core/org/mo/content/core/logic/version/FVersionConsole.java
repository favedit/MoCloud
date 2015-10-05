package org.mo.content.core.logic.version;

import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionResourceLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionResourceUnit;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import java.util.HashMap;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.FWebSession;
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
      //      FDataSystemApplicationLogic systemApplication = logicContext.findLogic(FDataSystemApplicationLogic.class);
      FDataSystemVersionResourceLogic versionResource = logicContext.findLogic(FDataSystemVersionResourceLogic.class);
      FDataSystemVersionLogic versionLogic = logicContext.findLogic(FDataSystemVersionLogic.class);
      long appVersionCode = Long.parseLong(versionStr);
      long lastVersionCode = versionLogic.connection().executeLong("SELECT MAX(CAST(CODE AS SIGNED)) AS LASTVERSION FROM `DT_SYS_VERSION` WHERE `APPLICATION_ID`=" + applicationStr);
      //如果是0,,意味着没有找到对应的app
      if(lastVersionCode != 0){
         //如果最新版本号大于当前版本号则提示更新
         if(lastVersionCode > appVersionCode){
            //拿出来最新的version
            FSql where = new FSql();
            where.append(FDataSystemVersionLogic.APPLICATION_ID);
            where.append("=");
            where.append(applicationStr);
            where.append(" AND ");
            where.append(FDataSystemVersionLogic.CODE);
            where.append("=");
            where.append(lastVersionCode);
            FLogicDataset<FDataSystemVersionUnit> lastVersionUnits = versionLogic.fetch(where);
            if(lastVersionUnits != null && lastVersionUnits.count() > 0){
               FDataSystemVersionUnit lastVersionUnit = lastVersionUnits.first();
               map.put("lastVersion", lastVersionUnit);
               //获取版本id
               long versionOuid = lastVersionUnit.ouid();
               _logger.debug(this, "************************getLastVersion", "versionCode={1},versionLabel={2}", lastVersionUnit.code(), lastVersionUnit.label());
               //通过版本去找对应的版本资源
               FSql whereSql = new FSql();
               whereSql.append(FDataSystemVersionResourceLogic.APPLICATION_ID);
               whereSql.append("=");
               whereSql.append(applicationStr);
               whereSql.append(" AND ");
               whereSql.append(FDataSystemVersionResourceLogic.VERSION_ID);
               whereSql.append("=");
               whereSql.append(versionOuid);
               FLogicDataset<FDataSystemVersionResourceUnit> versionResourceUnits = versionResource.fetch(whereSql);
               if(versionResourceUnits != null && versionResourceUnits.count() > 0){
                  map.put("lastVersionResource", versionResourceUnits.first());
               }
            }
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
      FWebSession session = (FWebSession)sessionContext;
      EResult result = _sessionConsole.close(session);
      return result;
   }

}
