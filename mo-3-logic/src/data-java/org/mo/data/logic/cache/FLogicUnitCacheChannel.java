package org.mo.data.logic.cache;

import org.mo.com.collections.FRow;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;

//============================================================
// <T>逻辑单元缓冲频道。</T>
//============================================================
public class FLogicUnitCacheChannel
      extends FObject
{
   // 控制台
   protected ILogicUnitCacheConsole _console;

   // 单元集合
   protected FDictionary<FLogicUnitCache> _caches = new FDictionary<FLogicUnitCache>(FLogicUnitCache.class);

   //============================================================
   // <T>构造逻辑单元缓冲频道。</T>
   //============================================================
   public FLogicUnitCacheChannel(){
   }

   //============================================================
   // <T>构造逻辑单元缓冲频道。</T>
   //
   // @param console 控制台
   //============================================================
   public FLogicUnitCacheChannel(ILogicUnitCacheConsole console){
      _console = console;
   }

   //============================================================
   // <T>获得控制台。</T>
   //
   // @return 控制台
   //============================================================
   public ILogicUnitCacheConsole console(){
      return _console;
   }

   //============================================================
   // <T>设置控制台。</T>
   //
   // @return 控制台
   //============================================================
   public void setConsole(ILogicUnitCacheConsole console){
      _console = console;
   }

   //============================================================
   // <T>配置处理。</T>
   //============================================================
   public void setup(){
   }

   //============================================================
   // <T>根据名称查找缓冲器。</T>
   //
   // @param name 名称
   // @return 逻辑单元
   //============================================================
   public FLogicUnitCache findCache(String name){
      return _caches.find(name);
   }

   //============================================================
   // <T>根据名称和代码查找逻辑单元。</T>
   //
   // @param name 名称
   // @param code 代码
   // @return 逻辑单元
   //============================================================
   public FRow findUnit(String name,
                        long code){
      FRow row = null;
      FLogicUnitCache cache = _caches.find(name);
      if(cache != null){
         row = cache.get(code);
      }
      return row;
   }

   //============================================================
   // <T>根据名称同步缓冲器。</T>
   //
   // @param name 名称
   // @return 逻辑单元
   //============================================================
   public FLogicUnitCache syncCache(String name){
      FLogicUnitCache cache = _caches.find(name);
      if(cache == null){
         cache = new FLogicUnitCache();
         _caches.set(name, cache);
      }
      return cache;
   }

   //============================================================
   // <T>根据代码设置逻辑单元。</T>
   //
   // @param code 代码
   // @param unit 逻辑单元
   //============================================================
   public void set(String name,
                   long code,
                   FRow row){
      FLogicUnitCache cache = syncCache(name);
      cache.set(code, row);
   }

   //============================================================
   // <T>清除全部数据内容。</T>
   //============================================================
   public void clear(){
      int count = _caches.count();
      for(int n = 0; n < count; n++){
         FLogicUnitCache cache = _caches.value(n);
         cache.clear();
      }
      _caches.clear();
   }
}
