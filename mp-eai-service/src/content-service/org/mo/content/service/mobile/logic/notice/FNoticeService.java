package org.mo.content.service.mobile.logic.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Iterator;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.account.ILoginConsole;
import org.mo.content.core.mobile.logic.notice.INoticeConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
//<T>号令服务接口</T>
//============================================================
public class FNoticeService
      extends FObject
      implements
         INoticeService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNoticeService.class);

   // 号令逻辑控制台
   @ALink
   protected INoticeConsole _noticeConsole;

   // 配置文件注入属性
   @AProperty
   protected String _contentHost;

   @AProperty
   protected String _localHost;

   // GcSession会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   // 登录逻辑控制台
   @ALink
   protected ILoginConsole _loginConsole;

   // WebSession会话控制台
   @ALink
   protected IWebSessionConsole _webSessionConsole;

   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   // ============================================================
   // <T>分页获取号令相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult select(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext,
                         IWebSession sessionContext){
      _logger.debug(this, "select", "select from FNoticeService is beginning. ");
      int pageNum = 1, pageSize = 10;
      String pageSizeStr = input.config().findNode("pagesize").text();
      String pageNumStr = input.config().findNode("pagenumber").text();
      String sessionCode = context.head("mo-session-id");
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      // 查看用户是否有最新的公告
      FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
      FLogicDataset<FDataLogicNoticeUnit> noticeUnits = _loginConsole.isThereNotices(sessionInfo.userId(), sessionContext, logicContext, _sessionConsole, _webSessionConsole);
      if(noticeUnits != null && noticeUnits.count() > 0){
         output.config().createNode("notice").setText(noticeUnits.count());
      }else{
         output.config().createNode("notice").setText(-1);
      }
      FLogicDataset<FDataLogicNoticeUnit> units = _noticeConsole.select(pageNum, pageSize, sessionCode, logicContext);
      if(units != null && units.count() > 0){
         FXmlNode list = output.config().createNode("notice_list");
         FLogicDataset<FDataPersonUserUnit> userCount = _noticeConsole.getUserCount(logicContext);
         for(Iterator<FDataLogicNoticeUnit> iterator = units.iterator(); iterator.hasNext();){
            FDataLogicNoticeUnit unit = iterator.next();
            FXmlNode xruntime = list.createNode("notice_info");
            if(unit.createDate() != null && (!"".equals(unit.createDate()))){
               FXmlNode createNode = xruntime.createNode("create_date");
               createNode.setText(unit.createDate().format("yyyy/mm/dd hh:mi:ss"));
            }
            if(unit.label() != null && (!"".equals(unit.label()))){
               FXmlNode labelNode = xruntime.createNode("label");
               labelNode.setText(unit.label());
            }
            if(unit.description() != null && (!"".equals(unit.description()))){
               FXmlNode percentNode = xruntime.createNode("description");
               percentNode.setText(unit.description());
            }
            FXmlNode viewNode = xruntime.createNode("view_count");
            viewNode.setText(unit.viewCount());
            if(userCount != null && userCount.count() > 0){
               FXmlNode percentNode = xruntime.createNode("percent");
               NumberFormat numberFormat = NumberFormat.getInstance();
               numberFormat.setMaximumFractionDigits(0);
               numberFormat.setRoundingMode(RoundingMode.HALF_UP);
               String result = numberFormat.format((float)unit.viewCount() / (float)userCount.count() * 100);
               percentNode.setText(result);
            }
            if(unit.content() != null && (!"".equals(unit.content()))){
               FXmlNode contentNode = xruntime.createNode("content");
               contentNode.setText(unit.content());
            }
            if(unit.guid() != null && (!"".equals(unit.guid()))){
               FXmlNode urlNode = xruntime.createNode("notice_url");
               urlNode.setText(_contentHost + "mobile/logic/notice/Notice.wa?do=getInfo&notice_id=" + unit.guid());
            }
         }
      }else{
         output.config().createNode("message").setText("no order!");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>标记号令已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult markRead(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext){
      String sessionCode = context.head("mo-session-id");
      String noticeGuid = context.parameter("notice_id");
      String locationLongitude = context.parameter("location_longitude");
      String locationLatitude = context.parameter("location_latitude");
      float longitude = -1;
      if(RString.isNotEmpty(locationLongitude)){
         longitude = Float.parseFloat(locationLongitude);
      }
      float latitude = -1;
      if(RString.isNotEmpty(locationLatitude)){
         latitude = Float.parseFloat(locationLatitude);
      }
      if(RString.isNotEmpty(sessionCode)){
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
         long userId = sessionInfo.userId();
         _noticeConsole.markRead(noticeGuid, userId, longitude, latitude, logicContext);
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>号令发布</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult noticePublish(IWebContext context,
                                IWebInput input,
                                IWebOutput output,
                                ILogicContext logicContext){
      String label = context.parameter("label");
      String content = context.parameter("content");
      if(RString.isNotEmpty(RString.trimSplit(label, ' ')) && RString.isNotEmpty(RString.trimSplit(content, ' '))){
         _noticeConsole.noticePublish(label, content, logicContext);
         return EResult.Success;
      }else{
         return EResult.Failure;
      }
   }
}
