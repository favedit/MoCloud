package org.mo.cloud.content.define.tree;

import org.mo.cloud.content.define.frame.ETypeGroup;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.cloud.content.design.tree.ITreeConsole;
import org.mo.cloud.content.design.tree.common.XTreeNode;
import org.mo.cloud.content.design.tree.common.XTreeView;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>目录描述服务。</T>
//============================================================
public class FTreeService
      implements
         ITreeService
{
   // 存储名称
   protected String _storageName = "cloud";

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容列表控制台接口
   @ALink
   protected ITreeConsole _treeConsole;

   //============================================================
   // <T>构造内容表单服务。</T>
   //============================================================
   public FTreeService(){
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
      XContentObject[] xframes = _treeConsole.list(_storageName);
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
         xnode.setTypeGroup(ETypeGroup.Package);
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
      if(ETypeGroup.Package.equals(typeGroup)){
         // 显示包内表单集合
         XContentObject[] xframes = _treeConsole.list(_storageName);
         for(XContentObject xframe : xframes){
            String name = xframe.getString("name");
            String packageName = RString.leftLast(name, ".");
            if(packageName.equals(code)){
               XTreeNode xnode = new XTreeNode();
               xnode.setIsValid(true);
               xnode.setTypeGroup(ETypeGroup.Container);
               xnode.setTypeCode(xframe.name());
               xnode.setHasChild(xframe.hasChild());
               xnode.setLabel(xframe.getString("name"));
               xnode.setNote(xframe.getString("label"));
               xnode.saveConfig(xconfig.createNode("TreeNode"));
            }
         }
      }else if(ETypeGroup.Container.equals(typeGroup)){
         // 显示表单内控件集合
         FContentObject xframe = _treeConsole.findDefine(_storageName, code, EPersistenceMode.Config);
         for(FContentObject xcontrol : xframe.nodes()){
            XTreeNode xnode = new XTreeNode();
            xnode.setIsValid(true);
            xnode.setTypeGroup(ETypeGroup.Item);
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
      String code = context.parameter("code");
      // 查找目录定义
      XTreeView xtree = _treeConsole.find(_storageName, code, EPersistenceMode.Config);
      if(xtree == null){
         return EResult.Failure;
      }
      // 转换数据
      FXmlNode xconfig = output.config().createNode();
      FPersistence persistence = _persistenceConsole.findPersistence(_storageName, "design.tree");
      FContentObject content = persistence.convertConfig(xtree);
      // 存储输出
      content.saveConfig(xconfig);
      return EResult.Success;
   }
}
