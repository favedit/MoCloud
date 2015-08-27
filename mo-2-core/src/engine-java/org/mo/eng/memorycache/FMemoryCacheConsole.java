package org.mo.eng.memorycache;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.system.FObjectPool;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>内存缓冲控制台。</T>
//============================================================
public class FMemoryCacheConsole
      implements
         IMemoryCacheConsole
{
   // 日志输出接口 
   private static ILogger _logger = RLogger.find(FMemoryCacheConsole.class);

   // 允许缓冲
   @AProperty
   protected boolean _enable;

   // 服务器地址
   @AProperty
   protected String _servers;

   // 标识
   @AProperty
   protected String _code = RString.EMPTY;

   // 构建器
   private XMemcachedClientBuilder _builder;

   // 内存频道集合
   protected FObjectPool<FMemoryChannel> _channels = new FObjectPool<FMemoryChannel>();

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
   // <T>获得构建器。</T>
   //============================================================
   public XMemcachedClientBuilder builder(){
      return _builder;
   }

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      // 初始化服务器
      if(_enable){
         try{
            // 获得服务器列表
            List<InetSocketAddress> addresses = new ArrayList<InetSocketAddress>();
            String[] servers = RString.splitChars(_servers, ",;|");
            for(String serverCode : servers){
               if(!RString.isEmpty(serverCode)){
                  String[] serverItems = RString.split(serverCode, ':');
                  InetSocketAddress address = new InetSocketAddress(serverItems[0], RInteger.parse(serverItems[1]));
                  addresses.add(address);
               }
            }
            if(addresses.isEmpty()){
               throw new FFatalError("Address is empty.");
            }
            // 创建链接
            _builder = new XMemcachedClientBuilder(addresses);
            XMemcachedClient client = (XMemcachedClient)_builder.build();
            // 打印信息
            Map<InetSocketAddress, String> versions = client.getVersions();
            Map<InetSocketAddress, Map<String, String>> statuses = client.getStats();
            for(InetSocketAddress address : versions.keySet()){
               String version = versions.get(address);
               Map<String, String> properties = statuses.get(address);
               _logger.debug(this, "initialize", "Memcache status. (address={1}, version={2})", address, version);
               for(String name : properties.keySet()){
                  String value = properties.get(name);
                  _logger.debug(this, "initialize", " - {1} = {2}", name, value);
               }
            }
            // 获得同步代码
            String guid = RUuid.simpleUuid();
            String identityCode = _code + EMemoryCacheConstant.IDENTITY_CODE;
            boolean result = client.set(identityCode, 0, guid);
            if(!result){
               throw new FFatalError("Write code failure.");
            }
         }catch(Exception exception){
            throw new FFatalError(exception);
         }
      }
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
