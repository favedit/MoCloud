package org.mo.cloud.content.design.configuration;

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
// <T>内容存储。</T>
//============================================================
public class FContentStorage
      extends FObject
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FContentStorage.class);

   // 名称
   protected String _name;

   // 文件路径
   protected String _filePath;

   // 打开状态
   protected boolean _statusOpen;

   // 空间节点字典
   protected FDictionary<FContentSpace> _spaces = new FDictionary<FContentSpace>(FContentSpace.class);

   //============================================================
   // <T>构造内容存储。</T>
   //============================================================
   public FContentStorage(){
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
   // <T>获得内容空间字典。</T>
   //
   // @return 内容空间字典
   //============================================================
   public FDictionary<FContentSpace> spaces(){
      return _spaces;
   }

   //============================================================
   // <T>根据名称查找内容空间。</T>
   //
   // @param name 空间名称
   // @return 内容空间
   //============================================================
   public FContentSpace find(String name){
      FContentSpace space = _spaces.find(name);
      if(space != null){
         space.open();
      }
      return space;
   }

   //============================================================
   // <T>创建内容空间。</T>
   //
   // @param name 空间名称
   // @return 内容空间
   //============================================================
   public FContentSpace create(String name){
      // 检查名称
      if(RString.isEmpty(name)){
         throw new FFatalError("Name is empty.");
      }
      // 查找空间
      FContentSpace space = _spaces.find(name);
      if(space != null){
         return space;
      }
      // 新建空间
      space = new FContentSpace(this);
      space.setName(name);
      space.setFilePath(RFile.makePathname(_filePath, name));
      _spaces.set(name, space);
      return space;
   }

   //============================================================
   // <T>删除内容节点。</T>
   //
   // @param name 节点名称
   //============================================================
   public void delete(FContentSpace space){
      String name = space.name();
      _spaces.set(name, null);
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
      for(String name : RDirectory.listDirectory(_filePath)){
         FContentSpace storage = new FContentSpace();
         storage.setName(name);
         storage.setFilePath(RFile.makePathname(_filePath, name));
         _spaces.set(name, storage);
         _logger.debug(this, "open", "Create content space. (name={1})", name);
      }
      _statusOpen = true;
      return EResult.Success;
   }

   //============================================================
   // <T>检查处理，如果发生改变重新加载内容。</T>
   //
   // @param context 检查环境
   // @return 处理结果
   //============================================================
   public EResult check(SConfigurationCheckContext context){
      for(INamePair<FContentSpace> pair : _spaces){
         FContentSpace contentSpace = pair.value();
         contentSpace.check(context);
      }
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
      for(INamePair<FContentSpace> pair : _spaces){
         pair.value().close();
      }
      _spaces.clear();
      _statusOpen = false;
      return EResult.Success;
   }
}
