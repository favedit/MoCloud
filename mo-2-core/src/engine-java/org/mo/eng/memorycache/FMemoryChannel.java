package org.mo.eng.memorycache;

import com.danga.MemCached.MemCachedClient;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RLong;

//============================================================
// <T>内存频道。</T>
//============================================================
public class FMemoryChannel
      extends FObject
      implements
         AutoCloseable
{
   // 控制台
   protected IMemoryCacheConsole _console;

   // 内存链接
   protected MemCachedClient _client;

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
   public IMemoryCacheConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @return 控制台
   //============================================================
   public void setConsole(IMemoryCacheConsole console){
      _console = console;
      _code = "[" + console.code() + "]";
   }

   //============================================================
   // <T>配置处理。</T>
   //============================================================
   public void setup(){
      _client = new MemCachedClient();
   }

   //============================================================
   // <T>获得内容。</T>
   //
   // @param key 主键
   // @return 内容
   //============================================================
   public Object get(String key){
      String cacheKey = _code + key;
      return _client.get(cacheKey);
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param key 主键
   // @param value 内容
   //============================================================
   public boolean set(String key,
                      Object value){
      String cacheKey = _code + key;
      boolean result = _client.set(cacheKey, value);
      return result;
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @param key 主键
   // @return 字符串
   //============================================================
   public String getAsString(String key){
      String cacheKey = _code + key;
      Object result = _client.get(cacheKey);
      return (String)result;
   }

   //============================================================
   // <T>设置字符串。</T>
   //
   // @param key 主键
   // @param value 内容
   //============================================================
   public boolean setString(String key,
                            String value){
      String cacheKey = _code + key;
      boolean result = _client.set(cacheKey, value);
      return result;
   }

   //============================================================
   // <T>获得超时字符串。</T>
   //
   // @param key 主键
   // @param timeout 超时时间
   // @return 字符串
   //============================================================
   public String getTimeoutString(String key){
      String cacheKey = _code + key;
      String value = (String)_client.get(cacheKey);
      if(value != null){
         int index = value.indexOf(":");
         if(index != -1){
            // 检查超时
            String timeString = value.substring(0, index);
            long time = RLong.parse(timeString, 0);
            if(time > 0){
               long currentTime = System.currentTimeMillis();
               if(currentTime > time){
                  _client.delete(cacheKey);
                  return null;
               }
            }
            value = value.substring(index + 1);
         }
      }
      return value;
   }

   //============================================================
   // <T>设置超时字符串。</T>
   //
   // @param key 主键
   // @param value 字符串
   // @param timeout 超时时间
   // @param value 内容
   //============================================================
   public boolean setTimeoutString(String key,
                                   String value,
                                   long timeout){
      String cacheKey = _code + key;
      long current = System.currentTimeMillis() + timeout;
      boolean result = _client.set(cacheKey, current + ":" + value);
      return result;
   }

   //============================================================
   // <T>删除主键。</T>
   //
   // @param key 主键
   // @return 处理结果
   //============================================================
   public boolean delete(String key){
      String cacheKey = _code + key;
      boolean result = _client.delete(cacheKey);
      return result;
   }

   //============================================================
   // <T>刷新处理。</T>
   //
   // @return 处理结果
   //============================================================
   public boolean flush(){
      boolean result = _client.flushAll();
      return result;
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close() throws Exception{
      _console.free(this);
   }
}
