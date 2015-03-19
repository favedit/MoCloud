package org.mo.cloud.content.design.configuration.common;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.jfa.face.logic.process.FProcessSyncArgs;
import org.mo.jfa.face.logic.schedule.FScheduleSyncArgs;
import org.mo.web.protocol.context.IWebInput;

//============================================================
// <T>配置基础对象。</T>
//============================================================
public class FAbstractConfigurationBase
      extends FObject
{
   public final static String ACTION_SORT = "sortAction";

   public final static String NODE_ENVIRONMENT = "Environment";

   public final static String NAME_SORT = "sortList";

   public final static String TYPE_COLLECTION = "collection";

   public final static String TYPE_COMPONENT = "component";

   public final static String PTY_TYPE = "_type";

   public final static String PTY_IS_VALID = "is_valid";

   public final static String PTY_NAME = "name";

   public final static String PTY_LABEL = "label";

   protected int _processConditionOrder = 0;

   protected int _processEventOrder = 0;

   protected int _taskConditionOrder = 0;

   protected int _taskEventOrder = 0;

   // 存储处理业务流程PLSQL代理类容器
   protected FProcessSyncArgs _processSyncArgs;

   protected FScheduleSyncArgs _scheduleSyncArgs;

   //============================================================
   // <T>获得系统上传的环境设置。</T>
   //
   // @param input 上传数据
   // @return 环境设置
   //============================================================
   public FXmlNode getEnvironmentNode(IWebInput input){
      FXmlNode xconfig = input.config().findNode(NODE_ENVIRONMENT);
      if(xconfig == null){
         throw new FFatalError("Can't find environment config.");
      }
      return xconfig;
   }

   //============================================================
   // <T>获得系统上传的选择设置。</T>
   //
   // @param input 上传数据
   // @return 选择设置
   //============================================================
   public FXmlNode getSelectNode(IWebInput input){
      FXmlNode xconfig = input.config().node("Node");
      if(xconfig == null){
         xconfig = input.config().findNode("TreeNode");
      }
      if(xconfig == null){
         throw new FFatalError("Can't find select node.");
      }
      return xconfig;
   }

   //============================================================
   // <T>获得系统上传的数据设置。</T>
   //
   // @param input 上传数据
   // @return 数据设置
   //============================================================
   public FXmlNode getDataNode(IWebInput input){
      FXmlNode xconfig = input.config().findNode("Data");
      if(xconfig == null){
         throw new FFatalError("Can't find data config.");
      }
      return xconfig;
   }

}
