package com.ahyc.eai.service.cockpit.projectmanage;

import com.ahyc.eai.core.cockpit.projectmanage.IProjectManageConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>驾驶舱业绩处理。</T>
//============================================================
public class FCockpitProjectManageServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitProjectManageServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitProjectManageServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitProjectManageServlet.class);

   // 金融控制台
   @ALink
   protected IProjectManageConsole _projectManageConsole;

   //============================================================
   // <T>获得统计动态数据。</T>
   //
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
      // 检查参数
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
      //      try{
      //         String jsonStr = _projectManageConsole.getJson("4");
      //      }catch(ParseException e){
      //         e.printStackTrace();
      //      }catch(IOException e){
      //         e.printStackTrace();
      //      }
      String jsonStr = "[{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"台账管理系统\",\"uname\": \"王丽娟\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]}]";
      JSONArray jsonOutArray = JSONArray.fromObject(jsonStr);
      int count = jsonOutArray.size();
      dataStream.writeInt32(count);
      for(int j = 0; j < jsonOutArray.size(); j++){
         //获取数据
         JSONObject fromObject = jsonOutArray.getJSONObject(j);
         String name = fromObject.get("name").toString();
         String uname = fromObject.get("uname").toString();
         String priority = fromObject.get("priority").toString();
         String status = fromObject.get("status").toString();
         //输出数据
         dataStream.writeString(name);//项目标题
         dataStream.writeString(uname);//责任人
         dataStream.writeString(priority);//优先级 0-低 1-中 2-高
         dataStream.writeString(status);//状态指示灯 0-项目超前 1-项目正常 2-项目逾期
         JSONArray jsonInArray = fromObject.getJSONArray("progress");
         for(int i = 0; i < jsonInArray.size(); i++){
            JSONObject jsonInObject = jsonInArray.getJSONObject(i);
            String key = jsonInObject.get("key").toString();
            String progress = jsonInObject.get("progress").toString();
            dataStream.writeString(key);//进度标题 时间进度或项目进度
            dataStream.writeString(progress);//进度百分比
         }
      }
      stream.write(dataStream.memory(), 0, dataStream.position());
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send dynamic. (date={1}, data_length={2},count={3})", currentDate.format(), dataLength, count);
      return sendStream(context, request, response, stream);
   }
}
