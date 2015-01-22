package org.mo.data.logic.cache;

import org.mo.com.console.FConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FList;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>逻辑单元缓冲控制台。</T>
//============================================================
public class FLogicUnitCacheConsole
      extends FConsole
      implements
         ILogicUnitCacheConsole
{
   // 允许缓冲
   @AProperty
   protected boolean _enable;

   // 收集次数
   protected long _allocTotal;

   // 释放次数
   protected long _freeTotal;

   // 逻辑单元缓冲频道集合
   protected FList<FLogicUnitCacheChannel> _channels = new FList<FLogicUnitCacheChannel>();

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
   }

   //============================================================
   // <T>收集一个内存频道。</T>
   //
   // @return 内存频道
   //============================================================
   @Override
   public FLogicUnitCacheChannel alloc(){
      FLogicUnitCacheChannel channel = null;
      if(_enable){
         synchronized(_channels){
            if(_channels.isEmpty()){
               channel = new FLogicUnitCacheChannel(this);
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
   public void free(FLogicUnitCacheChannel channel){
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
