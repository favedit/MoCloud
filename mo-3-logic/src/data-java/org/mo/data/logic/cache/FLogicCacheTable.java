package org.mo.data.logic.cache;

import java.util.UUID;
import org.mo.com.lang.FObject;
import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑单元缓冲表格。</T>
//============================================================
public class FLogicCacheTable
      extends FObject
{
   // 控制台
   protected ILogicCacheConsole _console;

   // 设置过
   protected boolean _setuped;

   // 名称
   protected String _name;

   //============================================================
   // <T>构造逻辑单元缓冲表格。</T>
   //============================================================
   public FLogicCacheTable(){
   }

   //============================================================
   // <T>构造逻辑单元缓冲表格。</T>
   //
   // @param console 控制台
   //============================================================
   public FLogicCacheTable(ILogicCacheConsole console){
      _console = console;
   }

   //============================================================
   // <T>获得控制台。</T>
   //
   // @return 控制台
   //============================================================
   public ILogicCacheConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @return 控制台
   //============================================================
   public void setConsole(ILogicCacheConsole console){
      _console = console;
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
   // @return 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>配置处理。</T>
   //============================================================
   public void setup(){
   }

   //============================================================
   // <T>获得下一个代码。</T>
   //
   // @return 代码
   //============================================================
   protected String nextCode(){
      return UUID.randomUUID().toString();
   }

   //============================================================
   // <T>获得当前控制台代码。</T>
   //
   // @param channel 内存缓冲频道
   // @return 代码
   //============================================================
   public synchronized String currentConsoleCode(FMemoryChannel channel){
      return _console.currentCode(channel);
   }

   //============================================================
   // <T>刷新控制台处理。</T>
   //
   // @param channel 内存缓冲频道
   //============================================================
   public synchronized void flushConsole(FMemoryChannel channel){
      _console.flush(channel);
   }

   //============================================================
   // <T>获得当前代码。</T>
   //
   // @param channel 内存缓冲频道
   // @return 代码
   //============================================================
   public synchronized String currentCode(FMemoryChannel channel){
      // 获得数据表代码
      String key = "mo-cache|logic.table|" + _name + "|code";
      String code = null;
      if(_setuped){
         code = channel.getAsString(key);
      }else{
         _setuped = true;
      }
      // 写入默认代码
      if(code == null){
         code = nextCode();
         if(channel != null){
            channel.set(key, code);
         }
      }
      return code;
   }

   //============================================================
   // <T>刷新处理。</T>
   //
   // @param channel 内存缓冲频道
   //============================================================
   public synchronized void flush(FMemoryChannel channel){
      // 生成主键
      String key = "mo-cache|logic.table|" + _name + "|code";
      // 更改内容
      String code = nextCode();
      channel.set(key, code);
   }
}
