package org.mo.cloud.content.design.configuration;

import java.io.File;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>内容节点。</T>
//============================================================
public class FContentNode
      extends FObject
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FContentNode.class);

   // 内容空间
   protected FContentSpace _space;

   // 名称
   protected String _name;

   // 文件名称
   protected String _fileName;

   // 打开状态
   protected boolean _statusOpen;

   // 修改时间
   protected long _lastModified;

   // 配置节点
   protected FContentObject _content = new FContentObject();

   //============================================================
   // <T>构造内容节点。</T>
   //
   // @return 名称
   //============================================================
   public FContentNode(){
   }

   //============================================================
   // <T>构造内容节点。</T>
   //
   // @param space 内容空间
   // @return 名称
   //============================================================
   public FContentNode(FContentSpace space){
      _space = space;
   }

   //============================================================
   // <T>获得内容空间。</T>
   //
   // @return 内容空间
   //============================================================
   public FContentSpace space(){
      return _space;
   }

   //============================================================
   // <T>设置内容空间。</T>
   //
   // @param space 内容空间
   //============================================================
   public void setSpace(FContentSpace space){
      _space = space;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得文件名称。</T>
   //
   // @return 文件名称
   //============================================================
   public String fileName(){
      return _fileName;
   }

   //============================================================
   // <T>设置文件名称。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void setFileName(String fileName){
      _fileName = fileName;
   }

   //============================================================
   // <T>获得是否打开。</T>
   //
   // @return 是否打开
   //============================================================
   public boolean statusOpen(){
      return _statusOpen;
   }

   //============================================================
   // <T>获得内容节点。</T>
   //
   // @return 内容节点
   //============================================================
   public synchronized FContentObject config(){
      return _content;
   }

   //============================================================
   // <T>获得内容节点。</T>
   //
   // @return 内容节点
   //============================================================
   public synchronized FContentObject content(){
      return _content;
   }

   //============================================================
   // <T>设置内容节点。</T>
   //
   // @return 内容节点
   //============================================================
   public synchronized void setContent(FContentObject content){
      _content = content;
   }

   //============================================================
   // <T>递归查询指定编号的内容节点。</T>
   //
   // @param objectId 对象编号
   // @return 内容节点
   //============================================================
   public synchronized FContentObject search(String objectId){
      return _content.search(objectId);
   }

   //============================================================
   // <T>打开处理。</T>
   //
   // @return 处理结果
   //============================================================
   public synchronized EResult open(){
      // 检查标志
      if(_statusOpen){
         return EResult.Failure;
      }
      // 检查文件名称
      if(RString.isEmpty(_fileName)){
         return EResult.Failure;
      }
      // 检查文件存在性
      File file = new File(_fileName);
      if(!file.exists()){
         _statusOpen = true;
         return EResult.Failure;
      }
      _lastModified = file.lastModified();
      // 加载配置节点
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(_fileName);
      FXmlNode xroot = xdocument.root();
      // 加载配置信息
      FXmlNode xcontent = xroot.nodes().first();
      xcontent.set("name", _name);
      _content.loadConfig(xcontent);
      _statusOpen = true;
      // 输出日志
      _logger.debug(this, "open", "Open content node. (name={1}, file_name={2})", _name, _fileName);
      return EResult.Success;
   }

   //============================================================
   // <T>检查处理，如果发生改变重新加载内容。</T>
   //
   // @param context 检查环境
   // @return 处理结果
   //============================================================
   public synchronized EResult check(SConfigurationCheckContext context){
      // 检查文件时间
      File file = new File(_fileName);
      if(file.lastModified() == _lastModified){
         return EResult.Success;
      }
      // 重新加载文件
      _statusOpen = false;
      _content = new FContentObject();
      open();
      // 改变文件处理
      context.listeners.process(this, 0, _fileName);
      return EResult.Success;
   }

   //============================================================
   // <T>存储处理。</T>
   //
   // @return 处理结果
   //============================================================
   public synchronized EResult store(){
      // 检查标志
      if(!_statusOpen){
         return EResult.Failure;
      }
      // 检查文件名称
      if(RString.isEmpty(_fileName)){
         return EResult.Failure;
      }
      // 检查节点存在性
      if(_content == null){
         return EResult.Failure;
      }
      // 存储配置节点
      FXmlDocument xdocument = new FXmlDocument();
      FXmlNode xroot = xdocument.root();
      _content.saveConfig(xroot.createNode());
      xroot.setName("Content");
      xroot.set("update_date", RDateTime.format());
      xdocument.saveFile(_fileName);
      _logger.debug(this, "store", "Store content node. (name={1}, file_name={2})", _name, _fileName);
      _lastModified = new File(_fileName).lastModified();
      return EResult.Success;
   }

   //============================================================
   // <T>关闭处理。</T>
   //
   // @return 处理结果
   //============================================================
   public synchronized EResult close(){
      // 检查标志
      if(!_statusOpen){
         return EResult.Failure;
      }
      _statusOpen = false;
      return EResult.Success;
   }

   //============================================================
   // <T>删除处理。</T>
   //
   // @return 处理结果
   //============================================================
   public synchronized EResult remove(){
      // 关闭处理
      close();
      // 删除内容
      _space.contents().remove(_name);
      // 删除文件
      RFile.delete(_fileName);
      _logger.debug(this, "remove", "Remove content node. (name={1}, file_name={2})", _name, _fileName);
      return EResult.Success;
   }
}
