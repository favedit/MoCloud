package org.mo.content.service.solution;

import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import com.cyou.gccloud.data.data.FDataSolutionProjectUnit;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.solution.project.IC3dProjectConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D服务。</T>
//============================================================
public class FProjectService
      extends FObject
      implements
         IProjectService
{
   // 项目控制台接口
   @ALink
   protected IC3dProjectConsole _projectConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FProjectService(){
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      String typeCd = context.parameter("type_cd");
      String serach = context.parameter("serach");
      int pageSize = context.parameterAsInteger("page_size", 20);
      int page = context.parameterAsInteger("page", 0);
      // 设置输出节点
      FXmlNode xoutput = output.config().createNode("ItemCollection");
      xoutput.set("page_count", 0);
      xoutput.set("page_size", pageSize);
      xoutput.set("page", page);
      //............................................................
      // 查询数据
      switch(typeCd){
         case "private":
            // 查找位图
            _projectConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "team":
            // 查找声音
            _projectConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         case "share":
            // 查找视频
            _projectConsole.fetch(logicContext, xoutput, serach, pageSize, page);
            break;
         default:
            throw new FFatalError("Unknown resource type. (type_cd={1})", typeCd);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      FXmlNode xinput = input.config();
      String guid = xinput.get("guid");
      FDataSolutionProjectUnit unit = _projectConsole.query(logicContext, guid);
      FXmlNode xproject = output.config().createNode("Project");
      xproject.set("code", unit.code());
      xproject.set("label", unit.label());
      return EResult.Success;
   }

   //============================================================
   // <T>新建数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult insert(IWebContext context,
                         ILogicContext logicContext,
                         FGcSessionInfo session,
                         IWebInput input,
                         IWebOutput output){
      FXmlNode xdata = input.config().findNode("Data");
      String code = xdata.get("code");
      String label = xdata.get("label");
      FDataSolutionProjectLogic logic = logicContext.findLogic(FDataSolutionProjectLogic.class);
      FDataSolutionProjectUnit unit = logic.doPrepare();
      unit.setUserId(session.userId());
      unit.setCode(code);
      unit.setLabel(label);
      logic.doInsert(unit);
      return EResult.Success;
   }

   //============================================================
   // <T>修改数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult upate(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>删除数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      String guid = input.config().get("guid");
      FDataSolutionProjectLogic logic = logicContext.findLogic(FDataSolutionProjectLogic.class);
      FDataSolutionProjectUnit unit = logic.findByGuid(guid);
      logic.doDelete(unit);
      return EResult.Success;
   }
}
