package com.ahyc.eai.service.cockpit.notice;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import java.math.RoundingMode;
import java.text.NumberFormat;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.mobile.logic.notice.FNoticeModel;
import org.mo.content.core.mobile.logic.notice.INoticeConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>号令接口。</T>
//============================================================
public class FCockpitNoticeServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitNoticeServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitNoticeServlet.class);

   // 号令逻辑控制台
   @ALink
   protected INoticeConsole _noticeConsole;

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>号令列表</T>
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      _logger.debug(this, "fetch", "the method named fetch from FCockpitTrendServlet is beginning... ");
      //检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + currentDate.format("YYYYMMDDHH24MI");
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      FByteStream dataStream = createStream(context);
      //组合号令数据
      FLogicDataset<FNoticeModel> logicDataset = _noticeConsole.fetch(1, 5, null, logicContext);
      FLogicDataset<FDataPersonUserUnit> userUnits = _noticeConsole.getUserCount(logicContext);
      int userCount = -1;
      if(userUnits != null && userUnits.count() > 0){
         userCount = userUnits.count();
      }
      NumberFormat numberFormat = NumberFormat.getInstance();
      numberFormat.setMaximumFractionDigits(0);
      numberFormat.setRoundingMode(RoundingMode.HALF_UP);
      int count = logicDataset.count();
      dataStream.writeInt32(count);
      for(FNoticeModel unit : logicDataset){
         //计算数据
         String label = unit.label();
         String userLabel = unit.userLabel();
         String publishDate = unit.createDate().format("yyyy/mm/dd");
         String percent = numberFormat.format(unit.viewCount() / (float)userCount * 100);
         _logger.debug(this, "fetch", "Send dynamic. (label={1},userLabel={2},publishDate={3},percent={4})", label, userLabel, publishDate, percent);
         //输出数据
         dataStream.writeString(label);
         dataStream.writeString(userLabel);
         dataStream.writeString(publishDate);
         dataStream.writeString(percent);
      }
      //写入数据
      stream.write(dataStream.memory(), 0, dataStream.position());
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send data notice dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
