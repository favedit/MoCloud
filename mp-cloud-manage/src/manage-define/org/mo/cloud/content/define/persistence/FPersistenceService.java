package org.mo.cloud.content.define.persistence;

import org.mo.content.core.common.ECatalogNodeGroup;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.tree.common.XTreeNode;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.REnum;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容持久化服务。</T>
//============================================================
public class FPersistenceService
      implements
         IPersistenceService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FPersistenceService(){
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public void buildFrame(FContentObject control,
                          EPersistenceMode modeCd){
      // 处理当前节点
      String inheritFrames = control.get("inherit_frames", null);
      if(!RString.isEmpty(inheritFrames)){
         String[] items = RString.split(inheritFrames, ",");
         for(String item : items){
            String frameName = RString.trim(item);
            if(!RString.isEmpty(frameName)){
               // 查找定义
               FContentObject frame = findBuildFrame(frameName, modeCd);
               if(frame == null){
                  throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
               }
               // 嵌入节点
               for(FContentObject node : frame.nodes()){
                  control.push(node);
               }
            }
         }
      }
      //..........................................................
      // 处理当前节点
      String frameSource = control.get("frame_source", null);
      if(!RString.isEmpty(frameSource)){
         // 获得嵌入方式
         String includeCd = null;
         String frameName = null;
         String[] items = RString.splitTwo(frameSource, '@');
         if(items == null){
            includeCd = "include";
            frameName = frameSource;
         }else{
            includeCd = items[0];
            frameName = items[1];
         }
         // 查找定义
         FContentObject frame = findBuildFrame(frameName, modeCd);
         if(frame == null){
            throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
         }
         // 嵌入节点
         if(includeCd.equals("include")){
            control.push(frame);
         }else if(includeCd.equals("children")){
            for(FContentObject node : frame.nodes()){
               control.push(node);
            }
         }else{
            throw new FFatalError("Frame include type is invalid. (frame_name={1}, include_cd={2})", frameName, includeCd);
         }
      }
      //..........................................................
      // 处理所有子节点
      if(control.hasNode()){
         for(FContentObject xchild : control.nodes()){
            buildFrame(xchild, modeCd);
         }
      }
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   public FContentObject findBuildFrame(String frameName,
                                        EPersistenceMode modeCd){
      FContentObject content = _persistenceConsole.findDefine(_storageName, frameName, modeCd);
      content.set("name", frameName);
      buildFrame(content, modeCd);
      return content;

   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult catalog(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      XContentObject[] xframes = _persistenceConsole.list(_storageName);
      FXmlNode xconfig = output.config();
      FAttributes packages = new FAttributes();
      for(XContentObject xframe : xframes){
         String name = xframe.getString("name");
         String packageName = RString.leftLast(name, ".");
         packages.set(packageName, packageName);
      }
      for(IStringPair pair : packages){
         String packageName = pair.name();
         XTreeNode xnode = new XTreeNode();
         xnode.setIsValid(true);
         xnode.setTypeGroup(ECatalogNodeGroup.Package);
         xnode.setTypeCode("Package");
         xnode.setHasChild(true);
         xnode.setLabel(packageName);
         //xnode.setNote(xframe.getString("label"));
         xnode.saveConfig(xconfig.createNode("TreeNode"));
      }
      return EResult.Success;
   }

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult list(IWebContext context,
                       IWebInput input,
                       IWebOutput output){
      FXmlNode treeNode = input.config().findNode("TreeNode");
      FXmlNode xconfig = output.config();
      String typeGroup = treeNode.get("type_group");
      String code = treeNode.get("label");
      if(ECatalogNodeGroup.Package.equals(typeGroup)){
         // 显示包内表单集合
         XContentObject[] xframes = _persistenceConsole.list(_storageName);
         for(XContentObject xframe : xframes){
            String name = xframe.getString("name");
            String packageName = RString.leftLast(name, ".");
            if(packageName.equals(code)){
               XTreeNode xnode = new XTreeNode();
               xnode.setIsValid(true);
               xnode.setTypeGroup(ECatalogNodeGroup.Container);
               xnode.setTypeCode(xframe.name());
               xnode.setHasChild(xframe.hasChild());
               xnode.setLabel(xframe.getString("name"));
               xnode.setNote(xframe.getString("label"));
               xnode.saveConfig(xconfig.createNode("TreeNode"));
            }
         }
      }else if(ECatalogNodeGroup.Container.equals(typeGroup)){
         // 显示表单内控件集合
         FContentObject xframe = _persistenceConsole.findDefine(_storageName, code, EPersistenceMode.Config);
         for(FContentObject xcontrol : xframe.nodes()){
            XTreeNode xnode = new XTreeNode();
            xnode.setIsValid(true);
            xnode.setTypeGroup(ECatalogNodeGroup.Item);
            xnode.setTypeCode(xcontrol.name());
            xnode.setHasChild(xcontrol.hasNode());
            xnode.setGuid(xcontrol.objectId());
            xnode.setLabel(xcontrol.get("name"));
            xnode.setNote(xcontrol.get("label"));
            xnode.saveConfig(xconfig.createNode("TreeNode"));
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output){
      // 获得输入
      FXmlNode xinput = input.config();
      FXmlNode xoutput = output.config();
      //............................................................
      // 参数获取
      String frameName = context.parameter("frame");
      if(!RString.isEmpty(frameName)){
         String mode = context.parameter("mode_cd");
         EPersistenceMode modeCd = EPersistenceMode.Config;
         if(!RString.isEmpty(mode)){
            modeCd = REnum.parse(EPersistenceMode.class, mode);
         }
         FContentObject content = _persistenceConsole.findDefine(_storageName, frameName, modeCd);
         content.set("name", frameName);
         buildFrame(content, modeCd);
         // 转换数据
         FXmlNode xconfig = xoutput.createNode();
         content.saveConfig(xconfig);
         return EResult.Success;
      }
      //............................................................
      // 内容获取
      for(FXmlNode xframe : xinput){
         if(xframe.isName("Frame")){
            String name = xframe.get("name");
            // 查找目录定义
            FContentObject content = _persistenceConsole.findDefine(_storageName, name, EPersistenceMode.Config);
            content.set("name", name);
            buildFrame(content, EPersistenceMode.Config);
            // 转换数据
            FXmlNode xconfig = xoutput.createNode();
            content.saveConfig(xconfig);
         }
      }
      return EResult.Success;
   }
}
