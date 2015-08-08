package org.mo.cloud.editor.design.list;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.list.IListConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.tree.common.XTreeNode;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.common.ECatalogNodeGroup;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务。</T>
//============================================================
public class FListService
      implements
         IListService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容列表控制台接口
   @ALink
   protected IListConsole _listConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FListService(){
      //_storageName = "cloud";
      //_spaceName = "design.form";
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
      XContentObject[] xframes = _listConsole.list(_storageName);
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
         xnode.setTypeCode("package");
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
         XContentObject[] xframes = _listConsole.list(_storageName);
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
         FContentObject xframe = _listConsole.findDefine(_storageName, code, EPersistenceMode.Config);
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
   public void query(IWebContext context,
                     IWebInput input,
                     IWebOutput output){
   }

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
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
   @Override
   public EResult update(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      FXmlNode xlist = input.config().findNode("List");
      String name = xlist.get("name");
      // 查找目录定义
      FContentObject content = _listConsole.findDefine(_storageName, name, EPersistenceMode.Config);
      content.mergeConfig(xlist);
      _listConsole.update(_storageName, content);
      return EResult.Success;
   }

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult delete(IWebContext context,
                         IWebInput input,
                         IWebOutput output){
      return EResult.Success;
   }
}
