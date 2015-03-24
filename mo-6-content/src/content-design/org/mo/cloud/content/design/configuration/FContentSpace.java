package org.mo.cloud.content.design.configuration;

import java.io.File;
import org.mo.com.io.FFileInfo;
import org.mo.com.io.RDirectory;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>内容空间。</T>
//============================================================
public class FContentSpace
      extends FObject
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FContentStorage.class);

   // 内容存储
   protected FContentStorage _storage;

   // 名称
   protected String _name;

   // 文件路径
   protected String _filePath;

   // 打开状态
   protected boolean _statusOpen;

   // 内容类字典
   protected FDictionary<FContentClass> _classes = new FDictionary<FContentClass>(FContentClass.class);

   // 内容节点字典
   protected FDictionary<FContentNode> _nodes = new FDictionary<FContentNode>(FContentNode.class);

   //============================================================
   // <T>构造内容空间。</T>
   //============================================================
   public FContentSpace(){
   }

   //============================================================
   // <T>构造内容空间。</T>
   //
   // @param storage 内容存储
   //============================================================
   public FContentSpace(FContentStorage storage){
      _storage = storage;
   }

   //============================================================
   // <T>获得内容存储。</T>
   //
   // @return 内容存储
   //============================================================
   public FContentStorage storage(){
      return _storage;
   }

   //============================================================
   // <T>设置内容存储。</T>
   //
   // @param storage 内容存储
   //============================================================
   public void setStorage(FContentStorage storage){
      _storage = storage;
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
   // <T>获得文件路径。</T>
   //
   // @return 文件路径
   //============================================================
   public String filePath(){
      return _filePath;
   }

   //============================================================
   // <T>设置文件路径。</T>
   //
   // @param filePath 文件路径
   //============================================================
   public void setFilePath(String filePath){
      _filePath = filePath;
   }

   //============================================================
   // <T>获得内容节点字典。</T>
   //
   // @return 内容节点字典
   //============================================================
   public FDictionary<FContentNode> contents(){
      return _nodes;
   }

   //============================================================
   // <T>根据名称查找内容节点。</T>
   //
   // @param name 节点名称
   // @return 内容节点
   //============================================================
   public FContentNode find(String name){
      FContentNode node = _nodes.find(name);
      if(node != null){
         if(!node.statusOpen()){
            node.open();
         }
         node.check();
      }
      return node;
   }

   //============================================================
   // <T>创建内容节点。</T>
   //
   // @param name 节点名称
   // @return 内容节点
   //============================================================
   public FContentNode create(String name){
      // 检查名称
      if(RString.isEmpty(name)){
         throw new FFatalError("Name is empty.");
      }
      // 查找节点
      FContentNode node = _nodes.find(name);
      if(node != null){
         return node;
      }
      // 新建节点
      String fileName = RString.replace(name, '.', File.separatorChar) + ".xml";
      node = new FContentNode(this);
      node.setName(name);
      node.setFileName(RFile.makeFilename(_filePath, fileName));
      node.open();
      _nodes.set(name, node);
      return node;
   }

   //============================================================
   // <T>更新内容节点。</T>
   //
   // @param name 节点名称
   //============================================================
   public void update(FContentNode node){
      node.store();
   }

   //============================================================
   // <T>删除内容节点。</T>
   //
   // @param name 节点名称
   //============================================================
   public void delete(FContentNode node){
      String name = node.name();
      _nodes.set(name, null);
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
      // 处理所有目录
      int pathLength = _filePath.length();
      for(FFileInfo fileInfo : RDirectory.listFiles(_filePath, true)){
         // 检查文件名称
         String fileName = fileInfo.fileName();
         if(!fileName.endsWith(".xml")){
            continue;
         }
         // 生成名称
         String name = fileName.substring(pathLength + 1, fileName.length() - 4);
         name = RString.replace(name, '/', '.');
         name = RString.replace(name, '\\', '.');
         // 创建对象
         FContentNode node = new FContentNode(this);
         node.setName(name);
         node.setFileName(fileInfo.fileName());
         node.open();
         _nodes.set(name, node);
         _logger.debug(this, "open", "Create content node. (name={1})", name);
      }
      _statusOpen = true;
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
      // 释放所有空间
      for(INamePair<FContentNode> pair : _nodes){
         pair.value().close();
      }
      _nodes.clear();
      _statusOpen = false;
      return EResult.Success;
   }
}
