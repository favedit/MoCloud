package org.mo.eng.memorycache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.system.FObjectPool;
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

   // 内存频道集合
   protected FObjectPool<FMemoryChannel> _channels = new FObjectPool<FMemoryChannel>();

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      // 初始化服务器
      if(_enable){
         // 获得服务器列表
         String[] servers = RString.splitChars(_servers, ",;|");
         // 初始化服务器
         SockIOPool pool = SockIOPool.getInstance();
         pool.setServers(servers);
         pool.initialize();
         // 获得同步代码
         String guid = RUuid.simpleUuid();
         MemCachedClient client = new MemCachedClient();
         String identityCode = _code + EMemoryCacheConstant.IDENTITY_CODE;
         client.set(identityCode, guid);
         client.flushAll();
      }
   }

   //============================================================
   // <T>测试是否允许。</T>
   //
   // @return 是否允许
   //============================================================
   @Override
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
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   @Override
   public FMemoryChannel alloc(){
      FMemoryChannel channel = null;
      if(_enable){
         // 收集链接
         channel = _channels.alloc();
         // 创建链接
         if(channel == null){
            channel = new FMemoryChannel();
            channel.setConsole(this);
            channel.setup();
         }
         // 链接处理
         channel.connect();
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
         // 断开处理
         channel.disconnect();
         // 释放处理
         _channels.free(channel);
      }
   }
}
