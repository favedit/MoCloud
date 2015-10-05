package org.mo.eng.memorycache;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>内存频道。</T>
//============================================================
public class FMemoryChannel
      extends FObject
      implements
         AutoCloseable
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMemoryChannel.class);

   // 控制台
   protected FMemoryCacheConsole _console;

   // 内存链接
   protected XMemcachedClient _client;

   // 代码
   protected String _code;

   //============================================================
   // <T>构造内存频道。</T>
   //============================================================
   public FMemoryChannel(){
   }

   //============================================================
   // <T>获得控制台。</T>
   //
   // @return 控制台
   //============================================================
   public FMemoryCacheConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @return 控制台
   //============================================================
   public void setConsole(FMemoryCacheConsole console){
      _console = console;
   }

   //============================================================
   // <T>获得句柄。</T>
   //
   // @return 句柄
   //============================================================
   public XMemcachedClient handle(){
      return _client;
   }

   //============================================================
   // <T>配置处理。</T>
   //============================================================
   public void setup(){
      XMemcachedClientBuilder builder = _console.handle();
      try{
         _client = (XMemcachedClient)builder.build();
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>链接处理。</T>
   //============================================================
   public void connect(){
      try{
         String identityCode = _console.code() + EMemoryCacheConstant.IDENTITY_CODE;
         String guid = (String)_client.get(identityCode);
         _code = _console.code() + "(" + guid + ")|";
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>获得内容。</T>
   //
   // @param key 主键
   // @return 内容
   //============================================================
   public Object get(String key){
      Object value = null;
      try{
         String cacheKey = _code + key;
         value = _client.get(cacheKey);
         if(value != null){
            _logger.debug(this, "get", "Find memory cache. [code={1}, value={2}]", cacheKey, RClass.dump(value));
         }
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return value;
   }

   //============================================================
   // <T>获得内容。</T>
   //
   // @param key 主键
   // @return 内容
   //============================================================
   public byte[] getBytes(String key){
      byte[] value = null;
      try{
         String cacheKey = _code + key;
         value = (byte[])_client.get(cacheKey);
         if(value != null){
            _logger.debug(this, "getBytes", "Find memory cache. [code={1}, value_length={2}]", cacheKey, value.length);
         }
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return value;
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @param key 主键
   // @return 字符串
   //============================================================
   public String getString(String key){
      String value = null;
      try{
         String cacheKey = _code + key;
         value = (String)_client.get(cacheKey);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return value;
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param key 主键
   // @param value 内容
   //============================================================
   public boolean set(String key,
                      Object value){
      boolean result = false;
      try{
         String cacheKey = _code + key;
         result = _client.set(cacheKey, 0, value);
         if(result){
            _logger.debug(this, "set", "Update memory cache success. [code={1}, value={2}]", cacheKey, RClass.dump(value));
         }else{
            _logger.debug(this, "set", "Update memory cache failure. [code={1}, value={2}]", cacheKey, RClass.dump(value));
         }
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return result;
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param key 主键
   // @param value 内容
   //============================================================
   public boolean setBytes(String key,
                           byte[] value){
      boolean result = false;
      if(value != null){
         try{
            String cacheKey = _code + key;
            result = _client.set(cacheKey, 0, value);
            if(result){
               _logger.debug(this, "setBytes", "Update memory cache success. [code={1}, value_length={2}]", cacheKey, value.length);
            }else{
               _logger.debug(this, "setBytes", "Update memory cache failure. [code={1}, value_length={2}]", cacheKey, value.length);
            }
         }catch(Exception exception){
            throw new FFatalError(exception);
         }
      }
      return result;
   }

   //============================================================
   // <T>设置字符串。</T>
   //
   // @param key 主键
   // @param value 内容
   //============================================================
   public boolean setString(String key,
                            String value){
      boolean result = false;
      try{
         String cacheKey = _code + key;
         result = _client.set(cacheKey, 0, value);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return result;
   }

   //============================================================
   // <T>设置超时字符串。</T>
   //
   // @param key 主键
   // @param value 字符串
   // @param expiry 期限[秒]
   // @param value 内容
   //============================================================
   public boolean setString(String key,
                            String value,
                            int expiry){
      boolean result = false;
      try{
         String cacheKey = _code + key;
         result = _client.set(cacheKey, expiry, value);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return result;
   }

   //============================================================
   // <T>删除主键。</T>
   //
   // @param key 主键
   // @return 处理结果
   //============================================================
   public boolean delete(String key){
      boolean result = false;
      try{
         String cacheKey = _code + key;
         result = _client.delete(cacheKey);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
      return result;
   }

   //============================================================
   // <T>刷新处理。</T>
   //
   // @return 处理结果
   //============================================================
   public void flush(){
      try{
         _client.flushAll();
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close() throws Exception{
      _console.free(this);
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   public void release(){
      try{
         _client.shutdown();
      }catch(Exception exception){
         _logger.error(this, "disconnect", exception);
      }
   }
}
