package org.mo.eng.memorycache;

import com.danga.MemCached.SockIOPool;
import org.mo.com.lang.FList;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内存缓冲控制台。</T>
//============================================================
public class FMemoryCacheConsole
      implements
         IMemoryCacheConsole
{
   // 允许缓冲
   @AProperty
   protected boolean _enable;

   // 服务器地址
   @AProperty
   protected String _servers;

   // 标识
   @AProperty
   protected String _code = RString.EMPTY;

   // 收集次数
   protected long _allocTotal;

   // 释放次数
   protected long _freeTotal;

   // 内存频道集合
   protected FList<FMemoryChannel> _channels = new FList<FMemoryChannel>();

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      // 初始化服务器
      if(_enable){
         String[] servers = RString.split(_servers, ',');
         SockIOPool pool = SockIOPool.getInstance();
         pool.setServers(servers);
         pool.initialize();
      }
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
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   @Override
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   @Override
   public FMemoryChannel alloc(){
      FMemoryChannel channel = null;
      if(_enable){
         synchronized(_channels){
            if(_channels.isEmpty()){
               channel = new FMemoryChannel(this);
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
   public void free(FMemoryChannel channel){
      if(_enable){
         synchronized(_channels){
            _channels.push(channel);
            _freeTotal++;
         }
      }
   }
}
