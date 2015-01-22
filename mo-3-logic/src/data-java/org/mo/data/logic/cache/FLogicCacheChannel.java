package org.mo.data.logic.cache;

import org.mo.com.collections.FRow;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;

//============================================================
// <T>逻辑单元缓冲频道。</T>
//============================================================
public class FLogicCacheChannel
      extends FObject
{
   // 控制台
   protected ILogicCacheConsole _console;

   // 单元集合
   protected FDictionary<FLogicCacheDataset> _caches = new FDictionary<FLogicCacheDataset>(FLogicCacheDataset.class);

   //============================================================
   // <T>构造逻辑单元缓冲频道。</T>
   //============================================================
   public FLogicCacheChannel(){
   }

   //============================================================
   // <T>构造逻辑单元缓冲频道。</T>
   //
   // @param console 控制台
   //============================================================
   public FLogicCacheChannel(ILogicCacheConsole console){
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
   public FLogicCacheDataset findCache(String name){
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
      FLogicCacheDataset cache = _caches.find(name);
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
   public FLogicCacheDataset syncCache(String name){
      FLogicCacheDataset cache = _caches.find(name);
      if(cache == null){
         cache = new FLogicCacheDataset();
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
      FLogicCacheDataset cache = syncCache(name);
      cache.set(code, row);
   }

   //============================================================
   // <T>清除全部数据内容。</T>
   //============================================================
   public void clear(){
      int count = _caches.count();
      for(int n = 0; n < count; n++){
         FLogicCacheDataset cache = _caches.value(n);
         cache.clear();
      }
      _caches.clear();
   }
}
