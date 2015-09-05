package org.mo.cloud.content.design.frame;

import org.mo.cloud.content.design.configuration.FContentNode;
import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.FContentSpace;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.list.IListConsole;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.cloud.content.design.persistence.FPersistence;
import org.mo.cloud.content.design.persistence.IPersistenceConsole;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.system.IListener;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内容表单控制台。</T>
//============================================================
public class FFrameConsole
      extends FConsole
      implements
         IFrameConsole
{
   // 空间名称
   @AProperty
   protected String _spaceName;

   // 路径名称
   @AProperty
   protected String _pathName;

   // 持久化名称
   @AProperty
   protected String _persistenceName;

   // 内容配置控制台接口
   @ALink
   protected IConfigurationConsole _configurationConsole;

   // 内容持久化控制台接口
   @ALink
   protected IPersistenceConsole _persistenceConsole;

   // 内容列表控制台接口
   @ALink
   protected IListConsole _listConsole;

   // 内容字典
   protected FDictionary<XContentObject> _contents = new FDictionary<XContentObject>(XContentObject.class);

   //============================================================
   // <T>更新配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   public void initialize(){
      _configurationConsole.registerFileChanged(new IListener(){
         @Override
         public boolean process(Object sender,
                                int command,
                                Object params){
            _contents.clear();
            return true;
         }
      });
   }

   //============================================================
   // <T>获得表单集合。</T>
   //
   // @param storgeName 存储名称
   // @return 表单集合
   //============================================================
   @Override
   public XContentObject[] list(String storgeName){
      FObjects<XContentObject> results = new FObjects<XContentObject>(XContentObject.class);
      FContentSpace space = _configurationConsole.getSpace(storgeName, _pathName);
      for(INamePair<FContentNode> pair : space.contents()){
         FContentNode node = pair.value();
         String listName = node.name();
         XContentObject xlist = find(storgeName, listName, EPersistenceMode.Store);
         results.push(xlist);
      }
      return results.toObjects();
   }

   //============================================================
   // <T>根据名称获得表单。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public XContentObject find(String storgeName,
                              String frameName,
                              EPersistenceMode modeCd){
      String code = storgeName + "|" + frameName + "|" + modeCd.toString();
      XContentObject xframe = _contents.find(code);
      if(xframe == null){
         FContentNode node = _configurationConsole.getNode(storgeName, _pathName, frameName);
         if(node != null){
            try{
               FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _spaceName);
               xframe = persistence.convertInstance(node.content(), modeCd);
               _contents.set(code, xframe);
            }catch(Exception exception){
               throw new FFatalError(exception, "Find frame failure. (storage={1}, frame_name={2})", storgeName, frameName);
            }
         }
      }
      return xframe;
   }

   //============================================================
   // <T>根据名称获得表单定义。</T>
   //
   // @param storgeName 存储名称
   // @param formName 表单名称
   // @param modeCd 模式类型
   // @return 表单
   //============================================================
   @Override
   public FContentObject findDefine(String storgeName,
                                    String formName,
                                    EPersistenceMode modeCd){
      XContentObject xobject = find(storgeName, formName, modeCd);
      if(xobject != null){
         // 获得转换器
         FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
         // 转换对象
         return persistence.convertConfig(xobject, modeCd);
      }
      return null;
   }

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @return 目录配置
   //============================================================
   protected void buildSelect(String storgeName,
                              FContentObject xcontent,
                              EPersistenceMode modeCd){
      // 获得编辑引用
      String editRefer = xcontent.get("edit_refer", null);
      if(RString.isEmpty(editRefer)){
         return;
      }
      // 获得列表定义
      FContentObject xlist = _listConsole.findDefine(storgeName, editRefer, modeCd);
      if(xlist.hasNode()){
         for(FContentObject xitem : xlist.nodes()){
            if(xitem.getBoolean("is_valid")){
               FContentObject xselectitem = new FContentObject();
               xselectitem.setName("SelectItem");
               xselectitem.set("name", xitem.get("name"));
               xselectitem.set("label", xitem.get("label"));
               xselectitem.set("data_value", xitem.get("value"));
               xcontent.push(xselectitem);
            }
         }
      }
   }

   //============================================================
   // <T>根据名称建立目录配置。</T>
   //
   // @param storgeName 存储名称
   // @param frameName 页面名称
   // @return 目录配置
   //============================================================
   protected void buildTemplate(String storgeName,
                                FContentObject content,
                                FContentObject control,
                                EPersistenceMode modeCd){
      String frameSource = control.get("frame_source", null);
      if(!RString.isEmpty(frameSource)){
         // 查找定义
         FContentObject frame = buildDefine(storgeName, frameSource, modeCd);
         if(frame == null){
            throw new FFatalError("Frame is not exists. (frame_name={1})", frameSource);
         }
         // 嵌入节点
         for(FContentObject node : frame.nodes()){
            content.push(node);
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
   public void buildFrame(String storgeName,
                          FContentObject content,
                          FContentObject control,
                          EPersistenceMode modeCd){
      // 合并属性
      content.merge(control);
      //..........................................................
      // 处理父继承
      String inheritFrames = control.get("inherit_frames", null);
      if(!RString.isEmpty(inheritFrames)){
         String[] items = RString.split(inheritFrames, ",");
         for(String item : items){
            String frameName = RString.trim(item);
            if(!RString.isEmpty(frameName)){
               // 查找定义
               FContentObject frame = buildDefine(storgeName, frameName, modeCd);
               if(frame == null){
                  throw new FFatalError("Frame is not exists. (frame_name={1})", frameName);
               }
               // 嵌入节点
               for(FContentObject node : frame.nodes()){
                  content.push(node);
               }
            }
         }
      }
      //..........................................................
      // 处理选择框
      if(content.isName("Select")){
         buildSelect(storgeName, content, modeCd);
      }
      //..........................................................
      // 处理所有子节点
      if(control.hasNode()){
         for(FContentObject xchild : control.nodes()){
            if(xchild.isName("Template")){
               buildTemplate(storgeName, content, xchild, modeCd);
            }else{
               FContentObject contentChild = new FContentObject();
               buildFrame(storgeName, contentChild, xchild, modeCd);
               content.push(contentChild);
            }
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
   @Override
   public FContentObject buildDefine(String storgeName,
                                     String frameName,
                                     EPersistenceMode modeCd){
      // 查找页面
      FContentObject contentDefine = findDefine(storgeName, frameName, modeCd);
      contentDefine.set("name", frameName);
      // 创建页面
      FContentObject content = new FContentObject();
      buildFrame(storgeName, content, contentDefine, modeCd);
      return content;
   }

   //============================================================
   // <T>新建配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void insert(String storgeName,
                      FContentObject contentObject){
      // 新建节点
      String nodeName = contentObject.get("name");
      FContentSpace space = _configurationConsole.findSpace(storgeName, _spaceName);
      FContentNode contentNode = space.create(nodeName);
      contentNode.setContent(contentObject);
      contentNode.store();
      // 清空缓冲
      _contents.clear();
   }

   //============================================================
   // <T>更新配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void update(String storgeName,
                      FContentObject frame){
      String nodeName = frame.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      FContentObject xinstance = node.content();
      // 获得转换器
      FPersistence persistence = _persistenceConsole.findPersistence(storgeName, _persistenceName);
      persistence.mergeConfig(xinstance, frame, EPersistenceMode.Config);
      // 保存处理
      node.store();
      // 清空缓冲
      _contents.clear();
   }

   //============================================================
   // <T>删除配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   @Override
   public void delete(String storgeName,
                      FContentObject contentObject){
      // 移除节点
      String nodeName = contentObject.get("name");
      FContentNode node = _configurationConsole.findNode(storgeName, _spaceName, nodeName);
      node.remove();
      // 清空缓冲
      _contents.clear();
   }
}
