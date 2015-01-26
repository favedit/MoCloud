package org.mo.data.logic.cache;

import java.util.UUID;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FList;
import org.mo.core.aop.face.AProperty;
import org.mo.eng.memorycache.FMemoryChannel;

//============================================================
// <T>逻辑单元缓冲控制台。</T>
//============================================================
public class FLogicCacheConsole
      extends FConsole
      implements
         ILogicCacheConsole
{
   // 允许缓冲
   @AProperty
   protected boolean _enable;

   // 收集次数
   protected long _allocTotal;

   // 释放次数
   protected long _freeTotal;

   // 设置过
   protected boolean _setuped;

   // 表格集合
   protected FDictionary<FLogicCacheTable> _tables = new FDictionary<FLogicCacheTable>(FLogicCacheTable.class);

   // 逻辑单元缓冲频道集合
   protected FList<FLogicCacheChannel> _channels = new FList<FLogicCacheChannel>();

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
   }

   //============================================================
   // <T>获得表格集合。</T>
   //
   // @return 内存频道
   //============================================================
   public FDictionary<FLogicCacheTable> tables(){
      return _tables;
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
   // <T>测试是否允许。</T>
   //
   // @return 是否允许
   //============================================================
   public boolean isEnable(){
      return _enable;
   }

   //============================================================
   // <T>获得当前代码。</T>
   //
   // @param channel 内存缓冲频道
   // @return 代码
   //============================================================
   @Override
   public synchronized String currentCode(FMemoryChannel channel){
      String key = "mo-cache|logic.connection|code";
      String code = null;
      if(_setuped){
         code = channel.getAsString(key);
      }else{
         _setuped = true;
      }
      // 写入默认代码
      if(code == null){
         code = nextCode();
         channel.set(key, code);
      }
      return code;
   }

   //============================================================
   // <T>刷新处理。</T>
   //
   // @param channel 内存缓冲频道
   //============================================================
   @Override
   public synchronized void flush(FMemoryChannel channel){
      // 生成主键
      String key = "mo-cache|logic.connection|code";
      // 更改内容
      String code = nextCode();
      channel.set(key, code);
   }

   //============================================================
   // <T>同步获得缓冲表格。</T>
   //
   // @return 缓冲表格
   //============================================================
   @Override
   public FLogicCacheTable syncTable(String name){
      FLogicCacheTable table = null;
      synchronized(_tables){
         table = _tables.find(name);
         if(table == null){
            table = new FLogicCacheTable();
            table.setName(name);
            table.setup();
            _tables.set(name, table);
         }
      }
      return table;
   }

   //============================================================
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   @Override
   public FLogicCacheChannel alloc(){
      FLogicCacheChannel channel = null;
      if(_enable){
         synchronized(_channels){
            if(_channels.isEmpty()){
               channel = new FLogicCacheChannel(this);
               channel.setup();
            }else{
               channel = _channels.pop();
            }
            _allocTotal++;
         }
      }
      return channel;
   }

   //============================================================
   // <T>释放一个内存频道。</T>
   //
   // @param channel 内存频道
   //============================================================
   @Override
   public void free(FLogicCacheChannel channel){
      if(_enable){
         if(channel == null){
            throw new FFatalError("Channel is null.");
         }
         // 清空处理
         channel.clear();
         // 回收处理
         synchronized(_channels){
            _channels.push(channel);
            _freeTotal++;
         }
      }
   }
}
