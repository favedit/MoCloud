package com.cyou.gccloud.service.system.session;

import com.cyou.gccloud.service.data.cache.FCacheSystemSessionLogic;
import com.cyou.gccloud.service.data.cache.FCacheSystemSessionUnit;
import org.mo.com.console.FConsole;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>系统会话控制台。</T>
//============================================================
public class FSessionConsole
      extends FConsole
      implements
         ISessionConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSessionConsole.class);

   //============================================================
   // <T>打开一个会话。</T>
   //
   // @return 会话信息
   //============================================================
   @Override
   public FSessionInfo open(ISqlContext sqlContext,
                            long userId){
      // 生成唯一码
      String sessionCode = RUuid.makeUuid();
      sessionCode = RString.removeChars(sessionCode, '-').toUpperCase();
      // 设置数据单元
      FCacheSystemSessionUnit sessionUnit = new FCacheSystemSessionUnit();
      sessionUnit.setCode(sessionCode);
      sessionUnit.setUserId(userId);
      // 新建记录
      FCacheSystemSessionLogic sessionLogic = new FCacheSystemSessionLogic(sqlContext.activeConnection("CD_CACHE"));
      sessionLogic.doInsert(sessionUnit);
      _logger.debug(this, "open", "Open session. (code={1})", sessionUnit.code());
      // 返回结果
      FSessionInfo sessionInfo = new FSessionInfo(sessionUnit);
      return sessionInfo;
   }

   //============================================================
   // <T>查找一个会话。</T>
   //
   // @param code 代码
   // @return 会话信息
   //============================================================
   @Override
   public FSessionInfo find(ISqlContext sqlContext,
                            String code){
      // 新建记录
      FCacheSystemSessionLogic sessionLogic = new FCacheSystemSessionLogic(sqlContext);
      FCacheSystemSessionUnit sessionUnit = sessionLogic.serach("CODE='" + code + "'");
      // 返回结果
      FSessionInfo sessionInfo = new FSessionInfo(sessionUnit);
      return sessionInfo;
   }

   //============================================================
   // <T>关闭一个会话。</T>
   //
   // @param session 会话信息
   //============================================================
   @Override
   public void close(FSessionInfo session){
      // TODO Auto-generated method stub
   }

}
