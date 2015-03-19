package org.mo.cloud.content.design.configuration;

import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>配置定义。</T>
//============================================================
public class RContentConfiguration
{
   // 节点过滤
   public final static String PTY_NODE_FILTER = "node_filter";

   // 节点排序
   public final static String PTY_NODE_SORT = "node_sort";

   // 节点类型
   public final static String PTY_NODE_TYPE = "node_type";

   // 存储代码
   public final static String PTY_STORAGE_CODE = "storage_code";

   // 集合代码
   public final static String PTY_COLLECTION_CODE = "collection_code";

   // 组件代码
   public final static String PTY_COMPONENT_CODE = "component_code";

   // 表单名称
   public final static String PTY_FRAME_CODE = "frame_code";

   // 表单服务
   public final static String PTY_FRAME_SERVICE = "frame_service";

   // 类型名称
   public final static String PTY_TYPE = "_type";

   // 名称
   public final static String PTY_NAME = "name";

   // 节点命令集合
   public final static String NODE_COMMANDS = "Commands";

   // 节点命令
   public final static String NODE_COMMAND = "Command";

   // 目录节点刷新
   public final static String CMD_TREE_NODE_REFRESH = "tree.node.refresh";

   // 目录刷新
   public final static String CMD_TREE_REFRESH = "tree.refresh";

   // 目录重加载
   public final static String CMD_TREE_RELOAD = "tree.reload";

   public static FXmlNode commandsNode(IWebOutput output){
      FXmlNode commands = output.config().nodes().findNode(NODE_COMMANDS);
      if(null == commands){
         commands = output.config().nodes().create(NODE_COMMANDS);
      }
      return commands;
   }

   public static void setPageRedirect(IWebOutput output,
                                      String page){
      FXmlNode commands = commandsNode(output);
      FXmlNode command = commands.createNode(NODE_COMMAND);
      command.set(PTY_NAME, "page.redirect");
      String[] items = RString.splitTwo(page, '@', true);
      if(null == items){
         command.set("page", page);
      }else{
         command.set("action", items[0]);
         command.set("page", items[1]);
      }
   }

   //============================================================
   // <T>刷新树目录当前节点的父节点。</T>
   //
   // @param output 网络输出
   //============================================================
   public static void setTreeParentRefresh(IWebOutput output){
      FXmlNode xcommands = commandsNode(output);
      FXmlNode xcommand = xcommands.createNode(NODE_COMMAND);
      xcommand.set(PTY_NAME, CMD_TREE_NODE_REFRESH);
   }

   //============================================================
   // <T>刷新树目录当前节点的父节点。</T>
   //
   // @param output 网络输出
   // @param guid 唯一编号
   //============================================================
   public static void setTreeNodeRefresh(IWebOutput output,
                                         String guid){
      FXmlNode xcommands = commandsNode(output);
      FXmlNode xcommand = xcommands.createNode(NODE_COMMAND);
      xcommand.set(PTY_NAME, CMD_TREE_NODE_REFRESH);
      xcommand.set("guid", guid);
   }

   //============================================================
   // <T>刷新树目录当前节点的父节点。</T>
   //
   // @param output 网络输出
   //============================================================
   public static void setTreeRefresh(IWebOutput output){
      FXmlNode xcommands = commandsNode(output);
      FXmlNode xcommand = xcommands.createNode(NODE_COMMAND);
      xcommand.set(PTY_NAME, CMD_TREE_REFRESH);
   }

   public static void setTreeReload(IWebOutput output){
      FXmlNode commands = commandsNode(output);
      FXmlNode command = commands.createNode(NODE_COMMAND);
      command.set(PTY_NAME, CMD_TREE_RELOAD);
   }
}
