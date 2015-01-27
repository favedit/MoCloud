package org.mo.cloud.design.core.configuration;

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

   // 配置节点
   protected FContentObject _config = new FContentObject();

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
   // <T>获得配置节点。</T>
   //
   // @return 配置节点
   //============================================================
   public FContentObject config(){
      return _config;
   }

   //============================================================
   // <T>递归查询指定编号的内容节点。</T>
   //
   // @param objectId 对象编号
   // @return 内容节点
   //============================================================
   public FContentObject search(String objectId){
      return _config.search(objectId);
   }

   //============================================================
   // <T>保存配置节点。</T>
   //
   // @param xconfig 配置节点
   // @param deep 支持深度 
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.setName("Content");
      xconfig.set("name", _name);
      xconfig.set("update_date", RDateTime.format());
   }

   //============================================================
   // <T>加载配置节点。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
   }

   //============================================================
   // <T>打开处理。</T>
   //
   // @return 处理结果
   //============================================================
   public EResult open(){
      // 检查标志
      if(_statusOpen){
         return EResult.Failure;
      }
      // 检查文件名称
      if(RString.isEmpty(_fileName)){
         return EResult.Failure;
      }
      // 检查文件存在性
      if(!RFile.exists(_fileName)){
         _statusOpen = true;
         return EResult.Failure;
      }
      // 加载配置节点
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadFile(_fileName);
      FXmlNode xroot = xdocument.root();
      loadConfig(xroot);
      _config.loadConfig(xroot.nodes().first());
      _statusOpen = true;
      return EResult.Success;
   }

   //============================================================
   // <T>存储处理。</T>
   //
   // @return 处理结果
   //============================================================
   public EResult store(){
      // 检查标志
      if(!_statusOpen){
         return EResult.Failure;
      }
      // 检查文件名称
      if(RString.isEmpty(_fileName)){
         return EResult.Failure;
      }
      // 检查节点存在性
      if(_config == null){
         return EResult.Failure;
      }
      // 存储配置节点
      FXmlDocument xdocument = new FXmlDocument();
      FXmlNode xroot = xdocument.root();
      saveConfig(xroot);
      _config.saveConfig(xroot.createNode());
      xdocument.saveFile(_fileName);
      _logger.debug(this, "store", "Store content node. (name={1}, file_name={2})", _name, _fileName);
      return EResult.Success;
   }

   //============================================================
   // <T>关闭处理。</T>
   //
   // @return 处理结果
   //============================================================
   public EResult close(){
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
   public EResult remove(){
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
