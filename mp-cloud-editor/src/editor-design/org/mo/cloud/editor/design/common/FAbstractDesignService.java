package org.mo.cloud.editor.design.common;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.tree.common.XTreeNode;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.common.ECatalogNodeGroup;
import org.mo.content.core.common.EContentConstants;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>设计基础服务。</T>
//============================================================
public abstract class FAbstractDesignService
      extends FObject
{
   //============================================================
   // <T>构造设计基础服务。</T>
   //============================================================
   public FAbstractDesignService(){
   }

   //============================================================
   // <T>获得内容列表处理。</T>
   //
   // @return 内容列表
   //============================================================
   protected abstract XContentObject[] contentList();

   //============================================================
   // <T>查找配置定义处理。</T>
   //
   // @param containerName 容器名称
   // @param modeCd 持久化模式
   // @return 内容对象
   //============================================================
   protected abstract FContentObject contentFindDefine(String containerName,
                                                       EPersistenceMode modeCd);

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param content 内容
   //============================================================
   protected abstract void contentUpdate(FContentObject content);

   //============================================================
   // <T>建立目录节点。</T>
   //
   // @param xconfig 配置节点
   // @param xcontainer 配置节点
   // @param groupCd 类型
   // @return 目录节点
   //============================================================
   public XTreeNode buildTreeNode(FXmlNode xconfig,
                                  XContentObject xcontent,
                                  String groupCd,
                                  boolean shortFlag){
      String name = xcontent.getString("name");
      String shortName = null;
      if(shortFlag){
         shortName = RString.right(name, ".");
      }else{
         shortName = name;
      }
      XTreeNode xnode = new XTreeNode();
      xnode.setIsValid(true);
      xnode.setTypeGroup(groupCd);
      xnode.setTypeCode(xcontent.name());
      xnode.setHasChild(xcontent.hasChild());
      xnode.setGuid(xcontent.contentGuid());
      xnode.setLabel(shortName);
      xnode.setCode(name);
      xnode.setNote(xcontent.getString("label", ""));
      xnode.saveConfig(xconfig.createNode("TreeNode"));
      return xnode;
   }

   //============================================================
   // <T>建立目录节点。</T>
   //
   // @param xconfig 配置节点
   // @param xcontainer 配置节点
   // @param groupCd 类型
   // @return 目录节点
   //============================================================
   public XTreeNode buildTreeNode(FXmlNode xconfig,
                                  FContentObject xcontent,
                                  String groupCd){
      XTreeNode xnode = new XTreeNode();
      xnode.setIsValid(true);
      xnode.setTypeGroup(groupCd);
      xnode.setTypeCode(xcontent.name());
      xnode.setHasChild(xcontent.hasNode());
      xnode.setGuid(xcontent.objectId());
      xnode.setLabel(xcontent.get("name"));
      xnode.setNote(xcontent.get("label", ""));
      xnode.saveConfig(xconfig.createNode("TreeNode"));
      return xnode;
   }

   //============================================================
   // <T>获得目录分组处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   public EResult catalogPackage(IWebContext context,
                                 IWebInput input,
                                 IWebOutput output){
      XContentObject[] xcontainers = contentList();
      FXmlNode xconfig = output.config();
      // 容器分组
      FAttributes packages = new FAttributes();
      for(XContentObject xframe : xcontainers){
         String name = xframe.getString("name");
         String packageName = RString.leftLast(name, ".");
         packages.set(packageName, packageName);
      }
      // 生成列表
      for(IStringPair pair : packages){
         String packageName = pair.name();
         XTreeNode xnode = new XTreeNode();
         xnode.setIsValid(true);
         xnode.setTypeGroup(ECatalogNodeGroup.Package);
         xnode.setTypeCode("package");
         xnode.setHasChild(true);
         xnode.setLabel(packageName);
         xnode.setCode(packageName);
         xnode.saveConfig(xconfig.createNode("TreeNode"));
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获得目录列表处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   public EResult catalogList(IWebContext context,
                              IWebInput input,
                              IWebOutput output){
      XContentObject[] xcontainers = contentList();
      FXmlNode xconfig = output.config();
      // 生成列表
      for(XContentObject xcontainer : xcontainers){
         buildTreeNode(xconfig, xcontainer, ECatalogNodeGroup.Container, false);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获得目录节点处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   public EResult list(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      // 检查参数
      FXmlNode treeNode = input.config().findNode("TreeNode");
      if(treeNode == null){
         throw new FFatalError("Select tree node is empty.");
      }
      String typeGroup = treeNode.get("type_group");
      String code = treeNode.get("code", null);
      FXmlNode containerNode = treeNode;
      while(containerNode.hasNode()){
         if(ECatalogNodeGroup.Container.equals(containerNode.get("type_group"))){
            break;
         }
         containerNode = containerNode.nodes().first();
      }
      String containerName = containerNode.get("code");
      if(RString.isEmpty(containerName)){
         throw new FFatalError("Container name is empty.");
      }
      // 生成输出
      FXmlNode xconfig = output.config();
      if(ECatalogNodeGroup.Package.equals(typeGroup)){
         // 显示包内表单集合
         XContentObject[] xcontainers = contentList();
         for(XContentObject xcontainer : xcontainers){
            String name = xcontainer.getString("name");
            String packageName = RString.leftLast(name, ".");
            if(packageName.equals(code)){
               buildTreeNode(xconfig, xcontainer, ECatalogNodeGroup.Container, true);
            }
         }
      }else if(ECatalogNodeGroup.Container.equals(typeGroup)){
         // 显示表单内控件集合
         FContentObject xcontainer = contentFindDefine(containerName, EPersistenceMode.Config);
         for(FContentObject xcontrol : xcontainer.nodes()){
            buildTreeNode(xconfig, xcontrol, ECatalogNodeGroup.Item);
         }
      }else if(ECatalogNodeGroup.Item.equals(typeGroup)){
         // 检查参数
         String itemGuid = treeNode.get("guid");
         if(RString.isEmpty(itemGuid)){
            throw new FFatalError("Container item guid is empty.");
         }
         // 显示表单内控件集合
         FContentObject xcontainer = contentFindDefine(containerName, EPersistenceMode.Config);
         FContentObject xitem = xcontainer.search(itemGuid);
         if(xitem == null){
            throw new FFatalError("Container item guid is not exists.");
         }
         // 建立目录
         for(FContentObject xcontrol : xitem.nodes()){
            buildTreeNode(xconfig, xcontrol, ECatalogNodeGroup.Item);
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获取配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   public EResult fetch(IWebContext context,
                        IWebInput input,
                        IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output){
      // 检查参数
      String groupName = context.parameter("group");
      if(RString.isEmpty(groupName)){
         throw new FFatalError("Group name is empty.");
      }
      String containerName = context.parameter("container");
      if(RString.isEmpty(containerName)){
         throw new FFatalError("Container name is empty.");
      }
      //............................................................
      // 加载配置
      FContentObject xcontainer = contentFindDefine(containerName, EPersistenceMode.Config);
      if(xcontainer == null){
         throw new FFatalError("Container is not exists. (container_name={1})", containerName);
      }
      if(ECatalogNodeGroup.Container.equals(groupName)){
         // 设置容器配置
         FXmlNode xconfig = output.config().createNode(EContentConstants.Content);
         xconfig.set("_type", xcontainer.name());
         xconfig.attributes().append(xcontainer.attributes());
      }else if(ECatalogNodeGroup.Item.equals(groupName)){
         // 检查参数
         String itemName = context.parameter("item");
         if(RString.isEmpty(itemName)){
            throw new FFatalError("Container item name is empty.");
         }
         // 设置项目配置
         FContentObject xitem = xcontainer.search(itemName);
         if(xitem == null){
            throw new FFatalError("Container item name is not exists. (item_name={1})", itemName);
         }
         FXmlNode xconfig = output.config().createNode(EContentConstants.Content);
         xconfig.set("_type", xcontainer.name());
         xconfig.attributes().append(xitem.attributes());
      }else{
         throw new FFatalError("Group is invalid. (group={1})", groupName);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public EResult insert(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      // 检查参数
      String groupName = context.parameter("group");
      if(RString.isEmpty(groupName)){
         throw new FFatalError("Group name is empty.");
      }
      String containerName = context.parameter("container");
      if(RString.isEmpty(containerName)){
         throw new FFatalError("Container name is empty.");
      }
      FXmlNode xcontent = input.config().findNode(EContentConstants.Content);
      if(xcontent == null){
         throw new FFatalError("Content config is empty.");
      }
      //............................................................
      // 加载配置
      FContentObject xcontainer = contentFindDefine(containerName, EPersistenceMode.Config);
      if(xcontainer == null){
         throw new FFatalError("Container is not exists. (container_name={1})", containerName);
      }
      if(ECatalogNodeGroup.Container.equals(groupName)){
         // 设置容器配置
         xcontainer.assignAttributes(xcontent.attributes());
      }else if(ECatalogNodeGroup.Item.equals(groupName)){
         // 检查参数
         String itemName = context.parameter("item");
         if(RString.isEmpty(itemName)){
            throw new FFatalError("Container item name is empty.");
         }
         // 设置项目配置
         FContentObject xitem = xcontainer.search(itemName);
         if(xitem == null){
            throw new FFatalError("Container item name is not exists. (item_name={1})", itemName);
         }
         xitem.assignAttributes(xcontent.attributes());
      }else{
         throw new FFatalError("Group is invalid. (group={1})", groupName);
      }
      // 更新处理
      contentUpdate(xcontainer);
      return EResult.Success;
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
